


package Decision_tree_validation;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Effort_data_comparison {

    // === CONFIG ===
    private static final String BASE_URL = "https://pbl.3-cubed.com/";
    private static final String WELCOME_URL = "https://pbl.3-cubed.com/Projects/Welcome";
    private static final String DECISION_TREE_URL = "https://pbl.3-cubed.com/Projects/DecisionTree?Pid=3925";
    private static final String REWORK_URL = "https://pbl.3-cubed.com/Operations/ReworkReduction";
    private static final boolean APPEND_LOG = false; // false = overwrite each run

    @Test
    public void data_validation() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try (FileWriter fw = new FileWriter("Comparison_Result.txt", APPEND_LOG)) {

            // ---------- Start log header ----------
            fw.write("=== Run at: " + LocalDateTime.now() + " ===\n");

            // ---------- Login ----------
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(BASE_URL);

            driver.findElement(By.id("UName")).sendKeys("Rama krishna");
            driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
            driver.findElement(By.name("Logon")).click();

            String current = driver.getCurrentUrl();
            if (WELCOME_URL.equals(current)) {
                fw.write("Login: Success\n");
            } else if (BASE_URL.concat("Account/LogOn").equals(current)) {
                // retry (site sometimes bounces)
                driver.findElement(By.xpath("//button[text()='Log Out']")).click();
                driver.findElement(By.id("UName")).sendKeys("Rama krishna");
                driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
                driver.findElement(By.name("Logon")).click();
                fw.write("Login: Retried\n");
            } else {
                fw.write("Login: Current URL after login = " + current + "\n");
            }

            // ---------- Go to Decision Tree ----------
            driver.navigate().to(DECISION_TREE_URL);

            // Decision Tree Effort node text (id 104)
            WebElement nodeEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("104")));
            String nodeRaw = nodeEl.getText();
            fw.write("\n[Decision Tree] Raw Node Text: " + safe(nodeRaw) + "\n");

            // open the node to ensure page fully loads (mirrors your flow)
            nodeEl.click();

            // set page number (kept from your script; harmless if not needed)
            WebElement pageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("((//input[@class='form-control'])[11])")));
            pageInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            pageInput.sendKeys("99");
            new Actions(driver).sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            // ---------- Get Widget text on Decision Tree page ----------
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,2000)");
            String widgetRaw = textOrEmpty(wait, By.xpath("//a[@href='/Operations/ReworkReduction']"));
            fw.write("[Decision Tree] Widget Link Raw Text: " + safe(widgetRaw) + "\n");

            // ---------- Go to Rework & Rejection page ----------
            driver.navigate().to(REWORK_URL);

            // Two H4s (as in your code): [1]=Total Effort, [2]=Total Rework Effort
            String totalEffortRaw = textOrEmpty(wait, By.xpath("((//div[@id='myModalAddConnectivity']/following::h4[@class='text-center'])[1])"));
            String totalReworkRaw = textOrEmpty(wait, By.xpath("((//div[@id='myModalAddConnectivity']/following::h4[@class='text-center'])[2])"));

            fw.write("[Rework Page] Total Effort Raw: " + safe(totalEffortRaw) + "\n");
            fw.write("[Rework Page] Total Rework Effort Raw: " + safe(totalReworkRaw) + "\n\n");

            // ---------- Sanitize up to '|' then extract numbers ----------
            String nodeSan = takeBeforePipe(nodeRaw);
            String totEffSan = takeBeforePipe(totalEffortRaw);
            String widgetSan = takeBeforePipe(widgetRaw);
            String totRewSan = takeBeforePipe(totalReworkRaw);

            fw.write("Sanitized (before '|'):\n");
            fw.write("  Decision Node: " + safe(nodeSan) + "\n");
            fw.write("  Total Effort : " + safe(totEffSan) + "\n");
            fw.write("  Widget Text  : " + safe(widgetSan) + "\n");
            fw.write("  Total Rework : " + safe(totRewSan) + "\n\n");

            // Extract first number (supports 1,234.56 and 1234.56 and 1234)
            Extracted eNode = extractFirstNumber(nodeSan);
            Extracted eTotEff = extractFirstNumber(totEffSan);
            Extracted eWidget = extractFirstNumber(widgetSan);
            Extracted eTotRew = extractFirstNumber(totRewSan);

            fw.write("Parsed Numbers:\n");
            fw.write("  Decision Node: " + eNode.toLog() + "\n");
            fw.write("  Total Effort : " + eTotEff.toLog() + "\n");
            fw.write("  Widget Text  : " + eWidget.toLog() + "\n");
            fw.write("  Total Rework : " + eTotRew.toLog() + "\n\n");

            // ---------- Integer comparisons (ignore decimals) ----------
            fw.write("Comparisons (INTEGER ONLY, decimals ignored):\n");

            if (eNode.found && eTotEff.found) {
                if (eNode.intPart == eTotEff.intPart) {
                    fw.write("✅ Decision Tree Effort (" + eNode.intPart + ") MATCHES Total Effort (" + eTotEff.intPart + ")\n");
                } else {
                    fw.write("❌ Decision Tree Effort (" + eNode.intPart + ") DOES NOT MATCH Total Effort (" + eTotEff.intPart + ")\n");
                }
            } else {
                fw.write("⚠️ Could not compare Decision Tree vs Total Effort (number missing)\n");
            }

            if (eWidget.found && eTotRew.found) {
                if (eWidget.intPart == eTotRew.intPart) {
                    fw.write("✅ Rework & Rejection Text (" + eWidget.intPart + ") MATCHES Total Rework Effort (" + eTotRew.intPart + ")\n");
                } else {
                    fw.write("❌ Rework & Rejection Text (" + eWidget.intPart + ") DOES NOT MATCH Total Rework Effort (" + eTotRew.intPart + ")\n");
                }
            } else {
                fw.write("⚠️ Could not compare Widget vs Total Rework Effort (number missing)\n");
            }

            fw.write("========================================\n");
            fw.flush();

            System.out.println("✅ Wrote results to Comparison_Result.txt");

        } catch (Exception ex) {
            // If anything goes wrong, try to at least surface it
            try (FileWriter fw2 = new FileWriter("Comparison_Result.txt", true)) {
                fw2.write("\n[ERROR] " + ex.getClass().getSimpleName() + ": " + ex.getMessage() + "\n");
                fw2.write("========================================\n");
                fw2.flush();
            }
            throw ex;
        } finally {
            driver.quit();
        }
    }

    // ----- Helpers -----

    private static String textOrEmpty(WebDriverWait wait, By by) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return el.getText() == null ? "" : el.getText().trim();
    }

    private static String takeBeforePipe(String s) {
        if (s == null) return "";
        String part = s.split("\\|", 2)[0]; // keep only before first '|'
        return part.trim();
    }

    private static String safe(String s) {
        return s == null ? "(null)" : s.replace("\n", " ").trim();
    }

    // Structure holding parsed number information
    private static class Extracted {
        boolean found;
        String rawNumber;   // e.g., "529.64"
        int intPart;        // e.g., 529

        Extracted(boolean found, String raw, int intPart) {
            this.found = found;
            this.rawNumber = raw;
            this.intPart = intPart;
        }

        String toLog() {
            if (!found) return "NOT FOUND";
            return "raw=" + rawNumber + " | int=" + intPart;
        }
    }

    // Finds the FIRST number in the string (handles 1,234.56 / 1234.56 / 1234)
    private static Extracted extractFirstNumber(String s) {
        if (s == null) return new Extracted(false, "", 0);
        // number with optional thousands separators and optional decimals
        Pattern p = Pattern.compile("(\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.(\\d+))?");
        Matcher m = p.matcher(s);
        if (!m.find()) {
            return new Extracted(false, "", 0);
        }
        String whole = m.group(1).replace(",", "");
        String dec = m.group(2); // may be null
        String raw = dec == null ? whole : (whole + "." + dec);
        int intOnly = Integer.parseInt(whole); // ignore decimals
        return new Extracted(true, raw, intOnly);
    }
}






//	System.out.println("✅ Wrote results to Comparison_Result.txt");
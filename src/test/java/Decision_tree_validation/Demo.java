package Decision_tree_validation;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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

public class Demo {

    @Test
    public void data_validation() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        FileWriter fw = null;

        try {
            fw = new FileWriter("Comparison_Result.txt", false); // overwrite each run
            DecimalFormat df = new DecimalFormat("0.00");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            fw.write("=== Run at: " + LocalDateTime.now() + " ===\n");

            // ------------------------
            // ======= ORIGINAL LOGIN (UNCHANGED) ==========
            // ------------------------
            driver.get("https://pbl.3-cubed.com/");
            String A = "https://pbl.3-cubed.com/";
            String WelcomePage = "https://pbl.3-cubed.com/Projects/Welcome";

            driver.get(A);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Login
            driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
            driver.findElement(By.xpath("//button[@name='Logon']")).click();

            String AA = driver.getCurrentUrl();
            if (AA.equals(WelcomePage)) {
                System.out.println("Login Success");
                fw.write("Login Success\n");
            }

            if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) {
                driver.findElement(By.xpath("//button[text()='Log Out']")).click();
                driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
                driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
                driver.findElement(By.xpath("//button[@name='Logon']")).click();
                fw.write("Login retried after LogOn bounce\n");
            }

            // ------------------------
            // Navigate to DecisionTree and open node (your original flow)
            // ------------------------
            driver.navigate().to("https://pbl.3-cubed.com/Projects/DecisionTree?Pid=3925");

            WebElement nodeEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']")));
            String decisionNodeText = nodeEl.getText();
            fw.write("[Decision Node] Raw: " + safe(decisionNodeText) + "\n");

            // click decision node
            nodeEl.click();

            // clear & enter page number (your original flow)
            WebElement page_number = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("((//input[@class='form-control'])[11])")));
            page_number.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            Thread.sleep(1000);
            page_number.sendKeys("99");
            new Actions(driver).sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            // ------------------------
            // Sum column 6 values robustly (extract first number per cell)
            // ------------------------
            List<WebElement> rows = driver.findElements(
                    By.xpath("//table[@class='table table-bordered table-condensed activities dataTable']//tbody//tr//td[6]"));

            double totalSum = 0.0;
            int parsedRows = 0;
            for (WebElement r : rows) {
                String cell = r.getText();
                double v = extractFirstDouble(cell);
                if (!Double.isNaN(v)) {
                    totalSum += v;
                    parsedRows++;
                }
            }

            fw.write("Rows found (col6): " + rows.size() + " | Numeric parsed: " + parsedRows + "\n");
            fw.write("Sum of Column 6 (raw double): " + df.format(totalSum) + "\n");
            int totalSumInt = (int) totalSum; // integer part only, decimals ignored
            fw.write("Sum of Column 6 (integer used for comparison): " + totalSumInt + "\n\n");

            // ------------------------
            // Go to ReworkReduction page and fetch Rework & Rejection text (Total Rework Effort)
            // ------------------------
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,2000)");
            driver.navigate().to("https://pbl.3-cubed.com/Operations/ReworkReduction");

            String totalReworkRaw = "";
            try {
                totalReworkRaw = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("((//div[@id='myModalAddConnectivity']/following::h4[@class='text-center'])[2])"))).getText();
            } catch (Exception e) {
                // element not found — leave empty
                totalReworkRaw = "";
            }

            fw.write("[Rework Page] Total Rework Effort (raw): " + safe(totalReworkRaw) + "\n");

            // sanitize before '|' and parse
            String reworkBeforePipe = takeBeforePipe(totalReworkRaw);
            fw.write("Total Rework Effort (before '|'): " + safe(reworkBeforePipe) + "\n");

            Extracted reworkExtract = extractFirstNumberDetails(reworkBeforePipe);
            if (!reworkExtract.found) {
                fw.write("ERROR: Could not find numeric value in Total Rework Effort. Aborting comparison.\n");
                fw.write("========================================\n");
                fw.flush();
                System.out.println("No numeric value found in Rework & Rejection text — check locator / page.");
                return;
            }

            fw.write("Parsed Rework number: raw=" + reworkExtract.rawNumber + " | int=" + reworkExtract.intPart + "\n\n");

            // ------------------------
            // FINAL COMPARISON: sum of column6 (integer) vs rework int (ignore decimals)
            // ------------------------
            fw.write("Comparison (INTEGER parts only, decimals ignored):\n");
            if (totalSumInt == reworkExtract.intPart) {
                fw.write("✅ Sum(Column6) (" + totalSumInt + ") MATCHES Rework & Rejection (" + reworkExtract.intPart
                        + ")\n");
            } else {
                fw.write("❌ Sum(Column6) (" + totalSumInt + ") DOES NOT MATCH Rework & Rejection ("
                        + reworkExtract.intPart + ")\n");
            }

            fw.write("========================================\n");
            fw.flush();

            System.out.println("✅ Comparison results written to Comparison_Result.txt");

        } catch (Exception ex) {
            // log exception to file if possible
            if (fw != null) {
                try {
                    fw.write("\n[ERROR] " + ex.getClass().getSimpleName() + ": " + ex.getMessage() + "\n");
                    fw.write("========================================\n");
                    fw.flush();
                } catch (IOException ioe) {
                    // ignore
                }
            }
            throw ex;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            try {
                driver.quit();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    // ----------------- Helpers -----------------

    // get text before '|' char (if present), trimmed
    private static String takeBeforePipe(String s) {
        if (s == null) return "";
        return s.split("\\|", 2)[0].trim();
    }

    private static String safe(String s) {
        return s == null ? "(null)" : s.replace("\n", " ").trim();
    }

    // Return first number as double from string, or NaN if none found
    // Handles values like "1,234.56", "1234.56", "529.64 hrs"
    private static double extractFirstDouble(String s) {
        if (s == null || s.trim().isEmpty()) return Double.NaN;
        Pattern p = Pattern.compile("(\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.(\\d+))?");
        Matcher m = p.matcher(s);
        if (!m.find()) return Double.NaN;
        String whole = m.group(1).replace(",", "");
        String dec = m.group(2);
        String raw = dec == null ? whole : (whole + "." + dec);
        try {
            return Double.parseDouble(raw);
        } catch (NumberFormatException ex) {
            return Double.NaN;
        }
    }

    // small struct to return parsed number details
    private static class Extracted {
        boolean found;
        String rawNumber; // e.g. "132.59"
        int intPart;      // e.g. 132

        Extracted(boolean found, String raw, int intPart) {
            this.found = found;
            this.rawNumber = raw;
            this.intPart = intPart;
        }
    }

    // Extracts first number and returns integer part (ignore decimals)
    private static Extracted extractFirstNumberDetails(String s) {
        if (s == null || s.trim().isEmpty()) return new Extracted(false, "", 0);
        Pattern p = Pattern.compile("(\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.(\\d+))?");
        Matcher m = p.matcher(s);
        if (!m.find()) return new Extracted(false, "", 0);
        String whole = m.group(1).replace(",", "");
        String dec = m.group(2);
        String raw = dec == null ? whole : (whole + "." + dec);
        int intPart;
        try {
            intPart = Integer.parseInt(whole);
        } catch (NumberFormatException ex) {
            return new Extracted(false, raw, 0);
        }
        return new Extracted(true, raw, intPart);
    }
}


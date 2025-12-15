package Decision_tree_validation;

import java.text.DecimalFormat;
import java.time.Duration;
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

public class Benefit_calculations_decision_tree 
{

    @Test
    public void data_validation() throws InterruptedException
    {
    	
        WebDriver driver = new ChromeDriver();

        driver.get("https://pbl.3-cubed.com/");
        String WelcomePage = "https://pbl.3-cubed.com/Projects/Welcome";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login
        driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
        driver.findElement(By.xpath("//button[@name='Logon']")).click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(WelcomePage))
        {
            System.out.println("Login Success");
        }

        if (currentUrl.equals("https://pbl.3-cubed.com/Account/LogOn")) 
        {
            driver.findElement(By.xpath("//button[text()='Log Out']")).click();
            driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
            driver.findElement(By.xpath("//button[@name='Logon']")).click();
        }

        // Navigate to decision tree
        driver.navigate().to("https://pbl.3-cubed.com/Projects/DecisionTree?Pid=3925");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String node = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
        System.out.println("Decision Tree Node Text: " + node);

        driver.findElement(By.xpath("//a[@id='104']")).click();

        // Clear & enter page number
        WebElement page_number = driver.findElement(By.xpath("((//input[@class='form-control'])[11])"));
        page_number.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        Thread.sleep(2000);

        page_number.sendKeys("99");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(4000);

        // Fetch all row values from column 6
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@class='table table-bordered table-condensed activities dataTable']//tbody//tr//td[6]"));

        double total = 0.0;
        DecimalFormat df = new DecimalFormat("0.00");

        for (WebElement row : rows) 
        {
            String text = row.getText().trim();
            if (!text.isEmpty()) 
            {
                try {
                    text = text.replaceAll("[^0-9.]", "");
                    if (!text.isEmpty()) 
                    {
                        double value = Double.parseDouble(text);
                        total += value;
                        System.out.println("Row value: " + df.format(value));
                    }
                } catch (NumberFormatException e)
                {
                    System.out.println("Skipping non-numeric value: " + text);
                }
            }
        }

        System.out.println("==================================");
        System.out.println("✅ Total sum of column 6 = " + df.format(total));

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");

        String print_widget_text = driver.findElement(By.xpath("//a[@href='/Operations/ReworkReduction']")).getText();
        System.out.println("Widget Text: " + print_widget_text);

        driver.navigate().to("https://pbl.3-cubed.com/Operations/ReworkReduction");

        // Get Decision Tree Effort
        String get_effort = driver.findElement(
                By.xpath("((//div[@id='myModalAddConnectivity']/following::h4[@class='text-center'])[1])")).getText();
        int decisionTreeEffort = Integer.parseInt(get_effort.replaceAll("[^0-9]", ""));
        System.out.println("Decision Tree Effort = " + decisionTreeEffort);

        // Get Total Rework Effort
        String total_rework_effort = driver.findElement(
                By.xpath("((//div[@id='myModalAddConnectivity']/following::h4[@class='text-center'])[2])")).getText();
        int reworkEffort = Integer.parseInt(total_rework_effort.replaceAll("[^0-9]", ""));
        System.out.println("Rework Reduction Effort = " + reworkEffort);

        // ✅ NEW LOGIC: Calculate percentage
        double percentage = ((double) reworkEffort / decisionTreeEffort) * 100;
        int approxPercent = (int) Math.round(percentage);

        // ✅ Extract Widget Percentage: take only part after "hrs" and ignore spaces
        String normalizedText = print_widget_text.replaceAll("\\s+", " ").trim();
        String afterHrs = "";
        int hrsIndex = normalizedText.toLowerCase().indexOf("hrs");
        if (hrsIndex != -1) 
        {
            afterHrs = normalizedText.substring(hrsIndex + 3).trim();
        }

        Pattern percentPattern = Pattern.compile("(\\d+)%");
        Matcher matcher = percentPattern.matcher(afterHrs);

        int widgetPercent = 0;
        if (matcher.find()) 
        {
            widgetPercent = Integer.parseInt(matcher.group(1));
        }

        System.out.println("==================================");
        System.out.println("Calculated Percentage = " + df.format(percentage) + "%");
        System.out.println("Widget Percentage = " + widgetPercent + "%");

        if (approxPercent == widgetPercent) {
            System.out.println("✅ Percentage (" + approxPercent + "%) MATCHES Widget Percentage (" + widgetPercent + "%)");
        } else {
            System.out.println("❌ Percentage (" + approxPercent + "%) does NOT match Widget Percentage (" + widgetPercent + "%)");
        }

        driver.quit();
    }
}

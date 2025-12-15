package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Baseclass {

    public static WebDriver driver;
    public static ResourceBundle rb;
    public static Logger log;

    // OPEN BROWSER BEFORE SUITE
    @BeforeSuite
    public void openURL() {
        rb = ResourceBundle.getBundle("config");
        log = LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.get("https://pbl.3-cubed.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // CLOSE BROWSER AFTER SUITE
    @AfterSuite
    public void closeTheUrl() {
        if (driver != null) {
            driver.quit();
        }
    }

    // TAKE SCREENSHOT
    public String screenshot(String tname) throws IOException {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir") + "\\ScreenShot\\" + timestamp + "_" + tname + "_img.png";

        try {
            FileUtils.copyFile(source, new File(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dest;
    }
}

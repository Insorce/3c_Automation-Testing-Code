package Decision_tree_validation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Decision_tree_validation 
{




	@Test
	public void Decision_tree_validation()  throws InterruptedException, FileNotFoundException
	{


		WebDriver driver= new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/");
		String A="https://pbl.3-cubed.com/";	


		String WelcomePage="https://pbl.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//enter username
		driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		//enter password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver.findElement(By.xpath("//button[@name='Logon']")).click();
		String AA=driver.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://pbl.3-cubed.com/Account/LogOn"))
		{
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
			//enter password
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@name='Logon']")).click();

		}
		// log out code is completed here



		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);


		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3925: Diagnostic agent testing 1064_Claims Processing with Wizard']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);


		
		// === 1. Go to Decision Tree and get node text ===
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		WebElement decisionNode = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']")));
		decisionNode.click();
		String decisionTreeValue = decisionNode.getText();
		System.out.println("Decision Tree Value: " + decisionTreeValue);

		// === Effort stage gate FTE ===
		driver.navigate().to("https://pbl.3-cubed.com/Validation/EffortPeriodic");
		String effortNodeValue = driver.findElement(By.xpath("//a[@id='104']")).getText();
		System.out.println("Effort Node Value: " + effortNodeValue);

		// === Controls ===
		driver.navigate().to("https://pbl.3-cubed.com/Validation/Controls");
		String controlsNodeValue = driver.findElement(By.xpath("//a[@id='104']")).getText();
		System.out.println("Controls Node Value: " + controlsNodeValue);

		// === 2. Go to Model Insight and get node text ===
		driver.navigate().to("https://pbl.3-cubed.com/Validation/Controls?screen=modalval");
		WebElement modelInsightNode = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']")));
		modelInsightNode.click();
		String modelInsightValue = modelInsightNode.getText();
		System.out.println("Model Insight Value: " + modelInsightValue);

		// === 2.5 Geolocate Team Size - calculate Effort & FTE ===
		driver.navigate().to("https://pbl.3-cubed.com/Process/GeolocateTeamSize");

		// --- Effort calculation ---
		List<WebElement> effortList = driver.findElements(By.xpath("//div[@id='TmSize']//td[2]"));
		double totalEffort = 0.0;
		for (int e = 1; e <= effortList.size(); e++) {
		    String effortText = driver.findElement(By.xpath("(//div[@id='TmSize']//td[2])[" + e + "]")).getText();
		    String numeric = effortText.replaceAll("[^0-9.]", "");
		    if (!numeric.isEmpty()) {
		        totalEffort += Double.parseDouble(numeric);
		    }
		}
		System.out.println("✅ Total Effort Sum (raw) = " + totalEffort);

		// --- FTE calculation ---
		List<WebElement> fteList = driver.findElements(By.xpath("//div[@id='TmSize']//td[6]"));
		double totalFTE = 0.0;
		for (int f = 1; f <= fteList.size(); f++) {
		    String fteText = driver.findElement(By.xpath("(//div[@id='TmSize']//td[6])[" + f + "]")).getText();
		    String numeric = fteText.replaceAll("[^0-9.]", "");
		    if (!numeric.isEmpty()) {
		        totalFTE += Double.parseDouble(numeric);
		    }
		}
		System.out.println("✅ Total FTE Sum (raw) = " + totalFTE);

		// === Truncate decimals ===
		long effortInt = (long) totalEffort;
		long fteInt = (long) totalFTE;

		// === Build concatenated string ===
		String dynamicValue = "Effort\n" + effortInt + " hrs | " + fteInt + " FTE";
		System.out.println("✅ Concatenated Value = " + dynamicValue);

		// === 3. Compare all values (ignoring decimals) ===
		String dTreeClean    = decisionTreeValue.replaceAll("\\.\\d+", "");
		String effortClean   = effortNodeValue.replaceAll("\\.\\d+", "");
		String controlsClean = controlsNodeValue.replaceAll("\\.\\d+", "");
		String modelClean    = modelInsightValue.replaceAll("\\.\\d+", "");
		String dynamicClean  = dynamicValue.replaceAll("\\.\\d+", "");

		// ✅ All values should match
		boolean allMatch = dTreeClean.equals(effortClean)
		                && effortClean.equals(controlsClean)
		                && controlsClean.equals(modelClean)
		                && modelClean.equals(dynamicClean);

		if (allMatch) {
		    System.out.println("✅ PASSED: All values matched (ignoring decimals)");
		} else {
		    System.out.println("❌ FAILED: Values did not match (ignoring decimals)");
		}

		// === 4. Assertion ===
		Assert.assertTrue(allMatch,
		        "FAIL : Decision Tree / Effort / Controls / Model Insight / Dynamic values mismatch!");

		// === 5. Log results ===
		try (PrintStream log = new PrintStream(new FileOutputStream("Log.txt", true))) {
		    log.println("===== Decision Tree Validation =====");
		    log.println("Decision Tree Value : " + decisionTreeValue);
		    log.println("Effort Node Value   : " + effortNodeValue);
		    log.println("Controls Node Value : " + controlsNodeValue);
		    log.println("Model Insight Value : " + modelInsightValue);
		    log.println("Dynamic Value       : " + dynamicValue);
		    log.println("Total Effort Raw    : " + totalEffort);
		    log.println("Total Effort Int    : " + effortInt);
		    log.println("Total FTE Raw       : " + totalFTE);
		    log.println("Total FTE Int       : " + fteInt);

		    if (allMatch) {
		        log.println("Result              : ✅ MATCHED (ignoring decimals)");
		    } else {
		        log.println("Result              : ❌ NOT MATCHED (ignoring decimals)");
		    }
		    log.println("====================================\n");
		}

		
		
		


	}
}
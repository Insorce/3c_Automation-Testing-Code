package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class periodic_activities extends Baseclass 
{

	@Test
	public void products() throws InterruptedException
	{
	
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://prod.3-cubed.com/");
		String A="https://prod.3-cubed.com/";	


		String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		//enter password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver.findElement(By.xpath("//button[@name='Logon']")).click();
		String AA=driver.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://prod.3-cubed.com/Account/LogOn"))
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"5349: zip--test\"]")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);


		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


		Thread.sleep(3000);

		driver.navigate().to("http://prod.3-cubed.com/Process/PeriodicActivities");

		
		//click on periodic activites
		
////		//Do you have periodic activites to set
//	    Thread.sleep(3000);
//		WebElement periodic_activites=driver.findElement(By.xpath("//button[@id='alertify-cancel']"));
//		JavascriptExecutor set_activites = (JavascriptExecutor)driver;
//		set_activites.executeScript("arguments[0].click();", periodic_activites);
//		
		//click on improve
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='obs-tab']")).click();


//		//click on gen ai
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@id='genai-tab']")).click();

		//click on observations
		WebElement review_tab=driver.findElement(By.xpath("//a[@id='review-tab']"));
		JavascriptExecutor tab = (JavascriptExecutor)driver;
		tab.executeScript("arguments[0].click();", review_tab);
		
	

		
	
	
	}
	
}

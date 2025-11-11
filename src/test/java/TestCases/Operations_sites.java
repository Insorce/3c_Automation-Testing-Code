package TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Operations_sites 
{

	
	@Test(invocationCount=1)
	public static void opeartion_sites(WebDriver driver2) throws InterruptedException
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3848: peakutilization__values__checking']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);


		
		driver.navigate().to("https://pbl.3-cubed.com/Infra/OperationSites");
		
		
		//click on the three lines
		WebElement three_lines=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		JavascriptExecutor just_click = (JavascriptExecutor) driver;                            
		just_click.executeScript("arguments[0].click();", three_lines);
		
		
		
		//click on close window
		WebElement close_window=driver.findElement(By.xpath("//div[@id=\"locationTeamModal\"]/descendant::button[@class=\"btn-close\"]"));
		JavascriptExecutor just_click_close = (JavascriptExecutor) driver;                            
		just_click_close.executeScript("arguments[0].click();", close_window);
		
		//click on gen ai tab
		Thread.sleep(3000);
		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
		JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
		gen_ai_click.executeScript("arguments[0].click();", gen_ai);
		
		//click on observations
		WebElement obseravtions_another=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor operations = (JavascriptExecutor)driver;
		operations.executeScript("arguments[0].click();", obseravtions_another);

		//click on infra cost by location
		WebElement infra=driver.findElement(By.xpath("//button[text()='Infra Cost by Location']"));
		JavascriptExecutor operations_location = (JavascriptExecutor)driver;
		operations_location.executeScript("arguments[0].click();", infra);

		//click on mark as reviwed
		Thread.sleep(3000);
		WebElement review_screen_1=driver.findElement(By.xpath("//label[@data-color='blue']"));		
		JavascriptExecutor operations_location_9 = (JavascriptExecutor)driver;
		operations_location_9.executeScript("arguments[0].click();", review_screen_1);

		//click on fte validation
		WebElement ftr=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor ftr_click = (JavascriptExecutor)driver;
		ftr_click.executeScript("arguments[0].click();", ftr);
		
		
		
	}

	
	
}

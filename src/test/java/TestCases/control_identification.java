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

public class control_identification 
{
	
	@Test
	public static void controls() throws InterruptedException
	{
		

		WebDriver driver= new ChromeDriver();
		driver.get("https://prod.3-cubed.com/");
		String A="https://prod.3-cubed.com/";	

		
		String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

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


         driver.navigate().to("https://prod.3-cubed.com/Risk/ControlIdentification"); 

//		//click on download the team details
//		Thread.sleep(3000);
//		WebElement donwload_details=driver.findElement(By.xpath("//a[text()='Download Controls File']"));
//		JavascriptExecutor details = (JavascriptExecutor)driver;
//		details.executeScript("arguments[0].click();", donwload_details);
//
//		//upload the downloaded team file
//		WebDriverWait team_file=new WebDriverWait(driver, Duration.ofSeconds(90));
//		team_file.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='BulkUploadFile']"))).sendKeys("D:\\upload_file_input_screens\\Excel_3848-peakutilization__values__checking_Controls (3).xlsm");
//
//
//		//click on upload
//		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_click = (JavascriptExecutor)driver;
//		upload_click.executeScript("arguments[0].click();", upload);


		//click on legend
		WebElement legend=	driver.findElement(By.xpath("//button[text()='Legend']"));
		JavascriptExecutor click_legend = (JavascriptExecutor)driver;
		click_legend.executeScript("arguments[0].click();", legend);	

		

		
		
		//click on add new control objective
		driver.findElement(By.xpath("//button[@id='PopNewObjective']")).click();


		//click on add the new objective name
		driver.findElement(By.xpath("//div[@id='objectiveCtrlModel']/descendant::input[@type='text']")).sendKeys("QA_test");	


		//scroll to top
		JavascriptExecutor bottom_top = (JavascriptExecutor) driver;
		bottom_top.executeScript("window.scrollTo(0,0)", "");

		//click on control validation observations
		Thread.sleep(3000);
		WebElement control_validation=driver.findElement(By.xpath("//a[@id='review-tab']"));
		JavascriptExecutor valid = (JavascriptExecutor)driver;
		valid.executeScript("arguments[0].click();", control_validation);



		//click on mark as reviewed
		Thread.sleep(10000);
		//JavascriptExecutor bottom_top_1 = (JavascriptExecutor) driver;
		//bottom_top_1.executeScript("window.scrollTo(0,0)", "");
		Thread.sleep(3000);
		//			WebElement blue_color=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//			JavascriptExecutor valid_12 = (JavascriptExecutor)driver;
		//			valid_12.executeScript("arguments[0].click();", blue_color);

		
		//scroll to top
		JavascriptExecutor just_click = (JavascriptExecutor) driver;
		just_click.executeScript("window.scrollTo(0,0)", "");
		
		//click  on improve
		WebElement  improve=	driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor click_improve = (JavascriptExecutor)driver;
		click_improve.executeScript("arguments[0].click();", improve);

		
		
		
		//click on ai
		WebElement click_ai=	driver.findElement(By.xpath("//a[@id='genai-tab']"));
		JavascriptExecutor ai_click = (JavascriptExecutor)driver;
		ai_click.executeScript("arguments[0].click();", click_ai);	

		//click on control validation
		Thread.sleep(3000);
		WebElement control_validation_1=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor valid_1 = (JavascriptExecutor)driver;
		valid_1.executeScript("arguments[0].click();", control_validation_1);


	}

		
	}
	
	
	
	



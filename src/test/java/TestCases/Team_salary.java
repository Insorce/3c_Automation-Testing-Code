package TestCases;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;




public class Team_salary extends Baseclass

{


	@Test(invocationCount=1)
	public static void team_salary() throws InterruptedException

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


	  


		
		driver.navigate().to("https://prod.3-cubed.com/Teams/Teams");

//		//click on bulk download un hide 
//		
//		
//		WebElement click_bulk_download=driver.findElement(By.xpath("//button[text()='Bulk Upload']"));
//		JavascriptExecutor click_unhide = (JavascriptExecutor)driver;
//		click_unhide.executeScript("arguments[0].click();", click_bulk_download);
//
//		//click on download the team details
//
//		WebElement donwload_details=driver.findElement(By.xpath("//a[text()='Download Team Details File']"));
//		JavascriptExecutor details = (JavascriptExecutor)driver;
//		details.executeScript("arguments[0].click();", donwload_details);
//
//
//		//click on choose file
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3755-AUTOMATION TESTING_TeamDetails (1).xlsm");
//
//
//		//click on upload
//		Thread.sleep(3000);
//		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_click = (JavascriptExecutor)driver;
//		upload_click.executeScript("arguments[0].click();", upload);


		//				//click on the collapse in the team salary
		//				WebElement collapse=driver.findElement(By.xpath("//div[@id='actorAccordion']/descendant::button[@type='button']"));
		//				JavascriptExecutor collapse_click = (JavascriptExecutor)driver;
		//				collapse_click.executeScript("arguments[0].click();", collapse);

		driver.navigate().refresh();
		
		//enter the salary in for the teams

		List<WebElement>enter_salary=driver.findElements(By.xpath("//table[@id='dvActorDetail']//td//input[@type='text']"));


		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 1; i <= enter_salary.size(); i++)
		{
			WebElement enter_salary_intext_box = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@id='dvActorDetail']//td//input[@type='text'])[" + i + "]")));

			
			
			
			enter_salary_intext_box.sendKeys(Keys.CONTROL, Keys.chord("a"));
			enter_salary_intext_box.sendKeys(Keys.BACK_SPACE);
			// Clear the input field before entering a value

			enter_salary_intext_box.sendKeys("41000");
		}



		//click on gen ai
		Thread.sleep(5000);
		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
		JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
		gen_ai_click.executeScript("arguments[0].click();", gen_ai);


		//click on review
		WebElement review=driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor reviews = (JavascriptExecutor)driver;
		reviews.executeScript("arguments[0].click();", review);

		//click on team info
		WebElement team_info=driver.findElement(By.xpath("//button[text()='Teams Info']"));
		JavascriptExecutor team_info_click = (JavascriptExecutor)driver;
		team_info_click.executeScript("arguments[0].click();", team_info);


		//click on mark as reviewed
		Thread.sleep(3000);
		WebElement mark=driver.findElement(By.xpath("//label[@data-color='blue']"));
		JavascriptExecutor mark_as_review = (JavascriptExecutor)driver;
		mark_as_review.executeScript("arguments[0].click();", mark);


		//click on team info
		Thread.sleep(3000);
		WebElement team_info_click5192=driver.findElement(By.xpath("//button[text()='Teams Info']"));
		JavascriptExecutor info_click = (JavascriptExecutor)driver;
		info_click.executeScript("arguments[0].click();", team_info_click5192);


	}

	
	
}

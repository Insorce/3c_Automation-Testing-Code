package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class business_rules extends Baseclass
{

	
	

	@Test(invocationCount=1)
	public static void business_rules() throws InterruptedException
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


		
		driver.navigate().to("https://prod.3-cubed.com/Process/BusinessRules");
		
		

//		//click on download the team details
//		WebElement donwload=driver.findElement(By.xpath("//a[text()='Download Business Rules File']"));
//		JavascriptExecutor donwload_team = (JavascriptExecutor)driver;
//		donwload_team.executeScript("arguments[0].click();", donwload);

//		//click on choose file
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\Excel_2508-QA_test29229_BusinessRules.xlsm");
//
//		//click on upload
//		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_5192 = (JavascriptExecutor)driver;
//		upload_5192.executeScript("arguments[0].click();", upload);

		
		
		
		//click on the manage forms
		
		WebElement manage_forms=driver.findElement(By.xpath("//button[text()='Manage Business Rules']"));
		JavascriptExecutor click_manage_forms = (JavascriptExecutor)driver;
		click_manage_forms.executeScript("arguments[0].click();", manage_forms);
		
		
		
		
		// Wait object
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait until the input box is visible and interactable
		WebElement inputBox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dvNewBR']")));

		// Clear and type
//		inputBox.clear();
		inputBox.sendKeys("QA_test");
//
//		// Wait for '+' symbol to be clickable
//		WebElement plusSymbol = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fas fa-plus input-group-text']")));
//
//		// Scroll into view if needed
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plusSymbol);
//
//		
//	
//		// Click the '+' icon using JS if normal click doesn't work
//		try
//		{
//		    plusSymbol.click();
//		} catch (ElementNotInteractableException e) 
//		{
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusSymbol);
//		}
//		
//		
//
//
//		Thread.sleep(3000);
//		//click on qa_test
//		WebElement qa_test=driver.findElement(By.xpath("//a[text()='QA_test']"));
//		JavascriptExecutor click_qa_test = (JavascriptExecutor)driver;
//		click_qa_test.executeScript("arguments[0].click();", qa_test);
//
//
//		Thread.sleep(3000);
//		//click on the send to requsition
//		WebElement requsition=driver.findElement(By.xpath("//button[text()='Click here to send for Requisition']"));
//		JavascriptExecutor click_qa_test1 = (JavascriptExecutor)driver;
//		click_qa_test1.executeScript("arguments[0].click();", requsition);
//		

		
//		for (int l = 0; ; l++) 
//		{
//		    List<WebElement> activityLinks = driver.findElements(By.xpath("//ul[@id=\"activityTree\"]//a"));
//		    if (l >= activityLinks.size()) break;
//
//		    WebElement activityLink = activityLinks.get(l);
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityLink);
//		    Thread.sleep(1000);
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityLink);
//		    Thread.sleep(2000);
//		}


		
//		//click on improve
//		Thread.sleep(3000);
//		WebElement improve=driver.findElement(By.xpath("//a[@id='perfimp-tab']"));
//		JavascriptExecutor click_improve = (JavascriptExecutor)driver;
//		click_improve.executeScript("arguments[0].click();", improve);
//		
//
//		//click on information
//		Thread.sleep(3000);
//		WebElement information=	driver.findElement(By.xpath("//a[@id='information-tab']"));
//		JavascriptExecutor click_information = (JavascriptExecutor)driver;
//		click_information.executeScript("arguments[0].click();", information);
//
//		//click on compare
//		Thread.sleep(3000);
//		WebElement compare=driver.findElement(By.xpath("//a[@id='adv-tab']"));
//		JavascriptExecutor click_compare = (JavascriptExecutor)driver;
//		click_compare.executeScript("arguments[0].click();", compare);
//		
//		//click on gen ai
//		Thread.sleep(3000);
//		WebElement genai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor click_genai = (JavascriptExecutor)driver;
//		click_genai.executeScript("arguments[0].click();", genai);
//		
		
//		//clik on business rules observations
//		WebElement observations_rules=driver.findElement(By.xpath("//a[@id='obs-tab']"));
//		JavascriptExecutor click_forms = (JavascriptExecutor)driver;
//		click_forms.executeScript("arguments[0].click();", observations_rules);
//		
//		//click on the activity cluster
//		WebElement activity_cluster=driver.findElement(By.xpath("//button[@title='Click here to assign cluster']"));
//		JavascriptExecutor cluster_click = (JavascriptExecutor)driver;
//		cluster_click.executeScript("arguments[0].click();", activity_cluster);
//		
//
//		//scroll to top
//		JavascriptExecutor bottom_top_2 = (JavascriptExecutor) driver;
//		bottom_top_2.executeScript("window.scrollTo(0,0);");
//
//		JavascriptExecutor bottom_top_3 = (JavascriptExecutor) driver;
//		bottom_top_3.executeScript("window.scrollTo(0,0);");


//		//click on Decision activity
//		WebElement Decision_activity=driver.findElement(By.xpath("//button[text()='Decision activity Business rules']"));
//		JavascriptExecutor click_v = (JavascriptExecutor)driver;
//		click_v.executeScript("arguments[0].click();", Decision_activity);

		//click on mark as reviewed
		Thread.sleep(3000);
		WebElement mark_review_1=driver.findElement(By.xpath("//div[@id='accDecisionActivity']/descendant::input[@type='checkbox']"));
		JavascriptExecutor click_2 = (JavascriptExecutor)driver;
		click_2.executeScript("arguments[0].click();", mark_review_1);

		//click on Decision activity
		WebElement Decision_activity_2=driver.findElement(By.xpath("//button[text()='Decision activity Business rules']"));
		JavascriptExecutor click_activity = (JavascriptExecutor)driver;
		click_activity.executeScript("arguments[0].click();", Decision_activity_2);


		//clcik on business rules automation
		Thread.sleep(3000);
		WebElement automation=driver.findElement(By.xpath("//button[text()='Business rules automation']"));
		JavascriptExecutor automation_7 = (JavascriptExecutor)driver;
		automation_7.executeScript("arguments[0].click();", automation);

//		//click on mark as reviwed
//		Thread.sleep(3000);
//		WebElement mark_review_2=driver.findElement(By.xpath("//div[@id='BRAutomation']/descendant::input[@type='checkbox']"));
//		JavascriptExecutor click_3 = (JavascriptExecutor)driver;
//		click_3.executeScript("arguments[0].click();", mark_review_2);


		//clcik on business rules automation
		Thread.sleep(3000);
		WebElement automation_rules=driver.findElement(By.xpath("//button[text()='Business rules automation']"));
		JavascriptExecutor automation_9 = (JavascriptExecutor)driver;
		automation_9.executeScript("arguments[0].click();", automation_rules);

//		//click on info
//		WebElement info=driver.findElement(By.xpath("//a[@id='information-tab']"));
//		JavascriptExecutor click_info = (JavascriptExecutor)driver;
//		click_info.executeScript("arguments[0].click();", info);
//	
		
//		//click on no business rules
//		WebElement business_rules=	driver.findElement(By.xpath("//button[text()='No Business Rules']"));
//		JavascriptExecutor rules_click = (JavascriptExecutor)driver;
//		rules_click.executeScript("arguments[0].click();", business_rules);


//		//click on control validation
//		WebElement vaid_8=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black mb-3']"));
//		JavascriptExecutor click_validation = (JavascriptExecutor)driver;
//		click_validation.executeScript("arguments[0].click();", vaid_8);


		
	}

	
}

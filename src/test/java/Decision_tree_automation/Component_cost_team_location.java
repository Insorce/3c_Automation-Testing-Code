package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Component_cost_team_location 


{
	@Test
	public static void compoenent_cost_team_location() throws Exception
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
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rama krishna");
			//enter password
			driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
			String AA=driver.getCurrentUrl();
			
			if(AA.equals(WelcomePage))
			{
				System.out.println("Login Success");
			}
		
			if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) 
			{
				driver.findElement(By.xpath("//button[text()='Log Out']")).click();
				driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rama krishna");
				//enter password
				driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2025");
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
				
			}
		
	
		

		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement click_on_project=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4315: AUTOMATION__MORTGAGE__PROJECT88']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);


		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='107']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='107']"))).getText();
		System.out.println(node);



		//here we need to compare the  Component Cost  decision tree values
		String expectedValue ="Component Cost\n"+ "39 seats | USD 20.8K" ;
		String actualValue=node;                    
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Effort:Expected data and Actual data are not Matched");
		if (expectedValue.equalsIgnoreCase(actualValue)) 
		{
			System.out.println("Expected Value matches the Actual Value");

		}
		else 
		{
			System.out.println("Expected Value not matches to Actual Value");
		}

		//file reading sceanrio
		PrintStream printStream = new PrintStream(new FileOutputStream("Log.txt"));
		printStream.println("Actual Value is"+'\n'+actualValue);
		printStream.println(                                                       );
		printStream.println(                                                       );
		printStream.println("Expected Value is"+'\n'+expectedValue);

		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor bottom = (JavascriptExecutor) driver;
		bottom.executeScript("window.scrollBy(0,900)", "");



		//click on component widget

		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[text()='Team Location']")).click();


		//use the windows handler
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println(mainWindowHandle);

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);

		for (String handle : allWindowHandles)
		{
			if (!handle.equals(mainWindowHandle))
			{

				driver.switchTo().window(handle);
				break;

			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");



		
		


		//click on the  download 
		WebElement download=driver.findElement(By.xpath("//button[@title='Download']"));

		JavascriptExecutor click_download  = (JavascriptExecutor) driver;
		click_download.executeScript("arguments[0].click();", download);



		//click on the view comment
		Thread.sleep(3000);
		WebElement view_comment=driver.findElement(By.xpath("//i[@class='fas fa-comment is-cursor-pointer fa-2x mx-1 text-primary']"));
		JavascriptExecutor click_comment= (JavascriptExecutor) driver;
		click_comment.executeScript("arguments[0].click();", view_comment);

		//enter the comment in text
		Thread.sleep(3000);
		WebElement comment_text=driver.findElement(By.xpath("//textarea[@id='CommentsText']"));
		comment_text.sendKeys("QA_test");


		//click on save
		WebElement save=driver.findElement(By.xpath("//div[@id='CommentDialogue']/descendant::button[text()='Save']"));
		Thread.sleep(3000);
		save.click();


		//click on the three lines

		WebElement three_lines=driver.findElement(By.xpath("//i[@class='fas fa-bars fa-2x p-2']"));
		JavascriptExecutor three_lines_click= (JavascriptExecutor) driver;
		three_lines_click.executeScript("arguments[0].click();", three_lines);

		//click on the download button

		WebElement download_button=driver.findElement(By.xpath("//a[@title='Download Visio & Recovery']"));
		JavascriptExecutor click_download_button= (JavascriptExecutor) driver;
		click_download_button.executeScript("arguments[0].click();", download_button);

		//click on all downloads under the symbol


		List<WebElement> all_downloads=driver.findElements(By.xpath("//i[@class='fas fa-file-download']"));

		for (int D = 1; D <= all_downloads.size(); D++) 
		{

			WebElement click_menu=driver.findElement(By.xpath("(//i[@class='fas fa-file-download'])["+D+"]"));


			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", click_menu);

			Thread.sleep(3000);

			
			
			
		}




		//enter all the location which is enabled

		List<WebElement> locations=driver.findElements(By.xpath("((//form[@id='frmGeolocateTeams'])[1])/descendant::input[contains(@id,'actorCity')]"));




		// Loop through each element
		for (WebElement location : locations)
		{
			// Check if the field is enabled
			if (location.isEnabled())
			{


				Thread.sleep(3000);
				location.sendKeys(Keys.CONTROL, Keys.chord("a"));
				location.sendKeys(Keys.BACK_SPACE);
				Thread.sleep(3000);
				location.sendKeys("Hyderabad");
				location.sendKeys(Keys.ENTER);

			} 
			else
			{
				System.out.println("Location is NOT enabled");
			}
		}





		//click on save and continue
		WebDriverWait click_save=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement save_continue=click_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-group mx-1']/child::button")));
		JavascriptExecutor click_no_optimization = (JavascriptExecutor) driver;
		click_no_optimization.executeScript("arguments[0].click();", save_continue);
		
		
		//enter the start time
		
		
		List<WebElement> start_time=driver.findElements(By.xpath("//input[contains(@id,'actorStartTime')]"));

		for (int s = 1; s <=start_time.size(); s++) 
		{

			WebElement enter_start_time=driver.findElement(By.xpath("((//input[contains(@id,'actorStartTime')])["+s+"])"));
            
			enter_start_time.clear();
			enter_start_time.sendKeys("09:00");
			
			Thread.sleep(5000);
		}
		

		

				
		//end time

		List<WebElement> end_time=driver.findElements(By.xpath("//input[contains(@id,'actorStartTime')]"));

		for (int e = 1; e <= end_time.size(); e++) 
		{

			WebElement enter_end_time=driver.findElement(By.xpath("((//input[contains(@id,'actorEndTime')])["+e+"])"));

			enter_end_time.clear();
			enter_end_time.sendKeys("18:00");
			

			Thread.sleep(3000);

		
		}
		
		//working hours
		
		List<WebElement> working_hours=driver.findElements(By.xpath("//input[contains(@id,'actorWorkingHours')]"));

		for (int w = 1; w <=working_hours.size(); w++) 
		{

			WebElement enter_working_time=driver.findElement(By.xpath("((//input[contains(@id,'actorWorkingHours')])[\"+w+\"])"));

			enter_working_time.clear();
			enter_working_time.sendKeys("09.00");

		}
				
		
		
		
		//productive hours
		
		
		
		
		List<WebElement> productive_hours=driver.findElements(By.xpath("//input[contains(@id,'actorWorkingHours')]"));

		for (int p = 1; p <=productive_hours.size(); p++) 
		{

			WebElement enter_productive_time=driver.findElement(By.xpath("((//input[contains(@id,'actorProductiveHours')])["+p+"])"));
			enter_productive_time.clear();
			enter_productive_time.sendKeys("08.00");
			

		}

		//click on save and countinue
		WebDriverWait click_save_continue=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement countinue=click_save_continue.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Cart-dialog']/descendant::button[text()='Save & Continue']")));
		JavascriptExecutor just_click_save_continue = (JavascriptExecutor) driver;
		just_click_save_continue.executeScript("arguments[0].click();", countinue);

	
		
		
		//enter the cost sheet per month
		WebDriverWait cost=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement sheet=cost.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @data-bvalidator-msg='Enter Base Cost']")));
		sheet.click();
		sheet.sendKeys(Keys.CONTROL, Keys.chord("a"));
		sheet.sendKeys(Keys.BACK_SPACE);
		sheet.sendKeys("15000");
		sheet.sendKeys(Keys.ENTER);

		//click on check box and slect all the componennts
		WebDriverWait componennts=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement select_all=componennts.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@id,'chkSelect')]")));
		select_all.click();


		//click on save and continue
		WebDriverWait just_click_save=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement just_save=just_click_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='LocationSaveContinue']")));
		just_save.click();
		
		
      //click on all reset
		
		List<WebElement> all_reset=driver.findElements(By.xpath("//td[text()='Reset']"));
		
		
		for(int l=1;  l<=all_reset.size(); l++)
		{
			
			WebElement all=driver.findElement(By.xpath("(//td[text()='Reset'])["+l+"]"));
			JavascriptExecutor just_click_reset= (JavascriptExecutor) driver;
			just_click_reset.executeScript("arguments[0].click();", all);
			Thread.sleep(3000);
			
		}
		
		
		//click on the linked text to highlighted benchmark cost per annum
		
		Thread.sleep(3000);
		
		List<WebElement> linked_text=driver.findElements(By.xpath("//a[text()='Click here to enter benchmark cost']"));
		
		for(int t=1;  t<=linked_text.size(); t++)
		{
			
			WebElement click_linked_text=driver.findElement(By.xpath("((//a[text()='Click here to enter benchmark cost'])["+t+"])"));
			click_linked_text.click();
			

			
			Thread.sleep(5000);
			
			
			//enter the low cost
			
			WebElement low_costs=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[contains(@id,'LowCost')]"));
			
			
			low_costs.sendKeys(Keys.CONTROL, Keys.chord("a"));
			low_costs.sendKeys(Keys.BACK_SPACE);
			low_costs.sendKeys("450");
			low_costs.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			

			//enter the medium cost
			
		
			WebElement enter_medium_cost=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[@id='MediumCost']"));
			
			enter_medium_cost.sendKeys(Keys.CONTROL, Keys.chord("a"));
			enter_medium_cost.sendKeys(Keys.BACK_SPACE);
			enter_medium_cost.sendKeys("15000");
			enter_medium_cost.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
			  

			//enter the high cost
			
			
			WebElement high_cost=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[@id='HighCost']"));
			
			high_cost.sendKeys(Keys.CONTROL, Keys.chord("a"));
			high_cost.sendKeys(Keys.BACK_SPACE);
			high_cost.sendKeys("20000");
			high_cost.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			


	
			//click on save and  continue
			WebDriverWait continue_save=new WebDriverWait(driver, Duration.ofSeconds(0));
			WebElement click_continue_save=continue_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::button[text()='Save & Proceed']")));
		   click_continue_save.click();


		}
		
		
		
		
		//click and enter the salary

		List<WebElement> salary=driver.findElements(By.xpath("//a[text()='Click here to enter salary']"));



        for (int s=1; s<=salary.size(); s++)
        {
        	
        	
        	driver.findElement(By.xpath("(//a[text()='Click here to enter salary'])["+s+"]")).click();
        	
        	
        	//click the radio button
        	WebElement radio_button=driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::input[@value='AvgSal']"));
        	
        	
        	//enter the average salary
        	
        	Thread.sleep(5000);
        
        	WebElement average_salary=driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::input[@type='text']"));
        
        	average_salary.sendKeys(Keys.CONTROL, Keys.chord("a"));
        	average_salary.sendKeys(Keys.BACK_SPACE);
        	average_salary.sendKeys("2000");
        	
        	
        	//salary range per month
        	
        	driver.findElement(By.xpath("//input[@value='MMSal']")).click();
        	
        	
        	//enter the minium salary
        	
        	WebElement minium_salary=driver.findElement(By.xpath("//input[@id='MinSal']"));
        	minium_salary.sendKeys(Keys.CONTROL, Keys.chord("a"));
        	minium_salary.sendKeys(Keys.BACK_SPACE);
        	minium_salary.sendKeys("3000");
        	
        	
        	
        	
        	//enter the maximum salary
        	
        	WebElement maximun_salary=driver.findElement(By.xpath("//input[@id='MaxSal']"));
        	maximun_salary.sendKeys(Keys.CONTROL, Keys.chord("a"));
        	maximun_salary.sendKeys(Keys.BACK_SPACE);
        	maximun_salary.sendKeys("10000");
        	
        	
        	//click on save and proceed
        	driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::button[text()='Save & Proceed']")).click();
        	
        	
        }



		

		//click on save and continue per month
		WebDriverWait save_continue_month=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement save_continue_per_month=save_continue_month.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='LocationSaveContinue']")));
		save_continue_per_month.click();


		//click on review and proceed 
		WebDriverWait insorcetest992=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement review_proceed=insorcetest992.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Review & Proceed')]")));
		JavascriptExecutor just_click_reset= (JavascriptExecutor) driver;
		just_click_reset.executeScript("arguments[0].click();", review_proceed);

		//click on simulate out come
		WebDriverWait simulate=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_simulate_outcome=simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='TeamCartDialog']/descendant::button[text()='Simulate Outcome']")));
		click_simulate_outcome.click();

		Thread.sleep(7000);
		//close path automation window using window handler

		String mainWindowHandle211 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles211 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle1 : allWindowHandles211)
		{
			if (!handle1.equals(mainWindowHandle211))
			{

				//driver.switchTo().window(handle);
				//click on view results
				WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
				click_optimization.executeScript("arguments[0].click();", click_proceed);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}













	}

}

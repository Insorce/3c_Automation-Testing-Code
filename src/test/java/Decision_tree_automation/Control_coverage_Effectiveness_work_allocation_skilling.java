package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Control_coverage_Effectiveness_work_allocation_skilling 

{

	@Test
	public static  void work_allocation_skilling() throws Exception
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='1842: AUTOMATION_PROJECT']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='303']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='303']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Effectiveness\n"+ "45.4%";
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
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");


		//click on workallocation&skilling
		WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement work_allocation=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Work Allocation & Skilling']")));
		Actions action1=new Actions(driver);
		action1.click(work_allocation).perform();
		Thread.sleep(10000);
		

		// multiple window handler

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
		
		
		//click on the activity cluster wise
		WebElement activity_cluster_wise=driver.findElement(By.xpath("//button[text()=' Activities similarity (cluster wise)']"));
		
		JavascriptExecutor click_activity_cluster  = (JavascriptExecutor) driver;
		click_activity_cluster.executeScript("arguments[0].click();", activity_cluster_wise);
		
		
		//click on close
		Thread.sleep(3000);
		
		WebElement close=driver.findElement(By.xpath("//button[@id='frameModalDialogClose']"));
		JavascriptExecutor click_close  = (JavascriptExecutor) driver;
		click_close.executeScript("arguments[0].click();", close);
		
		
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


		
		
	    
		
		//click on allocate the fullteam
		Thread.sleep(10000);
		WebElement click_full_team=driver.findElement(By.xpath("//tbody/tr/td[3]/div[1]/span[2]/button[contains(text(),\"Full\")]"));
		Thread.sleep(3000);
		JavascriptExecutor click_full  = (JavascriptExecutor) driver;
		click_full.executeScript("arguments[0].click();", click_full_team);
	


		//using this we can generate the unique team name
		String uuid=UUID.randomUUID().toString();
		String[] links = null;
		int linksCount = 0;

		//click on text box
		WebElement fullteam=driver.findElement(By.xpath("//div[@id='new-team-modal']/descendant::input[@class='form-control']"));
		fullteam.sendKeys("QAteam" +uuid);

		//click on Add
		Thread.sleep(5000);
		WebElement add_button=driver.findElement(By.xpath("//button[text()='Add']"));
		add_button.click();
		Thread.sleep(4000);

		//click on proceed

		WebElement proceed=driver.findElement(By.xpath("//div[@id='new-team-modal']/descendant::button[text()='Proceed']"));
		JavascriptExecutor click_proceed = (JavascriptExecutor) driver;
		click_proceed.executeScript("arguments[0].click();", proceed);

		//click on review and proceed

		Thread.sleep(3000);
		WebElement reviewed_proceed=driver.findElement(By.xpath("//button[@id='btnAssignedList']"));
		reviewed_proceed.click();

		//click on proceed
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='excahnge-activities-dialog']/descendant::button[text()='Proceed']")).click();

		//enter the team location
		Thread.sleep(3000);
		WebElement teamslocation=driver.findElement(By.xpath("//form[@id='frmGeolocateTeams']/descendant::input[@type='text']"));
		teamslocation.sendKeys(Keys.CONTROL, Keys.chord("a"));
		teamslocation.sendKeys(Keys.BACK_SPACE);
		teamslocation.sendKeys("India/Hyderabad");
		teamslocation.sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		teamslocation.sendKeys(Keys.ENTER);

		//click on save and continue
		WebDriverWait click_save=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement save_and_continue=click_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Cart-dialog']//button[text()='Save & Continue']")));
		save_and_continue.click();


		//start time
		//		Thread.sleep(3000);
		//		WebElement starttime=driver.findElement(By.id("actorStartTime10"));
		//		starttime.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		starttime.sendKeys(Keys.BACK_SPACE);
		//		starttime.sendKeys("9:00");
		//		starttime.click();


		//end time
		//		Thread.sleep(3000);
		//		WebElement Endtime=driver.findElement(By.id("actorEndTime10"));
		//		Endtime.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		Endtime.sendKeys(Keys.BACK_SPACE);
		//		Endtime.sendKeys("08:00");
		//		Endtime.click();


		//working hours
		//	Thread.sleep(3000);
		//	WebElement workinghours=driver.findElement(By.id("actorWorkingHours10"));
		//		workinghours.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		workinghours.sendKeys(Keys.BACK_SPACE);
		//		workinghours.sendKeys("06.80");
		//	workinghours.click();

		//productive hours		
		//	Thread.sleep(3000);
		//	WebElement productivehours=driver.findElement(By.xpath("//input[@id='actorProductiveHours10']"));
		//		productivehours.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		productivehours.sendKeys(Keys.BACK_SPACE);
		//		productivehours.sendKeys("18:00");
		//	productivehours.click();

		//click on save and continue
		Thread.sleep(3000);
		WebElement savecontinue=driver.findElement(By.xpath("//div[@id='Cart-dialog']//button[text()='Save & Continue']"));
		savecontinue.click();

		//enter the cost per month

		WebElement costpermonth=driver.findElement(By.xpath("//input[@data-bvalidator-msg='Enter Base Cost']"));
		costpermonth.sendKeys(Keys.CONTROL, Keys.chord("a"));
		costpermonth.sendKeys(Keys.BACK_SPACE);
		costpermonth.sendKeys(Keys.ARROW_UP);
		costpermonth.sendKeys("41200");

		//select all components

		WebElement all_components=driver.findElement(By.xpath("//input[contains(@id,'chkSelect')]"));
		all_components.click();

		//click on save and continue

		WebElement saveclickcontinue=driver.findElement(By.xpath("//button[@id='LocationSaveContinue']"));
		saveclickcontinue.click();



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
			JavascriptExecutor click_save_click= (JavascriptExecutor) driver;
			click_save_click.executeScript("arguments[0].click();", click_continue_save);

		}




		//click and enter the salary

		List<WebElement> salary=driver.findElements(By.xpath("//a[text()='Click here to enter salary']"));



		for (int s=1; s<=salary.size(); s++)
		{


			driver.findElement(By.xpath("(//a[text()='Click here to enter salary'])["+s+"]")).click();

			//click on radio button

			driver.findElement(By.xpath("//input[@value='AvgSal']")).click();



			//enter the average salary

			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::input[@type='text']")).sendKeys("2000");


			//salary range per month

			driver.findElement(By.xpath("//input[@value='MMSal']")).click();

			//enter the minium salary

			driver.findElement(By.xpath("//input[@id='MinSal']")).sendKeys("5000");


			//enter the maximum salary

			driver.findElement(By.xpath("//input[@id='MaxSal']")).sendKeys("10000");


			//click on save and proceed
			driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::button[text()='Save & Proceed']")).click();
			


		}


		//click on save and continue
		Thread.sleep(3000);
		WebElement save_continue=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::button[text()='Save & Proceed']"));
		JavascriptExecutor click_save_click= (JavascriptExecutor) driver;
		click_save_click.executeScript("arguments[0].click();", save_continue);


		//click on save and continue
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='LocationSaveContinue']")).click();

		
		
		
		Thread.sleep(7000);
		//close work allovcation window using window handler

		String mainWindowHandle211 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles211 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle1 : allWindowHandles211)
		{
			if (!handle1.equals(mainWindowHandle211))
			{


				WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement proceed_optimization=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
				click_optimization.executeScript("arguments[0].click();", proceed_optimization);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}



	}

}

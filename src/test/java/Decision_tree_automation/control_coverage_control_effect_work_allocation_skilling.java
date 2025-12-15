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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class control_coverage_control_effect_work_allocation_skilling
{

	@Test
	public static void control_coverage() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='304']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='304']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Control Effort\n"+ "26.7 hrs (12.5%)";
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

		//click on work allocation

		WebDriverWait robotics=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Automation_robotics=robotics.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Work Allocation & Skilling']")));
		JavascriptExecutor click_robotics = (JavascriptExecutor) driver;
		click_robotics.executeScript("arguments[0].click();", Automation_robotics);

		// multiple window handler

		String mainWindowHandle1 = driver.getWindowHandle();
		System.out.println(mainWindowHandle1);

		Set<String> allWindowHandles1 = driver.getWindowHandles();
		System.out.println(allWindowHandles1);

		for (String handle1 : allWindowHandles1)
		{
			if (!handle1.equals(mainWindowHandle1))
			{

				driver.switchTo().window(handle1);
				Thread.sleep(3000);
				break;

			}
		}
		System.out.println(mainWindowHandle1);

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


		//click on all the 5 labels bottlenecks hands-off Delays,preak,ineffective controls,ineffective controls,comptency by

		List<WebElement> click_all_labels = driver.findElements(By.xpath("//label[@class='btn btn-outline-primary']"));


		for(int k=1; k<=click_all_labels.size(); k++)
		{

			WebElement all_labels=driver.findElement(By.xpath("//label[@class='btn btn-outline-primary']["+k+"]"));

			JavascriptExecutor just_click_labels  = (JavascriptExecutor) driver;
			just_click_labels.executeScript("arguments[0].click();", all_labels);


			Thread.sleep(2000);

			//click on show graph 

			WebElement show_grpah= driver.findElement(By.xpath("//button[text()='Show Graph']"));

			JavascriptExecutor click_graph  = (JavascriptExecutor) driver;
			click_graph.executeScript("arguments[0].click();", show_grpah);






		}

		Thread.sleep(3000);
		//click on the select all the drop down menu

		Select objSelect = new Select(driver.findElement(By.xpath("(//select[@class='form-select'])[1]")));
		Thread.sleep(2000);
		objSelect.selectByVisibleText("Fact based");
		objSelect.selectByVisibleText("Computation");
		objSelect.selectByVisibleText("Human Judgment");
		objSelect.selectByVisibleText("All");



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



		//click on peak
		Thread.sleep(3000);
		WebDriverWait peaks=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement clickonpeak=peaks.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CostAnalysis']/descendant::label[text()='On Peak']")));
		JavascriptExecutor insorcepeak = (JavascriptExecutor) driver;
		insorcepeak.executeScript("arguments[0].click();", clickonpeak);



		//click allocate on full
		WebDriverWait full=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement allocate=full.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[3]/div[1]/span[2]/button[contains(text(),'Full')]")));
		JavascriptExecutor allocat = (JavascriptExecutor) driver;
		allocat.executeScript("arguments[0].click();", allocate);


		//click on text box
		WebDriverWait proceeds=new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement proceed=proceeds.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='new-team-modal']/descendant::input[@class='form-control']")));
		JavascriptExecutor allocate1  = (JavascriptExecutor) driver;
		allocate1.executeScript("arguments[0].click();", proceed);

		String uuid=UUID.randomUUID().toString();
		String[] links = null;
		int linksCount = 0;

		proceed.sendKeys("QA testing" +uuid);


		//click on add
		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement hello=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
		Actions action11=new Actions(driver);
		action11.click(hello).perform();

		//click on proceed

		WebDriverWait proceed1=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement hello1=proceed1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='new-team-modal']/descendant::button[text()='Proceed']")));
		Actions action111=new Actions(driver);
		action111.click(hello1).perform();

		//click on review and proceed
		Thread.sleep(3000);
		WebDriverWait review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement review_proceed=review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnAssignedList']")));
		JavascriptExecutor allocate11  = (JavascriptExecutor) driver;
		allocate11.executeScript("arguments[0].click();", review_proceed);


		//click on proceed
		WebDriverWait proceeding=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click=proceeding.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='excahnge-activities-dialog']/descendant::button[text()='Proceed']")));
		JavascriptExecutor proceedchanges  = (JavascriptExecutor) driver;
		proceedchanges.executeScript("arguments[0].click();", click);

		//enter the location
		Thread.sleep(3000);
		WebDriverWait enter_location=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement enter=enter_location.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='frmGeolocateTeams']/descendant::input[@type='text']")));
		JavascriptExecutor locations  = (JavascriptExecutor) driver;
		locations.executeScript("arguments[0].click();", enter);
		Thread.sleep(1000);
		enter.sendKeys(Keys.CONTROL, Keys.chord("a"));
		enter.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		enter.sendKeys("India/Hyderabad");
		Thread.sleep(1000);
		enter.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		//click on save and continue

		Thread.sleep(3000);
		WebElement save_and_continue=driver.findElement(By.xpath("//div[@id='Cart-dialog']//button[text()='Save & Continue']"));
		Actions saveandcontinue=new Actions(driver);
		saveandcontinue.click(save_and_continue).build().perform();  

		//		//click on start time 
		//		WebDriverWait starttime=new WebDriverWait(driver, Duration.ofSeconds(60));
		//		WebElement time=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control text-right' and @id='actorStartTime10']")));
		//		time.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		time.sendKeys(Keys.BACK_SPACE);
		//		time.sendKeys("10:00");
		//		Thread.sleep(3000);
		//		//click on end time
		//		WebDriverWait endtime=new WebDriverWait(driver, Duration.ofSeconds(60));
		//		WebElement end=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control text-right' and @id='actorEndTime10']")));
		//		end.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		end.sendKeys(Keys.BACK_SPACE);
		//		end.sendKeys("17:00");
		//		Thread.sleep(3000);
		//
		//		//click on working hours
		//		WebDriverWait hours=new WebDriverWait(driver, Duration.ofSeconds(60));
		//		WebElement workinghours=hours.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control text-right' and @id='actorWorkingHours10']")));
		//		workinghours.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		workinghours.sendKeys(Keys.BACK_SPACE);
		//		workinghours.sendKeys("7:00");
		//		Thread.sleep(3000);
		//		//productive hours
		//		WebDriverWait productivehours=new WebDriverWait(driver, Duration.ofSeconds(60));
		//		WebElement workinghours1=productivehours.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control' and @id='actorProductiveHours10']")));
		//		workinghours1.sendKeys(Keys.CONTROL, Keys.chord("a"));
		//		workinghours1.sendKeys(Keys.BACK_SPACE);
		//		workinghours1.sendKeys("5:00");    
		//		Thread.sleep(3000);

		//click on save and continue
		Thread.sleep(3000);
		WebElement again_click_save=driver.findElement(By.xpath("//div[@id='Cart-dialog']//button[text()='Save & Continue']"));
		Actions clickonsave=new Actions(driver);
		clickonsave.click(again_click_save).build().perform();  



		//enter the cost

		WebElement cost=driver.findElement(By.xpath("//input[@data-bvalidator-msg='Enter Base Cost']"));
		cost.sendKeys(Keys.CONTROL, Keys.chord("a"));
		cost.sendKeys(Keys.BACK_SPACE);
		cost.sendKeys("100"); 

		//click on system and application
		Thread.sleep(2000);
		WebElement systemandapplication=driver.findElement(By.xpath("//input[contains(@id,'chkSelect')]"));
		Thread.sleep(1000);
		systemandapplication.click();

		//click on save and continue
		Thread.sleep(2000);
		WebElement saveandcontinue2=driver.findElement(By.xpath("//button[@id='LocationSaveContinue']"));
		saveandcontinue2.click();





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








		//click on save and continue per month
		WebDriverWait continue_permonth=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement save_and_continue_permonth=continue_permonth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='LocationSaveContinue']")));
		save_and_continue_permonth.click();

		//click on close

		WebElement close_click=driver.findElement(By.xpath("//a[@class='btn-close']"));
		JavascriptExecutor click_on_optmize = (JavascriptExecutor) driver;
		click_on_optmize.executeScript("arguments[0].click();", close_click);




		Thread.sleep(7000);
		//close work allocation window using window handler

		String mainWindowHandle211 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles211 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle1 : allWindowHandles211)
		{
			if (!handle1.equals(mainWindowHandle211))
			{


				// 				WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
				// 				WebElement proceed_optimization=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				// 				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
				// 				click_optimization.executeScript("arguments[0].click();", proceed_optimization);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}
	}
}













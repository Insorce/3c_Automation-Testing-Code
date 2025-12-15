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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customerexperience_bottleneck_shift_workinghours 


{

	@Test
	public static void shift_workinghours() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='204']"))).click();

//		//click on tree node and get text
//		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
//		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='204']"))).getText();
//		System.out.println(node);
//
//
//
//		//here we need to Critical path  decision tree values
//		String expectedValue ="Bottlenecks and Delays\n"+ "6 days | 31.1 days" ;
//		String actualValue=node;                    
//		System.out.println(actualValue);
//		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Effort:Expected data and Actual data are not Matched");
//		if (expectedValue.equalsIgnoreCase(actualValue)) 
//		{
//			System.out.println("Expected Value matches the Actual Value");
//
//		}
//		else 
//		{
//			System.out.println("Expected Value not matches to Actual Value");
//		}
//
//		//file reading sceanrio
//		PrintStream printStream = new PrintStream(new FileOutputStream("Log.txt"));
//		printStream.println("Actual Value is"+'\n'+actualValue);
//		printStream.println(                                                       );
//		printStream.println(                                                       );
//		printStream.println("Expected Value is"+'\n'+expectedValue);
//
		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor bottom = (JavascriptExecutor) driver;
		bottom.executeScript("window.scrollBy(0,900)", "");


		//click on shift & working hours 
		WebDriverWait rework=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement reductions=rework.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/WorkTimingDelays']")));
		Actions action1=new Actions(driver);
		action1.click(reductions).perform();
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
				Thread.sleep(3000);
				break;

			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");

		//scroll to top to bottom

		Thread.sleep(3000);
		JavascriptExecutor top_bottom = (JavascriptExecutor) driver;
		top_bottom.executeScript("window.scrollBy(0,500)", "");





//		//click on the  download 
//		WebElement download=driver.findElement(By.xpath("//button[@title='Download']"));
//
//		JavascriptExecutor click_download  = (JavascriptExecutor) driver;
//		click_download.executeScript("arguments[0].click();", download);
//
//
//
//		//click on the view comment
//		Thread.sleep(3000);
//		WebElement view_comment=driver.findElement(By.xpath("//i[@class='fas fa-comment is-cursor-pointer fa-2x mx-1 text-primary']"));
//		JavascriptExecutor click_comment= (JavascriptExecutor) driver;
//		click_comment.executeScript("arguments[0].click();", view_comment);
//
//		//enter the comment in text
//		Thread.sleep(3000);
//		WebElement comment_text=driver.findElement(By.xpath("//textarea[@id='CommentsText']"));
//		comment_text.sendKeys("QA_test");
//
//
//		//click on save
//		driver.findElement(By.xpath("//div[@id='CommentDialogue']/descendant::button[text()='Save']")).click();
//


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


		//click on the all teams check boxes
		WebElement click_all_teams=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

		Actions act = new Actions(driver);
		act.doubleClick(click_all_teams).perform();



		//enter the start time, end time , working hours

		List<WebElement> all_timings=driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int D = 1; D <= all_timings.size(); D++) 
		{

			WebElement click_menu=driver.findElement(By.xpath("((//input[@type='checkbox'])["+D+"])"));
			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", click_menu);



			try
			{
				//enter the start time

				WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement starttime1=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[3]/descendant::input[@type='text']")));
				starttime1.sendKeys(Keys.CONTROL, Keys.chord("a"));
				starttime1.sendKeys(Keys.BACK_SPACE);
				starttime1.sendKeys("09:00");


				//enter the end time

				WebElement endtime=driver.findElement(By.xpath("//tbody/tr/td[4]/descendant::input[@type='text']"));
				endtime.sendKeys(Keys.CONTROL, Keys.chord("a"));
				endtime.sendKeys(Keys.BACK_SPACE);
				endtime.sendKeys("18:00");


				//enter the working hours
				WebElement working_hours=driver.findElement(By.xpath("//tbody/tr/td[5]/descendant::input[@type='text']"));
				working_hours.sendKeys(Keys.CONTROL, Keys.chord("a"));
				working_hours.sendKeys(Keys.BACK_SPACE);
				working_hours.sendKeys("07.00");


				//click on list
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[7]/descendant::button[@class='btn btn-primary']")).click();


				//click on try recommendations
				Thread.sleep(5000);
				WebElement try_recommendations=driver.findElement(By.xpath("//button[text()='Try Recommendation']"));
				JavascriptExecutor click_try = (JavascriptExecutor) driver;
				click_try.executeScript("arguments[0].click();", try_recommendations);


				//click on try more recommendations
				Thread.sleep(5000);
				WebElement try_more=driver.findElement(By.xpath("//button[text()='Try More Recommendations']"));
				JavascriptExecutor click_try_more = (JavascriptExecutor) driver;
				click_try_more.executeScript("arguments[0].click();", try_more);


				//clear recommendations
				Thread.sleep(3000);
				WebElement clear_recommendations=driver.findElement(By.xpath("//button[text()='Clear Recommendations']"));
				act.click(clear_recommendations).build().perform();

				//click on ok to clear recommendations

				WebElement ok=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
				JavascriptExecutor click_ok = (JavascriptExecutor) driver;
				click_ok.executeScript("arguments[0].click();", ok);



				//scroll top bottm  to top
				Thread.sleep(5000);
				JavascriptExecutor top = (JavascriptExecutor) driver;
				top.executeScript("window.scrollTo(0, 0);");

			}
			catch(Exception e)

			{
				System.out.println("Exception is catched cooll move forward");
			}


		}





		//click on review and proceed

		WebElement review =driver.findElement(By.xpath("//button[contains(text(),'Review & Proceed')]"));
		JavascriptExecutor review_proceed = (JavascriptExecutor) driver;
		review_proceed.executeScript("arguments[0].click();", review);

		Thread.sleep(9000);                             


		//click on simulate outcome
		WebDriverWait outcome=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement simulate=outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ResetTeam-dialog']/following::button[text()='Simulate Outcome']")));
		JavascriptExecutor simulate1 = (JavascriptExecutor) driver;
		simulate1.executeScript("arguments[0].click();", simulate);






		// using window handler

		String mainWindowHandle211 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles211 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle1 : allWindowHandles211)
		{
			if (!handle1.equals(mainWindowHandle211))
			{


				//click on no validate later
				//	      					WebDriverWait later=new WebDriverWait(driver, Duration.ofSeconds(90));
				//	      					WebElement validate=later.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				//	      					JavascriptExecutor on = (JavascriptExecutor) driver;
				//	      					on.executeScript("arguments[0].click();", validate);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				Thread.sleep(9000);
				driver.close();				

			}
		}



	}

}

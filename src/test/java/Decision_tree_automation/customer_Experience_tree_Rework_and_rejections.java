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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customer_Experience_tree_Rework_and_rejections
{

	@Test
	public static void rework_rejections() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='205']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='205']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Rework & Rejections\n"+ "37.1% | 31.4%";
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



		//click on rework and reductions
		WebDriverWait rework=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement reductions=rework.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/CustomerExperienceRework\']")));
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
				break;

			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");

		Thread.sleep(1000);
		int scroll_height = 500;
		JavascriptExecutor js1234=(JavascriptExecutor) driver;
		js1234.executeScript("window.scrollBy(0,"+scroll_height+ ")");


		
		

		//click on download button
		WebElement downalod_button=driver.findElement(By.xpath("//div[@id='actionmenu']/descendant::button[@title='Download']"));
		JavascriptExecutor button = (JavascriptExecutor) driver;
		button.executeScript("arguments[0].click();", downalod_button);

		//scroll bottom to top
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");


		//Enter the text in the search bar
		WebDriverWait search=new WebDriverWait(driver, Duration.ofSeconds(600));
		WebElement click_on_search=search.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ActivitySearchText']")));

		Actions search_click=new Actions(driver);
		search_click.click(click_on_search).build().perform();
		click_on_search.sendKeys("Confirm Appraisal Meets Mortgage Loan Guidelines");


		Thread.sleep(1000);
		//click on search
		WebElement search_symbol =driver.findElement(By.xpath("//i[@class='fas fa-search']"));

		//click on search symbol
		Actions act_click=new Actions(driver);
		act_click.click(search_symbol).perform();

		//click on clear text
		WebElement clear_text=driver.findElement(By.xpath("//button[text()='Clear']"));
		search_click.click(clear_text).build().perform();



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



		// click on the all the process maps view 

		List<WebElement> view = driver.findElements(By.xpath("//tr[@class='info']"));
		Thread.sleep(3000);

		for( int j=1; j<=view.size(); j++)
		{

			//click on view 
			WebElement click_view=driver.findElement(By.xpath("//tr[@class='info']["+j+"]//td[8]//a"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(click_view).build().perform();
			Thread.sleep(2000);
		}

//
//			   List<WebElement> download_button=driver.findElements(By.xpath("//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')]"));
//
//			   System.out.println("downalod_button");
//			   for (int k = 1; k <=download_button.size() ; k++)
//			   {
//
//				WebElement download=driver.findElement(By.xpath("(//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')])["+k+"]"));
//
//				JavascriptExecutor downlaod_click = (JavascriptExecutor) driver;
//				downlaod_click.executeScript("arguments[0].click();", download);
//
//
//				Thread.sleep(1000);
//				System.out.println("Hi");
//				//click on downlaod as pdf
//				
//				List<WebElement> download_pdf=driver.findElements(By.xpath("//a[text()='Download as PDF']"));
//				for (int r = 1; r <= download_pdf.size(); r++) 
//				{
//				  WebElement click_pdf=	driver.findElement(By.xpath("(//a[text()='Download as PDF'])["+r+"]"));
//				  
//				  JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//				  pdf_click.executeScript("arguments[0].click();", click_pdf);
//				}
//
//
//		
//				List<WebElement> download_tgf=driver.findElements(By.xpath("//a[text()='Download as TGF']"));
//				for (int a = 1; a <= download_tgf.size(); a++)
//				{
//					WebElement click_tgf=driver.findElement(By.xpath("(//a[text()='Download as TGF'])["+a+"]"));
//
//					JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//					pdf_click.executeScript("arguments[0].click();", click_tgf);
//				}
//
//				Thread.sleep(5000);
//				
//				
//
//			}
//		}

		//select the drop down menu to select the different drop down menu
		
		Select objSelect =new Select(driver.findElement(By.xpath("//select[@class='form-select'][1]")));
		objSelect.selectByVisibleText("Rework Effort");
		Thread.sleep(4000);
		objSelect.selectByVisibleText("Has Controls");
		Thread.sleep(4000);
		objSelect.selectByVisibleText("Cycle Time");
		
		//select the second drop down menu
		
		Select second_another_dropmenu =new Select(driver.findElement(By.xpath("//select[@class='form-select'][2]")));
		second_another_dropmenu.selectByVisibleText("Descending");
		Thread.sleep(4000);
		second_another_dropmenu.selectByVisibleText("Ascending");
		Thread.sleep(4000);
		

		
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
		
		
		
		
		
		// click on the solution option


		List<WebElement> solution_option = driver.findElements(By.xpath("//tr[@class='info']"));
		Thread.sleep(3000);

		for( int o=1; o<=solution_option.size(); o++)
		{

			//click on view 
			WebElement solution_data=driver.findElement(By.xpath("//tr[@class='info']["+o+"]//td[7]//a"));
			
			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(solution_data).build().perform();
			Thread.sleep(2000);
					
			
			//click on close the notification

			WebElement close=	driver.findElement(By.xpath("//div[@id='Rwk_NVAActivitiesDialogue']/descendant::button[text()='Close']"));

			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", close);
			
            Thread.sleep(3000);
            System.out.println("close count");

			
		}
			 	
		

		//clicking on the process map
		JavascriptExecutor click_process_map = (JavascriptExecutor)driver;
		click_process_map.executeScript("model.Rwk_ActivityClick(model.ReworkPaths()[0].Decision, model.ReworkPaths()[0])");



		//click on change decision percentage
		Thread.sleep(2000);
		WebDriverWait decision=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage=decision.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Change Decision Percentage']")));
		JavascriptExecutor change = (JavascriptExecutor) driver;
		change.executeScript("arguments[0].click();", percentage);

		//click on training
		WebDriverWait training=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_training=training.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training']")));
		JavascriptExecutor train = (JavascriptExecutor) driver;
		train.executeScript("arguments[0].click();", click_training);

		//click on training requried
		WebDriverWait requried=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_training_required=requried.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='<< Training Required for all Predecessor Activities']")));
		JavascriptExecutor click_one = (JavascriptExecutor) driver;
		click_one.executeScript("arguments[0].click();", click_training_required);
		

		//click on proceed
		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Rwk_ProbAlongwithDialogue']/descendant::button[text()='Proceed']")));
		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
		proceed_click.executeScript("arguments[0].click();", click_proceed);

		//change the decision probability
		driver.findElement(By.xpath("//input[contains(@id, 'probabilityrow0')]")).clear();

		//change the decision percentage
		Thread.sleep(3000);
		WebElement decision_percentage=driver.findElement(By.xpath("//input[contains(@id, 'probabilityrow0')]"));
		decision_percentage.sendKeys("1");
		

		//click on enter
		Actions enter= new Actions(driver);
		enter.sendKeys(Keys.ENTER).build().perform();

		//Add the list
		WebDriverWait addlist=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_addlist=addlist.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-warning' and contains(text(),'Add to List') ])")));
		JavascriptExecutor list = (JavascriptExecutor) driver;
		list.executeScript("arguments[0].click();", click_addlist);

		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor js12341=(JavascriptExecutor) driver;
		js12341.executeScript("window.scrollTo(0,0);");



		//click on Review and proceed
		WebDriverWait insorce233=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement insorce891=insorce233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
		JavascriptExecutor insorce711 = (JavascriptExecutor) driver;
		insorce711.executeScript("arguments[0].click();", insorce891);



		//click on simulate outcome
		WebDriverWait outcome=new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement simulate=outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor simulate_click = (JavascriptExecutor) driver;
		simulate_click.executeScript("arguments[0].click();", simulate);


		//close rework and reduction window using window handler

		String mainWindowHandle2 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles2 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle : allWindowHandles2)
		{
			if (!handle.equals(mainWindowHandle2))
			{

				//driver.switchTo().window(handle);
				//click on view results
//				WebDriverWait click_proceed_validation=new WebDriverWait(driver, Duration.ofSeconds(100));
//				WebElement click_optimization_later=click_proceed_validation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//				JavascriptExecutor optimization = (JavascriptExecutor) driver;
//				optimization.executeScript("arguments[0].click();", click_optimization_later);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle2);
				driver.navigate().refresh();
				
				
				JavascriptExecutor click_javascript_scroll = (JavascriptExecutor) driver;
				click_javascript_scroll.executeScript("window.scrollTo(0, 0);");
			    Thread.sleep(3000);
				
				driver.close();

			}
		}




	}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//clicking on the process map
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("model.Rwk_ActivityClick(model.ReworkPaths()[0].Decision, model.ReworkPaths()[0])");
//
//
//		//click on change decision percentage
//		Thread.sleep(2000);
//		WebDriverWait decision=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement percentage=decision.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Change Decision Percentage']")));
//		JavascriptExecutor change = (JavascriptExecutor) driver;
//		change.executeScript("arguments[0].click();", percentage);
//
//		//click on training
//		WebDriverWait training=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement click_training=training.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training']")));
//		JavascriptExecutor train = (JavascriptExecutor) driver;
//		train.executeScript("arguments[0].click();", click_training);
//
//
//		//click Decision Activity
//		WebDriverWait Activity=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement Decision=Activity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training Required for Decision Activity >>']")));
//		JavascriptExecutor Decision_Activity  = (JavascriptExecutor) driver;
//		Decision_Activity.executeScript("arguments[0].click();", Decision);
//		//
//		//		//click on raionallize systems
//		//		WebDriverWait wait11111111=new WebDriverWait(driver, Duration.ofSeconds(30));
//		//		WebElement insorce6781111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Rationalize systems']")));
//		//		JavascriptExecutor insorce11111 = (JavascriptExecutor) driver;
//		//		insorce11111.executeScript("arguments[0].click();", insorce6781111);
//		//
//		//		//click on add decision tree actvity
//		//		WebDriverWait wait888=new WebDriverWait(driver, Duration.ofSeconds(30));
//		//		WebElement insorce67811111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Decision Activity >>']")));
//		//		JavascriptExecutor insorce111111 = (JavascriptExecutor) driver;
//		//		insorce111111.executeScript("arguments[0].click();", insorce67811111);
//
//		//click on proceed
//		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Rwk_ProbAlongwithDialogue']/descendant::button[text()='Proceed']")));
//		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
//		proceed_click.executeScript("arguments[0].click();", click_proceed);
//
//
//
//		//enter the input data
//		WebDriverWait input=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement input_data=input.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='probabilityrow0']")));
//		input_data.clear();
//		Thread.sleep(3000);
//		input_data.sendKeys("1");
//		input_data.click();
//
//		//click on enter
//		Actions enter= new Actions(driver);
//		enter.sendKeys(Keys.ENTER).build().perform();
//
//		//Add the list
//		WebDriverWait addlist=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement click_addlist=addlist.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-warning' and contains(text(),'Add to List') ])")));
//		JavascriptExecutor list = (JavascriptExecutor) driver;
//		list.executeScript("arguments[0].click();", click_addlist);
//
//		//sroll bottom to up
//		Thread.sleep(5000);
//		JavascriptExecutor js12341=(JavascriptExecutor) driver;
//		js12341.executeScript("window.scrollTo(0,0);");
//
//
//
//		//click on Review and proceed
//		WebDriverWait Review=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement review_proceed=Review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
//		JavascriptExecutor click_review = (JavascriptExecutor) driver;
//		click_review.executeScript("arguments[0].click();", review_proceed);
//
//
//
//		//click on simulate outcome
//		WebDriverWait outcome=new WebDriverWait(driver, Duration.ofSeconds(40));
//		WebElement simulate=outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
//		JavascriptExecutor simulate_click = (JavascriptExecutor) driver;
//		simulate_click.executeScript("arguments[0].click();", simulate);
//
//
//
//
//		//close rework and reduction window using window handler
//
//		String mainWindowHandle2 = driver.getWindowHandle();
//		//System.out.println(mainWindowHandle);
//
//		Set<String> allWindowHandles2 = driver.getWindowHandles();
//		//System.out.println(allWindowHandles2);
//
//		for (String handle : allWindowHandles2)
//		{
//			if (!handle.equals(mainWindowHandle2))
//			{
//
//				//driver.switchTo().window(handle);
//				//click on view results
//				//					WebDriverWait click_proceed_validation=new WebDriverWait(driver, Duration.ofSeconds(100));
//				//					WebElement click_optimization_later=click_proceed_validation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//				//					JavascriptExecutor optimization = (JavascriptExecutor) driver;
//				//					optimization.executeScript("arguments[0].click();", click_optimization_later);
//				Thread.sleep(2000);
//				driver.navigate().back();
//				driver.switchTo().window(mainWindowHandle2);
//				driver.close();				
//
//			}
//		}


	}


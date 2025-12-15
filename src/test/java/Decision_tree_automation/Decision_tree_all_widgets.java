package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

public class Decision_tree_all_widgets 


{
	
	
	
	@Test(priority=1)
	public static void rework_rejections() throws InterruptedException, FileNotFoundException
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
		WebDriverWait click_wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_project=click_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);
		
		
		

		
		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();



		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");



		//click on rework and reductions
		WebDriverWait rework=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement rework_and_reductions=rework.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/ReworkReduction']")));
		Actions action_click=new Actions(driver);
		action_click.click(rework_and_reductions).perform();
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
		decision_percentage.sendKeys("99");
		

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


//		//close rework and reduction window using window handler

		String mainWindowHandle2 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles2 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle : allWindowHandles2)
		{
			if (!handle.equals(mainWindowHandle2))
			{

//				
//				//driver.switchTo().window(handle);
//				//click on view results
				WebDriverWait click_proceed_validation=new WebDriverWait(driver, Duration.ofSeconds(100));
				WebElement click_optimization_later=click_proceed_validation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor optimization = (JavascriptExecutor) driver;
				optimization.executeScript("arguments[0].click();", click_optimization_later);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle2);
				driver.navigate().refresh();
				driver.close();
				Thread.sleep(5000);
				
				
				

			}
		}

	
	}
	
	@Test(priority=2)
	public static void effort_nva() throws InterruptedException, FileNotFoundException
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
		WebDriverWait click_wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_project=click_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);
		
		
		

		
		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();



		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		
		
		

	    driver.navigate().to("https://pbl.3-cubed.com/Operations/NonProductivePath");

	    
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
		act_click.click(clear_text).build().perform();



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
		

		for( int j=1; j<=view.size(); j++)
		{

			//click on view 
			WebElement click_view=driver.findElement(By.xpath("(//tbody//td//a)["+j+"]"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(click_view).build().perform();




//			List<WebElement> download_button=driver.findElements(By.xpath("//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')]"));
//
//			System.out.println("downalod_button");
//			for (int k = 1; k <=download_button.size() ; k++)
//			{
//
//				WebElement download=driver.findElement(By.xpath("(//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')])["+k+"]"));
//
//				JavascriptExecutor downlaod_click = (JavascriptExecutor) driver;
//				downlaod_click.executeScript("arguments[0].click();", download);
//
//
//
//				System.out.println("Hi");
//				//click on downlaod as pdf
//
//				List<WebElement> download_pdf=driver.findElements(By.xpath("//a[text()='Download as PDF']"));
//				for (int r = 1; r <= download_pdf.size(); r++) 
//				{
//					WebElement click_pdf=	driver.findElement(By.xpath("(//a[text()='Download as PDF'])["+r+"]"));
//
//					JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//					pdf_click.executeScript("arguments[0].click();", click_pdf);
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
//
//
//
//
//			}
		}
		

		//select the drop down menu to select the different drop down menu

		Select objSelect =new Select(driver.findElement(By.xpath("//select[@class='form-select'][1]")));
		objSelect.selectByVisibleText("Non-value Added Activities");
		Thread.sleep(4000);
		objSelect.selectByVisibleText("Action");
		Thread.sleep(4000);
		objSelect.selectByVisibleText("Routing");
		Thread.sleep(4000);
		objSelect.selectByVisibleText("Reporting");


		//select the second drop down menu

		Select second_another_dropmenu =new Select(driver.findElement(By.xpath("//select[@class='form-select'][2]")));
		second_another_dropmenu.selectByVisibleText("Effort (hrs)");
		Thread.sleep(4000);
		second_another_dropmenu.selectByVisibleText("No. of Activities");
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


		
		//click on all proceed  
		
	
		List<WebElement> click_all_proceeds=driver.findElements(By.xpath("//button[text()='Proceed']"));
		for (int a = 1; a <= click_all_proceeds.size(); a++) 
		{
			WebElement click_pdf=	driver.findElement(By.xpath("(//button[text()='Proceed'])["+a+"]"));

			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", click_pdf);
			
			Thread.sleep(3000);
		}




		//click on all proceed

		WebDriverWait insorce704=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement click_on_proceed=insorce704.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[1]/tbody[1]/tr[3]/td[2]/descendant::button")));
		JavascriptExecutor just_click = (JavascriptExecutor) driver;                                       
		just_click.executeScript("arguments[0].click();", click_on_proceed);
		Thread.sleep(2000);
		JavascriptExecutor jsinsorce324=(JavascriptExecutor) driver;
		jsinsorce324.executeScript("window.scrollTo(0,450);");
		//click on process map

		JavascriptExecutor process_map = (JavascriptExecutor)driver;
		process_map.executeScript("model.NVA_ActivitySelection(model.AutoSortFilteredList()[0].RoutingActs[0], model.AutoSortFilteredList()[0])");

		//clcik on yes automate
		WebDriverWait yes=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement yes_click_automate=yes.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Automate']")));
		JavascriptExecutor automate_click = (JavascriptExecutor) driver;
		automate_click.executeScript("arguments[0].click();", yes_click_automate);

		//click on drop down menu
		WebDriverWait click_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement selectdropdown=click_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::select[@class='form-select']")));
		Select select=new Select(selectdropdown);
		select.selectByIndex(2);


		//click on automate
		WebDriverWait automate=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_automate=automate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::button[contains(text(),'Automate')]")));
		JavascriptExecutor click_automate_click = (JavascriptExecutor) driver;
		click_automate_click.executeScript("arguments[0].click();", click_automate);

		//click on another drop down menu
		WebDriverWait click_wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_table=click_wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ShowSystemsforLegacyDialogue']/following::select[@class='form-select']")));

		Select object=new Select(click_table);
		object.selectByVisibleText("Scanned Image");




		//enter the reduced percentage
		WebDriverWait reduced=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement reduced_percentage=reduced.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='AddtoCartDialogue']/descendant::input[@class='form-control']")));
		reduced_percentage.clear();
		reduced_percentage.sendKeys("11");

		//click on add Automation cost button
		WebDriverWait insorcetest3=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test3=insorcetest3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
		test3.click();


		//click on check box
		WebDriverWait check=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_check_box=check.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/descendant::input[@type='checkbox']")));
		JavascriptExecutor box = (JavascriptExecutor) driver;
		box.executeScript("arguments[0].click();", click_check_box);




		//enter the depreciation in years
		WebDriverWait depreciation=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test5111=depreciation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]/descendant::input[@type='number']")));
		test5111.sendKeys("60");

		//enter the AMC in percentage
		WebDriverWait AMC=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement AMC_in_percentage=AMC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[9]/input[@type='number']")));
		AMC_in_percentage.sendKeys("75");

		//click on add list
		WebDriverWait click_add=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement add=click_add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
		JavascriptExecutor list_click = (JavascriptExecutor) driver;
		list_click.executeScript("arguments[0].click();", add);


		//click on add to cart
		WebDriverWait cart=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement cart_click=cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
		JavascriptExecutor insorce_cart = (JavascriptExecutor) driver;
		insorce_cart.executeScript("arguments[0].click();", cart_click);


		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor js123411=(JavascriptExecutor) driver;
		js123411.executeScript("window.scrollTo(0,0);");

		//click on Review and proceed
		WebDriverWait review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Review_and_proceed=review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
		JavascriptExecutor proceed_review = (JavascriptExecutor) driver;
		proceed_review.executeScript("arguments[0].click();", Review_and_proceed);


		//click on simulate outcome
		WebDriverWait outcome_simulate=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement simulate_outcome=outcome_simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor click_outcome = (JavascriptExecutor) driver;                               
		click_outcome.executeScript("arguments[0].click();", simulate_outcome);

		//close NonProductivePath window using window handler


//		String mainWindowHandle21 = driver.getWindowHandle();
////		//System.out.println(mainWindowHandle);
//
//		Set<String> allWindowHandles21 = driver.getWindowHandles();
//		//System.out.println(allWindowHandles2);
//
//		for (String handle1 : allWindowHandles21)
//		{
//			if (!handle1.equals(mainWindowHandle21))
//			{

				//driver.switchTo().window(handle);
				//click on view results
				WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement result_click=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_on_result = (JavascriptExecutor) driver;
				click_on_result.executeScript("arguments[0].click();", result_click);
				//						
				Thread.sleep(2000);
//				driver.navigate().back();
//				driver.switchTo().window(mainWindowHandle21);
				driver.close();
				


//			}
//		}


	}
	
	@Test(priority=3)
	public static void effort_automation() throws InterruptedException, FileNotFoundException
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
		WebDriverWait click_wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_project=click_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);
		
		
		

		
		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();



		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		
		
		driver.navigate().to("https://pbl.3-cubed.com/Operations/PathAutomation");
		
		
		

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
		WebElement search_symbol =driver.findElement(By.xpath("//i[@class='fas fa-search fa-white']"));

		//click on search symbol
		Actions act_click=new Actions(driver);
		act_click.click(search_symbol).perform();

		//click on clear text
		WebElement clear_text=driver.findElement(By.xpath("//button[text()='Clear']"));
		act_click.click(clear_text).build().perform();



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
		

		for( int j=1; j<=view.size(); j++)
		{

			//click on view 
			WebElement click_view=driver.findElement(By.xpath("(//tbody//td//a)["+j+"]"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(click_view).build().perform();

				


//
//			List<WebElement> download_button=driver.findElements(By.xpath("//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')]"));
//
//			System.out.println("downalod_button");
//			for (int k = 1; k <=download_button.size() ; k++)
//			{
//
//				WebElement download=driver.findElement(By.xpath("(//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')])["+k+"]"));
//
//				JavascriptExecutor downlaod_click = (JavascriptExecutor) driver;
//				downlaod_click.executeScript("arguments[0].click();", download);
//
//
//
//				System.out.println("Hi");
//				//click on downlaod as pdf
//
//				List<WebElement> download_pdf=driver.findElements(By.xpath("//a[text()='Download as PDF']"));
//				for (int r = 1; r <= download_pdf.size(); r++) 
//				{
//					WebElement click_pdf=	driver.findElement(By.xpath("(//a[text()='Download as PDF'])["+r+"]"));
//
//					JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//					pdf_click.executeScript("arguments[0].click();", click_pdf);
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
//
//


			//}
		

		//select the drop down menu to select the different drop down menu

		Select objSelect =new Select(driver.findElement(By.xpath("//select[@class='form-select'][1]")));
		objSelect.selectByVisibleText("No of Activities");
		
		objSelect.selectByVisibleText("Effort");
		
		objSelect.selectByVisibleText("Office Automation Benefit");
		
		objSelect.selectByVisibleText("Robotic Process Automation Benefit");
		
		objSelect.selectByVisibleText("Requires Digitization Benefit");
		
		objSelect.selectByVisibleText("Machine Learning / AI Benefit");
		
		objSelect.selectByVisibleText("No of Milestones");
		
		objSelect.selectByVisibleText("No of Critical Activities");
		
		objSelect.selectByVisibleText("No of Peak Activities");
		
		
		
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


		

		//clicking on the process map
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("model.Auto_ActivityClick(model.Auto_AllPaths[0].ActionActs[0],model.Auto_AllPaths[0])");


		

		//click on drop down menu
		WebDriverWait click_drop_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Automatic_drop_menu=click_drop_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::select[@class='form-select']")));
		Select auto_Automatic_drop_menu=new Select(Automatic_drop_menu);
		auto_Automatic_drop_menu.selectByIndex(2);

		//click on automate
		WebDriverWait automate_the_button=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_automate_button=automate_the_button.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::button[contains(text(),'Automate')]")));
		JavascriptExecutor button_automate = (JavascriptExecutor) driver;                                                       
		button_automate.executeScript("arguments[0].click();", click_automate_button);
		


		WebDriverWait click_on_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_on_drop_menu=click_on_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ShowSystemsforLegacyDialogue']/following::select[@class='form-select']")));
		Select select_menu=new Select(click_on_drop_menu);
		select_menu.selectByVisibleText("Scanned Image");



		//enter the reduced percentage
		WebDriverWait click_on_reduced=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage_reduced=click_on_reduced.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='AddtoCartDialogue']/descendant::input[@class='form-control']")));
		percentage_reduced.clear();
		percentage_reduced.sendKeys("51");


		//click on add Automation cost button
		WebDriverWait Automation_cost=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement button_cost=Automation_cost.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
		JavascriptExecutor add_automation_click = (JavascriptExecutor) driver;
		add_automation_click.executeScript("arguments[0].click();", button_cost);

		Thread.sleep(4000);				
		//click on check box
		WebDriverWait select_check=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Check_box=select_check.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/descendant::input[@type='checkbox']")));
		JavascriptExecutor click_on_check_box = (JavascriptExecutor) driver;
		click_on_check_box.executeScript("arguments[0].click();", Check_box);

		//enter the depreciation in years
		WebDriverWait depreciation_years=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement years_click=depreciation_years.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]/descendant::input[@type='number']")));
		years_click.sendKeys("34");

		//click on price


		//enter the AMC in percentage
		WebDriverWait amc_percentage=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage_click=amc_percentage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[9]/descendant::input[@type='number']")));
		percentage_click.sendKeys("25");
		

		//click on add list
		WebDriverWait add_list=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_add_list=add_list.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
		JavascriptExecutor click_list = (JavascriptExecutor) driver;
		click_list.executeScript("arguments[0].click();", click_add_list);

		//click on add to cart
		WebDriverWait add_cart=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement cart_click_add=add_cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
		JavascriptExecutor go_to_cart = (JavascriptExecutor) driver;
		go_to_cart.executeScript("arguments[0].click();", cart_click_add);


		//click on Review and proceed
		WebDriverWait click_on_review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_on_cart=click_on_review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
		JavascriptExecutor click_proceed_review = (JavascriptExecutor) driver;
		click_proceed_review.executeScript("arguments[0].click();", click_on_cart);


		//click on simulate outcome
		WebDriverWait click_simulate_outcome=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement click_simulate=click_simulate_outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor outcome_click = (JavascriptExecutor) driver;
		outcome_click.executeScript("arguments[0].click();", click_simulate);


		//close path automation window using window handler
		

		String mainWindowHandle211 = driver.getWindowHandle();
//		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles211 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle1 : allWindowHandles211)
		{
			if (!handle1.equals(mainWindowHandle211))
			{

//				//driver.switchTo().window(handle);
//				//click on view results
				//						WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
				//						WebElement click_result=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				//						JavascriptExecutor result_click = (JavascriptExecutor) driver;
				//						result_click.executeScript("arguments[0].click();", click_result);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				
				
		
			}
		
			}
		}
		
	}

	
	@Test(priority=4)
	public static void control_redunacy() throws InterruptedException, FileNotFoundException
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
		WebDriverWait click_wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_project=click_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);
		
		
		

		
		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();



		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		
		
		
		
		
		
		driver.navigate().to("https://pbl.3-cubed.com/Operations/ControlsPath");
		
		
		

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

		
		
		//click on show bubble chat
		WebElement Show_bubble_chat =	driver.findElement(By.xpath("//button[contains(@id,'btnBubblechart')]"));
		JavascriptExecutor click_Show_bubble_chat = (JavascriptExecutor) driver;
		click_Show_bubble_chat.executeScript("arguments[0].click();", Show_bubble_chat);
		
		
		
		
		
		//click on process map			
		JavascriptExecutor click_on_process_map = (JavascriptExecutor)driver;
		click_on_process_map.executeScript("LODMap.ControlClick(LODMap.filteredLOD()[0],LODMap.filteredLOD()[0].controlActs[0].ID)");

		
		
		
		//click on delete button
		WebDriverWait delete=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_delete=delete.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
		JavascriptExecutor delete_button = (JavascriptExecutor) driver;
		delete_button.executeScript("arguments[0].click();", click_delete);

		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor insorce789=(JavascriptExecutor) driver;
		insorce789.executeScript("window.scrollTo(0,0);");

		//click on Review and proceed
		WebDriverWait review_proceed=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement insorce_review=review_proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
		JavascriptExecutor click_review_proceed = (JavascriptExecutor) driver;
		click_review_proceed.executeScript("arguments[0].click();", insorce_review);


		
		
		Thread.sleep(10000);

		
		
		//click on simulate outcome
		WebDriverWait simulate_outcome_click=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement click_outcomes=simulate_outcome_click.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cart-activities']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor proceed_outcome = (JavascriptExecutor) driver;
		proceed_outcome.executeScript("arguments[0].click();", click_outcomes);
		
		
//
		//close control and redundancy
		

//		String mainWindowHandle2111 = driver.getWindowHandle();
//		//System.out.println(mainWindowHandle);
//
//		Set<String> allWindowHandles2111 = driver.getWindowHandles();
//		//System.out.println(allWindowHandles2);
//
//		for (String handle1 : allWindowHandles2111)
//		{
//			if (!handle1.equals(mainWindowHandle2111))
//			{
//
////				//driver.switchTo().window(handle);
////
////				//						//click on view results
										WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
										WebElement click_result=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View Result']")));
										JavascriptExecutor result_click = (JavascriptExecutor) driver;
										result_click.executeScript("arguments[0].click();", click_result);
				Thread.sleep(2000);
//				driver.navigate().back();
//				driver.switchTo().window(mainWindowHandle2111);
				
				driver.close();
//				
//
//
//
//			}

		}
	
	@Test(priority=5)
	public static void Competency_work_allocation_skillingwork_allocation_skilling() throws InterruptedException, FileNotFoundException
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

		if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) {
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();


		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Competency and Compensation\n"+ "USD 58.2K\n" + "Fact Based - 53.4%\n"+ "Human Judgement - 41.1%\n" + "Computation - 5.7%";
		String actualValue=node;
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Competency and Compensation:Expected data and Actual data are not Matched");
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
		Thread.sleep(1000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(1000);

		//click on team location
		WebDriverWait team=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement location=team.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Work Allocation & Skilling')]")));
		Actions action1=new Actions(driver);
		action1.click(location).perform();


		//switch to child window

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

	@Test(priority=6)
	public static void competancyandcompensation() throws InterruptedException, FileNotFoundException 
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
			if(AA.equals(WelcomePage)) {
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3454: Automation__decision__tree__testing']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();


		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Competency and Compensation\n"+ "USD 58.2K\n" + "Fact Based - 53.4%\n"+ "Human Judgement - 41.1%\n" + "Computation - 5.7%";
		String actualValue=node;
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Competency and Compensation:Expected data and Actual data are not Matched");
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


		Thread.sleep(15000);
		//scroll top to bottom
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, 5000);");
		
		

		//click on team competancy cost
		
		
		WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement click_on_workallocation_skilling=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/TeamCompetency']")));
		Actions action1=new Actions(driver);
		
		action1.click(click_on_workallocation_skilling).perform();
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
        	
        	
    		//Enter the new aht
    		Thread.sleep(3000);
    		WebDriverWait new_aht=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement enter_new_aht=new_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
    		JavascriptExecutor insorce52178 = (JavascriptExecutor) driver;
    		insorce52178.executeScript("arguments[0].click();", enter_new_aht);
    		enter_new_aht.clear();
    		enter_new_aht.sendKeys("10");
    
    		//click on activity name check box
    		Thread.sleep(3000);
    		WebDriverWait select_activites=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement select_all_activites=select_activites.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
    		JavascriptExecutor insorce52179 = (JavascriptExecutor) driver;
    		insorce52179.executeScript("arguments[0].click();", select_all_activites);

      
        	//click on increase AHT
    		Thread.sleep(3000);
    		WebDriverWait increase=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement increase_AHT=increase.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Increase AHT')]")));
    		JavascriptExecutor insorce520 = (JavascriptExecutor) driver;
    		insorce520.executeScript("arguments[0].click();", increase_AHT);

    		//click on save and continue
    		Thread.sleep(3000);
    		WebDriverWait saves=new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement save_continue=saves.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Continue')]")));
    		JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
    		click_save_continue.executeScript("arguments[0].click();", save_continue);

    		//select the drop down menu activity
    		Thread.sleep(3000);
    		WebDriverWait select_menu=new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement select_drop_menu=select_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
    		Select select_drop_down=new Select(select_drop_menu);
    		select_drop_down.selectByIndex(2);
    		
    		
    		//click on add to cart
    		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement add_to_cart=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Cart']")));
    
    		add_to_cart.click();
    	
        	
        }

		
		
		
		
		
		
		
		

//		//click on save and proceed
//		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(100));
//		WebElement saveandproceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"SalariesDialogue\"]//parent::button[text()='Save & Proceed']")));
//		//Thread.sleep(5000);
////		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
////		proceed_click.executeScript("arguments[0].click();", saveandproceed);
//		saveandproceed.click();
//
//
//		//Enter the new aht
//		Thread.sleep(3000);
//		WebDriverWait new_aht=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_new_aht=new_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
//		JavascriptExecutor insorce52178 = (JavascriptExecutor) driver;
//		insorce52178.executeScript("arguments[0].click();", enter_new_aht);
//		enter_new_aht.clear();
//		enter_new_aht.sendKeys("10");
//
//		//click on activity name check box
//		Thread.sleep(3000);
//		WebDriverWait select_activites=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement select_all_activites=select_activites.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
//		JavascriptExecutor insorce52179 = (JavascriptExecutor) driver;
//		insorce52179.executeScript("arguments[0].click();", select_all_activites);

//		//click on increase AHT
//		Thread.sleep(3000);
//		WebDriverWait increase=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement increase_AHT=increase.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Increase AHT')]")));
//		JavascriptExecutor insorce520 = (JavascriptExecutor) driver;
//		insorce520.executeScript("arguments[0].click();", increase_AHT);
//
//		//click on save and continue
//		Thread.sleep(3000);
//		WebDriverWait saves=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement save_continue=saves.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Continue')]")));
//		JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
//		click_save_continue.executeScript("arguments[0].click();", save_continue);
//
//		//select the drop down menu activity
//		Thread.sleep(3000);
//		WebDriverWait select_menu=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement select_drop_menu=select_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
//		Select select_drop_down=new Select(select_drop_menu);
//		select_drop_down.selectByIndex(2);

//		//select another drop down menu
//		Thread.sleep(5000);
//		WebDriverWait wait67332212=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement insorce50072212=wait67332212.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='form-group']//following-sibling::select)[2]")));
//		Select objSelect1 =new Select(insorce50072212);
//		objSelect1.selectByVisibleText("Human Judgement");

//		//scroll top to bottom
//		WebDriverWait top=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement scroll_top_bottom=top.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to Cart')]")));
//		//actions double click
//		Actions addcart=new Actions(driver);
//		addcart.doubleClick(scroll_top_bottom).build().perform();
		
//		JavascriptExecutor insorce7862 = (JavascriptExecutor) driver;
//		insorce7862.executeScript("arguments[0].scrollIntoView(true);",add_cart);

		
//		//click on add to cart
//		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement add_to_cart=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Cart']")));
//		JavascriptExecutor click_add_cart = (JavascriptExecutor) driver;
//		click_add_cart.executeScript("arguments[0].click();", add_to_cart);
//
//		//double click using the actions
//		Actions object=new Actions(driver);
//		object.doubleClick(add_to_cart).build().perform();
		
//		
//		//click on another pencil 
//		WebDriverWait pencil=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_on_pencil=pencil.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[3]/td[4]/div[3]/i[1]")));
//		JavascriptExecutor click_icon = (JavascriptExecutor) driver;
//		click_icon.executeScript("arguments[0].click();", click_on_pencil);
//		
//					
//		//enter the salary
//		WebDriverWait Enter_salary=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_salary=Enter_salary.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/descendant::div[@class='col-sm-8']/descendant::input[@type='text']")));
//		JavascriptExecutor enter_salary_textbox = (JavascriptExecutor) driver;
//		enter_salary_textbox.executeScript("arguments[0].click();", enter_salary);
//		enter_salary.click();
//		enter_salary.clear();
//		enter_salary.sendKeys("650");
//		
//		//save and proceed
//		Thread.sleep(3000);
//		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SalariesDialogue']/descendant::button[text()='Save & Proceed']")));
//		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
//		proceed_click.executeScript("arguments[0].click();", click_proceed);
//		
//		//enter aht
//		WebDriverWait aht=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_aht=aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
//		JavascriptExecutor click_aht = (JavascriptExecutor) driver;
//		click_aht.executeScript("arguments[0].click();", enter_aht);
//		enter_aht.clear();
//		enter_aht.sendKeys("78");
//		
//		//select activity
//		WebDriverWait select_activity=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_select_activity=select_activity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
//		JavascriptExecutor click_on_selectactivity = (JavascriptExecutor) driver;
//		click_on_selectactivity.executeScript("arguments[0].click();", click_select_activity);
//		
		
//		//increase aht
//		WebElement click_on_aht=increase_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Increase AHT']")));
//		JavascriptExecutor insorce8997 = (JavascriptExecutor) driver;
//		insorce8997.executeScript("arguments[0].click();", click_on_aht);
//		
//		//click on save
//		WebDriverWait save_click=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_on_save_and_continue=save_click.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save & Continue']")));
//		JavascriptExecutor click_on_save = (JavascriptExecutor) driver;
//		click_on_save.executeScript("arguments[0].click();", click_on_save_and_continue);
//		
//		
//		//select the drop down menu activity
//		WebDriverWait click_second=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement click_second_dropdrown_menu=click_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
//		Select objSelect121 =new Select(click_second_dropdrown_menu);
//		Thread.sleep(3000);
//		objSelect121.selectByVisibleText("Computation");
//		
//		//scroll top to bottom
//		Thread.sleep(3000);
//		WebDriverWait top_bottom=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement top_to_bottom=top_bottom.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to Cart')]")));
//		JavascriptExecutor scroll_top_to_bottom = (JavascriptExecutor) driver;
//		scroll_top_to_bottom.executeScript("arguments[0].scrollIntoView(true);",top_to_bottom);
//
//		Thread.sleep(5000);
//		
//		//click on add to cart
//		
//		WebElement add_cart_1=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
//		JavascriptExecutor itemadd = (JavascriptExecutor) driver;
//		Thread.sleep(3000);
//		itemadd.executeScript("arguments[0].click();", add_cart_1);

	




		//click on review and proceed
		WebDriverWait wait000741=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement insorce345=wait000741.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Review & Proceed')]")));
		JavascriptExecutor insorce785 = (JavascriptExecutor) driver;
		insorce785.executeScript("arguments[0].click();", insorce345);

		//click on simualte outcome
		WebDriverWait wait678=new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement insorce980=wait678.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Simulate Outcome')])")));
		JavascriptExecutor insorce780 = (JavascriptExecutor) driver;
		insorce780.executeScript("arguments[0].click();", insorce980);


		//click on view result
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
				WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement proceed_optimization=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
				click_optimization.executeScript("arguments[0].click();", proceed_optimization);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle2);
				driver.close();			

			}
		}


	}
		

	@Test(priority=7)
	public static void Compentancy_Cost() throws InterruptedException, FileNotFoundException 
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3454: Automation__decision__tree__testing']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();


		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Competency and Compensation\n"+ "USD 58.2K\n" + "Fact Based - 53.4%\n"+ "Human Judgement - 41.1%\n" + "Computation - 5.7%";
		String actualValue=node;
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Competency and Compensation:Expected data and Actual data are not Matched");
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
		Thread.sleep(1000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");


		//click on team location
		WebDriverWait team_location=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement insorce5192=team_location.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/TeamLocation']")));
		Actions action1=new Actions(driver);
		action1.click(insorce5192).perform();
		Thread.sleep(10000);

		//switch to child window

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
		driver.findElement(By.xpath("//div[@id='CommentDialogue']/descendant::button[text()='Save']")).click();
	
		

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
				WebDriverWait click_continue=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement save_and_continue=click_continue.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-group mx-1']/descendant::button[@class='btn btn-primary'][normalize-space()='Save & Continue']")));

				JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
				pdf_click.executeScript("arguments[0].click();", save_and_continue);
				
				
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
				WebDriverWait save_continue=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement countinue=save_continue.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Cart-dialog']/descendant::button[text()='Save & Continue']")));
				JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
				click_save_continue.executeScript("arguments[0].click();", countinue);
		
			
				
				
				
				
				
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
				WebDriverWait click_save=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement just_save=click_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='LocationSaveContinue']")));
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
				
				WebElement close=driver.findElement(By.xpath("//a[@class='btn-close']"));
				JavascriptExecutor click_on_optmize = (JavascriptExecutor) driver;
				click_on_optmize.executeScript("arguments[0].click();", close);
		
		
				//click on review and proceed 
				WebDriverWait review=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement review_proceed=review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Review & Proceed')]")));
				JavascriptExecutor click_on_optmizes = (JavascriptExecutor) driver;
				click_on_optmizes.executeScript("arguments[0].click();", review_proceed);
		
				//click on simulate out come
				WebDriverWait click_simualte_outcome=new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement click_simualteoutcome=click_simualte_outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='TeamCartDialog']/descendant::button[text()='Simulate Outcome']")));
				click_simualteoutcome.click();
		
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
						WebDriverWait optmize=new WebDriverWait(driver, Duration.ofSeconds(90));
						WebElement clcik_optimize=optmize.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
						JavascriptExecutor click_on_optmizing = (JavascriptExecutor) driver;
						click_on_optmizing.executeScript("arguments[0].click();", clcik_optimize);
						Thread.sleep(10000);
						driver.navigate().back();
						driver.switchTo().window(mainWindowHandle211);
						driver.close();				

	}
}

	}			
			
				@Test
				public  static void component_cost() throws Exception
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
					if(AA.equals(WelcomePage)) {
						System.out.println("Login Success");
					}

					if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) {
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
					WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"3506: Automation_decision_tree_widget_Don't_make any changes\"]")));
					JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
					insorce1.executeScript("arguments[0].click();", insorce678);

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



					//here we need to compare the  peak and utlization  decision tree values
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
					driver.findElement(By.xpath("//h5[text()='Components']")).click();


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


					
					
					
					


					//enter the base cost per month
					Thread.sleep(3000);
					WebElement cost_month=driver.findElement(By.xpath("//div[@class='col-sm-8']/child::input[@type='text']"));
					
					// Create an Actions instance
			        Actions actions = new Actions(driver);
					
			        cost_month.sendKeys(Keys.CONTROL,"a");
			        cost_month.sendKeys(Keys.DELETE);
			        //send the cost per month
					cost_month.sendKeys("412000");





					//select the system and applications
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[contains(@id,'chkSelect')]")).click();

					//click on save and continue
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@id='LocationSaveContinue']")).click();

					//click on reviwe and proceed

					driver.findElement(By.xpath("//button[@id='btnAssignedList']")).click();

					//click on simulate out come
					WebDriverWait simulate_outcome=new WebDriverWait(driver, Duration.ofSeconds(30));
					WebElement click_simulate_outcome=simulate_outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Simulate Outcome']")));
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
							WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
							WebElement no_optimize_later=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
							JavascriptExecutor click_optimize = (JavascriptExecutor) driver;
							click_optimize.executeScript("arguments[0].click();", no_optimize_later);
							Thread.sleep(2000);
							driver.navigate().back();
							driver.switchTo().window(mainWindowHandle211);
							driver.close();				

						}
					}





				}
				
	
   
  


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
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"3449: AUTOMATION_PROJECT5192\"]")));
	JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
	insorce1.executeScript("arguments[0].click();", insorce678);

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
	
	
	public static void peak_utilization_shift_working_hours() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
		System.out.println(node);

		//here we need to compare the  peak and utlization  decision tree values
		String expectedValue ="Peak & Utilization\n"+ "38 FTE | 54.7% | 83.3%\n" + "FTE Count - 41\n"+ "Actual Utilization - 54.7%\n" + "Desired Utilization - 83.3%";
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


		//Scroll top to bottom

		Thread.sleep(1000);
		JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
		scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(2000);
		JavascriptExecutor bottom = (JavascriptExecutor) driver;
		bottom.executeScript("window.scrollBy(0,1000)", "");



		//click on work allocation and skilling


		WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement work_allocation_widget=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/WorkTimings']")));
		//click the work allocations in the actions
		Actions action1=new Actions(driver);
		action1.click(work_allocation_widget).perform();
		Thread.sleep(1000);


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
		driver.findElement(By.xpath("//div[@id='CommentDialogue']/descendant::button[text()='Save']")).click();
	
		

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


		
		
		
		
//		
//		//click on try recommendations
//		
//		WebElement try_recommendations=driver.findElement(By.xpath("//button[text()='Try Recommendation']"));
//		JavascriptExecutor click_try = (JavascriptExecutor) driver;
//		click_try.executeScript("arguments[0].click();", try_recommendations);
//		
//		
//		//click on try more recommendations
//		WebElement try_more=driver.findElement(By.xpath("//button[text()='Try More Recommendations']"));
//		JavascriptExecutor click_try_more = (JavascriptExecutor) driver;
//		click_try_more.executeScript("arguments[0].click();", try_more);
//		
//
//		//clear recommendations
//        Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[text()='Clear Recommendations']")).clear();
//		JavascriptExecutor click_clear_recommendations = (JavascriptExecutor) driver;
//		click_clear_recommendations.executeScript("arguments[0].click();", click_clear_recommendations);
		
		
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
				WebDriverWait later=new WebDriverWait(driver, Duration.ofSeconds(90));
//				WebElement validate=later.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//				JavascriptExecutor on = (JavascriptExecutor) driver;
//				on.executeScript("arguments[0].click();", validate);
//				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}




	}




public static void peak_and_utlization() throws Exception
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
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(90));
	WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"3506: Automation_decision_tree_widget_Don't_make any changes\"]")));
	JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
	insorce1.executeScript("arguments[0].click();", insorce678);

	//click on decision tree
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

	//click on decision tree node
	WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

	//click on tree node and get text
	WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
	String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
	System.out.println(node);

	//here we need to compare the  peak and utlization  decision tree values
	String expectedValue ="Peak & Utilization\n"+ "32 FTE | 65.8% | 83.3%\n" + "FTE Count - 32\n"+ "Actual Utilization - 65.8%\n" + "Desired Utilization - 83.3%";
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


	//Scroll top to bottom

	//		Thread.sleep(1000);
	//		JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
	//		scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	//
	//		Thread.sleep(2000);
	//		JavascriptExecutor bottom = (JavascriptExecutor) driver;
	//		bottom.executeScript("window.scrollBy(0,1000)", "");


	//click on work allocation
	Thread.sleep(3000);
	WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(6000));
	WebElement click_on_work_allocation=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/TeamCostPeakReduction']")));
	Actions action1=new Actions(driver);
	action1.click(click_on_work_allocation).perform();
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
	WebElement click_full_team=driver.findElement(By.xpath("//tbody/tr/td[3]/div[1]/span[2]/button[contains(text(),'Full')]"));
	Thread.sleep(3000);
	click_full_team.click();


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
		//          	JavascriptExecutor click_save_click= (JavascriptExecutor) driver;
		//          	click_save_click.executeScript("arguments[0].click();", click_proceed_save);


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
 

	public static void over_capacity() throws InterruptedException, IOException
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3449: AUTOMATION_PROJECT5192']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
		System.out.println(node);

		//here we need to compare the  peak and utlization  decision tree values
		String expectedValue ="Peak & Utilization\n"+ "49 FTE | 49.6% | 83.3%\n" + "FTE Count - 49\n"+ "Actual Utilization - 49.6%\n" + "Desired Utilization - 83.3%";
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


		//Scroll top to bottom

		Thread.sleep(1000);
		JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
		scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		//scroll top to bottom
		JavascriptExecutor processmap = (JavascriptExecutor) driver;
		processmap.executeScript("window.scrollTo(0,700)", "");


		//click on over capacity
     Thread.sleep(3000);
     
		WebDriverWait capacity=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement over_capacity=capacity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Over Capacity']")));
		//click the over capacity with the actions
		Actions action1=new Actions(driver);
		action1.click(over_capacity).perform();
		
		Thread.sleep(1000);

		
		
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
		
		
		//click on remove over capacity
		WebElement remove_overcapacity=driver.findElement(By.xpath("//button[text()='Remove Over Capacity for All Teams']"));
		JavascriptExecutor click_capacity = (JavascriptExecutor) driver;
		click_capacity.executeScript("arguments[0].click();", remove_overcapacity);


		//click on ok 
		driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();

		//click on add to cart
		WebElement add_cart=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
		JavascriptExecutor click_add_cart = (JavascriptExecutor) driver;
		click_add_cart.executeScript("arguments[0].click();", add_cart);
		
		//click on review and proceed
		
		WebElement review_proceed=	driver.findElement(By.xpath("//button[contains(text(), 'Review & Proceed')]"));

		JavascriptExecutor click_proceed = (JavascriptExecutor) driver;
		click_proceed.executeScript("arguments[0].click();", review_proceed);

		
		//implement overcapacity
		
		WebElement implement_over_capacity=driver.findElement(By.xpath("//button[contains(text(), 'Implement Over Capacity')]"));

		JavascriptExecutor cick_implement_over_capacity = (JavascriptExecutor) driver;
		cick_implement_over_capacity.executeScript("arguments[0].click();", implement_over_capacity);
		

		//close overcapacity window using window handler

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
		
	
	

	@Test
	public static void optimize_by_cost() throws Exception
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3427: QA--test']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
		System.out.println(node);

		//here we need to compare the  peak and utlization  decision tree values
		String expectedValue ="Peak & Utilization\n"+ "49 FTE | 49.6% | 83.3%\n" + "FTE Count - 49\n"+ "Actual Utilization - 49.6%\n" + "Desired Utilization - 83.3%";
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


		//Scroll top to bottom

		Thread.sleep(1000);
		JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
		scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(2000);
		JavascriptExecutor bottom = (JavascriptExecutor) driver;
		bottom.executeScript("window.scrollBy(0,1000)", "");
       
		//click on optimize cycle time
		
		WebElement optimize_cycle_time=driver.findElement(By.xpath("//h5[text()='Optimize By Cost']"));
       //using the action click optimize cycle times
		Actions action1=new Actions(driver);
		action1.click(optimize_cycle_time).perform();
		Thread.sleep(1000);


		// click on windows handler

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

		Thread.sleep(3000);
		WebElement click_on_optimization=driver.findElement(By.xpath("//button[text()='No, will do it later. Proceed optimization']"));
		click_on_optimization.click();
		Thread.sleep(3000);
		driver.close();



	  }
	
	

public static void  Merge_teams() throws Exception
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
	WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3454: Automation__decision__tree__testing']")));
	JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
	insorce1.executeScript("arguments[0].click();", insorce678);

	//click on decision tree
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

	//click on decision tree node
	WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

	//click on tree node and get text
	WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
	String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
	System.out.println(node);

	//here we need to compare the  peak and utlization  decision tree values
	String expectedValue ="Peak & Utilization\n"+ "49 FTE | 49.6% | 83.3%\n" + "FTE Count - 49\n"+ "Actual Utilization - 49.6%\n" + "Desired Utilization - 83.3%";
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


	//Scroll top to bottom

	Thread.sleep(1000);
	JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
	scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	Thread.sleep(2000);
	JavascriptExecutor bottom = (JavascriptExecutor) driver;
	bottom.executeScript("window.scrollBy(0,500)", "");

	//click on merge teams
	Thread.sleep(3000);
	WebDriverWait deadlines=new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement click_on_deadlines=deadlines.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/Operations/JoinTeams\"]")));
	//click the merge teams in the actions
	Actions action1=new Actions(driver);
	action1.click(click_on_deadlines).perform();
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


	//scroll top to bottom
	JavascriptExecutor processmap = (JavascriptExecutor) driver;
	processmap.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	
             //select the team size
//			WebDriverWait click_team_size=new WebDriverWait(driver, Duration.ofSeconds(60));
//			WebElement select_team_size=click_team_size.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-select']")));
//			Select select_type=new Select(select_team_size);
//			select_type.selectByVisibleText("Closer");
//			select_type.selectByVisibleText("HSS");
//			select_type.selectByVisibleText("Pre ICD Processor");
//			select_type.selectByVisibleText("Underwriter");
			
//			WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select']"));
//	        Select dropdown = new Select(dropdownElement);
//	        dropdown.selectByVisibleText("Closer");
//	        dropdown.selectByVisibleText("HSS");
//	        dropdown.selectByVisibleText("Pre ICD Processor");
//	        dropdown.selectByVisibleText("Underwriter");
//			
	        

	       
	        
	        try 
	        {
	            // Wait for the dropdown to be present and visible
	        	 WebDriverWait waitnow = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement dropdownElement = waitnow.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//select[@class='form-select']")));

	            // Create Select instance and choose option by visible text
	            Select dropdown = new Select(dropdownElement);
	            dropdown.selectByVisibleText("Underwriter"); 
	            dropdown.selectByVisibleText("Closer");
	            dropdown.selectByVisibleText("HSS");
	            dropdown.selectByVisibleText("Pre ICD Processor");// or "HSS", etc.

	        } 
	        catch (org.openqa.selenium.StaleElementReferenceException e) 
	        {
	            // Re-locate and retry
	            System.out.println("Stale element found, retrying...");

	            WebElement dropdownElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//select[@class='form-select']")));

	            Select dropdown = new Select(dropdownElement);
	            dropdown.selectByVisibleText("Underwriter");
	      
	        
	        
			//click on merge teams check box
			
			
			
			List<WebElement> merge=driver.findElements(By.xpath("//tr[@class='info']/following::th[8]/following::input[@type='checkbox']"));
			
			
			for( int i=1;i<merge.size();i++)
			{
				
				
				WebElement check_box=driver.findElement(By.xpath("((//tr[@class='info']/following::th[8]/following::input[@type='checkbox'])["+i+"])"));
				
				check_box.click();
				
				
				
			}
			
			
			//click on merge
			
		
			
			
			List<WebElement> merge_teams=driver.findElements(By.xpath("//th/following::button[text()='Merge']"));
			
			
			for( int m=1;m<=merge_teams.size();m++)
			{
				
				
				WebElement click_merge_teams=driver.findElement(By.xpath("((//th/following::button[text()='Merge'])["+m+"])"));
			
				JavascriptExecutor click_teams = (JavascriptExecutor) driver;
				click_teams.executeScript("arguments[0].click();", click_merge_teams);
				
				
				
				
			}
			
			
			//click on simulate out come
			
			WebElement simulate_outcome=driver.findElement(By.xpath("//div[@id='MergedTeamNameDialogue']/descendant::button[text()='Simulate Outcome']"));
			JavascriptExecutor click_simulate_outcome = (JavascriptExecutor) driver;
			click_simulate_outcome.executeScript("arguments[0].click();", simulate_outcome);
			
			
			
			
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
					WebDriverWait later=new WebDriverWait(driver, Duration.ofSeconds(90));
//					WebElement validate=later.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//					JavascriptExecutor on = (JavascriptExecutor) driver;
//					on.executeScript("arguments[0].click();", validate);
//					Thread.sleep(2000);
					driver.navigate().back();
					driver.switchTo().window(mainWindowHandle211);
					driver.close();				

				}
			}
	        }
	        }

	        
	        
	        
	        
	        public static void delays() throws Exception
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
	    		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"3506: Automation_decision_tree_widget_Don't_make any changes\"]")));
	    		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
	    		insorce1.executeScript("arguments[0].click();", insorce678);

	    		//click on decision tree
	    		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
	    		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

	    		//click on decision tree node
	    		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
	    		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).click();

	    		//click on tree node and get text
	    		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
	    		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='105']"))).getText();
	    		System.out.println(node);

	    		//here we need to compare the  peak and utlization  decision tree values
	    		String expectedValue ="Peak & Utilization\n"+ "32 FTE | 65.8% | 83.3%\n" + "FTE Count - 32\n"+ "Actual Utilization - 65.8%\n" + "Desired Utilization - 83.3%";
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


	    		//Scroll top to bottom

	    		Thread.sleep(1000);
	    		JavascriptExecutor scrolltobottom = (JavascriptExecutor) driver;
	    		scrolltobottom.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	    		Thread.sleep(2000);
	    		JavascriptExecutor bottom = (JavascriptExecutor) driver;
	    		bottom.executeScript("window.scrollBy(0,1000)", "");

	    		//click on delays
	    		WebDriverWait delays=new WebDriverWait(driver, Duration.ofSeconds(30));
	    		WebElement click_delays=delays.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Delays']")));

	    		//click the work allocations in the actions
	    		Actions action1=new Actions(driver);
	    		action1.click(click_delays).perform();
	    		Thread.sleep(1000);


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

	    		Thread.sleep(3000);

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



	    		//click on select the dropm down menu wait types

	    		List<WebElement> select_all= driver.findElements(By.xpath("//select[@data-bind='value: WaitType']"));


	    		for (int a = 1; a <= select_all.size(); a++) 
	    		{


	    			WebElement dropdown = driver.findElement(By.xpath("((//select[@data-bind='value: WaitType'])["+a+"])"));
	    			Select select = new Select(dropdown);

	    			select.selectByVisibleText("POST");
	    			Thread.sleep(3000);
	    			select.selectByVisibleText("EOD");
	    			Thread.sleep(3000);
	    			select.selectByVisibleText("BOD");
	    			Thread.sleep(3000);
	    			select.selectByVisibleText("TOD");


	    			//select the time 

	    			LocalTime now = LocalTime.now();
	    			String dynamicTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));



	    			WebElement Enter_time= driver.findElement(By.xpath("//input[contains(@id, 'TODTime')]"));
	    			Enter_time.sendKeys("10.00:00:00");
	    			Enter_time.sendKeys(dynamicTime);








	    		}



	    		//	
	    		//		WebElement dropdown = driver.findElement(By.xpath("//select[@data-bind='value: WaitType']"));
	    		//        Select select = new Select(dropdown);
	    		//
	    		//        select.selectByVisibleText("POST");
	    		//        Thread.sleep(3000);
	    		//        select.selectByVisibleText("EOD");
	    		//        Thread.sleep(3000);
	    		//        select.selectByVisibleText("BOD");
	    		//        Thread.sleep(3000);
	    		//        select.selectByVisibleText("TOD");
	    		//        
	    		//        
	    		//        //select the time 
	    		//        
	    		//        LocalTime now = LocalTime.now();
	    		//        String dynamicTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	    		//
	    		//        
	    		//        
	    		//       WebElement Enter_time= driver.findElement(By.xpath("//input[contains(@id, 'TODTime')]"));
	    		//       Enter_time.sendKeys("10.00:00:00");
	    		//       Enter_time.sendKeys(dynamicTime);
	    		//       
	    		//click on add
	    		WebElement add=driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary mt')]"));
	    		JavascriptExecutor click_add= (JavascriptExecutor) driver;
	    		click_add.executeScript("arguments[0].click();", add);     

	    		//click on add cart
	    		WebElement add_to_cart=  driver.findElement(By.xpath("//div[@id=\"AddtoCartDialogue\"]/descendant::button[text()=' Add to cart']"));
	    		JavascriptExecutor click_add_to_cart= (JavascriptExecutor) driver;
	    		click_add_to_cart.executeScript("arguments[0].click();", add_to_cart);   

	    		//click on close

	    		WebElement close=driver.findElement(By.xpath("//a[@class='btn-close']"));
	    		JavascriptExecutor click_close= (JavascriptExecutor) driver;
	    		click_close.executeScript("arguments[0].click();", close); 


	    		//click on review and proceed

	    		WebElement review_proceed= driver.findElement(By.xpath("//button[contains(text(),'Review & Proceed')]"));
	    		JavascriptExecutor click_review_proceed= (JavascriptExecutor) driver;
	    		click_review_proceed.executeScript("arguments[0].click();", review_proceed);

	    		//click on simulate outcome

	    		WebElement simulate_outcome= driver.findElement(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']"));
	    		JavascriptExecutor click_simulate_outcome= (JavascriptExecutor) driver;
	    		click_simulate_outcome.executeScript("arguments[0].click();", simulate_outcome);




	    		//click on view result
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
	    				//				WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
	    				//				WebElement proceed_optimization=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
	    				//				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
	    				//				click_optimization.executeScript("arguments[0].click();", proceed_optimization);
	    				Thread.sleep(2000);
	    				driver.navigate().back();
	    				driver.switchTo().window(mainWindowHandle2);
	    				driver.close();			

	    			}
	    		}

	    	}
      }     




	    	

	        
	        

			
			
	










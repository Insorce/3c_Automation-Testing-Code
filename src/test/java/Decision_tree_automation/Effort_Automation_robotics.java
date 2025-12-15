package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Effort_Automation_robotics 

{
	
	
	@Test
	public static void effort_automation_robotics() throws InterruptedException, FileNotFoundException
	{
		
		WebDriver driver= new ChromeDriver();
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement click_on_project=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4315: AUTOMATION__MORTGAGE__PROJECT88']")));

		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);




		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();



//		click on decision tree symbol
		
//		driver.findElement(By.xpath("//a[@href=\"/Projects/DecisionTree\"]")).click();
//		
		

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

	
		

		//click on Automation robotics

		WebDriverWait robotics=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Automation=robotics.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/PathAutomation']")));
		JavascriptExecutor click_robotics = (JavascriptExecutor) driver;
		click_robotics.executeScript("arguments[0].click();", Automation);


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
				break;

			}
		}
		System.out.println(mainWindowHandle1);

		//printing child window
		System.out.println("Child Window");

		
		
		
		

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
//				//						WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
//				//						WebElement click_result=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//				//						JavascriptExecutor result_click = (JavascriptExecutor) driver;
//				//						result_click.executeScript("arguments[0].click();", click_result);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				Thread.sleep(3000);
				driver.close();
				
							

//			}
//		}

	
	}
	
  }
}	
	}
}

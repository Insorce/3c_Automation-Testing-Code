package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

public class Deadlines_under_peak_utilization 
{

	@Test
	public static void  Deadlines() throws Exception
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

		//click on deadlines
		Thread.sleep(3000);
		WebDriverWait deadlines=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_deadlines=deadlines.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Deadlines']")));
		//click the work deadlines in the actions
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
		
		
		//click on download button
		WebElement downalod_button=driver.findElement(By.xpath("//div[@id='actionmenu']/descendant::button[@title='Download']"));
		JavascriptExecutor button = (JavascriptExecutor) driver;
		button.executeScript("arguments[0].click();", downalod_button);

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


         //click on close
		
		WebElement close=driver.findElement(By.xpath("//a[@class='btn-close']"));
		JavascriptExecutor click_close = (JavascriptExecutor) driver;
		click_close.executeScript("arguments[0].click();", close);




		//click on show all

		WebElement show_all=driver.findElement(By.xpath("//span[@class='toggle']"));
		JavascriptExecutor click_show_all = (JavascriptExecutor) driver;
		click_show_all.executeScript("arguments[0].click();", show_all);



		// click on the all the process maps view 

		List<WebElement> view = driver.findElements(By.xpath("//tr[@class='info']"));
		Thread.sleep(3000);

		for( int a=1; a<=view.size(); a++)
		{

			//click on view 
			WebElement click_view=driver.findElement(By.xpath("//tr[@class='info']["+a+"]//td[7]//a"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(click_view).build().perform();
			
		}


		
		Thread.sleep(3000);

//		List<WebElement> download_button1=driver.findElements(By.xpath("//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')]"));
//
//		System.out.println("downalod_button");
//		for (int k = 1; k <=download_button1.size() ; k++)
//		{
//
//			WebElement download=driver.findElement(By.xpath("(//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')])["+k+"]"));
//
//			JavascriptExecutor downlaod_click = (JavascriptExecutor) driver;
//			downlaod_click.executeScript("arguments[0].click();", download);
//
//
//			Thread.sleep(1000);
//			System.out.println("Hi");
//			//click on download as pdf
//
//			List<WebElement> download_pdf=driver.findElements(By.xpath("//a[text()='Download as PDF']"));
//			for (int r = 1; r <= download_pdf.size(); r++) 
//			{
//				WebElement click_pdf=	driver.findElement(By.xpath("(//a[text()='Download as PDF'])["+r+"]"));
//
//				JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//				pdf_click.executeScript("arguments[0].click();", click_pdf);
//			}
//
//
//
//			//click on download tgf
//
//			List<WebElement> download_tgf=driver.findElements(By.xpath("//a[text()='Download as TGF']"));
//			for (int a = 1; a <= download_tgf.size(); a++)
//			{
//				WebElement click_tgf=driver.findElement(By.xpath("(//a[text()='Download as TGF'])["+a+"]"));
//
//				JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//				pdf_click.executeScript("arguments[0].click();", click_tgf);
//			}
//
//			Thread.sleep(5000);
//
//
//
//	
			//click on edit deadline
			Thread.sleep(3000);
			WebDriverWait proceeding=new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement edit_deadline=proceeding.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[4]/td[1]/descendant::button[text()='Edit Deadline']")));
			JavascriptExecutor deadlines_click  = (JavascriptExecutor) driver;
			deadlines_click.executeScript("arguments[0].click();", edit_deadline);

	       //click on edit deadlines
			Thread.sleep(3000);
			WebElement EditDeadlines=driver.findElement(By.xpath("//label[@class='col-sm-4']/child::select[@class='form-select']"));
			EditDeadlines.click();
			EditDeadlines.sendKeys(Keys.ARROW_DOWN);
			EditDeadlines.sendKeys(Keys.ARROW_DOWN);
			EditDeadlines.sendKeys(Keys.ENTER);

			WebDriverWait click_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement select_dead_lines=click_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='col-sm-4']/child::select[@class='form-select']")));
			Select select=new Select(select_dead_lines);
			select.selectByVisibleText("No Deadline");
			
			//click on addd to cart
	        Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='editDeadlineDialogue']/descendant::button[@class='btn btn-primary']")).click();
	
			
			//click on add the deadline
			
			List<WebElement> deadline=driver.findElements(By.xpath("//button[text()='Add Deadline']"));
			
			
			for (int d=1;d<=deadline.size(); d++)
			{
				
				WebElement click_deadline=driver.findElement(By.xpath("((//button[text()='Add Deadline'])["+d+"])"));
				JavascriptExecutor add_deadline  = (JavascriptExecutor) driver;
				add_deadline.executeScript("arguments[0].click();", click_deadline);
				
				
				//select the drop down menu
				WebDriverWait click_menu_once=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement select_deadline_type=click_menu_once.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='AddDeadlinetoActivity']/descendant::select[@data-bind='value: DeadLineType']")));
				Select select_type=new Select(select_deadline_type);
				select_type.selectByVisibleText("Absolute");
				select_type.selectByVisibleText("Relative");
				select_type.selectByVisibleText("No Deadline");
				
				
				//click on addd to cart
				Thread.sleep(3000);
				WebElement add_cart=driver.findElement(By.xpath("//div[@id='editDeadlineDialogue']/descendant::button[@class='btn btn-primary']"));
				JavascriptExecutor click_add_cart = (JavascriptExecutor) driver;
				click_add_cart.executeScript("arguments[0].click();", add_cart);

			
				
			}
			

			
			//scroll bottom to top 
			JavascriptExecutor bottom_top = (JavascriptExecutor) driver;
			bottom_top.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(3000);	
	   
	       //click on review and proceed
			driver.findElement(By.xpath("//button[ contains (text(), 'Review & Proceed')]")).click();
			Thread.sleep(3000);

			//click on simulate outcome
			WebDriverWait outcome=new WebDriverWait(driver, Duration.ofSeconds(90));
			WebElement simulate=outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
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
					WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
					WebElement no_validate_later=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
					JavascriptExecutor click_no_validate_later = (JavascriptExecutor) driver;
					click_no_validate_later.executeScript("arguments[0].click();", no_validate_later);
					Thread.sleep(2000);
					driver.navigate().back();
					driver.switchTo().window(mainWindowHandle211);
					driver.close();				
	
				}
			}
	
	
		}
		


}

 


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

public class customer_experience_criticalpath_setdeadlines 
{
	
	@Test
	 public static void customer_experiecnce_criticalpath() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='203']"))).click();

//		//click on tree node and get text
//		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
//		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='203']"))).getText();
//		System.out.println(node);
//		
//		
//
//		//here we need to Critical path  decision tree values
//		String expectedValue ="Critical Path\n"+ "4.3 days" ;
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
//        //scroll top to bottom
//		Thread.sleep(5000);
//		JavascriptExecutor bottom = (JavascriptExecutor) driver;
//		bottom.executeScript("window.scrollBy(0,900)", "");
//		
		
		//click on set deadlines
		WebDriverWait deadlines=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement set_deadlines=deadlines.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Set Deadlines']")));
		Actions action1=new Actions(driver);
		action1.click(set_deadlines).perform();
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

		

//
//		//click on the three lines
//
//		WebElement three_lines=driver.findElement(By.xpath("//i[@class='fas fa-bars fa-2x p-2']"));
//		JavascriptExecutor three_lines_click= (JavascriptExecutor) driver;
//		three_lines_click.executeScript("arguments[0].click();", three_lines);
//
//		//click on the download button
//
//		WebElement download_button=driver.findElement(By.xpath("//a[@title='Download Visio & Recovery']"));
//		JavascriptExecutor click_download_button= (JavascriptExecutor) driver;
//		click_download_button.executeScript("arguments[0].click();", download_button);
//
//		//click on all downloads under the symbol
//
//
//		List<WebElement> all_downloads=driver.findElements(By.xpath("//i[@class='fas fa-file-download']"));
//
//		for (int D = 1; D <= all_downloads.size(); D++) 
//		{
//
//			WebElement click_menu=driver.findElement(By.xpath("(//i[@class='fas fa-file-download'])["+D+"]"));
//
//
//			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//			pdf_click.executeScript("arguments[0].click();", click_menu);
//
//			Thread.sleep(3000);
//			
//			
//		}
//
//		//click on cancel
//		WebElement cancel=driver.findElement(By.xpath("//a[@class='btn-close']"));
//		
//		JavascriptExecutor click_cancel = (JavascriptExecutor) driver;
//		click_cancel.executeScript("arguments[0].click();", cancel);
		


		  // Locate the deadline dropdown
        WebElement deadlineDropdown = driver.findElement(By.xpath("//select[@data-bind='value: DeadLineType']"));
        Select select = new Select(deadlineDropdown);

        // Get current selected value
        String currentSelection = select.getFirstSelectedOption().getText().trim();
        System.out.println("Currently selected: " + currentSelection);

        // Check which options are available
        boolean hasNoDeadline = false;
        boolean hasAbsolute = false;

        for (WebElement option : select.getOptions()) 
        {
            String text = option.getText().trim();
            if (text.equals("No Deadline")) hasNoDeadline = true;
            if (text.equals("Absolute")) hasAbsolute = true;
        }

        // Case 1: If Absolute is selected and No Deadline exists → switch to No Deadline
        if (currentSelection.equals("Absolute") && hasNoDeadline) 
        {
            select.selectByVisibleText("No Deadline");
            System.out.println("Switched to: No Deadline");

        // Case 2: If No Deadline is selected and Absolute exists → switch to Absolute and enter time
        } 
        else if (currentSelection.equals("No Deadline") && hasAbsolute)
        {
            select.selectByVisibleText("Absolute");
            System.out.println("Switched to: Absolute");

            // Enter deadline time
            WebElement deadlineInput = driver.findElement(By.xpath("//input[contains(@id, 'DeadlineTime')]"));
            deadlineInput.sendKeys(Keys.CONTROL + "a");
            deadlineInput.sendKeys(Keys.BACK_SPACE);
            deadlineInput.sendKeys("10.10:10:10");

        } 
        else 
        {
            System.out.println("No switching needed or options unavailable.");
        }

        // Click Save & Proceed using Actions double-click
        WebElement save_continue = driver.findElement(By.xpath("//div[@id='dvSetDeadlines']/descendant::button[text()='  Save & Proceed  ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(save_continue).doubleClick().perform();
    
		
		

    
	
		


		// using window set deadline and close
		
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

	
			
	
	



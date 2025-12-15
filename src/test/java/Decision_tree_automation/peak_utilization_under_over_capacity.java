package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class peak_utilization_under_over_capacity 
{


	@Test
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

}
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

public class Component_cost_component 
{

	@Test
	public static void path() throws Exception
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

//		//click on tree node and get text
//		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
//		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='107']"))).getText();
//		System.out.println(node);
//
//
//
//		//here we need to compare the  peak and utlization  decision tree values
//		String expectedValue ="Component Cost\n"+ "39 seats | USD 20.8K" ;
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
//		//scroll top to bottom
//		Thread.sleep(5000);
//		JavascriptExecutor bottom = (JavascriptExecutor) driver;
//		bottom.executeScript("window.scrollBy(0,900)", "");
//
//

		//click on component widget

		Thread.sleep(3000);
		WebElement component_widget=driver.findElement(By.xpath("//h5[text()='Components']"));
		JavascriptExecutor component_click= (JavascriptExecutor) driver;
		component_click.executeScript("arguments[0].click();", component_widget);


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

}

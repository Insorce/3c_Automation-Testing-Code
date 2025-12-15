package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Input_screen_release_wait_type
{

	
	@Test(invocationCount=1)
	public static void wait_types() throws InterruptedException
	{


		WebDriver driver= new ChromeDriver();
		driver.get("https://prod.3-cubed.com/");
		String A="https://prod.3-cubed.com/";	

		
		String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		//enter password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver.findElement(By.xpath("//button[@name='Logon']")).click();
		String AA=driver.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://prod.3-cubed.com/Account/LogOn"))
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='5432: infy1043__child__trending']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


	  
		
		
		//click on naviagte 
		driver.navigate().to("https://prod.3-cubed.com/Process/WaitTypes");
		

//		//click on download release and wait types
//		WebElement download_click=driver.findElement(By.xpath("//a[text()='Download Wait Periods File']"));
//		JavascriptExecutor download_waittypes = (JavascriptExecutor)driver;
//		download_waittypes.executeScript("arguments[0].click();", download_click);
//
//		//click on choose file
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3848-peakutilization__values__checking_WaitPeriods (4).xlsm");
//
//		//click on upload
//		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_click = (JavascriptExecutor)driver;
//		upload_click.executeScript("arguments[0].click();", upload);

		
		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title='Full screen']"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title='Exit full screen']"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);

         //click on the all the activity links
		
		List<WebElement> all_activity=driver.findElements(By.xpath("//h6//a"));
		
		
		for(int s=1;s<=all_activity.size(); s++)
		{
			
		WebElement click_activity=	driver.findElement(By.xpath("((//h6//a)["+s+"])"));
		JavascriptExecutor activity_click = (JavascriptExecutor)driver;
		activity_click.executeScript("arguments[0].click();", click_activity);
			
			
		}
		
		
		
		


		List<WebElement> list_activities = driver.findElements(By.xpath("//div[@id='WTActs']/descendant::input[@type='text']"));
		Actions action = new Actions(driver);

		for (WebElement element : list_activities) {

		    try {

		        // Check if the element is displayed & enabled
		        if (element.isDisplayed() && element.isEnabled()) {

		            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		            wait1.until(ExpectedConditions.elementToBeClickable(element));

		            // Click the element
		            action.moveToElement(element).click().perform();

		            // Clear old value
		            element.sendKeys(Keys.CONTROL, "a");
		            element.sendKeys(Keys.BACK_SPACE);

		            // Enter new value
		            element.sendKeys("02.02:02:02");

		            // Press ENTER
		            action.sendKeys(Keys.ENTER).perform();
		        }
		        else {
		            System.out.println("Element is NOT visible or NOT enabled, skipping...");
		        }

		    } catch (Exception e) {
		        System.out.println("Skipping one element due to error: " + e.getMessage());
		    }
		}



//		//clcik on improve
//		WebElement click_waittype=driver.findElement(By.xpath("//a[@id='obs-tab']"));
//		Thread.sleep(3000);
//		JavascriptExecutor wait_type = (JavascriptExecutor)driver;
//		wait_type.executeScript("arguments[0].click();", click_waittype);
//
//		//clcik on gen ai
//		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		Thread.sleep(3000);
//		JavascriptExecutor click_gen_ai = (JavascriptExecutor)driver;
//		click_gen_ai.executeScript("arguments[0].click();", gen_ai);


		//click on release and wait types
		WebElement click_review=driver.findElement(By.xpath("//a[@id='review-tab']"));
		Thread.sleep(3000);
		JavascriptExecutor click_on_review = (JavascriptExecutor)driver;
		click_on_review.executeScript("arguments[0].click();", click_review);


		//click on dead lines
		Thread.sleep(3000);
		WebElement dead_lines=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor mark_0 = (JavascriptExecutor)driver;
		mark_0.executeScript("arguments[0].click();", dead_lines);


	}

	
	
}

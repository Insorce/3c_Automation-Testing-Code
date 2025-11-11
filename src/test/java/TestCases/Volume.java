package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Volume extends Baseclass 
{
	
	
	@Test
	public void volume() throws InterruptedException
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"5349: zip--test\"]")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


	  

		driver.navigate().to("https://prod.3-cubed.com/Process/Volume");

		
		
		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title=\"Full screen\"]"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title=\"Exit full screen\"]"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);

		

		
		
		
		
//		//select the activity
//		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-select me-1']")); // or any other locator
//		Select select = new Select(dropdown);
//
//		// Select by visible text
//		select.selectByValue("3848002");
		
		
		//click on the volume activity links
		
		List<WebElement> volume_links=driver.findElements(By.xpath("//tr//a"));
		
		
		for( int b=1;b<=volume_links.size(); b++)
		{
			
			
			WebElement click_volume=driver.findElement(By.xpath("((//tr//a)["+b+"])"));
			Thread.sleep(3000);
			JavascriptExecutor volume_click = (JavascriptExecutor)driver;
			volume_click.executeScript("arguments[0].click();", click_volume);
			
			
			
		}
		

		//enter the volume
		List<WebElement> volume = driver.findElements(By.xpath("(//div[@id='EditMap']//following-sibling::input[@type='number'])"));

		for (int i = 1; i < volume.size(); i++) 
		{
			WebElement input_volume=driver.findElement(By.xpath("(//div[@id='EditMap']//following-sibling::input[@type='number'])["+i+"]"));
			if (input_volume.isEnabled())
			{
				input_volume.clear();
				input_volume.sendKeys("100");

			}
			if (input_volume.isDisplayed()) 
			{
				System.out.println("Not required to enter volume");
			} 
		}

//
//				//click on gen ai tab
//				Thread.sleep(3000);
//				WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//				JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
//				gen_ai_click.executeScript("arguments[0].click();", gen_ai);
//		
//				//click on observations
//				Thread.sleep(3000);
//				WebElement observations1=driver.findElement(By.xpath("//a[@id='obs-tab']"));
//				JavascriptExecutor observations_click = (JavascriptExecutor)driver;
//				observations_click.executeScript("arguments[0].click();", observations1);
//		
//				//click on rework collapse
//				WebElement rework_collapse=driver.findElement(By.xpath("//button[text()='Rework and FTR']"));
//				JavascriptExecutor rework_click = (JavascriptExecutor)driver;
//				rework_click.executeScript("arguments[0].click();", rework_collapse);
//		
//		
//				//click on mark as reviwed
//				Thread.sleep(3000);
//				WebElement mark_reviewed=driver.findElement(By.xpath("(//span[@class='toggle'])[1]"));
//				JavascriptExecutor volume_reviewed = (JavascriptExecutor)driver;
//				volume_reviewed.executeScript("arguments[0].click();", mark_reviewed);
//		
//		
//				//click on rejections
//				WebElement rework_rejections=driver.findElement(By.xpath("//button[text()='Rejection']"));
//				JavascriptExecutor rework = (JavascriptExecutor)driver;
//				rework.executeScript("arguments[0].click();", rework_rejections);
//		
//				//mark as reviewed
//				Thread.sleep(3000);
//				WebElement review_screen=driver.findElement(By.xpath("(//span[@class='toggle'])[2]"));
//				JavascriptExecutor screen = (JavascriptExecutor)driver;
//				screen.executeScript("arguments[0].click();", review_screen);
//


		
		
	}

}

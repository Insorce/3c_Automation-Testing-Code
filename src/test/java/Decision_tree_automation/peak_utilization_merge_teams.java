package Decision_tree_automation;

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

public class peak_utilization_merge_teams 
{

	@Test
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement click_on_project=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4315: AUTOMATION__MORTGAGE__PROJECT88']")));
		
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);

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
//				WebDriverWait click_team_size=new WebDriverWait(driver, Duration.ofSeconds(60));
//				WebElement select_team_size=click_team_size.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-select']")));
//				Select select_type=new Select(select_team_size);
//				select_type.selectByVisibleText("Closer");
//				select_type.selectByVisibleText("HSS");
//				select_type.selectByVisibleText("Pre ICD Processor");
//				select_type.selectByVisibleText("Underwriter");
				
//				WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select']"));
//		        Select dropdown = new Select(dropdownElement);
//		        dropdown.selectByVisibleText("Closer");
//		        dropdown.selectByVisibleText("HSS");
//		        dropdown.selectByVisibleText("Pre ICD Processor");
//		        dropdown.selectByVisibleText("Underwriter");
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
//						WebElement validate=later.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
//						JavascriptExecutor on = (JavascriptExecutor) driver;
//						on.executeScript("arguments[0].click();", validate);
//						Thread.sleep(2000);
						driver.navigate().back();
						driver.switchTo().window(mainWindowHandle211);
						driver.close();				

					}
				}



				
				
	
}
	
}

}

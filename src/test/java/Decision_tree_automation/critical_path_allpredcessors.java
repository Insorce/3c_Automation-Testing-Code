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

public class critical_path_allpredcessors
{

	@Test
	public static  void predecessor() throws InterruptedException, IOException
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

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='203']"))).getText();
		System.out.println(node);



		//here we need to Critical path  decision tree values
		String expectedValue ="Critical Path\n"+ "4.4 days" ;
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

		//click on all predecessors


		WebDriverWait all=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement all_predecessors=all.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Any/All predecessors']")));
		Actions action1=new Actions(driver);
		action1.click(all_predecessors).perform();
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



				driver.switchTo().window(handle);
				Thread.sleep(3000);
				//click on all predecssors   using for loop

				List<WebElement> all_predecssors=driver.findElements(By.xpath("//table[1]/tbody[2]//td[2]//input[contains(@id, 'All')]"));



				for(int i=1;i<all_predecssors.size(); i++)
				{

					WebElement predecessors=driver.findElement(By.xpath("//table[1]/tbody[2]/tr["+i+"]/td[2]//input[contains(@id, 'All')]"));
					JavascriptExecutor click_allpredecessors = (JavascriptExecutor) driver;
					click_allpredecessors.executeScript("arguments[0].click();", predecessors);

				}



				//click on save and continue
				WebElement save_continue=driver.findElement(By.xpath("//button[text()='Save & Continue']"));
				JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
				click_save_continue.executeScript("arguments[0].click();", save_continue);


				//click on review and proceed
				WebElement review_proceed=driver.findElement(By.xpath("//button[@id='btnAssignedList']"));
				JavascriptExecutor click_review_proceed = (JavascriptExecutor) driver;
				click_review_proceed.executeScript("arguments[0].click();", review_proceed);


				//click on simulate outcome
				WebElement simulate_outcome=driver.findElement(By.xpath("//button[text()='Simulate Outcome']"));
				JavascriptExecutor click_simulate_outcome = (JavascriptExecutor) driver;
				click_simulate_outcome.executeScript("arguments[0].click();", simulate_outcome);

				Thread.sleep(5000);


			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");


		
		Thread.sleep(9000);
        driver.close();




	}

}


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

public class Customer_experience_bottleneck_delays_workallocation
{


	@Test
	public static void work_allocation() throws Exception
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='204']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='204']"))).getText();
		System.out.println(node);



//		//here we need to bottle neck  decision tree values
//		String expectedValue ="Bottlenecks and Delays\n"+ "6 days | 31.1 days" ;
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

		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor bottom = (JavascriptExecutor) driver;
		bottom.executeScript("window.scrollBy(0,900)", "");


		//click on work allocation
		WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement work_allocation=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/BottlenecksWorkAllocation\']")));
		Actions action1=new Actions(driver);
		action1.click(work_allocation).perform();
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

				
				  Thread.sleep(3000);

					//click on the view comment
					Thread.sleep(3000);
					WebElement view_comment=driver.findElement(By.xpath("//i[@class=\"fas fa-comment is-cursor-pointer fa-2x mx-1 text-primary\"]"));
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





				
				
				//select the competency by

				WebElement dropdown = driver.findElement(By.xpath("((//div[@id='CostAnalysis']/descendant::select[@class='form-select'])[1])"));

				// Create Select object
				Select select = new Select(dropdown);

				// Select by visible text
				select.selectByVisibleText("Fact based");
				select.selectByVisibleText("Computation");
				select.selectByVisibleText("Human Judgment");
				select.selectByVisibleText("All");




				//select the delay type

				WebElement delay_type= driver.findElement(By.xpath("((//div[@id=\"CostAnalysis\"]/descendant::select[@class=\"form-select\"])[2])"));

				Select select_type = new Select(delay_type);

				// Select by visible text
				select_type.selectByVisibleText("In-Office");
				select_type.selectByVisibleText("Out-Of-Office");
				select_type.selectByVisibleText("All"); 



				//click on all full

				List<WebElement> click_full=driver.findElements(By.xpath("//tbody/tr/td[4]/following::button[text()='Full']"));


				for(int f=1; f<=click_full.size(); f++)
				{


					WebElement click=driver.findElement(By.xpath("((//tbody/tr/td[4]/following::button[text()='Full'])["+f+"])"));

					JavascriptExecutor simulate1 = (JavascriptExecutor) driver;
					simulate1.executeScript("arguments[0].click();", click);
				}




				//click on full
				WebElement full=driver.findElement(By.xpath("(//tbody/tr/td[4]/following::button[text()='Full'])[1]"));
				JavascriptExecutor train = (JavascriptExecutor) driver;
				train.executeScript("arguments[0].click();", full);

				//click on review and proceed
				WebElement review_proceed=	driver.findElement(By.xpath("//button[@id='btnAssignedList']"));
				JavascriptExecutor click_proceed = (JavascriptExecutor) driver;
				click_proceed.executeScript("arguments[0].click();", review_proceed);

				//click on simulate out come

				WebElement simulate_outcome=driver.findElement(By.xpath("//div[@id='excahnge-activities-dialog']/descendant::button[text()='Simulate Outcome']"));
				JavascriptExecutor click_simulate = (JavascriptExecutor) driver;
				click_simulate.executeScript("arguments[0].click();", simulate_outcome);
				Thread.sleep(3000);



			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");

		Thread.sleep(6000);

		driver.close();
	}
}

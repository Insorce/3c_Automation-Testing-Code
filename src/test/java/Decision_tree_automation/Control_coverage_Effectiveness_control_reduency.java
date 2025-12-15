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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Control_coverage_Effectiveness_control_reduency 
{
	
	
	@Test
	public static void effectiveness() throws Exception
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='1842: AUTOMATION_PROJECT']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='303']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='303']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Effectiveness\n"+ "45.4%";
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
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		
		//click on control_Reducany
		WebDriverWait control_Reducany=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement Reducany=control_Reducany.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Operations/ControlsPath']/descendant::h5[text()='Control Redundancy']")));
		Actions action1=new Actions(driver);
		action1.click(Reducany).perform();
		Thread.sleep(10000);

		

		// multiple window handler

		String mainWindowHandle11 = driver.getWindowHandle();
		System.out.println(mainWindowHandle11);

		Set<String> allWindowHandles11 = driver.getWindowHandles();
		System.out.println(allWindowHandles11);

		for (String handle1 : allWindowHandles11)
		{
			if (!handle1.equals(mainWindowHandle11))
			{

				driver.switchTo().window(handle1);
				break;

			}
		}
		System.out.println(mainWindowHandle11);

		//printing child window
		System.out.println("Child Window");
	


		Thread.sleep(9000);
		//drop down menu
		JavascriptExecutor js1234111=(JavascriptExecutor) driver;
		js1234111.executeScript("window.scrollTo(0,200);");
		
		
		
		

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





		// click on the all the process maps view 

		List<WebElement> view = driver.findElements(By.xpath("//tr[@class='info']"));
		Thread.sleep(3000);

		for( int j=1; j<=view.size(); j++)
		{

			//click on view 
			WebElement click_view=driver.findElement(By.xpath("//tr[@class='info']["+j+"]//td[8]//a"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(click_view).build().perform();
			Thread.sleep(2000);


		}
		
		
		
		// click all the visible text in table


		List<WebElement> click_table = driver.findElements(By.xpath("//a[@data-bs-toggle='collapse']"));
		Thread.sleep(3000);

		for( int o=1; o<=click_table.size(); o++)
		{

			//click all text 
			WebElement solution_data=driver.findElement(By.xpath("((//a[@data-bs-toggle=\"collapse\"])["+o+"])"));

			//click on all views
			Actions click_act=new Actions(driver);
			click_act.click(solution_data).build().perform();
			Thread.sleep(2000);


		}


		//click on show bubble chat
		WebElement Show_bubble_chat =	driver.findElement(By.xpath("//button[contains(@id,'btnBubblechart')]"));
		JavascriptExecutor click_Show_bubble_chat = (JavascriptExecutor) driver;
		click_Show_bubble_chat.executeScript("arguments[0].click();", Show_bubble_chat);





		//click on process map			
		JavascriptExecutor process_map = (JavascriptExecutor)driver;
		process_map.executeScript("LODMap.ControlClick(LODMap.filteredLOD()[0],LODMap.filteredLOD()[0].controlActs[0].ID)");

		//click on delete button
		WebDriverWait delete=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Delete_button=delete.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
		JavascriptExecutor deletebutton = (JavascriptExecutor) driver;
		deletebutton.executeScript("arguments[0].click();", Delete_button);

		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor insorce789=(JavascriptExecutor) driver;
		insorce789.executeScript("window.scrollTo(0,0);");

		//click on Review and proceed
		WebDriverWait review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement review_proceed=review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Review & Proceed')]")));
		JavascriptExecutor proceed = (JavascriptExecutor) driver;
		proceed.executeScript("arguments[0].click();", review_proceed);


		//click on simulate outcome
		WebDriverWait simulate=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement simulate_outcome=simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cart-activities']/descendant::button[text()='Simulate Outcome']")));
		Thread.sleep(3000);
		driver.close();




		
		
	}

}

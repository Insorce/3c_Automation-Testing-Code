package Decision_tree_automation;

import java.io.FileNotFoundException;
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

public class Control_coverage_adeqecy_under_controlled 

{


	@Test
	public void control_coverage() throws InterruptedException, FileNotFoundException
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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='302']"))).click();

//		//click on tree node and get text
//		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
//		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='302']"))).getText();
//		System.out.println(node);
//
//		//here we need to compare the decision tree values
//		String expectedValue ="Adequacy\n"+ "2.7 LOD";
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
//
//		PrintStream printStream = new PrintStream(new FileOutputStream("Log.txt"));
//		printStream.println("Actual Value is"+'\n'+actualValue);
//		printStream.println(                                                       );
//		printStream.println(                                                       );
//		printStream.println("Expected Value is"+'\n'+expectedValue);
//


		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");


		//click on undercontrolled_Reducany

		WebDriverWait control_Reducany=new WebDriverWait(driver, Duration.ofSeconds(600));
		WebElement Reducany=control_Reducany.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Under Controlled']")));
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
				Thread.sleep(6000);
			

			}
		}
		System.out.println(mainWindowHandle11);

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


		//click on the  customer intake documentation

		List<WebElement> intake=driver.findElements(By.xpath("//table//tr//td[@class=\"col-sm-3 text-center open-control is-cursor-pointer\"]"));


		for( int i=1; i<intake.size(); i++)
		{

			WebElement click_intake=driver.findElement(By.xpath("((//table//tr//td[@class=\"col-sm-3 text-center open-control is-cursor-pointer\"])["+i+"])"));

			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", click_intake);

			
			
			
			List<WebElement> controls=driver.findElements(By.xpath("//a[@class=\"is-cursor-pointer\"]"));
			
			for (int j=1; j<controls.size(); j++)
			{
				
				
			WebElement click_all_controls=	driver.findElement(By.xpath("((//a[@class=\"is-cursor-pointer\"])["+j+"])"));
			
			JavascriptExecutor click_controls = (JavascriptExecutor) driver;
			click_controls.executeScript("arguments[0].click();", click_all_controls);

			
			List<WebElement> click_apply=driver.findElements(By.xpath("//button[text()='Apply']"));

			for(int l=1; l<=click_apply.size(); l++)
			{
				
				
				
				WebElement just_click=driver.findElement(By.xpath("((//button[text()=\"Apply\"])["+l+"])"));
				JavascriptExecutor apply = (JavascriptExecutor) driver;
				apply.executeScript("arguments[0].click();", just_click);
				
				
			}
			
			
			
			
			
			Thread.sleep(3000);
			
			
			List<WebElement> click_radiobutton=driver.findElements(By.xpath("//input[@type='radio']"));
			
			
			
			for(int  m=1;m<=click_radiobutton.size(); m++)
				
			{
				
				WebElement click_raido=driver.findElement(By.xpath("((//input[@type='radio'])["+m+"])"));
				
				
				JavascriptExecutor click_all_radios = (JavascriptExecutor) driver;
				click_all_radios.executeScript("arguments[0].click();", click_raido);
				
			}
			
			
			
			}
			
			
			
			List<WebElement> close_button  =driver.findElements(By.xpath("//button[@type='button']"));
			
			
			for( int k=1; k<=close_button.size(); k++)
			{
				
				
				WebElement click_close=driver.findElement(By.xpath("((//button[@type='button'])["+k+"])"));
				JavascriptExecutor click_controls = (JavascriptExecutor) driver;
				click_controls.executeScript("arguments[0].click();", click_close);
				
			}
			
			
			
			
			Thread.sleep(3000);
			driver.close();
			
			

		}


	}




}



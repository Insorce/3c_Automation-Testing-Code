package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
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

public class Effort_edit_processmap 

{
	
	
	
	@Test
	public void edit_process_map() throws InterruptedException, FileNotFoundException
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
		if(AA.equals(WelcomePage)) 
		{
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
		// log out code is completed here


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
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");



		
		
		//click on edit process map
		WebDriverWait edit_processmap=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement click_editprocessmap=edit_processmap.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//h4[@id=\"hSelectedWidget\"]/following::h5[text()='Edit Process map'])[1])")));
		Actions action_click=new Actions(driver);
		action_click.click(click_editprocessmap).perform();
		Thread.sleep(10000);


		
		List<WebElement> edit_process_map=driver.findElements(By.xpath("//div[@xmlns=\"http://www.w3.org/1999/xhtml\"]"));
		
	
	
	    for( int r=1; r<=edit_process_map.size(); r++)
	    	{
	    	
	    	
	    	
	    	WebElement just_click=driver.findElement(By.xpath("//div[@xmlns=\"http://www.w3.org/1999/xhtml\"]["+r+"]"));

	       
	    	just_click.clear();
	    	Thread.sleep(3000);
	    	just_click.sendKeys("QA_test");
	    	
	    	}
	    
	    	}
		


		
	}



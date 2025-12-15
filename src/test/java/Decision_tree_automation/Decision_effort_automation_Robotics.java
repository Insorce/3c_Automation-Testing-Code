package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Decision_effort_automation_Robotics 
{
	
	@Test
	public static void effort_automation_robotics() throws InterruptedException, FileNotFoundException
	{
		
		
		
		String uuid=UUID.randomUUID().toString();
		String[] links = null;
		int linksCount = 0;

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
        // log out code is completed here

		

       Thread.sleep(3000);

       
       
       //click on the view projects
       WebElement rk=driver.findElement(By.xpath("//a[text()=\"View Projects\"]"));
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



				//scroll top to bottom
				Thread.sleep(5000);
				JavascriptExecutor js111 = (JavascriptExecutor) driver;
				js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(5000);
				js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");


				
		
		//click on Automation robotics

		WebDriverWait Automation=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement robotics=Automation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h5[contains(text(),'Automation & Robotics')])[1]")));
		JavascriptExecutor click_robotics = (JavascriptExecutor) driver;
		click_robotics.executeScript("arguments[0].click();", robotics);


		// multiple window handler

		String mainWindowHandle1 = driver.getWindowHandle();
		System.out.println(mainWindowHandle1);

		Set<String> allWindowHandles1 = driver.getWindowHandles();
		System.out.println(allWindowHandles1);

		for (String handle1 : allWindowHandles1)
		{
			if (!handle1.equals(mainWindowHandle1))
			{

				driver.switchTo().window(handle1);
				break;

			}
		}
		System.out.println(mainWindowHandle1);

		//printing child window
		System.out.println("Child Window");


		//clicking on the process map
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("model.Auto_ActivityClick(model.Auto_AllPaths[0].ActionActs[0],model.Auto_AllPaths[0])");


		//click on drop down menu
		WebDriverWait insorce321111111=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Menu111=insorce321111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class=\"form-select\"])[3]")));
		JavascriptExecutor insorce0211111113 = (JavascriptExecutor) driver;
		insorce0211111113.executeScript("arguments[0].click();", Menu111);
		Menu111.sendKeys(Keys.DOWN);
		Menu111.sendKeys(Keys.DOWN);
		Menu111.sendKeys(Keys.ENTER);

		//click on automate
		WebDriverWait insorce3211111111=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Menu1111=insorce3211111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Automate')])[1]")));
		JavascriptExecutor insorce021111111111 = (JavascriptExecutor) driver;
		insorce021111111111.executeScript("arguments[0].click();", Menu1111);

		//click on another drop down menu
		WebDriverWait insorce32111111111=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement hello=insorce32111111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class=\"form-select\"])[4]")));
		JavascriptExecutor insorce0211111111110 = (JavascriptExecutor) driver;
		insorce0211111111110.executeScript("arguments[0].click();", hello);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ENTER);





		//enter the reduced percentage
		WebDriverWait insorcetest1=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test11=insorcetest1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
		test11.clear();
		test11.sendKeys("51");

		Thread.sleep(3000);
		//click on add Automation cost button
		WebDriverWait insorcetest31=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test31=insorcetest31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
		JavascriptExecutor insorce771 = (JavascriptExecutor) driver;
		insorce771.executeScript("arguments[0].click();", test31);
					
		Thread.sleep(4000);				
		//click on check box
		WebDriverWait insorcetest41=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test41=insorcetest41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[3]")));
		JavascriptExecutor insorce77 = (JavascriptExecutor) driver;
		insorce77.executeScript("arguments[0].click();", test41);


//		//click on currency
//		WebDriverWait insorcetest5111111=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement test512=insorcetest5111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='form-select input-small'])[1]")));
//		JavascriptExecutor insorce7712 = (JavascriptExecutor) driver;
//		insorce7712.executeScript("arguments[0].click();", test512);


//		//click on radio button
//		WebDriverWait insorcetest51111111=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement test22=insorcetest51111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='closinginsight145'])[1]")));
//		JavascriptExecutor insorce778 = (JavascriptExecutor) driver;
//		insorce778.executeScript("arguments[0].click();", test22);


		//enter the investement per annum
//		WebDriverWait insorcetest511111111=new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement test511111111=insorcetest511111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[2]")));
//		test511111111.sendKeys("31");


		//enter the depreciation in years
		WebDriverWait insorce9949=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test89=insorce9949.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[3]")));
		test89.sendKeys("34");
		
		//click on price
		

		//enter the AMC in percentage
		WebDriverWait insorcetest51111111111=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test51111111111=insorcetest51111111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[4]")));
		test51111111111.sendKeys("25");

		//click on add list
		WebDriverWait insorcetest5111111112=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test256=insorcetest5111111112.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
		JavascriptExecutor insorce773 = (JavascriptExecutor) driver;
		insorce773.executeScript("arguments[0].click();", test256);

		//click on add to cart
		WebDriverWait insorcetest52172=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement test52172=insorcetest52172.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
		JavascriptExecutor insorce7731 = (JavascriptExecutor) driver;
		insorce7731.executeScript("arguments[0].click();", test52172);


		//click on Review and proceed
		WebDriverWait Review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement proceed=Review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Review & Proceed(1)']")));
		JavascriptExecutor click_proceed = (JavascriptExecutor) driver;
		click_proceed.executeScript("arguments[0].click();", proceed);


		//click on simulate outcome
		WebDriverWait simulate=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement outcome=simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor click_outcome = (JavascriptExecutor) driver;
		click_outcome.executeScript("arguments[0].click();", outcome);


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
				WebDriverWait view=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement results=view.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_view = (JavascriptExecutor) driver;
				click_view.executeScript("arguments[0].click();", results);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}
		
		
		
	}

}

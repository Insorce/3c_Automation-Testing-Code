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

public class Decision_tree_effort_control_redundancy 


{
	@Test
	public static void effort_control_redundancy() throws InterruptedException, FileNotFoundException
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
		WebElement robotics=Automation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='text-center col-sm-12 card card-body benefit-green show']/descendant::h5[text()='Automation & Robotics']")));
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
		WebDriverWait drop=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement down_menu=drop.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class=\"form-select\"])[3]")));
		JavascriptExecutor click_down_menu = (JavascriptExecutor) driver;
		click_down_menu.executeScript("arguments[0].click();", down_menu);
		down_menu.sendKeys(Keys.DOWN);
		down_menu.sendKeys(Keys.DOWN);
		down_menu.sendKeys(Keys.ENTER);

		//click on automate
		WebDriverWait automate=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_automate=automate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Automate')])[1]")));
		JavascriptExecutor automate_click = (JavascriptExecutor) driver;
		automate_click.executeScript("arguments[0].click();", click_automate);

		//click on another drop down menu
		WebDriverWait click_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement hello=click_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class=\"form-select\"])[4]")));
		JavascriptExecutor hello_click = (JavascriptExecutor) driver;
		hello_click.executeScript("arguments[0].click();", hello);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ARROW_DOWN);
		hello.sendKeys(Keys.ENTER);


		//enter the reduced percentage
		WebDriverWait reduced=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement reduced_percentage=reduced.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
		reduced_percentage.clear();
		reduced_percentage.sendKeys("51");

		Thread.sleep(3000);
		//click on add Automation cost button
		WebDriverWait Automationcost=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement add_Automationcost=Automationcost.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
		JavascriptExecutor click = (JavascriptExecutor) driver;
		click.executeScript("arguments[0].click();", add_Automationcost);

		Thread.sleep(4000);				
		//click on check box
		WebDriverWait checkbox=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_checkbox=checkbox.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[3]")));
		JavascriptExecutor insorce77 = (JavascriptExecutor) driver;
		insorce77.executeScript("arguments[0].click();", click_checkbox);


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
		WebDriverWait depreciation=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement depreciation_years=depreciation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[3]")));
		depreciation_years.sendKeys("34");

		//click on price


		//enter the AMC in percentage
		WebDriverWait amc=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement amc_percentage=amc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[4]")));
		amc_percentage.sendKeys("25");

		//click on add list
		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement add_list=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
		JavascriptExecutor click_list = (JavascriptExecutor) driver;
		click_list.executeScript("arguments[0].click();", add_list);

		//click on add to cart
		WebDriverWait cart=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement add_to_cart=cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
		JavascriptExecutor insorce7731 = (JavascriptExecutor) driver;
		insorce7731.executeScript("arguments[0].click();", add_to_cart);


		//click on Review and proceed
		WebDriverWait Review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement proceed=Review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Review & Proceed(1)']")));
		JavascriptExecutor click_proceed = (JavascriptExecutor) driver;
		click_proceed.executeScript("arguments[0].click();", proceed);


		//click on simulate outcome
		WebDriverWait simulate=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement outcome=simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Simulate Outcome'])[1]")));
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
				WebDriverWait optimize=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement click_optimize=optimize.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor project_optimize = (JavascriptExecutor) driver;
				project_optimize.executeScript("arguments[0].click();", click_optimize);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
					

			}
		}




	}

}

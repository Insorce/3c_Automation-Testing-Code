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

public class decision_tree_single_sceanrio_map 

{

	@Test
	public void decision_tree() throws InterruptedException, FileNotFoundException
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
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2024");
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
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2024");
			driver.findElement(By.xpath("//button[@name='Logon']")).click();
			
		}
        // log out code is completed here

		
		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='2610: insorce__228']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

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

		WebDriverWait robotics=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Automation=robotics.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h5[contains(text(),'Automation & Robotics')])[1]")));
		JavascriptExecutor click_robotics = (JavascriptExecutor) driver;
		click_robotics.executeScript("arguments[0].click();", Automation);


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
			

			}
		}
		System.out.println(mainWindowHandle1);

		//printing child window
		System.out.println("Child Window");


		//clicking on the process map
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("model.Auto_ActivityClick(model.Auto_AllPaths[0].ActionActs[0],model.Auto_AllPaths[0])");


		//click on drop down menu
		WebDriverWait drop=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement Menu_click=drop.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='form-select'])[3]")));
		JavascriptExecutor down_menu = (JavascriptExecutor) driver;
		down_menu.executeScript("arguments[0].click();", Menu_click);
		Menu_click.sendKeys(Keys.DOWN);
		Menu_click.sendKeys(Keys.DOWN);
		Menu_click.sendKeys(Keys.ENTER);

		//click on automate
		WebDriverWait automate=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_automate=automate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Automate')])[1]")));
		JavascriptExecutor automate_click = (JavascriptExecutor) driver;
		automate_click.executeScript("arguments[0].click();", click_automate);

		//click on another drop down menu
		WebDriverWait another=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement another_click=another.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='form-select'])[4]")));
		JavascriptExecutor down_menu_click = (JavascriptExecutor) driver;
		down_menu_click.executeScript("arguments[0].click();", another_click);
		another_click.sendKeys(Keys.ARROW_UP);
		another_click.sendKeys(Keys.ARROW_UP);
		another_click.sendKeys(Keys.ARROW_UP);
		another_click.sendKeys(Keys.ARROW_UP);
		another_click.sendKeys(Keys.ARROW_UP);
		another_click.sendKeys(Keys.ENTER);





		//enter the reduced percentage
		WebDriverWait reduced=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage_reduced=reduced.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
		percentage_reduced.clear();
		percentage_reduced.sendKeys("51");

		
		//click on add Automation cost button
		WebDriverWait Automation_cost=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement button_cost=Automation_cost.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
		JavascriptExecutor add_automation_click = (JavascriptExecutor) driver;
		add_automation_click.executeScript("arguments[0].click();", button_cost);
					
		Thread.sleep(4000);				
		//click on check box
		WebDriverWait check=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Check_box=check.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[3]")));
		JavascriptExecutor click_on_check_box = (JavascriptExecutor) driver;
		click_on_check_box.executeScript("arguments[0].click();", Check_box);


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
		WebDriverWait depreciation_years=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement years_click=depreciation_years.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[3]")));
		years_click.sendKeys("34");
		
		//click on price
		

		//enter the AMC in percentage
		WebDriverWait amc_percentage=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage_click=amc_percentage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[4]")));
		percentage_click.sendKeys("25");

		//click on add list
		WebDriverWait add_list=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_add_list=add_list.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
		JavascriptExecutor click_list = (JavascriptExecutor) driver;
		click_list.executeScript("arguments[0].click();", click_add_list);

		//click on add to cart
		WebDriverWait add_cart=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement cart_click_add=add_cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
		JavascriptExecutor go_to_cart = (JavascriptExecutor) driver;
		go_to_cart.executeScript("arguments[0].click();", cart_click_add);


		//click on Review and proceed
		WebDriverWait click_on_review=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_on_cart=click_on_review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Review & Proceed(1)']")));
		JavascriptExecutor click_proceed_review = (JavascriptExecutor) driver;
		click_proceed_review.executeScript("arguments[0].click();", click_on_cart);


		//click on simulate outcome
		WebDriverWait click_simulate_outcome=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement click_simulate=click_simulate_outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor outcome_click = (JavascriptExecutor) driver;
		outcome_click.executeScript("arguments[0].click();", click_simulate);


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
				WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement click_result=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor result_click = (JavascriptExecutor) driver;
				result_click.executeScript("arguments[0].click();", click_result);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle211);
				driver.close();				

			}
		}

		//click on control reduency path

		for (String handle1 : allWindowHandles1)
		{
			if (handle1.equals(mainWindowHandle1))
			{

				driver.switchTo().window(handle1);
				break;

			}
		}


		// multiple window handler
		Thread.sleep(3000);

		String mainWindowHandle611 = driver.getWindowHandle();
		System.out.println(mainWindowHandle611);

		Set<String> allWindowHandles611 = driver.getWindowHandles();
		System.out.println(allWindowHandles611);

		for (String handle1 : allWindowHandles611)
		{
			if (!handle1.equals(mainWindowHandle611))
			{

				driver.switchTo().window(handle1);
				break;

			}
		}


		
		
	}
	
	
}

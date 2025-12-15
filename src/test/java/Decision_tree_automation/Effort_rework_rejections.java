package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Effort_rework_rejections
{

	@Test
	public void effort_rework_rejectons() throws Exception
	{
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/"); 
		Thread.sleep(2000);
		driver.close();
		String a="https://pbl.3-cubed.com/";

		WebDriver driver1 =new ChromeDriver();
		//Launching url 
		driver1.get(a);
		//Maximize window
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//enter username
		driver1.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("Rama krishna");
		//enter password
		driver1.findElement(By.xpath("//input[@placeholder=\"Password\"][1]")).sendKeys("Welcome@2025");
		//click on login button
		driver1.findElement(By.xpath("//button[@class=\"btn btn-default btn-block\"]")).click();

		Thread.sleep(2000);
		//if the account has been not logouted then logout that account first
		String logout="https://pbl.3-cubed.com/Account/LogOn";
		driver1.findElement(By.xpath("//button[text()='Log Out']")).click();

		//enter username
		driver1.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("Rama krishna");
		//enter password
		driver1.findElement(By.xpath("//input[@placeholder=\"Password\"][1]")).sendKeys("Welcome@2025");
		//click on login button
		WebElement click1=driver1.findElement(By.xpath("//button[@class=\"btn btn-default btn-block\"]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver1;
		js11.executeScript("arguments[0].click();", click1);

		//click on the view projects
		WebElement rk=driver1.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver1;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
		WebDriverWait wait=new WebDriverWait(driver1, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='1842: AUTOMATION_PROJECT']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver1;
		insorce1.executeScript("arguments[0].click();", insorce678);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver1, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver1, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver1, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
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
		JavascriptExecutor js111 = (JavascriptExecutor) driver1;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		//		click on edit model
		//		WebDriverWait wait1111=new WebDriverWait(driver1, Duration.ofSeconds(60));
		//		WebElement ProcessMap = wait1111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='dvLeversSection']//child::h5[text()='Edit Process map'])[1]")));
		//		Actions action=new Actions(driver1);
		//		action.click(ProcessMap).build().perform();
		//		Thread.sleep(10000);

		//click on rework and reductions
		WebDriverWait wait11111=new WebDriverWait(driver1, Duration.ofSeconds(6000));
		WebElement insorce5192=wait11111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h5[contains(text(),'Rework Reduction')])[1]")));
		Actions action1=new Actions(driver1);
		action1.click(insorce5192).perform();
		Thread.sleep(10000);


		// multiple window handler

		String mainWindowHandle = driver1.getWindowHandle();
		System.out.println(mainWindowHandle);

		Set<String> allWindowHandles = driver1.getWindowHandles();
		System.out.println(allWindowHandles);

		for (String handle : allWindowHandles)
		{
			if (!handle.equals(mainWindowHandle))
			{

				driver1.switchTo().window(handle);
				break;

			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");

		Thread.sleep(1000);
		int scroll_height = 500;
		JavascriptExecutor js1234=(JavascriptExecutor) driver1;
		js1234.executeScript("window.scrollBy(0,"+scroll_height+ ")");


		//clicking on the process map
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("model.Rwk_ActivityClick(model.ReworkPaths()[0].Decision, model.ReworkPaths()[0])");

		//click on change decision percentage
		Thread.sleep(2000);
		WebDriverWait wait1111=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce6781=wait1111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Change Decision Percentage\"]")));
		JavascriptExecutor insorce11 = (JavascriptExecutor) driver1;
		insorce11.executeScript("arguments[0].click();", insorce6781);


		//click on training
		WebDriverWait wait111111=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce67811=wait111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training']")));
		JavascriptExecutor insorce111 = (JavascriptExecutor) driver1;
		insorce111.executeScript("arguments[0].click();", insorce67811);


		//click Decision Activity
		WebDriverWait wait1111111=new WebDriverWait(driver1, Duration.ofSeconds(30));
		WebElement insorce678111=wait1111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training Required for Decision Activity >>']")));
		JavascriptExecutor insorce1111 = (JavascriptExecutor) driver1;
		insorce1111.executeScript("arguments[0].click();", insorce678111);
		//
		//		//click on raionallize systems
		//		WebDriverWait wait11111111=new WebDriverWait(driver1, Duration.ofSeconds(30));
		//		WebElement insorce6781111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Rationalize systems']")));
		//		JavascriptExecutor insorce11111 = (JavascriptExecutor) driver1;
		//		insorce11111.executeScript("arguments[0].click();", insorce6781111);
		//
		//		//click on add decision tree actvity
		//		WebDriverWait wait888=new WebDriverWait(driver1, Duration.ofSeconds(30));
		//		WebElement insorce67811111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Decision Activity >>']")));
		//		JavascriptExecutor insorce111111 = (JavascriptExecutor) driver1;
		//		insorce111111.executeScript("arguments[0].click();", insorce67811111);

		//click on proceed
		WebDriverWait wait11111111=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce6781111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Proceed'])[2]")));
		insorce6781111.click();

		//		JavascriptExecutor insorce11111 = (JavascriptExecutor) driver1;
		//		insorce11111.executeScript("arguments[0].click();", insorce6781111);

		//		WebElement insorce345=	driver.findElement(By.xpath("(//button[text()='Proceed'])[1]"));
		//		JavascriptExecutor insorce1111111 = (JavascriptExecutor) driver1;
		//		insorce1111111.executeScript("arguments[0].click();", insorce678);


		//enter the input data
		WebDriverWait hi=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce67811111=hi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number' and @class='form-control' and @id='probabilityrow0']")));
		insorce67811111.clear();
		Thread.sleep(3000);
		insorce67811111.sendKeys("1");
		insorce67811111.click();

		//click on enter
		Actions insorce11111111= new Actions(driver1);
		insorce11111111.sendKeys(Keys.ENTER).build().perform();

		//Add the list
		WebDriverWait insorce23=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce89=insorce23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-warning' and contains(text(),'Add to List') ])")));
		JavascriptExecutor insorce71 = (JavascriptExecutor) driver1;
		insorce71.executeScript("arguments[0].click();", insorce89);

		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor js12341=(JavascriptExecutor) driver1;
		js12341.executeScript("window.scrollTo(0,0);");



		//click on Review and proceed
		WebDriverWait insorce233=new WebDriverWait(driver1, Duration.ofSeconds(60));
		WebElement insorce891=insorce233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Review & Proceed(1)']")));
		JavascriptExecutor insorce711 = (JavascriptExecutor) driver1;
		insorce711.executeScript("arguments[0].click();", insorce891);



		//click on simulate outcome
		WebDriverWait insorce2331=new WebDriverWait(driver1, Duration.ofSeconds(40));
		WebElement insorce8911=insorce2331.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Simulate Outcome'])[1]")));
		JavascriptExecutor insorce7111 = (JavascriptExecutor) driver1;
		insorce7111.executeScript("arguments[0].click();", insorce8911);
		
		
		
		//close rework and reduction window using window handler

				String mainWindowHandle2 = driver1.getWindowHandle();
				//System.out.println(mainWindowHandle);

				Set<String> allWindowHandles2 = driver1.getWindowHandles();
				//System.out.println(allWindowHandles2);

				for (String handle : allWindowHandles2)
				{
					if (!handle.equals(mainWindowHandle2))
					{

						//driver1.switchTo().window(handle);
						//click on view results
						WebDriverWait insorce32=new WebDriverWait(driver1, Duration.ofSeconds(100));
						WebElement insorce91=insorce32.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
						JavascriptExecutor insorce02 = (JavascriptExecutor) driver1;
						insorce02.executeScript("arguments[0].click();", insorce91);
						Thread.sleep(90000);
						driver1.navigate().back();
						driver1.switchTo().window(mainWindowHandle2);
						driver1.close();				

					}
				}

		
		
		
		
		
	}
	
	
	
	
}




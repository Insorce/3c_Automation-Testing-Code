package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class drp_menu 
{
	@Test
	public void meu() throws FileNotFoundException, InterruptedException
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
		driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2024");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
		String AA=driver.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) 
		{
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rama krishna");
			//enter password
			driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2024");
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();

		}





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


		//click on non-value added work
		WebDriverWait insorce32=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement insorce91=insorce32.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h5[text()='Non-Value Added work'])[1]")));
		JavascriptExecutor insorce02 = (JavascriptExecutor) driver;
		insorce02.executeScript("arguments[0].click();", insorce91);


		driver.navigate().to("https://pbl.3-cubed.com/Operations/NonProductivePath");

		//switch to anothe window handler

		String mainWindowHandle7 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles7 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle : allWindowHandles7)
		{
			if (!handle.equals(mainWindowHandle7))
			{

				driver.switchTo().window(handle);
				WebDriverWait insorce704=new WebDriverWait(driver, Duration.ofSeconds(80));
				WebElement insorce902=insorce704.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Proceed'])[1]")));
				JavascriptExecutor insorce66 = (JavascriptExecutor) driver;
				insorce66.executeScript("arguments[0].click();", insorce902);
				Thread.sleep(2000);
				JavascriptExecutor jsinsorce324=(JavascriptExecutor) driver;
				jsinsorce324.executeScript("window.scrollTo(0,450);");
				//click on process map

				JavascriptExecutor js5192 = (JavascriptExecutor)driver;
				js5192.executeScript("model.NVA_ActivitySelection(model.AutoSortFilteredList()[0].RoutingActs[0], model.AutoSortFilteredList()[0])");

				//clcik on yes automate
				WebDriverWait insorce3211=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement insorce9111=insorce3211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Automate']")));
				JavascriptExecutor insorce0211 = (JavascriptExecutor) driver;
				insorce0211.executeScript("arguments[0].click();", insorce9111);

				//click on drop down menu
//				WebDriverWait insorce32111=new WebDriverWait(driver, Duration.ofSeconds(60));
//				WebElement Menu=insorce32111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table//tr//td//following::select[@class='form-select'][3])")));
//				JavascriptExecutor insorce02111 = (JavascriptExecutor) driver;
//				insorce02111.executeScript("arguments[0].click();", Menu);
//				Menu.sendKeys(Keys.DOWN);
//				Menu.sendKeys(Keys.DOWN);
//				Menu.sendKeys(Keys.DOWN);
//				Menu.sendKeys(Keys.DOWN);
//				Menu.sendKeys(Keys.DOWN);
//				Menu.sendKeys(Keys.ENTER);
//
//				//click on automate
//				WebDriverWait insorce321111=new WebDriverWait(driver, Duration.ofSeconds(60));
//				WebElement Menu1=insorce321111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Automate')])[1]")));
//				JavascriptExecutor insorce021111 = (JavascriptExecutor) driver;
//				insorce021111.executeScript("arguments[0].click();", Menu1);

				WebElement dropdown = driver.findElement(By.xpath("//div[@id='activityInfoDialogue']/descendant::select[@class='form-select']"));

				Select select=new Select(dropdown);

				select.selectByIndex(2);

				//table 2   //div[@id="ShowSystemsforLegacyDialogue"]/following::select[@class="form-select"]
				
			}

		}
	}
}

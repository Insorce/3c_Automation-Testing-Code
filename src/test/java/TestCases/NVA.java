package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NVA
{
	
	@Test
	public static void nva() throws InterruptedException
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
		// log out code is completed here

		
		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()=\"View Projects\"]"));
		Thread.sleep(3000);
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);


		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4259: zip__file__infosys5182']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


	  

		
		driver.navigate().to("https://pbl.3-cubed.com/Locations/NonProductive");
		
		WebElement click_legend=driver.findElement(By.xpath("//button[@title=\"Legend\"]"));
		//click on the legend
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", click_legend);
		
		
		//click on the close
		
		
		

		//click on the three lines

		WebElement three_lines=driver.findElement(By.xpath("//i[@class='fas fa-bars fa-2x p-2']"));
		JavascriptExecutor three_lines_click= (JavascriptExecutor) driver;
		three_lines_click.executeScript("arguments[0].click();", three_lines);

		//click on the download button

		WebElement download_button=driver.findElement(By.xpath("//a[@title='Download Visio & Recovery']"));
		JavascriptExecutor click_download_button= (JavascriptExecutor) driver;
		click_download_button.executeScript("arguments[0].click();", download_button);

		

		//click on all nva activity links
		List<WebElement> click_all=driver.findElements(By.xpath("//a[contains(@id,'tree')]"));

		for(int p=1; p<click_all.size();p++)
		{


			WebElement click_all_products=driver.findElement(By.xpath("((//a[contains(@id,'tree')])["+p+"])"));


			JavascriptExecutor click_link = (JavascriptExecutor)driver;
			click_link.executeScript("arguments[0].click();", click_all_products);

		}

		
		
		
		
		//click on all downloads under the symbol


		WebElement click_toggle =   driver.findElement(By.xpath("//span[@class='toggle']"));
		JavascriptExecutor toggle_click= (JavascriptExecutor) driver;
		toggle_click.executeScript("arguments[0].click();", click_toggle);
		
		//click on the hyper link
		
		WebElement hper_link=driver.findElement(By.xpath("//a[text()=\"Click here Systems Changed Activities\"]"));
		JavascriptExecutor click_hyperlink= (JavascriptExecutor) driver;
		click_hyperlink.executeScript("arguments[0].click();", click_toggle);
		
		//click on the another hyper link
		WebElement click_another_hyperlink=	driver.findElement(By.xpath("//a[text()='Click here Mode Changed Activities']"));
		JavascriptExecutor hyperlink_2= (JavascriptExecutor) driver;
		hyperlink_2.executeScript("arguments[0].click();", click_another_hyperlink);

		
		
		

		}
		
		
		
		
	}
	
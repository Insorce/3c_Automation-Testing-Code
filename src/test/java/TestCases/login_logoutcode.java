package TestCases;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class login_logoutcode 


{
	
	@Test
	public static void logout()
	{
		
		
		
	

		WebDriver driver1= new ChromeDriver();
		driver1.get("https://pbl.3-cubed.com/");
		String A="https://pbl.3-cubed.com/";	

		
		String WelcomePage="https://pbl.3-cubed.com/Projects/Welcome";

		driver1.get(A);
		//Maximize window
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//enter username
		driver1.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		//enter password
		driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver1.findElement(By.xpath("//button[@name='Logon']")).click();
		String AA=driver1.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://pbl.3-cubed.com/Account/LogOn"))
		{
			driver1.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver1.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
			//enter password
			driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
			driver1.findElement(By.xpath("//button[@name='Logon']")).click();
			
		}
        // log out code is completed here
		
		
		
		//click on the view projects
		WebElement rk=driver1.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver1;
		insorce.executeScript("arguments[0].click();", rk);


		//click on project
		WebDriverWait wait=new WebDriverWait(driver1, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4259: zip__file__infosys5182']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver1;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		
	}

	

		
		
	}



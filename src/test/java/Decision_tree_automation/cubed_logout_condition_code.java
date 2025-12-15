package Decision_tree_automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class cubed_logout_condition_code 
{

    @Test
	public static void logout() throws Exception
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
			
			if(AA.equals(WelcomePage))
			{
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
		
	
		
	    

}
	}

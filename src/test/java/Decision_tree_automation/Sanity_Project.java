package Decision_tree_automation;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sanity_Project 
{

	@Test
	public void insorce() throws InterruptedException
	{

		WebDriver driver= new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/");
		String a="https://pbl.3-cubed.com/";

		String uuid=UUID.randomUUID().toString();
		String[] links = null;
		int linksCount = 0;

		WebDriver driver1 =new ChromeDriver();
		//Launching url 
		driver1.get(a);
		//Maximize window
		driver1.manage().window().maximize();
		//enter username
		driver1.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("Rama krishna");
		//enter password
		driver1.findElement(By.xpath("//input[@placeholder=\"Password\"][1]")).sendKeys("Welcome@2024");
		//click on login button
		driver1.findElement(By.xpath("//button[@class=\"btn btn-default btn-block\"]")).click();

		Thread.sleep(2000);
		//if the account has been not logouted then logout that account first
		String logout="https://pbl.3-cubed.com/Account/LogOn";
		driver1.findElement(By.xpath("//button[text()='Log Out']")).click();

		//enter username
		driver1.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("Rama krishna");
		//enter password
		driver1.findElement(By.xpath("//input[@placeholder=\"Password\"][1]")).sendKeys("Welcome@2024");
		//click on login button
		WebElement click1=driver1.findElement(By.xpath("//button[@class=\"btn btn-default btn-block\"]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver1;
		js11.executeScript("arguments[0].click();", click1);

		//click on the view projects
		WebElement rk=driver1.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver1;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
	    driver.findElement(By.xpath("//a[@href=\"/Projects/Welcome?Pid=1070\"]")).click();
		

	}

}

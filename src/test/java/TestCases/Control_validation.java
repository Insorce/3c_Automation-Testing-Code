package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Control_validation
{
	
	

		

		@Test()
		public static void third_stage_gate() throws InterruptedException 
		
		{
			WebDriver driver= new ChromeDriver();
			driver.get("https://pbl.3-cubed.com/");
			String A="https://pbl.3-cubed.com/";	


			
			
			//automtable
			Thread.sleep(4000);
			WebElement auto=driver.findElement(By.id("108"));
			Actions matable = new Actions(driver);
			matable.contextClick(auto).perform();
			Thread.sleep(4000);
			//click on mark as approved
			WebElement approved_auto=driver.findElement(By.id("Rvd"));
			JavascriptExecutor mark_1 = (JavascriptExecutor)driver;
			mark_1.executeScript("arguments[0].click();", approved_auto);

			//competency 
			Thread.sleep(4000);
			WebElement competency=	driver.findElement(By.id("106"));
			Actions compe = new Actions(driver);
			compe.contextClick(competency).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement id=driver.findElement(By.id("Rvd"));
			JavascriptExecutor id_1 = (JavascriptExecutor)driver;
			id_1.executeScript("arguments[0].click();", id);
			Thread.sleep(4000);
			//control effort 
			Thread.sleep(4000);
			WebElement effort=	driver.findElement(By.id("110"));
			Actions efforts = new Actions(driver);
			efforts.contextClick(effort).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement id_4=driver.findElement(By.id("Rvd"));
			JavascriptExecutor id_5 = (JavascriptExecutor)driver;
			id_5.executeScript("arguments[0].click();", id_4);
			Thread.sleep(4000);
			//nva 

			Thread.sleep(4000);
			WebElement nva=	driver.findElement(By.id("111"));
			Actions nva_1 = new Actions(driver);
			nva_1.contextClick(nva).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement onnva=driver.findElement(By.id("Rvd"));
			JavascriptExecutor on = (JavascriptExecutor)driver;
			on.executeScript("arguments[0].click();", onnva);
			Thread.sleep(4000); 

			//adeqecy 

			Thread.sleep(4000);
			WebElement adeqecy=	driver.findElement(By.id("302"));
			Actions adeqecy_1 = new Actions(driver);
			adeqecy_1.contextClick(adeqecy).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement ade=driver.findElement(By.id("Rvd"));
			JavascriptExecutor qecy = (JavascriptExecutor)driver;
			qecy.executeScript("arguments[0].click();", ade);

			Thread.sleep(4000);
			//effectiveness 
			Thread.sleep(4000);
			WebElement effect=	driver.findElement(By.id("303"));
			Actions ness = new Actions(driver);
			ness.contextClick(effect).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement clickeff=driver.findElement(By.id("Rvd"));
			JavascriptExecutor click_app = (JavascriptExecutor)driver;
			click_app.executeScript("arguments[0].click();", clickeff);
			Thread.sleep(4000);



			//control effort 
			Thread.sleep(4000);
			WebElement control=	driver.findElement(By.id("304"));
			Actions effort_c = new Actions(driver);
			effort_c.contextClick(control).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement click_on=driver.findElement(By.id("Rvd"));
			JavascriptExecutor click_approved = (JavascriptExecutor)driver;
			click_approved.executeScript("arguments[0].click();", click_on);
			Thread.sleep(4000);


			//control effort 
			Thread.sleep(4000);
			WebElement ds_tree=	driver.findElement(By.id("305"));
			Actions decision = new Actions(driver);
			decision.contextClick(ds_tree).perform();
			Thread.sleep(4000);

			//click on mark as approved
			WebElement click_de=driver.findElement(By.id("Rvd"));
			JavascriptExecutor js_id = (JavascriptExecutor)driver;
			js_id.executeScript("arguments[0].click();", click_de);
			Thread.sleep(4000);


	
			
		}
		
 }


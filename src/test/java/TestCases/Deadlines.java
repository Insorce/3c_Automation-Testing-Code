package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class Deadlines extends Baseclass
{


	@Test(invocationCount=1)
	public static void deadlines_9() throws InterruptedException
	{



		WebDriver driver= new ChromeDriver();
		driver.get("https://prod.3-cubed.com/");
		String A="https://prod.3-cubed.com/";	

		
		String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		//enter password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver.findElement(By.xpath("//button[@name='Logon']")).click();
		String AA=driver.getCurrentUrl();
		if(AA.equals(WelcomePage)) {
			System.out.println("Login Success");
		}

		if (AA.equals("https://prod.3-cubed.com/Account/LogOn"))
		{
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
			//enter password
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@name='Logon']")).click();
			
		}
        // log out code is completed here
		
		
		
		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);


		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='5432: infy1043__child__trending']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


	  
		driver.navigate().to("https://prod.3-cubed.com/Process/DeadLines");
		
		
		
		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title='Full screen']"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title='Exit full screen']"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);

		
		//click on deadline link

		List<WebElement> activity_link=	driver.findElements(By.xpath("//div[@id='DLActss']//a"));


		for(int k=1;k<=activity_link.size();k++)
		{


			WebElement deadline_link=	driver.findElement(By.xpath("((//div[@id='DLActss']//a)["+k+"])"));
			JavascriptExecutor on_deadline_click = (JavascriptExecutor)driver;
			on_deadline_click.executeScript("arguments[0].click();", deadline_link);

		}



//		//clik on gen ai tab
//		Thread.sleep(3000);
//		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));	
//		JavascriptExecutor click_genai = (JavascriptExecutor)driver;
//		click_genai.executeScript("arguments[0].click();", gen_ai);

		//click on review
		Thread.sleep(3000);
		WebElement Deadlines_observations=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor deadlines_o = (JavascriptExecutor)driver;
		deadlines_o.executeScript("arguments[0].click();", Deadlines_observations);

		//click on input/edit 

		WebElement input_edit=driver.findElement(By.xpath("//a[@id='edit-tab']"));
		Actions act= new Actions(driver);
		act.doubleClick(input_edit).perform();

		//				//click on close
		//				Thread.sleep(3000);
		//				WebElement on_close=driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		//				JavascriptExecutor mark_close = (JavascriptExecutor)driver;
		//				mark_close.executeScript("arguments[0].click();", on_close);
		//
		//				//click on container
		//				WebElement containers=driver.findElement(By.id("loadDialogue"));
		//				JavascriptExecutor mark = (JavascriptExecutor)driver;
		//				mark.executeScript("arguments[0].click();", containers);
		//				

		//click on close
		Thread.sleep(3000);
		WebElement close_click1=driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		JavascriptExecutor click_close1 = (JavascriptExecutor)driver;
		click_close1.executeScript("arguments[0].click();", close_click1);

		//click on container
		WebElement containers_2=driver.findElement(By.id("loadDialogue"));
		JavascriptExecutor mark_2 = (JavascriptExecutor)driver;
		mark_2.executeScript("arguments[0].click();", containers_2);

		// These deadlines may increase no of FTE in teams
		WebElement fte=driver.findElement(By.xpath("//button[text()='These deadlines may increase no of FTE in teams']"));
		JavascriptExecutor fte_2 = (JavascriptExecutor)driver;
		fte_2.executeScript("arguments[0].click();", fte);


		//mark as reviewed
		WebElement deadlines_review=driver.findElement(By.xpath("(//label[@data-color='blue'])[1]"));
		JavascriptExecutor mark_review = (JavascriptExecutor)driver;
		mark_review.executeScript("arguments[0].click();", deadlines_review);


//		//click on cycle time and utilization
//		WebElement cycle_time=driver.findElement(By.xpath("//button[text()='Cycle  Time and Utilization']"));
//		JavascriptExecutor mark_5 = (JavascriptExecutor)driver;
//		mark_5.executeScript("arguments[0].click();", cycle_time);


		//click on mark as reviewed
		Thread.sleep(3000);
		WebElement reviwed_9=driver.findElement(By.xpath("(//label[@data-color='blue'])[2]"));
		JavascriptExecutor blue_mark = (JavascriptExecutor)driver;
		blue_mark.executeScript("arguments[0].click();", reviwed_9);

		//click on opeartion sites
		WebElement operation_sites=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor click_opearation = (JavascriptExecutor)driver;
		click_opearation.executeScript("arguments[0].click();", operation_sites);



	}


	
	
	
}

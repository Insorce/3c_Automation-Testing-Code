package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class AHT extends Baseclass
{

	@Test
	public static void aht() throws InterruptedException
	
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"5349: zip--test\"]")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(3000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title=\"Input Model\"]"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);


	  

		driver.navigate().to("https://prod.3-cubed.com/Process/AHT");

		//	//scroll by middle
		//	JavascriptExecutor middle = (JavascriptExecutor) driver;
		//	middle.executeScript("window.scrollBy(0,350);");

		//	//click on aht
		//	Thread.sleep(5000);
		//	WebElement aht=driver.findElement(By.xpath("//div[@class='row']//following-sibling::a[@href='/Process/AHT']"));
		//	JavascriptExecutor input_screen = (JavascriptExecutor)driver;
		//	input_screen.executeScript("arguments[0].click();", aht);


//		//click on bulk download
//		WebElement bulk_download=	driver.findElement(By.xpath("//button[text()='Bulk Upload']"));
//		JavascriptExecutor click_bulk_download = (JavascriptExecutor)driver;
//		click_bulk_download.executeScript("arguments[0].click();", bulk_download);
//
//
//		//click on download the aht
//		WebElement download_aht=driver.findElement(By.xpath("//a[text()='Download AHT File']"));
//		JavascriptExecutor download_click = (JavascriptExecutor)driver;
//		download_click.executeScript("arguments[0].click();", download_aht);
//
//		//upload the download aht
//
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3848-peakutilization__values__checking_AHT.xlsm");
//
//		//click on upload
//		WebElement click_upload=	driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor just_click = (JavascriptExecutor)driver;
//		just_click.executeScript("arguments[0].click();", click_upload);

		driver.navigate().refresh();

		List<WebElement> aht_enter=driver.findElements(By.xpath("//div[@id='AHTActs']//following-sibling::td//input[@type='number']"));



		for (int i = 1; i < aht_enter.size(); i++) 
		{


			//enter the aht
			WebDriverWait insorce65=new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement aht_enter_data=insorce65.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='AHTTable']/descendant::input[@type='number']["+i+"]")));
			//WebElement aht_enter_data=driver.findElement(By.xpath("//div[@id='AHTTable']/descendant::input[@type='number']["+i+"]"));

			aht_enter_data.sendKeys(Keys.CONTROL, Keys.chord("a"));
			aht_enter_data.sendKeys(Keys.BACK_SPACE);



			Thread.sleep(2000);
			aht_enter_data.sendKeys("12");
			Actions aht_clear = new Actions(driver);
			aht_clear.sendKeys(Keys.ENTER).build().perform();


		}

		//click on out-scope activities

		List<WebElement> out_scope_activity=driver.findElements(By.xpath("//div[@id='OutProcessTeamActs']/descendant::input[@type='number']"));



		for(int d=1;d<=out_scope_activity.size();d++)
		{


			WebElement enter_data=driver.findElement(By.xpath("//div[@id='OutProcessTeamActs']/descendant::input[@type='number']["+d+"]"));

			enter_data.sendKeys(Keys.CONTROL, Keys.chord("a"));
			enter_data.sendKeys(Keys.BACK_SPACE);



			Thread.sleep(2000);
			enter_data.sendKeys("12");
			Actions aht_clear = new Actions(driver);
			aht_clear.sendKeys(Keys.ENTER).build().perform();


		}








		//click on all the activity links

		List<WebElement> all_links=driver.findElements(By.xpath("//td//a"));



		for(int c=1;c<=all_links.size(); c++)
		{

			WebElement click_all_links=driver.findElement(By.xpath("((//td//a)["+c+"])"));
			JavascriptExecutor just_all_links = (JavascriptExecutor)driver;
			just_all_links.executeScript("arguments[0].click();", click_all_links);

		}



		//click on observations
		WebElement observations=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor observation_click = (JavascriptExecutor)driver;
		observation_click.executeScript("arguments[0].click();", observations);



		//clcik on team minium size under the accordian

		WebElement accordian=driver.findElement(By.xpath("//button[text()='Team Minimum Team Size']"));
		JavascriptExecutor accordian_size = (JavascriptExecutor)driver;
		accordian_size.executeScript("arguments[0].click();", accordian);
		Thread.sleep(3000);

		//click on mark as reviwed
		Thread.sleep(3000);
		WebElement reviewed=driver.findElement(By.xpath("//label[@data-color='blue']"));
		JavascriptExecutor reviewed_51 = (JavascriptExecutor)driver;
		reviewed_51.executeScript("arguments[0].click();", reviewed);
		Thread.sleep(3000);

//		//click on improve
//		WebElement improve=driver.findElement(By.xpath("//a[@id='improve-tab']"));
//		JavascriptExecutor click_improve = (JavascriptExecutor)driver;
//		click_improve.executeScript("arguments[0].click();", improve);


		//click on the path total effort

		WebElement total_effort=driver.findElement(By.xpath("//div[@id='Improve']/descendant::button[@data-bs-toggle='collapse']"));
		JavascriptExecutor click_total_effort = (JavascriptExecutor)driver;
		click_total_effort.executeScript("arguments[0].click();", total_effort);


//		//click on info tab
//
//		WebElement info_tab=	driver.findElement(By.xpath("//a[@id='information-tab']"));
//		JavascriptExecutor click_tab = (JavascriptExecutor)driver;
//		click_tab.executeScript("arguments[0].click();", info_tab);


		//click on the all links in the activity

		List<WebElement> click_activity=driver.findElements(By.xpath("//div[@id='outrng']//table//td//a"));

		for (int y=1;y<click_activity.size();y++)
		{


			WebElement links=  driver.findElement(By.xpath("((//div[@id='outrng']//table//td//a)["+y+"])"));
			JavascriptExecutor click_links = (JavascriptExecutor)driver;
			click_links.executeScript("arguments[0].click();", links);

		}

//		//click on the ai 
//		WebElement click_ai= driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor on_ai = (JavascriptExecutor)driver;
//		on_ai.executeScript("arguments[0].click();", click_ai);
//
//		
		
//		//convet the lots
//		
//		WebElement click_lots=driver.findElement(By.xpath("//button[text()='Convert to LOTs']"));
//		JavascriptExecutor lost_click = (JavascriptExecutor)driver;
//		lost_click.executeScript("arguments[0].click();", click_lots);
//		
//		
//		//click on batch
//		WebElement batch=driver.findElement(By.xpath("//button[text()='Batch']"));
//		JavascriptExecutor batch_click = (JavascriptExecutor)driver;
//		batch_click.executeScript("arguments[0].click();", batch);
//		
//		
//		//click on un match
//		WebElement unmatch=driver.findElement(By.xpath("//button[text()='Un-Batch']"));
//		JavascriptExecutor click_unmatch = (JavascriptExecutor)driver;
//		click_unmatch.executeScript("arguments[0].click();", unmatch);
//		
//		
//		//click on close
//		WebElement close=driver.findElement(By.xpath("//div[@id='LOTConversionDialogue']/descendant::button[text()='Close']"));
//		JavascriptExecutor click_close = (JavascriptExecutor)driver;
//		click_close.executeScript("arguments[0].click();", close);
		

		//click on geolocate team size
		WebElement gelocate_team_size=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor gelocate_team_size_click = (JavascriptExecutor)driver;
		gelocate_team_size_click.executeScript("arguments[0].click();", gelocate_team_size);






		
		
	}
	
	
	
}

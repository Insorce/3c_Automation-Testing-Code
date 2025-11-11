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

public class gelocate_team_size extends Baseclass
{
	
	
	

	@Test(invocationCount=1)
	public static void gelocate_team_size_as_is() throws InterruptedException
	{

		

		WebDriver driver= new ChromeDriver();
		driver.get("https://prod.3-cubed.com/");
		String A="https://prod.3-cubed.com/";	

		
		String WelcomePage="https://prod.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		
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


		//click on geolocate team size
        driver.navigate().to("https://prod.3-cubed.com/Process/GeolocateTeamSize");
		
		
//        //click on bulk upload
//        WebElement bulk_upload=  driver.findElement(By.xpath("//button[text()='Bulk Upload']"));
//        JavascriptExecutor click_upload = (JavascriptExecutor) driver;                            
//        click_upload.executeScript("arguments[0].click();", bulk_upload);
//
//		//click on downlaod the team details
//		WebElement download_team_details=driver.findElement(By.xpath("//a[text()='Download Team Details File']"));
//		JavascriptExecutor team_details = (JavascriptExecutor)driver;
//		team_details.executeScript("arguments[0].click();", download_team_details);
//
//		//upload the team details
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3848-peakutilization__values__checking_TeamDetails.xlsm");
//
//		//click on upload button
//		WebElement upload_button=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_click = (JavascriptExecutor)driver;
//		upload_click.executeScript("arguments[0].click();", upload_button);
//		
		driver.navigate().refresh();
		
		
		//click on view map
		WebElement view_map=	driver.findElement(By.xpath("//button[@id='btnWorldMapAccordion']"));
		JavascriptExecutor click_viewmap = (JavascriptExecutor)driver;
		click_viewmap.executeScript("arguments[0].click();", view_map);
		
		
		//enter the geolocate team size

		List<WebElement>geolocate_team_size=driver.findElements(By.xpath("//table[@id='TmSizetbl']//following-sibling::td//input[@type='text']"));



		for (int teamsize1 = 1 ; teamsize1<=geolocate_team_size.size(); teamsize1++)
		{

			WebElement teamsize=driver.findElement(By.xpath("//table[@id='TmSizetbl']/descendant::input[@type='text']["+teamsize1+"]"));
			teamsize.clear();
			Thread.sleep(3000);
			teamsize.sendKeys("44");
			Actions aht_clear = new Actions(driver);
			aht_clear.sendKeys(Keys.ENTER).build().perform();

		}

//		//click on gen ai
//		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
//		gen_ai_click.executeScript("arguments[0].click();", gen_ai);
//		
		
		//click on observations
		WebElement observations_teamsize=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor observations_team = (JavascriptExecutor)driver;
		observations_team.executeScript("arguments[0].click();", observations_teamsize);

		//click on mark as reviwed
		Thread.sleep(3000);
		WebElement marks_as_reviewed=driver.findElement(By.xpath("//label[@data-color='blue']"));
		JavascriptExecutor mark_click = (JavascriptExecutor)driver;
		mark_click.executeScript("arguments[0].click();", marks_as_reviewed);

//		//click release and wait 
//		WebElement release_wait= driver.findElement(By.xpath("//a[@href='/Process/WaitTypes']"));
//		JavascriptExecutor click_release_wait = (JavascriptExecutor)driver;
//		click_release_wait.executeScript("arguments[0].click();", release_wait);
//
//		
//		driver.navigate().back();
//		
//		
//		//click on volume
//		WebElement volume=	driver.findElement(By.xpath("//a[@href='/Process/Volume']"));
//		JavascriptExecutor click_volume = (JavascriptExecutor)driver;
//		click_volume.executeScript("arguments[0].click();", volume);
//
		
//		driver.navigate().back();
//		
//		
//		//click on gen Ai
//		WebElement click_gen_ai=	driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor cont = (JavascriptExecutor)driver;
//		cont.executeScript("arguments[0].click();", click_gen_ai);

		//click on observations
		WebElement observations_teamsize1=driver.findElement(By.id("obs-tab"));
		JavascriptExecutor observations_team1 = (JavascriptExecutor)driver;
		observations_team1.executeScript("arguments[0].click();", observations_teamsize1);

		
		//click on release and wait types
		Thread.sleep(20000);
		WebElement hello_1=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		JavascriptExecutor click_cont = (JavascriptExecutor)driver;
		click_cont.executeScript("arguments[0].click();", hello_1);


	}



}

package TestCases;

import java.io.IOException;
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
public class gelocate_working_hours extends Baseclass 
{
    @Test
	public void gelocate_working_hours() throws IOException, InterruptedException 
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
		WebElement rk=driver.findElement(By.xpath("//a[text()=\"View Projects\"]"));
		Thread.sleep(3000);
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


	  

		driver.navigate().to("https://prod.3-cubed.com/Process/GeolocateWorkingHours");
//		
//		//click on bulk download
//		WebElement bulk_download=driver.findElement(By.xpath("//button[text()='Bulk Upload']"));
//		JavascriptExecutor click_download = (JavascriptExecutor)driver;
//		click_download.executeScript("arguments[0].click();", bulk_download);
//		
		

		
		//click on the view map
		
		WebElement view_map=driver.findElement(By.xpath("//button[@id='btnMapSectionAccordion']"));
		JavascriptExecutor click_view_map = (JavascriptExecutor)driver;
		click_view_map.executeScript("arguments[0].click();", view_map);


		//click on in scope and out scope
		List<WebElement>scope=driver.findElements(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr"));

		for( int i=1; i<=scope.size(); i++)
		{

			WebElement out_scope=driver.findElement(By.xpath("//div[@id='EditMap']/descendant::label[@class='toggle-switchy']["+i+"]"));
			Thread.sleep(3000);
			JavascriptExecutor scope_out = (JavascriptExecutor)driver;
			scope_out.executeScript("arguments[0].click();", out_scope);


		}


		List<WebElement>rows=driver.findElements(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr"));

      Actions act=new Actions(driver);

		for (int i2 = 1; i2 <=rows.size(); i2++) 
		{


			//enter the location
			WebElement location=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorCity')]"));

			if(location.isEnabled())
			{

				location.clear();
				location.sendKeys("Hyderabad");
				Thread.sleep(3000);
				location.sendKeys(Keys.ARROW_DOWN);
				location.sendKeys(Keys.ENTER);

			}
			else
			{
				System.out.println("location  is not been enbaled");
			}




			//start time

			WebElement start_time=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorStartTime')]"));
			if(start_time.isEnabled())
			{

				start_time.sendKeys(Keys.CONTROL.chord("a"));
				start_time.sendKeys(Keys.BACK_SPACE);
				start_time.sendKeys("10:00");
				Thread.sleep(3000);
				start_time.sendKeys(Keys.ENTER);
			}
			else
			{
				System.out.println("start time is not been enabled");
			}



			//end time
			WebElement end_time=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorWorkingHours')]"));
			if(end_time.isEnabled())
			{
				end_time.sendKeys(Keys.CONTROL.chord("a"));
				end_time.sendKeys(Keys.BACK_SPACE);
				end_time.sendKeys("06:00");
				Thread.sleep(3000);
				//end_time.sendKeys(Keys.ENTER);
			}
			else
			{
				System.out.println("end time is not bene enabled");
			}


			//prodcutive hours
			WebElement productive_hours=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorProductiveHours')]"));
			if(productive_hours.isEnabled())
			{
				productive_hours.sendKeys(Keys.CONTROL.chord("a"));
				productive_hours.sendKeys(Keys.BACK_SPACE);
				productive_hours.sendKeys("10:00");
				Thread.sleep(3000);
				//productive_hours.sendKeys(Keys.ENTER);
			}
			else
			{
				System.out.println("productive hours is not enabled");
			}


			//end time
			WebElement end_time1=driver.findElement(By.xpath("//div[@id='EditMap']//following-sibling::table[@id='dvTeamLocations']//tbody/tr["+i2+"]//following-sibling::input[starts-with(@id,'actorEndTime')]"));
			if(end_time1.isDisplayed())
			{
				end_time1.sendKeys(Keys.CONTROL.chord("a"));
				end_time1.sendKeys(Keys.BACK_SPACE);
				end_time1.sendKeys("9:00");
				Thread.sleep(3000);
				//end_time1.sendKeys(Keys.ENTER);

			}
			else
			{
				System.out.println("end time is not enabled");
			}

		}
		
		//clickk on review
		Thread.sleep(3000);
		WebElement observations_insorce=driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor team_1 = (JavascriptExecutor)driver;
		team_1.executeScript("arguments[0].click();", observations_insorce);


		//click on the hyper links in observations

		WebElement hyper_link=driver.findElement(By.xpath("//div[@id='Observations']/following::a[normalize-space()='Click to View Popup and interaction model']"));
		JavascriptExecutor link_click = (JavascriptExecutor)driver;
		link_click.executeScript("arguments[0].click();", hyper_link);

		
		//click team responsible for rejection outcome
		List<WebElement> team_responsible=driver.findElements(By.xpath("(//table[@class=\"table table-bordered\"])[3]//a"));

		for( int r=1;r<=team_responsible.size(); r++)
		{


			WebElement click_links=	driver.findElement(By.xpath("(//table[@class=\"table table-bordered\"])[3]//a["+r+"]"));
			JavascriptExecutor click_hyperlinks = (JavascriptExecutor)driver;
			click_hyperlinks.executeScript("arguments[0].click();", click_links);


		}
		
		List<WebElement>  click_close=driver.findElements(By.xpath("//button[@type=\"button\"]"));
		
		
		for(int k=1;k<=click_close.size();k++)
		{
			
			WebElement close=driver.findElement(By.xpath("((//button[@type=\"button\"])["+k+"])"));
			Thread.sleep(3000);
			JavascriptExecutor close_click = (JavascriptExecutor)driver;
			close_click.executeScript("arguments[0].click();", close);
			
		}
		
		

//		//click on information
//		Thread.sleep(3000);
//		WebElement information=driver.findElement(By.xpath("//a[@id='information-tab']"));
//		JavascriptExecutor information_click = (JavascriptExecutor)driver;
//		information_click.executeScript("arguments[0].click();", information);
		
		//click on interaction model
		WebElement interaction_model=	driver.findElement(By.xpath("//button[text()='Interaction Model']"));
		JavascriptExecutor click_link = (JavascriptExecutor)driver;
		click_link.executeScript("arguments[0].click();", interaction_model);
		
		
		
		//click on the view popup interaction model
		WebElement click_hyper_link=driver.findElement(By.xpath("//a[text()='Click to View Popup and interaction model']"));
		JavascriptExecutor link_click1 = (JavascriptExecutor)driver;
		link_click1.executeScript("arguments[0].click();", click_hyper_link);

		
		//click on all interactive models
		List<WebElement> interactive_models=driver.findElements(By.xpath("//table//a"));
		
		for(int t=1;t<=interactive_models.size();t++)
		{
			
			WebElement models=driver.findElement(By.xpath("((//table//a)["+t+"])"));

			Thread.sleep(3000);
			JavascriptExecutor click_all_links = (JavascriptExecutor)driver;
			click_all_links.executeScript("arguments[0].click();", models);
			
		}
		//click on the close
		
		WebElement close_popup=	driver.findElement(By.xpath("//div[@id='OpenTeamsInteractionModal']/descendant::button[@type='button']"));
		JavascriptExecutor click_popup = (JavascriptExecutor)driver;
		click_popup.executeScript("arguments[0].click();", close_popup);

		//click on the system and applications
        Thread.sleep(3000);
		WebElement system_applications=	driver.findElement(By.xpath("//a[text()='Systems & Applications ']"));
		JavascriptExecutor system_app_click = (JavascriptExecutor)driver;
		system_app_click.executeScript("arguments[0].click();", system_applications);

		
	
//		//click on gen ai
//		Thread.sleep(3000);
//		WebElement gen_ai=	driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
//		gen_ai_click.executeScript("arguments[0].click();", gen_ai);
//


//		Thread.sleep(3000);
//		WebElement review=driver.findElement(By.xpath("//a[@id='obs-tab']"));
//		JavascriptExecutor review_click = (JavascriptExecutor)driver;
//		review_click.executeScript("arguments[0].click();", review);


		
		Thread.sleep(3000);
		WebElement proceed=driver.findElement(By.xpath("//label[@data-color='blue']"));
		JavascriptExecutor team_91 = (JavascriptExecutor)driver;
		team_91.executeScript("arguments[0].click();", proceed);



		//click on download the team details
//
//		WebElement donwload_details=driver.findElement(By.xpath("//a[text()='Download Team Details File']"));
//		JavascriptExecutor details = (JavascriptExecutor)driver;
//		details.executeScript("arguments[0].click();", donwload_details);
//
//		//upload the downloaded team file
//		WebDriverWait team_location=new WebDriverWait(driver, Duration.ofSeconds(90));
//		team_location.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='BulkUploadFile']"))).sendKeys("D:\\upload_file_input_screens\\Excel_3755-AUTOMATION TESTING_TeamDetails (1).xlsm");
//		
//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3755-AUTOMATION TESTING_TeamDetails (1).xlsm");
//
//		//click on upload
//		
//		WebElement upload=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
//		JavascriptExecutor upload_click = (JavascriptExecutor)driver;
//		upload_click.executeScript("arguments[0].click();", upload);
//		
//	
//		driver.quit();
		
		//click on system and applications
		
		Thread.sleep(3000);
		WebElement  system_and_applications=driver.findElement(By.xpath("//a[text()='Systems & Applications ']"));
		
		JavascriptExecutor click_sys = (JavascriptExecutor)driver;
		click_sys.executeScript("arguments[0].click();", system_and_applications);

    }
    	
	
	
  }

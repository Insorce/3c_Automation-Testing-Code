package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class System_applications extends Baseclass 


{
	@Test
	public void system_and_applications() throws InterruptedException
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


	  





		driver.navigate().to("https://prod.3-cubed.com/Process/SystemsandApplications");

		//click on system and application
		Thread.sleep(1000);
	


		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title='Full screen']"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title='Exit full screen']"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);

		


	

		Thread.sleep(9000);
		//click on manage system & applications
		WebElement manage_system_applications=driver.findElement(By.xpath("//button[text()='Manage Systems & Applications']"));
		JavascriptExecutor click_manage = (JavascriptExecutor)driver;
		click_manage.executeScript("arguments[0].click();", manage_system_applications);

		
//		// Wait object
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		// Wait until the input box is visible and interactable
//		WebElement inputBox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='NewDOEName']")));
//
//		// Clear and type
//		inputBox.clear();
//		inputBox.sendKeys("QA_test");
//
//		// Wait for '+' symbol to be clickable
//		WebElement plusSymbol = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fas fa-plus input-group-text']")));
//
//		// Scroll into view if needed
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plusSymbol);
//
//		// Click the '+' icon using JS if normal click doesn't work
//		try {
//		    plusSymbol.click();
//		} catch (ElementNotInteractableException e)
//		{
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusSymbol);
//		}
//		
//		
//
//
//		Thread.sleep(3000);
//		//click on qa_test
//		WebElement qa_test=driver.findElement(By.xpath("//a[text()='QA_test']"));
//		JavascriptExecutor click_qa_test = (JavascriptExecutor)driver;
//		click_qa_test.executeScript("arguments[0].click();", qa_test);
//
//		//click on search symbol
//		
//		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
//	
//
//
//
//		String dropdownXPath = "//div[@id='idSystitle']/following::select[@class='form-select enableforall']";
//
//		// Re-find dropdown before every access
//		WebElement dropdownElement = driver.findElement(By.xpath(dropdownXPath));
//		Select dropdown = new Select(dropdownElement);
//
//		// Get latest options list each time
//		List<WebElement> options = dropdown.getOptions();
//
//		// Loop with re-finding inside
//		for (int i = 0; i < options.size(); i++)
//		{
//		    // Re-fetch dropdown and options again
//		    dropdownElement = driver.findElement(By.xpath(dropdownXPath));
//		    dropdown = new Select(dropdownElement);
//		    options = dropdown.getOptions();  // Refresh the options too
//
//		    WebElement option = options.get(i);
//		    String value = option.getText().trim();
//
//		    if (!value.equalsIgnoreCase("Select") && !value.isEmpty()) 
//		    {
//		        dropdown.selectByIndex(i);  // Safe to interact now
//		        System.out.println("Selected: " + value);
//		        Thread.sleep(1000);
//		    }
//		}
//
//		
//		//click on the check box
//		WebElement check_box=driver.findElement(By.xpath("//th//input[@type='checkbox']"));
//		JavascriptExecutor click_check_box = (JavascriptExecutor)driver;
//		click_check_box.executeScript("arguments[0].click();", check_box);
//		
//		// Click the 'Add/Associate' button
//		WebElement add=	driver.findElement(By.xpath("//button[text()='Add/Associate']"));
//		JavascriptExecutor click_add = (JavascriptExecutor)driver;
//		click_add.executeScript("arguments[0].click();", add);
//
//		
//		//click on delete from activity
//		WebElement click_delete=driver.findElement(By.xpath("//a[@id=\"DelAct-tab\"]"));
//		JavascriptExecutor click_ondelete = (JavascriptExecutor)driver;
//		click_ondelete.executeScript("arguments[0].click();", click_delete);
//		
//		
//		
//		String dropdownXPath1 = "((//select[@id=\"search-doe\"])[2])";
//
//		// Re-find dropdown before every access
//		WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXPath1));
//		Select dropdown1 = new Select(dropdownElement1);
//
//		// Get latest options list each time
//		List<WebElement> options1 = dropdown1.getOptions();
//
//		// Loop with re-finding inside
//		for (int i = 0; i < options1.size(); i++)
//		{
//		    // Re-fetch dropdown and options again
//		    dropdownElement1 = driver.findElement(By.xpath(dropdownXPath1));
//		    dropdown1 = new Select(dropdownElement1);
//		    options1 = dropdown1.getOptions();  // Refresh the options too
//
//		    WebElement option = options1.get(i);
//		    String value = option.getText().trim();
//
//		    if (!value.equalsIgnoreCase("Select") && !value.isEmpty()) 
//		    {
//		        dropdown1.selectByIndex(i);  // Safe to interact now
//		        System.out.println("Selected: " + value);
//		        Thread.sleep(1000);
//		    }
//		}
//
//		
//		
//		
//
//
//		String dropdownXPath11 = "//div[@id='idSystitle']/following::select[@class='form-select enableforall']";
//
//		// Re-find dropdown before every access
//		WebElement dropdownElement11 = driver.findElement(By.xpath(dropdownXPath11));
//		Select dropdown11 = new Select(dropdownElement11);
//
//		// Get latest options list each time
//		List<WebElement> options11 = dropdown11.getOptions();
//
//		// Loop with re-finding inside
//		for (int i = 0; i < options11.size(); i++)
//		{
//		    // Re-fetch dropdown and options again
//		    dropdownElement11 = driver.findElement(By.xpath(dropdownXPath11));
//		    dropdown11 = new Select(dropdownElement11);
//		    options11 = dropdown11.getOptions();  // Refresh the options too
//
//		    WebElement option = options11.get(i);
//		    String value = option.getText().trim();
//
//		    if (!value.equalsIgnoreCase("Select") && !value.isEmpty()) 
//		    {
//		        dropdown11.selectByIndex(i);  // Safe to interact now
//		        System.out.println("Selected: " + value);
//		        Thread.sleep(1000);
//		    }
//		}
//
//		
//		//click on the check box
//		WebElement check_box1=driver.findElement(By.xpath("//th//input[@type='checkbox']"));
//		JavascriptExecutor click_check_box1 = (JavascriptExecutor)driver;
//		click_check_box1.executeScript("arguments[0].click();", check_box1);
//		
//		
//		// Click the delete button
//		WebElement delete=	driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
//		JavascriptExecutor click_on_delete = (JavascriptExecutor)driver;
//		click_on_delete.executeScript("arguments[0].click();", delete);
//		
//		
//		//click on yes delete
//		WebElement yes_delete=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//		JavascriptExecutor click_yes_delete = (JavascriptExecutor)driver;
//		click_yes_delete.executeScript("arguments[0].click();", yes_delete);
//		
//		//click on replace system and applications
//		WebElement click_replace=	driver.findElement(By.xpath("//a[@id=\"RpleForms-tab\"]"));
//		JavascriptExecutor click_onclick_replace = (JavascriptExecutor)driver;
//		click_onclick_replace.executeScript("arguments[0].click();", click_replace);
//
//		//select the system application for replace
//		
//
//
//		String dropdownXPath111 = "((//div[@id=\"dvAddRemovePopUp\"]/following::select[@class='form-select enableforall'])[1])";
//
//		// Re-find dropdown before every access
//		WebElement dropdownElement111 = driver.findElement(By.xpath(dropdownXPath111));
//		Select dropdown111 = new Select(dropdownElement111);
//
//		// Get latest options list each time
//		List<WebElement> options111 = dropdown111.getOptions();
//
//		// Loop with re-finding inside
//		for (int i = 0; i < options111.size(); i++)
//		{
//		    // Re-fetch dropdown and options again
//		    dropdownElement111 = driver.findElement(By.xpath(dropdownXPath111));
//		    dropdown111 = new Select(dropdownElement111);
//		    options111 = dropdown111.getOptions();  // Refresh the options too
//
//		    WebElement option = options111.get(i);
//		    String value = option.getText().trim();
//
//		    if (!value.equalsIgnoreCase("Select") && !value.isEmpty()) 
//		    {
//		        dropdown111.selectByIndex(i);  // Safe to interact now
//		        System.out.println("Selected: " + value);
//		        Thread.sleep(1000);
//		    }
//		}
//
//		
//		//click on trigger
//		
//		driver.findElement(By.xpath("((//div[@id=\"CommonDivSearch\"]/descendant::input[@type=\"text\"])[2])")).sendKeys("loan origination system");
//	
//		WebElement click_trigger=driver.findElement(By.xpath("((//div[@class=\"ms-trigger-ico\"])[2])"));
//		JavascriptExecutor click_on_trigger = (JavascriptExecutor)driver;
//		click_on_trigger.executeScript("arguments[0].click();", click_trigger);
//		
//		
//		
//		
//		
//		//click on the replace
//		WebElement replace=driver.findElement(By.xpath("//div[@id=\"SearchModel\"]/descendant::button[@class=\"btn btn-warning\"]"));
//		JavascriptExecutor click_on_replace = (JavascriptExecutor)driver;
//		click_on_replace.executeScript("arguments[0].click();", replace);
//		
//		
//		//click on the check box
//		WebElement check_box11=driver.findElement(By.xpath("//th//input[@type='checkbox']"));
//		JavascriptExecutor click_check_box11 = (JavascriptExecutor)driver;
//		click_check_box11.executeScript("arguments[0].click();", check_box11);
//		
//		
//		//click on ok
//		WebElement ok=driver.findElement(By.xpath("//button[@id=\"alertify-ok\"]"));
//		JavascriptExecutor click_on_ok = (JavascriptExecutor)driver;
//		click_on_ok.executeScript("arguments[0].click();", ok);
//		
//		
//
//
//		
//		//click on close 
//		WebElement close=driver.findElement(By.xpath("//div[@id='SearchModel']/descendant::button[@type='button']"));
//		JavascriptExecutor click_close = (JavascriptExecutor)driver;
//		click_close.executeScript("arguments[0].click();", close);
//		
//		
//		
//		
//		
//		
//			//click on review
//			Thread.sleep(3000);
//			WebElement observations=driver.findElement(By.xpath("//a[@id='review-tab']"));
//			JavascriptExecutor ob_sys = (JavascriptExecutor)driver;
//			ob_sys.executeScript("arguments[0].click();", observations);
//
//
//			
//			//click on similar system and applications
//
//			WebElement click_similar_application=	driver.findElement(By.xpath("//button[text()='Similar Systems & Applications in project']"));
//			JavascriptExecutor click_similar = (JavascriptExecutor)driver;
//			click_similar.executeScript("arguments[0].click();", click_similar_application);
//
//
//			//click on interaction model	
//			WebElement model=	driver.findElement(By.xpath("//a[text()='Click to View Popup and interaction model']"));
//			JavascriptExecutor click_model = (JavascriptExecutor)driver;
//			click_model.executeScript("arguments[0].click();", model);
//
//		
//			//click on classify
//			WebElement classify=	driver.findElement(By.xpath("//button[text()='Classify']"));
//			JavascriptExecutor click_classify = (JavascriptExecutor)driver;
//			click_classify.executeScript("arguments[0].click();", classify);
//
//			
//			
//			//click on standarization application
//			WebElement application=driver.findElement(By.xpath("//button[text()='Standardization Check for Systems & Applications']"));
//			JavascriptExecutor click_application = (JavascriptExecutor)driver;
//			click_application.executeScript("arguments[0].click();", application);
//			
//			//click on the link
//			WebElement edit_project_details=driver.findElement(By.xpath("//a[@href=\"/Projects/ProjectAdmin\"]"));
//			JavascriptExecutor just_click = (JavascriptExecutor)driver;
//			just_click.executeScript("arguments[0].click();", edit_project_details);
//
//
//			//enter the project name 
//
//			driver.findElement(By.xpath("//input[@id=\"editPrjctId\"]")).clear();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//input[@id=\"editPrjctId\"]")).sendKeys("AUTOMATION TESTING");
//
//
//			//enter the project decsription
//
//
//			driver.findElement(By.xpath("//textarea[@id=\"projectNarrat\"]")).sendKeys("AUTOMATION TESTING");
//
//
//
//
//			//click on save 
//			WebElement save=driver.findElement(By.xpath("//button[@id=\"btnEditProject\"]"));
//			JavascriptExecutor click_save = (JavascriptExecutor)driver;
//			click_save.executeScript("arguments[0].click();", save);
//
//			Thread.sleep(3000);
//
//			driver.navigate().back();
//
//
////			//click on gen ai
////			Thread.sleep(3000);
////			WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
////			JavascriptExecutor ai_click = (JavascriptExecutor)driver;
////			ai_click.executeScript("arguments[0].click();", gen_ai);
//
//			
//			driver.navigate().refresh();
//			
//			//click on all links
//			
//			
//			List<WebElement> allinks=driver.findElements(By.xpath("//td[1]//a"));
//			
//			
//			for(int p=1;p<allinks.size();p++)
//			{
//				
//				WebElement allclicks=driver.findElement(By.xpath("((//td[1]//a)["+p+"])"));
//				JavascriptExecutor click = (JavascriptExecutor)driver;
//				click.executeScript("arguments[0].click();", allclicks);
//				
//			}
//			
//			
//			//click on review
//			WebElement review=driver.findElement(By.xpath("//a[@id='review-tab']"));
//			JavascriptExecutor review_clcik = (JavascriptExecutor)driver;
//			review_clcik.executeScript("arguments[0].click();", review);
//
//
//
		
		
	
		}
}


		
		
	

	
	


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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class products extends Baseclass 
{

	@Test
	public void products() throws InterruptedException
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


		Thread.sleep(3000);

		driver.navigate().to("https://prod.3-cubed.com/Process/Product");

		//		//click on product
		//		WebElement product=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor product_click = (JavascriptExecutor)driver;
		//		product_click.executeScript("arguments[0].click();", product);





		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title='Full screen']"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title='Exit full screen']"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);



		//		//click on download product file
		//		WebElement download_file=driver.findElement(By.xpath("//a[text()='Download Product File']"));
		//		JavascriptExecutor download = (JavascriptExecutor)driver;
		//		download.executeScript("arguments[0].click();", download_file);

		//		Thread.sleep(3000);
		//		//click on choose file
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3755-AUTOMATION TESTING_Products.xlsm");
		//
		//		//click on upload
		//		WebElement upload_click=driver.findElement(By.xpath("//button[@id='btnBulkUpload']"));
		//		JavascriptExecutor upload_10 = (JavascriptExecutor)driver;
		//		upload_10.executeScript("arguments[0].click();", upload_click);
		//		
		driver.navigate().refresh();

		//click on all product activity links
		List<WebElement> click_all=driver.findElements(By.xpath("//div[@id='tblactprodlist']//tr//a"));

		for(int p=1; p<click_all.size();p++)
		{


			WebElement click_all_products=driver.findElement(By.xpath("((//div[@id='tblactprodlist']//tr//a)["+p+"])"));


			JavascriptExecutor click_link = (JavascriptExecutor)driver;
			click_link.executeScript("arguments[0].click();", click_all_products);

		}



		//click on manage products
		WebElement manage_products=	driver.findElement(By.xpath("//button[text()='Manage Products']"));
		JavascriptExecutor click_products = (JavascriptExecutor)driver;
		click_products.executeScript("arguments[0].click();", manage_products);


		// Create explicit wait object (e.g., 10 seconds)
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until input box is visible and clickable
		WebElement product = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='NewProdName']")));

		// Clear existing text (if any)
		product.clear();

		// Generate unique numeric value based on current time (milliseconds)
		String uniqueNumber = String.valueOf(System.currentTimeMillis() % 1000000); // last 6 digits
		String uniqueName = "QA_test_" + uniqueNumber;

		// Type unique product name
		product.sendKeys(uniqueName);

		// Log for debugging
		System.out.println("Generated product name: " + uniqueName);

		Thread.sleep(5000);
		//click on + icon to add the requisition
		WebElement add_requsition= driver.findElement(By.xpath("//i[@class='fas fa-plus input-group-text']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(add_requsition).click().perform();

		//click on the text
    	WebElement text=driver.findElement(By.xpath("//a[contains(text(),'QA_test_')]"));
        JavascriptExecutor click_text = (JavascriptExecutor)driver;
        click_text.executeScript("arguments[0].click();", text);
        			


//
//        try
//        {
//            WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//            // ✅ Wait up to 5 seconds for the alert button to be present
//            WebElement sendRequisition = wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='alertify-ok']")));
//
//            // ✅ Check if it's visible before clicking
//            if (sendRequisition.isDisplayed())
//            {
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].click();", sendRequisition);
//                System.out.println("✅ Notification button clicked successfully.");
//            } 
//            else 
//            {
//                System.out.println("⚠️ Notification button found but not visible.");
//            }
//
//        } 
//        catch (Exception e)
//        {
//            System.out.println("❌ Error while clicking notification: " + e.getMessage());
//        }
//        
//      //search the text
//        
//      WebElement search_text=  driver.findElement(By.xpath("//input[@id='ActivitySearchText']"));
//   
//      search_text.sendKeys("Start");
//
//      // ✅ Perform keyboard actions — Down Arrow + Enter
//      actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//
//      
//      //click on search button
//      WebElement search_button= driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
//      JavascriptExecutor click_search_button = (JavascriptExecutor)driver;
//      click_search_button.executeScript("arguments[0].click();", search_button);
//
//      
//      //click on the check box to select the activity
//
//      WebElement check_box= driver.findElement(By.xpath("//input[@class='checkbox']"));
//      JavascriptExecutor click_check_box = (JavascriptExecutor)driver;
//      click_check_box.executeScript("arguments[0].click();", check_box);
//
//
//      //click on the assign activity button
//
//	  WebElement assign_activity= driver.findElement(By.xpath("((//input[@type='checkbox'])[3])"));
//	  JavascriptExecutor click_assign_activity = (JavascriptExecutor)driver;
//	  click_assign_activity.executeScript("arguments[0].click();", assign_activity);
//	  
//	  
//	  //click on ok button
//	  
//	  WebElement ok_button= driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//	  JavascriptExecutor click_ok_button = (JavascriptExecutor)driver;
//	  click_ok_button.executeScript("arguments[0].click();", ok_button);
//      
//
//
//
//		//click on delete from activity
//		WebElement click_delete=driver.findElement(By.xpath("//a[@id='DelProds-tab']"));
//		JavascriptExecutor click_ondelete = (JavascriptExecutor)driver;
//		click_ondelete.executeScript("arguments[0].click();", click_delete);
//
//
//		//click on choose team
//
//		WebElement choose_team=driver.findElement(By.xpath("((//select[@class=\"form-select enableforall\"])[3])"));
//		Select select3 = new Select(choose_team);
//
//		// Select by visible text
//		select3.selectByVisibleText("Choose Product");
//
//
//
//		WebElement dropdown = driver.findElement(By.xpath("((//select[@class=\"form-select enableforall\"])[3])"));
//		Select select = new Select(dropdown);
//
//		// Select by visible text
//		select.selectByVisibleText("Choose Team");
//
//
//
//
//
//		Thread.sleep(3000);
//		//click on the check box
//		WebElement check_box1=driver.findElement(By.xpath("//th//input[@type='checkbox']"));
//		JavascriptExecutor click_check_box1 = (JavascriptExecutor)driver;
//		click_check_box1.executeScript("arguments[0].click();", check_box1);
//
//
//
//
//		// Click the delete button
//		WebElement delete=	driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
//		JavascriptExecutor click_on_delete = (JavascriptExecutor)driver;
//		click_on_delete.executeScript("arguments[0].click();", delete);
//
//
//		//click on yes delete
//		WebElement yes_delete=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//		JavascriptExecutor click_yes_delete = (JavascriptExecutor)driver;
//		click_yes_delete.executeScript("arguments[0].click();", yes_delete);
//
//		//click on replace products
//		WebElement click_replace= driver.findElement(By.xpath("//a[@id='RpleProds-tab']"));
//		JavascriptExecutor click_onclick_replace = (JavascriptExecutor)driver;
//		click_onclick_replace.executeScript("arguments[0].click();", click_replace);
//
//		//select the product for replace
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
//			// Re-fetch dropdown and options again
//			dropdownElement111 = driver.findElement(By.xpath(dropdownXPath111));
//			dropdown111 = new Select(dropdownElement111);
//			options111 = dropdown111.getOptions();  // Refresh the options too
//
//			WebElement option = options111.get(i);
//			String value = option.getText().trim();
//
//			if (!value.equalsIgnoreCase("Select") && !value.isEmpty()) 
//			{
//				dropdown111.selectByIndex(i);  // Safe to interact now
//				System.out.println("Selected: " + value);
//				Thread.sleep(1000);
//			}
//		}
//
//
//
//
//
//
//		//click on the replace
//		WebElement replace=driver.findElement(By.xpath("//a[@id='RpleProds-tab']"));
//		JavascriptExecutor click_on_replace = (JavascriptExecutor)driver;
//		click_on_replace.executeScript("arguments[0].click();", replace);
//
//
//		//select the drop down menu
//
//		//((//select[@class="form-select enableforall"])[2])
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
//		//click on improve
//		Thread.sleep(3000);
//		WebElement improve=driver.findElement(By.xpath("//a[@id='perfimp-tab']"));
//		JavascriptExecutor improve_click = (JavascriptExecutor)driver;
//		improve_click.executeScript("arguments[0].click();", improve);
//
//
//		//click on view
//		WebElement view=driver.findElement(By.xpath("//button[text()='View']"));
//		JavascriptExecutor click_view = (JavascriptExecutor)driver;
//		click_view.executeScript("arguments[0].click();", view);
//
//
//		//click on close
//		WebElement close1=driver.findElement(By.xpath("//div[@id=\"ProductActivityModal\"]/descendant::button[@type=\"button\"]"));
//		JavascriptExecutor click_close1 = (JavascriptExecutor)driver;
//		click_close1.executeScript("arguments[0].click();", close1);
//
//		//click on interaction model
//
//		WebElement model=	driver.findElement(By.xpath("//a[text()='Click to View Popup and interaction model']"));
//		JavascriptExecutor click_model = (JavascriptExecutor)driver;
//		click_model.executeScript("arguments[0].click();", model);
//
//
//		//click on close pop up
//		WebElement close_popup=driver.findElement(By.xpath("//div[@id=\"OpenProdInteractionModal\"]/descendant::button[@type=\"button\"]"));
//		JavascriptExecutor click_close_popup = (JavascriptExecutor)driver;
//		click_close_popup.executeScript("arguments[0].click();", close_popup);
//
//
//		//click on compare
//		Thread.sleep(3000);
//		WebElement compare=driver.findElement(By.xpath("//a[@id='adv-tab']"));
//		JavascriptExecutor compare_9 = (JavascriptExecutor)driver;
//		compare_9.executeScript("arguments[0].click();", compare);
//
//
//		//click on standardization 
//		WebElement classify=driver.findElement(By.xpath("//button[text()='Standardization Check for Products']"));
//		JavascriptExecutor click_classify = (JavascriptExecutor)driver;
//		click_classify.executeScript("arguments[0].click();", classify);
//
//
//
//
//		//click on the link
//
//		WebElement edit_project_details=driver.findElement(By.xpath("//a[@href=\"/Projects/ProjectAdmin\"]"));
//		JavascriptExecutor just_click1 = (JavascriptExecutor)driver;
//		just_click1.executeScript("arguments[0].click();", edit_project_details);
//
//
//		//enter the project name 
//
//		driver.findElement(By.xpath("//input[@id=\"editPrjctId\"]")).clear();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id=\"editPrjctId\"]")).sendKeys("AUTOMATION TESTING");
//
//
//		//enter the project decsription
//
//
//		driver.findElement(By.xpath("//textarea[@id=\"projectNarrat\"]")).sendKeys("AUTOMATION TESTING");
//
//
//
//
//		//click on save 
//		WebElement save=driver.findElement(By.xpath("//button[@id='btnEditProject']"));
//		JavascriptExecutor click_save = (JavascriptExecutor)driver;
//		click_save.executeScript("arguments[0].click();", save);
//
//		Thread.sleep(3000);
//
//		driver.navigate().back();
//
//
//
//		//click on gen ai
//		Thread.sleep(3000);
//		WebElement gen_ai_click=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor gen_ai_click_on = (JavascriptExecutor)driver;
//		gen_ai_click_on.executeScript("arguments[0].click();", gen_ai_click);
//
//		//click on review
//		WebElement review_product=driver.findElement(By.xpath("//a[@id='obs-tab']"));
//		JavascriptExecutor product_review = (JavascriptExecutor)driver;
//		product_review.executeScript("arguments[0].click();", review_product);
//
//
//		//click on product ratio
//		Thread.sleep(1000);
//		WebElement product_ratio=driver.findElement(By.xpath("//button[text()='Product Conversion Ratio']"));
//		JavascriptExecutor ratio = (JavascriptExecutor)driver;
//		ratio.executeScript("arguments[0].click();", product_ratio);
//
//		//click on mark as reviwed
//		Thread.sleep(5000);
//		WebElement toggle_mark_as_reviewed=driver.findElement(By.xpath("//label[@data-color='blue']"));
//		JavascriptExecutor toggle_review = (JavascriptExecutor)driver;
//		toggle_review.executeScript("arguments[0].click();", toggle_mark_as_reviewed);
//
//
//		//click on product ratio
//		Thread.sleep(1000);
//		WebElement product_ratio1=driver.findElement(By.xpath("//button[text()='Product Conversion Ratio']"));
//		JavascriptExecutor ratio1 = (JavascriptExecutor)driver;
//		ratio1.executeScript("arguments[0].click();", product_ratio1);
//
//		WebElement periodic_activities= driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
//		JavascriptExecutor activities = (JavascriptExecutor)driver;
//		activities.executeScript("arguments[0].click();", periodic_activities);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='alertify-cancel']")).click();
//
//
//	}
//
//		
		 
	}
}

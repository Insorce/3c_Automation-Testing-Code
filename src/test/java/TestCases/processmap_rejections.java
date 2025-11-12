package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;
public class processmap_rejections extends Baseclass
{

	@Test
	public void processmap_rejections() throws InterruptedException 
	{
		

		WebDriver driver= new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/");
		String A="https://pbl.3-cubed.com/";	

		
		String WelcomePage="https://pbl.3-cubed.com/Projects/Welcome";

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

		if (AA.equals("https://pbl.3-cubed.com/Account/LogOn"))
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
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4259: zip__file__infosys5182']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;                            
		insorce1.executeScript("arguments[0].click();", insorce678);

		
		//click on input button
		Thread.sleep(5000);
		WebElement input_button=driver.findElement(By.xpath("//a[@title='Input Model']"));
		JavascriptExecutor click_input_button = (JavascriptExecutor)driver;
		click_input_button.executeScript("arguments[0].click();", input_button);
		
		
//		//select the all the teams
//		List<WebElement> all_teams=	driver.findElements(By.xpath("(//table//tr//td[1])"));
//		
//		
//		
//		for(int i=1;i<=all_teams.size();i++)
//		{
//		
//		
//		
//	   WebElement check_box=  driver.findElement(By.xpath("((//table//tr//td[1])["+i+"])"));
//	   JavascriptExecutor click_check_box = (JavascriptExecutor) driver;                            
//	   click_check_box.executeScript("arguments[0].click();", check_box);
//		
//		
//		}
//		
//		
//		//click on the merge teams
//		
//	    WebElement merge_teams = driver.findElement(By.xpath("//button[text()='Merge Teams']"));
//	    JavascriptExecutor click_merge_teams = (JavascriptExecutor) driver;                            
//	    click_merge_teams.executeScript("arguments[0].click();", merge_teams);
//		
//	    //click on ok 
//	    Thread.sleep(3000);
//	    WebElement ok=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//	    JavascriptExecutor click_ok = (JavascriptExecutor) driver;                            
//	    click_ok.executeScript("arguments[0].click();", ok);
//	    
//	    
//	    
//		
//		//click on the proceed
//		WebDriverWait click_proceed=new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement click_proceed_button=click_proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-warning float-end']")));
//		JavascriptExecutor click_button = (JavascriptExecutor) driver;                            
//		click_button.executeScript("arguments[0].click();", click_proceed_button);
//		
//		
//        //click on the save 
//		WebElement save=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
//		JavascriptExecutor click_save = (JavascriptExecutor) driver;                            
//		click_save.executeScript("arguments[0].click();", save);
//				
//        //click  on prev
//		WebElement prev=driver.findElement(By.xpath("//button[@class=\"btn btn-sm btn-secondary\"]"));
//		JavascriptExecutor click_prev = (JavascriptExecutor) driver;
//		click_prev.executeScript("arguments[0].click();", prev);
//		
//		
//		//click on the next button
//		WebElement next=driver.findElement(By.xpath("//button[@class='btn btn-sm btn-secondary ms-2']"));
//		JavascriptExecutor click_next = (JavascriptExecutor) driver;
//		click_next.executeScript("arguments[0].click();", next);
//		
//		//click on proceed button
//		WebElement proceed=driver.findElement(By.xpath("//button[text()='Proceed']"));
//		JavascriptExecutor click_pro = (JavascriptExecutor) driver;
//		click_pro.executeScript("arguments[0].click();", proceed);
//		
//		
//		//click on the let's go button
//		WebElement lets_go=driver.findElement(By.xpath("//a[text()='Let's Begin']"));
//		JavascriptExecutor click_lets_go = (JavascriptExecutor) driver;	
//		click_lets_go.executeScript("arguments[0].click();", lets_go);
//		

		
		//click on process map and rejections
	    Thread.sleep(3000);
		WebElement process_map_rejections=driver.findElement(By.xpath("//div[@class='row']//following-sibling::a[@href='/Process/ProcessMapRejections']"));
		JavascriptExecutor process_map = (JavascriptExecutor)driver;
		process_map.executeScript("arguments[0].click();", process_map_rejections);


	

		//click on the rejection outcomes end activity text


		List<WebElement> click_text=driver.findElements(By.xpath("//div[@id='EndActivitiesScroll']/descendant::td[contains(@id, 'act')]"));


		for(int k=1;k<=click_text.size();k++)
		{


			WebElement click_rejections=driver.findElement(By.xpath("//div[@id='EndActivitiesScroll']/descendant::td[contains(@id, 'act')]["+k+"]"));
			
			JavascriptExecutor rejections_click = (JavascriptExecutor)driver;
			rejections_click.executeScript("arguments[0].click();", click_rejections);

		}



		//click on expand process map

		WebElement expand_procees_map=driver.findElement(By.xpath("//a[@title=\"Full screen\"]"));
		JavascriptExecutor click_expand_procees_map = (JavascriptExecutor)driver;
		click_expand_procees_map.executeScript("arguments[0].click();", expand_procees_map);


		//click on process map to same position

		WebElement again_click_processmap=driver.findElement(By.xpath("//a[@title=\"Exit full screen\"]"));
		JavascriptExecutor click_unhide_processmap = (JavascriptExecutor)driver;
		click_unhide_processmap.executeScript("arguments[0].click();", again_click_processmap);


		//click on search icon
		WebElement search_icon=driver.findElement(By.xpath("//strong[@data-bind=\"click: ShowSearch\"]"));
		JavascriptExecutor click_search_icon = (JavascriptExecutor)driver;
		click_search_icon.executeScript("arguments[0].click();", search_icon);


		//click on the search text 
		driver.findElement(By.xpath("//input[@id=\"ActivitySearchText\"]")).sendKeys("Send ICD task");


		//click on the search button
		WebElement search_button=driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		JavascriptExecutor click_search_button = (JavascriptExecutor)driver;
		click_search_button.executeScript("arguments[0].click();", search_button);

		//click on close button
		WebElement close_button=driver.findElement(By.xpath("//div[@id=\"SearchModel\"]/descendant::button[@class=\"btn-close\"]"));
		JavascriptExecutor click_close_button = (JavascriptExecutor)driver;
		click_close_button.executeScript("arguments[0].click();", close_button);

		
		//click on rearrange
		WebElement rearrange=driver.findElement(By.xpath("//strong[text()='Rearrange']"));
		JavascriptExecutor click_rearrange = (JavascriptExecutor)driver;
		click_rearrange.executeScript("arguments[0].click();", rearrange);



		//click on ok alert
		WebElement alert=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
		JavascriptExecutor click_alert = (JavascriptExecutor)driver;
		click_alert.executeScript("arguments[0].click();", alert);




		List<WebElement>rejections_outcomes= driver.findElements(By.xpath("//div[@id='EndActivitiesScroll']/descendant::input[@type='checkbox']"));



		for(int  i=1; i <=rejections_outcomes.size(); i++)
		{

			if(i%3==0)
			{

				Thread.sleep(5000);
				WebElement toggle_2=driver.findElement(By.xpath("//div[@id='EndActivitiesScroll']/descendant::table/tbody/tr["+i+"]//input[@type='checkbox']"));
				JavascriptExecutor executor2 = (JavascriptExecutor)driver;
				executor2.executeScript("arguments[0].click();", toggle_2);
				System.out.println("This is in scope");
			}
			else
			{
				System.out.println("This is out scope");
			}


		}

		//clcik on compare
		Thread.sleep(3000);
		WebElement compare=	driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor compare_click = (JavascriptExecutor)driver;
		compare_click.executeScript("arguments[0].click();", compare);


//
//		//click on check standardaziation
//
//		WebElement check_standarization=driver.findElement(By.xpath("//button[text()='Standardization Check for Activities']"));
//		JavascriptExecutor click_link = (JavascriptExecutor)driver;
//		click_link.executeScript("arguments[0].click();", check_standarization);
//
//		//click on the link
//
//		WebElement edit_project_details=driver.findElement(By.xpath("//a[@href=\"/Projects/ProjectAdmin\"]"));
//		JavascriptExecutor just_click = (JavascriptExecutor)driver;
//		just_click.executeScript("arguments[0].click();", edit_project_details);
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
//		WebElement save_click=driver.findElement(By.xpath("//button[@id='btnEditProject']"));
//		JavascriptExecutor button_save = (JavascriptExecutor)driver;
//		button_save.executeScript("arguments[0].click();", save_click);
//		
//		

//		Thread.sleep(3000);
//
//		driver.navigate().back();



//		//click on tempalates
//		Thread.sleep(3000);
//		WebElement templates_click=	driver.findElement(By.xpath("//a[@id='download-tab']"));
//		JavascriptExecutor templatesclick = (JavascriptExecutor)driver;
//		templatesclick.executeScript("arguments[0].click();", templates_click);


		//				//Download the tempalte zip
		//				WebElement template_zip=driver.findElement(By.xpath("//button[@id='mergeScreen']"));
		//				JavascriptExecutor templatezip = (JavascriptExecutor)driver;
		//				templatezip.executeScript("arguments[0].click();", template_zip);
		//
		//
		//				// multiple window handler
		//
		//				String mainWindowHandle11 = driver.getWindowHandle();
		//				System.out.println(mainWindowHandle11);
		//
		//				Set<String> allWindowHandles11 = driver.getWindowHandles();
		//				System.out.println(allWindowHandles11);
		//
		//				for (String handle1 : allWindowHandles11)
		//				{
		//					if (!handle1.equals(mainWindowHandle11))
		//					{
		//						Thread.sleep(3000);  
		//						driver.switchTo().window(mainWindowHandle11);
		//
		//
		//					}
		//				}
		//				System.out.println(mainWindowHandle11);
		//
		//				//printing child window
		//				System.out.println("Child Window");
		//
		//
		//				
		//				
		//
		//				//click on ok we are predicting the data
		//				WebElement predicting_data=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
		//				JavascriptExecutor predicting_download_template = (JavascriptExecutor)driver;
		//				predicting_download_template.executeScript("arguments[0].click();", predicting_data);
		//				

		Thread.sleep(9000);

		//click on information
		WebElement information=driver.findElement(By.xpath("//a[@id='information-tab']"));
		JavascriptExecutor information_click = (JavascriptExecutor)driver;
		information_click.executeScript("arguments[0].click();", information);

		//click on collapse cruch history
		Thread.sleep(3000);
		WebElement collapse_cruch=driver.findElement(By.xpath("//div[@id='crunchHistoryAccordion']/descendant::button[@type='button']"));
		JavascriptExecutor history = (JavascriptExecutor)driver;
		history.executeScript("arguments[0].click();", collapse_cruch);

//		//clcik on the gen ai
//        Thread.sleep(3000);
//		WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//		JavascriptExecutor genai = (JavascriptExecutor)driver;
//		genai.executeScript("arguments[0].click();", gen_ai);

		
		driver.navigate().refresh();
		Thread.sleep(3000);
		//click on observations

		WebElement obseravtions=driver.findElement(By.xpath("//a[@id='obs-tab']"));
		JavascriptExecutor executor_ob = (JavascriptExecutor)driver;
		executor_ob.executeScript("arguments[0].click();", obseravtions);

//		//scoll to middle
//		JavascriptExecutor top_input = (JavascriptExecutor) driver;
//		top_input.executeScript("window.scrollTo(0,0);");


		//click on rework loops
//		WebDriverWait rework_loops=new WebDriverWait(driver, Duration.ofSeconds(0));
//		WebElement Automation_robotics=rework_loops.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='rework loop']")));
//		
//		WebElement Automation_robotics=driver.findElement(By.xpath("//span[text()='rework loop']"));
//		Thread.sleep(10000);
//		JavascriptExecutor click_rework_loops = (JavascriptExecutor) driver;
//		click_rework_loops.executeScript("arguments[0].click();", Automation_robotics);
//
//
//
//		//click on close
//		Thread.sleep(3000);
//		WebElement close=driver.findElement(By.xpath("//div[@id='IframeDialog']/descendant::button[@type='button']"));
//		JavascriptExecutor click_close = (JavascriptExecutor)driver;
//		click_close.executeScript("arguments[0].click();", close);
//
//
//		//scoll to middle
//		JavascriptExecutor scroll_middle = (JavascriptExecutor) driver;
//		scroll_middle.executeScript("window.scrollTo(0,250);");
//
//
//		//click on paths
//		Thread.sleep(10000);
//		WebElement click_on_path=driver.findElement(By.xpath("//span[text()='Paths']"));
//
//		Thread.sleep(10000); 
//		JavascriptExecutor click_on_paths = (JavascriptExecutor) driver;
//		click_on_paths.executeScript("arguments[0].click();", click_on_path);
//
//
//
//		//click on close
//		Thread.sleep(3000);
//		WebElement click_path=driver.findElement(By.xpath("//div[@id='IframeDialog']/descendant::button[@type='button']"));
//		JavascriptExecutor just_close = (JavascriptExecutor)driver;
//		just_close.executeScript("arguments[0].click();", click_path);
//
//
//		
//		//scoll to middle
//		JavascriptExecutor scroll_bottom = (JavascriptExecutor) driver;
//		scroll_bottom.executeScript("window.scrollTo(0,500);");
//
//		Thread.sleep(3000);
//		
//
//		//click on rejection path
//
//		Thread.sleep(10000);
//		WebElement rejections_path=driver.findElement(By.xpath("//span[text()=\"Rejection path\"]"));
//		Thread.sleep(10000);
//		JavascriptExecutor click_rejection_path = (JavascriptExecutor) driver;
//		click_rejection_path.executeScript("arguments[0].click();", rejections_path);
//
//
//		//click on close
//		Thread.sleep(3000);
//		WebElement rejection_path=driver.findElement(By.xpath("//div[@id='IframeDialog']/descendant::button[@type='button']"));
//		JavascriptExecutor click_rejections = (JavascriptExecutor)driver;
//		click_rejections.executeScript("arguments[0].click();", rejection_path);
//
//
//
//		Thread.sleep(3000);
//		//scoll to middle
//		JavascriptExecutor scroll_bottom_bottom = (JavascriptExecutor) driver;
//		scroll_bottom_bottom.executeScript("window.scrollTo(0,500);");
//
//		
//		//click on the decision  link
//
//		WebElement decision_link=driver.findElement(By.xpath("//a[text()='Click here']"));
//		JavascriptExecutor click_decision = (JavascriptExecutor) driver;
//		click_decision.executeScript("arguments[0].click();", decision_link);
//
//
//		//click on close
//		Thread.sleep(3000);
//		WebElement click_close_decision=driver.findElement(By.xpath("//div[@id='IframeDialog']/descendant::button[@type='button']"));
//		JavascriptExecutor click_close_now = (JavascriptExecutor)driver;
//		click_close_now.executeScript("arguments[0].click();", click_close_decision);
//
//

		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));

	
		 try {
			 JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("window.scrollTo(0, 0);");
	        } catch (Exception e) {
	            System.out.println("⚠️ Scroll to top failed: " + e.getMessage());
	        }

	        // --- Rework loop ---
	        try {
	            WebElement reworkLoop = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[text()='rework loop']")));
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].click();", reworkLoop);
	            Thread.sleep(3000);
	            WebElement close1 = wait1.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='IframeDialog']//button[@type='button']")));
	            js.executeScript("arguments[0].click();", close1);
	        } catch (Exception e) {
	            System.out.println("⚠️ Rework loop step skipped: " + e.getMessage());
	        }

	        // --- Paths ---
	        try {
	        	JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("window.scrollTo(0, 250);");
	            WebElement pathLink = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[text()='Paths']")));
	            js.executeScript("arguments[0].click();", pathLink);
	            Thread.sleep(3000);
	            WebElement close2 = wait1.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='IframeDialog']//button[@type='button']")));
	            js.executeScript("arguments[0].click();", close2);
	        } catch (Exception e) {
	            System.out.println("⚠️ Paths step skipped: " + e.getMessage());
	        }

	        // --- Rejection path ---
	        try {
	        	JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("window.scrollTo(0, 500);");
	            WebElement rejectLink = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[text()='Rejection path']")));
	            js.executeScript("arguments[0].click();", rejectLink);
	            Thread.sleep(3000);
	            WebElement close3 = wait1.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='IframeDialog']//button[@type='button']")));
	            js.executeScript("arguments[0].click();", close3);
	        } catch (Exception e) {
	            System.out.println("⚠️ Rejection path step skipped: " + e.getMessage());
	        }

	        // --- Decision link ---
	        try {
	        	JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("window.scrollTo(0, 500);");
	            WebElement decisionLink = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//a[text()='Click here']")));
	            js.executeScript("arguments[0].click();", decisionLink);
	            Thread.sleep(3000);
	            WebElement close4 = wait1.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='IframeDialog']//button[@type='button']")));
	            js.executeScript("arguments[0].click();", close4);
	        } catch (Exception e) {
	            System.out.println("⚠️ Decision link step skipped: " + e.getMessage());
	        }
		



		
		

		//click on the three lines

		WebElement three_lines=driver.findElement(By.xpath("//i[@class='fas fa-bars fa-2x p-2']"));
		JavascriptExecutor three_lines_click= (JavascriptExecutor) driver;
		three_lines_click.executeScript("arguments[0].click();", three_lines);

		//click on the download button

		WebElement download_button=driver.findElement(By.xpath("//a[@title='Download Visio & Recovery']"));
		JavascriptExecutor click_download_button= (JavascriptExecutor) driver;
		click_download_button.executeScript("arguments[0].click();", download_button);

		//click on all downloads under the symbol


		List<WebElement> all_downloads=driver.findElements(By.xpath("//i[@class='fas fa-file-download']"));

		for (int D = 1; D <= all_downloads.size(); D++) 
		{

			WebElement click_menu=driver.findElement(By.xpath("(//i[@class='fas fa-file-download'])["+D+"]"));


			JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
			pdf_click.executeScript("arguments[0].click();", click_menu);

			Thread.sleep(3000);




		}

//		//click on upload the process map
//
//		WebElement upload_process_map=driver.findElement(By.xpath("//a[@title='Upload Visio & Recovery']"));
//		JavascriptExecutor click_upload = (JavascriptExecutor) driver;
//		click_upload.executeScript("arguments[0].click();", upload_process_map);
//
//
//		//click on  upload visio  
//		WebElement upload=driver.findElement(By.xpath("//a[@title='Upload Visio']"));
//		JavascriptExecutor click_visio = (JavascriptExecutor) driver;
//		click_visio.executeScript("arguments[0].click();", upload);
//
//
//		//click on yes
//		WebElement just_yes=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//		JavascriptExecutor yes_click = (JavascriptExecutor) driver;
//		yes_click.executeScript("arguments[0].click();", just_yes);
//
//
//		//click on choose file
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//form[@id='Importvdx']/descendant::input[@class='input input-xxlarge']")).sendKeys("‪D:\\upload_file_input_screens");
//
//
//
//		//click on upload 
//		driver.findElement(By.xpath("//button[@id='VDXImp']")).click();
//		
//	    
//
//		//click on upload the recovery file
//
//		WebElement upload_recoveryfile=driver.findElement(By.xpath("//a[@title='Upload Recovery File']"));
//		JavascriptExecutor click_upload_recovery = (JavascriptExecutor) driver;
//		click_upload_recovery.executeScript("arguments[0].click();", upload_recoveryfile);
//
//
//		//click on yes
//		WebElement yes=driver.findElement(By.xpath("//button[@id='alertify-ok']"));
//		JavascriptExecutor click_yes = (JavascriptExecutor) driver;
//		click_yes.executeScript("arguments[0].click();", yes);
//
//
//
//		Thread.sleep(3000);
//		//click on choose file
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("((//input[@class='input input-xxlarge'])[2])")).sendKeys("D:\\upload_file_input_screens\\3755-AUTOMATION TESTING.bak");
//
//
//		//click on upload 
//		Thread.sleep(3000);
//		WebElement just_click_upload1=driver.findElement(By.xpath("(//button[text()='Upload'])[2]"));
//		JavascriptExecutor upload_click1 = (JavascriptExecutor) driver;
//		upload_click1.executeScript("arguments[0].click();", just_click_upload1);
//
//
	    //click on the legend
		Thread.sleep(5000);
		WebElement legend=driver.findElement(By.xpath("//a[@title='Legend']"));
		JavascriptExecutor click_legend = (JavascriptExecutor)driver;
		click_legend.executeScript("arguments[0].click();", legend);


		//first accordian
		WebElement mark_review=driver.findElement(By.xpath("//div[@id='Reviews']/descendant::input[@type='checkbox']"));

		Thread.sleep(3000);
		if(mark_review.isSelected()==true)
		{


			//Move the toggle mark as reviwed	
			Thread.sleep(500);
			WebElement hello=driver.findElement(By.xpath("//div[@id='PathsandLoops']/descendant::input[@type='checkbox']"));
			JavascriptExecutor mark_reviewed_click = (JavascriptExecutor)driver;
			mark_reviewed_click.executeScript("arguments[0].click();", hello);
		}

		Thread.sleep(3000);

		if (mark_review.isSelected()==false) 
		{

			WebElement make_it_mark_reveiwed=driver.findElement(By.xpath("//div[@id='Reviews']/descendant::input[@type='checkbox']"));
			JavascriptExecutor click_accordian = (JavascriptExecutor)driver;
			click_accordian.executeScript("arguments[0].click();", make_it_mark_reveiwed);

			Thread.sleep(500);
			WebElement hello=driver.findElement(By.xpath("//div[@id='PathsandLoops']/descendant::input[@type='checkbox']"));
			JavascriptExecutor mark_reviewed_click = (JavascriptExecutor)driver;
			mark_reviewed_click.executeScript("arguments[0].click();", hello);
		}


		//scroll to bottom to top
		JavascriptExecutor top_input1 = (JavascriptExecutor) driver;
		top_input1.executeScript("window.scrollTo(0,0);");



		//click on geolocate team working hours
		WebElement geolocate_working_hours=driver.findElement(By.xpath("//a[text()='Geolocate & Working Hours ']"));
		JavascriptExecutor executor_9 = (JavascriptExecutor)driver;
		executor_9.executeScript("arguments[0].click();", geolocate_working_hours);


		
		
	}
	
	
	
	
}

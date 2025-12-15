	package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.testng.Assert;
import org.testng.annotations.Test;

public class Competency_and_team_competency_cost 
{

	@Test
	public static void competancyandcompensation() throws InterruptedException, FileNotFoundException 
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
			driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
			String AA=driver.getCurrentUrl();
			if(AA.equals(WelcomePage)) {
				System.out.println("Login Success");
			}
		
			if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) 
			{
				driver.findElement(By.xpath("//button[text()='Log Out']")).click();
				driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rama krishna");
				//enter password
				driver.findElement(By.xpath("//input[@placeholder='Password'][1]")).sendKeys("Welcome@2025");
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
				
			}
			
		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement click_on_project=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='4315: AUTOMATION__MORTGAGE__PROJECT88']")));
		
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);

		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();


		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).click();

		//click on tree node and get text
		WebDriverWait wait111=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='106']"))).getText();
		System.out.println(node);

		//here we need to compare the decision tree values
		String expectedValue ="Competency and Compensation\n"+ "USD 58.2K\n" + "Fact Based - 53.4%\n"+ "Human Judgement - 41.1%\n" + "Computation - 5.7%";
		String actualValue=node;
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Competency and Compensation:Expected data and Actual data are not Matched");
		if (expectedValue.equalsIgnoreCase(actualValue)) 
		{
			System.out.println("Expected Value matches the Actual Value");

		}
		else 
		{
			System.out.println("Expected Value not matches to Actual Value");
		}

		//file reading sceanrio

		PrintStream printStream = new PrintStream(new FileOutputStream("Log.txt"));
		printStream.println("Actual Value is"+'\n'+actualValue);
		printStream.println(                                                       );
		printStream.println(                                                       );
		printStream.println("Expected Value is"+'\n'+expectedValue);


		Thread.sleep(15000);
		//scroll top to bottom
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, 5000);");
		
		

		//click on team competancy cost
		
		
		WebDriverWait work=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement click_on_workallocation_skilling=work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/TeamCompetency']")));
		Actions action1=new Actions(driver);
		
		action1.click(click_on_workallocation_skilling).perform();
		Thread.sleep(10000);


		// multiple window handler

		String mainWindowHandle = driver.getWindowHandle();
		System.out.println(mainWindowHandle);

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);

		for (String handle : allWindowHandles)
		{
			if (!handle.equals(mainWindowHandle))
			{

				driver.switchTo().window(handle);
				break;

			}
		}
		System.out.println(mainWindowHandle);

		//printing child window
		System.out.println("Child Window");

		
		
		

		//click on the  download 
		WebElement download=driver.findElement(By.xpath("//button[@title='Download']"));

		JavascriptExecutor click_download  = (JavascriptExecutor) driver;
		click_download.executeScript("arguments[0].click();", download);



		//click on the view comment
		Thread.sleep(3000);
		WebElement view_comment=driver.findElement(By.xpath("//i[@class='fas fa-comment is-cursor-pointer fa-2x mx-1 text-primary']"));
		JavascriptExecutor click_comment= (JavascriptExecutor) driver;
		click_comment.executeScript("arguments[0].click();", view_comment);

		//enter the comment in text
		Thread.sleep(3000);
		WebElement comment_text=driver.findElement(By.xpath("//textarea[@id='CommentsText']"));
		comment_text.sendKeys("QA_test");


		//click on save
		WebElement save=driver.findElement(By.xpath("//div[@id='CommentDialogue']/descendant::button[text()='Save']"));
		Thread.sleep(3000);
		save.click();


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



		
		
		
		   //click on all reset
		
		List<WebElement> all_reset=driver.findElements(By.xpath("//td[text()='Reset']"));
		
		
		for(int l=1;  l<=all_reset.size(); l++)
		{
			
			WebElement all=driver.findElement(By.xpath("(//td[text()='Reset'])["+l+"]"));
			JavascriptExecutor just_click_reset= (JavascriptExecutor) driver;
			just_click_reset.executeScript("arguments[0].click();", all);
			Thread.sleep(3000);
			
		}
		
		
		//click on the linked text to highlighted benchmark cost per annum
		
		
		List<WebElement> linked_text=driver.findElements(By.xpath("//a[text()='Click here to enter benchmark cost']"));
		
		for(int t=1;  t<=linked_text.size(); t++)
		{
			
			WebElement click_linked_text=driver.findElement(By.xpath("((//a[text()='Click here to enter benchmark cost'])["+t+"])"));
			click_linked_text.click();
			

			
			Thread.sleep(5000);
			
			
			//enter the low cost
			
			WebElement low_costs=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[contains(@id,'LowCost')]"));
			
			
			low_costs.sendKeys(Keys.CONTROL, Keys.chord("a"));
			low_costs.sendKeys(Keys.BACK_SPACE);
			low_costs.sendKeys("450");
			low_costs.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			

			//enter the medium cost
			
		
			WebElement enter_medium_cost=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[@id='MediumCost']"));
			
			enter_medium_cost.sendKeys(Keys.CONTROL, Keys.chord("a"));
			enter_medium_cost.sendKeys(Keys.BACK_SPACE);
			enter_medium_cost.sendKeys("15000");
			enter_medium_cost.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
			  

			//enter the high cost
			
			
			WebElement high_cost=driver.findElement(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::input[@id='HighCost']"));
			
			high_cost.sendKeys(Keys.CONTROL, Keys.chord("a"));
			high_cost.sendKeys(Keys.BACK_SPACE);
			high_cost.sendKeys("20000");
			high_cost.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			


	
			//click on save and  continue
			WebDriverWait continue_save=new WebDriverWait(driver, Duration.ofSeconds(0));
			WebElement click_continue_save=continue_save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SetBenchmarkCostDialogue']/descendant::button[text()='Save & Proceed']")));
			JavascriptExecutor click_save_click= (JavascriptExecutor) driver;
			click_save_click.executeScript("arguments[0].click();", click_continue_save);


		}
		
		
		//click and enter the salary

		List<WebElement> salary=driver.findElements(By.xpath("//a[text()='Click here to enter salary']"));



        for (int s=1; s<=salary.size(); s++)
        {
        	
        	
        	driver.findElement(By.xpath("(//a[text()='Click here to enter salary'])["+s+"]")).click();
        	
        	//click on radio button
        	
        	driver.findElement(By.xpath("//input[@value='AvgSal']")).click();
        	
        	
        	
        	//enter the average salary
        	
        	Thread.sleep(3000);
        
        	driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::input[@type='text']")).sendKeys("2000");
        
        	
        	//salary range per month
        	
        	driver.findElement(By.xpath("//input[@value='MMSal']")).click();
        	
        	//enter the minium salary
        	
        	driver.findElement(By.xpath("//input[@id='MinSal']")).sendKeys("5000");
        	
        	
        	//enter the maximum salary
        	
        	driver.findElement(By.xpath("//input[@id='MaxSal']")).sendKeys("10000");
        	
        	
        	//click on save and proceed
        	driver.findElement(By.xpath("//div[@id='SalariesDialogue']/descendant::button[text()='Save & Proceed']")).click();
        	
        	
    		//Enter the new aht
    		Thread.sleep(3000);
    		WebDriverWait new_aht=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement enter_new_aht=new_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
    		JavascriptExecutor insorce52178 = (JavascriptExecutor) driver;
    		insorce52178.executeScript("arguments[0].click();", enter_new_aht);
    		enter_new_aht.clear();
    		enter_new_aht.sendKeys("10");
    
    		//click on activity name check box
    		Thread.sleep(3000);
    		WebDriverWait select_activites=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement select_all_activites=select_activites.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
    		JavascriptExecutor insorce52179 = (JavascriptExecutor) driver;
    		insorce52179.executeScript("arguments[0].click();", select_all_activites);

      
        	//click on increase AHT
    		Thread.sleep(3000);
    		WebDriverWait increase=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement increase_AHT=increase.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Increase AHT')]")));
    		JavascriptExecutor insorce520 = (JavascriptExecutor) driver;
    		insorce520.executeScript("arguments[0].click();", increase_AHT);

    		//click on save and continue
    		Thread.sleep(3000);
    		WebDriverWait saves=new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement save_continue=saves.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Continue')]")));
    		JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
    		click_save_continue.executeScript("arguments[0].click();", save_continue);

    		//select the drop down menu activity
    		Thread.sleep(3000);
    		WebDriverWait select_menu=new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement select_drop_menu=select_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
    		Select select_drop_down=new Select(select_drop_menu);
    		select_drop_down.selectByIndex(2);
    		
    		
    		//click on add to cart
    		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(90));
    		WebElement add_to_cart=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Cart']")));
    
    		add_to_cart.click();
    	
        	
        }

		
		
		
		
		
		
		
		

//		//click on save and proceed
//		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(100));
//		WebElement saveandproceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"SalariesDialogue\"]//parent::button[text()='Save & Proceed']")));
//		//Thread.sleep(5000);
////		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
////		proceed_click.executeScript("arguments[0].click();", saveandproceed);
//		saveandproceed.click();
//
//
//		//Enter the new aht
//		Thread.sleep(3000);
//		WebDriverWait new_aht=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_new_aht=new_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
//		JavascriptExecutor insorce52178 = (JavascriptExecutor) driver;
//		insorce52178.executeScript("arguments[0].click();", enter_new_aht);
//		enter_new_aht.clear();
//		enter_new_aht.sendKeys("10");
//
//		//click on activity name check box
//		Thread.sleep(3000);
//		WebDriverWait select_activites=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement select_all_activites=select_activites.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
//		JavascriptExecutor insorce52179 = (JavascriptExecutor) driver;
//		insorce52179.executeScript("arguments[0].click();", select_all_activites);

//		//click on increase AHT
//		Thread.sleep(3000);
//		WebDriverWait increase=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement increase_AHT=increase.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Increase AHT')]")));
//		JavascriptExecutor insorce520 = (JavascriptExecutor) driver;
//		insorce520.executeScript("arguments[0].click();", increase_AHT);
//
//		//click on save and continue
//		Thread.sleep(3000);
//		WebDriverWait saves=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement save_continue=saves.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Continue')]")));
//		JavascriptExecutor click_save_continue = (JavascriptExecutor) driver;
//		click_save_continue.executeScript("arguments[0].click();", save_continue);
//
//		//select the drop down menu activity
//		Thread.sleep(3000);
//		WebDriverWait select_menu=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement select_drop_menu=select_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
//		Select select_drop_down=new Select(select_drop_menu);
//		select_drop_down.selectByIndex(2);

//		//select another drop down menu
//		Thread.sleep(5000);
//		WebDriverWait wait67332212=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement insorce50072212=wait67332212.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='form-group']//following-sibling::select)[2]")));
//		Select objSelect1 =new Select(insorce50072212);
//		objSelect1.selectByVisibleText("Human Judgement");

//		//scroll top to bottom
//		WebDriverWait top=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement scroll_top_bottom=top.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to Cart')]")));
//		//actions double click
//		Actions addcart=new Actions(driver);
//		addcart.doubleClick(scroll_top_bottom).build().perform();
		
//		JavascriptExecutor insorce7862 = (JavascriptExecutor) driver;
//		insorce7862.executeScript("arguments[0].scrollIntoView(true);",add_cart);

		
//		//click on add to cart
//		WebDriverWait add=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement add_to_cart=add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Cart']")));
//		JavascriptExecutor click_add_cart = (JavascriptExecutor) driver;
//		click_add_cart.executeScript("arguments[0].click();", add_to_cart);
//
//		//double click using the actions
//		Actions object=new Actions(driver);
//		object.doubleClick(add_to_cart).build().perform();
		
//		
//		//click on another pencil 
//		WebDriverWait pencil=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_on_pencil=pencil.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[3]/td[4]/div[3]/i[1]")));
//		JavascriptExecutor click_icon = (JavascriptExecutor) driver;
//		click_icon.executeScript("arguments[0].click();", click_on_pencil);
//		
//					
//		//enter the salary
//		WebDriverWait Enter_salary=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_salary=Enter_salary.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/descendant::div[@class='col-sm-8']/descendant::input[@type='text']")));
//		JavascriptExecutor enter_salary_textbox = (JavascriptExecutor) driver;
//		enter_salary_textbox.executeScript("arguments[0].click();", enter_salary);
//		enter_salary.click();
//		enter_salary.clear();
//		enter_salary.sendKeys("650");
//		
//		//save and proceed
//		Thread.sleep(3000);
//		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SalariesDialogue']/descendant::button[text()='Save & Proceed']")));
//		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
//		proceed_click.executeScript("arguments[0].click();", click_proceed);
//		
//		//enter aht
//		WebDriverWait aht=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement enter_aht=aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtAHTPercentage']")));
//		JavascriptExecutor click_aht = (JavascriptExecutor) driver;
//		click_aht.executeScript("arguments[0].click();", enter_aht);
//		enter_aht.clear();
//		enter_aht.sendKeys("78");
//		
//		//select activity
//		WebDriverWait select_activity=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_select_activity=select_activity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tr//th/descendant::input[@type='checkbox']")));
//		JavascriptExecutor click_on_selectactivity = (JavascriptExecutor) driver;
//		click_on_selectactivity.executeScript("arguments[0].click();", click_select_activity);
//		
		
//		//increase aht
//		WebElement click_on_aht=increase_aht.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Increase AHT']")));
//		JavascriptExecutor insorce8997 = (JavascriptExecutor) driver;
//		insorce8997.executeScript("arguments[0].click();", click_on_aht);
//		
//		//click on save
//		WebDriverWait save_click=new WebDriverWait(driver, Duration.ofSeconds(90));
//		WebElement click_on_save_and_continue=save_click.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save & Continue']")));
//		JavascriptExecutor click_on_save = (JavascriptExecutor) driver;
//		click_on_save.executeScript("arguments[0].click();", click_on_save_and_continue);
//		
//		
//		//select the drop down menu activity
//		WebDriverWait click_second=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement click_second_dropdrown_menu=click_second.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/descendant::select[@class='form-select']")));
//		Select objSelect121 =new Select(click_second_dropdrown_menu);
//		Thread.sleep(3000);
//		objSelect121.selectByVisibleText("Computation");
//		
//		//scroll top to bottom
//		Thread.sleep(3000);
//		WebDriverWait top_bottom=new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement top_to_bottom=top_bottom.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to Cart')]")));
//		JavascriptExecutor scroll_top_to_bottom = (JavascriptExecutor) driver;
//		scroll_top_to_bottom.executeScript("arguments[0].scrollIntoView(true);",top_to_bottom);
//
//		Thread.sleep(5000);
//		
//		//click on add to cart
//		
//		WebElement add_cart_1=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
//		JavascriptExecutor itemadd = (JavascriptExecutor) driver;
//		Thread.sleep(3000);
//		itemadd.executeScript("arguments[0].click();", add_cart_1);

	




		//click on review and proceed
		WebDriverWait wait000741=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement insorce345=wait000741.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Review & Proceed')]")));
		JavascriptExecutor insorce785 = (JavascriptExecutor) driver;
		insorce785.executeScript("arguments[0].click();", insorce345);

		//click on simualte outcome
		WebDriverWait wait678=new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement insorce980=wait678.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Simulate Outcome')])")));
		JavascriptExecutor insorce780 = (JavascriptExecutor) driver;
		insorce780.executeScript("arguments[0].click();", insorce980);


		//click on view result
		String mainWindowHandle2 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles2 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle : allWindowHandles2)
		{
			if (!handle.equals(mainWindowHandle2))
			{

				//driver.switchTo().window(handle);
				//click on view results
				WebDriverWait no=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement proceed_optimization=no.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor click_optimization = (JavascriptExecutor) driver;
				click_optimization.executeScript("arguments[0].click();", proceed_optimization);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle2);
				driver.close();			

			}
		}


	}
}






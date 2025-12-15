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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Effort_NVA
{



	@Test
	public static void effortnva(WebDriver driver) throws InterruptedException, FileNotFoundException
	{
		
		
	 
	String A="https://pbl.3-cubed.com/";	

		
		String WelcomePage="https://pbl.3-cubed.com/Projects/Welcome";

		driver.get(A);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement click_on_project=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
		JavascriptExecutor project_click = (JavascriptExecutor) driver;                            
		project_click.executeScript("arguments[0].click();", click_on_project);


		//click on decision tree
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		
		
		
		//click on decision tree node
		WebDriverWait wait11=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).click();

		//click on tree node and get text
		WebDriverWait effort_node=new WebDriverWait(driver, Duration.ofSeconds(20));
		String node= effort_node.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='104']"))).getText();
		System.out.println(node);

		//Here we need to compare the decision tree values
		String expectedValue ="Effort\n"+ "213.2 hrs | 30 FTE";
		String actualValue=node;
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue,actualValue,"FAIL : Cost->Effort:Expected data and Actual data are not Matched");
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


		//click on effort
		String expectedValue1 ="Team wise Effort";
		String header=driver.findElement(By.xpath("//span[@id='TitleHeading']")).getText();
		//change the node
		String actualValue1=header;
		System.out.println(actualValue1);
		Assert.assertEquals(expectedValue1,actualValue1,"text is changed");
		if (expectedValue1.equalsIgnoreCase(actualValue1)) 
		{
			System.out.println("Text is matched");

		}
		else 
		{
			System.out.println("Text is not matched");
		}



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");




		//click on non-value added work

		WebDriverWait add_work=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement non_value_added_work=add_work.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dvLeversSection']/descendant::a[@href='/Operations/NonProductivePath']")));
		JavascriptExecutor click_added = (JavascriptExecutor) driver;
		click_added.executeScript("arguments[0].click();", non_value_added_work);

		//switch to another window handler

		String mainWindowHandle7 = driver.getWindowHandle();
		//System.out.println(mainWindowHandle);

		Set<String> allWindowHandles7 = driver.getWindowHandles();
		//System.out.println(allWindowHandles2);

		for (String handle : allWindowHandles7)
		{
			if (!handle.equals(mainWindowHandle7))
			{


				driver.switchTo().window(handle);

				


				Thread.sleep(1000);
				int scroll_height = 500;
				JavascriptExecutor js1234=(JavascriptExecutor) driver;
				js1234.executeScript("window.scrollBy(0,"+scroll_height+ ")");


				//click on download button
				WebElement downalod_button=driver.findElement(By.xpath("//div[@id='actionmenu']/descendant::button[@title='Download']"));
				JavascriptExecutor button = (JavascriptExecutor) driver;
				button.executeScript("arguments[0].click();", downalod_button);

				//scroll bottom to top
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, 0);");


				//Enter the text in the search bar
				WebDriverWait search=new WebDriverWait(driver, Duration.ofSeconds(600));
				WebElement click_on_search=search.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ActivitySearchText']")));

				Actions search_click=new Actions(driver);
				search_click.click(click_on_search).build().perform();
				click_on_search.sendKeys("Confirm Appraisal Meets Mortgage Loan Guidelines");


				Thread.sleep(1000);
				//click on search
				WebElement search_symbol =driver.findElement(By.xpath("//i[@class='fas fa-search']"));

				//click on search symbol
				Actions act_click=new Actions(driver);
				act_click.click(search_symbol).perform();

				//click on clear text
				WebElement clear_text=driver.findElement(By.xpath("//button[text()='Clear']"));
				act_click.click(clear_text).build().perform();



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



				// click on the all the process maps view 

				List<WebElement> view = driver.findElements(By.xpath("//tr[@class='info']"));
				

				for( int j=1; j<=view.size(); j++)
				{

					//click on view 
					WebElement click_view=driver.findElement(By.xpath("(//tbody//td//a)["+j+"]"));

					//click on all views
					Actions click_act=new Actions(driver);
					click_act.click(click_view).build().perform();




//					List<WebElement> download_button=driver.findElements(By.xpath("//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')]"));
//
//					System.out.println("downalod_button");
//					for (int k = 1; k <=download_button.size() ; k++)
//					{
//
//						WebElement download=driver.findElement(By.xpath("(//table[@id='FirstRowOpen']//following-sibling::button[contains (text(),'Download')])["+k+"]"));
//
//						JavascriptExecutor downlaod_click = (JavascriptExecutor) driver;
//						downlaod_click.executeScript("arguments[0].click();", download);
//
//
//
//						System.out.println("Hi");
//						//click on downlaod as pdf
//
//						List<WebElement> download_pdf=driver.findElements(By.xpath("//a[text()='Download as PDF']"));
//						for (int r = 1; r <= download_pdf.size(); r++) 
//						{
//							WebElement click_pdf=	driver.findElement(By.xpath("(//a[text()='Download as PDF'])["+r+"]"));
//
//							JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//							pdf_click.executeScript("arguments[0].click();", click_pdf);
//						}
//
//
//
//						List<WebElement> download_tgf=driver.findElements(By.xpath("//a[text()='Download as TGF']"));
//						for (int a = 1; a <= download_tgf.size(); a++)
//						{
//							WebElement click_tgf=driver.findElement(By.xpath("(//a[text()='Download as TGF'])["+a+"]"));
//
//							JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
//							pdf_click.executeScript("arguments[0].click();", click_tgf);
//						}
//
//
//
//
//
//					}
				}
				

				//select the drop down menu to select the different drop down menu

				Select objSelect =new Select(driver.findElement(By.xpath("//select[@class='form-select'][1]")));
				objSelect.selectByVisibleText("Non-value Added Activities");
				Thread.sleep(4000);
				objSelect.selectByVisibleText("Action");
				Thread.sleep(4000);
				objSelect.selectByVisibleText("Routing");
				Thread.sleep(4000);
				objSelect.selectByVisibleText("Reporting");


				//select the second drop down menu

				Select second_another_dropmenu =new Select(driver.findElement(By.xpath("//select[@class='form-select'][2]")));
				second_another_dropmenu.selectByVisibleText("Effort (hrs)");
				Thread.sleep(4000);
				second_another_dropmenu.selectByVisibleText("No. of Activities");
				Thread.sleep(4000);


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


				
				//click on all proceed  
				
			
				List<WebElement> click_all_proceeds=driver.findElements(By.xpath("//button[text()='Proceed']"));
				for (int a = 1; a <= click_all_proceeds.size(); a++) 
				{
					WebElement click_pdf=	driver.findElement(By.xpath("(//button[text()='Proceed'])["+a+"]"));

					JavascriptExecutor pdf_click = (JavascriptExecutor) driver;
					pdf_click.executeScript("arguments[0].click();", click_pdf);
					
					Thread.sleep(3000);
				}




				//click on all proceed

				WebDriverWait insorce704=new WebDriverWait(driver, Duration.ofSeconds(80));
				WebElement click_on_proceed=insorce704.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[1]/tbody[1]/tr[3]/td[2]/descendant::button")));
				JavascriptExecutor just_click = (JavascriptExecutor) driver;                                       
				just_click.executeScript("arguments[0].click();", click_on_proceed);
				Thread.sleep(2000);
				JavascriptExecutor jsinsorce324=(JavascriptExecutor) driver;
				jsinsorce324.executeScript("window.scrollTo(0,450);");
				//click on process map

				JavascriptExecutor process_map = (JavascriptExecutor)driver;
				process_map.executeScript("model.NVA_ActivitySelection(model.AutoSortFilteredList()[0].RoutingActs[0], model.AutoSortFilteredList()[0])");

				//clcik on yes automate
				WebDriverWait yes=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement yes_click_automate=yes.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Automate']")));
				JavascriptExecutor automate_click = (JavascriptExecutor) driver;
				automate_click.executeScript("arguments[0].click();", yes_click_automate);

				//click on drop down menu
				WebDriverWait click_menu=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement selectdropdown=click_menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::select[@class='form-select']")));
				Select select=new Select(selectdropdown);
				select.selectByIndex(2);


				//click on automate
				WebDriverWait automate=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement click_automate=automate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='activityInfoDialogue']/descendant::button[contains(text(),'Automate')]")));
				JavascriptExecutor click_automate_click = (JavascriptExecutor) driver;
				click_automate_click.executeScript("arguments[0].click();", click_automate);

				//click on another drop down menu
				WebDriverWait click_wait=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement click_table=click_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ShowSystemsforLegacyDialogue']/following::select[@class='form-select']")));

				Select object=new Select(click_table);
				object.selectByVisibleText("Scanned Image");




				//enter the reduced percentage
				WebDriverWait reduced=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement reduced_percentage=reduced.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='AddtoCartDialogue']/descendant::input[@class='form-control']")));
				reduced_percentage.clear();
				reduced_percentage.sendKeys("11");

				//click on add Automation cost button
				WebDriverWait insorcetest3=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement test3=insorcetest3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Automation Cost')]")));
				test3.click();


				//click on check box
				WebDriverWait check=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement click_check_box=check.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/descendant::input[@type='checkbox']")));
				JavascriptExecutor box = (JavascriptExecutor) driver;
				box.executeScript("arguments[0].click();", click_check_box);




				//enter the depreciation in years
				WebDriverWait depreciation=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement test5111=depreciation.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]/descendant::input[@type='number']")));
				test5111.sendKeys("60");

				//enter the AMC in percentage
				WebDriverWait AMC=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement AMC_in_percentage=AMC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[9]/input[@type='number']")));
				AMC_in_percentage.sendKeys("75");

				//click on add list
				WebDriverWait click_add=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement add=click_add.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back')]")));
				JavascriptExecutor list_click = (JavascriptExecutor) driver;
				list_click.executeScript("arguments[0].click();", add);


				//click on add to cart
				WebDriverWait cart=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement cart_click=cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));
				JavascriptExecutor insorce_cart = (JavascriptExecutor) driver;
				insorce_cart.executeScript("arguments[0].click();", cart_click);


				//sroll bottom to up
				Thread.sleep(5000);
				JavascriptExecutor js123411=(JavascriptExecutor) driver;
				js123411.executeScript("window.scrollTo(0,0);");

				//click on Review and proceed
				WebDriverWait review=new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement Review_and_proceed=review.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Review & Proceed')]")));
				JavascriptExecutor proceed_review = (JavascriptExecutor) driver;
				proceed_review.executeScript("arguments[0].click();", Review_and_proceed);


				//click on simulate outcome
				WebDriverWait outcome_simulate=new WebDriverWait(driver, Duration.ofSeconds(90));
				WebElement simulate_outcome=outcome_simulate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
				JavascriptExecutor click_outcome = (JavascriptExecutor) driver;                               
				click_outcome.executeScript("arguments[0].click();", simulate_outcome);

				//close NonProductivePath window using window handler


				String mainWindowHandle21 = driver.getWindowHandle();
//				//System.out.println(mainWindowHandle);

				Set<String> allWindowHandles21 = driver.getWindowHandles();
				//System.out.println(allWindowHandles2);

				for (String handle1 : allWindowHandles21)
				{
					if (!handle1.equals(mainWindowHandle21))
					{

						//driver.switchTo().window(handle);
						//click on view results
						//						WebDriverWait results=new WebDriverWait(driver, Duration.ofSeconds(90));
						//						WebElement result_click=results.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
						//						JavascriptExecutor click_on_result = (JavascriptExecutor) driver;
						//						click_on_result.executeScript("arguments[0].click();", result_click);
						//						
						Thread.sleep(2000);
						driver.navigate().back();
						driver.switchTo().window(mainWindowHandle21);
						driver.close();						


					}
				}








			}

		}
	}



	

}	
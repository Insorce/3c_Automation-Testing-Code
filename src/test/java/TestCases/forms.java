package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class forms extends Baseclass
{

	
	@Test(invocationCount=1)
	public static void forms() throws InterruptedException
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


	
	
	driver.navigate().to("https://prod.3-cubed.com/Process/forms");
	
	

//
//	//click on forms
//	WebElement forms=driver.findElement(By.xpath("//div[@class='row']//following-sibling::a[@href='/Process/Forms']"));
//	JavascriptExecutor form = (JavascriptExecutor)driver;
//	form.executeScript("arguments[0].click();", forms);

//	//click on download forms
//	WebElement forms_download=driver.findElement(By.xpath("//a[text()='Download Form File']"));
//	JavascriptExecutor download = (JavascriptExecutor)driver;
//	download.executeScript("arguments[0].click();", forms_download);
//
//
//	//choose file
//	driver.findElement(By.xpath("//input[@id='BulkUploadFile']")).sendKeys("D:\\upload_file_input_screens\\Excel_3848-peakutilization__values__checking_Forms.xlsm");
//
//
//	//click on upload
//	WebElement upload=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
//	JavascriptExecutor click_upload = (JavascriptExecutor)driver;
//	click_upload.executeScript("arguments[0].click();", upload);
//
//	
//	
	
	//click on the manage forms
	
	WebElement manage_forms=driver.findElement(By.xpath("//button[text()='Manage Form(s)']"));
	JavascriptExecutor click_manage_forms = (JavascriptExecutor)driver;
	click_manage_forms.executeScript("arguments[0].click();", manage_forms);
	
	
	
	
	// Wait object
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

	// Wait until the input box is visible and interactable
	WebElement inputBox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dvNewForm']")));

	// Clear and type
//	inputBox.clear();
	inputBox.sendKeys("QA_test");
//
//	// Wait for '+' symbol to be clickable
//	WebElement plusSymbol = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fas fa-plus input-group-text']")));
//
//	// Scroll into view if needed
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plusSymbol);
//
//	
//
//	// Click the '+' icon using JS if normal click doesn't work
//	try
//	{
//	    plusSymbol.click();
//	} catch (ElementNotInteractableException e) 
//	{
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusSymbol);
//	}
//	
//	
//
//
//	Thread.sleep(3000);
//	//click on qa_test
//	WebElement qa_test=driver.findElement(By.xpath("//a[text()='QA_test']"));
//	JavascriptExecutor click_qa_test = (JavascriptExecutor)driver;
//	click_qa_test.executeScript("arguments[0].click();", qa_test);
//
//
//	Thread.sleep(3000);
//	//click on the send to requsition
//	WebElement requsition=driver.findElement(By.xpath("//button[text()='Click here to send for Requisition']"));
//	JavascriptExecutor click_qa_test1 = (JavascriptExecutor)driver;
//	click_qa_test1.executeScript("arguments[0].click();", requsition);
//	
//
//	
//	for (int l = 0; ; l++) 
//	{
//	    List<WebElement> activityLinks = driver.findElements(By.xpath("//ul[@id='activityTree']//a"));
//	    if (l >= activityLinks.size()) break;
//
//	    WebElement activityLink = activityLinks.get(l);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityLink);
//	    Thread.sleep(1000);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activityLink);
//	    Thread.sleep(2000);
//	}
//
//	
//	
//	
//	
//	//click on improve
//
//	WebElement improve=driver.findElement(By.xpath("//a[@id='perfimp-tab']"));
//	JavascriptExecutor improve_click = (JavascriptExecutor)driver;
//	improve_click.executeScript("arguments[0].click();", improve);
//	
//	
//	//click on the activities
//	WebElement click_activties=driver.findElement(By.xpath("//button[text()='Activities having more than 5 Forms']"));
//	JavascriptExecutor activities_click = (JavascriptExecutor)driver;
//	activities_click.executeScript("arguments[0].click();", click_activties);
//	
//	//click on the another activity
//
//	WebElement click_activity=	driver.findElement(By.xpath("//button[text()='Following Forms appear in > 90% of activities']"));
//	JavascriptExecutor activity_click = (JavascriptExecutor)driver;
//	activity_click.executeScript("arguments[0].click();", click_activity);
//
//	
//	//click on the link 
//	WebElement link=driver.findElement(By.xpath("//button[text()='Following Forms appear in < 10% of activities']"));
//	JavascriptExecutor click_link = (JavascriptExecutor)driver;
//	click_link.executeScript("arguments[0].click();", link);
//	
//	
//	//click on the info tab
//	WebElement  click_infotab=	driver.findElement(By.xpath("//a[@id='information-tab']"));
//	JavascriptExecutor infotab_click = (JavascriptExecutor)driver;
//	infotab_click.executeScript("arguments[0].click();", click_infotab);

	//clik on view
	WebElement view=driver.findElement(By.xpath("//button[text()='View']"));
	JavascriptExecutor view_click = (JavascriptExecutor)driver;
	view_click.executeScript("arguments[0].click();", view);
	
	
	//click on the activity links
List<WebElement> activity_links=	driver.findElements(By.xpath("//tbody/tr[1]/td[2]//a"));

for(int m=1;m<=activity_links.size(); m++);

{
	
  WebElement click_all=	driver.findElement(By.xpath("((//tbody/tr[1]/td[2]//a)[\"+m+\"])"));
  JavascriptExecutor all_click = (JavascriptExecutor)driver;
  all_click.executeScript("arguments[0].click();", click_all);
  
}
	
	
	
//	//click on compare
//	WebElement compare=driver.findElement(By.xpath("//a[@id='adv-tab']"));
//	JavascriptExecutor compare_cilck = (JavascriptExecutor)driver;
//	compare_cilck.executeScript("arguments[0].click();", compare);

   //click on the similarity
	
	WebElement similarity=driver.findElement(By.xpath("//button[text()='Forms Similarity']"));
	JavascriptExecutor click_similarity = (JavascriptExecutor)driver;
	click_similarity.executeScript("arguments[0].click();", similarity);
	
	
	
//	//click on gen ai
//	WebElement gen_ai=driver.findElement(By.xpath("//a[@id='genai-tab']"));
//	JavascriptExecutor gen_ai_click = (JavascriptExecutor)driver;
//	gen_ai_click.executeScript("arguments[0].click();", gen_ai);



	//clik on observation forms
	WebElement forms_click=driver.findElement(By.id("obs-tab"));
	JavascriptExecutor click_forms = (JavascriptExecutor)driver;
	click_forms.executeScript("arguments[0].click();", forms_click);

//
//	Thread.sleep(3000);
//
//	//Enter the mode  for the forms
//	WebElement enter_forms=driver.findElement(By.xpath("//h4[text()='List of Forms with no mode associated']"));
//
//
//	if (enter_forms.isDisplayed()==true) 
//	{
//		List<WebElement> modes= driver.findElements(By.xpath("(//tbody[@data-bind='foreach: $root.NoModeForms']//tr//select)"));
//
//		for( int i=1;i<=modes.size();i++)
//		{
//
//			WebElement mode=driver.findElement(By.xpath("(//tbody[@data-bind='foreach: $root.NoModeForms']//tr//select)["+i+"]"));
//
//			Select select=new Select(mode);
//			Thread.sleep(1000);
//			select.selectByVisibleText("Email");
//			
//			
//		}
////		driver.findElement(By.xpath("//div[@id='noModeModal']/descendant::a[text()='Save']")).click();
//	}
//	
//	
//	if (enter_forms.isDisplayed()==false) 
//	{
//		
//
//		System.out.println("Sucessfully selected the modes in the forms");

		//click on forms automation
		WebElement  forms_automation=driver.findElement(By.xpath("//button[text()='Forms automation']"));
		JavascriptExecutor click_on_forms = (JavascriptExecutor)driver;
		click_on_forms.executeScript("arguments[0].click();", forms_automation);


		//click on mark as reviwed
		WebElement mark_rew=driver.findElement(By.xpath("//label[@data-color='blue']"));
		JavascriptExecutor click_revw = (JavascriptExecutor)driver;
		click_revw.executeScript("arguments[0].click();", mark_rew);

		//click on busniess rules

		WebElement rules_business=driver.findElement(By.xpath("//button[text()='Business Rules ']"));
		JavascriptExecutor click_form = (JavascriptExecutor)driver;
		click_form.executeScript("arguments[0].click();", rules_business);




	}

}

	
	


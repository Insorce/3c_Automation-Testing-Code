package Decision_tree_automation;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Automation_motgage_project_for_creation 
{

	@Test
	public void insorce() throws InterruptedException
	{
		String uuid=UUID.randomUUID().toString();
		String[] links = null;
		int linksCount = 0;

		WebDriver driver= new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/");
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

		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);

		//create project
		driver.findElement(By.cssSelector("div.float-end.my-1")).click();
		//enter project name
		driver.findElement(By.xpath("//input[@name='Project Name']")).sendKeys("RAMAKRISHNA AUTOMATION TESTING " +uuid);
		//enter project description
		driver.findElement(By.xpath("//textarea[@id='projectDescription']")).sendKeys("INSORCE " +uuid);
		//Selecting the  project timezone
		Select object1=new Select(driver.findElement(By.name("Project TimeZone")));
		object1.selectByValue("Dateline Standard Time");
		//Selecting project Currency
		Select object2=new Select(driver.findElement(By.name("Project Currency")));
		object2.selectByValue("ARS");

//		//select the project group
//		WebElement project_group=driver.findElement(By.cssSelector("#dvProjectGroup > div.ms-sel-ctn > input[type=text]"));
//		Thread.sleep(3000);
//		project_group.click();
//		project_group.sendKeys("Test Base");
//
//		Actions object3=new Actions(driver);
//		object3.sendKeys(Keys.ARROW_DOWN).build().perform();
//		object3.sendKeys(Keys.ENTER).build().perform();
//		object3.sendKeys(Keys.ARROW_DOWN).build().perform();
//		object3.sendKeys(Keys.ENTER).build().perform();

		//enter the industry
		WebElement Insorce=	driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Insorce);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='dvProjectTags']/child::div/child::input[@type='text']")).sendKeys("Banking");
		Actions krishna=new Actions(driver);
		krishna.sendKeys(Keys.ARROW_DOWN).build().perform();
		krishna.sendKeys(Keys.ARROW_DOWN).build().perform();
		krishna.sendKeys(Keys.ENTER).build().perform();

//		//enter sub industry
//		Thread.sleep(3000);
//		WebElement Insorce1 =driver.findElement(By.xpath("//div[@id='dvProjectSubTags']/child::div//input[@type='text']"));
//		JavascriptExecutor js11 = (JavascriptExecutor) driver;
//		js11.executeScript("arguments[0].click();", Insorce1);
//
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@id='dvProjectSubTags']/child::div//input[@type='text']")).sendKeys("accounting");
//		Actions krishna1=new Actions(driver);
//		krishna1.sendKeys(Keys.ARROW_DOWN).build().perform();
//		krishna1.sendKeys(Keys.ARROW_DOWN).build().perform();
//		krishna1.sendKeys(Keys.ENTER).build().perform();
//
//		//enter the function
//		Thread.sleep(3000);
//		WebElement Insorce11 =driver.findElement(By.xpath("//div[@id='dvProjectFunTags']/child::div//input[@type='text']"));
//		JavascriptExecutor js111 = (JavascriptExecutor) driver;
//		js111.executeScript("arguments[0].click();", Insorce11);
//
//
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@id='dvProjectFunTags']/child::div//input[@type='text']")).sendKeys("reconciliation");
//		Actions krishna11=new Actions(driver);
//		krishna11.sendKeys(Keys.ARROW_DOWN).build().perform();
//		krishna11.sendKeys(Keys.ARROW_DOWN).build().perform();
//		krishna11.sendKeys(Keys.ENTER).build().perform();



//		//Template projects
//		Thread.sleep(1000);
//		WebElement projects=driver.findElement(By.xpath("//input[@class='ms-inv']"));
//
//		Thread.sleep(3000);
//		projects.sendKeys("1446-insorce_QAtest143");
//
//		Thread.sleep(10000);
//		Actions template_projects=new Actions(driver);
//		template_projects.sendKeys(Keys.ARROW_DOWN).build().perform();
//		template_projects.sendKeys(Keys.ARROW_DOWN).build().perform();
//		Thread.sleep(2000);
//		template_projects.sendKeys(Keys.ENTER).build().perform();



		//click on create a project
		WebElement we=	driver.findElement(By.xpath("//button[text()='Create Project']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", we);

		//click on get started
		Thread.sleep(3000);
		driver.findElement(By.id("getStarted")).click();

//
//		//click on process map and rejections
//		driver.findElement(By.xpath("//h5[text()='Process Map & Rejections']")).click();
//		//click on the zip file
//		driver.findElement(By.xpath("//img[@src=\'/Images/import.svg']")).click();
//
//		//click on the choose file
//		WebElement insorce9=driver.findElement(By.xpath("//input[@id='BulkUploadFile']"));
//		JavascriptExecutor object = (JavascriptExecutor) driver;
//		object.executeScript("arguments[0].click();", insorce9);
//
//		//Zip file uploadng
//		Thread.sleep(3000);
//		insorce9.sendKeys("D:\\projects automation in pbl instance\\4417-Mortgage loan - MHK.zip");
//
//		//click on the upload
//		driver.findElement(By.xpath("//button[@id='btnBulkUpload']")).click();
//
//		//click on done
//		Thread.sleep(1000);
//		WebElement insorce3= driver.findElement(By.xpath("//button[text()='Done']"));
//		JavascriptExecutor js111111 = (JavascriptExecutor) driver;
//		js111111.executeScript("arguments[0].click();", insorce3); 
//
//		// Explict wait
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NoProceedoptimization"))).click();
//
//		//click on view result
//		driver.findElement(By.xpath("//a[text()='View Result']")).click();
//
//		//click on input model
//		driver.findElement(By.xpath("//span[text()='Input Model']")).click();
//
//		//click on child plus button
//
//		driver.findElement(By.xpath("//a[@title='Click here to create Child Project']")).click();
//
//		//click on edit project 
//
//		driver.findElement(By.xpath("//li[@id='TxtEditProjectDetails']")).click();
//
//		//click on tempalte projects
//
//		JavascriptExecutor js_projects = (JavascriptExecutor) driver;
//		js_projects.executeScript("window.scrollTo(0,500)");
//
//		Thread.sleep(5000);
//		WebElement tempalte_projects=driver.findElement(By.xpath("//div[@id='dvTemplateProjects']//input[@placeholder='Type or click here']"));
//		tempalte_projects.click();
//
//		tempalte_projects.sendKeys("Ramakrishna");
//
//		Thread.sleep(10000);
//		Actions template_projects_1=new Actions(driver);
//		template_projects_1.sendKeys(Keys.ARROW_DOWN).build().perform();
//		template_projects_1.sendKeys(Keys.ARROW_DOWN).build().perform();
//		Thread.sleep(2000);
//		template_projects_1.sendKeys(Keys.ENTER).build().perform();
//
//
//		//click on save changes
//		driver.findElement(By.xpath("//button[@id='btnEditProject']")).click();
//		Thread.sleep(5000);
//		//click on input model
//		driver.findElement(By.xpath("//ul[@class='xp-horizontal-menu']/li/a[span[text()='Input Model']]")).click();
//		
//
//		//after this line new script update 
//		
//		
//		//click on process map and rejections
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@class='row']//following-sibling::a[@href='/Process/ProcessMapRejections']")).click();
//
//		//click on input and edit process map
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[text()='Input & Edit']")).click();
//		
//		//click on rejection outcome
//		
//		driver.findElement(By.xpath("//span[text()='Rejection Outcome']")).click();
//		
//		
//		
//
//		//click on toggle rework and rejections
//		Thread.sleep(5000);
//		WebElement toggle_1=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]//span[@class='toggle']"));
//		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
//		executor1.executeScript("arguments[0].click();", toggle_1);
//
//		Thread.sleep(5000);
//		WebElement toggle_2=	driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]//span[@class='toggle']"));
//		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
//		executor2.executeScript("arguments[0].click();", toggle_2);
//		Thread.sleep(5000);
//		WebElement toggle_3=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[2]//span[@class='toggle']"));
//		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
//		executor3.executeScript("arguments[0].click();", toggle_3);
//		Thread.sleep(5000);
//		WebElement toggle_4=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[4]/td[2]//span[@class='toggle']"));
//		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
//		executor4.executeScript("arguments[0].click();", toggle_4);
//		
//		//scroll to bottom to top
//		Thread.sleep(3000);
//		JavascriptExecutor top = (JavascriptExecutor) driver;
//		top.executeScript("window.scrollTo(0,0);");
//
//		//click on observations
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@id='obs-tab']")).click();
//
//
//		
//		//click on rework and rejections
//		driver.findElement(By.xpath("//button[text()='Rework Loops']")).click();
//
//		//move the toggle mark as reviwed
//		Thread.sleep(4000);
//		WebElement mark_reviwed=driver.findElement(By.xpath("//div[@id='Reviews']//following-sibling::input[@type='checkbox']"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", mark_reviwed);
//		
//		Thread.sleep(3000);
//		WebElement mark_unreviwed=driver.findElement(By.xpath("//div[@id='Reviews']//following-sibling::input[@type='checkbox']"));
//		JavascriptExecutor executor_1 = (JavascriptExecutor)driver;
//		executor_1.executeScript("arguments[0].click();", mark_unreviwed);
//		
//		
//		//click on path and loops
//		Thread.sleep(4000);
//		WebElement path_loops=driver.findElement(By.xpath("//button[text()='Paths and Loops']"));
//		JavascriptExecutor executor__1 = (JavascriptExecutor)driver;
//		executor_1.executeScript("arguments[0].click();", path_loops);
//		
//		Thread.sleep(4000);
//		WebElement loops_click=driver.findElement(By.xpath("//div[@id='PathsandLoops']//following-sibling::input[@type='checkbox']"));
//		JavascriptExecutor executor__9 = (JavascriptExecutor)driver;
//		executor__9.executeScript("arguments[0].click();", loops_click);
//	
//		
		//new scipt is been updated here
		
		
		
		
		

		//		Thread.sleep(5000);
		//		WebElement insorce_5192=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//		JavascriptExecutor executor_in = (JavascriptExecutor)driver;
		//		executor.executeScript("arguments[0].click();", insorce_5192);
		//
		//
		//		//click on accordian
		//
		//		Thread.sleep(5000);
		//		WebElement another_accordian=driver.findElement(By.xpath("(//label[@class='toggle-switchy'])[6]"));
		//		JavascriptExecutor accordian = (JavascriptExecutor)driver;
		//		accordian.executeScript("arguments[0].click();", another_accordian);
		//
		//
		//		//				//scroll top bottom
		//		//				JavascriptExecutor bottom = (JavascriptExecutor) driver;
		//		//				bottom.executeScript("window.scrollBy(0,2000);");
		//
		//		//click on geolocate & working hours
		//		Thread.sleep(3000);
		//		WebElement geolocate_working_hours=driver.findElement(By.xpath("//a[text()='Geolocate & Working Hours ']"));
		//		JavascriptExecutor executor_9 = (JavascriptExecutor)driver;
		//		executor_9.executeScript("arguments[0].click();", geolocate_working_hours);
		//		//enter the location
		//		WebElement location=driver.findElement(By.xpath("//input[@id='actorCity5']"));
		//		location.clear();
		//		location.sendKeys("Hyderabad");
		//		Thread.sleep(3000);
		//		location.sendKeys(Keys.ARROW_DOWN);
		//		location.sendKeys(Keys.ENTER);
		//
		//		//start time
		//
		//		WebElement start_time=driver.findElement(By.xpath("//input[@id='actorStartTime5']"));
		//		start_time.sendKeys(Keys.CONTROL.chord("a"));
		//		start_time.sendKeys(Keys.BACK_SPACE);
		//		start_time.sendKeys("10:00");
		//		Thread.sleep(3000);
		//		start_time.sendKeys(Keys.ENTER);
		//
		//
		//		//end time
		//		WebElement end_time=driver.findElement(By.xpath("//input[@id='actorWorkingHours5']"));
		//		end_time.sendKeys(Keys.CONTROL.chord("a"));
		//		end_time.sendKeys(Keys.BACK_SPACE);
		//		end_time.sendKeys("06:00");
		//		Thread.sleep(3000);
		//		end_time.sendKeys(Keys.ENTER);
		//
		//		//prodcutive hours
		//		WebElement productive_hours=driver.findElement(By.xpath("//input[@id='actorProductiveHours5']"));
		//		productive_hours.sendKeys(Keys.CONTROL.chord("a"));
		//		productive_hours.sendKeys(Keys.BACK_SPACE);
		//		productive_hours.sendKeys("10:00");
		//		Thread.sleep(3000);
		//		productive_hours.sendKeys(Keys.ENTER);
		//
		//		//end time
		//		WebElement end_time1=driver.findElement(By.xpath("//input[@id='actorEndTime5']"));
		//		end_time1.sendKeys(Keys.CONTROL.chord("a"));
		//		end_time1.sendKeys(Keys.BACK_SPACE);
		//		end_time1.sendKeys("9:00");
		//		Thread.sleep(3000);
		//		end_time1.sendKeys(Keys.ENTER);
		//
		//
		//		//clcik on observations
		//		Thread.sleep(3000);
		//		WebElement observations_insorce=driver.findElement(By.xpath("//a[text()='Observations']"));
		//		JavascriptExecutor team_1 = (JavascriptExecutor)driver;
		//		team_1.executeScript("arguments[0].click();", observations_insorce);
		//
		//		//click on review and proceed
		//		Thread.sleep(3000);
		//		WebElement proceed=driver.findElement(By.xpath("//span[@class='toggle']"));
		//		JavascriptExecutor team_91 = (JavascriptExecutor)driver;
		//		team_91.executeScript("arguments[0].click();", proceed);
		//
		//		//click on team salary
		//		WebElement  team_salary=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor team_92 = (JavascriptExecutor)driver;
		//		team_92.executeScript("arguments[0].click();", team_salary);
		//
		//		//mark as reviwed
		//		Thread.sleep(3000);
		//		WebElement reviwed=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//		JavascriptExecutor team_mark_reviewed = (JavascriptExecutor)driver;
		//		team_mark_reviewed.executeScript("arguments[0].click();", reviwed);
		//
		//		//enter the salary per month
		//		WebElement salary_month=driver.findElement(By.id("AvgSalary195105"));
		//		salary_month.clear();
		//		salary_month.sendKeys("41000");
		//
		//		//enter the high bench mark
		//		WebElement high_bench_mark=	driver.findElement(By.id("HighBenchSalary"));
		//		high_bench_mark.clear();
		//		high_bench_mark.sendKeys("50000");
		//
		//		//enter the mid percentage
		//		WebElement mid_percntage=driver.findElement(By.id("MidBenchSalary"));
		//		mid_percntage.clear();
		//		mid_percntage.sendKeys("19000");
		//
		//		//enter the low in percentage
		//		WebElement low_percentage=	driver.findElement(By.id("LowBenchSalary"));
		//		low_percentage.clear();
		//		low_percentage.sendKeys("10000");
		//
		//		//click on observation
		//		driver.findElement(By.xpath("//a[text()='Observations']")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on system and application
		//		driver.findElement(By.xpath("//a[@id='btnTeamValidation']")).click();
		//
		//		//click on observations
		//		driver.findElement(By.xpath("//a[text()='Observations']")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on products
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//		//click on observations
		//		driver.findElement(By.xpath("//a[text()='Observations']")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on periodic activites
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//		//click on observations
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//click on volume
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//		//click on observations
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on  ftr validation
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//
		//		//click  on right click using actions
		//		WebElement right_click=	driver.findElement(By.xpath("//a[@id='205']"));
		//		Actions actions = new Actions(driver);
		//		actions.contextClick(right_click).perform();
		//		Thread.sleep(3000);
		//		//click on mark as approved
		//		driver.findElement(By.xpath("//a[@id='Rvd']")).click();
		//
		//		driver.navigate().back();
		//
		//		//click on input model
		//		driver.findElement(By.xpath("//span[text()='Input Model']")).click();
		//
		//		//scroll by middle
		//		JavascriptExecutor middle = (JavascriptExecutor) driver;
		//		middle.executeScript("window.scrollBy(0,350);");
		//
		//		//click on aht
		//		Thread.sleep(3000);
		//		WebElement aht=driver.findElement(By.xpath("(//a[@class='text-success']/following::h5[@class='xp-counter text-success'])[7]"));
		//		JavascriptExecutor input_screen = (JavascriptExecutor)driver;
		//		input_screen.executeScript("arguments[0].click();", aht);
		//
		//		//click on observations
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//close the notifiaction
		//		Thread.sleep(3000);
		//		WebElement intercept=driver.findElement(By.xpath("//h5[text()='Below are the zero AHT activities']/following::button[@class='btn-close'][1]"));
		//		JavascriptExecutor team = (JavascriptExecutor)driver;
		//		team.executeScript("arguments[0].click();", intercept);
		//
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on geololocate team size
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//		//click on observations
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on release and wait types
		//		Thread.sleep(5000);
		//		WebElement hello_1=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor cont = (JavascriptExecutor)driver;
		//		cont.executeScript("arguments[0].click();", hello_1);
		//
		//		//click on release and wait types
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		WebElement hello_90=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//		JavascriptExecutor mark9 = (JavascriptExecutor)driver;
		//		mark9.executeScript("arguments[0].click();", hello_90);
		//
		//		//click on dead lines
		//		Thread.sleep(3000);
		//		WebElement dead_lines=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor mark_0 = (JavascriptExecutor)driver;
		//		mark_0.executeScript("arguments[0].click();", dead_lines);
		//
		//
		//		//click on deadlines
		//		Thread.sleep(3000);
		//		WebElement Deadlines_observations=driver.findElement(By.id("obs-tab"));
		//		JavascriptExecutor deadlines_o = (JavascriptExecutor)driver;
		//		deadlines_o.executeScript("arguments[0].click();", Deadlines_observations);
		//
		//		//click on input/edit 
		//
		//		WebElement input_edit=driver.findElement(By.xpath("//a[@id='edit-tab']"));
		//		Actions act= new Actions(driver);
		//		act.doubleClick(input_edit).perform();
		//
		//		//				//click on close
		//		//				Thread.sleep(3000);
		//		//				WebElement on_close=driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		//		//				JavascriptExecutor mark_close = (JavascriptExecutor)driver;
		//		//				mark_close.executeScript("arguments[0].click();", on_close);
		//		//
		//		//				//click on container
		//		//				WebElement containers=driver.findElement(By.id("loadDialogue"));
		//		//				JavascriptExecutor mark = (JavascriptExecutor)driver;
		//		//				mark.executeScript("arguments[0].click();", containers);
		//		//				
		//
		//		//click on close
		//		Thread.sleep(3000);
		//		WebElement close_click=driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		//		JavascriptExecutor click_close = (JavascriptExecutor)driver;
		//		click_close.executeScript("arguments[0].click();", close_click);
		//
		//		//click on container
		//		WebElement containers_2=driver.findElement(By.id("loadDialogue"));
		//		JavascriptExecutor mark_2 = (JavascriptExecutor)driver;
		//		mark_2.executeScript("arguments[0].click();", containers_2);
		//
		//		//click on mark as reviewed
		//		Thread.sleep(3000);
		//		WebElement reviwed_9=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//		JavascriptExecutor blue_mark = (JavascriptExecutor)driver;
		//		blue_mark.executeScript("arguments[0].click();", reviwed_9);
		//
		//		//click on opeartion sites
		//		WebElement operation_sites=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor click_opearation = (JavascriptExecutor)driver;
		//		click_opearation.executeScript("arguments[0].click();", operation_sites);
		//
		//
		//		//click on observations
		//		WebElement obseravtions=driver.findElement(By.id("obs-tab"));
		//		JavascriptExecutor operations = (JavascriptExecutor)driver;
		//		operations.executeScript("arguments[0].click();", obseravtions);
		//
		//		//click on mark as reviwed
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();		
		//
		//
		//		//click on ftr validation
		//		driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']")).click();
		//
		//		//click on effort widget
		//		//click  on right click using actions
		//		WebElement right_click1=	driver.findElement(By.xpath("//a[@id='104']"));
		//		Actions actions1 = new Actions(driver);
		//		actions1.contextClick(right_click1).perform();
		//		Thread.sleep(3000);
		//		//click on mark as approved
		//		driver.findElement(By.xpath("//a[@id='Rvd']")).click();
		//
		//		//scroll by middle
		//		JavascriptExecutor decision_tree = (JavascriptExecutor) driver;
		//		decision_tree.executeScript("window.scrollBy(0,350);");
		//
		//		//click  on right click using actions
		//		Thread.sleep(4000);
		//		WebElement right_click11=	driver.findElement(By.xpath("//a[@id='109']"));
		//		Actions actions11 = new Actions(driver);
		//		actions11.contextClick(right_click11).perform();
		//		Thread.sleep(4000);
		//		//click on mark as approved
		//		WebElement approved=driver.findElement(By.xpath("//a[@id='Rvd']"));
		//		JavascriptExecutor mark3 = (JavascriptExecutor)driver;
		//		mark3.executeScript("arguments[0].click();", approved);
		//
		//
		//		//click on peak_and_utlizization_
		//		Thread.sleep(4000);
		//		WebElement right_click_1= driver.findElement(By.xpath("//a[@id='105']"));
		//		Actions actions_1 = new Actions(driver);
		//		actions_1.contextClick(right_click_1).perform();
		//		Thread.sleep(5000);
		//		//click on mark as approved
		//		WebElement peak=driver.findElement(By.xpath("//a[@id='Rvd']"));
		//		JavascriptExecutor uitlization = (JavascriptExecutor)driver;
		//		uitlization.executeScript("arguments[0].click();", peak);
		//		Thread.sleep(4000);
		//
		//		//critical path 
		//		Thread.sleep(4000);
		//		WebElement critical=driver.findElement(By.xpath("//a[@id='203']"));
		//		Actions path = new Actions(driver);
		//		path.contextClick(critical).perform();
		//		Thread.sleep(5000);
		//		//click on mark as approved
		//		WebElement app=driver.findElement(By.xpath("//a[@id='Rvd']"));
		//		JavascriptExecutor marks = (JavascriptExecutor)driver;
		//		marks.executeScript("arguments[0].click();", app);
		//
		//		//bottle neck 
		//		Thread.sleep(4000);
		//		WebElement right_click_neck=driver.findElement(By.xpath("//a[@id='204']"));
		//		Actions actionsneck = new Actions(driver);
		//		actionsneck.contextClick(right_click_neck).perform();
		//		Thread.sleep(5000);
		//		//click on mark as approved
		//		WebElement hi=driver.findElement(By.xpath("//a[@id='Rvd']"));
		//		JavascriptExecutor marks_9 = (JavascriptExecutor)driver;
		//		marks_9.executeScript("arguments[0].click();", hi);
		//
		//		//compoent cost 
		//		Thread.sleep(4000);
		//		WebElement cost=driver.findElement(By.xpath("//a[@id='107']"));
		//		Actions cost_1 = new Actions(driver);
		//		cost_1.contextClick(cost).perform();
		//		Thread.sleep(5000);
		//		//click on mark as approved
		//		Thread.sleep(4000);
		//		WebElement component_cost=driver.findElement(By.xpath("//a[@id='Rvd']"));
		//		JavascriptExecutor comp = (JavascriptExecutor)driver;
		//		comp.executeScript("arguments[0].click();", component_cost);
		//
		//		driver.navigate().back();
		//
		//		//scroll to bottom
		//		JavascriptExecutor sc_bottom = (JavascriptExecutor) driver;
		//		sc_bottom.executeScript("window.scrollBy(0,350);");
		//
		//
		//		//click on input model
		//		driver.findElement(By.xpath("//span[text()='Input Model']")).click();
		//
		//		//scroll to bottom
		//		JavascriptExecutor bottom_down= (JavascriptExecutor) driver;
		//		bottom_down.executeScript("window.scrollBy(0,3000);");
		//
		//		//click on forms
		//		WebElement forms=driver.findElement(By.xpath("(//h5[@class='xp-counter text-success'])[13]"));
		//		JavascriptExecutor form = (JavascriptExecutor)driver;
		//		form.executeScript("arguments[0].click();", forms);
		//
		//		//clik on observation forms
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//click on mark as reviwed
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on busniess rules
		//		driver.findElement(By.xpath("//div[@class='accordion mt-3']/child::button[@class='btn btn-warning btn-rounded text-black mb-3 enableforall'][1]")).click();
		//
		//
		//		//clik on business rules observations
		//		driver.findElement(By.id("obs-tab")).click();
		//
		//		//scroll to top
		//		JavascriptExecutor bottom_top_2 = (JavascriptExecutor) driver;
		//		bottom_top_2.executeScript("window.scrollTo(0,0);");
		//
		//		JavascriptExecutor bottom_top_3 = (JavascriptExecutor) driver;
		//		bottom_top_3.executeScript("window.scrollTo(0,0);");
		//
		//		//click on mark as reviwed
		//		driver.findElement(By.xpath("//label[@data-color='blue']")).click();
		//
		//		//click on control validation
		//		Thread.sleep(10000);
		//		WebElement vaid_8=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black mb-3']"));
		//		JavascriptExecutor click_v = (JavascriptExecutor)driver;
		//		click_v.executeScript("arguments[0].click();", vaid_8);
		//
		//
		//		//close the notifiation
		//		Thread.sleep(3000);
		//		WebElement notification=driver.findElement(By.xpath("//div[@class='popover-body']/child::button[@type='button']"));		
		//		JavascriptExecutor notification_close = (JavascriptExecutor)driver;
		//		notification_close.executeScript("arguments[0].click();", notification);
		//
		//		//scroll to top
		//		JavascriptExecutor bottom_top = (JavascriptExecutor) driver;
		//		bottom_top.executeScript("window.scrollTo(0,0)", "");
		//
		//		//click on control validation observations
		//		Thread.sleep(10000);
		//		WebElement control_validation=driver.findElement(By.id("obs-tab"));
		//		JavascriptExecutor valid = (JavascriptExecutor)driver;
		//		valid.executeScript("arguments[0].click();", control_validation);
		//
		//
		//
		//		//click on mark as reviewed
		//		Thread.sleep(10000);
		//		//JavascriptExecutor bottom_top_1 = (JavascriptExecutor) driver;
		//		//bottom_top_1.executeScript("window.scrollTo(0,0)", "");
		//		Thread.sleep(3000);
		//		WebElement blue_color=driver.findElement(By.xpath("//label[@data-color='blue']"));
		//		JavascriptExecutor valid_12 = (JavascriptExecutor)driver;
		//		valid_12.executeScript("arguments[0].click();", blue_color);
		//
		//		//click on control validation
		//		WebElement control_validation_1=driver.findElement(By.xpath("//a[@class='btn btn-warning text-black']"));
		//		JavascriptExecutor valid_1 = (JavascriptExecutor)driver;
		//		valid_1.executeScript("arguments[0].click();", control_validation_1);
		//
		//		//automtable
		//		Thread.sleep(4000);
		//		WebElement auto=driver.findElement(By.id("108"));
		//		Actions matable = new Actions(driver);
		//		matable.contextClick(auto).perform();
		//		Thread.sleep(4000);
		//		//click on mark as approved
		//		WebElement approved_auto=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor mark_1 = (JavascriptExecutor)driver;
		//		mark_1.executeScript("arguments[0].click();", approved_auto);
		//
		//		//competency 
		//		Thread.sleep(4000);
		//		WebElement competency=	driver.findElement(By.id("106"));
		//		Actions compe = new Actions(driver);
		//		compe.contextClick(competency).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement id=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor id_1 = (JavascriptExecutor)driver;
		//		id_1.executeScript("arguments[0].click();", id);
		//		Thread.sleep(4000);
		//		//control effort 
		//		Thread.sleep(4000);
		//		WebElement effort=	driver.findElement(By.id("110"));
		//		Actions efforts = new Actions(driver);
		//		efforts.contextClick(effort).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement id_4=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor id_5 = (JavascriptExecutor)driver;
		//		id_5.executeScript("arguments[0].click();", id_4);
		//		Thread.sleep(4000);
		//		//nva 
		//
		//		Thread.sleep(4000);
		//		WebElement nva=	driver.findElement(By.id("111"));
		//		Actions nva_1 = new Actions(driver);
		//		nva_1.contextClick(nva).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement onnva=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor on = (JavascriptExecutor)driver;
		//		on.executeScript("arguments[0].click();", onnva);
		//		Thread.sleep(4000); 
		//
		//		//adeqecy 
		//
		//		Thread.sleep(4000);
		//		WebElement adeqecy=	driver.findElement(By.id("302"));
		//		Actions adeqecy_1 = new Actions(driver);
		//		adeqecy_1.contextClick(adeqecy).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement ade=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor qecy = (JavascriptExecutor)driver;
		//		qecy.executeScript("arguments[0].click();", ade);
		//
		//		Thread.sleep(4000);
		//		//effectiveness 
		//		Thread.sleep(4000);
		//		WebElement effect=	driver.findElement(By.id("303"));
		//		Actions ness = new Actions(driver);
		//		ness.contextClick(effect).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement clickeff=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor click_app = (JavascriptExecutor)driver;
		//		click_app.executeScript("arguments[0].click();", clickeff);
		//		Thread.sleep(4000);
		//
		//
		//
		//		//control effort 
		//		Thread.sleep(4000);
		//		WebElement control=	driver.findElement(By.id("304"));
		//		Actions effort_c = new Actions(driver);
		//		effort_c.contextClick(control).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement click_on=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor click_approved = (JavascriptExecutor)driver;
		//		click_approved.executeScript("arguments[0].click();", click_on);
		//		Thread.sleep(4000);
		//
		//
		//		//control effort 
		//		Thread.sleep(4000);
		//		WebElement ds_tree=	driver.findElement(By.id("305"));
		//		Actions decision = new Actions(driver);
		//		decision.contextClick(ds_tree).perform();
		//		Thread.sleep(4000);
		//
		//		//click on mark as approved
		//		WebElement click_de=driver.findElement(By.id("Rvd"));
		//		JavascriptExecutor js_id = (JavascriptExecutor)driver;
		//		js_id.executeScript("arguments[0].click();", click_de);
		//		Thread.sleep(4000);
		//
		//
		//
		//






	}

}

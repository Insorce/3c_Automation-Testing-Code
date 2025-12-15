package Decision_tree_automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Decision_tree_effort_rework_rejections



{

	@Test
	public static void rework_rejections(WebDriver driver) throws InterruptedException, FileNotFoundException
	{


		//click on the view projects
		WebElement rk=driver.findElement(By.xpath("//a[text()='View Projects']"));
		JavascriptExecutor insorce = (JavascriptExecutor) driver;
		insorce.executeScript("arguments[0].click();", rk);

		//click on project
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement insorce678=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='1842: AUTOMATION_PROJECT']")));
		JavascriptExecutor insorce1 = (JavascriptExecutor) driver;
		insorce1.executeScript("arguments[0].click();", insorce678);

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



		//scroll top to bottom
		Thread.sleep(5000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");



		//click on rework and reductions
		WebDriverWait rework=new WebDriverWait(driver, Duration.ofSeconds(6000));
		WebElement rework_and_reductions=rework.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='text-center col-sm-12 card card-body benefit-lightgreen show']/descendant::h5[contains(text(),'Rework Reduction')]")));
		Actions action_click=new Actions(driver);
		action_click.click(rework_and_reductions).perform();
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

		Thread.sleep(1000);
		int scroll_height = 500;
		JavascriptExecutor js1234=(JavascriptExecutor) driver;
		js1234.executeScript("window.scrollBy(0,"+scroll_height+ ")");


		//clicking on the process map
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("model.Rwk_ActivityClick(model.ReworkPaths()[0].Decision, model.ReworkPaths()[0])");

		//click on change decision percentage
		Thread.sleep(2000);
		WebDriverWait decision=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement percentage=decision.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Change Decision Percentage']")));
		JavascriptExecutor change = (JavascriptExecutor) driver;
		change.executeScript("arguments[0].click();", percentage);


		//click on training
		WebDriverWait training=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_training=training.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training']")));
		JavascriptExecutor train = (JavascriptExecutor) driver;
		train.executeScript("arguments[0].click();", click_training);


		//click Decision Activity
		WebDriverWait Activity=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Decision=Activity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Training Required for Decision Activity >>']")));
		JavascriptExecutor Decision_Activity  = (JavascriptExecutor) driver;
		Decision_Activity.executeScript("arguments[0].click();", Decision);
		//
		//		//click on raionallize systems
		//		WebDriverWait wait11111111=new WebDriverWait(driver, Duration.ofSeconds(30));
		//		WebElement insorce6781111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Rationalize systems']")));
		//		JavascriptExecutor insorce11111 = (JavascriptExecutor) driver;
		//		insorce11111.executeScript("arguments[0].click();", insorce6781111);
		//
		//		//click on add decision tree actvity
		//		WebDriverWait wait888=new WebDriverWait(driver, Duration.ofSeconds(30));
		//		WebElement insorce67811111=wait11111111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Decision Activity >>']")));
		//		JavascriptExecutor insorce111111 = (JavascriptExecutor) driver;
		//		insorce111111.executeScript("arguments[0].click();", insorce67811111);

		//click on proceed
		WebDriverWait proceed=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_proceed=proceed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Rwk_ProbAlongwithDialogue']/descendant::button[text()='Proceed']")));
		JavascriptExecutor proceed_click = (JavascriptExecutor) driver;
		proceed_click.executeScript("arguments[0].click();", click_proceed);



		//enter the input data
		WebDriverWait input=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement input_data=input.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//input[contains(@id,'probabilityrow')])[1]")));
		input_data.clear();
		Thread.sleep(3000);
		input_data.sendKeys("1");
		input_data.click();

		//click on enter
		Actions enter= new Actions(driver);
		enter.sendKeys(Keys.ENTER).build().perform();

		//Add the list
		WebDriverWait addlist=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement click_addlist=addlist.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-warning' and contains(text(),'Add to List') ])")));
		JavascriptExecutor list = (JavascriptExecutor) driver;
		list.executeScript("arguments[0].click();", click_addlist);

		//sroll bottom to up
		Thread.sleep(5000);
		JavascriptExecutor js12341=(JavascriptExecutor) driver;
		js12341.executeScript("window.scrollTo(0,0);");



		//click on Review and proceed
		WebDriverWait insorce233=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement insorce891=insorce233.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Review & Proceed(1)']")));
		JavascriptExecutor insorce711 = (JavascriptExecutor) driver;
		insorce711.executeScript("arguments[0].click();", insorce891);



		//click on simulate outcome
		WebDriverWait outcome=new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement simulate=outcome.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CartActivitiesDialogue']/descendant::button[text()='Simulate Outcome']")));
		JavascriptExecutor simulate_click = (JavascriptExecutor) driver;
		simulate_click.executeScript("arguments[0].click();", simulate);




		//close rework and reduction window using window handler

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
				WebDriverWait insorce32=new WebDriverWait(driver, Duration.ofSeconds(100));
				WebElement insorce91=insorce32.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No, will do it later. Proceed optimization']")));
				JavascriptExecutor insorce02 = (JavascriptExecutor) driver;
				insorce02.executeScript("arguments[0].click();", insorce91);
				Thread.sleep(2000);
				driver.navigate().back();
				driver.switchTo().window(mainWindowHandle2);
				driver.close();				

			}
		}

	}

}

package Decision_tree_automation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

		public class Decision_tree_values_comparision
		{

//		    public static void main(String[] args) throws IOException {
//		        WebDriver driver = new ChromeDriver();
//		        StringBuilder logBuilder = new StringBuilder();
//
//		        driver.get("https://pbl.3-cubed.com/");
//		        driver.manage().window().maximize();
//		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		        // Login
//		        driver.findElement(By.id("UName")).sendKeys("Rama krishna");
//		        driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
//		        driver.findElement(By.name("Logon")).click();
//
//		        String AA = driver.getCurrentUrl();
//		        String WelcomePage = "https://pbl.3-cubed.com/Projects/Welcome";
//
//		        if (AA.equals(WelcomePage)) {
//		            System.out.println("Login Success");
//		        } else if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) {
//		            driver.findElement(By.xpath("//button[text()='Log Out']")).click();
//		            driver.findElement(By.id("UName")).sendKeys("Rama krishna");
//		            driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
//		            driver.findElement(By.name("Logon")).click();
//		        }
//
//		        // Navigate to project
//		        WebElement rk = driver.findElement(By.xpath("//a[text()='View Projects']"));
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rk);
//
//		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		        WebElement click_on_project = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3763: AUTOMATION_PROJECT_MORTGE']")));
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_on_project);
//
//		        // Click on Decision Tree
//		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();
//
//		        // Function to test a node
//		        testNode(driver, logBuilder, "104", "Effort\n213.2 hrs | 30 FTE", "Effort");
//		        testHeader(driver, logBuilder, "Team wise Effort");
//
//		        testNode(driver, logBuilder, "105", "Peak & Utilization\n49 FTE | 49.6% | 83.3%\nFTE Count - 49\nActual Utilization - 49.6%\nDesired Utilization - 83.3%", "Peak & Utilization");
//		        testNode(driver, logBuilder, "106", "Competency and Compensation\nUSD 58.2K\nFact Based - 53.4%\nHuman Judgement - 41.1%\nComputation - 5.7%", "Competency and Compensation");
//		        testNode(driver, logBuilder, "107", "Component Cost\n39 seats | USD 20.8K", "Component Cost");
//		        testNode(driver, logBuilder, "204", "Bottlenecks and Delays\n5.4 days | 30.3 days", "Bottlenecks and Delays");
//
//		        testNode(driver, logBuilder, "203", "Critical Path\n4.3 days", "Critical path");
//		        testNode(driver, logBuilder, "205", "Rework & Rejections\n37.1% | 31.4%", "Rework & rejections");
//
//
//		        testNode(driver, logBuilder, "302", "Adequacy\n2.6 LOD", "Adequacy");
//
//		        testNode(driver, logBuilder, "303", "Effectiveness\n30.3%", "Effectiveness");
//		        testNode(driver, logBuilder, "304", "Control Effort\n26.7 hrs (12.5%)", "Control Effort");
//		        testNode(driver, logBuilder, "305", "Control Rework\n77.1%", "Control rework");
//
//		        
//		        
//		        testNode(driver, logBuilder, "302", "Adequacy\n2.6 LOD", "Adequacy");
//
//		        testNode(driver, logBuilder, "101", "FTE Sizing\n49 FTE", "FTE Sizing");
//		        testNode(driver, logBuilder, "100", "Total Cost\nUSD 3.66M", "Total Cost");
//		        testNode(driver, logBuilder, "200", "Customer Experience\n30.3 days | FTR 31.4%", "Customer Experience");
//                
//		        testNode(driver, logBuilder, "300", "Controls Coverage\n69%", "Controls Coverage");
//		        
//		        
//		        
//		   
//		        
//		        // Write the log
//		        try (PrintStream out = new PrintStream(new FileOutputStream("Log.txt"))) {
//		            out.print(logBuilder.toString());
//		            System.out.println("All node details written to Log.txt");
//		        } catch (IOException e) {
//		            System.out.println("Error writing to log file: " + e.getMessage());
//		        }
//
//		        driver.quit();
//		    }
//
//		    public static void testNode(WebDriver driver, StringBuilder logBuilder, String nodeId, String expectedValue, String nodeLabel) {
//		        try {
//		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		            WebElement nodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nodeId)));
//		        	
//		            Thread.sleep(3000);
//		            JavascriptExecutor js = (JavascriptExecutor) driver;
//		    		js.executeScript("arguments[0].click();", nodeElement);
//		            
//		            
//		         
//
//		            // Re-fetch for updated value
//		            String actualValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nodeId))).getText();
//		            System.out.println("Node [" + nodeLabel + "]: " + actualValue);
//
//		            logBuilder.append("Node: ").append(nodeLabel).append(" (ID: ").append(nodeId).append(")\n");
//		            logBuilder.append("Expected Value:\n").append(expectedValue).append("\n");
//		            logBuilder.append("Actual Value:\n").append(actualValue).append("\n");
//
//		            try {
//		                Assert.assertEquals(actualValue, expectedValue, "FAIL: Mismatch at node " + nodeLabel);
//		                logBuilder.append("Status: PASS ✅\n");
//		            } catch (AssertionError e) {
//		                logBuilder.append("Status: FAIL ❌\n").append("Reason: ").append(e.getMessage()).append("\n");
//		            }
//
//		            logBuilder.append("--------------------------------------------------\n\n");
//
//		        } catch (Exception e) {
//		            logBuilder.append("Node: ").append(nodeLabel).append(" (ID: ").append(nodeId).append(")\n");
//		            logBuilder.append("Status: ERROR ❌\n");
//		            logBuilder.append("Reason: ").append(e.getMessage()).append("\n");
//		            logBuilder.append("--------------------------------------------------\n\n");
//		        }
//		    }
//
//		    public static void testHeader(WebDriver driver, StringBuilder logBuilder, String expectedValue) {
//		        try {
//		            String actualValue = driver.findElement(By.id("TitleHeading")).getText();
//		            System.out.println("Header: " + actualValue);
//
//		            logBuilder.append("Header Test\n");
//		            logBuilder.append("Expected Header:\n").append(expectedValue).append("\n");
//		            logBuilder.append("Actual Header:\n").append(actualValue).append("\n");
//
//		            try {
//		                Assert.assertEquals(actualValue, expectedValue, "FAIL: Header mismatch");
//		                logBuilder.append("Status: PASS ✅\n");
//		            } catch (AssertionError e) {
//		                logBuilder.append("Status: FAIL ❌\n").append("Reason: ").append(e.getMessage()).append("\n");
//		            }
//
//		            logBuilder.append("--------------------------------------------------\n\n");
//
//		        } catch (Exception e) {
//		            logBuilder.append("Header Test Error ❌\n");
//		            logBuilder.append("Reason: ").append(e.getMessage()).append("\n\n");
//		        }
//		    }
//		
//	
		//}
		    @Test
		   public static void prod_instance()
		   {
			   
		        WebDriver driver = new ChromeDriver();
		        StringBuilder logBuilder = new StringBuilder();

		        driver.get("https://prod.3-cubed.com/");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		        // Login
		        driver.findElement(By.id("UName")).sendKeys("Rama krishna");
		        driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
		        driver.findElement(By.name("Logon")).click();

		        String AA = driver.getCurrentUrl();
		        String WelcomePage = "https://prod.3-cubed.com/Projects/Welcome";

		        if (AA.equals(WelcomePage)) {
		            System.out.println("Login Success");
		        } else if (AA.equals("https://prod.3-cubed.com/Account/LogOn")) {
		            driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		            driver.findElement(By.id("UName")).sendKeys("Rama krishna");
		            driver.findElement(By.id("Password")).sendKeys("Welcome@2025");
		            driver.findElement(By.name("Logon")).click();
		        }

		        // Navigate to project
		        WebElement rk = driver.findElement(By.xpath("//a[text()='View Projects']"));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rk);

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        WebElement click_on_project = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='5210: Decision_tree_value_comparision']")));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_on_project);

		        // Click on Decision Tree
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		        // Function to test a node
		        testNode1(driver, logBuilder, "104", "Effort\n213.2 hrs | 30 FTE", "Effort");
		        testHeader1(driver, logBuilder, "Team wise Effort");

		        testNode1(driver, logBuilder, "105", "Peak & Utilization\n49 FTE | 49.6% | 83.3%", "Peak & Utilization");
		        testNode1(driver, logBuilder, "106", "Competency and Compensation\nUSD 58.2K", "Competency and Compensation");
		        testNode1(driver, logBuilder, "107", "Component Cost\n39 seats | USD 20.8K", "Component Cost");
		        testNode1(driver, logBuilder, "204", "Bottlenecks and Delays\n5.4 days | 30.3 days", "Bottlenecks and Delays");

		        testNode1(driver, logBuilder, "203", "Critical Path\n4.3 days", "Critical path");
		        testNode1(driver, logBuilder, "205", "Rework & Rejections\n37.1% | 31.4%", "Rework & rejections");


		        testNode1(driver, logBuilder, "302", "Adequacy\n2.6 LOD", "Adequacy");

		        testNode1(driver, logBuilder, "303", "Effectiveness\n30.3%", "Effectiveness");
		        testNode1(driver, logBuilder, "304", "Control Effort\n26.7 hrs (12.5%)", "Control Effort");
		        testNode1(driver, logBuilder, "305", "Control Rework\n77.1%", "Control rework");

		        
		        
		        testNode1(driver, logBuilder, "302", "Adequacy\n2.6 LOD", "Adequacy");

		        testNode1(driver, logBuilder, "101", "FTE Sizing\n49 FTE", "FTE Sizing");
		        testNode1(driver, logBuilder, "100", "Total Cost\nUSD 3.66M", "Total Cost");
		        testNode1(driver, logBuilder, "200", "Customer Experience\n30.3 days | FTR 31.4%", "Customer Experience");
                
		        testNode1(driver, logBuilder, "300", "Controls Coverage\n69%", "Controls Coverage");
		        
		        
		        
		   
		        
		        // Write the log
		        try (PrintStream out = new PrintStream(new FileOutputStream("Log.txt"))) {
		            out.print(logBuilder.toString());
		            System.out.println("All node details written to Log.txt");
		        } catch (IOException e) {
		            System.out.println("Error writing to log file: " + e.getMessage());
		        }

		        driver.quit();
		    }

		    public static void testNode1(WebDriver driver, StringBuilder logBuilder, String nodeId, String expectedValue, String nodeLabel) {
		        try {
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		            WebElement nodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nodeId)));
		        	
		            Thread.sleep(3000);
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		    		js.executeScript("arguments[0].click();", nodeElement);
		            
		            
		         

		            // Re-fetch for updated value
		            String actualValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nodeId))).getText();
		            System.out.println("Node [" + nodeLabel + "]: " + actualValue);

		            logBuilder.append("Node: ").append(nodeLabel).append(" (ID: ").append(nodeId).append(")\n");
		            logBuilder.append("Expected Value:\n").append(expectedValue).append("\n");
		            logBuilder.append("Actual Value:\n").append(actualValue).append("\n");

		            try {
		                Assert.assertEquals(actualValue, expectedValue, "FAIL: Mismatch at node " + nodeLabel);
		                logBuilder.append("Status: PASS ✅\n");
		            } catch (AssertionError e) {
		                logBuilder.append("Status: FAIL ❌\n").append("Reason: ").append(e.getMessage()).append("\n");
		            }

		            logBuilder.append("--------------------------------------------------\n\n");

		        } catch (Exception e) {
		            logBuilder.append("Node: ").append(nodeLabel).append(" (ID: ").append(nodeId).append(")\n");
		            logBuilder.append("Status: ERROR ❌\n");
		            logBuilder.append("Reason: ").append(e.getMessage()).append("\n");
		            logBuilder.append("--------------------------------------------------\n\n");
		        }
		    }

		    public static void testHeader1(WebDriver driver, StringBuilder logBuilder, String expectedValue) {
		        try {
		            String actualValue = driver.findElement(By.id("TitleHeading")).getText();
		            System.out.println("Header: " + actualValue);

		            logBuilder.append("Header Test\n");
		            logBuilder.append("Expected Header:\n").append(expectedValue).append("\n");
		            logBuilder.append("Actual Header:\n").append(actualValue).append("\n");

		            try {
		                Assert.assertEquals(actualValue, expectedValue, "FAIL: Header mismatch");
		                logBuilder.append("Status: PASS ✅\n");
		            } catch (AssertionError e) {
		                logBuilder.append("Status: FAIL ❌\n").append("Reason: ").append(e.getMessage()).append("\n");
		            }

		            logBuilder.append("--------------------------------------------------\n\n");

		        } catch (Exception e) {
		            logBuilder.append("Header Test Error ❌\n");
		            logBuilder.append("Reason: ").append(e.getMessage()).append("\n\n");
		        }
		    }
		
	
		    
		    
		    
		    
		    
		    
		
	}
			
	
	
		
		

	
				
				

		
		
		
		


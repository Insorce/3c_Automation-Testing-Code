package Decision_tree_validation;


import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Comparison_using_soft_assert 

{




	public class Decision_tree_model_insight_ftr_fte_controls
	{

		@Test
		public void data_validation() throws IOException 
		{
			WebDriver driver = new ChromeDriver();
			SoftAssert softAssert = new SoftAssert();
			List<String> logLines = new ArrayList<>();

			driver.get("https://pbl.3-cubed.com/");
			String A = "https://pbl.3-cubed.com/";
			String WelcomePage = "https://pbl.3-cubed.com/Projects/Welcome";

			driver.get(A);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// login
			driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@name='Logon']")).click();

			String AA = driver.getCurrentUrl();
			if (AA.equals(WelcomePage)) {
				System.out.println("Login Success");
			}
			if (AA.equals("https://pbl.3-cubed.com/Account/LogOn")) {
				driver.findElement(By.xpath("//button[text()='Log Out']")).click();
				driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
				driver.findElement(By.xpath("//button[@name='Logon']")).click();
			}

			// === Collect data from DecisionTree (Base Tree) ===
			driver.navigate().to("https://pbl.3-cubed.com/Projects/DecisionTree?Pid=3925");

			String total_cost = driver.findElement(By.id("100")).getText();
			String fte_sizing = driver.findElement(By.id("101")).getText();
			String fte_cost = driver.findElement(By.id("102")).getText();
			String instfrastructure_cost = driver.findElement(By.id("103")).getText();
			String effort = driver.findElement(By.id("104")).getText();
			String peak_and_utilization = driver.findElement(By.id("105")).getText();
			String compentacy_and_compensation = driver.findElement(By.id("106")).getText();
			String component_cost = driver.findElement(By.id("107")).getText();
			String customer_experience = driver.findElement(By.id("200")).getText();
			String critical_path = driver.findElement(By.id("203")).getText();
			String rework_rejections = driver.findElement(By.id("205")).getText();
			String bottleneck_delays = driver.findElement(By.id("204")).getText();
			String Control_coverages = driver.findElement(By.id("300")).getText();
			String Aquency = driver.findElement(By.id("302")).getText();
			String effectiveness = driver.findElement(By.id("303")).getText();
			String control_effort = driver.findElement(By.id("304")).getText();
			String Control_rework = driver.findElement(By.id("305")).getText();

			// === Compare nodes for all validation pages ===
			String[] urls = {
					"https://pbl.3-cubed.com/Validation/Controls?screen=modalval",
					"https://pbl.3-cubed.com/Validation/FTR",
					"https://pbl.3-cubed.com/Validation/EffortPeriodic",
					"https://pbl.3-cubed.com/Validation/Controls"
			};

			for (String url : urls) {
				driver.navigate().to(url);
				compareAllNodes(softAssert, driver, logLines,
						total_cost, fte_sizing, fte_cost, instfrastructure_cost,
						effort, peak_and_utilization, compentacy_and_compensation, component_cost,
						customer_experience, critical_path, rework_rejections, bottleneck_delays,
						Control_coverages, Aquency, effectiveness, control_effort, Control_rework);
			}

			// Final log result
			try (FileWriter writer = new FileWriter("decision_tree_validation_log.txt")) {
				try {
					softAssert.assertAll(); // will throw if any mismatch
					logLines.add("\nAll data is matched successfully for all widgets ✅");
				} catch (AssertionError e) {
					logLines.add("\nSome nodes failed ❌");
				}
				// Write all logs to file and console
				for (String line : logLines) {
					System.out.println(line);
					writer.write(line + "\n");
				}
			}

			driver.quit();
		}

		private void compareNode(SoftAssert softAssert, String nodeId, String expected, String actual, List<String> logLines) {
			String expectedTrimmed = expected.trim();
			String actualTrimmed = actual.trim();

			// Special handling for Competency and Compensation nodes (ignore after "|")
			if (expected.contains("Competency and Compensation") || actual.contains("Competency and Compensation")) {
				if (expected.contains("|")) expectedTrimmed = expected.split("\\|")[0].trim();
				if (actual.contains("|")) actualTrimmed = actual.split("\\|")[0].trim();
			}

			// Normalize spaces
			expectedTrimmed = expectedTrimmed.replaceAll("\\s+", "");
			actualTrimmed = actualTrimmed.replaceAll("\\s+", "");

			// Normalize decimals
			expectedTrimmed = normalizeDecimals(expectedTrimmed);
			actualTrimmed = normalizeDecimals(actualTrimmed);

			// Node Name only
			String nodeName = expected.split("\\n")[0].trim();

			boolean match = expectedTrimmed.equalsIgnoreCase(actualTrimmed);

			String status = match ? "is passed" : "is failed";
			logLines.add(nodeName + " " + status);

			softAssert.assertEquals(actualTrimmed, expectedTrimmed, nodeName + " mismatch");
		}

		private String normalizeDecimals(String input) {
			Pattern p = Pattern.compile("(\\d+\\.\\d+)");
			Matcher m = p.matcher(input);
			StringBuffer sb = new StringBuffer();
			while (m.find()) {
				double val = Double.parseDouble(m.group(1));
				m.appendReplacement(sb, String.format("%.1f", val));
			}
			m.appendTail(sb);
			return sb.toString();
		}

		private void compareAllNodes(SoftAssert softAssert, WebDriver driver, List<String> logLines,
				String total_cost, String fte_sizing, String fte_cost, String instfrastructure_cost,
				String effort, String peak_and_utilization, String compentacy_and_compensation,
				String component_cost, String customer_experience, String critical_path,
				String rework_rejections, String bottleneck_delays, String Control_coverages,
				String Aquency, String effectiveness, String control_effort, String Control_rework) {

			compareNode(softAssert, "100", total_cost, driver.findElement(By.id("100")).getText(), logLines);
			compareNode(softAssert, "101", fte_sizing, driver.findElement(By.id("101")).getText(), logLines);
			compareNode(softAssert, "102", fte_cost, driver.findElement(By.id("102")).getText(), logLines);
			compareNode(softAssert, "103", instfrastructure_cost, driver.findElement(By.id("103")).getText(), logLines);
			compareNode(softAssert, "104", effort, driver.findElement(By.id("104")).getText(), logLines);
			compareNode(softAssert, "105", peak_and_utilization, driver.findElement(By.id("105")).getText(), logLines);
			compareNode(softAssert, "106", compentacy_and_compensation, driver.findElement(By.id("106")).getText(), logLines);
			compareNode(softAssert, "107", component_cost, driver.findElement(By.id("107")).getText(), logLines);
			compareNode(softAssert, "200", customer_experience, driver.findElement(By.id("200")).getText(), logLines);
			compareNode(softAssert, "203", critical_path, driver.findElement(By.id("203")).getText(), logLines);
			compareNode(softAssert, "205", rework_rejections, driver.findElement(By.id("205")).getText(), logLines);
			compareNode(softAssert, "204", bottleneck_delays, driver.findElement(By.id("204")).getText(), logLines);
			compareNode(softAssert, "300", Control_coverages, driver.findElement(By.id("300")).getText(), logLines);
			compareNode(softAssert, "302", Aquency, driver.findElement(By.id("302")).getText(), logLines);
			compareNode(softAssert, "303", effectiveness, driver.findElement(By.id("303")).getText(), logLines);
			compareNode(softAssert, "304", control_effort, driver.findElement(By.id("304")).getText(), logLines);
			compareNode(softAssert, "305", Control_rework, driver.findElement(By.id("305")).getText(), logLines);
		}
	}
}












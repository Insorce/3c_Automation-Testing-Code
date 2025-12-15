package Decision_tree_validation;




import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class Decision_tree_nodes_comparision

{


	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();  // ✅ SoftAssert declared globally

	// ✅ Safe method to just get node text (handles missing nodes)
	public String getNodeText(String nodeId) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		try {
			WebElement nodeElement = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='" + nodeId + "']"))
					);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nodeElement);
			return nodeElement.getText().trim();
		} catch (Exception e) {
			System.out.println("❌ Node " + nodeId + " not found or not visible!");
			return "NOT_FOUND";
		}
	}

	// ✅ Comparison method with SoftAssert
	public void compareAndAssert(Map<String, String> modelInsightMap,
			Map<String, String> compareMap,
			String pageName,
			FileWriter writer) throws IOException {

		writer.write("\n🔹 Comparison: Model Insight vs " + pageName + "\n");
		writer.write("======================================\n");

		boolean allPass = true;

		for (String nodeId : modelInsightMap.keySet()) {
			String insightValue = modelInsightMap.get(nodeId);
			String pageValue = compareMap.getOrDefault(nodeId, "NOT_FOUND");

			boolean isMatch;

			if (pageName.equals("Decision Tree")) {
				// ✅ Relaxed comparison for Decision Tree
				String normalizedInsight = normalizeText(insightValue);
				String normalizedPage = normalizeText(pageValue);

				String mainInsight = normalizedInsight.split("\\|")[0].trim();
				String mainPage = normalizedPage.split("\\|")[0].trim();

				isMatch = mainInsight.equalsIgnoreCase(mainPage) && !insightValue.equals("NOT_FOUND");
			} else {
				// Strict comparison for others
				String normalizedInsight = normalizeText(insightValue);
				String normalizedPage = normalizeText(pageValue);

				isMatch = normalizedInsight.equalsIgnoreCase(normalizedPage) && !insightValue.equals("NOT_FOUND");
			}

			// ✅ Write results
			writer.write("Node ID: " + nodeId + "\n");
			writer.write("Model Insight Value: " + insightValue + "\n");
			writer.write(pageName + " Value : " + pageValue + "\n");
			writer.write("Status : " + (isMatch ? "PASS ✅" : "FAIL ❌") + "\n");
			writer.write("--------------------------------------\n");

			// ✅ Collect result in SoftAssert
			if (!isMatch) {
				allPass = false;
				softAssert.fail("Mismatch in " + pageName + " at Node " + nodeId +
						" | Expected: " + insightValue + " | Found: " + pageValue);
			}
		}

		// ✅ Final status per page
		if (allPass) {
			writer.write("✅ Final Status for " + pageName + ": PASS\n");
			System.out.println("✅ Final Status for " + pageName + ": PASS");
		} else {
			writer.write("❌ Final Status for " + pageName + ": FAIL\n");
			System.out.println("❌ Final Status for " + pageName + ": FAIL");
		}
		writer.write("\n");
	}

	// ✅ Utility method to normalize text
	private String normalizeText(String text) {
		if (text == null) return "";
		return text
				.replaceAll("\\s+", " ")
				.replaceAll("\\s*%\\s*", "%")
				.trim()
				.toLowerCase();
	}

	@Test
	public void validateDecisionTreeNodes() throws Exception {
		// Setup driver
		driver = new ChromeDriver();
		driver.get("https://pbl.3-cubed.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String WelcomePage = "https://pbl.3-cubed.com/Projects/Welcome";

		// Login
		driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
		driver.findElement(By.xpath("//button[@name='Logon']")).click();

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals(WelcomePage)) {
			System.out.println("✅ Login Success");
		} else if (currentUrl.equals("https://pbl.3-cubed.com/Account/LogOn")) {
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.findElement(By.xpath("//input[@id='UName']")).sendKeys("Rama krishna");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Welcome@2025");
			driver.findElement(By.xpath("//button[@name='Logon']")).click();
		}

		// Click on view projects
		WebElement rk = driver.findElement(By.xpath("//a[text()='View Projects']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", rk);

		// Click on project
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement insorce678 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[text()=\"3506: Automation_decision_tree_widget_Don't_make any changes\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", insorce678);

		// Go to Decision Tree page
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Decision Tree ']"))).click();

		// ✅ Node IDs
		String[] nodeIds = {
				"100","101","102","103","104","105","106","107",
				"200","203","204","205",
				"300","302","303","304","305"
		};

		// ✅ Model Insight baseline values
		Map<String, String> modelInsightValues = new LinkedHashMap<>();
		driver.get("https://pbl.3-cubed.com/Validation/Controls?screen=main");
		for (String nodeId : nodeIds) {
			String text = getNodeText(nodeId);
			modelInsightValues.put(nodeId, text);
			System.out.println("Model Insight Node " + nodeId + " → " + text);
		}

		FileWriter writer = new FileWriter("NodeComparison.txt");
		writer.write("==== Node Comparison Results ====\n");

		// Compare Decision Tree
		Map<String, String> decisionTreeValues = new LinkedHashMap<>();
		driver.get("https://pbl.3-cubed.com/Projects/DecisionTree");
		for (String nodeId : nodeIds) {
			decisionTreeValues.put(nodeId, getNodeText(nodeId));
		}
		compareAndAssert(modelInsightValues, decisionTreeValues, "Decision Tree", writer);

		// Compare FTR
		Map<String, String> ftrValues = new LinkedHashMap<>();
		driver.get("https://pbl.3-cubed.com/Validation/FTR");
		for (String nodeId : nodeIds) {
			ftrValues.put(nodeId, getNodeText(nodeId));
		}
		compareAndAssert(modelInsightValues, ftrValues, "FTR Stage Gate", writer);

		// Compare EffortPeriodic
		Map<String, String> effortPeriodicValues = new LinkedHashMap<>();
		driver.get("https://pbl.3-cubed.com/Validation/EffortPeriodic");
		for (String nodeId : nodeIds) {
			effortPeriodicValues.put(nodeId, getNodeText(nodeId));
		}
		compareAndAssert(modelInsightValues, effortPeriodicValues, "EffortPeriodic Stage Gate", writer);

		// Compare Controls
		Map<String, String> controlsValues = new LinkedHashMap<>();
		driver.get("https://pbl.3-cubed.com/Validation/Controls");
		for (String nodeId : nodeIds) {
			controlsValues.put(nodeId, getNodeText(nodeId));
		}
		compareAndAssert(modelInsightValues, controlsValues, "Controls Stage Gate", writer);

		// Close writer
		writer.close();
		System.out.println("✅ Results saved to NodeComparison.txt");

		// ✅ Final assertion check (will fail test if mismatches exist)
		softAssert.assertAll();

		driver.quit();
	}
}



package TestCases;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class url_check 
{
	
	


	

		public static WebDriver driver;
		public static void main(String[] args) throws IOException {
			driver= new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    // Defined the brokenlink vaiable
			int brokenlinks=0;
			// find out the all links with tag name
			List<WebElement> listoflinks=driver.findElements(By.tagName("a"));
			int links=listoflinks.size();
			//reade the all links 
			//for(int i=0;i<links;i++) {
				//String hrefurls= listoflinks.get(i).getAttribute("href");
			for(WebElement hreurl:listoflinks) {
				String hrefurls=hreurl.getAttribute("href");
				if(hrefurls==null||hrefurls.isEmpty()) {
					System.out.println("this urls is empty");
					continue;
				}
			// open the links and check thestatus for that string to url convert
				URL urllinks=new URL(hrefurls);
				// without http tag we cont hit the url
				HttpURLConnection httpurl= (HttpURLConnection)urllinks.openConnection();
				httpurl.connect();
			    if(httpurl.getResponseCode()>=400) {
			    	System.out.println(hrefurls+" ===> broken link ");
			    }else {
			    	System.out.println(hrefurls+" ===> Not abroken link ");
			    }
			
			}
			
			
			
			
			
		}

	}




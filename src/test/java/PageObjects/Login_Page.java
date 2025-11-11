package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public static WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")WebElement username;
	@FindBy(xpath="//input[@name='passwor']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement submit;
	
	
	public void Enter_UserName(String user) {
		username.sendKeys(user);
	}
	
	public void Enter_Passsword(String psw) {
		password.sendKeys(psw);
	}
	
	public void click() {
		submit.click();
	}
	
	
}

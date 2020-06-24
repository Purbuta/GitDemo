package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		 this.driver=driver;
		 
		}

	private By email = By.xpath("//input[@id='user_email']"); 
	private By password = By.xpath("//input[@id='user_password']");
	private By btnLogin = By.xpath("//input[@name='commit']");
	//By forgotPassword = By.xpath("//a[@class='link-below-button']");
	private By forgotPassword = By.cssSelector("[href*='password/new']");
	 
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}
	
	public WebElement getEmail()
	 {
		 return driver.findElement(email);
	 }
	public WebElement getPassword()
	 {
		 return driver.findElement(password);
	 }
	public WebElement login()
	 {
		 return driver.findElement(btnLogin);
	 }
	
}

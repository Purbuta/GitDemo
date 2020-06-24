package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
public WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		 this.driver=driver;
		 
		}

	private By email = By.xpath("//input[@id='user_email']"); 
	private By sendMeInstructions = By.xpath("//input[@type='submit']");
	
	public WebElement getEmail()
	 {
		 return driver.findElement(email);
	 }
	public WebElement sendMeInstructions()
	 {
		 return driver.findElement(sendMeInstructions);
	 }
	
}

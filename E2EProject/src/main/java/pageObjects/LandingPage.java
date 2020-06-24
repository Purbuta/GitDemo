package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		 this.driver=driver;
		 
		}
	
	
	
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By popupNoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By title = By.cssSelector(".text-center>h2");
	private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	

public LoginPage getLogin()
 {
	 driver.findElement(signin).click();
	 LoginPage l = new LoginPage(driver);
	 return l;
 }
public int getNoThanksSize()
{
	 return driver.findElements(popupNoThanks).size();
}
public WebElement getNoThanks()
{
	 return driver.findElement(popupNoThanks);
}
public WebElement getTitle()
{
	 return driver.findElement(title);
}
public WebElement getNavigationBar()
{
	 return driver.findElement(navBar);
}
public WebElement getHeader()
{
	 return driver.findElement(header);
}

}

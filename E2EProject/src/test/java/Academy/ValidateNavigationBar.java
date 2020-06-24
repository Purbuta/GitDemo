package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
@Listeners(CustomListeners.class)
public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}

	@Test
	
	public void basePageNavigation() throws InterruptedException
	{
		
		LandingPage lp = new LandingPage(driver);
		lp.getNoThanks().click();
		Assert.assertTrue(lp.getNavigationBar().isDisplayed()); 
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}

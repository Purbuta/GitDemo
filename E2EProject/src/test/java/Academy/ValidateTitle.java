package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
@Listeners(CustomListeners.class)
public class ValidateTitle extends Base {
	public static Logger log =LogManager.getLogger(ValidateTitle.class);
	public WebDriver driver;
	LandingPage lp;
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("NAvigated to home page");
		log.debug("11111111");
		log.error("687ii09=====****");
	}

	@Test

	public void validateTitle() {
		
		lp = new LandingPage(driver);
		lp.getNoThanks().click();
		// Compare the text from the browser with the actual value- if mismatch then
		// error
		System.out.println("value==" + lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSE");// expected value-FEATURED COURSES
		log.info("Successfully validated Text message");
	}
	
	@Test

	public void validateHeader() {
		
		lp = new LandingPage(driver);
		// Compare the text from the browser with the actual value- if mismatch then
		// error
		System.out.println("value of header==" + lp.getHeader().getText());
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");// expected value-FEATURED COURSES
		log.info("Successfully validated Header message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}

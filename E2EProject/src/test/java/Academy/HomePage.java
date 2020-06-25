package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
@Listeners(CustomListeners.class)
public class HomePage extends Base {

	public WebDriver driver;

	@Test(dataProvider = "getData")

	public void validateLogin(String userName, String password, String text) throws IOException, InterruptedException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
		LandingPage lp = new LandingPage(driver);

		System.out.println("before no thanks*****====");
		if(lp.getNoThanksSize()>0)
		{
		lp.getNoThanks().click();
		}
		LoginPage l = lp.getLogin();
		l.getEmail().sendKeys(userName);
		l.getPassword().sendKeys(password);
		System.out.println("text==" + text);
		l.login().click();
		ForgotPassword fp = l.forgotPassword();
		fp.getEmail().sendKeys("xxxxx");
		fp.sendMeInstructions().click();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "non Restricted User";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "33445";
		data[1][2] = "Restricted user";

		return data;

	}

	@AfterTest
	public void teardown() {
		 driver.close();
	}
}

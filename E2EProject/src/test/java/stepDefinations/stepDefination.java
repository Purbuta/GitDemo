package stepDefinations;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import org.junit.runner.RunWith;

import Academy.Base;

@RunWith(Cucumber.class)
public class stepDefination extends Base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = initializeDriver();
    }
    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
    }

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);

		System.out.println("inside no thanks*****");
		if(lp.getNoThanksSize()>0)
		{
		lp.getNoThanks().click();
		}

		LoginPage l = lp.getLogin();
    }
  //Coding for parameterized feature
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage l = new LoginPage(driver);
    	l.getEmail().sendKeys(username);
		l.getPassword().sendKeys(password);
		System.out.println(username);
		System.out.println(password);
		l.login().click();
    }

    //For normal login.feature
	/*
	 * @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$") public void
	 * user_enters_something_and_something_and_logs_in(String strArg1, String
	 * strArg2) throws Throwable { LoginPage l = new LoginPage(driver);
	 * l.getEmail().sendKeys(strArg1); l.getPassword().sendKeys(strArg2);
	 * System.out.println(strArg1); System.out.println(strArg2); l.login().click();
	 * 
	 * }
	 */

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    }
    
    

    @And("^close browser$")
    public void close_browser() throws Throwable {
    	driver.quit();
    }
   

}
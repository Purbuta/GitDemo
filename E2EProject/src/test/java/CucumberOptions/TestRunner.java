package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//This is for Junit cucumber integration
/*@RunWith(Cucumber.class)  
@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinations")

public class TestRunner {

}*/
//This is for Junit runner

//Code for TestNG and Cucumber integration
@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests{

}

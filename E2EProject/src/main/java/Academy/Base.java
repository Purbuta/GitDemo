package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base { 
	
   public WebDriver driver;
   public Properties prop;
public WebDriver initializeDriver() throws IOException
{	
    prop = new Properties();
    //System.getProperty("user.dir")
    FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	//String browserName = System.getProperty("browser");//Parameterize Jenkin build with different browser execution
	
	System.out.println("browserName==>>*****"+browserName);
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.out.println("inside chrome");
		//for Chrome browser
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe"); 
		 
		/* //Code for head less browser
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("headless");
		 driver = new ChromeDriver(options);
		//Code for head less browser*/
		 
		  driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.out.println("inside firefox");
		//for Firfox browser
		  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver_win32\\geckodriver.exe");
	      driver = new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.out.println("inside IE");
	}
		
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;    
      
}

public String getScreenshotPath(String testCaseName, WebDriver driver)
{
	System.out.println("inside getScreenshotPath===");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	try {
		FileUtils.copyFile(source, new File(destinationFile));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return destinationFile;
}

}

package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import org.openqa.selenium.TakesScreenshot;


public class BaseClass {
    
    public  static WebDriver driver;
    
    public Logger logging; // for Logging
    
    public ResourceBundle rb; //to read config.properties
    
    @BeforeClass(groups= {"Master", "Sanity", "Regression"})
    @Parameters("browser") //getting browser parameter from testng.xml
    public void setup(String br)
    {
    	rb= ResourceBundle.getBundle("config"); // Load config.properties
    	
    	logging=LogManager.getLogger(this.getClass());  // for logging
    	ChromeOptions co = new ChromeOptions();
    	EdgeOptions eo= new EdgeOptions();
    	      eo.addArguments("--remote-allow-origins=*");
    		co.addArguments("--remote-allow-origins=*");
    			co.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
    			
    			if(br.equals("chrome"))
    			{
    				driver = new ChromeDriver(co);	
    			} 
    			else if(br.equals("edge"))
    			{
    				driver = new EdgeDriver(eo);
    			}
    			else 
    			{
    				driver = new ChromeDriver(co);
    			}
    						
    			    			
    			driver.get(rb.getString("appURL1")); // get url from config.properties file
       			driver.manage().window().maximize();
       			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    			

    }
    
    @AfterClass(groups= {"Master", "Sanity", "Regression"})
      public void teardown()
    {
    	driver.quit();
    }
    
    public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takenScreenshot = (TakesScreenshot) driver;
		File source = takenScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		

		try {
			Files.copy(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	
}
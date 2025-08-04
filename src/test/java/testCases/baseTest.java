package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import utilities.extentReportManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties propObj;
	public Logger logger;
	
	@BeforeClass(groups= {"regression","master","sanity"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException
	{
		propObj = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		propObj.load(file);
		
		
		switch(browser.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();
		break;
		
		case "edge": driver = new EdgeDriver();
		break;
		
		case "firefox": driver = new FirefoxDriver();
		break;
		
		default: System.out.println("Invalid browser");
		break;
		}
		
		
		extentReportManager.setWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(propObj.getProperty("app"));
		logger = LogManager.getLogger(this.getClass()); //will get the class name, get the log, and store it to logger
	}
	
	@AfterClass(groups={"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}	
}

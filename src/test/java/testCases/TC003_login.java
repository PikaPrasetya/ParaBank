package testCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.homePage;


public class TC003_login extends baseTest{
	
	@Parameters("browser")
	@Test(groups= {"regression","master"})
	public void login(String browser)
	{
		browser=browser.toLowerCase();
		homePage hp = new homePage(driver);
		hp.enterUsername(propObj.getProperty("username_"+browser));
		hp.enterPassword(propObj.getProperty("password_"+browser));
		logger.info("Fill username & passowrd");
		
		hp.clickLogIn();
		logger.info("Click login button");
		
		accountPage ap = new accountPage(driver);
		if(ap.valLogin()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		logger.info("Validate Login successful");
	}
}

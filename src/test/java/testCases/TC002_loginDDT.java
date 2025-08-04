package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.homePage;
import utilities.dataProviders;

public class TC002_loginDDT extends baseTest {
	
	@Test(dataProvider="loginAccount", dataProviderClass=dataProviders.class)
	public void login(String userName, String password)
	{		
		homePage hp = new homePage(driver);
		hp.enterUsername(userName);
		hp.enterPassword(password);
		hp.clickLogIn();
		accountPage ap = new accountPage(driver);
		if(ap.valLogin()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ap.clickLogOut();
	}

}

package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.registerPage;
import utilities.configWriter;
import utilities.randomizer;

public class TC001_accountRegistration extends baseTest {

	public String userName = null;
	public String password = null;
	
	@Parameters("browser")
	@Test(groups={"regression","master"})
	public void accRegistration(@Optional("chrome") String browser) throws IOException
	{
		randomizer random = new randomizer();
		homePage hp = new homePage(driver);
		registerPage reg = new registerPage(driver);
		accountPage ap = new accountPage(driver);
		browser = browser.toLowerCase();
		
		wait.until(ExpectedConditions.visibilityOf(hp.registerLink));
		hp.clickRegister();
		logger.info("Click Register link");
		
		reg.setFirstName(random.randomAlphabet());
		reg.setLastName(random.randomAlphabet());
		reg.setAddressField(random.randomAlphabet()+random.randomNumber());
		reg.setCityField(random.randomAlphabet());
		reg.setStateField(random.randomAlphabet());
		reg.setZipCode(random.randomNumber());
		reg.setPhoneNumber(random.randomNumber());
		reg.setSSNumb(random.randomNumber());
		this.userName = (random.randomAlphabet());
		reg.setUserName(userName);
		this.password = random.randomAlphabet()+random.randomNumber();
		reg.setPassword(password);
		reg.confPassword(password);
		logger.info("Fill user info");
		
		reg.clickRegister();
		logger.info("Click Register button");

		if(ap.valReg()==true && ap.valName(userName))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			return;
		}
		logger.info("Validate successful registration");
		
		configWriter cf = new configWriter();
		cf.writeAccount(userName, password, browser);
		logger.info("Send newly created account to config.properties");
	}

}

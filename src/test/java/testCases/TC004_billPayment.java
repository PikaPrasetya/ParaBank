package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.billPayPage;
import pageObjects.homePage;

public class TC004_billPayment extends baseTest {
	
	@Parameters("browser")
	@Test(groups= {"sanity","master"})
	public void billPayment(String browser)
	{
		browser=browser.toLowerCase();
		homePage hp = new homePage(driver);
		logger.info("Login process");
		hp.enterUsername(propObj.getProperty("username_"+browser));
		hp.enterPassword(propObj.getProperty("password_"+browser));
		hp.clickLogIn();
		
		accountPage ap = new accountPage(driver);
		ap.clickBillPay();
		logger.info("click Bill Pay");
				
		billPayPage bp = new billPayPage(driver);
		bp.setPayeeName(propObj.getProperty("payeename"));
		bp.setPayeeStreet();
		bp.setPayeeCity();
		bp.setPayeeState();
		bp.setZIPCode();
		bp.setPhoneNumber();
		bp.setPayeeAccount();
		bp.verifyPayeeAccount();
		bp.inputAmount(propObj.getProperty("amount"));
		logger.info("Fill payment info");
		
		bp.clickSendPayment();
		logger.info("Click Send Payment button");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='payeeName']")));
		String payeeNameReceipt = bp.payeeNameReceipt.getText();
		String amountReceipt = bp.amountReceipt.getText();
		try
		{
			if(payeeNameReceipt.equals(propObj.getProperty("payeename")) && amountReceipt.equals("$"+propObj.getProperty("amount")))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Validating payment");
	}

}

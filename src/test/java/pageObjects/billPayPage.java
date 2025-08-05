package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.randomizer;

public class billPayPage extends basePage {
	public billPayPage(WebDriver driver)
	{
		super(driver);
	}
	
	randomizer random = new randomizer();
	String payeeAccNum = null;
	
	@FindBy(name="payee.name")
	WebElement payeeNameField;
	
	@FindBy(name="payee.address.street")
	WebElement payeeStreet;
	
	@FindBy(name="payee.address.city")
	WebElement payeeCity;
	
	@FindBy(name="payee.address.state")
	WebElement payeeState;
	
	@FindBy(name="payee.address.zipCode")
	WebElement zipCode;
	
	@FindBy(name="payee.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(name="payee.accountNumber")
	WebElement payeeAccountNumber;
	
	@FindBy(name="verifyAccount")
	WebElement verifyAccount;
	
	@FindBy(name="amount")
	WebElement amountField;
	
	@FindBy(css="input.button")
	WebElement sendPaymentBtn;
	
	@FindBy(id="payeeName")
	public WebElement payeeNameReceipt;

	@FindBy(id="amount")
	public WebElement amountReceipt;
	
	public void setPayeeName(String payeeName)
	{
		payeeNameField.sendKeys(payeeName);
	}
	
	public void setPayeeStreet()
	{
		payeeStreet.sendKeys(random.randomAlphabet());
	}
	
	public void setPayeeCity()
	{
		payeeCity.sendKeys(random.randomAlphabet());
	}
	
	public void setPayeeState()
	{
		payeeState.sendKeys(random.randomAlphabet());
	}
	
	public void setZIPCode()
	{
		zipCode.sendKeys(random.randomNumber());
	}
	
	public void setPhoneNumber()
	{
		phoneNumber.sendKeys(random.randomNumber());
	}
	
	public void setPayeeAccount()
	{
		this.payeeAccNum = random.randomNumber(); 
		payeeAccountNumber.sendKeys(payeeAccNum);
	}
	
	public void verifyPayeeAccount()
	{
		verifyAccount.sendKeys(payeeAccNum);
	}
	
	public void inputAmount(String amount)
	{
		amountField.sendKeys(amount);
	}
	
	public void clickSendPayment()
	{
		sendPaymentBtn.click();
	}
}

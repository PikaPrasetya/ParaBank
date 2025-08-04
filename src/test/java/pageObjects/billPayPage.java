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
	
	@FindBy(xpath="//input[@name='payee.name']")
	WebElement payeeNameField;
	
	@FindBy(xpath="//input[@name='payee.address.street']")
	WebElement payeeStreet;
	
	@FindBy(xpath="//input[@name='payee.address.city']")
	WebElement payeeCity;
	
	@FindBy(xpath="//input[@name='payee.address.state']")
	WebElement payeeState;
	
	@FindBy(xpath="//input[@name='payee.address.zipCode']")
	WebElement zipCode;
	
	@FindBy(xpath="//input[@name='payee.phoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='payee.accountNumber']")
	WebElement payeeAccountNumber;
	
	@FindBy(xpath="//input[@name='verifyAccount']")
	WebElement verifyAccount;
	
	@FindBy(xpath="//input[@name='amount']")
	WebElement amountField;
	
	@FindBy(xpath="//input[@value='Send Payment']")
	WebElement sendPaymentBtn;
	
	@FindBy(xpath="//span[@id='payeeName']")
	public WebElement payeeNameReceipt;

	@FindBy(xpath="//span[@id='amount']")
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

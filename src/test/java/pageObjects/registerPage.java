package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends basePage {
	public registerPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	//by id
	@FindBy(id="customer.firstName")
	WebElement firstNameField;
	
	//by name
	@FindBy(id="customer.lastName")
	WebElement lastNameField;
	
	@FindBy(id="customer.address.street")
	WebElement addressField;
	
	//by css, attribute: id
	@FindBy(css="#customer\\.address\\.city") //use \\ before dot since CSS selectors don't allow dots (.) in IDs unless you escape them
	WebElement cityField;
	
	//by css, attribute: name
	@FindBy(css="input[name='customer.address.state']")
	WebElement stateField;
	
	@FindBy(id="customer.address.zipCode")
	WebElement zipCode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id="customer.ssn")
	WebElement SSN;
	
	@FindBy(id="customer.username")
	WebElement userName;
	
	@FindBy(id="customer.password")
	WebElement password;
	
	@FindBy(id="repeatedPassword")
	WebElement confirmPassword;
	
	@FindBy(css="input.button[value='Register']")
	WebElement btnRegister;
	
	//actions
	public void setFirstName(String firstName)
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		lastNameField.sendKeys(lastName);
	}
	
	public void setAddressField(String address)
	{
		addressField.sendKeys(address);
	}
	
	public void setCityField(String city)
	{
		cityField.sendKeys(city);
	}
	
	public void setStateField(String state)
	{
		stateField.sendKeys(state);
	}
	
	public void setZipCode(String zip)
	{
		zipCode.sendKeys(zip);
	}
	
	public void setPhoneNumber(String phone)
	{
		phoneNumber.sendKeys(phone);
	}
	
	public void setSSNumb(String ssnumb)
	{
		SSN.sendKeys(ssnumb);
	}
	
	public void setUserName(String username)
	{
		userName.sendKeys(username);
	}
	
	public void setPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void confPassword(String confpassw)
	{
		confirmPassword.sendKeys(confpassw);
	}
	
	public void clickRegister()
	{
		btnRegister.click();
	}
}

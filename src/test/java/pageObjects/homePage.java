package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {
	public homePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Objects Locator
	@FindBy(name="username")
	WebElement usernameField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginButton;
	
	//Actions
	public void enterUsername(String username)
	{
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickRegister()
	{
		registerLink.click();
	}
	
	public void clickLogIn()
	{
		loginButton.click();
	}

}

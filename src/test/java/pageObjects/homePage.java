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
	public WebElement usernameField;
	
	@FindBy(name="password")
	public WebElement passwordField;
	
	@FindBy(linkText="Register")
	public WebElement registerLink;
	
	@FindBy(css="input.button")
	public WebElement loginButton;
	
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

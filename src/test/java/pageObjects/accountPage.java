package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class accountPage extends basePage{
	public accountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div/p[normalize-space()='Your account was created successfully. You are now logged in.']")
	WebElement createAccSuccess;
	
	@FindBy(linkText="Accounts Overview")
	WebElement loginSuccess;
	
	@FindBy(linkText="Log Out")
	WebElement logOutLink;
	
	@FindBy(linkText="Bill Pay")
	WebElement billPayLink;
		
	public boolean valReg()
	{
		try
		{
		boolean status = createAccSuccess.getText().equals("Your account was created successfully. You are now logged in.");
		return status;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean valName(String name)
	{
		try
		{
		String welcomeMsg = driver.findElement(By.cssSelector("h1.title")).getText();
		boolean nameStatus = welcomeMsg.equals("Welcome "+name);
		return nameStatus;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean valLogin()
	{
		try
		{
		String accOverview = loginSuccess.getText();
		boolean loginStatus = accOverview.equals("Accounts Overview");
		return loginStatus;
		}
		catch(Exception e)
		{
			return false;
		}	
	}
	
	public void clickLogOut()
	{
		logOutLink.click();
	}
	
	public void clickBillPay()
	{
		billPayLink.click();
	}
}

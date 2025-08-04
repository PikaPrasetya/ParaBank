package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.homePage;
import pageObjects.registerPage;
import testCases.baseTest;

public class accountGenerator extends baseTest {
	
	public static void main (String[] args) throws IOException
	{
		String userName = null;
		String password = null;
		
		randomizer random = new randomizer();

		int accountNum = 1;
		
		
		for(int i=1;i<=accountNum;i++)
		{
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		homePage hp = new homePage(driver);
		registerPage reg = new registerPage(driver);
		hp.clickRegister();
		reg.setFirstName(random.randomAlphabet());
		reg.setLastName(random.randomAlphabet());
		reg.setAddressField(random.randomAlphabet()+random.randomNumber());
		reg.setCityField(random.randomAlphabet());
		reg.setStateField(random.randomAlphabet());
		reg.setZipCode(random.randomNumber());
		reg.setPhoneNumber(random.randomNumber());
		reg.setSSNumb(random.randomNumber());
		userName = (random.randomAlphabet());
		reg.setUserName(userName);
		password = random.randomAlphabet()+random.randomNumber();
		reg.setPassword(password);
		reg.confPassword(password);
		reg.clickRegister();
		
		//write the account to excel file
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\accountCreated.xlsx";
		excelManager xl = new excelManager(path);
		xl.recordAccount(userName, password, i);
		driver.quit();
		}
		
	}

}

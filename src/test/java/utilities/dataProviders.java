package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	@DataProvider(name="loginAccount")
	public String[][] loginAccount() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\accountCreated.xlsx";
		excelManager xl = new excelManager(path);
		
		int totalRow = xl.rowCount("loginAccount");
		int totalCol = xl.colCount("loginAccount", 0);
		
		String loginData[][] = new String[totalRow][totalCol];
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				loginData[i-1][j] = xl.readLoginAccount("loginAccount", i, j);
			}
		}
		return loginData;
	}
}

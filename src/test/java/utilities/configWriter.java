package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configWriter {
	public void writeAccount(String userName, String password, String browser) throws IOException
	{
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fi = new FileInputStream(path);
		prop.load(fi);
		fi.close();
		
		prop.setProperty("username_"+browser, userName);
		prop.setProperty("password_"+browser, password);
		
		FileOutputStream fo = new FileOutputStream(path);
		prop.store(fo, null);
		fo.close();
	}
}

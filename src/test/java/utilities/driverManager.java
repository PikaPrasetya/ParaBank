package utilities;

import org.openqa.selenium.WebDriver;

public class driverManager {
	// Thread-safe if parallel execution enabled
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //This line creates a ThreadLocal variable that holds a WebDriver instance separately for each thread.

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void removeDriver() {
        driver.remove();
    }
}

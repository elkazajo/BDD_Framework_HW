package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCreator {
    //Singleton pattern
    private static WebDriver driver;

    private WebDriverCreator() {

    }

    public static WebDriver getDriver() {
        if(driver == null) {
            DriverFactory.getChromeDriver();
        }
        return driver;
    }
}

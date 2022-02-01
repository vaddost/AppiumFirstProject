package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){

    }

    public static WebDriver getInstance(){
        if (driver == null){
            driver = new AndroidDriver(PropertiesReader.getPropertiesReader().getUrl(), CapabilityFactory.getCapabilities());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            ((AppiumDriver) driver).closeApp();
            driver = null;
        }
    }
}

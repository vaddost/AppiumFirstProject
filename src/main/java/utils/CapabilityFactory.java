package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import model.AppiumCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class CapabilityFactory {
    private static AppiumCapabilities appiumCapabilities;

    static Logger logger = LogManager.getLogger(CapabilityFactory.class);

    private static DesiredCapabilities capabilities;

    public static DesiredCapabilities getCapabilities(){
        if (capabilities == null) {
            capabilities = new DesiredCapabilities();
            setAppiumCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, appiumCapabilities.getPlatformName());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, appiumCapabilities.getPlatformVersion());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, appiumCapabilities.getDeviceName());
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appiumCapabilities.getAppPackage());
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appiumCapabilities.getAppActivity());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, appiumCapabilities.getNoReset());
        }

        return capabilities;
    }

    private static void setAppiumCapabilities(){
        ObjectMapper objectMapper = new ObjectMapper();
        File appiumCap = new File("src/main/resources/appium-options.json");
        try {
            appiumCapabilities = objectMapper.readValue(appiumCap, AppiumCapabilities.class);
        } catch (IOException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}

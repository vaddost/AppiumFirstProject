package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSingleton;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = DriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void waitUntilElementIsClickableIgnoringStaleReferenceExeption(WebElement element){
        new WebDriverWait(driver, 30)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void tapOnElement(WebElement element){
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.tap(PointOption.point(element.getLocation())).perform();
    }
}

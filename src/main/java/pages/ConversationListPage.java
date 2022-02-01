package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import pages.impl.InboxPage;
import pages.impl.SentPage;
import pages.impl.TrashPage;

import java.util.List;

public abstract class ConversationListPage extends BasePage{

    @FindBy(xpath = "//*[contains(@class, 'RecyclerView')]/*[contains(@class, 'View')]")
    private List<WebElement> messageLinks;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement openNavButton;

    private final By messageCheckboxAndDescriptionXpath = By.xpath(".//child::*");
    
    String navCategoriesXpathString =
            "//android.widget.TextView[@text='%s']//ancestor::android.widget.LinearLayout[@clickable='true']";

    public String getMessageDescription(int index){
        String description = null;
        if (index < messageLinks.size()){
            description = messageLinks.get(index)
                    .findElements(messageCheckboxAndDescriptionXpath).get(1)
                    .getAttribute("content-desc");
        }
        return description;
    }

    public void clickOnMessage(int index){
        if (index < messageLinks.size()){
            messageLinks.get(index).click();
        }
    }

    public void selectMessageWithIndex(int index){
        if (index < messageLinks.size()){
            WebElement selectConversation = messageLinks.get(index)
                    .findElements(messageCheckboxAndDescriptionXpath).get(0);
            tapOnElement(selectConversation);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void clickOpenNavButton(){
        openNavButton.click();
    }

    public void clickOnCategory(final String categoryName){
        driver.findElement(By.xpath(String.format(navCategoriesXpathString, categoryName))).click();
    }

    public int getMessageCountOnScreen(){
        return messageLinks.size();
    }

    public static class ConversationListPageFactory{
        public static ConversationListPage getInstance(final String folderName){
            switch(folderName){
                case "Inbox":
                    return new InboxPage();
                case "Sent":
                    return new SentPage();
                case "Trash":
                    return new TrashPage();
                default:
                    throw new IllegalArgumentException("The folder name is not correct");
            }
        }
    }
}

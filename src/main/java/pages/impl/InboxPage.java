package pages.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ConversationListPage;

public class InboxPage extends ConversationListPage {

    @FindBy(id = "compose_button")
    private WebElement composeButton;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    public void clickOnComposeButton(){
        composeButton.click();
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }
}

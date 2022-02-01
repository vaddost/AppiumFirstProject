package pages.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ConversationListPage;

public class TrashPage extends ConversationListPage {

    @FindBy(id = "empty_trash_spam_action")
    private WebElement emptyTrashButton;

    @FindBy(xpath = "//android.widget.Button[@text='Empty']")
    private WebElement emptyButtonModal;

    public void clickOnEmptyTrashButton(){
        emptyTrashButton.click();
    }

    public void clickOnEmptyButtonFromModal(){
        emptyButtonModal.click();
    }
}

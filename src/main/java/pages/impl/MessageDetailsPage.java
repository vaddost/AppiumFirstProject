package pages.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MessageDetailsPage extends BasePage {

    @FindBy(id = "subject_and_folder_view")
    private WebElement subjectAndFolderViewLabel;

    @FindBy(xpath = "//*[@resource-id='conversation-header']//following-sibling::android.view.View/child::android.view.View")
    private WebElement bodyLabel;

    @FindBy(id = "show_hide_details")
    private WebElement showHideDetailsButton;

    @FindBy(id = "to_details")
    private WebElement toDetailsLabel;

    public String getMessageSubjectWithLabel(){
        waitUntilElementIsClickableIgnoringStaleReferenceExeption(subjectAndFolderViewLabel);
        return subjectAndFolderViewLabel.getAttribute("text");
    }

    public String getMessageBody(){
        waitUntilElementIsClickableIgnoringStaleReferenceExeption(bodyLabel);
        return bodyLabel.getAttribute("text");
    }

    public void clickOnShowHideDetailsButton(){
        waitUntilElementIsClickableIgnoringStaleReferenceExeption(showHideDetailsButton);
        showHideDetailsButton.click();
    }

    public String getRecipientEmail(){
        if (!toDetailsLabel.isDisplayed()){
            clickOnShowHideDetailsButton();
        }
        waitUntilElementIsClickableIgnoringStaleReferenceExeption(toDetailsLabel);
        return toDetailsLabel.getAttribute("text");
    }
}

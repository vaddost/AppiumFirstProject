package pages.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ComposePage extends BasePage {
    @FindBy(xpath = "//*[@text='Got it']")
    private WebElement smartComposeGotItButton;

    @FindBy(id = "to")
    private WebElement toInput;

    @FindBy(id = "subject")
    private WebElement subjectInput;

    @FindBy(xpath = "//*[contains(@resource-id, 'wc_body_layout')]//android.widget.EditText")
    private WebElement bodyInput;

    @FindBy(id = "send")
    private WebElement sendButton;

    public void clickSmartComposeGotItButton(){
        smartComposeGotItButton.click();
    }

    public void enterToEmailAddress(final String emailAddress){
        toInput.sendKeys(emailAddress);
    }

    public void enterSubject(final String subject){
        subjectInput.sendKeys(subject);
    }

    public void enterMessageBody(final String message){
        bodyInput.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

}

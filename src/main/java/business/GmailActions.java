package business;

import pages.impl.InboxPage;
import pages.impl.TrashPage;

public class GmailActions extends AbstractBO{

    public void clearTrash(){
        if (!(conversationListPage instanceof TrashPage)){
            conversationListPage = goTo("Trash");
        }
        TrashPage trashPage = (TrashPage) conversationListPage;
        if (trashPage.getMessageCountOnScreen() > 0){
            trashPage.clickOnEmptyTrashButton();
            trashPage.clickOnEmptyButtonFromModal();
        }
    }

    public String getMessageDescriptionFrom(String folderName, int messageIndex){
        conversationListPage = goTo(folderName);
        return conversationListPage.getMessageDescription(messageIndex);
    }

    public void deleteMessageFromInbox(int index){
        if (!(conversationListPage instanceof InboxPage)){
            conversationListPage = goTo("Inbox");
        }
        InboxPage inboxPage = (InboxPage) conversationListPage;
        inboxPage.selectMessageWithIndex(0);
        inboxPage.clickDeleteButton();
    }

    public void sendNewMessage(final String recipientEmail, final String messageSubject, final String messageBody){
        if (!(conversationListPage instanceof InboxPage)){
            conversationListPage = goTo("Inbox");
        }
        InboxPage inboxPage = (InboxPage) conversationListPage;
        inboxPage.clickOnComposeButton();

        composePage.enterToEmailAddress(recipientEmail);
        composePage.enterSubject(messageSubject);
        composePage.enterMessageBody(messageBody);
        composePage.clickSendButton();
    }


}

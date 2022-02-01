package business;

import pages.ConversationListPage;
import pages.impl.ComposePage;
import pages.impl.InboxPage;
import pages.impl.MessageDetailsPage;

public abstract class AbstractBO {
    ConversationListPage conversationListPage;
    MessageDetailsPage messageDetailsPage;
    ComposePage composePage;

    public AbstractBO() {
        conversationListPage = new InboxPage();
        messageDetailsPage = new MessageDetailsPage();
        composePage = new ComposePage();
    }

    ConversationListPage goTo(final String folderName){
        conversationListPage.clickOpenNavButton();
        conversationListPage.clickOnCategory(folderName);
        return ConversationListPage.ConversationListPageFactory.getInstance(folderName);
    }
}

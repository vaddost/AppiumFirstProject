package tests;

import business.GmailActions;
import business.Verifier;
import listener.TestNGListener;
import org.testng.annotations.*;
import pages.ConversationListPage;
import pages.impl.*;
import utils.DriverSingleton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestNGListener.class)
public class GmailTests {

    private GmailActions actions;
    private Verifier verifier;

    @BeforeMethod
    public void setUp(){
        actions = new GmailActions();
        verifier = new Verifier();
    }

    @Test
    public void testCheckUserCanDeleteMessageFromInbox(){
        actions.clearTrash();
        String expectedDesc = actions.getMessageDescriptionFrom("Inbox", 0);
        actions.deleteMessageFromInbox(0);

        verifier.verifyDeletedMessageInTrashByMessageDescription(expectedDesc);
    }

    @Test
    public void testCheckUserCanComposeNewLetter(){

        String recipientEmail = "ast.vo.test@gmail.com";
        String messageSubject = "Test Subject";
        String messageBody = "test body";

        actions.sendNewMessage(recipientEmail, messageSubject, messageBody);

        verifier.verifyMessageDisplayedInSentFolderWithExpectedAttributes(recipientEmail, messageSubject, messageBody);
    }

    @AfterMethod
    public void tearDown(){
        DriverSingleton.closeDriver();
    }
}

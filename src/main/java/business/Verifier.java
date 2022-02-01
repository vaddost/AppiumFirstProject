package business;

import org.testng.asserts.SoftAssert;
import pages.impl.SentPage;

import static org.testng.Assert.assertEquals;

public class Verifier extends AbstractBO{

    public void verifyDeletedMessageInTrashByMessageDescription(final String expectedDescription){
        conversationListPage = goTo("Trash");
        assertEquals(conversationListPage.getMessageDescription(0), expectedDescription);
    }

    public void verifyMessageDisplayedInSentFolderWithExpectedAttributes(final String expectedTo,
                                                                         final String expectedSubject,
                                                                         final String expectedBody){
        conversationListPage = goTo("Sent");
        SentPage sentPage = (SentPage) conversationListPage;
        sentPage.clickOnMessage(0);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(messageDetailsPage.getMessageSubjectWithLabel().contains(expectedSubject));
        softAssert.assertEquals(messageDetailsPage.getMessageBody(), expectedBody);

        messageDetailsPage.clickOnShowHideDetailsButton();
        softAssert.assertEquals(messageDetailsPage.getRecipientEmail(), expectedTo);
        softAssert.assertAll();
    }
}

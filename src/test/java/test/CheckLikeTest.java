package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.ProfilePage;

import static com.google.common.truth.Truth.assertWithMessage;

public class CheckLikeTest extends NewPostTest {
    @DisplayName("Check like post")
    @Test
    void checkLikeClick() {
        seleniumUtilities.postProfileUrl(USER_ID);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String firstPostText = profilePage.getFirstPostText();
        assertWithMessage("TestMessage equals").that(firstPostText).contains(TEST_MESSAGE);
    }
}

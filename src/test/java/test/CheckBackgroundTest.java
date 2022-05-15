package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.ProfilePage;

import static com.google.common.truth.Truth.assertWithMessage;

public class CheckBackgroundTest extends NewPostTest {
    private static final String SAND_COLOR_RGB = "rgb(247, 196, 67)";

    @DisplayName("Check color for post")
    @Test
    void checkBackgroundForSandDesign() {
        seleniumUtilities.postProfileUrl(USER_ID);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String style = profilePage.getFirstPostStyleAttribute();
        assertWithMessage("Colors equals").that(style).contains(SAND_COLOR_RGB);
    }
}

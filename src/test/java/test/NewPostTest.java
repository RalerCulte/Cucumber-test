package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PostPage;
import pages.ProfilePage;
import utils.User;

import static com.google.common.truth.Truth.assertWithMessage;

@DisplayName("Check some field for post")
public class NewPostTest extends BaseTest {

    private static final String TEST_MESSAGE = "TEST TEST TEST!!!!";
    private static final String USER_ID = "600587939102";
    private static final String SAND_COLOR_RGB = "rgb(247, 196, 67)";

    @BeforeEach
    void repostPost() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.loginByPhone(TEST_USER);
        PostPage postPage = mainPage.receivePostPage();
        postPage.selectBeachDesign().sendPost(TEST_MESSAGE);
    }

    @DisplayName("Check color for post")
    @Test
    void checkBackgroundForSandDesign() {
        ProfilePage profilePage = new ProfilePage(seleniumUtilities, USER_ID);
        String style = profilePage.getFirstPostStyleAttribute();
        assertWithMessage("Colors equals").that(style).contains(SAND_COLOR_RGB);
    }

    @DisplayName("Check like post")
    @Test
    void checkLikeClick() {
        ProfilePage profilePage = new ProfilePage(seleniumUtilities, USER_ID);
        String firstPostText = profilePage.getFirstPostText();
        assertWithMessage("TestMessage equals").that(firstPostText).contains(TEST_MESSAGE);
    }

    @DisplayName("Check post text")
    @Test
    void checkPostText() {
        ProfilePage profilePage = new ProfilePage(seleniumUtilities, USER_ID);
        int likeCount = profilePage.getLikeCount();
        int likeCountAfterNewLike = profilePage.likeFirstPost().getLikeCount();
        assertWithMessage("Like success").that(likeCount).isLessThan(likeCountAfterNewLike);
    }
}

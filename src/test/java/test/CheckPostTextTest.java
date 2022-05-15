package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.ProfilePage;

import static com.google.common.truth.Truth.assertWithMessage;

public class CheckPostTextTest extends NewPostTest {
    @DisplayName("Check post text")
    @Test
    void checkPostText() {
        seleniumUtilities.postProfileUrl(USER_ID);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        int likeCount = profilePage.getLikeCount();
        int likeCountAfterNewLike = profilePage.likeFirstPost().getLikeCount();
        assertWithMessage("Like success").that(likeCount).isLessThan(likeCountAfterNewLike);
    }
}

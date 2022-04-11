package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtilities;

public class ProfilePage extends Page {
    private static final By FIRST_POST =
            By.xpath("//*[@data-l='fL,self']//*[1][@class='feed-w']//*[contains(@class,'media-block')]");
    private static final By FIRST_POST_LIKES =
            By.xpath("//*[@data-l='fL,self']//*[1][@class='feed-w']//*[@data-like-icon='like']//*[contains(@class,'widget_count')]");

    public ProfilePage(SeleniumUtilities seleniumUtilities, String userId) {
        super(seleniumUtilities);
        seleniumUtilities.postProfileUrl(userId);
    }

    public ProfilePage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }

    public String getFirstPostStyleAttribute() {
        WebElement webElement = seleniumUtilities.waitForElement(FIRST_POST);
        return webElement.getAttribute("style");
    }

    public String getFirstPostText() {
        WebElement webElement = seleniumUtilities.waitForElement(FIRST_POST);
        return webElement.getText();
    }

    public int getLikeCount() {
        WebElement webElement = seleniumUtilities.waitForElement(FIRST_POST_LIKES);
        return Integer.parseInt(webElement.getText());
    }

    public void likeFirstPost() {
        WebElement webElement = seleniumUtilities.waitForElement(FIRST_POST_LIKES);
        webElement.click();
    }
}

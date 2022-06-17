package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtilities;

public class PostPage implements Page{
    private static final By BEACH_DESIGN_BTN =
            By.xpath("//*[@data-decorator-id='90']");
    private static final By MESSAGE_FIELD_IN_POST =
            By.xpath("//*[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']");
    private static final By POST_BTN =
            By.xpath("//*[@data-l='t,button.submit']");

    private final SeleniumUtilities seleniumUtilities;

    public PostPage(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    public PostPage selectBeachDesign() {
        seleniumUtilities.click(BEACH_DESIGN_BTN);
        return this;
    }

    public void sendPost(String msg) {
        enterPostMessage(msg);
        seleniumUtilities.click(POST_BTN);
    }

    private void enterPostMessage(String msg) {
        seleniumUtilities.enterText(MESSAGE_FIELD_IN_POST, msg);
    }
}

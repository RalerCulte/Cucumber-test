package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtilities;

public class PostPage extends Page {
    private static final By BEACH_DESIGN_BTN =
            By.xpath("//*[contains(@class,'posting_cp_i js-color-picker-i js-color-picker-i-90')]");
    private static final By MESSAGE_FIELD_IN_POST =
            By.xpath("//*[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']");
    private static final By POST_BTN =
            By.xpath("//*[@data-l='t,button.submit']");


    public PostPage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
    }

    // TODO неиспользуемый метод
    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }

    public PostPage selectBeachDesign() {
        seleniumUtilities.click(BEACH_DESIGN_BTN);
        return this;
    }

    public PostPage sendPost(String msg) {
        enterPostMessage(msg);
        seleniumUtilities.click(POST_BTN);
        return this;
    }

    private void enterPostMessage(String msg) {
        seleniumUtilities.enterText(MESSAGE_FIELD_IN_POST, msg);
    }
}

package pages;

import utils.SeleniumUtilities;

public class GroupPage extends Page {

    private static final String GROUP_URL = "https://ok.ru/group/";

    public GroupPage(SeleniumUtilities seleniumUtilities, String groupId) {
        super(seleniumUtilities);
        seleniumUtilities.postUrl(GROUP_URL + groupId);
    }

    public boolean checkAccessByAge() {
        String text = seleniumUtilities.getElementText("//*[contains(@class,'stub-empty')]//*[@class='stub-empty_t']");
        return !text.contains("18+");
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }
}

package pages;

import org.openqa.selenium.By;

import utils.SeleniumUtilities;

public class GroupPage extends Page {

    private static final String BLOCK = "18+";

    public GroupPage(SeleniumUtilities seleniumUtilities, String groupId) {
        super(seleniumUtilities);
        seleniumUtilities.postGroupUrl(groupId);
    }

    public boolean checkAccessByAge() {
        String text = seleniumUtilities.getElementText(By.xpath("//*[contains(@class,'stub-empty')]//*[@class='stub-empty_t']"));
        return !text.contains(BLOCK);
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }
}

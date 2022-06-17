package pages;

import org.openqa.selenium.By;

import utils.SeleniumUtilities;

public class GroupPage implements Page{

    private static final String BLOCK = "18+";
    private static final By age = By.xpath("//*[contains(@class,'stub-empty')]//*[@class='stub-empty_t']");

    private final SeleniumUtilities seleniumUtilities;

    public GroupPage(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    public boolean checkAccessByAge() {
        String text = seleniumUtilities.getElementText(age);
        return !text.contains(BLOCK);
    }
}

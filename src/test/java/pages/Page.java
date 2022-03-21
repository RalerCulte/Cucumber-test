package pages;

import utils.SeleniumUtilities;

public abstract class Page {
    SeleniumUtilities seleniumUtilities;

    public Page(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    abstract public String getUrl();
}

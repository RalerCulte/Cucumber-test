package pages;

import utils.SeleniumUtilities;

public abstract class Page {
    protected final SeleniumUtilities seleniumUtilities;

    public Page(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    abstract public String getUrl();
}

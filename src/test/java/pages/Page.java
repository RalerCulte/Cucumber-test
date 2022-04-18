/**
 * TODO поменять имена пакетов
 *
 * В текущем виде возможно пересечение имен пакетов, классов, т.к. pages.Page недостаточно уникальное имя.
 *
 * То же относится и к пакетам test и utils.
 *
 * см. https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html
 */
package pages;

import utils.SeleniumUtilities;

public abstract class Page {
    SeleniumUtilities seleniumUtilities;

    public Page(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    // TODO неиспользуемый метод
    abstract public String getUrl();
}

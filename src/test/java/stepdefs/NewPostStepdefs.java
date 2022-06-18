package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;
import pages.MainPage;
import pages.Page;
import pages.ProfilePage;
import stepdefs.exceptions.PageStateException;
import utils.SeleniumUtilities;
import utils.User;

import static com.google.common.truth.Truth.assertWithMessage;

public class NewPostStepdefs {

    private final SeleniumUtilities seleniumUtilities = SeleniumUtilitiesController.getSeleniumUtilities();
    private Page page;

    @Допустим("Авторизация с логином {string} и паролем {string}")
    public void АвторизацияСЛогиномИПаролем(String arg0, String arg1) throws PageStateException {
        if (page != null) {
            throw new PageStateException("Данный метод должен вызываться перед всеми остальными");
        }
        User testUser = new User.UserBuilder()
                .setPhoneNumber(arg0)
                .setPassword(arg1)
                .build();

        seleniumUtilities.postUrl(MainPage.URL);
        page = new LoginPage(seleniumUtilities)
                .loginByPhone(testUser);
    }

    @Тогда("Публикация нового поста с текстом {string} и пляжем на фоне")
    public void публикацияНовогоПостаСТекстомИПляжемНаФоне(String arg0) throws PageStateException {
        if (!(page instanceof MainPage mainPage)) {
            throw new PageStateException("Для публикации поста нужно находиться на главном экране");
        }
        mainPage.receivePostPage()
                .selectBeachDesign()
                .sendPost(arg0);
    }


    @Тогда("Проверить что последний пост профиля {string} имеет цвет rgb\\({string})")
    public void проверитьЧтоПоследнийПостПрофиляИмеетЦветRgb(String arg0, String arg1) {
        seleniumUtilities.postUrl(arg0);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String style = profilePage
                .getFirstPostStyleAttribute();
        page = profilePage;
        assertWithMessage("Colors equals")
                .that(style)
                .contains("rgb(" + arg1 + ")");
    }

    @Тогда("Проверить что последний пост профиля {string} имеет текст {string}")
    public void проверитьЧтоПоследнийПостПрофиляИмеетТекст(String arg0, String arg1) {
        seleniumUtilities.postUrl(arg0);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String firstPostText = profilePage
                .getFirstPostText();
        page = profilePage;
        assertWithMessage("TestMessage equals")
                .that(firstPostText)
                .contains(arg1);
    }

    @After
    public void after() {
        SeleniumUtilitiesController.close();
    }
}

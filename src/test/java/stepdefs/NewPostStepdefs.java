package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;
import pages.MainPage;
import pages.Page;
import pages.PostPage;
import pages.ProfilePage;
import stepdefs.exceptions.PageStateException;
import utils.SeleniumUtilities;
import utils.User;

import static com.google.common.truth.Truth.assertWithMessage;

public class NewPostStepdefs {
    private static final String SAND_COLOR_RGB = "rgb(247, 196, 67)";
    private String currentText;

    private Page page;
    private SeleniumUtilities seleniumUtilities;

    @Before
    public void before() {
        seleniumUtilities = Prepare.before();
    }

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
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        page = loginPage.loginByPhone(testUser);
    }

    @Тогда("Публикация нового поста с текстом {string} и пляжем на фоне")
    public void публикацияНовогоПостаСТекстомИПляжемНаФоне(String arg0) throws PageStateException {
        if (!(page instanceof MainPage mainPage)) {
            throw new PageStateException("Для публикации поста нужно находиться на главном экране");
        }

        currentText = arg0;
        PostPage postPage = mainPage.receivePostPage();
        postPage.selectBeachDesign().sendPost(arg0);
    }

    @Тогда("Проверить соответствие фона")
    public void проверитьСоответствиеФона() {
        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String style = profilePage.getFirstPostStyleAttribute();
        assertWithMessage("Colors equals").that(style).contains(SAND_COLOR_RGB);
    }

    @Тогда("Проверить соответствие текста")
    public void проверитьСоответствиеТекста() throws PageStateException {
        if (currentText == null) {
            throw new PageStateException("Пост должен содержать текст");
        }

        ProfilePage profilePage = new ProfilePage(seleniumUtilities);
        String firstPostText = profilePage.getFirstPostText();
        assertWithMessage("TestMessage equals").that(firstPostText).contains(currentText);
    }

    @After
    public void after() {
        Prepare.after();
    }
}

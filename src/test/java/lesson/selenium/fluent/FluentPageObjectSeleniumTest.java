package lesson.selenium.fluent;

import lesson.selenium.page.fluent.UserBugredHomePage;
import lesson.selenium.page.fluent.UssrBugredLoginRegistrationPage;
import org.testng.annotations.Test;

public class FluentPageObjectSeleniumTest extends AbstractSeleniumBaseTest {

    @Test
    public void registrationSuccessTest() {
        driver.get("http://users.bugred.ru/");
        UssrBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick();

        UserBugredHomePage homePage = loginRegistrationPage
                .fillRegistrationUserNameTextField("vashSJKDSALDHASK")
                .fillRegistrationEmailTextField("test.user182yhgasghasg@email.com")
                .fillRegistrationPasswordTextField("test")
                .successRegistrationButtonClick();

//        assertThat("Кнопка пользователя не отображается", homePage.isUserButtonDisplayed());
//        assertThat(homePage.getUserButtonText(), equalTo("vashSJKDSALDHASK"));
    }

    @Test
    public void registrationFailedTest() {
        driver.get("http://users.bugred.ru/");
        UssrBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick()
                .fillRegistrationUserNameTextField("uquyiy")
                .fillRegistrationEmailTextField("test.user")
                .fillRegistrationPasswordTextField("test")
                .failedRegistrationButtonClick();

//        assertThat(loginRegistrationPage.getRegistrationErrorMessageText(),
//                equalTo("register_not_correct_field (email)"));
    }
}
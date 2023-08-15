package tests;

import apiMethods.LoginSerialization;
import apiMethods.ApiMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private boolean isCleaningNeeded = false;

    @Test
    public void correctRegistration() {
        isCleaningNeeded = true;
        RegisterPage obj = new RegisterPage(driver);

        obj.clickProfileButton();
        obj.clickSignUpButton();
        obj.SendKeysToInputsAndClick("Test", "Test@123456.ru", "12345678");
        Assert.assertEquals("Произошла ошибка при регистрации", "Вход", obj.getSignInHeaderText());
    }

    @Test
    public void shortPasswordRegistration() {
        RegisterPage obj = new RegisterPage(driver);

        obj.clickProfileButton();
        obj.clickSignUpButton();
        obj.SendKeysToInputsAndClick("Test", "Test@123456.ru", "12345");

        Assert.assertEquals("Произошла ошибка", "Некорректный пароль", obj.getErrorText());
    }

    @After
    public void deleteUser(){
        if(isCleaningNeeded) {
            LoginSerialization login = new LoginSerialization("Test@123456.ru", "12345678");
            ApiMethods obj = new ApiMethods();
            obj.deleteUser(login);
            isCleaningNeeded = false;
        }
    }
}

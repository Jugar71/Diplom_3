package tests;

import apiMethods.LoginSerialization;
import apiMethods.ApiMethods;
import apiMethods.RegisterSerialization;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest{

    @Before
    public void createUser() {
        RegisterSerialization user = new RegisterSerialization("Test@123456.ru", "12345678", "Test");
        ApiMethods obj = new ApiMethods();
        obj.createUser(user);
    }

    @Test
    public void mainSignIn() {
        LoginPage obj = new LoginPage(driver);

        obj.clickMainSignInButton();
        obj.SendKeysToInputsAndClick( "Test@123456.ru", "12345678");
        Assert.assertEquals("Произошла ошибка при входе", "Соберите бургер", obj.getHeader());
    }

    @Test
    public void profileSignIn() {
        RegisterPage reg = new RegisterPage(driver);
        LoginPage obj = new LoginPage(driver);

        reg.clickProfileButton();
        obj.SendKeysToInputsAndClick( "Test@123456.ru", "12345678");
        Assert.assertEquals("Произошла ошибка при входе", "Соберите бургер", obj.getHeader());
    }

    @Test
    public void regSignIn() {
        RegisterPage reg = new RegisterPage(driver);
        LoginPage obj = new LoginPage(driver);

        reg.clickProfileButton();
        obj.clickRegButton();
        obj.clickRegForgotSignInButton();
        obj.SendKeysToInputsAndClick( "Test@123456.ru", "12345678");
        Assert.assertEquals("Произошла ошибка при входе", "Соберите бургер", obj.getHeader());
    }

    @Test
    public void forgetSignIn() {
        RegisterPage reg = new RegisterPage(driver);
        LoginPage obj = new LoginPage(driver);

        reg.clickProfileButton();
        obj.clickForgotButton();
        obj.clickRegForgotSignInButton();
        obj.SendKeysToInputsAndClick( "Test@123456.ru", "12345678");
        Assert.assertEquals("Произошла ошибка при входе", "Соберите бургер", obj.getHeader());
    }

    @After
    public void deleteUser(){
        LoginSerialization login = new LoginSerialization("Test@123456.ru", "12345678");
        ApiMethods obj = new ApiMethods();
        obj.deleteUser(login);
    }
}

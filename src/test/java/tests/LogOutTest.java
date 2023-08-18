package tests;

import apiMethods.LoginSerialization;
import apiMethods.ApiMethods;
import apiMethods.RegisterSerialization;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LogOutPage;
import pages.LoginPage;
import pages.RegisterPage;

public class LogOutTest extends BaseTest {

    @Before
    public void createUser() {
        RegisterSerialization user = new RegisterSerialization("Test@123456.ru", "12345678", "Test");
        ApiMethods obj = new ApiMethods();
        obj.createUser(user);
    }

    @Test
    public void logOut() {
        RegisterPage reg = new RegisterPage(driver);
        LoginPage obj = new LoginPage(driver);

        obj.clickMainSignInButton();
        obj.SendKeysToInputsAndClick( "Test@123456.ru", "12345678");
        reg.clickProfileButton();

        LogOutPage logOut = new LogOutPage(driver);
        logOut.clickLogOutButton();
        Assert.assertEquals("Произошла ошибка при выходе из учётной записи", "Вход", logOut.getHeader());
    }

    @After
    public void deleteUser(){
        LoginSerialization login = new LoginSerialization("Test@123456.ru", "12345678");
        ApiMethods obj = new ApiMethods();
        obj.deleteUser(login);
    }
}

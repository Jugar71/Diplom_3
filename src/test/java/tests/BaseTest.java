package tests;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void webDriver() {

        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Users\\mbolshakov\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(options);

        driver = new ChromeDriver();
        driver.get(URL);
        RestAssured.baseURI = URL;
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

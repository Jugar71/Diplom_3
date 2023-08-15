package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By mainSignInButton = By.xpath("//button[contains(text(), 'Войти в аккаунт')]");
    private By regButton = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
    private By forgotButton = By.xpath("//a[contains(text(), 'Восстановить пароль')]");
    private By regForgotSignInButton = By.xpath("//a[contains(text(), 'Войти')]");
    private By emailInput = By.xpath("//fieldset[1]/div/div/input");
    private By passwordInput = By.xpath("//fieldset[2]/div/div/input");
    private By signInButton = By.xpath("//button[contains(text(), 'Войти')]");
    private By mainHeader = By.xpath("//h1[contains(text(), 'Соберите бургер')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем на кнопку Входа на главной странице")
    public void clickMainSignInButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(mainSignInButton));
        driver.findElement(mainSignInButton).click();
    }

    @Step("Кликаем на кнопку Регистрации")
    public void clickRegButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(regButton));
        driver.findElement(regButton).click();
    }

    @Step("Кликаем на кнопку Забыли пароль?")
    public void clickForgotButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(forgotButton));
        driver.findElement(forgotButton).click();
    }

    @Step("Кликаем на кнопку Вход после Регистрации или Забыли пароль?")
    public void clickRegForgotSignInButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(regForgotSignInButton));
        driver.findElement(regForgotSignInButton).click();
    }

    @Step("Заполняем инпуты и кликаем на Вход")
    public void SendKeysToInputsAndClick(String email, String password) {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    @Step("Смотрим, что нас перебросило на Главную")
    public String getHeader() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
        return driver.findElement(mainHeader).getText();
    }
}

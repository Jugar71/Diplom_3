package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    private By profileButton = By.xpath("//p[contains(text(), 'Личный Кабинет')]");
    private By signUpButton = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
    private By nameInput = By.xpath("//fieldset[1]/div/div/input");
    private By emailInput = By.xpath("//fieldset[2]/div/div/input");
    private By passwordInput = By.xpath("//fieldset[3]/div/div/input");
    private By registerButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private By errorLabel = By.xpath("//p[contains(text(), 'Некорректный пароль')]");
    private By sigInHeader = By.xpath(".//h2[contains(text(), 'Вход')]");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем на кнопку Личного Кабинета")
    public void clickProfileButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();
    }

    @Step("Кликаем на кнопку Зарегестрироваться")
    public void clickSignUpButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(signUpButton));
        driver.findElement(signUpButton).click();
    }

    @Step("Заполняем инпуты и кликаем на Регистрацию")
    public void SendKeysToInputsAndClick(String name, String email, String password) {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Получаем текст ошибки о некорректном пароле")
    public String getErrorText() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(errorLabel));
        return driver.findElement(errorLabel).getText();
    }

    @Step("Смотрим, что нас перебросило к форме входа")
    public String getSignInHeaderText() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(sigInHeader));
        return driver.findElement(sigInHeader).getText();
    }
}


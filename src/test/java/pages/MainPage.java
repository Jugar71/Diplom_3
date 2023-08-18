package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    private By constructorButton = By.xpath("//p[contains(text(), 'Конструктор')]");
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private By mainHeader = By.xpath("//h1[contains(text(), 'Соберите бургер')]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем на кнопку Конструктор")
    public void clickConstructorButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Кликаем на Лого")
    public void clickLogoButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();
    }

    @Step("Проверяем, что перешли к Конструктору")
    public String getHeader() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
        return driver.findElement(mainHeader).getText();
    }
}

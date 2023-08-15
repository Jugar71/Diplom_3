package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage {

    private WebDriver driver;

    private By logOutButton = By.xpath("//button[contains(text(), 'Выход')]");
    private By SignInHeader = By.xpath("//h2[contains(text(), 'Вход')]");

    public LogOutPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Кликаем на Выход")
    public void clickLogOutButton() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(logOutButton));
        driver.findElement(logOutButton).click();
    }

    @Step("Смотрим, что вышли")
    public String getHeader() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(SignInHeader));
        return driver.findElement(SignInHeader).getText();
    }
}

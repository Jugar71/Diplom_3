package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;

    private By bunButton = By.xpath("//span[contains(text(), 'Булки')]");
    private By sauceButton = By.xpath("//span[contains(text(), 'Соусы')]");
    private By fillingButton = By.xpath("//span[contains(text(), 'Начинки')]");

    private By bunHeader = By.xpath("//h2[1][contains(text(), 'Булки')]");
    private By sauceHeader = By.xpath("//h2[2][contains(text(), 'Соусы')]");
    private By fillingHeader = By.xpath("//h2[3][contains(text(), 'Начинки')]");

    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Переходим к разделу Начинки, а затем проверяем переход к Булкам")
    public String getBunHeader() {
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        WebElement wait2 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        driver.findElement(bunButton).click();
        WebElement wait3 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(bunHeader));
        return driver.findElement(bunHeader).getText();
    }

    @Step("Переходим к разделу Начинки, а затем проверяем переход к Соусам")
    public String getSauceHeader() {
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        WebElement wait2 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        driver.findElement(sauceButton).click();
        WebElement wait3 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(sauceHeader));
        return driver.findElement(sauceHeader).getText();
    }
    @Step("Проверяем переход к Начинкам")
    public String getFillingHeader() {
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        WebElement wait2 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        return driver.findElement(fillingHeader).getText();
    }
}

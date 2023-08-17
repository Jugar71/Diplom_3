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

    private By buns = By.xpath("//ul[1][@class='BurgerIngredients_ingredients__list__2A-mT']");
    private By sauces = By.xpath("//ul[2][@class='BurgerIngredients_ingredients__list__2A-mT']");
    private By fillings = By.xpath("//ul[3][@class='BurgerIngredients_ingredients__list__2A-mT']");

    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Переходим к Начинкам, чтобы уже оттуда проверять Булки и Соусы")
    public void bunsAndSaucesPrecondition() {
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
    }

    @Step("Проверяем переход к Булкам")
    public boolean areBunsDisplayed() {
        driver.findElement(bunButton).click();
        WebElement wait3 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(buns));
        return driver.findElement(buns).isDisplayed();
    }

    @Step("Проверяем переход к Соусам")
    public boolean areSaucesDisplayed() {
        driver.findElement(sauceButton).click();
        WebElement wait3 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(sauces));
        return driver.findElement(sauces).isDisplayed();
    }
    @Step("Проверяем переход к Начинкам")
    public boolean areFillingDisplayed() {
        driver.findElement(fillingButton).click();
        WebElement wait3 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(fillings));
        return driver.findElement(fillings).isDisplayed();
    }
}

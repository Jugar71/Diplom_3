package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

    private By constructBurger = By.xpath("//h1[contains(text(), 'Соберите бургер')]");
    private By bunHeader = By.xpath("//h2[1][contains(text(), 'Булки')]");
    private By sauceHeader = By.xpath("//h2[2][contains(text(), 'Соусы')]");
    private By fillingHeader = By.xpath("//h2[3][contains(text(), 'Начинки')]");

    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Проверяем скролл до Булок")
    public boolean checkBun() throws InterruptedException {
        boolean isScrolled = false;
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        Thread.sleep(2000);
        driver.findElement(bunButton).click();
        Thread.sleep(2000);
        Point burger = driver.findElement(constructBurger).getLocation();
        Point bun = driver.findElement(bunHeader).getLocation();
        if(bun.getY() - burger.getY() == 115) {
            isScrolled = true;
        }
        return isScrolled;
    }

    @Step("Проверяем скролл до Соусов")
    public boolean checkSauce() throws InterruptedException {
        boolean isScrolled = false;
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        Thread.sleep(2000);
        driver.findElement(sauceButton).click();
        Thread.sleep(2000);
        Point burger = driver.findElement(constructBurger).getLocation();
        Point sauce = driver.findElement(sauceHeader).getLocation();
        if(sauce.getY() - burger.getY() == 115) {
            isScrolled = true;
        }
        return isScrolled;
    }

    @Step("Проверяем скролл до Начинок")
    public boolean checkFilling() throws InterruptedException {
        boolean isScrolled = false;
        WebElement wait1 = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        Thread.sleep(2000);
        Point burger = driver.findElement(constructBurger).getLocation();
        Point filling = driver.findElement(fillingHeader).getLocation();
        if(filling.getY() - burger.getY() == 115) {
            isScrolled = true;
        }
        return isScrolled;
    }
}
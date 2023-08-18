package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    private By descriptionText = By.xpath("//p[contains(text(), 'В этом разделе вы можете изменить свои персональные данные')]");

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Проверяем, что находимся в Личном Кабинете")
    public String getDescription() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))//Ждём
                .until(ExpectedConditions.visibilityOfElementLocated(descriptionText));
        return driver.findElement(descriptionText).getText();
    }
}

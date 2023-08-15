package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;

public class ConstructorTest extends BaseTest{

    @Test
    public void checkBuns() {
        ConstructorPage bun = new ConstructorPage(driver);
        Assert.assertEquals("Произошла ошибка при выходе из учётной записи", "Булки", bun.getBunHeader());
    }

    @Test
    public void checkSauces() {
        ConstructorPage sauce = new ConstructorPage(driver);
        Assert.assertEquals("Произошла ошибка при выходе из учётной записи", "Соусы", sauce.getSauceHeader());
    }

    @Test
    public void checkFillings() {
        ConstructorPage filling = new ConstructorPage(driver);
        Assert.assertEquals("Произошла ошибка при выходе из учётной записи", "Начинки", filling.getFillingHeader());
    }
}

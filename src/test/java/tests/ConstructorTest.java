package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;

public class ConstructorTest extends BaseTest{

    @Test
    public void checkBuns() {
        ConstructorPage obj = new ConstructorPage(driver);
        obj.bunsAndSaucesPrecondition();
        Assert.assertTrue("Произошла ошибка при переходе к разделу Булки", obj.areBunsDisplayed());
    }

    @Test
    public void checkSauces() {
        ConstructorPage obj = new ConstructorPage(driver);
        obj.bunsAndSaucesPrecondition();
        Assert.assertTrue("Произошла ошибка при переходе к разделу Соусы", obj.areSaucesDisplayed());
    }

    @Test
    public void checkFillings() {
        ConstructorPage obj = new ConstructorPage(driver);
        Assert.assertTrue("Произошла ошибка при переходе к разделу Начинки", obj.areFillingDisplayed());
    }
}

package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.ConstructorPage;

public class ConstructorTest extends BaseTest{

    @Test
    public void checkBun() throws InterruptedException {
        ConstructorPage obj = new ConstructorPage(driver);
        Assert.assertTrue("Произошла ошибка при переходе к разделу Булки", obj.checkBun());
    }

    @Test
    public void checkSauce() throws InterruptedException {
        ConstructorPage obj = new ConstructorPage(driver);
        Assert.assertTrue("Произошла ошибка при переходе к разделу Соусы", obj.checkSauce());
    }

    @Test
    public void checkFilling() throws InterruptedException {
        ConstructorPage obj = new ConstructorPage(driver);
        Assert.assertTrue("Произошла ошибка при переходе к разделу Начинки", obj.checkFilling());
    }
}

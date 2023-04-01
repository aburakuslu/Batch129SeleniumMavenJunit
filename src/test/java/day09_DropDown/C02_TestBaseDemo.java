package day09_DropDown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Basligin "Bootcamp" icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}

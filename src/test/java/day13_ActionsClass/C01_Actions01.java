package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import static org.junit.Assert.assertEquals;

public class C01_Actions01 extends TestBase {
    /*
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sağ tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void actionsTest() {

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sağ tıklayın
        //Sag tik islemi icin contextClick() method'una ihtiyacimiz var. Bunun icin Actions objeci olusturulmalidir.

        //1. Adim: Actions objesi olusturun
        Actions actions = new Actions(driver);

        //2. Adim: Uzerinde islem yapilacak WebElement'i locate edin
        WebElement box = driver.findElement(By.id("hot-spot"));

        //3. Adim: Islemi uygulayin
        actions.contextClick(box).perform(); //perform() method'u son olarak uygulanmalidir.

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertText = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertText);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}

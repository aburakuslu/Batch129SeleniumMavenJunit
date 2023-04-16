package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;

public class C03_FluentWait extends TestBase {
     /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıklayın
    Hello World! Yazının sitede oldugunu test edin
     */

    @Test
    public void fluentWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        //Hello World! Yazının sitede oldugunu test edin

        //Fluent wait'in WebDriverWait'ten farkı 'wait' objesinin oluşturulmasında ortaya çıkar.
        Wait<WebDriver> wait = new FluentWait<>(driver).
                             withTimeout(Duration.ofSeconds(30)). //Maksimum bekleme suresi
                             pollingEvery(Duration.ofSeconds(3)). //Deneme araliklari: Her 3 saniyede bir bulma denemesi yapar
                             withMessage("Ignore Exception"). // Mesaj yazdirilabilir, zorunlu degil
                             ignoring(TimeoutException.class); // Exception handle edilebilir, zorunlu degil.

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        assertTrue(helloWorldText.isDisplayed());
    }
}

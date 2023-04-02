package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task02 extends TestBase {

    /*
        *** Aşağıdaki Task'i Junit framework'u ile yapınız
        - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        - Add Element butonuna 100 defa basınız
        - 100 defa basıldığını test ediniz
        - 90 defa delete butonuna basınız
        - 90 defa basıldığını doğrulayınız
        - Sayfayı kapatınız
     */

    WebDriver driver = new ChromeDriver();

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // - Add Element butonuna 100 defa basınız

        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));



    }
}

package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //İlk sayfanın ID'sini(Window Handle değerini) alın.
        String firstPageWindowHandle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement pageText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", pageText.getText());

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);

        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text=()'Click Here']")).click();
        //Açılan pencereye geçin.
        /*
            Eger bir butona click yaptigimizda bizim kontrolumuz disinda yeni bir pencere aciliyorsa
            o pencere icindeki web elementleri handle edebilmemiz icin switchTo() methodu ile gecis yapmamiz gerekir.
            Fakat kontrolumuz disinda acildigi icin handle degerini bilmedigimiz icin tum acilan pencereleri
            getWindowHandles methodunu kullanarak bir Set'e assign ederiz ya da ArrayList'e assign ederiz.
        */

        Set<String> allWindows = driver.getWindowHandles();
        for(String w: allWindows) {
            if(!w.equals(firstPageWindowHandle)) {
                driver.switchTo().window(w);
            }
        }//Burada asil amac kontrolumuz disinda acilan pencereye gecis yapmak

        List<String> allWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allWindowHandles.get(1));

        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals("New Window", actualTitle2);
        String secondPageWindowHandle = driver.getWindowHandle();

        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(firstPageWindowHandle);
        Assert.assertEquals("The Internet", driver.getTitle());
        bekle(3);

        //2. pencereye tekrar geçin.
        driver.switchTo().window(secondPageWindowHandle);
        bekle(3);
        //1. pencereye tekrar dönün.
        driver.switchTo().window(firstPageWindowHandle);

    }
}

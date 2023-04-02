package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {
        //Method'lar kullanilarak C03_Alerts'deki soru tekrar cozuldu.

        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(4);
        alertAccept();
        bekle(4);
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        bekle(4);
        alertDismiss();
        bekle(4);
        //    “successfully” icermedigini test edin.
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "succesfully";
        Assert.assertFalse(actualText.contains(expectedText));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        bekle(4);
        alertprompt("Burak");
        alertAccept();
        bekle(4);
        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(result.getText().contains("Burak"));
        System.out.println(result.getText());
    }
}

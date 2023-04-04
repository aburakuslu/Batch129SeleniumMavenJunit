package day12_WindowHandleBasicAuthentication;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static junit.framework.TestCase.assertTrue;

public class C02_BasicAuthentication extends TestBase {

    /*
    Asagidaki bilgileri kullanarak, authentication yapiniz:

    URL: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin

    Başarılı girişi doğrulayın.
     */


    //Authentication URL: https://admin:admin@the-internet.herokuapp.com/basic_auth

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Paragrafin congratulations kelimesini icerdigini dogrulayiniz
        String paragraph = driver.findElement(By.xpath("//p")).getText();
        assertTrue(paragraph.contains("Congratulations"));
    }
}

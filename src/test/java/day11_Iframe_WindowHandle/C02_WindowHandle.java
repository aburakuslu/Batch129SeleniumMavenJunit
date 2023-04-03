package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
    /*
    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:
     */

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //String techproWindowHandle = driver.getWindowHandle(); //Techpro sayfasinin handle degerini bir String'e assign ettik.
        //System.out.println(techproWindowHandle);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().//Gecis yap
               newWindow(WindowType.WINDOW); //--> Yeni bir pencereye driver'i tasir.
                                             //WindowType.TAB --> Yeni sekme acar.
        driver.get("https://www.youtube.com");
        //String youtubeWindowHandle = driver.getWindowHandle(); //YouTube sayfasinin handle degerini bir String'e assign ettik.
        //System.out.println(youtubeWindowHandle);

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        //String linkedinWindowHandle = driver.getWindowHandle();
        //System.out.println(linkedinWindowHandle);

        List<String> allWindowList = new ArrayList<String>(driver.getWindowHandles());
        //Butun actigimiz pencerelerin handle degerlerini bir ArrayList'e atadik.

        //techproeducation sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(techproWindowHandle);
        driver.switchTo().window(allWindowList.get(0)); //Ilk actigimiz pencereye index ile gecebiliriz

        //youtube sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(youtubeWindowHandle);
        driver.switchTo().window(allWindowList.get(1));

        //linkedIn sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(linkedinWindowHandle);
        driver.switchTo().window(allWindowList.get(2));

    }
}

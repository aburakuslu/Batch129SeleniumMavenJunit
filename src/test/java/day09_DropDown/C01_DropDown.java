package day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
    - DropDown nedir: Altbasliklarin oldugu acilir menu listesidir.
    -DropDown nasil automate edilir(Handle):
        a- DropDown menuyu ilk olarak locate ederiz.
        b- Select object'i olustururuz
        c- Select object'inin ddm elementinin icerigine ve seceneklerine
        erisim saglamasi icin SELECT class'ina argument olarak locate ettigimiz webelement'i koyariz.
            Syntax: Select select = new select(ddm webelement)
        d- Select class'i, sadece select tag'i ile olusturulmus dropdown menulere uygulanabilir.
        e- select object'i ile ddm'yu handle edebilmek icin 3 method kullanilir.
            -selectByVisibleText() --> ddm'deki elemente gorunur metin ile ulasmak icin kullanilir.
            -selectByIndex() --> Index ile ulasmak icin kullanilir.
            -selectByValue --> Element'in degeri ile ulasmak icin kullanilir(option tag'indeki deger ile)
        f-getOptions()->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür
        g-getFirstSelectedOption()->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void test02() {
        /*
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }

        stateList.forEach(t -> System.out.println(t.getText()));
         */
        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("*****************************");
        tumEyaletler.forEach(t -> System.out.println(t.getText()));
        //b. Sayfadaki tüm ddm lerdeki tüm seçenekleri(option) konsolda yazdırınız
        System.out.println("******************************");
        List<WebElement> eyaletlerList = driver.findElements(By.tagName("option"));
        eyaletlerList.forEach(t -> System.out.println(t.getText()));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}

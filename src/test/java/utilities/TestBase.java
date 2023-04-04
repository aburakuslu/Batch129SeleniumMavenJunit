package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase class'indan object olusturmanin onune gecilmesi icin abstract yapilabilir
    //Orn: TestBase base = new TestBase();
    //Bu class'i extends ettigimiz test class'larindan ulasabiliriz.
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //Thread.sleep(3000);
        driver.quit();
    }

    // ****** HARD WAIT METHOD ******
    public static void bekle(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ****** Alert ACCEPT ******
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    // ****** Alert DISMISS ******
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    // ****** Alert getText() ******
    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    // ****** Alert promptBox ******
    public static void alertprompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // ****** DropDown VisibleText ******
    /*

        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
        ddmVisibleText(gun, "7") --> Yukaridaki kullanim yerine sadece method ile handle edebiliriz.

     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    // ****** DropDown Index ******
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    // ****** DropDown Value ******
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchTo: Sayfalar arasi gecis method'u
    //Index 0'dan baslar
    //Girilen index'teki windowHandle degerini alarak o sayfaya gecis yapar.
    public static void switchToWindow(int pageIndex) {
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(pageIndex));
    }
}

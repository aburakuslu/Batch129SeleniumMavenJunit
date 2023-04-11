package day14_Faker_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertTrue;

public class C03_FileExist {
    /*
    Masaüstünde "logo.jpeg" dosyası oluşturun.
    Bu dosyanın varlığını doğrulayın.
    */

    @Test
    public void fileExistTest() {

        String userDIR = System.getProperty("user.dir");// /Users/alpburakuslu/IdeaProjects/B129SeleniumMavenJunit
        //IDE proje yolunu dinamik olarak verir

        String userHOME = System.getProperty("user.home"); // /Users/alpburakuslu(kullanici adi)
        //Kullanıcı adı yolunu dinamik olarak verir
        boolean isExist = Files.exists(Paths.get(userHOME + "/Desktop/logo.jpeg"));
        System.out.println("isExist = " + isExist);
        assertTrue(isExist);

        /*
        Fail ise: Dosya masaüstünde değil, dosya adı yanlış,
        ya da arada onedrive gibi ekstra dosyalar olabilir.
         */
    }
}

package day14_Faker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker extends TestBase {

    @Test
    public void javaFakerTest() {
        //1. Faker objesi olustur:
        Faker faker = new Faker();

        //Ya da Faker.instance() static methodu ile baslayabiliriz.
        Faker.instance();

        //First Name yazdirin
        System.out.println(faker.name().firstName());

        //Last Name yazdirin
        System.out.println(Faker.instance().name().lastName());

        //Kullanici adi yazdirin
        System.out.println(faker.name().username());

        //Funny Name yazdirin
        System.out.println(faker.funnyName().name());

        //Meslek ismi yazdirin
        System.out.println(faker.name().title());

        //Sehir ismi yazdirin
        System.out.println(faker.address().city());

        //Eyalet yazdirin
        System.out.println(faker.address().state());

        //Full Address yazdirin
        System.out.println(faker.address().fullAddress());

        //Cep numarası yazdırın:
        System.out.println(faker.phoneNumber().cellPhone());

        //Email yazdırın:
        System.out.println(faker.internet().emailAddress());

        //Posta kodu yazdırın:
        System.out.println(faker.address().zipCode());

        //Rastgele 15 haneli numara yazdırın:
        System.out.println(faker.number().digits(15));
    }
}

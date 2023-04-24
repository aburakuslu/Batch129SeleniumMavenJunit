package day20_ReadExcel_WriteExcel;


import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class C01_ExcelRead {
    /*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
     */

    @Test
    public void readExcelTest() throws IOException {

        //Dosyayı al:
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/Capitals.xlsx");

        //FileInputStream objesini WorkBook(Excel) dosyası olarak aç:
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Sayfayı(Sheet) aç:
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //Satıra(Row) git:
        Row row = sheet1.getRow(0);//1. satır: index 0

        //Birinci hücreyi(Cell) al:
        Cell cell = row.getCell(0);//1. hücre: index 0

        System.out.println("cell = " + cell);

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println("cell1 = " + cell12);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell31 = sheet1.getRow(2).getCell(0);
        System.out.println("cell31 = " + cell31);
        assertEquals("France", cell31.toString());

        //Kullanılan satır sayısın bulun
        int sonKullanilanSatirIndeksi = sheet1.getLastRowNum();//Son kullanılan satırın index'ini verir
        System.out.println("sonKullanilanSatirIndeksi = " + sonKullanilanSatirIndeksi);

        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();//Kullanilan toplam satir sayisini verir
        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);

        //Ülke-Başkent şeklinde verileri yazdırın

        Map<String, String> ulkelerVeBaskentleri = new HashMap<>();

        ulkelerVeBaskentleri.put("France", "Paris");

        for (int satirIndex = 1; satirIndex < kullanilanToplamSatirSayisi; satirIndex++) {
            String ulkeAdi = sheet1.getRow(satirIndex).getCell(0).toString();
            String baskentAdi = sheet1.getRow(satirIndex).getCell(1).toString();

            ulkelerVeBaskentleri.put(ulkeAdi,baskentAdi);
        }

        System.out.println("ulkelerVeBaskentleri = " + ulkelerVeBaskentleri);
    }
}

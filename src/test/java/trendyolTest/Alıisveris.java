package trendyolTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Alıisveris {

    @Test
    public void  alisverisTesti () throws InterruptedException {

        // 1- Gerekli ayarları yapalım.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        // 2- "https://www.trendyol.com/" gidin
        driver.get("https://www.trendyol.com/");

        // 3- Acılan reklamı kapa
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//div[@class='modal-close']")).click();

        // 4- Arama kismina "MacBook pro m2" yazin ve aratin
        driver.findElement(By.xpath("//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")).sendKeys("MacBook pro m2"+Keys.ENTER);

        WebElement siteKlavuzu = driver.findElement(By.xpath("//div[@class='overlay']"));
        siteKlavuzu.click();

        // 5- Arama sonucunda kac adet unun oldugunu yazdirin.
        WebElement bulunanSonuc=driver.findElement(By.xpath("//div[@class='srch-ttl-cntnr-wrppr']"));
        System.out.println(bulunanSonuc.getText());

        // 6- Marka listesinden APPLE'i listele.
        WebElement markaSecimi = driver.findElement(By.xpath("//a[@href='/sr?wb=101470&q=macbook pro m2&qt=MacBook pro m2&st=MacBook pro m2&os=1']"));
        markaSecimi.click();

        // 7- pahalıdan ucuzs sırala
        WebElement siralama=driver.findElement(By.xpath("//option[@value='PRICE_BY_DESC']"));
        siralama.click();
        String ilkSayfaWHD= driver.getWindowHandle();

        // 8- cıkan sonuclardan ilkini sepete ekle
        driver.findElement(By.xpath("//div[@data-id='265756770']")).click();
        Set<String> ikinciSayfaninWHDegerleriSeti=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD:ikinciSayfaninWHDegerleriSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD = eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);
        WebElement sepeteEkle =driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']"));
        WebElement sepeteEklendi= driver.findElement(By.xpath("//div[@class='add-to-basket-button-text-success']"));
        sepeteEkle.click();

        sepeteEklendi.getText();

        if (sepeteEklendi.getText().equals("Sepete Eklendi")) {
            System.out.println("Sepete Ekleme Testi Basarili");
        }else System.out.println("Sepete Ekleme Testi Basarisiz");

        Thread.sleep(3000);
        driver.close();
    }
}
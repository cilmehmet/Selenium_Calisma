package youtubeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Kullanici_Girisi {

    @Test
    public void Giris() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//ytd-button-renderer[@id='sign-in-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='email']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("identifierId")).sendKeys("oziikuzii@gmail.com" + Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sanane.38" + Keys.ENTER);

        driver.findElement(By.id("//input[@id='search']")).sendKeys("Ahmet Bulutluoz" + Keys.ENTER);
        driver.findElement(By.id("//div[@id='avatar']")).click();
        driver.findElement(By.id("//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse']")).click();

        driver.close();
    }
}

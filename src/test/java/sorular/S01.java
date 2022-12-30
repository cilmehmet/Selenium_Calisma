package sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class S01 extends utilities.TestBase {

    @Test
    public void test01 () {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement kutununUstuneGitme = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(kutununUstuneGitme).perform();

        // 3- Link 1" e tiklayin
        WebElement ilkTiklama = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        ilkTiklama.click();

        // 4- Popup mesajini yazdirin
        String popUpMesaj = driver.switchTo().alert().getText();
        System.out.println(popUpMesaj);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement basiliTut = driver.findElement(By.id("click-box"));
        actions.clickAndHold().perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement kutudaCikanYazi = driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println("");
        System.out.println(kutudaCikanYazi.getText());
        utilities.ReusableMethods.bekle(3);

        // 8- “Double click me" butonunu cift tiklayin
        WebElement expectedCiftClick=driver.findElement(By.id("double-click"));
        actions.doubleClick(expectedCiftClick).perform();
        utilities.ReusableMethods.bekle(3);
    }
}

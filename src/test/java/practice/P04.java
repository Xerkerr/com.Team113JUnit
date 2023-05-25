package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void paraKarsilastir() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement searchbox =driver.findElement(By.xpath("//*[@name='q'])[1]"));
        searchbox.click();
        searchbox.sendKeys("USD TO TL" + Keys.ENTER);
        Thread.sleep(10000);
        WebElement result = driver.findElement(By.xpath("//*[@class=‘DFlfde SwHCTb’]"));
        System.out.println(result);
    }

}

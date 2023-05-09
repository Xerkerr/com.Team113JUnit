package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C03_Assertion {
    /*
    Bir Assertion failed olursa
    Assertion'in oldugu satirda exception olusur
    ve assertion satirindan sonraki kodlar CALISMAZ
 */
    WebDriver driver;

    @Test
    public void googleTest() {
        // 1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://www.google.com.tr/?hl=tr");
        String expectedurl = "google";
        String actualurl = driver.getCurrentUrl();

        Assert.assertTrue(actualurl.contains(expectedurl));
        driver.close();

    }

    @Test
    public void wisequarterTest() {
        // 2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://wisequarter.com/");
        String expectedurl = "wisequarter";
        String actualurl = driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(expectedurl));
        driver.close();

    }

    @Test
    public void amazonTest() {
        // 3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://www.amazon.com/");
        WebElement amazonelementi = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(amazonelementi.isDisplayed());
        driver.close();

    }


    public void mahserin4Atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}

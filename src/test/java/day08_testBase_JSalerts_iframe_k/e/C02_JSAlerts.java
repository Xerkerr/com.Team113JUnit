package day08_testBase_JSalerts_iframe_k.e;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClass;

public class C02_JSAlerts extends TestBaseBeforeClass {

    /*
    1. Test
- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
- 1.alert'e tiklayin
- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
- OK tusuna basip alert'i kapatin
2.Test
- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
- 2.alert'e tiklayalim
- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
3.Test
- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
- 3.alert'e tiklayalim
- Cikan prompt ekranina "Abdullah" yazdiralim
- OK tusuna basarak alert'i kapatalim
- Cikan sonuc yazisinin Abdullah icerdigini test edelim
     */


    @Test
    public void test01() {
        //    1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
//2.Test
//- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
//- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedSonucYazisi= "You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void test03() throws InterruptedException {

            //  3.Test
            //            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            Thread.sleep(3000);
            //            - 3.alert'e tiklayalim
            driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
            Thread.sleep(3000);
            //            - Cikan prompt ekranina "Abdullah" yazdiralim
            driver.switchTo().alert().sendKeys("Abdullah");
            Thread.sleep(3000);
            //            - OK tusuna basarak alert'i kapatalim
            driver.switchTo().alert().accept();
            //            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
            Thread.sleep(3000);

            String expectedIcerik= "Abdullah";
            String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();

            Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }


}

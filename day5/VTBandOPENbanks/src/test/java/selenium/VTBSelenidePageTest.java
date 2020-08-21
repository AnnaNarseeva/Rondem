package selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class VTBSelenidePageTest {

    public static VTBPage vtbPage;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().browserVersion("84.0.4147.30").setup();
        Configuration.baseUrl = "https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        vtbPage = new VTBPage();
        open(Configuration.baseUrl, VTBPage.class);
    }

    @AfterClass
    public static void close() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        clearBrowserCache();
        closeWebDriver();
    }

    @Test
    public void RURtoUSDless30000() {

        vtbPage.setRUR("");

        float rate = vtbPage.currentRate();
        vtbPage.setRUR("30000");
        sleep(2000);

        float actual = vtbPage.getUSD();
        float expected = 30000 / rate;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void USDtoRURless30000() {

        vtbPage.setUSD("20000");
        sleep(2000);
        float rate = vtbPage.currentRate();
        float actual = vtbPage.getRUR();
        float expected = 20000 * rate;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void RURtoUSDmore30000() {

        vtbPage.setRUR("");

        vtbPage.setRUR("40000000");
        sleep(2000);
        float rate = vtbPage.currentRate();

        float actual = vtbPage.getUSD();
        float expected = 40000000 / rate;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void USDtoRURmore30000() {

        vtbPage.setUSD("40000");
        sleep(2000);
        float actual = vtbPage.getRUR();
        float rate = vtbPage.currentRate();
        float expected = 40000 * rate;

        Assert.assertEquals(actual,expected);
    }
}
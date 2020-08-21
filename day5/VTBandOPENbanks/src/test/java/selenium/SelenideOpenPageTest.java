package selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideOpenPageTest {

    public static OpenPage openPage;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().browserVersion("84.0.4147.30").setup();
        Configuration.baseUrl = "https://www.open.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        openPage = new OpenPage();
        open(Configuration.baseUrl, OpenPage.class);
    }

    @AfterClass
    public static void close() {
        closeWebDriver();
    }

    @Test
    public void usdTest() {

        Double usdPurchase = openPage.usdPurchaseDouble();
        Double usdSale = openPage.usdSaleDouble();

        Assert.assertTrue(usdPurchase < usdSale);
    }

    @Test
    public void euroTest() {

        Double euroPurchase = openPage.euroPurchaseDouble();
        Double euroSale = openPage.euroSaleDouble();

        Assert.assertTrue(euroPurchase < euroSale);
    }
}
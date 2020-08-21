package selenium;

import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;

public class OpenPage {

    public Double usdSaleDouble() {
        String usdSaleS = $(By.xpath("(//*[contains(@class,'main-page-exchange__row')][contains(.,'USD')]//*[@class='main-page-exchange__rate'])[2]"))
                .getText();
        return Double.parseDouble(usdSaleS.replaceAll(",", "."));
    }

    public Double usdPurchaseDouble() {
        String usdPuschaseS = $(By.xpath("(//*[contains(@class,'main-page-exchange__row')][contains(.,'USD')]//*[@class='main-page-exchange__rate'])[1]"))
                .getText();
        return Double.parseDouble(usdPuschaseS.replaceAll(",", "."));
    }

    public Double euroSaleDouble() {
        String usdSaleS = $(By.xpath("(//*[contains(@class,'main-page-exchange__row')][contains(.,'EUR')]//*[@class='main-page-exchange__rate'])[2]"))
                .getText();
        return Double.parseDouble(usdSaleS.replaceAll(",", "."));
    }

    public Double euroPurchaseDouble() {
        String usdPuschaseS = $(By.xpath("(//*[contains(@class,'main-page-exchange__row')][contains(.,'EUR')]//*[@class='main-page-exchange__rate'])[1]"))
                .getText();
        return Double.parseDouble(usdPuschaseS.replaceAll(",", "."));
    }
}

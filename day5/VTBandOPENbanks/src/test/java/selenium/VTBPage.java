package selenium;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VTBPage {

    //узнать текущий курс рубля
    public float currentRate() {
        String rateS = $(By.cssSelector(".currency-exchange__info-ex.ng-binding.ng-scope"))
                .getText();
        String rateRoubleS = rateS.substring(0,5);
        return Float.parseFloat(rateRoubleS.replaceAll("\u00a0", "").replace(",","."));
    }

    //ввести значение в поле рублей
    public void setRUR(String setRUR) {
        $(By.id("method1")).clear();
        $(By.id("method1")).click();
        $(By.id("method1")).sendKeys(setRUR);
        $(By.cssSelector(".currency-exchange__row > div:nth-of-type(1) > .currency-exchange__label")).click();
    }

    //проверить значение в поле рублей
    public float getRUR() {
        String getRURS = $(By.id("method1")).shouldBe(Condition.visible).getValue();
        float getRUR = Float.parseFloat(getRURS.replaceAll("\u00a0", "").replace(",", "."));
        return getRUR;
    }

    //ввести значение в поле долларов
    public void setUSD(String setUSD) {
        $(By.id("method2")).clear();
        $(By.id("method2")).click();
        $(By.id("method2")).sendKeys(setUSD);
        $(By.cssSelector(".currency-exchange__row > div:nth-of-type(1) > .currency-exchange__label")).click();
    }

    //проверить значение в поле долларов
    public float getUSD() {
        String getUSDS = $(By.id("method2")).getValue();
        float getUSD = Float.parseFloat(getUSDS.replaceAll("\u00a0", "").replace(",", "."));
        return getUSD;
    }
}

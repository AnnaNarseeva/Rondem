package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Date;

public class Sample3 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");

    }

    @Test
    public void sample3() {
        String baseUrl = "http://demo.guru99.com/test/upload/";
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        uploadElement.sendKeys("/Users/Anna/Desktop/java/drivers/chromedriver");

        driver.findElement(By.id("terms")).click();

        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
        System.out.println(resultText.getText().contains(" successfully"));
        long start = (new Date()).getTime();
        System.out.println((new Date()).getTime() - start);

        driver.findElement(By.name("send")).click();
        System.out.println(resultText.getText().contains(" successfully"));
        System.out.println((new Date()).getTime() - start);

        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        System.out.println(resultText.getText().contains(" successfully"));
        System.out.println((new Date()).getTime() - start);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }

}
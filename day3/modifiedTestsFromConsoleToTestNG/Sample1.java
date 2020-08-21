package ru.technoserv.atmaven.tests.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class Sample1 {
    WebDriver safariDriver = new SafariDriver();
    WebDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");
    }

    @Test
    public void sample1() {

        String baseUrl = "http://demo.guru99.com/test/newtours/";

        safariDriver.get(baseUrl);
        chromeDriver.get(baseUrl);
        System.out.println("Safari title = " + safariDriver.getTitle());
        System.out.println("Chrome title = " + chromeDriver.getTitle());
    }

    @AfterClass
    public void quitBrowser() {
        safariDriver.quit();
        chromeDriver.quit();
    }
}



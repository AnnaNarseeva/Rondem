package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Sample4 {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void start() {

        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");
    }

    @Test
    public void sample4() {
        String baseUrl = "http://demo.guru99.com/test/yahoo.html";


        driver.get(baseUrl);
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");


        String wgetCommand = "wget -P /Users/Anna/Downloads/test --no-check-certificate " + sourceLocation;
        System.out.println(wgetCommand);
        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException |
                IOException ex) {
            System.out.println(ex.toString());
        } finally {
            driver.quit();
        }
    }


      @AfterClass
        public void quitBrowser() {
            driver.quit();
        }
    }


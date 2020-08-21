package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Sample2 {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");

    }

    @Test
    public void sample2() {

        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("passwd"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");

        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        WebElement login = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");

        driver.get(baseUrl);
        driver.findElement(By.id("email")).

                sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).

                sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).

                submit();
        System.out.println("Login Done with Submit");
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
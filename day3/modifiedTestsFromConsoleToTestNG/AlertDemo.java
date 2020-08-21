package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AlertDemo {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");
    }

    @Test
    public void alertDemo() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println(alertMessage);
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();

        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);

        alert2.accept();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }

}


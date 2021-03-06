package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Set;

public class PopupDemo {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");
    }

    @Test
    public void popupDemo() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().
                window().
                maximize();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).
                click();

        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handle = " + mainWindow);

        Set<String> allWindows = driver.getWindowHandles();

        for (
                String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                System.out.println("Child window handle = " + childWindow);
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();

                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                System.out.println(userIdElement.getText());
                System.out.println(passwordElement.getText());

                driver.close();
            }
        }
        driver.switchTo().
                window(mainWindow);

    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}


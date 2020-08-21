package ru.technoserv.atmaven.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ToolTip {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Desktop/java/drivers/chromedriver");
    }

    @Test
    public void tooltip() {
        String baseUrl = "http://demo.guru99.com/test/social-icon.html";

        driver.get(baseUrl);
        String expectedTooltip = "Github";

        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        String actualTooltip = github.getAttribute("title");

        System.out.println("Actual Title of Tool Tip = " + actualTooltip);

        if (actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case FAILED");
        }
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}


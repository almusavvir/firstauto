package TestNGDataProviders;

import java.io.File;

import TestUtils.ScreenShotty;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DataProviderDemo {
        WebDriver driver;
        String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
        @BeforeClass
        void setup() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1200");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        void testLogin() throws IOException {
            driver.get(url);
            driver.findElement(By.id("input-email")).sendKeys("pidami5907@evusd.com");
            driver.findElement(By.id("input-password")).sendKeys("qwerty123");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

            ScreenShotty.takeScreenshot(driver);

            boolean loginStatus;
            try {
                loginStatus = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
            } catch (NoSuchElementException e) {
                loginStatus = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
            }


            if(loginStatus) {
                Assert.assertTrue(true);
            } else {
                WebElement loginWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
                String loginWarningText = loginWarning.getText();
                System.out.println("--> " + loginWarningText);
                Assert.fail();
            }
        }

        @AfterClass
        void tearDown() {
            driver.quit();
        }

}

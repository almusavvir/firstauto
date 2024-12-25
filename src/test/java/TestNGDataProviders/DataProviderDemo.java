package TestNGDataProviders;

import BrowserUtils.HeadlessBrowser;
import TestUtils.ScreenShotUtil;
import org.openqa.selenium.*;
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
            driver = new HeadlessBrowser().createHeadlessChrome(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        void testLogin() throws IOException {
            driver.get(url);
            driver.findElement(By.id("input-email")).sendKeys("pidami5907@evusd.com");
            driver.findElement(By.id("input-password")).sendKeys("qwerty123");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

            boolean loginStatus = false;
            try {
                loginStatus = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
            } catch (NoSuchElementException e) {
                WebElement loginWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
                String loginWarningText = loginWarning.getText();
                System.out.println("--> " + loginWarningText);
                ScreenShotUtil.takeScreenshot(driver);
            }

            if(loginStatus) {
                Assert.assertTrue(true);

            } else {
                Assert.fail();
            }
        }

        @AfterClass
        void tearDown() {
            driver.quit();
        }

}

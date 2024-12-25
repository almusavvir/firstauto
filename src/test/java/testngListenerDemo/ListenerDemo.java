package testngListenerDemo;

import browserUtils.HeadlessBrowser;
import org.openqa.selenium.chrome.ChromeDriver;
import testUtils.ScreenShotUtil;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class ListenerDemo {
    WebDriver driver;
    String url = "https://tutorialsninja.com/demo/index.php?route=account/login";

    @BeforeClass
    void setup() {
        driver = new HeadlessBrowser().createHeadlessChrome(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    void testLogin() throws IOException {
        driver.get(url);
        driver.findElement(By.id("input-email")).sendKeys("pidami5907@evusd.com");
        driver.findElement(By.id("input-password")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }

    @Test(priority = 2, dependsOnMethods = {"testLogin"})
    void testLoginStatus() throws IOException {
        boolean loginStatus = false;
        try {
            loginStatus = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        } catch (NoSuchElementException e) {
            WebElement loginWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
            String loginWarningText = loginWarning.getText();
            System.out.println("--> " + loginWarningText);
            ScreenShotUtil.takeScreenshot(driver); // take SS of failed case
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

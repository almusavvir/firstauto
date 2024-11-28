package TestNGDemos;
/*
*  open
* test logo presence
* login
* close
 */

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver = null;

    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chromedriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Step("Test Case 001")
    @Test(priority = 1)
    void openApp() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Step("Test Case 002")
    @Test(priority = 2)
    void testLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='company-branding']")));
    }

    @Step("Test Case 003")
    @Test(priority = 3)
    void login () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='username' or @placeholder='Username']")));
        username.click();
        username.sendKeys("Admin");
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='password' or @placeholder='Password']")));
        password.click();
        password.sendKeys("admin123");
        driver.findElement(By.xpath("//div[@class='orangehrm-login-slot']//button")).click();
    }

    @Test(priority = 4)
    void logout () throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}

package TestNGDemos;
/*
*  open
* test logo presence
* login
* close
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    ChromeDriver driver = null;

    @Test(priority = 1)
    void openapp () {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void testlogo () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='company-branding']")));
    }

    @Test(priority = 3)
    void login () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='username']")));
        username.click();
        username.sendKeys("Admin");
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='password']")));
        password.click();
        password.sendKeys("admin123");
        driver.findElement(By.xpath("//div[@class='orangehrm-login-slot']//button")).click();
    }

    @Test(priority = 4)
    void logout () {
        driver.close();
    }

}

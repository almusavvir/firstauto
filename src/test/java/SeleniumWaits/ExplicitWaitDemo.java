package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // declaration
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        inputUsername.sendKeys("Admin");

        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        inputPassword.sendKeys("admin123");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='orangehrm-login-slot']//button")));
        loginButton.click();
        // driver.close();
    }
}

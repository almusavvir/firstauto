package SeleniumJourney;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();

//        if (driver.findElement(By.name("search")).isDisplayed())
//        {
//            System.out.println("Logo is displayed properly");
//        } else {
//            System.out.println("Logo is not displayed properly");
//        }
//
//        driver.findElement(By.partialLinkText("Tab")).click();
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.click(); password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement menubutton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menubutton.click();

        Thread.sleep(2000);
        driver.close();
    }
}
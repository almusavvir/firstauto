package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com");
        driver.manage().window().maximize();

        if (driver.findElement(By.name("search")).isDisplayed())
        {
            System.out.println("Logo is displayed properly");
        } else {
            System.out.println("Logo is not displayed properly");
        }

        driver.findElement(By.partialLinkText("Tab")).click();

//        driver.close();
    }
}
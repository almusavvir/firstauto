package TestNGDemos;
/*
    open app
    login
    logout
*/

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestCase {

    ChromeDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void openapp () {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test(priority = 2)
    void login () {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
    }

    @Test(priority = 3)
    void logout () throws InterruptedException {
        Thread.sleep(5000);
//        System.out.println("logged out");
        driver.close();
    }

}

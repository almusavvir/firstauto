package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipkartOTPGenerator {
    public static void main(String[] args) throws InterruptedException {
//        EdgeDriver driver = new EdgeDriver();

        for (int loop = 1; loop <=4; loop++) {

//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--window-size=1920, 1200");

            ChromeDriver driver = new ChromeDriver();

            driver.get("https://flipkart.com");
//            driver.manage().window().maximize();

            //login
            WebElement loginButton = driver.findElement(By.xpath("//a[@class='_1TOQfO']"));
            loginButton.click();

            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).click();
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("6202128791");
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            driver.quit();
        }

//        WebElement mainSearchBar = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search for Prod')]"));
//        mainSearchBar.sendKeys("Smart bulbs");
//        mainSearchBar.sendKeys(Keys.ENTER);
//
//        //Click on the Qubo 12W bulb product
//        driver.findElement(By.xpath("//a[contains(text(),'Qubo 12W B22 LED Wi-Fi BT 16 Million Colours Voice')]")).click();
//
//        //GET WINDOW HANDLES AND SWITCH TO THE NEW TAB
//        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
//
//        Thread.sleep(3000);
//
//        //CLICK ON THE ADD TO CART BUTTON
//        driver.findElement(By.xpath("//button[normalize-space()='GO TO CART']")).click();
//        //CLICK ON PLACE ORDER
//        driver.findElement(By.xpath("//span[normalize-space()='Place Order']")).click();
//        //click on the mobile / email input field
//        WebElement emailMobileInputField = driver.findElement(By.xpath("//input[@xpath='1' and @type='text']"));
//        emailMobileInputField.click();
//        emailMobileInputField.sendKeys("7765982333");


    }
}

package SeleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://croma.com");
        driver.manage().window().maximize();

        WebElement mainSearchBox = driver.findElement(By.id("searchV2"));
        mainSearchBox.click();
        mainSearchBox.sendKeys("Iphone 16");
        mainSearchBox.sendKeys(Keys.ENTER);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(2000);

        // LOCATE IPHONE 16 ULTRAMARINE 128GB VARIANT
        WebElement iphone16CardUltra = driver.findElement(By.xpath("(//a[contains(text(), '128GB, Ultramarine')])[1]"));
        iphone16CardUltra.click();

        String windowhandle = driver.getWindowHandle();
        System.out.println(windowhandle);

        System.out.println(driver.getWindowHandles());

        driver.quit();
    }
}

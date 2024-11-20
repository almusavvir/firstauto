package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CromaIphone16Finder {
    public static <Set> void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        // will go ahead and only find iphone 16 in ultra marine
        driver.get("https://croma.com");
        //System.out.println("Page ok");
        driver.manage().window().maximize();

        WebElement mainSearchBox = driver.findElement(By.id("searchV2"));
        mainSearchBox.click();
        mainSearchBox.sendKeys("Iphone 16");
        mainSearchBox.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Thread.sleep(2000);

        // LOCATE IPHONE 16 ULTRAMARINE 128GB VARIANT @msvr -> added wait until 20-11
        WebElement iphone16CardUltra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), '128GB, Ultramarine')])[1]")));
        iphone16CardUltra.click();

        //GET WINDOW HANDLES AND SWITCH TO THE NEW TAB
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

        //SCROLL UP A LITTLE TO GET THE BUY NOW BUTTON INTERACTABLE
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollBy(0, 400)");

        WebElement backPageRootDiv = driver.findElement(By.xpath("//*[@id=\"pdpdatael\"]/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(backPageRootDiv).click().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();

        //CLICK ON THE BUY NOW BUTTON @msvr -> added wait untill 20-11
        WebElement buyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(), 'Buy Now')][1])")));
        buyNowButton.click();

        // @msvr >> adding wait for checkout button to be clickable before closing window
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='side-bar']//button")));
        driver.close();

        //WebElement exchangePhoneButton = driver.findElement(By.xpath("(//button[contains(text(), 'Choose Phone for Exchange')][1])"));
        //exchangePhoneButton.click();

        //System.out.println("Elem");


    }
}

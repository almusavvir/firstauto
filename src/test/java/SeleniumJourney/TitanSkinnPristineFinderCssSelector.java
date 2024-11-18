package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class TitanSkinnPristineFinderCssSelector {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://skinn.in");

//        WebElement searchIcon = driver.findElement(By.cssSelector("img.searchicondeskhead"));
        WebElement searchIcon = driver.findElement(By.cssSelector("img.searchicondeskhead[data-name='Search']"));
        searchIcon.click();

        WebElement searchBox = driver.findElement(By.className("searchinputfielddesk"));
        searchBox.sendKeys("titan skinn pristine");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.partialLinkText("100 ML")).click();



    }
}

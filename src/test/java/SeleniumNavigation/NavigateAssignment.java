package SeleniumNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NavigateAssignment {
    public static void main(String[] args) {

        // initiate the driver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement wikiInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")));
        wikiInput.click();
        wikiInput.sendKeys("diamond");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //navigate and click through links

        for (int i = 2; i<=6; i++) {
            WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='Wikipedia1']//a)[" + i + "]")));
            searchResult.click();
        }
    }
}

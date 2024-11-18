package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DemoBlazeDotCom {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");

        Thread.sleep(5000);

        List<WebElement> countOfLinks = driver.findElements(By.tagName("a"));
        List<WebElement> countOfImages = driver.findElements(By.tagName("img"));
//        List<WebElement> countOfLinks = driver.findElements(By.tagName("a"));
        System.out.println(" Total number of links on the webpage - " + countOfLinks.size());
        System.out.println(" Total number of images on the webpage - " + countOfImages.size());

        driver.findElement(By.partialLinkText("lumia")).click();

        Thread.sleep(3000);
        driver.close();
    }
}

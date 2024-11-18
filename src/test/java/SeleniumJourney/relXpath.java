package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class relXpath {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://wpshout.com/free-jira-alternatives/");

        JavascriptExecutor jseScroll = (JavascriptExecutor) driver;
        jseScroll.executeScript("window.scrollBy(0, 2200);");

        driver.findElement(By.xpath("//*[@id=\"post-12230\"]/div[2]/div[4]/div/div/div[2]/a/span")).click();

    }
}

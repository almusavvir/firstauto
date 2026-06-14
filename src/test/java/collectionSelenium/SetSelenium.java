package collectionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SetSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();

        String parentTab = driver.getWindowHandle();
        Set<String> allTabs =  driver.getWindowHandles();
        System.out.println(allTabs);

        Iterator<String> itr = allTabs.iterator();

        while(itr.hasNext()) {
            String child = itr.next();
                if(!parentTab.equals(child)) {
                    driver.switchTo().window(child);
                    System.out.println(driver.getTitle());
                    driver.close();
                }
        }

        driver.switchTo().window(parentTab);
        System.out.println(driver.getTitle());

        Thread.sleep(2000); driver.quit();

        HashMap

    }
}

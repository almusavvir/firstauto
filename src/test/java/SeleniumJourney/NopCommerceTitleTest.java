package SeleniumJourney;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NopCommerceTitleTest {

    public static void main(String[] args) {

        //1. Launch Chrome
        ChromeDriver driver = new ChromeDriver();
        // Full screen window
        //driver.manage().window().maximize();
        //open URL
        driver.get("https://croma.com");
        //store title in variable
        String webpage_title = driver.getTitle();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Just a moment...")));

        String expectedTitle = "Croma Electronics | Online Electronics Shopping | Buy Electronics Online";

        if(webpage_title.equals(expectedTitle))
        {
            System.out.println("Test passed. Webpage title is matching as expected - " + driver.getTitle());
        } else
        {
            System.out.println("Test failed. Webpage title is incorrect. Actual title is '" + webpage_title + "'");
        }

//        driver.findElement(By.xpath("//img[@title='Show details for adidas Consortium Campus 80s Running Shoes'")[2]);
        // Close the browser


        driver.close();
    }
}

package testUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class SSUtil {
    public static void takeScreenshot(WebDriver driver) throws IOException {

        // first cast the driver object and store it into a TakesScreenShot type
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        //call the getScreenShotAs method which returns a FILE type and store it
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        //create a blank image file at a desired location ** updated with cross platform folder location
        File destFile = new File(
                System.getProperty("os.name").equals("Linux") ?
                "/home/muzz/Projects/qa/firstauto/test-output/screenshots/snap1.png" :
                "C:\\Users\\devbase\\Projects\\firstauto\\test-output\\screenshots\\snap2.png"
        );

        //copy the output from step 3 into the blank image file we created
        FileUtils.copyFile(srcFile, destFile);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        SSUtil.takeScreenshot(driver);
        driver.quit();
    }
}

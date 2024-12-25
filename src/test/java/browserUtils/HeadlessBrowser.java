package browserUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessBrowser {
    public WebDriver createHeadlessChrome(WebDriver driver) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1366,768");

        driver = new ChromeDriver(options);

        return driver;
    }

    public WebDriver createHeadlessFirefox(WebDriver driver) {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1366,768");

        driver = new FirefoxDriver(options);

        return driver;
    }
}

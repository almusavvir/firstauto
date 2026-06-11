package SeleniumAdvanced;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SeleniumCookieHandling {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.microsoft.com");
        driver.manage().window().maximize();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of cookies : " + cookies.size());
        System.out.println("Size of cookies : " + cookies.toString());

        for ( Cookie cookie: cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

    }
}

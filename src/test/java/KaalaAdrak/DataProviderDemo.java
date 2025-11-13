package KaalaAdrak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

    public class DataProviderDemo {
        WebDriver driver;
        String url = "https://tutorialsninja.com/demo/index.php?route=account/account";

        @BeforeClass
        void setup() {
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }
        @DataProvider(name = "dp")
        Object[][] loginData()
        {
            Object data[][] =
                    {
                            {"wwwbelakikuttiya@gmail.com", "Warishchaha@123"},
                            {"sonuMsvr@gmail.com", "TestAutomation@123"},
                            {"samar@gmail.com", "test@786"},
                            //{"anwarnishi701@gmail,com", "NishiAnwar@123"},
                            {"pidami5907@evusd.com", "qwerty123"},
                            {"alamshahbaz@gmailcom", "Sahabaz@123"}
                    };
            return data;
        }

        @Test( dataProvider = "dp")
        void Test_login(String email, String pwd) throws InterruptedException {

            WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
            Email.clear();
            Email.sendKeys(email);

            WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
            password.clear();
            password.sendKeys(pwd);

            Thread.sleep(3000);

            WebElement login_button = driver.findElement(By.xpath("//div[@id='content']/div[@class='row']/div[@class='col-sm-6'][2]/div[@class='well']/form/input[@class='btn btn-primary']"));
            login_button.click();

            boolean status = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).isDisplayed();
            if (status) {
                WebElement logout_button = driver.findElement(By.xpath("//aside[@id='column-right']/div[@class='list-group']/a[@class='list-group-item'][13]"));
                logout_button.click();
                Assert.assertTrue(true);
            } else {
                System.out.println("Invalid Login email or password");
            }

        }

        @AfterClass
        void tearDown() {
            driver.quit();
        }

    }

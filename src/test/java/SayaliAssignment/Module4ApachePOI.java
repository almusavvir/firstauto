package SayaliAssignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class Module4ApachePOI {
    public static void main(String[] args) throws IOException, InterruptedException {
        //setup
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //read data from Excel for id and password
        String projectDir = System.getProperty("user.dir");
        String fileLocation = "";
        if(Objects.equals(System.getProperty("os.name"), "Linux")) {
            fileLocation = projectDir + "/src/test/java/SayaliAssignment/guru99creds.xlsx";
        } else {
            fileLocation = projectDir + "\\src\\test\\java\\SayaliAssignment\\guru99creds.xlsx";
        }
        //String fileLocation = "C:\\Users\\RPA Base\\Projects\\firstauto\\src\\test\\java\\SayaliAssignment\\guru99creds.xlsx";
        String[] credentials = ExcelReader.readCredentials(fileLocation);

        //launch app and open URL
        driver.get("http://demo.guru99.com/V4/");

        //get username and password fields
        WebElement userName = driver.findElement(By.name("uid"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        //input username and password and login
        userName.click(); userName.sendKeys(credentials[0]);
        password.click(); password.sendKeys(credentials[1]);
        loginButton.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}

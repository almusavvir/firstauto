package SayaliAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Module4ApachePOI {
    public static void main(String[] args) throws IOException {
        //setup
        WebDriver driver = new ChromeDriver();

        //read data from Excel for id and password
        String[] credentials = ExcelReader.readCredentials("C:\\Users\\RPA Base\\Projects\\firstauto\\src\\test\\java\\SayaliAssignment\\guru99creds.xlsx");

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
    }
}

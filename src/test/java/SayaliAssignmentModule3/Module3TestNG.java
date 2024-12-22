package SayaliAssignmentModule3;

import SayaliAssignment.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Module3TestNG {
    WebDriver driver;
    String[] credentials = new String[2];
    String url = "https://demo.guru99.com/test/login.html";
    String fileLocation = "/home/muzz/Projects/qa/firstauto/src/test/java/SayaliAssignmentModule3/guru99creds.xlsx";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void openUrl(){
        driver.get(url);
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @DataProvider(name = "loginData")
    public String[] loginData(String fileLocation) throws IOException {
        //String[] credentials = ExcelReader.readCredentials(fileLocation);
        return ExcelReader.readCredentials(fileLocation);
    }

    @Test(dataProvider = "loginData")
    public void login() throws IOException {
        //get username and password fields
        WebElement userName = driver.findElement(By.name("uid"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        String[] credentials = loginData(fileLocation);

        userName.sendKeys(credentials[0]);
        password.sendKeys(credentials[1]);
        loginButton.click();
    }
}

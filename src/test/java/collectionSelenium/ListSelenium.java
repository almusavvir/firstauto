package collectionSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ListSelenium {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://testautomationpractice.blogspot.com/");

            driver.manage().window().maximize();

            List<WebElement> wdList = driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));

            WebElement tueCheckBox = wdList.get(2);

//        tueCheckBox.click();
//
//        for(WebElement box:wdList) {
//            box.click();
//        }

            for(int i = 0; i<wdList.size(); i++) {
                if(i%2==0 && !wdList.get(i).isSelected()) {
                    wdList.get(i).click();
                }
            }

            new Actions(driver).scrollByAmount(0, 400).perform();

            WebElement dd = driver.findElement(By.xpath("//select[@id='country']"));
            Select dropdown = new Select(dd);

            WebElement ddColor = driver.findElement(By.xpath("//select[@class='form-control' and @id='colors']"));
            Select dropdownColor = new Select(ddColor);

            WebElement ddAnimals = driver.findElement(By.xpath("//select[@id='animals']"));
            Select ddAnimalOptions = new Select(ddAnimals);


            List<WebElement> dropdownOptions = dropdown.getOptions();
            for(WebElement option: dropdownOptions) {
                System.out.println(option.getText());
            }

            dropdown.selectByVisibleText("India");
            dropdownColor.selectByVisibleText("White");
            ddAnimalOptions.selectByVisibleText("Deer");

//        List<WebElement> dropdownColorOptions = dropdownColor.getOptions();
//        for(WebElement colorOption:dropdownColorOptions){
//            if(!colorOption.isSelected() && colorOption.getText().equals("White")) {
//                colorOption.click();
//                System.out.println("Selected option " + colorOption.getText() + " from the dropdown");
//            }
//        }
        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }

        finally {
            driver.quit();
        }
    }
}

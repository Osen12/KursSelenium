import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {
    @Test
    public void executeJavaScript() throws IOException {
        //klikanie na przycisk przy pomocy Java scriptu

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            int randomNumber = (int) (Math.random()*1000);
            driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
            driver.findElement(By.id("myFile")).sendKeys("D:\\test.txt");
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String fileName = "upload" + randomNumber + ".png";
            FileUtils.copyFile(srcFile, new File("src/test/resources/" + fileName));

            //klikniecie prawym przyciskiem myszy
            Actions actions = new Actions(driver);
            //actions.contextClick().perform();

            //klikniecie myszy w konkretny element z uzyciem Webelement
            actions.contextClick(driver.findElement(By.id("myFile"))).perform();
}
}

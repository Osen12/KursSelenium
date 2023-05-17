import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActionsTest {
    @Test
    public void actionsTest() throws IOException {
        //klikanie na przycisk przy pomocy Java scriptu

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

            //klikniecie prawym przyciskiem myszy
            Actions actions = new Actions(driver);
            actions.contextClick().perform();

            //klikniecie myszy w konkretny element z uzyciem Webelement
            //actions.contextClick(driver.findElement(By.id("myFile"))).perform();\
            // podwojne klikniecie na dany element
            actions.doubleClick(driver.findElement(By.id("bottom"))).perform();
}

}

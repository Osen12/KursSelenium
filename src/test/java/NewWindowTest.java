import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;


public class NewWindowTest {

    @Test
    public void testNewWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //pobieranie nazwy aktywnego okna
        String currentWindow = driver.getWindowHandle();

        WebElement clickMe = driver.findElement(By.cssSelector("[id='newPage']"));
        clickMe.click();

        //Przelaczanie sie na inne okno niz aktywne po przejsciu przez liste wszystkich otwartych okien
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){
            //wyszukiwanie na liscie okien wartosci nie rownej currentWindow
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }

        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();
        //driver.switchTo().defaultContent();

        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium");
        //powrot do poprzedniego okna(przypisane jest do zmiennej currentWindow)
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Telefron");

    }
}

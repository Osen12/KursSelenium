package TestBrowsersPac;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestiFrame {

    @Test
    public void iFrame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        //przy pomocy argumentu webelement
        WebElement iFrame = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iFrame);


        // przelaczanie sie do okna o danym indeksie w kolejnosci od gory i numeracja od 0
        //driver.switchTo().frame(0);

        driver.findElement(By.id("fname")).sendKeys("Pateflon");

        //powrot do poprzedniego okna tego glowneg
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}

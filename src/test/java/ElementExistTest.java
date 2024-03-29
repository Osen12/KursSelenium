import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ElementExistTest {
    WebDriver driver;

    @Test
    public void elementExistTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.tagName("topSecret")));

        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.tagName("topSecre")));

        //czy element jest wyswietlany na ekranie
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        //czy przycisk jest klikalny, nie jest wyszarzony
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        //czy checkbox jest zaznaczony
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());


    }


    //jak sie znajduje to true jak nie to lapie wyjatek i wyrzuca false
    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }

    }
    // tworzy liste elementow i jesli lista jest wieksza od 0 to zwqraca true
    public boolean elementExistSecond(By locator) {
        return driver.findElements(locator).size() >0;
    }
}

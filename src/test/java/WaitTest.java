import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest {

    WebDriver driver;

    @Test
    public void waitTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ustaw timeout w sekundach dla całej klasy
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        //wait dla danego obiektu, import klasy duration
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        //Fluent wait nie ignoruje wyjatkow,trzeba samemu dodać

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        //interwal, co ile ma sprawdazac dostepnosc elementu
        wait.pollingEvery(Duration.ofSeconds(5));
        //ignorowanie wyjatku ze nie moze znalezc elementu, musi poczekac
        wait.ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        waitForElementToExist(By.cssSelector("p"));


    }



    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size()>0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;

                }
            }
        });
    }
}

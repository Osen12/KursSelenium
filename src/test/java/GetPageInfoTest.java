import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetPageInfoTest {

    @Test
    public void getInfo() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //pobranie nazwy strony
        System.out.println(driver.getTitle());
        //pobrranie adresu strony
        System.out.println(driver.getCurrentUrl());
    }
}
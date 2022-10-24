package TestBrowsersPac;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class TestBrowsers extends Browsers {

    @Test
    public void sprawdzam(){


     WebDriver driver = getDriver("chrome");
     driver.get("https://google.pl");

    }
}

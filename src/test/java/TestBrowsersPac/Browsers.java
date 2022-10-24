package TestBrowsersPac;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class  Browsers {


    public WebDriver Chrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\osene\\Downloads\\chromedriver_win32\\chromedriver.exe");

        return new ChromeDriver();
    }
    public WebDriver Firefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\osene\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();

        return firefox;
    }
    public WebDriver IE(){
        System.setProperty("webdriver.ie.driver", "C:\\Users\\osene\\Downloads\\IEDriverServer_x64_4.3.0\\IEDriverServer.exe");
        WebDriver ie = new InternetExplorerDriver();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.com");

        return ie;
    }




    public WebDriver getDriver(String browser) {
        if (browser == "chrome") {
            return Chrome();
        } else if (browser == "firefox") {
            return Firefox();
        } else if (browser == "ie") {
            return IE();
        } else {
            throw new InvalidArgumentException("Podaj poprawna przegladarke");}

    }

}
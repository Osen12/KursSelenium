import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracaDomowaDzialNaElementach {
    @Test
    public void hoverElement(){
        //najazd myszką na element
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));
        actions.moveToElement(heading).perform();
    }
    @Test
    public void copyHeader(){
        //Kopiowanie napisu ze strony
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String header = driver.findElement(By.tagName("h1")).getText();
        System.out.println(header);
    }
    @Test
    public void clickMe(){
        //klikniecie na element
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.findElement(By.id("clickOnMe")).click();
    }
    @Test
    public void enterName(){
        //wprowadzanie znakow w pole
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.findElement(By.id("fname")).sendKeys("OloManolo");
    }
    @Test
    public void clickLink(){
        // wyszukaj po a href
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //wyszukiwanie po tekscie
        //driver.findElement(By.xpath("//a[text() ='IamWeirdLink']")).click();
        //wyszukiwanie po linku
        driver.findElement(By.xpath("//a[@href ='https://www.google.com']")).click();

    }
    @Test
    public void searchTable(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //wybranie drugiego elementu w tabeli przy uzyciu selectora css
        By naglowekTabeli = By.cssSelector("th:last-child");
        String tekst1 = driver.findElement(naglowekTabeli).getText();
        System.out.println(tekst1);
        //wybranie drugiego elementu w tabeli przy uzyciu selectora css
        By wartoscTabeli = By.cssSelector("td:last-child");
        String tekst2 = driver.findElement(wartoscTabeli).getText();
        System.out.println(tekst2);
    }
    @Test
    public void selectDropdownlist() {
        //wybranie elementu z listy za pomoca selectora css po znalezieniu value
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By text = By.cssSelector("[value='saab']");
        driver.findElement(text).click();
    }
    @Test
    public void selectBox(){
        // klikniecie na checkbox
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.findElement(By.cssSelector("[type='checkbox']")).click();

    }
    @Test
    public void radioButton() {
        //wybranie elementu z listy za pomoca selectora css po znalezieniu value
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By text = By.cssSelector("[value='male']");
        driver.findElement(text).click();
    }
    @Test
    public void fillForm(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement username = driver.findElement(By.name("username"));
        username.click();
        username.clear();
        username.sendKeys("Olomanolo");
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("haslobardzodlugie");
        driver.findElement(By.cssSelector("[value='Submit']")).click();

    }

}

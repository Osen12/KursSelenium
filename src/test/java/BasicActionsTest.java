import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        //Otwarcie linku na wczt=ytanej stronie z przypisaniem do zmiennej(w tym wypadku basicPageLink )
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();

        //klikniecie w przycisk bez przypisywania tego do zmiennej
        //driver.findElement(By.id("clickOnMe")).click();

        //wprowadzanie wartosci do pola
        driver.findElement(By.id("fname")).sendKeys("OloManolo");

        //czyszczenie pola w ktorym cos jest wprowadzone
        //driver.findElement(By.name("username")).clear();
        //driver.findElement(By.name("username")).sendKeys("Admin");

        //albo gdy robimy cos na jednym elemencie wiecej niz raz to przypiujemy do zmiennej

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("Admin");
        //naciskanie entera, albo innego klawisza
        username.sendKeys(Keys.ENTER);

        //obsluga alertow
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        //obsługa drugiego alertu bez tworzenia zmiennej
        driver.switchTo().alert().accept();


        //pobieranie tekstu z pola input
        //System.out.println(username.getAttribute("value"));

        //checkboxy
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        //wybieranie opcji z Select
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        //cars.selectByIndex(2);
        //cars.selectByVisibleText("Saab");
        cars.selectByValue("mercedes");

        //Pobieranie opcji z Selecta
        // trzeba utworzyc liste z webelementem i utworzyc zmienna w celu wygenerowania listy
        List<WebElement> optionsCars = cars.getOptions();
        // pobieranie tekstu z webelementu i wypisanie na ekranie. Dla elementu option w optionCars wypisz kazdy element
        for (WebElement option : optionsCars) {
            System.out.println(option.getText());
        }

        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selectCar));
        System.out.println(selectCheck.checkOption("Jeep", selectCar));

        //Pobieranie tekstu ukrytego elementu przy pomocy getAtribute "textContent"
        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By attribute text content: " + para.getAttribute("textContent"));






    }
}

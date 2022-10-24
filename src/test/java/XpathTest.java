import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // po ID
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        driver.findElement(firstName);

        // po klasie
        By xpathClass= By.xpath("//p[@class='topSecret']");
        driver.findElement(xpathClass);

        // po Tagu
        By xpathInputLocator = By.xpath("//input");
        driver.findElement(xpathInputLocator).sendKeys("Pierwszy1");
        List<WebElement> inputs = driver.findElements(xpathInputLocator);
        System.out.println(inputs.size());

        //po tekscie
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        //po czesci tekstu
        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement schoolPartial = driver.findElement(partialLink);


        //xpath

        //wyszukiwanie po calej sciezce
        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        //wyszukiwanie po ostatnim tagu
        By shortName = By.xpath("//ul");
        driver.findElement(shortName);

        //znalezienie wsszytskich elementow
        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        //selektor z indeksem, wyszukiwanie konkretnego elementu
        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        //ostatni element w danym tagu
        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        //element z atrybutem
        By elementWithAtribute =  By.xpath("//*[@name]");
        driver.findElements(elementWithAtribute);

        //wartosc atrybutu jest rowna(co se tam wyszukasz)
        By attributeEqual = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(attributeEqual);

        //Wartosc atrybutu nie jest rowna
        By attributeNotEqual = By.xpath("//button[@id!='ClickOnMe']");
        driver.findElement(attributeNotEqual);

        //atrybut w tym przypadku @name zawiera fraze np ame
        By attribueContains = By.xpath("//*[contains(@name,'ame')]");
        driver.findElement(attribueContains);

        //rozpoczyna sie od - podajemy atrybut w nawiasie okraglym i szukana fraze po przecinku
        By startsWith = By.xpath("//*[starts-with(@name,'user')]");
        driver.findElement(startsWith);

        //konczy sie na
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']");
        driver.findElement(endsWith);

        //dzieci tagu div o znaczniku ul
         By child = By.xpath("//div/child::ul");
         driver.findElement(child);

         // wszyscy zstepni czyli wszystkie elementy w tagu div o znaczniku ul
        By desc = By.xpath("//div/descendant::ul");
        driver.findElement(desc);

        //Wybor bezposredniego rodzica(nad) taagiem div. Jak katalog w windowsie do gory
        By parent = By.xpath("//div/..");
        driver.findElement(parent);

        //Wszystkie tagi nadrzedne nad tagiem div
        By asc = By.xpath("//div/ancestor::*");
        driver.findElement(asc);

        //Wszystkie tagi wystepujace po tagu img
        By following = By.xpath("//img/following::*");

        //Wszystkie tagi na tym samym poziomie wystepujace po img
        By followingSib = By.xpath("//img/following-sibling::*");
        driver.findElement(followingSib);

        //Wszystkie elementy przed tagiem img
        By prec = By.xpath("//img/preceding::*");
        driver.findElement(prec);

        //Wszystkie elementy przed tagiem img ale znajdujace sie na tym samym poziomie
        By precSib = By.xpath("//img/preceding-siblings::*");

        //Szukanie dwoch roznych tagow jednoczesnie
        By twoselectors = By.xpath("//a | //input");
        driver.findElement(twoselectors);

        //oba warunki przy wyszukiwaniu musza byc spelnione(3 warunki wyszukuje input o atrybutach name i id i wlasciwosciach atrybutow fname)
        By andOperator = By.xpath("//input[@name='fname' and @id='fname']");
        driver.findElement(andOperator);

        //jeden warunek wyszukiwaniu musi byc spelniony(3 warunki wyszukuje input o atrybutach name i id i wlasciwosciach atrybutow fname)
        By orOperator = By.xpath("//input[@name='fname' or @id='fnam']");
        driver.findElement(orOperator);
















    }
}

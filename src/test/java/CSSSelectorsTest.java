import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CSSSelectorsTest {

    @Test
    public void findElements(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // po ID
        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        //fname
        By firstName = By.name("fname");
        driver.findElement(firstName);

        // po klasie
        By cssClass= By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        // po Tagu
        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Pierwszy1");

        // po nazwie "name"
        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        // zwraca wszystkie tagi na stronie
        By all = By.cssSelector("*");
        driver.findElement(all);

        // zwraca w tym przypadku wszystkie child
        By ulInsideDiv = By.cssSelector("div ul");
        By trInsideTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");

        driver.findElement(ulInsideDiv);
        driver.findElement(trInsideTable);
        driver.findElement(trInBody);

        //znalezienie tylko first child

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody >tr");

        driver.findElement(firstChildTrInTbody);
        driver.findElement(firstChildUlInDiv);

        //  Pierwszy element po tagu referencyjnym. Są na tym samym poziomie(po prostu nastepny tag)

        By firstFormAfterLabel = By.cssSelector("label + form");
        driver.findElement(firstFormAfterLabel);

        // Wszystkie elementy po tagu refererncyjnym.
        By allFormAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(allFormAfterLabel);

        //zaweza wyniki do konkretnego tagu
        By attrTag = By.cssSelector("input[name='fname']");
        driver.findElement(attrTag);

        // atrybut zawiera dany ciag znakow
        By attrContains = By.cssSelector("[name*='name']");
        driver.findElement(attrContains);

        //atrybut rozpoczyna sie od ciagu znakow
        By attrStarts = By.cssSelector("[name^='f']");
        driver.findElement(attrStarts);

        //atrybut konczy sie na ciagu znakow
        By attrEnds = By.cssSelector("[name$='ame']");
        driver.findElement(attrEnds);

        //Pierwszy element nadrzednego tagu
        By firstChild = By.cssSelector("li:first-child");
        driver.findElement(firstChild);

        //Ostatni element nadrzednego tagu
        By lastChild = By.cssSelector("li:last-child");
        driver.findElement(lastChild);

        //Wybrany element nadrzednego tagu
        By anyChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(anyChild);












    }
}

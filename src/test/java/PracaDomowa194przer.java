import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PracaDomowa194przer {

    String car = "Volvo";


    public void Volvo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByVisibleText("Volvo");

        WebElement optionsCars = cars.getFirstSelectedOption();
        String selectedCar = optionsCars.getText();
        System.out.println(selectedCar);


        if (car.equals(selectedCar)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }

    public void Saab() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByVisibleText("Saab");

        WebElement optionsCars = cars.getFirstSelectedOption();
        String selectedCar = optionsCars.getText();
        System.out.println(selectedCar);


        if (car.equals(selectedCar)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

        public void Mercedes () {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

            WebElement selectCar = driver.findElement(By.cssSelector("select"));
            Select cars = new Select(selectCar);
            cars.selectByVisibleText("Mercedes");

            WebElement optionsCars = cars.getFirstSelectedOption();
            String selectedCar = optionsCars.getText();
            System.out.println(selectedCar);


            if (car.equals(selectedCar)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }

        public void Audi () {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

            WebElement selectCar = driver.findElement(By.cssSelector("select"));
            Select cars = new Select(selectCar);
            cars.selectByVisibleText("Audi");

            WebElement optionsCars = cars.getFirstSelectedOption();
            String selectedCar = optionsCars.getText();
            System.out.println(selectedCar);


            if (car.equals(selectedCar)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }

        public void selectOption (String car){
            if (car == "Volvo") {
                Volvo();
            } else if (car == "Saab") {
                Saab();
            } else if (car == "Mercedes") {
                Mercedes();
            } else if (car == "Audi") {
                Audi();
            } else {
                System.out.println("gowno");
            }
        }

        @Test
        public void carList() {

            selectOption(car);

        }
    }

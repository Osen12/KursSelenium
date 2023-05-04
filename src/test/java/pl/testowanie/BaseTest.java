package pl.testowanie;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I'm running before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I'm running after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

}

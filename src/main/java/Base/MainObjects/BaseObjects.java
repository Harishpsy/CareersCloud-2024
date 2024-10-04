package Base.MainObjects;

import Base.AllCourse.BaseAllCourse;
import Base.Doubt.BaseDoubts;
import Base.Home.BaseHomePage;
import Base.Menu.BaseMenu;
import Base.MyCourse.BaseMyCourse;
import LoginPage.Loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * The BaseObjects class sets up the WebDriver for Chrome browser in incognito mode
 * and runs a set of test modules to validate different functionalities of a web application.
 */
public class BaseObjects {

    /**
     * The WebDriver instance that is used across multiple test modules for interacting
     * with the web browser. This driver is set up in the {@link #setup()} method,
     * where it is initialized with specific configurations for Chrome browser in
     * incognito mode. The driver is then utilized in various test methods such as
     * {@link #loginTest()}, {@link #homeModuleTest()}, {@link #menuModuleTest()},
     * {@link #myCourseModuleTest()}, {@link #allCoursesModuleTest()}, and {@link #doubtsModuleTest()}
     * for performing actions on the web application.
     */
    public static WebDriver driver;

    /**
     * Sets up the Chrome WebDriver with incognito mode before any tests run.
     * This method initializes the ChromeOptions, adds incognito argument,
     * and creates a new instance of ChromeDriver with the specified options.
     *
     * Note: If a previous driver instance exists, a NullPointerException might be thrown.
     */
    @BeforeClass
    public void setup() {
        // Set up ChromeDriver with incognito mode
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "--incognito" );
        driver = new ChromeDriver ( options ); // If a driver was there,Null point exception will throw
    }

    /**
     * This method performs a login test using the Loginpage class.
     * It initiates the login process by creating an instance of the Loginpage class
     * and calls the login method from this instance.
     *
     * @throws InterruptedException if the thread is interrupted during sleep
     */
    @Test(priority = 1, enabled = true)
    public void loginTest() throws InterruptedException {

        // Login Module
        Loginpage loginPage = new Loginpage ( driver );
        loginPage.login ();
    }

    /**
     * Tests the HomeModule functionality by creating an instance of BaseHomePage
     * and invoking its HomeModule method.
     *
     * @throws InterruptedException if the thread is interrupted during the sleep intervals.
     */
    @Test(priority = 2, enabled =false)
    public void homeModuleTest() throws InterruptedException {
        // Creating The Base For Home Page Module
        BaseHomePage home = new BaseHomePage ( driver );
        home.HomeModule ();
    }

    /**
     * Executes the tests for the menu module on the home page.
     *
     * @throws InterruptedException if the thread is interrupted during sleep or wait operations
     */
    @Test(priority = 3, enabled = true)
    public void menuModuleTest() throws InterruptedException {
        // Creating The Base For Home Page > Menu Module
        BaseMenu menu = new BaseMenu ( driver );
        menu.menuModule ();
    }

    /**
     * Executes the test for the "My Course" module within the application.
     *
     * This method initializes the base object for the My Course module and
     * triggers the main functionality defined in the module.
     * It is currently disabled and set to run with a priority of 4.
     *
     * @throws InterruptedException if the thread is interrupted.
     * @throws AWTException if an abstract window toolkit exception occurs.
     */
    @Test(priority = 4, enabled = false)
    public void myCourseModuleTest() throws InterruptedException, AWTException {

        // Creating The Base For My Course Module
        BaseMyCourse myCourse = new BaseMyCourse ( driver );
        myCourse.myCourseModule ();
    }

    /**
     * This test method verifies the functionality of the "All Courses" module in the application.
     * It creates an instance of the BaseAllCourse class and invokes the allCourseModule method.
     *
     * @throws InterruptedException if the thread is interrupted during the test execution
     * @throws AWTException if there is an issue with the abstract window toolkit (e.g., for handling GUI automation)
     */
    @Test(priority = 5, enabled = false)
    public void allCoursesModuleTest() throws InterruptedException, AWTException {

        // Creating The Base For All Course Module
        BaseAllCourse allCourse = new BaseAllCourse ( driver );
        allCourse.allCourseModule ();
    }

    /**
     * Test method for validating the functionality of the Doubts Module.
     * This method is currently disabled and will not be executed during test runs.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     * @throws AWTException if a problem occurs while using the AWT Robot class
     */
    @Test(priority = 6, enabled = false)
    public void doubtsModuleTest() throws InterruptedException, AWTException {
        // Creating The Base For Doubts Module
        BaseDoubts doubts = new BaseDoubts ( driver );
        doubts.doubtsModule ();
    }

}



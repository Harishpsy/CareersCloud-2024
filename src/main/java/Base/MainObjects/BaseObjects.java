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

public class BaseObjects {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set up ChromeDriver with incognito mode
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "--incognito" );
        driver = new ChromeDriver ( options ); // If a driver was there,Null point exception will throw
    }

    @Test(priority = 1, enabled = true)
    public void loginTest() throws InterruptedException {

        // Login Module
        Loginpage loginPage = new Loginpage ( driver );
        loginPage.login ();
    }

    @Test(priority = 2, enabled = false)
    public void homeModuleTest() throws InterruptedException {
        // Creating The Base For Home Page Module
        BaseHomePage home = new BaseHomePage ( driver );
        home.HomeModule ();
    }

    @Test(priority = 3, enabled = true)
    public void menuModuleTest() throws InterruptedException {
        // Creating The Base For Home Page > Menu Module
        BaseMenu menu = new BaseMenu ( driver );
        menu.menuModule ();
    }

    @Test(priority = 4, enabled = false)
    public void myCourseModuleTest() throws InterruptedException, AWTException {

        // Creating The Base For My Course Module
        BaseMyCourse myCourse = new BaseMyCourse ( driver );
        myCourse.myCourseModule ();
    }

    @Test(priority = 5, enabled = false)
    public void allCoursesModuleTest() throws InterruptedException, AWTException {

        // Creating The Base For All Course Module
        BaseAllCourse allCourse = new BaseAllCourse ( driver );
        allCourse.allCourseModule ();
    }

    @Test(priority = 6, enabled = false)
    public void doubtsModuleTest() throws InterruptedException, AWTException {
        // Creating The Base For Doubts Module
        BaseDoubts doubts = new BaseDoubts ( driver );
        doubts.doubtsModule ();
    }

}



package Base;

import AllCourse.allCourseModule;
import MainPages.Loginpage;
import MyCourse.myCourseModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;

public class baseObjects {
    public static void main(String[] args) throws InterruptedException, AWTException {

        /* Calling The Chrome Browser */
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "--incognito" );
        WebDriver driver = new ChromeDriver ( options );
        //WebDriver driver = new FirefoxDriver ();

        // Login Page
        Loginpage loginPage = new Loginpage ( driver );
        loginPage.login ();

//        // Home Page
//        HomePage clickingHomePage = new HomePage ( driver );
//        clickingHomePage.clickingHomePage ();
//
//        // Home Page > ArticleandCourse
//        HomePage articleandcourse = new HomePage ( driver );
//        articleandcourse.ArticleandCourse ();
//
//        // Verifying Duplicate In The Home Page
//        HomePage verifyingDuplicateInHomePage = new HomePage ( driver );
//        verifyingDuplicateInHomePage.verifyingDuplicate ();
//
//        // Footer Section
//        HomePage footer = new HomePage ( driver );
//        footer.footerSection ();

//        // Creating An Base Object For The Menu
//         menuBase base = new menuBase ( driver );
//         base.menu ();

        // My Course
        myCourseModule Mycourse = new myCourseModule ( driver );
        Mycourse.myCourseClicking ();

        // All Course Tab In Home Feeds
        allCourseModule allcourse = new allCourseModule ( driver );
        allcourse.allCourse ();

//        //Doubts Section
//        Doubts doubts = new Doubts ( driver );
//        doubts.doubts ();
//
//        // All Doubts
//        AllDoubts allDoubts = new AllDoubts ( driver );
//        allDoubts.allDoubts ();
//
//        //My Doubts
//        Mydoubts myDoubts = new Mydoubts ( driver );
//        myDoubts.myDoubts ();
//
//        //My Answered
//        MyAnswered answered = new MyAnswered ( driver );
//        answered.myAnswered ();
//
//        // My Followed
//        Myfollowed myFollowed = new Myfollowed ( driver );
//        myFollowed.myFollow ();
//
//        // My Points in the Doubts Page
//        Mypoints myPointsInDoubts = new Mypoints ( driver );
//        myPointsInDoubts.myPoints ();


    }
}

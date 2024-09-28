package Base;

import MainPages.Loginpage;
import MyCourse.myCourseModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class baseObjects {
    public static void main(String[] args) throws InterruptedException, AWTException {

        // Web Driver
        WebDriver driver = new ChromeDriver ();
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

//        // All Course Tab In Home Feeds
//        allCourseTabAndFeed allcourse = new allCourseTabAndFeed ( driver );
//        allcourse.allCourse ();

//        //Clicking The Inside The All Course List Page
//        allCourseBase courseclick = new allCourseBase ( driver );
//        courseclick.courseClicking ();





    }
}

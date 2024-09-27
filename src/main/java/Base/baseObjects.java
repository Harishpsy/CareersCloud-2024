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
//
//        // My Notes
//        Menu_MyNotes myNotes = new Menu_MyNotes ( driver );
//        myNotes.MyNotes ();
//
//        // My Notes > Article
//        Menu_MyNotes articles = new Menu_MyNotes ( driver );
//        articles.artilce ();
//
//        // My Notes > Videos
//        Menu_MyNotes videos = new Menu_MyNotes ( driver );
//        videos.videos ();
//
//        // My Notes > Start Quiz
//        Menu_MyNotes quiz = new Menu_MyNotes ( driver );
//        quiz.Startquiz ();
//
//        // My Notes > Resume Quiz
//        Menu_MyNotes resume = new Menu_MyNotes ( driver );
//        resume.resumequiz ();
//
//        // My Notes > Quiz Solution
//        Menu_MyNotes solutionclick = new Menu_MyNotes ( driver );
//        solutionclick.solution ();
//
//        // My Questions
//        Menu_MyQuestions myQuestions = new Menu_MyQuestions ( driver );
//        myQuestions.Myquestion ();
//
//        // My Ebooks
//        Menu_MyEbooks myEbooks = new Menu_MyEbooks ( driver );
//        myEbooks.MyEbooks ();
//
//        // My Coins
//        Menu_MyCoins myCoins = new Menu_MyCoins ( driver );
//        myCoins.MyCoins ();
//
//        // My Points
//        Menu_MyPoints myPoints = new Menu_MyPoints ( driver );
//        myPoints.MyPoints ();
//
//        // Invite Friends
//        Menu_InviteFriends inviteFriends = new Menu_InviteFriends ( driver );
//        inviteFriends.InviteFriends ();
//
//        // Rate App
//        Menu_RateApp rateApp = new Menu_RateApp ( driver );
//        rateApp.RateApp ();
//
//        // My Purchase
//        Menu_MyPurchase myPurchase = new Menu_MyPurchase ( driver );
//        myPurchase.MyPurchase ();
//
//        // Hire Us
//        Menu_Hireus hireUs = new Menu_Hireus ( driver );
//        hireUs.Hireus ();
//
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

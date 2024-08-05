package Base;

import MainPages.Loginpage;
import MyCourse.CourseArticle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class baseConstructor {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver ();

        // Login
        Loginpage loginPage = new Loginpage (driver);
        loginPage.login ();

        // Home Page
        // HomePage clickingHomePage = new HomePage(driver);
        // clickingHomePage.clickingHomePage();

        // My Notes
        // Menu_MyNotes myNotes = new Menu_MyNotes(driver);
        // myNotes.MyNotes();

        // My Questions
        // Menu_MyQuestions myQuestions = new Menu_MyQuestions(driver);
        // myQuestions.Myquestion();

        // My Ebooks
        // Menu_MyEbooks myEbooks = new Menu_MyEbooks(driver);
        // myEbooks.MyEbooks();

        // My Coins
        // Menu_MyCoins myCoins = new Menu_MyCoins(driver);
        // myCoins.MyCoins();

        // My Points
        // Menu_MyPoints myPoints = new Menu_MyPoints(driver);
        // myPoints.MyPoints();

        // Invite Friends
        // Menu_InviteFriends inviteFriends = new Menu_InviteFriends(driver);
        // inviteFriends.InviteFriends();

        // Rate App
        // Menu_RateApp rateApp = new Menu_RateApp(driver);
        // rateApp.RateApp();

        // My Purchase
        // Menu_MyPurchase myPurchase = new Menu_MyPurchase(driver);
        // myPurchase.MyPurchase();

        // Hire Us
        // Menu_Hireus hireUs = new Menu_Hireus(driver);
        // hireUs.Hireus();

        // My Course Filters
        // MyCourse_Filters filter = new MyCourse_Filters(driver);
        // filter.Filter();

        // Course Path
        // CoursePath path = new CoursePath(driver);
        // path.Path();

        // Course Quizzes
        // CourseQuizzes quizzes = new CourseQuizzes(driver);
        // quizzes.Quizzes();

        // Course Ebooks
        // CourseEbooks ebooks = new CourseEbooks(driver);
        // ebooks.Ebooks();

//    // Course Article
        CourseArticle article = new CourseArticle (driver);
        article.Article ();

        // Course Videos
        // CourseVideos videos = new CourseVideos(driver);
        // videos.videos();

        // Course Details
        // CourseDetails details = new CourseDetails(driver);
        // details.Details();

        // Course Doubts
        // CourseDoubts doubt = new CourseDoubts(driver);
        // doubt.Doubts();

        // Doubts Section
//     Doubts doubt = new Doubts(driver);
//     doubt.doubts();

        // All Doubts
        // AllDoubts allDoubts = new AllDoubts(driver);
        // allDoubts.allDoubts();

        //  My Doubts
//     Mydoubts myDoubts = new Mydoubts(driver);
//     myDoubts.myDoubts();

        // My Answered
        // MyAnswered answered = new MyAnswered(driver);
        // answered.myAnswered();

        // My Followed
        // Myfollowed myFollowed = new Myfollowed(driver);
        // myFollowed.myFollow();

        // My Points in the Doubts Page
        // Mypoints myPointsInDoubts = new Mypoints(driver);
        // myPointsInDoubts.myPoints();


    }

}

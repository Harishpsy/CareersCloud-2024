package Base;


import Doubts.*;
import MainPages.HomePage;
import MainPages.Loginpage;
import Menu.*;
import MyCourse.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class baseConstructor {
    public static void main(String[] args) throws InterruptedException, AWTException {

     // Browser
     WebDriver driver = new ChromeDriver ();
     //WebDriver driver = new FirefoxDriver ();

     // Login Page
     Loginpage loginPage = new Loginpage ( driver );
     loginPage.login ();

     // Home Page
     HomePage clickingHomePage = new HomePage ( driver );
     clickingHomePage.clickingHomePage ();

     // My Notes
     Menu_MyNotes myNotes = new Menu_MyNotes ( driver );
     myNotes.MyNotes ();

     // My Notes > Article
     Menu_MyNotes articles = new Menu_MyNotes ( driver );
     articles.artilce ();

     // My Notes > Videos
     Menu_MyNotes videos = new Menu_MyNotes ( driver );
     videos.videos ();

     // My Notes > Start Quiz
     Menu_MyNotes quiz = new Menu_MyNotes ( driver );
     quiz.Startquiz ();

     // My Notes > Resume Quiz
     Menu_MyNotes resume = new Menu_MyNotes ( driver );
     resume.resumequiz ();

     // My Notes > Quiz Solution
     Menu_MyNotes solutionclick = new Menu_MyNotes ( driver );
     solutionclick.solution ();

     // My Questions
     Menu_MyQuestions myQuestions = new Menu_MyQuestions ( driver );
     myQuestions.Myquestion ();

     // My Ebooks
     Menu_MyEbooks myEbooks = new Menu_MyEbooks ( driver );
     myEbooks.MyEbooks ();

     // My Coins
     Menu_MyCoins myCoins = new Menu_MyCoins ( driver );
     myCoins.MyCoins ();

     // My Points
     Menu_MyPoints myPoints = new Menu_MyPoints ( driver );
     myPoints.MyPoints ();

     // Invite Friends
     Menu_InviteFriends inviteFriends = new Menu_InviteFriends ( driver );
     inviteFriends.InviteFriends ();

     // Rate App
     Menu_RateApp rateApp = new Menu_RateApp ( driver );
     rateApp.RateApp ();

     // My Purchase
     Menu_MyPurchase myPurchase = new Menu_MyPurchase ( driver );
     myPurchase.MyPurchase ();

     // Hire Us
     Menu_Hireus hireUs = new Menu_Hireus ( driver );
     hireUs.Hireus ();

     // My Course
     myCourse Mycourse = new myCourse ( driver );
     Mycourse.myCourseClicking ();

     // My Course > Performing Action In The My Course
     myCourse actionInMyCourse = new myCourse ( driver );
     actionInMyCourse.performingActionInMyCourse ();

     //My Course Filters
     // MyCourse_Filters filter = new MyCourse_Filters(driver);
     // filter.Filter();

     // Course Path
     // CoursePath path = new CoursePath(driver);
     // path.Path();

     //Course Article
     CourseArticle article = new CourseArticle ( driver );
     article.Article ();

     //Course Videos
     CourseVideos video = new CourseVideos ( driver );
     video.videos ();

//         Course Quizzes
//         CourseQuizzes quizzes = new CourseQuizzes (driver);
//         quizzes.Quizzes ();

//        Course Quiz > Unattempted
//        CourseQuizzesUnattempted unattempt = new CourseQuizzesUnattempted ( driver );
//        unattempt.unAttempted ();

//        Course Quiz > Attempted
//        CourseQuizAttempted attempted = new CourseQuizAttempted ( driver );
//        attempted.attemptedTab ();

     //Course Ebooks
     CourseEbooks ebooks = new CourseEbooks ( driver );
     ebooks.Ebooks ();

     //Course Doubts
     CourseDoubts doubt = new CourseDoubts ( driver );
     doubt.Doubts ();

     // Course Doubt > My Doubt
     CourseDoubts myDoubt = new CourseDoubts ( driver );
     myDoubt.MyDoubt ();

     // Course Doubt > My Answered
     CourseDoubts myAnswer = new CourseDoubts ( driver );
     myAnswer.MyAnswered ();

     // Course Doubt > Followed
     CourseDoubts followed = new CourseDoubts ( driver );
     followed.Followed ();

     //Course Details
     CourseDetails details = new CourseDetails ( driver );
     details.Details ();

     //Doubts Section
     Doubts doubts = new Doubts ( driver );
     doubts.doubts ();

     //All Doubts
     AllDoubts allDoubts = new AllDoubts ( driver );
     allDoubts.allDoubts ();

     //My Doubts
     Mydoubts myDoubts = new Mydoubts ( driver );
     myDoubts.myDoubts ();

     //My Answered
     MyAnswered answered = new MyAnswered ( driver );
     answered.myAnswered ();

     //My Followed
     Myfollowed myFollowed = new Myfollowed ( driver );
     myFollowed.myFollow ();

     //My Points in the Doubts Page
     Mypoints myPointsInDoubts = new Mypoints ( driver );
     myPointsInDoubts.myPoints ();
    }
}

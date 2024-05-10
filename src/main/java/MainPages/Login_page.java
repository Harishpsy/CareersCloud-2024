package MainPages;

import MyCourse.CourseDoubts;
import PageObjectModule.Loginpageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Loginpageobject.*;


public class Login_page {
    public static WebDriver driver = new ChromeDriver ();


    public static void main(String[] args) throws InterruptedException, AWTException {
        // Setup for browser launch

        // Entering the url

        driver.get ("https://careerscloud.in/");
        driver.manage ().window ().maximize ();

        // Waiting for element visible

        Thread.sleep (5000);

        PageFactory.initElements (driver, Loginpageobject.class);

        // Clicking the login button

        LoginButton.click ();
        Thread.sleep (3000);

        //Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        //Entering the mailId

        Entering_mailID.sendKeys ("harishpsy12@gmail.com");

        //Clicking the next button

        Nextbutton.click ();

        //Entering Password

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40)); // 40 seconds timeout
        // WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//*[@name='Passwd']")));
        wait.until (ExpectedConditions.visibilityOf (passwordField));
        passwordField.sendKeys ("Harish@1998");

        //Clicking the next button

        Thread.sleep (2000);
        Nextbutton.click ();

        //Clicking the Continue_button

        Thread.sleep (5000);
        Continuebutton.click ();

        //Changing the focus to the parent window
        driver.switchTo ().window (parent);

//        // Calling Home Page
//
//        HomePage clickingHomePage = new HomePage (driver);
//        clickingHomePage.clickingHomePage ();
//
//        //CALLING MYNOTES
//
//        Menu_MyNotes Mynotes = new Menu_MyNotes (driver);
//        Mynotes.MyNotes ();
//
//        //CALLING MY QUESTIONS
//
//        Menu_MyQuestions MyQuestions = new Menu_MyQuestions (driver);
//        MyQuestions.Myquestion ();
//
//        // CALLING MY EBOOKS
//
//        Menu_MyEbooks MyEbooks = new Menu_MyEbooks (driver);
//        MyEbooks.MyEbooks ();
//
//        // CALLING MY COINS
//
//        Menu_MyCoins MyCoins = new Menu_MyCoins (driver);
//        MyCoins.MyCoins ();
//
//        // CALLING MY POINTS
//
//        Menu_MyPoints MyPoints = new Menu_MyPoints (driver);
//        MyPoints.MyPoints ();
//
//        //Calling InviteFriends
//
//        Menu_InviteFriends InviteFriends = new Menu_InviteFriends (driver);
//        InviteFriends.InviteFriends ();
//
//        // Calling Rate App
//
//        Menu_RateApp RateApp = new Menu_RateApp (driver);
//        RateApp.RateApp ();
//
//        // Calling The My Purchase
//
//        Menu_MyPurchase MyPurchase = new Menu_MyPurchase (driver);
//        MyPurchase.MyPurchase ();
//
//        // Calling The Hireus
//
//        Menu_Hireus Hireus = new Menu_Hireus (driver);
//        Hireus.Hireus ();

//        // Calling My Course Filters
//
//        MyCourse_Filters Filter = new MyCourse_Filters (driver);
//        Filter.Filter ();

//        //Calling CoursePath
//
//        CoursePath path = new CoursePath (driver);
//        path.Path ();

//        // Calling Course Quizzes
//
//        CourseQuizzes Quizzes = new CourseQuizzes (driver);
//        Quizzes.Quizzes ();

//        // Calling Course Ebooks
//
//        CourseEbooks Ebooks = new CourseEbooks (driver);
//        Ebooks.Ebooks ();

        // Calling Course Article

//        CourseArticle Article = new CourseArticle (driver);
//        Article.Article ();

//        // Calling Videos
//        CourseVideos videos = new CourseVideos (driver);
//        videos.videos ();


//        // Calling Course Details
//
//        CourseDetails Details = new CourseDetails (driver);
//        Details.Details ();

        // Calling Doubts

        CourseDoubts Doubt = new CourseDoubts (driver);
        Doubt.Doubts ();


    }
}

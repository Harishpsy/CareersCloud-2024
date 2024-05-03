package MainPages;

import Menu.*;
import MyCourse.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


public class Login_page {
    static WebDriver driver = new ChromeDriver ();

    public static void main(String[] args) throws InterruptedException {
        // Setup for browser launch

        // Entering the url

        driver.get ("https://careerscloud.in/");
        driver.manage ().window ().maximize ();

        // Waiting for element visible

        Thread.sleep (5000);

        // Clicking the login button

        WebElement LoginButton = driver.findElement (xpath ("//span[text()='Log in with Google']"));
        LoginButton.click ();
        Thread.sleep (3000);

        //Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        //Entering the mailId

        WebElement Entering_mailId = driver.findElement (id ("identifierId"));
        Entering_mailId.sendKeys ("harishpsy12@gmail.com");

        //Clicking the next button

        WebElement Nextbutton = driver.findElement (xpath ("//span[text()='Next']"));
        Nextbutton.click ();

        //Entering Password

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40)); // 40 seconds timeout
        WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//*[@name='Passwd']")));
        wait.until (ExpectedConditions.visibilityOf (passwordField));
        passwordField.sendKeys ("Harish@1998");

        //Clicking the next button

        Thread.sleep (2000);
        WebElement Next_button = driver.findElement (xpath ("//span[text()='Next']"));
        Next_button.click ();

        //Clicking the Continue_button

        Thread.sleep (5000);
        WebElement Continuebutton = driver.findElement (xpath ("//span[text()='Continue']"));
        Continuebutton.click ();

        //Changing the focus to the parent window
        driver.switchTo ().window (parent);

        // Calling Home Page

        HomePage clickingHomePage = new HomePage (driver);
        clickingHomePage.clickingHomePage ();

        // CALLING MY NOTES

        Menu_MyNotes Mynotes = new Menu_MyNotes (driver);
        Mynotes.MyNotes ();

        //CALLING MY QUESTIONS

        Menu_MyQuestions MyQuestions = new Menu_MyQuestions (driver);
        MyQuestions.Myquestion ();

//      CALLING MY EBOOKS

        Menu_MyEbooks MyEbooks = new Menu_MyEbooks (driver);
        MyEbooks.MyEbooks ();

        // CALLING MY COINS

        Menu_MyCoins MyCoins = new Menu_MyCoins (driver);
        MyCoins.MyCoins ();

        // CALLING MY POINTS

        Menu_MyPoints MyPoints = new Menu_MyPoints (driver);
        MyPoints.MyPoints ();

        //Calling InviteFriends

        Menu_InviteFriends InviteFriends = new Menu_InviteFriends (driver);
        InviteFriends.InviteFriends ();

        // Calling Rate App

        Menu_RateApp RateApp = new Menu_RateApp (driver);
        RateApp.RateApp ();

        // Calling The My Purchase

        Menu_MyPurchase MyPurchase = new Menu_MyPurchase (driver);
        MyPurchase.MyPurchase ();

        // Calling The Hireus

        Menu_Hireus Hireus = new Menu_Hireus (driver);
        Hireus.Hireus ();



        // Calling My Course Filters

        MyCourse_Filters Filter = new MyCourse_Filters (driver);
        Filter.Filter ();

        //Calling CoursePath

        CoursePath path = new CoursePath (driver);
        path.Path ();

        // Calling Course Quizzes

        CourseQuizzes Quizzes = new CourseQuizzes (driver);
        Quizzes.Quizzes ();

        // Calling Course Ebooks

        CourseEbooks Ebooks = new CourseEbooks (driver);
        Ebooks.Ebooks ();

        // Calling Course Article

        CourseArticle Article = new CourseArticle (driver);
        Article.Article ();


    }
}

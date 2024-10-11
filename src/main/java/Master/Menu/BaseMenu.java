package Master.Menu;

import Master.MainObjects.BaseObjects;
import Menu.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BaseMenu extends BaseObjects {
    static WebDriver driver;

    //Creating A Constructor For The Base Menu
    public BaseMenu(WebDriver driver) {
        BaseMenu.driver = driver;
    }

    @Test(enabled = false)
    public static void testMyNotes() throws InterruptedException {
        myNotes myNotes = new myNotes ( driver );
        myNotes.MyNotes ();
    }

    @Test(enabled = true)
    public static void testMyNotesArticle() throws InterruptedException {
        myNotes articles = new myNotes ( driver );
        articles.artilce ();
    }

    @Test(enabled = true)
    public static void testMyNotesVideos() throws InterruptedException {
        myNotes videos = new myNotes ( driver );
        videos.videos ();
    }

    @Test(enabled = true)
    public static void testMyNotesStartQuiz() throws InterruptedException {
        myNotes quiz = new myNotes ( driver );
        quiz.Startquiz ();
    }

    @Test(enabled = true)
    public static void testMyNotesResumeQuiz() throws InterruptedException {
        myNotes resume = new myNotes ( driver );
        resume.resumequiz ();
    }

    @Test(enabled = true)
    public static void testMyNotesQuizSolution() throws InterruptedException {
        myNotes solution = new myNotes ( driver );
        solution.solution ();
    }

    @Test(enabled = true)
    public static void testMyQuestions() throws InterruptedException {
        myQuestions myQuestions = new myQuestions ( driver );
        myQuestions.Myquestion ();
    }

    @Test(enabled = true)
    public static void testMyEbooks() throws InterruptedException {
        myEbooks myEbooks = new myEbooks ( driver );
        myEbooks.MyEbooks ();
    }

    @Test(enabled = true)
    public static void testMyCoins() throws InterruptedException {
        myCoins myCoins = new myCoins ( driver );
        myCoins.MyCoins ();
    }

    @Test(enabled = true)
    public static void testMyPoints() throws InterruptedException {
        myPoints myPoints = new myPoints ( driver );
        myPoints.MyPoints ();
    }

    @Test(enabled = true)
    public static void testInviteFriends() throws InterruptedException {
        inviteFriends inviteFriends = new inviteFriends ( driver );
        inviteFriends.InviteFriends ();
    }

    @Test(enabled = true)
    public static void testRateApp() throws InterruptedException {
        rateApp rateApp = new rateApp ( driver );
        rateApp.RateApp ();
    }

    @Test(enabled = true)
    public static void testMyPurchase() throws InterruptedException {
        myPurchase myPurchase = new myPurchase ( driver );
        myPurchase.MyPurchase ();
    }

    @Test(enabled = true)
    public static void testHireUs() throws InterruptedException {
        hireus hireUs = new hireus ( driver );
        hireUs.Hireus ();
    }

}

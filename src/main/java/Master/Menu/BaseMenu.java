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

    @Test(enabled = true, dependsOnMethods = "menuModuleTest")
    public static void testMyNotes() throws InterruptedException {
        myNotes myNotes = new myNotes ( driver );
        myNotes.MyNotes ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotes")
    public static void testMyNotesArticle() throws InterruptedException {
        myNotes articles = new myNotes ( driver );
        articles.artilce ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotesArticle")
    public static void testMyNotesVideos() throws InterruptedException {
        myNotes videos = new myNotes ( driver );
        videos.videos ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotesVideos")
    public static void testMyNotesStartQuiz() throws InterruptedException {
        myNotes quiz = new myNotes ( driver );
        quiz.Startquiz ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotesStartQuiz")
    public static void testMyNotesResumeQuiz() throws InterruptedException {
        myNotes resume = new myNotes ( driver );
        resume.resumequiz ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotesResumeQuiz")
    public static void testMyNotesQuizSolution() throws InterruptedException {
        myNotes solution = new myNotes ( driver );
        solution.solution ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyNotesQuizSolution")
    public static void testMyQuestions() throws InterruptedException {
        myQuestions myQuestions = new myQuestions ( driver );
        myQuestions.Myquestion ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyQuestions")
    public static void testMyEbooks() throws InterruptedException {
        myEbooks myEbooks = new myEbooks ( driver );
        myEbooks.MyEbooks ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyEbooks")
    public static void testMyCoins() throws InterruptedException {
        myCoins myCoins = new myCoins ( driver );
        myCoins.MyCoins ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyCoins")
    public static void testMyPoints() throws InterruptedException {
        myPoints myPoints = new myPoints ( driver );
        myPoints.MyPoints ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyPoints")
    public static void testInviteFriends() throws InterruptedException {
        inviteFriends inviteFriends = new inviteFriends ( driver );
        inviteFriends.InviteFriends ();
    }

    @Test(enabled = true, dependsOnMethods = "testInviteFriends")
    public static void testRateApp() throws InterruptedException {
        rateApp rateApp = new rateApp ( driver );
        rateApp.RateApp ();
    }

    @Test(enabled = true, dependsOnMethods = "testRateApp")
    public static void testMyPurchase() throws InterruptedException {
        myPurchase myPurchase = new myPurchase ( driver );
        myPurchase.MyPurchase ();
    }

    @Test(enabled = true, dependsOnMethods = "testMyPurchase")
    public static void testHireUs() throws InterruptedException {
        hireus hireUs = new hireus ( driver );
        hireUs.Hireus ();
    }

}

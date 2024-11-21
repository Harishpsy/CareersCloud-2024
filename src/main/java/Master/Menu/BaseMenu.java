package Master.Menu;

import Master.MainObjects.BaseObjects;
import Menu.*;
import ScreenShot.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseMenu {
    static WebDriver driver;

    //Creating A Constructor For The Base Menu
    public BaseMenu(WebDriver driver) {
        BaseMenu.driver = driver;
    }

    @Test(enabled = true)
    public void testMyNotes() throws InterruptedException, IOException {
        myNotes myNotes = new myNotes ( driver );
        myNotes.MyNotes ();
    }

    @Test(enabled = true)
    public void testMyNotesArticle() throws InterruptedException, IOException {
        myNotes articles = new myNotes ( driver );
        articles.artilce ();
    }

    @Test(enabled = true)
    public void testMyNotesVideos() throws InterruptedException, IOException {
        myNotes videos = new myNotes ( driver );
        videos.videos ();
    }

    @Test(enabled = true)
    public void testMyNotesStartQuiz() throws InterruptedException, IOException {
        myNotes quiz = new myNotes ( driver );
        quiz.Startquiz ();
    }

    @Test(enabled = true)
    public void testMyNotesResumeQuiz() throws InterruptedException, IOException {
        myNotes resume = new myNotes ( driver );
        resume.resumequiz ();
    }

    @Test(enabled = true)
    public void testMyNotesQuizSolution() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Notes Quiz Solution Has Been Initiated" );
        myNotes solution = new myNotes ( driver );
        solution.solution ();
        ScreenShot.captureScreenshot ( "My Notes Quiz Solution Has Been Completed" );
    }


    @Test(enabled = true)
    public void testMyQuestions() throws InterruptedException, IOException {
        myQuestions myQuestions = new myQuestions ( driver );
        myQuestions.Myquestion ();
    }

    @Test(enabled = true)
    public void testMyEbooks() throws InterruptedException, IOException {
        myEbooks myEbooks = new myEbooks ( driver );
        myEbooks.MyEbooks ();
    }

    @Test(enabled = true)
    public void testMyCoins() throws InterruptedException, IOException {
        myCoins myCoins = new myCoins ( driver );
        myCoins.MyCoins ();
    }

    @Test(enabled = true)
    public void testMyPoints() throws InterruptedException, IOException {
        myPoints myPoints = new myPoints ( driver );
        myPoints.MyPoints ();
    }

    @Test(enabled = true)
    public void testInviteFriends() throws InterruptedException, IOException {
        inviteFriends inviteFriends = new inviteFriends ( driver );
        inviteFriends.InviteFriends ();
    }

    @Test(enabled = true)
    public void testRateApp() throws InterruptedException, IOException {
        rateApp rateApp = new rateApp ( driver );
        rateApp.RateApp ();
    }

    @Test(enabled = true)
    public void testMyPurchase() throws InterruptedException, IOException {
        myPurchase myPurchase = new myPurchase ( driver );
        myPurchase.MyPurchase ();
    }

    @Test(enabled = true)
    public void testHireUs() throws InterruptedException, IOException {
        hireus hireUs = new hireus ( driver );
        hireUs.Hireus ();
    }
}

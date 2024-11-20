package Master.Menu;

import Master.MainObjects.BaseObjects;
import Menu.*;
import ScreenShot.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseMenu extends BaseObjects {
    static WebDriver driver;

    //Creating A Constructor For The Base Menu
    public BaseMenu(WebDriver driver) {
        BaseMenu.driver = driver;
    }

    @Test(enabled = true)
    public void testMyNotes() throws InterruptedException, IOException {

        ScreenShot.captureScreenshot ( "My Notes Has Been Initiated" );
        myNotes myNotes = new myNotes ( driver );
        myNotes.MyNotes ();
        ScreenShot.captureScreenshot ( "My Notes Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyNotesArticle() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Notes Article Has Been Initiated" );
        myNotes articles = new myNotes ( driver );
        articles.artilce ();
        ScreenShot.captureScreenshot ( "My Notes Article Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyNotesVideos() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Notes Videos Has Been Initiated" );
        myNotes videos = new myNotes ( driver );
        videos.videos ();
        ScreenShot.captureScreenshot ( "My Notes Videos Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyNotesStartQuiz() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Notes Start Quiz Has Been Initiated" );
        myNotes quiz = new myNotes ( driver );
        quiz.Startquiz ();
        ScreenShot.captureScreenshot ( "My Notes Start Quiz Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyNotesResumeQuiz() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Notes Resume Quiz Has Been Initiated" );
        myNotes resume = new myNotes ( driver );
        resume.resumequiz ();
        ScreenShot.captureScreenshot ( "My Notes Resume Quiz Has Been Completed" );
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
        ScreenShot.captureScreenshot ( "My Questions Has Been Initiated" );
        myQuestions myQuestions = new myQuestions ( driver );
        myQuestions.Myquestion ();
        ScreenShot.captureScreenshot ( "My Questions Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyEbooks() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Ebooks Has Been Initiated" );
        myEbooks myEbooks = new myEbooks ( driver );
        myEbooks.MyEbooks ();
        ScreenShot.captureScreenshot ( "My Ebooks Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyCoins() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Coins Has Been Initiated" );
        myCoins myCoins = new myCoins ( driver );
        myCoins.MyCoins ();
        ScreenShot.captureScreenshot ( "My Coins Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyPoints() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Points Has Been Initiated" );
        myPoints myPoints = new myPoints ( driver );
        myPoints.MyPoints ();
        ScreenShot.captureScreenshot ( "My Points Has Been Completed" );
    }

    @Test(enabled = true)
    public void testInviteFriends() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "Invite Friends Has Been Initiated" );
        inviteFriends inviteFriends = new inviteFriends ( driver );
        inviteFriends.InviteFriends ();
        ScreenShot.captureScreenshot ( "Invite Friends Has Been Completed" );
    }

    @Test(enabled = true)
    public void testRateApp() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "Rate App Has Been Initiated" );
        rateApp rateApp = new rateApp ( driver );
        rateApp.RateApp ();
        ScreenShot.captureScreenshot ( "Rate App Has Been Completed" );
    }

    @Test(enabled = true)
    public void testMyPurchase() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "My Purchase Has Been Initiated" );
        myPurchase myPurchase = new myPurchase ( driver );
        myPurchase.MyPurchase ();
        ScreenShot.captureScreenshot ( "My Purchase Has Been Completed" );
    }

    @Test(enabled = true)
    public void testHireUs() throws InterruptedException, IOException {
        ScreenShot.captureScreenshot ( "Hire Us Has Been Initiated" );
        hireus hireUs = new hireus ( driver );
        hireUs.Hireus ();
        ScreenShot.captureScreenshot ( "Hire Us Has Been Completed" );
    }
}

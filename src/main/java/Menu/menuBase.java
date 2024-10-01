package Menu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class menuBase {
    WebDriver driver;
    public menuBase(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = false)
    public void menu() throws InterruptedException {

        // My Notes
        myNotes myNotes = new myNotes ( driver );
        myNotes.MyNotes ();

        // My Notes > Article
        Menu.myNotes articles = new myNotes ( driver );
        articles.artilce ();

        // My Notes > Videos
        Menu.myNotes videos = new myNotes ( driver );
        videos.videos ();

        // My Notes > Start Quiz
        Menu.myNotes quiz = new myNotes ( driver );
        quiz.Startquiz ();

        // My Notes > Resume Quiz
        Menu.myNotes resume = new myNotes ( driver );
        resume.resumequiz ();

        // My Notes > Quiz Solution
        Menu.myNotes solutionclick = new myNotes ( driver );
        solutionclick.solution ();

        // My Questions
        myQuestions myQuestions = new myQuestions ( driver );
        myQuestions.Myquestion ();

        // My Ebooks
        myEbooks myEbooks = new myEbooks ( driver );
        myEbooks.MyEbooks ();

        // My Coins
        myCoins myCoins = new myCoins ( driver );
        myCoins.MyCoins ();

        // My Points
        myPoints myPoints = new myPoints ( driver );
        myPoints.MyPoints ();

        // Invite Friends
        inviteFriends inviteFriends = new inviteFriends ( driver );
        inviteFriends.InviteFriends ();

        // Rate App
        rateApp rateApp = new rateApp ( driver );
        rateApp.RateApp ();

        // My Purchase
        myPurchase myPurchase = new myPurchase ( driver );
        myPurchase.MyPurchase ();

        // Hire Us
        hireus hireUs = new hireus ( driver );
        hireUs.Hireus ();

    }


}

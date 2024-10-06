package MyCourse;

import Base.CommonActions.BaseActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class article {
    WebDriver driver;
    public article(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void Article() throws InterruptedException {

        // Verifying The Article Sub-Module Was Displaying, if Display Perform The Below Action
        try {
            WebElement clickingArticleTab = driver.findElement ( xpath ( "//*[text()='Articles']" ) );
            if (clickingArticleTab.isSelected ()) {
                System.out.println ( "Article Tab Is Already Selected, We Are Performing The Below Actions In The Article Tab List Page" );
            } else if (clickingArticleTab.isDisplayed ()) {
                clickingArticleTab = driver.findElement ( xpath ( "//*[text()='Articles']" ) );
                clickingArticleTab.click ();
                System.out.println ( "Successfully Clicked The Article Tab, And Performing The action In The List Page" );
            } else {
                System.out.println ( "Both The Code Has Not Executed In The Course Article Tab" );
            }

            // Creating an Object For Article Actions
            article articleAction = new article ( driver );
            articleAction.articleActions ();

        } catch (NoSuchElementException e) {
            System.out.println ( "Article Tab Is Not Present In The Current Course" );
        }
    }

    @Test
    public void articleActions() throws InterruptedException {

        // Scrollingv The Page In The Article
        BaseActions scroll = new BaseActions(driver);
        scroll.Scroll();

        // Clicking Float Icon
        BaseActions floatIcon = new BaseActions(driver);
        floatIcon.floatButton();

        // Verifying The list of Articles any one of them was getting Duplicate or Not
        // Finding All The elements From the Article components
        BaseActions duplicatefinding =  new BaseActions(driver);
        duplicatefinding.identifingDuplicate();

        // Clicking the view Article
        Thread.sleep ( 5000 );
        WebElement clickingViewButton = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]" ) );
        clickingViewButton.click ();
        System.out.println ( "Succesfully Clicked The View Article" );

        // Getting The Article Name To Verify In My Notes
        Thread.sleep ( 5000 );
        WebElement gettingArticleName = driver.findElement ( xpath ( "(//span[@class=\"ant-typography text css-xu9wm8\"])[1]" ) );
        String articleName = gettingArticleName.getText ();
        System.out.println ( "Article Name: " + articleName );

        // Clicking the like and unlike button
        Thread.sleep ( 5000 );
        WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

        if (clickAction.isDisplayed ()) {
            clickAction.click ();
            if (clickAction.getAttribute ( "class" ).contains ( "unlike" )) {
                System.out.println ( "Un Liked Successfully" );
            } else {
                System.out.println ( "Liked Successfully" );
            }
        }

        // Clicking The Comment Icon
        Thread.sleep ( 5000 );
        WebElement clickingCommentIcon = driver.findElement ( id ( "comments-icon" ) );
        clickingCommentIcon.click ();

        // Entering The comments
        Thread.sleep ( 5000 );
        WebElement enteringComments = driver.findElement ( name ( "comments1" ) );
        enteringComments.sendKeys ( "Thanks For the update" );
        System.out.println ( "Comment Added Sucessfully" );

        // Clicking The send Button
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

        // Clicking Float Icon
        try {
            // Wait for the float icon to become clickable (10-second timeout)
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
            WebElement clickingFloatIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class='css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle']" ) ) );

            // Check if the float icon is displayed
            if (clickingFloatIcon.isDisplayed ()) {
                // Optional wait before clicking
                Thread.sleep ( 2000 );
                clickingFloatIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class='css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle']" ) ) );
                clickingFloatIcon.click ();
                System.out.println ( "Float Icon clicked successfully." );
            }
        } catch (Exception e) {
            System.out.println ( "FloatIcon Button is not displayed." );
        }

        // Clicking the share icon
        Thread.sleep ( 3000 );
        WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@class=\"share\"]" ) );
        clickingshareicon.click ();

        //click the copy link in the share popup
        Thread.sleep ( 3000 );
        WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        Thread.sleep ( 3000 );
        WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
        Cancel_button.click ();
        System.out.println ( "Clicked cancel button" );

        // Verifying the Recent article in the webpage
        List<WebElement> recentArticle = driver.findElements ( xpath ( "//*[@class=\"ant-list-items\"]/child::*" ) );

        // Create a set to store unique URLs
        Set<String> uniquerecentArticleUrls = new HashSet<> ();
        int uniquerecentArticlelCount = 0;

        for (WebElement articles : recentArticle) {
            String actuarecentArticlelLink = articles.getAttribute ( "href" );
            System.out.println ( "Original Recent Article Link: " + actuarecentArticlelLink );

            if (uniquerecentArticleUrls.contains ( actuarecentArticlelLink )) {
                uniquerecentArticlelCount++;
                System.out.println ( "Duplicate found --> " + actuarecentArticlelLink );
            } else {
                uniquerecentArticleUrls.add ( actuarecentArticlelLink );
                uniquerecentArticlelCount++;
                //      System.out.println ( "Article Found: " + uniquerecentArticlelCount + " --> " + actuarecentArticlelLink );
                //     System.out.println ( "-------------------------------------------------------------------------" );
            }
        }

        // Print the total number of unique URLs found
        System.out.println ( "Total unique Article Name found: " + uniquerecentArticlelCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquerecentArticlelCount , uniquerecentArticleUrls.size () );

        // Click the BackButton In The Article
        Thread.sleep ( 10000 );
        WebElement clickingBackButton = driver.findElement ( xpath ( "//*[@class=\"ant-breadcrumb-link\"]" ) );
        clickingBackButton.click ();
        System.out.println ( "Navigated To Article List Page" );

        // Clicking the three Dots in the CourseCard
        Thread.sleep ( 5000 );
        WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
        clickingThreeDots.click ();

        // Clicking The save My Notes or Remove my notes
        Thread.sleep ( 5000 );
        WebElement clickMyNote = driver.findElement ( xpath ( "//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]" ) );

        if (clickMyNote.isDisplayed ()) {
            clickMyNote.click ();
            if (clickMyNote.getText ().contains ( "Remove My  Notes" )) {
                System.out.println ( "Successfully -  Remove - Article" );
            } else {
                System.out.println ( "Successfully -  saved - Article" );
            }
        }

//        // Clicking The home button
//        Thread.sleep ( 3000 );
//        WebElement clickingHomeButton = driver.findElement ( xpath ( "//*[text()='Home']" ) );
//        clickingHomeButton.click ();
//        System.out.println ( "SuccessFully Clicked The HomeButton" );
//
//        // Clicking The MyNotes
//        Thread.sleep ( 5000 );
//        WebElement clickingMyNotes = driver.findElement ( xpath ( "//*[@id=\"1\"]" ) );
//        clickingMyNotes.click ();
//        System.out.println ( "SuccessFully Clicked The My-Notes" );
//
//        // Verifying saved or removed article was showing in the My Notes Page
//        List<WebElement> articleMyNotes = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]" ) );
//
//        boolean articleFound = false;
//        for (WebElement Article : articleMyNotes) {
//            String articlenameInMyNotes = Article.getText ();
////            System.out.println ( "Article Name In My Notes: " + articlenameInMyNotes );
//
//            if (articleName.equals ( articlenameInMyNotes )) {
//                System.out.println ( "Verification Passed: Article Title (" + articleName + ") matches Article In My Notes (" + articlenameInMyNotes + ")" );
//                articleFound = true;
//            } else {
//                System.out.println ( "Article Name Does Not Match" );
//            }
//        }
//        if (!articleFound) {
//            System.out.println ( "Article Is Not Showing In The My Notes" );
//        }


    }
}



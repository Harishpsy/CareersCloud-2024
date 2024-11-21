package Menu;

import Master.MainObjects.BaseObjects;
import PageObjectModule.Mynotespageobject;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static PageObjectModule.Mynotespageobject.*;
import static org.openqa.selenium.By.*;


/**
 * The myNotes class is responsible for automating interactions with the "My Notes" section of a web application.
 * It provides methods to interact with notes, articles, videos, quizzes and their solutions.
 * Fields:
 * - driver: WebDriver instance to control browser actions.
 *
 */
public class myNotes extends BaseObjects {
    static WebDriver driver;


    public myNotes(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to the "My Notes" section and clicks on the "My Notes" button.
     * Initializes the elements of the "Mynotespageobject" class using PageFactory.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */

    public void MyNotes() throws InterruptedException, IOException {

        //Then click the MyNote
        PageFactory.initElements ( driver , Mynotespageobject.class );
        Thread.sleep ( 5000 );
        MyNotes.click ();
        System.out.println ( "Successfully CLicked The My Notes Button" );
        ScreenShot.captureScreenshot ( "CLicked The My Notes Button" );
    }

    /**
     * Handles actions in the "My Notes" section when articles are present or absent.
     * Depending on the presence of specific elements:
     * - If no records are found in "My Notes", navigates to the "My Question" page.
     * - If an article is found in "My Notes", performs various actions:
     *      - Clicking on the article.
     *      - Liking or unliking the article.
     *      - Adding a comment to the article.
     *      - Sharing the article and handling the share popup.
     *      - Verifying recent articles for duplicates.
     *      - Navigating back to the "My Notes" list page.
     *      - Handling the "more" options (three dots) in the course card.
     *      - Reporting the article and providing feedback.
     *      - Removing the article from "My Notes".
     *
     * The method logs the results of each action and includes various sleep intervals
     * to simulate real-time user interactions.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    public void artilce() throws InterruptedException, IOException {

        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean ArticleDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
            System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes ." );
        }

        try {
            ArticleDisplayedInMyNotes = clickingArticle.isDisplayed ();
            System.out.println ( "Article displayed In My Notes: " + ArticleDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "Article element not found In My Notes ." );
        }

        // Proceed with if-else logic

        if (noRecordfoundDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingMyQuestion.click ();
            System.out.println ( "No records found message is displayed In My Notes, navigating to My Question page." );
            ScreenShot.captureScreenshot ( "No records found message is displayed In My Notes, navigating to My Question page." );

        } else if (ArticleDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingArticle.click ();
            System.out.println ( "Successfully Clicked The Article In The My Notes" );
            ScreenShot.captureScreenshot ( "Clicked The Article In The My Notes." );

            // Clicking the like and unlike button

            Thread.sleep ( 5000 );
            WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

            if (clickAction.isDisplayed ()) {
                clickAction.click ();
                ScreenShot.captureScreenshot ( "Clicked The Like Or Un-Like Button." );

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
            ScreenShot.captureScreenshot ( "Clicked The Comment Icon." );

            // Entering The comments
            Thread.sleep ( 5000 );
            WebElement enteringComments = driver.findElement ( name ( "comments1" ) );
            enteringComments.sendKeys ( "Thanks For the update" );
            System.out.println ( "Comment Added Sucessfully" );
            ScreenShot.captureScreenshot ( "Comment Entered In The Comment Text Field" );

//        // Clicking The send Button
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();
//        captureScreenshot ( "Clicked The Send Button" );

            // Clicking Float button
            Thread.sleep ( 5000 );
            WebElement clickingFloatButton = driver.findElement ( xpath ( "//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]" ) );
            clickingFloatButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Float Button" );

            // Clicking the share icon
            Thread.sleep ( 3000 );
            WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@class=\"share\"]" ) );
            clickingshareicon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Icon" );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy Link Button" );

            //Clicking the cancel button in the in share popup
            Thread.sleep ( 3000 );
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked cancel button" );
            ScreenShot.captureScreenshot ( "Clicked cancel button" );

            // Verifying the Recent article in the webpage
            List<WebElement> recentArticle = driver.findElements ( xpath ( "//*[@class=\"ant-list-items\"]/child::*" ) );

            // Create a set to store unique URLs
            Set<String> uniquerecentArticleUrls = new HashSet<> ();
            int uniquerecentArticlelCount = 0;

            for (WebElement articles : recentArticle) {
                String actualrecentArticlelLink = articles.getAttribute ( "href" );
                if (uniquerecentArticleUrls.contains ( actualrecentArticlelLink )) {
                    uniquerecentArticlelCount++;
                    System.out.println ( "Duplicate found --> " + actualrecentArticlelLink );
                } else {
                    uniquerecentArticleUrls.add ( actualrecentArticlelLink );
                    uniquerecentArticlelCount++;
                    System.out.println ( "Article Found: " + uniquerecentArticlelCount + " --> " + actualrecentArticlelLink );
                    System.out.println ( "-------------------------------------------------------------------------" );
                }
            }
            // Print the total number of unique URLs found
            System.out.println ( "Total unique image URLs found: " + uniquerecentArticlelCount );

            // Assert that the number of unique URLs is equal to the number of elements
            Assert.assertEquals ( uniquerecentArticlelCount , uniquerecentArticleUrls.size () );

            // Click the BackButton In The Article
            Thread.sleep ( 7000 );
            WebElement clickingBackButton = driver.findElement ( xpath ( "//*[@class=\"ant-breadcrumb-link\"]" ) );
            clickingBackButton.click ();
            System.out.println ( "Navigated To My Notes List Page" );
            ScreenShot.captureScreenshot ( "Clicked Back Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Button" );

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy Link " );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots Button" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );
            ScreenShot.captureScreenshot ( "Entered The Comment In The Text Field" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

//            // Clicking The report Button
//
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();
            ScreenShot.captureScreenshot ( "Clicked The Remove My Notes Button" );

        } else {
            System.out.println ( "Both The Code Has Not Executed In The My Notes for article " );
        }
    }

    /**
     * This method performs a series of UI interactions on a web page involving videos.
     * It checks for the presence of certain elements, clicks on various buttons,
     * and logs the results of these actions. The interactions include:
     *
     * 1. Checking if a "No Record Found" message is displayed and navigating to the "My Question" page if true.
     * 2. Verifying if videos are displayed and if so, performing actions like clicking the video, liking/unliking, commenting, sharing, and various video controls (pause, mute
     * , captions, fullscreen).
     * 3. Handling popups and switching between windows.
     * 4. Navigating video URLs and verifying duplicates using a HashSet.
     * 5. Clicking back arrows and navigating back to the course card.
     * 6. Interacting with the share and report options in the course card dropdown.
     *
     * @throws InterruptedException if any thread has interrupted the current thread.
     */
    public void videos() throws InterruptedException, IOException {

        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean videosDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
            System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
            ScreenShot.captureScreenshot ( "NoRecordFound_Displayed" );
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes ." );
            ScreenShot.captureScreenshot ( "NoRecordFound_NotFound" );
        }

        try {
            videosDisplayedInMyNotes = clickingVideos.isDisplayed ();
            System.out.println ( "videos Displayed In My Notes: " + videosDisplayedInMyNotes );
            ScreenShot.captureScreenshot ( "videos Displayed In My Notes" );
        } catch (NoSuchElementException e) {
            System.out.println ( "videos element not found In My Notes ." );
            ScreenShot.captureScreenshot ( "videos element not found" );
        }

        // Verifying with the if else statement

        if (noRecordfoundDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingMyQuestion.click ();
            System.out.println ( "No records found message is displayed In My Notes, navigating to My Question page." );
            ScreenShot.captureScreenshot ( "No records found" );
        } else if (videosDisplayedInMyNotes) {

            // Clicking the videos in the my notes list page
            Thread.sleep ( 5000 );
            clickingVideos.click ();
            System.out.println ( "Successfully Clicked the videos " );
            ScreenShot.captureScreenshot ( "Clicked the videos" );

            // Clicking the like and unlike button

            WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

            if (clickAction.isDisplayed ()) {
                clickAction.click ();
                ScreenShot.captureScreenshot ( "Clicked the Like Or Un-Like" );

                if (clickAction.getAttribute ( "class" ).contains ( "unlike" )) {
                    System.out.println ( "Un Liked Successfully " );
                } else {
                    System.out.println ( " Liked Successfully " );
                }
            }

            // Clicking The Comment Icon
            Thread.sleep ( 5000 );
            WebElement clickingCommentIcon = driver.findElement ( id ( "comments-icon" ) );
            clickingCommentIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked the Comment Icon" );

            // Entering The comments

            Thread.sleep ( 3000 );
            WebElement enteringComments = driver.findElement ( name ( "comments1" ) );
            enteringComments.sendKeys ( "Thanks For the update" );
            System.out.println ( "Comment Added Sucessfully" );
            ScreenShot.captureScreenshot ( "Comment Added In Comment Text Field" );

//            // Clicking The send Button
//            Thread.sleep ( 3000 );
//            WebElement clickingSendButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-send\"]" ) );
//            clickingSendButton.click ();
//            ScreenShot.captureScreenshot ("Clicked The Send Button");

            // Clicking the share icon
            Thread.sleep ( 5000 );
            WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@class=\"share\"]" ) );
            clickingshareicon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Icon" );

            //click the copy link in the share popup
            Thread.sleep ( 5000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy Link" );

            //Clicking the cancel button in the in share popup
            Thread.sleep ( 3000 );
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Clicked cancel button" );
            ScreenShot.captureScreenshot ( "Clicked cancel button" );

            // Clicking The Pause Button In The Viedos
            driver.switchTo ().frame ( 0 );
            Thread.sleep ( 3000 );
            WebElement clickingPauseButton = driver.findElement ( xpath ( "//*[@title=\"Pause (k)\"]" ) );
            clickingPauseButton.click ();
            System.out.println ( "SucessFully Clicked Paused button" );
            ScreenShot.captureScreenshot ( "Clicked Paused button" );

            // Click the mute button in the video
            WebElement clickingMuteButton = driver.findElement ( xpath ( "//*[@title=\"Mute (m)\"]" ) );
            clickingMuteButton.click ();
            System.out.println ( "SucessFully Clicked Mute button" );
            ScreenShot.captureScreenshot ( "Clicked Mute button" );


            // Clicking The Caption button
            WebElement clickingCaptionButton = driver.findElement ( xpath ( "//*[@title=\"Subtitles/closed captions (c)\"]" ) );
            clickingCaptionButton.click ();
            System.out.println ( "SucessFully Clicked Caption (ON) button" );
            ScreenShot.captureScreenshot ( "Clicked Caption (ON) button" );

            // Clicking the Full screen Button
            Thread.sleep ( 3000 );
            WebElement clickingFullScreenButton = driver.findElement ( xpath ( "//*[@title=\"Full screen (f)\"]" ) );
            clickingFullScreenButton.click ();
            System.out.println ( "SucessFully Clicked The Full Screen Button" );
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button" );

            // Clicking the Exit The Full-screen Button
            Thread.sleep ( 3000 );
            WebElement clickingExitFullScreenButton = driver.findElement ( xpath ( "//*[@title=\"Exit full screen (f)\"]" ) );
            clickingExitFullScreenButton.click ();
            System.out.println ( "SucessFully Clicked The Exit Full Screen Button" );
            ScreenShot.captureScreenshot ( "Clicked The Exit Full Screen Button" );

            // Clicking the YouTube Logo It will navigate to YouTube or new windows
            Thread.sleep ( 3000 );
            WebElement clickingYouTubeLogo = driver.findElement ( xpath ( "//*[@title=\"Watch on YouTube\"]" ) );
            clickingYouTubeLogo.click ();
            System.out.println ( "SucessFully Clicked The YouTube Logo " );
            ScreenShot.captureScreenshot ( "Clicked The YouTube Logo" );

            // Windows Handeling
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Navigating to viedos Page
            Thread.sleep ( 3000 );
            driver.close ();
            ScreenShot.captureScreenshot ( "Clicked The Close Button" );

            // Switching Windows to Parent
            driver.switchTo ().window ( parent );

            // Another Method for verifying Duplicate In The Wep page Using HashSet
            List<WebElement> recentVideos = driver.findElements ( xpath ( "//*[@class=\"ant-list-items\"]/child::*" ) );

            // Create a set to store unique Recent Videos
            Set<String> uniqueurl = new HashSet<> ();
            int uniquevideosurlcount = 0;

            // Iterate through the list of elements
            for (WebElement recentVideo : recentVideos) {
                String actualUrls = recentVideo.getAttribute ( "href" );

                if (uniqueurl.contains ( actualUrls )) {
                    System.out.println ( "Duplicate found --> " + actualUrls );
                } else {
                    uniqueurl.add ( actualUrls );
                    uniquevideosurlcount++;
                    System.out.println ( "Recent Video URL Found: " + uniquevideosurlcount + "-->" + actualUrls );
                }
            }
            System.out.println ( "Total unique videos url found: " + uniquevideosurlcount );
            Assert.assertEquals ( uniquevideosurlcount , uniqueurl.size () );

            // Clicking The Back Arrow in Viedos page
            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"ant-breadcrumb-link\"]" ) );
            clickingBackArrow.click ();
            System.out.println ( "--------------------------------" );
            System.out.println ( "Sucessfully Clicking Back Arrow" );
            ScreenShot.captureScreenshot ( "Clicking Back Arrow Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicking The ThreeDots Button" );

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Button" );

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy Link" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );
            ScreenShot.captureScreenshot ( "Entering The Comment In The Text Field" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button " );

//            // Clicking The report Button
//
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();
            ScreenShot.captureScreenshot ( "Clicked The Remove My Notes" );

        } else {
            System.out.println ( "Both are was not executed for videos in my notes" );
        }
    }
    /**
     * This method handles the initiation and management of a quiz session including various UI interaction.
     * It checks if specific elements are displayed, logs their statuses, and performs actions accordingly.
     *
     * @throws InterruptedException if any thread sleep operation is interrupted.
     *
     * The method performs the following steps:
     * 1. Checks the visibility of elements indicating "No Record Found", "Start Quiz", and "Quiz Solution" in "My Notes".
     * 2. Based on the visibility checks, it either navigates to the "My Question" page or starts the quiz.
     * 3. If the quiz is started, it switches to the quiz window, handles quiz-related instructions and buttons, including close and maximize actions.
     * 4. Clicks quiz options and the "Save & Next" button in a loop.
     * 5. Handles quiz navigation, including clicking options again after navigating back, and interacting with buttons such as "Previous" and "Pause".
     * 6. Manages the pause functionality, including clicking the cancel and leave buttons on the pause popup.
     * 7. Switches between parent and child windows and resumes the quiz.
     * 8. Repeats certain interactions in the resumed quiz session.
     */
    public void Startquiz() throws InterruptedException, IOException {

        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean quizStartDisplayedInMyNotes = false;
        boolean quizsolutionDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes." );
        }

        try {
            quizStartDisplayedInMyNotes = clickingStartQuiz.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "StartQuiz element not found In My Notes." );
        }


        try {
            quizsolutionDisplayedInMyNotes = clickingSolutionquiz.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Solution button element not found In My Notes." );
        }

        // Log the visibility status of each element
        System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        System.out.println ( "StartQuiz displayed In My Notes: " + quizStartDisplayedInMyNotes );
        System.out.println ( "Solution button displayed In My Notes: " + quizsolutionDisplayedInMyNotes );

        // Perform actions based on which element is visible
        if (noRecordfoundDisplayedInMyNotes) {
            clickingMyQuestion.click ();
            System.out.println ( "No records found message is displayed In My Notes, navigating to My Question page." );
            ScreenShot.captureScreenshot ( "Clicked The My Question" );
        } else if (quizStartDisplayedInMyNotes) {
            Thread.sleep ( 5000 );
            clickingStartQuiz.click ();
            System.out.println ( "Successfully clicked the Start button in My Notes." );
            ScreenShot.captureScreenshot ( "clicked the Start button in My Notes." );

            //Windows Handeling
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Clicking the close icon in the quiz instruction

            Thread.sleep ( 7000 );
            WebElement Close_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            Close_icon.click ();
            System.out.println ( "SuccessFully Clicked The CloseIcon" );
            ScreenShot.captureScreenshot ( "Clicked The Close Icon" );

            //Windows mazimize

            WebDriverWait waitForWindowsMaximize;
            waitForWindowsMaximize = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button

            Thread.sleep ( 3000 );
            WebElement clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "SuccessFully Clicked The InstructionIcon" );
            ScreenShot.captureScreenshot ( "Clicked The Instruction Icon" );

            // Again Clicking the close icon in the quiz instruction
            Thread.sleep ( 3000 );
            WebElement againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();
            System.out.println ( "SuccessFully Clicked The Close_icon again " );
            ScreenShot.captureScreenshot ( "Clicked The Close_icon again" );

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "SuccessFully Clicked The Full Screen Button " );
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button" );

            // Clicking the BookMark-icon
            try {
                WebElement bookmarkIcon = driver.findElement ( By.xpath ( "//*[@class='bookmark-icon']" ) );
                if (bookmarkIcon.isDisplayed ()) {
                    bookmarkIcon.click ();
                    System.out.println ( "Successfully Clicked The Bookmark Icon" );
                    ScreenShot.captureScreenshot ( "Clicked The Bookmark Icon" );
                }
            } catch (NoSuchElementException e1) {
                try {
                    WebElement bookmarkedIcon = driver.findElement ( By.xpath ( "//*[@class='bookmarked-icon']" ) );
                    if (bookmarkedIcon.isDisplayed ()) {
                        bookmarkedIcon.click ();
                        System.out.println ( "Successfully Un-Clicked The Bookmark Icon" );
                        ScreenShot.captureScreenshot ( "Un-Clicked The Bookmark Icon" );
                    }
                } catch (NoSuchElementException e2) {
                    System.out.println ( "Both The Code Has Not Executed" );
                }
            }


            // Define the options to be clicked
            String[] options = new String[]{"A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" ,};

            // Locate the Save & Next button
            WebElement saveAndNextButton = driver.findElement ( By.xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( By.xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                ScreenShot.captureScreenshot ( "Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( By.xpath ( "//div[text()='" + options[i] + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + options[i] );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                WebElement numberOnRightSide = driver.findElement ( By.xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "Successfully Clicked The Number: " + (16 + i) );
                ScreenShot.captureScreenshot ( "Clicked The Number" );
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            WebElement clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Previous Button" );

            // Clicking The Pause Button
            Thread.sleep ( 3000 );
            WebElement clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Pause Button" );

            // Clicking The Cancel Button In The Pause popup
            Thread.sleep ( 3000 );
            WebElement clickingCancelButtonInPopup = driver.findElement ( xpath ( "//*[text()=' Cancel ']" ) );
            clickingCancelButtonInPopup.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button In Popup" );

            // Again Clicking The Pause Button leaves the quiz
            Thread.sleep ( 3000 );
            clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Pause Button" );

            // Clicking The Leave button In the Pause Popup

            Thread.sleep ( 3000 );
            WebElement clickingLeaveButtonInPopup = driver.findElement ( xpath ( "//span[text()=\" Leave \"]" ) );
            clickingLeaveButtonInPopup.click ();
            ScreenShot.captureScreenshot ( "Clicked The Leave Button In Popup" );

            // Changing The Child Windows To Parent Window
            driver.switchTo ().window ( parent );

            // Clicking The resume Button
            Thread.sleep ( 3000 );
            clickingResumequiz.click ();
            System.out.println ( "Successfully clicked the Resume button in My Notes." );
            ScreenShot.captureScreenshot ( "clicked the Resume button in My Notes." );

            //Windows Handeling
            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );

            //Windows mazimize
            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button
            driver.manage ().timeouts ().implicitlyWait ( 30 , TimeUnit.SECONDS );
            clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "Sucessfully clicked instruction icon" );
            ScreenShot.captureScreenshot ( "Clicked instruction icon" );

            // Again Clicking the close icon in the quiz instruction
            Thread.sleep ( 3000 );
            againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Again Close icon" );

            // Clicking The FullScreen Button
            Thread.sleep ( 2000 );
            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button" );

            // Clicking the BookMark-icon
                /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                 WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
                 bookMarkicon.click ();*/

            // Define the options to be clicked
            options = new String[]{"A" , "A" , "B" , "D" , "E" , "C" , "C" , "A" , "D" , "E" , "A" , "E" , "A" , "C" , "E" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                ScreenShot.captureScreenshot ( "Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                try {
                    Thread.sleep ( 3000 );

                    // Click the option
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully clicked the option: " + options[i] );
                    ScreenShot.captureScreenshot ( "clicked the option" );

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
                        ScreenShot.captureScreenshot ( "clicked the number and navigated to the next question" );
                    } else {
                        System.out.println ( "Number " + (16 + i) + " not found, skipping to the next iteration." );
                    }

                } catch (InterruptedException e) {
                    System.out.println ( "Thread sleep was interrupted." );
                } catch (NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "clicked the Previous Button" );

            // Clicking The Submit Button
            Thread.sleep ( 3000 );
            WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "clicked the Submit Button" );

            // Clicking the Cancel Button In the submit Popup
            Thread.sleep ( 1000 );
            WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();
            ScreenShot.captureScreenshot ( "clicked the Cancel Button In The Popup" );

            // Again Clicking The Submit Button
            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "Again Clicked the Submit Button" );

            // Clicking The Submit Button In The Submit Popup
            Thread.sleep ( 1000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=\"Submit\"]" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "Clicked the Submit Button" );

            // Switching Windows From Child To Parent

            driver.switchTo ().window ( parent );

            // Clicking The solution button
            Thread.sleep ( 2000 );
            clickingSolutionquiz.click ();
            ScreenShot.captureScreenshot ( "Clicked the Solution Button" );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            Actions actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked the Report Button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            WebElement clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked the Translation Error Radio Button" );

            // Clicking The Report Description button
            WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Entered The Report In The Text Field" );

            // Clicking The Cancel Button
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel button" );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 3000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            // Clicking The Report Description button
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Entered The Report In The Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( "clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period1." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" , "A" , "D" , "E" , "D" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option." );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                ScreenShot.captureScreenshot ( "Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                try {
                    Thread.sleep ( 3000 );

                    // Click the option
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully clicked the option: " + options[i] );
                    ScreenShot.captureScreenshot ( "Clicked the option" );

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
                        ScreenShot.captureScreenshot ( "Clicked the number and navigated to the next question" );
                    } else {
                        System.out.println ( "Number " + (16 + i) + " not found, skipping to the next iteration." );
                    }

                } catch (InterruptedException e) {
                    System.out.println ( "Thread sleep was interrupted." );
                } catch (NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Previous Button" );

            // Scrolling The Solution Page
            Thread.sleep ( 1000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The scroll To Report Icon" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            //Entering the text inside the report text field In Solution Page
            Thread.sleep ( 3000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            // Click the report button

            Thread.sleep ( 3000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

            // Clicking The Share Icon In The Solution Page
            Thread.sleep ( 3000 );
            WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Icon" );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy link" );

            //Clicking the cancel button in the in share popup
            WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel button" );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Reattempt Button" );

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( "Clicked The Reattempt icon" );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period2." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen
            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            ScreenShot.captureScreenshot ( "Clicked The Back Arrow" );

            // Clicking The solution button
            Thread.sleep ( 2000 );
            clickingSolutionquiz.click ();
            ScreenShot.captureScreenshot ( "Clicked The solution button" );

            // Analysis was not working in site
            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            ScreenShot.captureScreenshot ( "Clicked The Back Arrow" );
//
            // Clicking The Analysis Button In The MY Notes
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "//*[text()='Analysis']" ) );
            clickingAnalysisButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Analysis Button" );

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            clickingTheFullScreenButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-expand\"]" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Analysis Icon In Solution Screen" );

            // Exiting The FullScreen Button
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button In Solution Screen" );

            // Clicking The share Icon
            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            System.out.println ( "Successfully Clicked The The Share Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The The Share Icon In Solution Screen " );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully Clicked The Copy link In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Copy link In Solution Screen " );

            //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel buttonIn Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Cancel buttonIn Solution Screen" );

            // Clicking Like/Unlike Button

            try {
                try {
                    // Locate the like button
                    WebElement likeButton = driver.findElement ( By.xpath ( "//*[@class='like']" ) );
                    if (likeButton.isDisplayed ()) {
                        likeButton.click ();
                        System.out.println ( "Successfully Clicked The Like Button" );
                        ScreenShot.captureScreenshot ( "Clicked The Like Button" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );
                        if (unlikeButton.isDisplayed ()) {
                            unlikeButton.click ();
                            System.out.println ( "Successfully Clicked The Unlike Button" );
                            ScreenShot.captureScreenshot ( "Clicked The Unlike Button" );
                        }
                    } catch (NoSuchElementException e2) {
                        System.out.println ( "Unlike Button not found" );
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }
            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();
            System.out.println ( "Successfully Clicked The Comment Icon In Analysis Page" );
            ScreenShot.captureScreenshot ( "Clicked The Comment Icon In Analysis Page" );

            //Entering Comment In The TextField
            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );
            System.out.println ( "Successfully Entered The Comments" );
            ScreenShot.captureScreenshot ( "Entered The Comments" );

            // Clicking The Send Button In The Comment Text Field
//
//            Thread.sleep (2000);
//            clickingSendButton = driver.findElement (className ("anticon-send"));
//            clickingSendButton.click ();

            // Scrolling The analysis page Up

            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Page" );
            ScreenShot.captureScreenshot ( "Scroll The Page" );

            // Clicking The Reattempt Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();
            System.out.println ( "Successfully clicked Reattemp Button" );
            ScreenShot.captureScreenshot ( "Clicked Reattemp Button" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 5000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );
            ScreenShot.captureScreenshot ( "Clicked Back Arrow" );

            // Clicking The Solution Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();
            System.out.println ( "Successfully clicked Solution Button In Analysis" );
            ScreenShot.captureScreenshot ( "Clicked Solution Button In Analysis" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 10000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );
            ScreenShot.captureScreenshot ( "Clicked Back Arrow" );

            // Scrolling The analysis page Forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
            System.out.println ( "Successfully Scroll The Page Down " );
            ScreenShot.captureScreenshot ( "Scroll The Page Down" );

            // Scrolling The analysis page Backward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Backwards " );
            ScreenShot.captureScreenshot ( " Scroll The Backwards" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
            Thread.sleep ( 5000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );
            ScreenShot.captureScreenshot ( " Clicked The Back To Quiz Breadcrumbs In The Analysis Page" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( " Clicked The Three Dots" );

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Share Button" );

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            ScreenShot.captureScreenshot ( " Clicked The Copy Link" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( " Clicked The Three Dots" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );
            ScreenShot.captureScreenshot ( " Entered The Text Iside The Text" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel" );

//            // Clicking The report Button
//
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();
            ScreenShot.captureScreenshot ( "Clicked The Remove My Notes" );

        } else {
            System.out.println ( "No matching condition was found in the Start quiz My Notes." );
        }
    }

    /**
     * Resumes a quiz by determining if necessary elements to proceed are present.
     * Handles various stages of quiz resumption, including clicking through quiz questions,
     * managing browser window state, and interacting with UI elements to proceed with the quiz.
     *
     * @throws InterruptedException if any thread has interrupted the current thread while sleeping.
     */
    public void resumequiz() throws InterruptedException, IOException {
        System.out.println ( "----------------------Resume Quiz---------------------------" );
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean quizresumeDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes." );
        }
        try {
            quizresumeDisplayedInMyNotes = clickingResumequiz.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "ResumeQuiz element not found In My Notes." );
        }

        System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        System.out.println ( "ResumeQuiz displayed In My Notes: " + quizresumeDisplayedInMyNotes );

        if (noRecordfoundDisplayedInMyNotes) {
            clickingMyQuestion.click ();
            ScreenShot.captureScreenshot ( "Clicked The My-Question" );
        } else if (quizresumeDisplayedInMyNotes) {

            Thread.sleep ( 3000 );
            clickingResumequiz.click ();
            System.out.println ( "Successfully clicked the Resume button in My Notes." );
            ScreenShot.captureScreenshot ( "Clicked The Resume quiz" );

            //Windows Handeling

            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            //Windows mazimize

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button

            driver.manage ().timeouts ().implicitlyWait ( 30 , TimeUnit.SECONDS );
            WebElement clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "Sucessfully clicked instruction icon" );
            ScreenShot.captureScreenshot ( "Clicked instruction icon" );

            // Again Clicking the close icon in the quiz instruction

            Thread.sleep ( 3000 );
            WebElement againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();
            ScreenShot.captureScreenshot ( "Clicked Close icon" );

            // Clicking The FullScreen Button

            Thread.sleep ( 2000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button" );

            // Clicking the BookMark-icon

                /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                 WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
                 bookMarkicon.click ();*/

            // Define the options to be clicked
            String[] options = new String[]{"A" , "A" , "B" , "D" , "E" , "C" , "C" , "A" , "D" , "E" , "A" , "E" , "A" , "C" , "E" ,};

            // Locate the Save & Next button
            WebElement saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                ScreenShot.captureScreenshot ( "Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                try {
                    Thread.sleep ( 3000 );

                    // Click the option
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully clicked the option: " + options[i] );
                    ScreenShot.captureScreenshot ( "Clicked the option" );

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
                        ScreenShot.captureScreenshot ( "Clicked the number and navigated to the next question" );
                    } else {
                        System.out.println ( "Number " + (16 + i) + " not found, skipping to the next iteration." );
                    }

                } catch (InterruptedException e) {
                    System.out.println ( "Thread sleep was interrupted." );
                } catch (NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            WebElement clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Previous Button" );

            // Clicking The Submit Button

            Thread.sleep ( 3000 );
            WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Submit Button" );

            // Clicking the Cancel Button In the submit Popup
            Thread.sleep ( 1000 );
            WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button In The Popup" );

            // Again Clicking The Submit Button
            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Submit Button" );

            // Clicking The Submit Button In The Submit Popup
            Thread.sleep ( 1000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=\"Submit\"]" ) );
            clickingSubmitButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Submit Button" );

            // Switching Windows From Child To Parent

            driver.switchTo ().window ( parent );

            // Clicking The solution button
            Thread.sleep ( 2000 );
            clickingSolutionquiz.click ();
            ScreenShot.captureScreenshot ( "Clicked The solution button" );

            // Scrolling and Clicking The Report Page

            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            Actions actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Click The Translation Error In The Report Popup

            Thread.sleep ( 3000 );
            WebElement clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            // Clicking The Report Description button
            WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Enter The Text Inside The Report Text Field" );

            // Clicking The Cancel Button
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel button" );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 3000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            // Clicking The Report Description button
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Enter The Text Inside The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( "Clicked the reattempt icon" );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period1." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" , "A" , "D" , "E" , "D" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                ScreenShot.captureScreenshot ( "Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                try {
                    Thread.sleep ( 3000 );

                    // Click the option
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully clicked the option: " + options[i] );
                    ScreenShot.captureScreenshot ( "Clicked the option" );

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
                        ScreenShot.captureScreenshot ( "Clicked the number and navigated to the next question" );
                    } else {
                        System.out.println ( "Number " + (16 + i) + " not found, skipping to the next iteration." );
                    }

                } catch (InterruptedException e) {
                    System.out.println ( "Thread sleep was interrupted." );
                } catch (NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Previous Button" );

            // Scrolling The Report Button
            Thread.sleep ( 1000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report Button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            //Entering the text inside the report text field In Solution Page
            Thread.sleep ( 3000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( " Entering The text In The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( " Clicked The report Button " );

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

            // Clicking The Share Icon In The Solution Page
            Thread.sleep ( 3000 );
            WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            ScreenShot.captureScreenshot ( " Clicked The Share Icon " );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            ScreenShot.captureScreenshot ( " Clicked The Copy link " );

            //Clicking the cancel button in the in share popup
            WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( " Clicked The Cancel button " );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Reattempt Button" );

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( " Clicked The Reattempt Icon" );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period2." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen
            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            ScreenShot.captureScreenshot ( " Clicked The Back Arrow" );

            // Clicking The solution button
            Thread.sleep ( 2000 );
            clickingSolutionquiz.click ();
            ScreenShot.captureScreenshot ( " Clicked The solution button" );

            // Analysis was not working in site
            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            ScreenShot.captureScreenshot ( " Clicked The Back Arrow" );

            // Clicking The Analysis Button In The MY Notes
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "//*[text()='Analysis']" ) );
            clickingAnalysisButton.click ();
            ScreenShot.captureScreenshot ( " Clicked The Analysis Button" );

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            clickingTheFullScreenButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-expand\"]" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( " Clicked The FullScreen Button" );


            // Exiting The FullScreen Button
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button In Solution Screen " );
            ScreenShot.captureScreenshot ( " Exit The FullScreen Button" );

            // Clicking The share Icon
            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            System.out.println ( "Successfully Clicked The The Share Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The The Share Icon In Solution Screen" );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully Clicked The Copy link In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Copy link In Solution Screen" );

            //Clicking the cancel button in the in share popup
            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel buttonIn Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Cancel buttonIn Solution Screen" );

            // Clicking Like/Unlike Button
            try {
                try {
                    // Locate the like button
                    WebElement likeButton = driver.findElement ( By.xpath ( "//*[@class='like']" ) );
                    if (likeButton.isDisplayed ()) {
                        likeButton.click ();
                        System.out.println ( "Successfully Clicked The Like Button" );
                        ScreenShot.captureScreenshot ( "Clicked The Like Button" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );
                        if (unlikeButton.isDisplayed ()) {
                            unlikeButton.click ();
                            System.out.println ( "Successfully Clicked The Unlike Button" );
                            ScreenShot.captureScreenshot ( "Clicked The Unlike Button" );
                        }
                    } catch (NoSuchElementException e2) {
                        System.out.println ( "Unlike Button not found" );
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }
            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();
            System.out.println ( "Successfully Clicked The Comment Icon In Analysis Page" );
            ScreenShot.captureScreenshot ( "Clicked The Comment Icon In Analysis Page" );

            //Entering Comment In The TextField

            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );
            System.out.println ( "Successfully Entered The Comments" );
            ScreenShot.captureScreenshot ( "Entered The Comments In The Text Field" );

            // Clicking The Send Button In The Comment Text Field
//            Thread.sleep (2000);
//            clickingSendButton = driver.findElement (className ("anticon-send"));
//            clickingSendButton.click ();

            // Scrolling The analysis page Up
            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Page" );
            ScreenShot.captureScreenshot ( "Scrolling The analysis page Up" );

            // Clicking The Reattempt Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();
            System.out.println ( "Successfully clicked Reattemp Button" );
            ScreenShot.captureScreenshot ( "Clicked Reattemp Button" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 5000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );
            ScreenShot.captureScreenshot ( "Clicked Back Arrow" );

            // Clicking The Solution Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();
            System.out.println ( "Successfully clicked Solution Button In Analysis" );
            ScreenShot.captureScreenshot ( "Clicked Solution Button In Analysis" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 10000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked clicking Back Arrow" );
            ScreenShot.captureScreenshot ( "Clicked clicking Back Arrow" );

            // Scrolling The analysis page Forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
            System.out.println ( "Successfully Scroll The Page Down " );
            ScreenShot.captureScreenshot ( "Clicked clicking Back Arrow" );

            // Scrolling The analysis page Backward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Backwards " );
            ScreenShot.captureScreenshot ( "Scrolling The analysis page Backward" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
            Thread.sleep ( 5000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );
            ScreenShot.captureScreenshot ( "Clicked The Back To Quiz Breadcrumbs In The Analysis Page" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Button" );

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            ScreenShot.captureScreenshot ( "Clicked The Copy Link" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );
            ScreenShot.captureScreenshot ( "Entered The Text Inside The Text Field" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

//            // Clicking The report Button
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();
            ScreenShot.captureScreenshot ( "Clicked The Remove My Notes" );

        } else {
            System.out.println ( "No matching condition was found in the Resume quiz My Notes." );
        }
    }

    /**
     * This method performs several UI-related actions including checking the visibility of web elements, clicking on buttons, entering text into input fields,
     * scrolling to certain elements, handling popups, and navigating through a list of selectable options.
     *
     * Functionalities covered in this method:
     *
     * <ol>
     *     <li>Logging visibility status of specific elements "noRecordfoundMyNotes" and "clickingSolutionquiz".</li>
     *     <li>If "noRecordfoundMyNotes" is visible, clicking "clickingMyQuestion".</li>
     *     <li>If "clickingSolutionquiz" is visible, clicking it and performing a series of interactions such as:
     *         <ul>
     *             <li>Scrolling and clicking the report icon.</li>
     *             <li>Choosing "Translations Error" in the report popup and entering a description.</li>
     *             <li>Clicking the "CANCEL" and "REPORT" buttons in the report popup.</li>
     *         </ul>
     *     </li>
     *     <li>Handling a "reattempt" button, retrying clicks with error handling for various exceptions.</li>
     *     <li>Selecting options from a predefined array and clicking the "Save & Next" button.</li>
     *     <li>Navigating back through options and interacting with new elements based on iteration indices.</li>
     *     <li>Performing several other UI interactions such as clicking the "Previous" button, handling "Translation Error" selection, entering text in the report description, and
     *  sharing using a share icon and copy link functionality.</li>
     * </ol>
     *
     * Prerequisites:
     *
     * - Instances of `WebDriver`, `WebElement`, `Actions`, and other related variables must be initialized before invoking this method.
     *
     * Exceptions:
     *
     * - Throws `InterruptedException` due to usage of `Thread.sleep()` calls within the method.
     * - Catches and handles `NoSuchElementException`, `TimeoutException`, and generic `Exception` to ensure smooth execution even if some web elements are not found or actionable
     * .
     */
    public void solution() throws InterruptedException, IOException {
        System.out.println ( "-----------------------Solutions---------------------------" );
        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean quizsolutionDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes." );
        }

        try {
            quizsolutionDisplayedInMyNotes = clickingSolutionquiz.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Solution button element not found In My Notes." );
        }

        // Log the visibility status of each element
        System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        System.out.println ( "Solution button displayed In My Notes: " + quizsolutionDisplayedInMyNotes );

        if (noRecordfoundDisplayedInMyNotes) {
            clickingMyQuestion.click ();

        } else if (quizsolutionDisplayedInMyNotes) {

            clickingSolutionquiz.click ();
            System.out.println ( "Successfully clicked the Solution button in My Notes." );
            ScreenShot.captureScreenshot ( "clicked the Solution button in My Notes." );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 30000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report\"]" ) );
            Actions actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "clicked the Report button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            WebElement clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "clicked the Translation Error Radio Button" );

            // Clicking The Report Description button
            WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Entered the text In The Report Text Field" );

            // Clicking The Cancel Button
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "clicked the Cancel button" );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 3000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "clicked the Report button" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "clicked the Translation Error Radio Button" );

            // Clicking The Report Description button
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Entered The text In The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( "Clicked the Report button" );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( "Clicked the reattempt icon" );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period3." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            String[] options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" , "A" , "D" , "E" , "D" ,};

            // Locate the Next button
            Thread.sleep ( 20000 );
            WebElement NextButton = driver.findElement ( xpath ( "//*[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );
                ScreenShot.captureScreenshot ( "Clicked The Option" );

                Thread.sleep ( 3000 );
                NextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                try {
                    Thread.sleep ( 3000 );

                    // Click the option
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully clicked the option: " + options[i] );
                    ScreenShot.captureScreenshot ( "Clicked the option" );

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
                        ScreenShot.captureScreenshot ( "Clicked the number and navigated to the next question" );
                    } else {
                        System.out.println ( "Number " + (16 + i) + " not found, skipping to the next iteration." );
                    }

                } catch (InterruptedException e) {
                    System.out.println ( "Thread sleep was interrupted." );
                } catch (NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            WebElement clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Previous Button" );

            // Scrolling The Solution Page
            Thread.sleep ( 1000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            ScreenShot.captureScreenshot ( "Scrolling The Solution Page" );

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            ScreenShot.captureScreenshot ( "Clicked The Translation Error Radio Button" );

            //Entering the text inside the report text field In Solution Page
            Thread.sleep ( 3000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            ScreenShot.captureScreenshot ( "Entered The text In The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Report button" );

            // Clicking The Cancel Button
            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

            // Clicking The Share Icon In The Solution Page
            Thread.sleep ( 3000 );
            WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            ScreenShot.captureScreenshot ( "Clicked The Share Icon In The Solution Page" );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            ScreenShot.captureScreenshot ( "Clicked The copy link in the share popup" );

            //Clicking the cancel button in the in share popup
            WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            ScreenShot.captureScreenshot ( "Clicked The cancel button in the in share popup" );

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class=\"ant-switch ant-switch-small css-xu9wm8 ant-switch-checked\"]" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
                ScreenShot.captureScreenshot ( "clicked the reattempt icon" );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period4." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            ScreenShot.captureScreenshot ( "clicked the back arrow in the solution screen" );

            // Clicking The Analysis Button In The MY Notes
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "//*[text()='Analysis']" ) );
            clickingAnalysisButton.click ();
            ScreenShot.captureScreenshot ( "clicked the Analysis Button In The MY Notes" );

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-expand\"]" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Analysis Icon In Solution Screen" );

            // Exiting The FullScreen Button
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Full Screen Button In Solution Screen" );

            // Clicking The share Icon
            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            System.out.println ( "Successfully Clicked The The Share Icon In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The The Share Icon In Solution Screen" );

            //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully Clicked The Copy link In Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Copy link In Solution Screen" );

            //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel buttonIn Solution Screen " );
            ScreenShot.captureScreenshot ( "Clicked The Cancel buttonIn Solution Screen" );

            // Clicking Like/Unlike Button

            try {
                try {
                    // Locate the like button
                    WebElement likeButton = driver.findElement ( By.xpath ( "//*[@class='like']" ) );
                    if (likeButton.isDisplayed ()) {
                        likeButton.click ();
                        System.out.println ( "Successfully Clicked The Like Button" );
                        ScreenShot.captureScreenshot ( "Clicked The Like Button" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );
                        if (unlikeButton.isDisplayed ()) {
                            unlikeButton.click ();
                            System.out.println ( "Successfully Clicked The Unlike Button" );
                            ScreenShot.captureScreenshot ( "Clicked The Unlike Button" );
                        }
                    } catch (NoSuchElementException e2) {
                        System.out.println ( "Unlike Button not found" );
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }
            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();
            System.out.println ( "Successfully Clicked The Comment Icon In Analysis Page" );
            ScreenShot.captureScreenshot ( "Clicked The Comment Icon In Analysis Page" );

            //Entering Comment In The TextField
            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );
            System.out.println ( "Successfully Entered The Comments" );
            ScreenShot.captureScreenshot ( "Enter The Comment In The Text Field" );

            // Clicking The Send Button In The Comment Text Field
//
//            Thread.sleep (2000);
//            clickingSendButton = driver.findElement (className ("anticon-send"));
//            clickingSendButton.click ();

            // Scrolling The analysis page Up
            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Page" );
            ScreenShot.captureScreenshot ( "Scrolling The analysis page Up" );

            // Clicking The Reattempt Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();
            System.out.println ( "Successfully clicked Reattemp Button" );
            ScreenShot.captureScreenshot ( "The Reattempt Button Inside The analysis page" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 5000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );
            ScreenShot.captureScreenshot ( "The Clicked Back Arrow" );

            // Clicking The Solution Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();
            System.out.println ( "Successfully clicked Solution Button In Analysis" );
            ScreenShot.captureScreenshot ( "The Clicked The Solution Button Inside The analysis page" );

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 10000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );
            ScreenShot.captureScreenshot ( "The Clicked the back arrow in the solution screen" );

            // Scrolling The analysis page Forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
            System.out.println ( "Successfully Scroll The Page Down " );
            ScreenShot.captureScreenshot ( "The Clicked analysis page Forward" );

            // Scrolling The analysis page Backward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Backwards " );
            ScreenShot.captureScreenshot ( "The Clicked The analysis page Backward" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
            Thread.sleep ( 5000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );
            ScreenShot.captureScreenshot ( "The Clicked Back To Quiz Breadcrumbs In The Analysis Page" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "The Clicked the Three Dots in the Course Card" );

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            ScreenShot.captureScreenshot ( "The Clicked the Share Button" );

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            ScreenShot.captureScreenshot ( "The Clicked the Copy Link Button" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            ScreenShot.captureScreenshot ( "The Clicked the Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "The Clicked ThreeDots" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            ScreenShot.captureScreenshot ( "The Clicked Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            ScreenShot.captureScreenshot ( "The Clicked Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );
            ScreenShot.captureScreenshot ( "Entered The Text Inside The Comment" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            ScreenShot.captureScreenshot ( "Clicked Cancel Button" );

//            // Clicking The report Button
//
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            ScreenShot.captureScreenshot ( "Clicked three Dots in the CourseCard" );

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();
            ScreenShot.captureScreenshot ( "Clicked The Remove My Notes" );

        } else {
            System.out.println ( "No matching condition was found in the Solution quiz My Notes." );
        }
    }
}

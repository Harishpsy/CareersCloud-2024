package MyCourse;

import PageObjectModule.Mynotespageobject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

public class courseFreeTab {

    WebDriver driver;

    public courseFreeTab(WebDriver driver) {

        this.driver = driver;
    }

    public void freeTab() throws InterruptedException {

        // Clicking Free Tab In the all course list page
        try {
            WebElement clickingFreeTab = driver.findElement ( By.xpath ( "//*[text()='Free']" ) );

            if (clickingFreeTab.isSelected ()) {
                System.out.println ( "Free Tab Is Already Selected, We Are Performing The Below Actions In The Free Tab List Page" );
            } else if (clickingFreeTab.isDisplayed ()) {
                clickingFreeTab = driver.findElement ( By.xpath ( "//*[text()='Free']" ) );
                clickingFreeTab.click ();
                System.out.println ( "Successfully Clicked The Free Tab, And Performing The action In The " );
            } else {
                System.out.println ( "Both The Code Has Not Executed In The All Course Free Tab" );
            }

        } catch (NoSuchElementException e) {
            System.out.println ( "Error In The All Course Free Tab: " + e.getMessage () );
        }

        /* Creating An Free Tab > Article Object, We Are Calling Article Sub-Module */
        courseFreeTab article = new courseFreeTab ( driver );
        article.artilces ();

        /* Creating An Free Tab > Ebook Object, We Are Calling Ebook Module */
        courseFreeTab ebook = new courseFreeTab ( driver );
        ebook.Ebooks ();
//
//        courseFreeTab videos = new courseFreeTab ( driver );
//        videos.videos ();
//
//        // Performing the start quiz action
//        courseFreeTab startquiz = new courseFreeTab ( driver );
//        startquiz.quizStart ();
//
//        //Performing The resume quiz
//        courseFreeTab resumequiz = new courseFreeTab ( driver );
//        resumequiz.resumeQuiz ();

        //Performing The Solutions Action
//        courseFreeTab solutionquiz = new courseFreeTab ( driver );
//        solutionquiz.quizSolutions ();


    }

    public void artilces() throws InterruptedException {

        PageFactory.initElements ( driver , Mynotespageobject.class );

        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );

        boolean ArticleDisplayed = false;

        try {
            WebElement ClickingArticle = driver.findElement ( xpath ( "//*[@class=\"image1\"]/following::*[text()='VIEW >']" ) );
            ArticleDisplayed = ClickingArticle.isDisplayed ();
            System.out.println ( "Article displayed In The Free Tab: " + ArticleDisplayed );
        } catch (NoSuchElementException e) {
            System.out.println ( "Article element not found In The Free Tab ." );
        }

        // Proceed with if-else logic
        if (ArticleDisplayed) {
            Thread.sleep ( 3000 );
            WebElement ClickingArticle = driver.findElement ( xpath ( "//*[@class=\"image1\"]/following::*[text()='VIEW >']" ) );
            ClickingArticle.click ();
            System.out.println ( "Successfully Clicked The Article In The Free Tab" );

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

//        // Clicking The send Button
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

            // Clicking Float button
            Thread.sleep ( 5000 );
            WebElement clickingFloatButton = driver.findElement ( xpath ( "//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]" ) );
            clickingFloatButton.click ();

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
            Thread.sleep ( 5000 );
            WebElement clickingBackButton = driver.findElement ( xpath ( "//*[@class=\"ant-breadcrumb-link\"]" ) );
            clickingBackButton.click ();
            System.out.println ( "Successfully clicked the back button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();

            /* Clicking the three Dots in the CourseCard */
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            System.out.println ( "Successfully CLicked The ThreeDots" );

            /* Click The Share Button */
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();
            System.out.println ( "Successfully CLicked The Share Button" );

            /* Clicking The Copy Link */
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();
            System.out.println ( "Successfully CLicked The Copy Link" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();
            System.out.println ( "Successfully CLicked The Cancel Button" );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();
            System.out.println ( "Successfully CLicked The Three Dots" );

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();
            System.out.println ( "Successfully CLicked The Report Button" );

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();
            System.out.println ( "Successfully CLicked The Radio Button" );

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();
            System.out.println ( "Successfully CLicked The Cancel Button" );

//            // Clicking The report Button
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

        } else {
            System.out.println ( "Article Was Not Present In The Free Tab, So Skippikg The Article Module and moving To Next Module " );
        }
    }

    public void Ebooks() throws InterruptedException {

        Thread.sleep ( 5000 ); // Waiting For The Element Visible
        boolean EbookDisplayed = false;

        try {
            WebElement checkingEbookDisplay = driver.findElement ( xpath ( "//*[text()='VIEW >']/parent::*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]/following::*[@alt=\"ebook\"]" ) );
            EbookDisplayed = checkingEbookDisplay.isDisplayed ();
            System.out.println ( "Ebook displayed In The Free Tab: " + EbookDisplayed );
        } catch (NoSuchElementException e) {
            System.out.println ( "Ebook element not found In The Free Tab ." );
        }

        if (EbookDisplayed) {
            Thread.sleep ( 3000 );
            WebElement clickingViewButton = driver.findElement ( xpath ( "//*[text()='VIEW >']/parent::*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]/following::*[@alt=\"ebook\"]" ) );
                clickingViewButton.click ();
            System.out.println ( "SuccessFully Clicked The view Button In The Free Tab List Page" );

                // Getting The Clicked Ebook Name
            Thread.sleep ( 3000 );
                WebElement gettingEbookName = driver.findElement ( xpath ( "//*[@class=\"ant-typography text css-xu9wm8\"]" ) );
                String EbookName = gettingEbookName.getText ();
                System.out.println ( "Ebook Name: " + EbookName );

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
                // Clicking The View Button In The Ebook
                Thread.sleep ( 3000 );
            WebElement clickingViewButtonInEbook = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary button\"]" ) );
                clickingViewButtonInEbook.click ();
                System.out.println ( "SuccessFully Clicked The View Button In Ebook " );

                //Windows Handeling child to parent
                Thread.sleep ( 5000 );
                Set<String> windows = driver.getWindowHandles ();
                Iterator<String> it = windows.iterator ();
                String parent = it.next ();
                String child = it.next ();
                driver.switchTo ().window ( child );
                driver.close ();
                driver.switchTo ().window ( parent );

                // Clicking Back Button in the Ebook Page
                Thread.sleep ( 5000 );
                WebElement clickingBackButton = driver.findElement ( xpath ( "//span[text()='Back']" ) );
                clickingBackButton.click ();
                System.out.println ( "SuccessFully Clicked The BackButton " );

                // Clicking The Three dots
                Thread.sleep ( 3000 );
                WebElement Threedots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[1]" ) );
                Threedots.click ();

                // Clicking The save My Notes OR Remove My Notes
                WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) ); // 30 seconds timeout

                try {
                    Thread.sleep ( 3000 );
                    WebElement saveMyEbookElement = wait.until ( ExpectedConditions.visibilityOfElementLocated ( xpath ( "(//*[@class=\"ant-dropdown-menu-title-content\"])[1]" ) ) );
                    if (saveMyEbookElement.isDisplayed ()) {
                        saveMyEbookElement.click ();
                    }
                } catch (java.util.NoSuchElementException | TimeoutException e) {
                    System.out.println ( "Save Or Remove My Ebook is not displayed." );
                }

                // Clicking The Three dots
                Thread.sleep ( 3000 );
                Threedots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[1]" ) );
                Threedots.click ();

                /* Clicking the share icon in My Ebook */
                Thread.sleep ( 3000 );
                WebElement Share_icon = driver.findElement ( xpath ( "//span[text()='Share']" ) );
                Share_icon.click ();

                //click the copy link in the share popup
                Thread.sleep ( 3000 );
                WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 30 ) );
                WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

                // Again Click the three dots in the My Ebook
                Thread.sleep ( 3000 );
                WebElement Three_dots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[1]" ) );
                Three_dots.click ();

                //clicking the report icon
                Thread.sleep ( 3000 );
                WebElement Report_icon = driver.findElement ( xpath ( "//span[text()='Report']" ) );
                Report_icon.click ();
                System.out.println ( "SuccessFully Clicked The Report icon" );

                //Click the wrong information radio button
                Thread.sleep ( 3000 );
                WebElement Wronginformationradiobutton = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
                Wronginformationradiobutton.click ();
                System.out.println ( "SuccessFully Clicked The Wrong information radio button" );

                //Entering the text inside the report text field
                WebElement Enterthereport = driver.findElement ( name ( "reportDescription" ) );
                Enterthereport.sendKeys ( "Checking The text was Entering In The Report Text Field" );

                // Click the report button
        /* Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

                // Clicking The Cancel Button
                Thread.sleep ( 3000 );
                Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
                Cancel_button.click ();
                System.out.println ( "SuccessFully Clicked The Cancel Button" );

                // Clicking The Course BreadCrumbs
                Thread.sleep ( 3000 );
                WebElement clickingBreadcrumbs = driver.findElement ( xpath ( "//*[text()='Course']" ) );
                clickingBreadcrumbs.click ();
            } else {
            System.out.println ( "Ebook Element Is Not Present In The Free Tab, Skipping and Moveing To Next Module  Is Not Clicked In The Free Tab Error Has Been Occured" );
            }
    }

    public void videos() throws InterruptedException {

        // Check if noRecordFound element is displayed and log the result
        PageFactory.initElements ( driver , Mynotespageobject.class );

        Thread.sleep ( 5000 );
        boolean videosDisplayedInMyNotes = false;

        try {
            WebElement clickingVideos = driver.findElement ( xpath ( "" ) );
            videosDisplayedInMyNotes = clickingVideos.isDisplayed ();
            System.out.println ( "videos Displayed In The Free Tab: " + videosDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "videos element not found In The Free Tab ." );
        }

        // Verifying with the if else statement

        if (videosDisplayedInMyNotes) {

            // Clicking the videos In The Free Tab list page
            Thread.sleep ( 5000 );
            WebElement clickingVideos = driver.findElement ( xpath ( "" ) );
            clickingVideos.click ();
            System.out.println ( "Successfully Clicked the videos " );

            // Clicking the like and unlike button

            WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

            if (clickAction.isDisplayed ()) {
                clickAction.click ();

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

            // Entering The comments

            Thread.sleep ( 3000 );
            WebElement enteringComments = driver.findElement ( name ( "comments1" ) );
            enteringComments.sendKeys ( "Thanks For the update" );
            System.out.println ( "Comment Added Sucessfully" );

//            // Clicking The send Button
//
//            Thread.sleep ( 3000 );
//            WebElement clickingSendButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-send\"]" ) );
//            clickingSendButton.click ();

            // Clicking the share icon

            Thread.sleep ( 5000 );
            WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@class=\"share\"]" ) );
            clickingshareicon.click ();

            //click the copy link in the share popup

            Thread.sleep ( 5000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();

            //Clicking the cancel button in the in share popup

            Thread.sleep ( 3000 );
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Clicked cancel button" );

            // Clicking The Pause Button In The Viedos

            driver.switchTo ().frame ( 0 );
            Thread.sleep ( 3000 );
            WebElement clickingPauseButton = driver.findElement ( xpath ( "//*[@title=\"Pause (k)\"]" ) );
            clickingPauseButton.click ();
            System.out.println ( "SucessFully Clicked Paused button" );

            // Click the mute button in the video

            WebElement clickingMuteButton = driver.findElement ( xpath ( "//*[@title=\"Mute (m)\"]" ) );
            clickingMuteButton.click ();
            System.out.println ( "SucessFully Clicked Mute button" );

            // Clicking The Caption button

            WebElement clickingCaptionButton = driver.findElement ( xpath ( "//*[@title=\"Subtitles/closed captions (c)\"]" ) );
            clickingCaptionButton.click ();
            System.out.println ( "SucessFully Clicked Caption (ON) button" );

            // Clicking the Full screen Button

            Thread.sleep ( 3000 );
            WebElement clickingFullScreenButton = driver.findElement ( xpath ( "//*[@title=\"Full screen (f)\"]" ) );
            clickingFullScreenButton.click ();
            System.out.println ( "SucessFully Clicked The Full Screen Button" );

            // Clicking the Exit The Full-screen Button

            Thread.sleep ( 3000 );
            WebElement clickingExitFullScreenButton = driver.findElement ( xpath ( "//*[@title=\"Exit full screen (f)\"]" ) );
            clickingExitFullScreenButton.click ();
            System.out.println ( "SucessFully Clicked The Exit Full Screen Button" );


            // Clicking the YouTube Logo It will navigate to YouTube or new windows

            Thread.sleep ( 3000 );
            WebElement clickingYouTubeLogo = driver.findElement ( xpath ( "//*[@title=\"Watch on YouTube\"]" ) );
            clickingYouTubeLogo.click ();
            System.out.println ( "SucessFully Clicked The YouTube Logo " );

            // Windows Handeling

            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Navigating to viedos Page
            Thread.sleep ( 3000 );
            driver.close ();

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

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();

//            // Clicking The report Button
//
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();

        } else {
            System.out.println ( "Both are was not executed for videos In The Free Tab" );
        }
    }

    public void quizStart() throws InterruptedException {

        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean noRecordfoundDisplayedInQuizListPage = false;
        boolean quizStartDisplayed = false;

        try {
            WebElement noRecordFound = driver.findElement ( xpath ( "//*[text()='No Records Found.']" ) );
            noRecordfoundDisplayedInQuizListPage = noRecordFound.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In All QUiz Page." );
        }

        try {
            WebElement startquizDispayed = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block quiz-attempt0-button\"]/child::*[text()='Start Quiz ']" ) );
            quizStartDisplayed = startquizDispayed.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "StartQuiz element not found In The Quiz List Page." );
        }

        // Log the visibility status of each element
        System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInQuizListPage );
        System.out.println ( "StartQuiz displayed Free Tab : " + quizStartDisplayed );

        // Perform actions based on which element is visible
        if (noRecordfoundDisplayedInQuizListPage) {
            System.out.println ( "No records found message is displayed In All Quiz List Page" );
        } else if (quizStartDisplayed) {
            Thread.sleep ( 5000 );
            WebElement startquizDispayed = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block quiz-attempt0-button\"]/child::*[text()='Start Quiz ']" ) );
            startquizDispayed.click ();
            System.out.println ( "Successfully clicked the Start button in The All Tab In The quiz Module." );

            //Windows Handeling
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Clicking the close icon in the quiz instruction
            Thread.sleep ( 30000 );
            WebElement Close_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            Close_icon.click ();
            System.out.println ( "SuccessFully Clicked The CloseIcon" );

            // Getting The Quiz Name For Verify In The Paused Tab From The All Tab
            Thread.sleep ( 3000 );
            WebElement gettingQuizTitle = driver.findElement ( xpath ( "//span[@class=\"title\"]" ) );
            String QuizTitle = gettingQuizTitle.getText ();
            System.out.println ( "Quiz Title Name From The All Tab: " + QuizTitle );

            //Windows mazimize
            WebDriverWait waitForWindowsMaximize;
            waitForWindowsMaximize = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button
            Thread.sleep ( 10000 );
            WebElement clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "SuccessFully Clicked The InstructionIcon" );

            // Again Clicking the close icon in the quiz instruction
            Thread.sleep ( 3000 );
            WebElement againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();
            System.out.println ( "SuccessFully Clicked The Close_icon again " );

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "SuccessFully Clicked The Full Screen Button " );

            // Clicking the BookMark-icon
            try {
                WebElement bookmarkIcon = driver.findElement ( By.xpath ( "//*[@class='bookmark-icon']" ) );
                if (bookmarkIcon.isDisplayed ()) {
                    bookmarkIcon.click ();
                    System.out.println ( "Successfully Clicked The Bookmark Icon" );
                }
            } catch (NoSuchElementException e1) {
                try {
                    WebElement bookmarkedIcon = driver.findElement ( By.xpath ( "//*[@class='bookmarked-icon']" ) );
                    if (bookmarkedIcon.isDisplayed ()) {
                        bookmarkedIcon.click ();
                        System.out.println ( "Successfully Un-Clicked The Bookmark Icon" );
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

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( By.xpath ( "//div[text()='" + options[i] + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + options[i] );

                Thread.sleep ( 3000 );
                WebElement numberOnRightSide = driver.findElement ( By.xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "Successfully Clicked The Number: " + (16 + i) );
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            WebElement clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();

            // Clicking The Pause Button
            Thread.sleep ( 3000 );
            WebElement clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();

            // Clicking The Cancel Button In The Pause popup
            Thread.sleep ( 3000 );
            WebElement clickingCancelButtonInPopup = driver.findElement ( xpath ( "//*[text()=' Cancel ']" ) );
            clickingCancelButtonInPopup.click ();

            // Getting The User Answered Count
            Thread.sleep ( 3000 );
            WebElement gettingAnswerCountBeforepause = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
            String AnswerCountBeforepause = gettingAnswerCountBeforepause.getText ();
            System.out.println ( "Answered Question Count Before Pause : " + AnswerCountBeforepause );

            // Getting The Unanswered Count
            Thread.sleep ( 3000 );
            WebElement gettingUnAnsweredCountBeforepause = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgba(90, 114, 200, 0.2); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(0, 0, 0); font-weight: 900;\"]" ) );
            String UnAnswerCountBeforepause = gettingUnAnsweredCountBeforepause.getText ();
            System.out.println ( "User Unanswered Count Before Pause : " + UnAnswerCountBeforepause );

            // Getting The quiz Time
            Thread.sleep ( 3000 );
            WebElement getGettingQUizTimeBeforepause = driver.findElement ( xpath ( "//span[@class=\"text\"]" ) );
            String QuizTimeBeforepause = getGettingQUizTimeBeforepause.getText ();
            System.out.println ( "quiz Time Before pause: " + QuizTimeBeforepause );

            // Again Clicking The Pause Button leaves the quiz
            Thread.sleep ( 3000 );
            clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();

            // Clicking The Leave button In the Pause Popup
            Thread.sleep ( 3000 );
            WebElement clickingLeaveButtonInPopup = driver.findElement ( xpath ( "//span[text()=\" Leave \"]" ) );
            clickingLeaveButtonInPopup.click ();

            // Changing The Child Windows To Parent Window
            driver.switchTo ().window ( parent );

            // Click the paused Tab
            try {
                WebElement clickingPausedTab = driver.findElement ( xpath ( "//*[text()='Paused']" ) );

                if (clickingPausedTab.isDisplayed ()) {
                    clickingPausedTab.click ();
                    System.out.println ( "Successfully clicked The Paused Tab " );

                    // Scrolling The Paused Tab
                    int numberOfTimesScrollQuizzes = 5;

                    for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
                        try {
                            Thread.sleep ( 5000 );
                            JavascriptExecutor jse = (JavascriptExecutor) driver;
                            jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                            System.out.println ( "Successfully scroll The page In The paused Tab " + (i + 1) + " time(s)." );
                        } catch (Exception scroll) {
                            System.out.println ( "Failed to Scroll The Paused Tab: " + scroll.getMessage () );
                        }
                    }

                    // Clicking Float Icon
                    try {
                        WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
                        if (clickingFloatIcon.isDisplayed ()) {
                            clickingFloatIcon.click ();
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println ( "FloatIcon Button Is Not Displayed" );
                    }

                    // Getting the Quiz Title Name to check whether completed quiz from paused was showing in Attempted or not

                    // Find all elements matching the XPath and store them in a list
                    List<WebElement> gettingQuizTitles = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );
                    Thread.sleep ( 5000 );

                    // Iterate through the list and print the text of each element
                    boolean matchFound = false;
                    for (WebElement quizTitle : gettingQuizTitles) {
                        String quiztitleText = quizTitle.getText ();

                        // Verifying the All Tab quiz was showing or not in the Paused Tab
                        if (QuizTitle.equals ( quiztitleText )) {
                            matchFound = true;
                            System.out.println ( "Verification Passed: Quiz Title In Paused (" + QuizTitle + ") matches Quiz Title In Attempted Tabs (" + quiztitleText + ")" );
                        }
                    }
                    // Verifying That the Both the Titles are equal
                    Assert.assertTrue ( matchFound , "No matching quiz title found in the attempted list." );

                } else {
                    System.out.println ( "Passed Tab Was Not Clicked, we are SKipping" );
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Passed Tab Is Not Present, So We Are Skipping This Action" );
            }

            //Performing The resume quiz
            CourseQuizzes resumequiz = new CourseQuizzes ( driver );
            resumequiz.resumeQuiz ();

        } else {
            System.out.println ( "No matching condition was found in the Start quiz My Notes." );
        }
    }

    public void resumeQuiz() throws InterruptedException {

        PageFactory.initElements ( driver , Mynotespageobject.class );

        System.out.println ( "----------------------Resume Quiz---------------------------" );
        boolean noRecordfoundDisplayedInQuizListPage = false;
        boolean quizresumeDisplayedInQuizListPage = false;

        try {
            WebElement noRecordFound = driver.findElement ( xpath ( "//*[text()='No Records Found.']" ) );
            noRecordfoundDisplayedInQuizListPage = noRecordFound.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In The quiz List Page." );
        }

        try {
            WebElement resumequiz = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt2-button\"]/child::span[text()='Resume ']" ) );
            quizresumeDisplayedInQuizListPage = resumequiz.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "ResumeQuiz element not found In The quiz List Page." );
        }

        System.out.println ( "noRecordFound displayed In The quiz List Page: " + noRecordfoundDisplayedInQuizListPage );
        System.out.println ( "ResumeQuiz displayed In The quiz List Page: " + quizresumeDisplayedInQuizListPage );

        if (noRecordfoundDisplayedInQuizListPage) {
            WebElement clickingUnAttemptedTab = driver.findElement ( xpath ( "//*[text()='Unattempted']" ) );
            clickingUnAttemptedTab.click ();
            System.out.println ( "No record was found, So Navigating to The UnAttempted Tab " );

        } else if (quizresumeDisplayedInQuizListPage) {

            Thread.sleep ( 3000 );
            WebElement resumequiz = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt2-button\"]/child::span[text()='Resume ']" ) );
            resumequiz.click ();
            System.out.println ( "Successfully clicked the Resume button In The quiz List Page." );

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

            // Again Clicking the close icon in the quiz instruction
            Thread.sleep ( 5000 );
            WebElement againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();

            // Clicking The FullScreen Button
            Thread.sleep ( 2000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Clicking the BookMark-icon
            try {
                WebElement bookmarkIcon = driver.findElement ( By.xpath ( "//*[@class='bookmark-icon']" ) );
                if (bookmarkIcon.isDisplayed ()) {
                    bookmarkIcon.click ();
                    System.out.println ( "Successfully Clicked The Bookmark Icon" );
                }
            } catch (NoSuchElementException e1) {
                try {
                    WebElement bookmarkedIcon = driver.findElement ( By.xpath ( "//*[@class='bookmarked-icon']" ) );
                    if (bookmarkedIcon.isDisplayed ()) {
                        bookmarkedIcon.click ();
                        System.out.println ( "Successfully Un-Clicked The Bookmark Icon" );
                    }
                } catch (NoSuchElementException e2) {
                    System.out.println ( "Both The Code Has Not Executed" );
                }
            }

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

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
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

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (16 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (16 + i) );
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

            // Clicking The Submit Button
            Thread.sleep ( 3000 );
            WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();

            // Clicking the Cancel Button In the submit Popup
            Thread.sleep ( 1000 );
            WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();

            // Getting The Quiz Name For Verify In The Paused Tab From The All Tab
            Thread.sleep ( 3000 );
            WebElement gettingQuizTitle = driver.findElement ( xpath ( "//span[@class=\"title\"]" ) );
            String QuizTitle = gettingQuizTitle.getText ();
            System.out.println ( "Quiz Title Name From The Paused Tab: " + QuizTitle );

            // Again Clicking The Submit Button
            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();

            // Clicking The Submit Button In The Submit Popup
            Thread.sleep ( 1000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=\"Submit\"]" ) );
            clickingSubmitButton.click ();

            // Switching Windows From Child To Parent
            driver.switchTo ().window ( parent );

            // Clicking Te attempted Tab

            try {

                WebElement clickingAttemptedTab = driver.findElement ( xpath ( "//*[text()='Attempted']" ) );

                if (clickingAttemptedTab.isDisplayed ()) {
                    clickingAttemptedTab.click ();
                    System.out.println ( "Successfully clicked The attempted Tab" );

                    // Scrolling The Attempted Tab
                    int numberOfTimesScrollQuizzes = 5;

                    for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
                        try {
                            Thread.sleep ( 5000 );
                            JavascriptExecutor jse = (JavascriptExecutor) driver;
                            jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                            System.out.println ( "Successfully scroll The page In the Attempted" + (i + 1) + " time(s)." );
                        } catch (Exception scroll) {
                            System.out.println ( "Failed to Scroll The Page In The Attempted: " + scroll.getMessage () );
                        }
                    }
                    // Clicking Float Icon
                    try {
                        WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
                        if (clickingFloatIcon.isDisplayed ()) {
                            clickingFloatIcon.click ();
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println ( "FloatIcon Button Is Not Displayed" );
                    }

                    // Find all elements matching the XPath and store them in a list
                    List<WebElement> gettingQuizTitles = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );
                    Thread.sleep ( 5000 );

                    // Iterate through the list and print the text of each element
                    boolean matchFound = false;
                    for (WebElement quizTitle : gettingQuizTitles) {
                        String quiztitleText = quizTitle.getText ();
//              System.out.println ( "Quiz Title " + quiztitleText );

                        // Verifying the All Tab quiz was showing or not in the Paused Tab
                        if (QuizTitle.equals ( quiztitleText )) {
                            matchFound = true;
                            System.out.println ( "Verification Passed: Quiz Title In Paused (" + QuizTitle + ") matches Quiz Title In Attempted Tabs (" + quiztitleText + ")" );
                        }
                    }
                    // Verifying That the Both the Titles are equal
                    Assert.assertTrue ( matchFound , "No matching quiz title found in the attempted list." );

                } else {
                    System.out.println ( "Attempted Tab Action Was Not Present, So We Are Skippig" );
                }
            } catch (NoSuchElementException e1) {
                System.out.println ( "Attempted Tab Is Not Displayed, So We Are Skipping And Performing The Next Action" );
            }

            //Performing The Solutions Action
            CourseQuizzes solutionquiz = new CourseQuizzes ( driver );
            solutionquiz.quizSolution ();

        } else {
            System.out.println ( "No matching condition was found in the Resume quiz In The quiz List Page." );
        }

    }

    public void quizSolutions() throws InterruptedException {

        System.out.println ( "-----------------------Solutions---------------------------" );
        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean quizsolutionDisplayedInAllQuiz = false;

        try {
            WebElement quizsolution = driver.findElement ( xpath ( "(//*[text()='Solution '])[1]" ) );
            quizsolutionDisplayedInAllQuiz = quizsolution.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Solution button element not found In The quiz List Page." );
        }

        // Log the visibility status of each element
        System.out.println ( "Solution button displayed In The quiz List Page: " + quizsolutionDisplayedInAllQuiz );

        if (quizsolutionDisplayedInAllQuiz) {

            //Clicking The Solution Button
            WebElement quizsolution = driver.findElement ( xpath ( "(//*[text()='Solution '])[1]" ) );
            quizsolution.click ();
            System.out.println ( "Successfully clicked the Solution button In The quiz List Page." );

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 30000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report\"]" ) );
            Actions actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            WebElement clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();

            // Clicking The Report Description button
            WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

            // Clicking The Cancel Button
            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();

            // Scrolling and Clicking The Report Page
            Thread.sleep ( 3000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();

            // Clicking The Report Description button
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();

            // Clicking The ReattempButton
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period3." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred In The Reattempted Button: " + e.getMessage () );
            }

            // Define the options to be clicked
            String[] options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" ,};

            // Locate the Next button
            Thread.sleep ( 20000 );
            WebElement NextButton = driver.findElement ( xpath ( "//*[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );

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

                    Thread.sleep ( 3000 );

                    // Try to find and click the number on the right side
                    List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (12 + i) + "']" ) );
                    if (!numberOnRightSideList.isEmpty ()) {
                        WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                        numberOnRightSide.click ();
                        System.out.println ( "Successfully clicked the number and navigated to the next question: " + (12 + i) );
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

            // Scrolling The Solution Page
            Thread.sleep ( 1000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();

            // Click The Translation Error In The Report Popup
            Thread.sleep ( 3000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();

            //Entering the text inside the report text field In Solution Page
            Thread.sleep ( 3000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

            // Click the report button
            Thread.sleep ( 3000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();

            // Clicking The Cancel Button
            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();

            // Clicking The Share Icon In The Solution Page
            Thread.sleep ( 3000 );
            WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();

            //Clicking the cancel button in the in share popup
            WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();

            // Clicking The ReattempButton
            Thread.sleep ( 15000 );
            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class=\"ant-switch ant-switch-small css-xu9wm8 ant-switch-checked\"]" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period4." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " );
            }

//            //  Click the back arrow in the solution screen
//            Thread.sleep ( 3000 );
//            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@data-icon=\"arrow-left\"]" ) );
//            clickingBackArrow.click (); // Back Arrow was not working for first time

            // Clicking The Analysis Button
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "(//*[text()='Analysis '])[1]" ) );
            clickingAnalysisButton.click ();

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-expand\"]" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );

            // Exiting The FullScreen Button
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button In Solution Screen " );

            // Clicking The share Icon
            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            System.out.println ( "Successfully Clicked The The Share Icon In Solution Screen " );

            //click the copy link in the share popup
            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully Clicked The Copy link In Solution Screen " );

            //Clicking the cancel button in the in share popup
            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel buttonIn Solution Screen " );

            // Clicking Like/Unlike Button
            try {
                try {
                    // Locate the like button
                    WebElement likeButton = driver.findElement ( By.xpath ( "//*[@class='like']" ) );
                    if (likeButton.isDisplayed ()) {
                        likeButton.click ();
                        System.out.println ( "Successfully Clicked The Like Button" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );
                        if (unlikeButton.isDisplayed ()) {
                            unlikeButton.click ();
                            System.out.println ( "Successfully Clicked The Unlike Button" );
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

            //Entering Comment In The TextField
            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );
            System.out.println ( "Successfully Entered The Comments" );

            // Clicking The Send Button In The Comment Text Field
//            Thread.sleep (2000);
//            clickingSendButton = driver.findElement (className ("anticon-send"));
//            clickingSendButton.click ();

            // Scrolling The analysis page Up
            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Page" );

            // Clicking The Reattempt Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();
            System.out.println ( "Successfully clicked Reattemp Button" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 5000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );

            // Clicking The Solution Button Inside The analysis page
            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();
            System.out.println ( "Successfully clicked Solution Button In Analysis" );

            //  Again Click the back arrow in the solution screen
            Thread.sleep ( 10000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked clicking Back Arrow" );

            // Scrolling The analysis page Forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
            System.out.println ( "Successfully Scroll The Page Down " );

            // Scrolling The analysis page Backward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Backwards " );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
            Thread.sleep ( 5000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 10000 );
            WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );// Page was loading for long time Need more Time
            clickingThreeDots.click ();

            // Click The Share Button
            Thread.sleep ( 2000 );
            WebElement clickingShareButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[2]" ) );
            clickingShareButton.click ();

            // Clicking The Copy Link
            Thread.sleep ( 3000 );
            WebElement clickingCopyLink = driver.findElement ( xpath ( "//*[text()='COPY LINK']" ) );
            clickingCopyLink.click ();

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancelButton = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            clickingCancelButton.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Report Button
            Thread.sleep ( 3000 );
            WebElement clickingReportButton = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[3]" ) );
            clickingReportButton.click ();

            // Click The Radio Button which present in second Position
            Thread.sleep ( 3000 );
            WebElement clickingRadioButton = driver.findElement ( xpath ( "//*[@value=\"2\"]" ) );
            clickingRadioButton.click ();

            // Entering The Text Inside the Text Field
            Thread.sleep ( 3000 );
            WebElement enteringText = driver.findElement ( xpath ( "//*[@class=\"ant-input css-xu9wm8\"]" ) );
            enteringText.sendKeys ( "The content was good" );

            // Clicking The cancel Button
            Thread.sleep ( 3000 );
            WebElement clickingCancel = driver.findElement ( xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[1]" ) );
            clickingCancel.click ();

//            // Clicking The report Button
//            WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//            clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Save My Notes or Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();

        } else {
            System.out.println ( "No matching condition was found in the Solution quiz In The quiz List Page." );
        }
    }

}

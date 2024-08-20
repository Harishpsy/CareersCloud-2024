package Menu;

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

import static PageObjectModule.Mynotespageobject.*;
import static org.openqa.selenium.By.*;

public class Menu_MyNotes {
    WebDriver driver;

    public Menu_MyNotes(WebDriver driver) {
        this.driver = driver;
    }

    public void MyNotes() throws InterruptedException {

        //Then click the MyNote

        PageFactory.initElements ( driver , Mynotespageobject.class );

        Thread.sleep ( 5000 );
        MyNotes.click ();
        System.out.println ( "Successfully CLicked The My Notes Button" );

    }

    public void artilce() throws InterruptedException {

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
        } else if (ArticleDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingArticle.click ();
            System.out.println ( "Successfully Clicked The Three dots In The My Notes" );

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
//
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
            System.out.println ( "Navigated To Article List Page" );

        } else {

            System.out.println ( "Both The Code Has Not Executed In The My Notes for article " );
        }
    }

    public void videos() throws InterruptedException {

        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean videosDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
            System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes ." );
        }

        try {
            videosDisplayedInMyNotes = clickingVideos.isDisplayed ();
            System.out.println ( "videos Displayed In My Notes: " + videosDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "videos element not found In My Notes ." );
        }

        // Verifying with the if else statement

        if (noRecordfoundDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingMyQuestion.click ();
            System.out.println ( "No records found message is displayed In My Notes, navigating to My Question page." );
        } else if (videosDisplayedInMyNotes) {

            // Clicking the videos in the my notes list page
            Thread.sleep ( 5000 );
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
                    System.out.println ( "Found: " + uniquevideosurlcount + "-->" + actualUrls );
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
        } else {
            System.out.println ( "Both are was not executed for videos in my notes" );
        }
    }

    public void quiz() throws InterruptedException {
        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );
        boolean noRecordfoundDisplayedInMyNotes = false;
        boolean quizStartDisplayedInMyNotes = false;
        boolean quizresumeDisplayedInMyNotes = false;
        boolean quizsolutionDisplayedInMyNotes = false;

        try {
            noRecordfoundDisplayedInMyNotes = noRecordfoundMyNotes.isDisplayed ();
            System.out.println ( "noRecordFound displayed In My Notes: " + noRecordfoundDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In My Notes ." );
        }

        try {
            quizStartDisplayedInMyNotes = clickingStartQuiz.isDisplayed ();
            System.out.println ( "StartQuiz displayed In My Notes: " + quizStartDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "StartQuiz element not found In My Notes ." );
        }
        try {
            quizStartDisplayedInMyNotes = clickingResumequiz.isDisplayed ();
            System.out.println ( "Resumequiz displayed In My Notes: " + quizStartDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "Resumequiz element not found In My Notes ." );
        }
        try {
            quizStartDisplayedInMyNotes = clickingSolutionquiz.isDisplayed ();
            System.out.println ( "Solution button displayed In My Notes: " + quizStartDisplayedInMyNotes );
        } catch (NoSuchElementException e) {
            System.out.println ( "Solution button element not found In My Notes ." );
        }

        if (noRecordfoundDisplayedInMyNotes) {
            clickingMyQuestion.click ();
            System.out.println ( "No records found message is displayed In My Notes, navigating to My Question page." );
        } else if (quizStartDisplayedInMyNotes) {
            Thread.sleep ( 5000 );
            clickingStartQuiz.click ();
            System.out.println ( "Successfully clicked the Start button in the My Notes" );

            //Windows Handeling

            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Clicking the close icon in the quiz instruction

            WebDriverWait wait1 = new WebDriverWait ( driver , Duration.ofSeconds ( 60 ) );
            WebElement closeIcon = wait1.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class=\"ant-modal-close\"]" ) ) );
            closeIcon.click ();
            System.out.println ( "SuccessFully Clicked The CloseIcon" );

            //Windows mazimize

            WebDriverWait waitForWindowsMaximize;
            waitForWindowsMaximize = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button

            Thread.sleep ( 3000 );
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
                WebElement bookmarkIcon = driver.findElement ( xpath ( "//*[@class='bookmark-icon']" ) );
                if (bookmarkIcon.isDisplayed ()) {
                    bookmarkIcon.click ();
                    System.out.println ( "Successfully Clicked The Bookmark Icon" );
                }
            } catch (NoSuchElementException e1) {
                try {
                    WebElement bookmarkedIcon = driver.findElement ( xpath ( "//*[@class='bookmarked-icon']" ) );
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

            // Clicking The Pause Button

            Thread.sleep ( 3000 );
            WebElement clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();

            // Clicking The Cancel Button In The Pause popup

            Thread.sleep ( 3000 );
            WebElement clickingCancelButtonInPopup = driver.findElement ( xpath ( "//*[text()=' Cancel ']" ) );
            clickingCancelButtonInPopup.click ();

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

            // Clicking the Resume quiz

            Thread.sleep ( 5000 );
            clickingResumequiz.click ();
            System.out.println ( " Clicked The resume quiz " );

            //Windows Handeling

            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );

            //Windows mazimize

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            // Clicking The Submit Button

            Thread.sleep ( 3000 );
            WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();

            // Clicking the Cancel Button In the submit Popup

            Thread.sleep ( 1000 );
            WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();

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

            // Clicking The solution button

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[1]" ) );
            clickingSolutionButton.click ();

            // Scrolling and Clicking The Report Page

            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
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

            Thread.sleep ( 7000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

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
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
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

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

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

            Thread.sleep ( 5000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen

            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();

            // Clicking The solution button

            Thread.sleep ( 2000 );
            clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
            clickingSolutionButton.click ();

            // Analysis was not working in site

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            WebElement clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The FullScreen Button

            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Exiting The FullScreen Button

            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The Share Icon In The Analysis Page

            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();

            //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();

            //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();

            // Clicking Like/Unlike Button

            try {
                // Locate the like and unlike buttons
                WebElement likeButton = driver.findElement ( xpath ( "//*[@class='like']" ) );
                WebElement unlikeButton = driver.findElement ( xpath ( "//*[@class='unlike']" ) );

                // Check if the like button is displayed and click it
                if (likeButton.isDisplayed ()) {
                    likeButton.click ();
                    System.out.println ( "Successfully Clicked The Like Button" );
                }
                // Otherwise, check if the unlike button is displayed and click it
                else if (unlikeButton.isDisplayed ()) {
                    unlikeButton.click ();
                    System.out.println ( "Successfully Clicked The Unlike Button" );
                }
                // If neither button is found/displayed
                else {
                    System.out.println ( "Both Code Not Executed" );
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }

            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();

            //Entering Comment In The TextField

            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );

//                // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();

            // Scrolling The analysis page Up

            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Reattempt Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Clicking The Solution Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Scrolling The analysis page Forward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

            // Scrolling The analysis page Backward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            //  Clicking the back arrow in the solution screen for coming to course > Quiz

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

        } else if (quizresumeDisplayedInMyNotes) {
            Thread.sleep ( 3000 );
            clickingResumequiz.click ();
            System.out.println ( "Successfully clicked the Resume button in the My Notes" );

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

            Thread.sleep ( 3000 );
            WebElement clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "Sucessfully clicked instruction icon" );

            // Again Clicking the close icon in the quiz instruction

            Thread.sleep ( 3000 );
            WebElement againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();

            // Clicking The FullScreen Button

            Thread.sleep ( 2000 );
            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Clicking the BookMark-icon

                /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                 WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
                 bookMarkicon.click ();*/

            // Define the options to be clicked
            String[] options = new String[]{"A" , "B" , "C" , "D" , "E" , "B" , "A" , "B" , "E" , "D" , "C" , "E" , "C" , "A" , "E" ,};

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
                System.out.println ( "Successfully Clicked The Number and Navigated To The Next Question: " + (16 + i) );
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            WebElement clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();

            // Clicking The Pause Button

            Thread.sleep ( 3000 );
            WebElement clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();

            // Clicking The Leave button In the Pause Popup

            Thread.sleep ( 3000 );
            WebElement clickingLeaveButtonInPopup = driver.findElement ( xpath ( "//span[text()=\" Leave \"]" ) );
            clickingLeaveButtonInPopup.click ();

            // Changing The Child Windows To Parent Window

            driver.switchTo ().window ( parent );

            // Clicking The Resume Button In the quiz

            Thread.sleep ( 3000 );
            WebElement clickingResumeButton = driver.findElement ( xpath ( " (//span[text()=' Resume '])[1]" ) );
            clickingResumeButton.click ();

            //Windows Handeling child

            Thread.sleep ( 3000 );
            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );

            // Clicking The Submit Button

            Thread.sleep ( 3000 );
            WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
                clickingSubmitButton.click ();

                // Clicking the Cancel Button In the submit Popup

            Thread.sleep ( 1000 );
            WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();

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

            // Clicking The solution button

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[1]" ) );
            clickingSolutionButton.click ();

            // Scrolling and Clicking The Report Page

            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
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

            Thread.sleep ( 7000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( By.xpath ( "//div[text()='Save & Next']" ) );

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
            clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
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

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

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

            Thread.sleep ( 5000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen

            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();

            // Clicking The solution button

            Thread.sleep ( 2000 );
            clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
            clickingSolutionButton.click ();

            // Analysis was not working in site

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            WebElement clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The FullScreen Button

            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Exiting The FullScreen Button

            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The Share Icon In The Analysis Page

            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
                clickingTheShareIcon.click ();

                //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

            // Clicking Like/Unlike Button

            try {
                // Locate the like and unlike buttons
                WebElement likeButton = driver.findElement ( By.xpath ( "//*[@class='like']" ) );
                WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );

                // Check if the like button is displayed and click it
                if (likeButton.isDisplayed ()) {
                    likeButton.click ();
                    System.out.println ( "Successfully Clicked The Like Button" );
                }
                // Otherwise, check if the unlike button is displayed and click it
                else if (unlikeButton.isDisplayed ()) {
                    unlikeButton.click ();
                    System.out.println ( "Successfully Clicked The Unlike Button" );
                }
                // If neither button is found/displayed
                else {
                    System.out.println ( "Both Code Not Executed" );
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }

            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();

            //Entering Comment In The TextField

            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );

//                // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();

            // Scrolling The analysis page Up

            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Reattempt Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Clicking The Solution Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Scrolling The analysis page Forward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

            // Scrolling The analysis page Backward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            //  Clicking the back arrow in the solution screen for coming to course > Quiz

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz

            Thread.sleep ( 3000 );
            WebElement Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            Threedots.click ();
            System.out.println ( "Successfully clicked The ThreeDots" );

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

            // Again Click the three dots in the Quiz Tab

            Thread.sleep ( 3000 );
            Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            Threedots.click ();

            /* Clicking the share icon in Quiz Tab */

            Thread.sleep ( 3000 );
            WebElement Share_icon = driver.findElement ( xpath ( "//span[text()='Share']" ) );
            Share_icon.click ();

            //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();

            //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();

            // Again Click the three dots in the Quiz Tab

            Thread.sleep ( 3000 );
            Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            Threedots.click ();

            //clicking the report icon

            Thread.sleep ( 1000 );
            WebElement Report_icon = driver.findElement ( xpath ( "//span[text()='Report']" ) );
            Report_icon.click ();

            //Click the wrong information radio button

            Thread.sleep ( 1000 );
            WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
            Wrong_information_radio_button.click ();

            //Entering the text inside the report text field

            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

            // Click the report button

            Thread.sleep ( 3000 );
                /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
                Report_button.click ();*/

            // Clicking The Cancel Button

            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();

            //Windows Handeling

            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );
            System.out.println ( " SuccessFully Navigated The Child Windows" );

            //Windows mazimize

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button

            Thread.sleep ( 3000 );
            clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "Sucessfully clicked instruction icon" );

            // Again Clicking the close icon in the quiz instruction

            Thread.sleep ( 3000 );
            againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();
            System.out.println ( "SuccessFully Clicked The Close  Icon " );

            // Clicking The FullScreen Button

            Thread.sleep ( 2000 );
            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button" );

            // Clicking the BookMark-icon

            WebElement clickingBookmarkicon = driver.findElement ( linkText ( "/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg\"" ) );
            WebElement unClickBookMarkIcon = driver.findElement ( linkText ( "/static/media/quiz-bookmarked.bd5185a7db809bd7b02c9c33b1cdca2a.svg" ) );

            if (clickingBookmarkicon.isDisplayed ()) {

                clickingBookmarkicon = driver.findElement ( linkText ( "/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg\"" ) );
                clickingBookmarkicon.click ();
                System.out.println ( " Successfully Clicked The Bookmark Icon " );

            } else if (unClickBookMarkIcon.isSelected ()) {
                unClickBookMarkIcon = driver.findElement ( linkText ( "/static/media/quiz-bookmarked.bd5185a7db809bd7b02c9c33b1cdca2a.svg" ) );
                unClickBookMarkIcon.click ();
                System.out.println ( " Successfully Un-Clicked The Bookmark Icon " );
            } else {

                System.out.println ( " Both The COde Has Not Executed " );
            }

            // Clicking the options and Save & Next button in a loop

            options = new String[]{"A" , "B" , "C" , "D" , "E"};
            saveAndNextButton = driver.findElement ( By.xpath ( "//div[text()='Save & Next']" ) );
            WebElement numberOnRightSide;

            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( By.xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "SuccessFully CLicked The Option" + options );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "SuccessFully Clicked The Save and Next Button " );

                Thread.sleep ( 3000 );
                numberOnRightSide = driver.findElement ( By.xpath ( "//Span[text()='" + (options.length + 1) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "SuccessFully Clicked The Right Side Count" + numberOnRightSide );
            }
            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( By.xpath ( "//div[text()='" + options[i] + "']" ) );
                optionElement.click ();
                System.out.println ( "SuccessFully Clicked The Options Again" + options );

                Thread.sleep ( 3000 );
                numberOnRightSide = driver.findElement ( By.xpath ( "//Span[text()='" + (options.length + 9 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "SuccessFully Clicked The Right Side Count" + numberOnRightSide );
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            System.out.println ( "SuccessFully Clicked The Previous Button In Qestion Screen " );

            // Clicking The Pause Button

            Thread.sleep ( 3000 );
            clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
            clickingThePauseButton.click ();
            System.out.println ( "SuccessFully Clicked The Pause Button" );

            // Clicking The Leave button In the Pause Popup

            Thread.sleep ( 3000 );
            clickingLeaveButtonInPopup = driver.findElement ( xpath ( "//span[text()=\" Leave \"]" ) );
            clickingLeaveButtonInPopup.click ();
            System.out.println ( "SuccessFully Clicked The Leave Button In Popup" );

            // Changing The Child Windows To Parent Window

            driver.switchTo ().window ( parent );

            // Clicking The Resume Button In the quiz

            Thread.sleep ( 3000 );
            clickingResumeButton = driver.findElement ( xpath ( " (//span[text()=' Resume '])[1]" ) );
            clickingResumeButton.click ();
            System.out.println ( "SuccessFully Clicked The Resume Button" );

            //Windows Handeling child

            Thread.sleep ( 3000 );
            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );
            System.out.println ( "SuccessFully Navigated To The Child Window Again" );

            // Clicking The Submit Button

            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            System.out.println ( "SuccessFully Clicked Submit Button" );
            // Clicking the Cancel Button In the submit Popup

            Thread.sleep ( 1000 );
            clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
            clickingCancelButtonInThePopup.click ();
            System.out.println ( "SuccessFully Clicked Cancel Button In The Popup" );

            // Again Clicking The Submit Button

            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
            clickingSubmitButton.click ();
            System.out.println ( "SuccessFully Clicked Submit Button" );

            // Clicking The Submit Button In The Submit Popup

            Thread.sleep ( 1000 );
            clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=\"Submit\"]" ) );
            clickingSubmitButton.click ();
            System.out.println ( "SuccessFully Clicked Submit Button In The Popup " );

            // Switching Windows From Child To Parent

            driver.switchTo ().window ( parent );

            // Clicking The solution button

            Thread.sleep ( 2000 );
            clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[1]" ) );
            clickingSolutionButton.click ();

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

            // Clicking The Cancel Button

            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
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
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();

                // Clicking The ReattempButton

            Thread.sleep ( 7000 );
            //wait = new WebDriverWait (driver,30);
            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            // Define the options to be clicked
            options = new String[]{"A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( By.xpath ( "//div[text()='Save & Next']" ) );

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
                numberOnRightSide = driver.findElement ( By.xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "Successfully Clicked The Number: " + (16 + i) );
            }
            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( By.xpath ( "//div[text()='Previous']" ) );
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

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

                // Clicking The Share Icon In The Solution Page

            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
                clickingTheShareIcon.click ();

                //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup

            waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

            // Clicking The ReattempButton

            Thread.sleep ( 5000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
                clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

                //  Click the back arrow in the solution screen

            Thread.sleep ( 3000 );
            clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
                clickingBackArrow.click ();

                // Clicking The solution button

            Thread.sleep ( 2000 );
            clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
                clickingSolutionButton.click ();

                // Analysis was not working in site

                // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
                clickingAnalysisIcon.click ();

                // Clicking The FullScreen Button

            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
                clickingTheFullScreenButton.click ();

                // Exiting The FullScreen Button

            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
                exitingTheFullScreenButton.click ();

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

                // Clicking The Share Icon In The Analysis Page

            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();

                //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

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
            clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
                clickingCommentIconInAnalysisPage.click ();

            //Entering Comment In The TextField

            Thread.sleep ( 5000 );
            enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );

                // Clicking The Send Button In The Comment Text Field

            Thread.sleep ( 2000 );
            WebElement clickingSendButton = driver.findElement ( className ( "anticon-send" ) );
                clickingSendButton.click ();

            // Scrolling The analysis page Up

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Reattempt Button Inside The analysis page

            Thread.sleep ( 2000 );
            clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
                clickingReattempButton.click ();

                //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

                // Clicking The Solution Button Inside The analysis page

            Thread.sleep ( 2000 );
            clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
                clickingSolutionButtonInAnalysis.click ();

                //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

                // Scrolling The analysis page Forward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

                // Scrolling The analysis page Backward

            Thread.sleep ( 3000 );
                jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
                clickingBackToQuizBreadCrumbs.click ();

            //  Clicking the back arrow in the solution screen for coming to course > Quiz

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

        } else if (quizsolutionDisplayedInMyNotes) {
            clickingSolutionquiz.click ();
            System.out.println ( "Successfully clicked the solution button in the My Notes" );

            // Scrolling and Clicking The Report Page

            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
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

            Thread.sleep ( 7000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            String[] options = new String[]{"A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" , "A" , "B" , "C" , "D" , "E" ,};

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

                /* // Clicking The Cancel Button

                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
                Cancel_button.click ();*/

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

            Thread.sleep ( 5000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period." );
            } catch (NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen

            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();

            // Clicking The solution button

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
            clickingSolutionButton.click ();

            // Analysis was not working in site

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            WebElement clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The FullScreen Button

            WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Exiting The FullScreen Button

            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            // Clicking The Analysis Icon

            Thread.sleep ( 3000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();

            // Clicking The Share Icon In The Analysis Page

            Thread.sleep ( 3000 );
            clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();

            //click the copy link in the share popup

            Thread.sleep ( 3000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();

            //Clicking the cancel button in the in share popup

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();

            // Clicking Like/Unlike Button

            try {
                // Locate the like and unlike buttons
                WebElement likeButton = driver.findElement ( xpath ( "//*[@class='like']" ) );
                WebElement unlikeButton = driver.findElement ( xpath ( "//*[@class='unlike']" ) );

                // Check if the like button is displayed and click it
                if (likeButton.isDisplayed ()) {
                    likeButton.click ();
                    System.out.println ( "Successfully Clicked The Like Button" );
                }
                // Otherwise, check if the unlike button is displayed and click it
                else if (unlikeButton.isDisplayed ()) {
                    unlikeButton.click ();
                    System.out.println ( "Successfully Clicked The Unlike Button" );
                }
                // If neither button is found/displayed
                else {
                    System.out.println ( "Both Code Not Executed" );
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "Like/Unlike Button not found" );
            }

            // Clicking The comment icon in the analysis page

            Thread.sleep ( 3000 );
            WebElement clickingCommentIconInAnalysisPage = driver.findElement ( xpath ( "//*[@id=\"comments-icon\"]" ) );
            clickingCommentIconInAnalysisPage.click ();

            //Entering Comment In The TextField

            Thread.sleep ( 5000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name=\"comments1\"]" ) );
            enteringTheCommentInTextField.sendKeys ( "Checking The Comment Text Field" );

//                // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();

            // Scrolling The analysis page Up

            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Reattempt Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Clicking The Solution Button Inside The analysis page

            Thread.sleep ( 2000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();

            //  Again Click the back arrow in the solution screen

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

            // Scrolling The analysis page Forward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

            // Scrolling The analysis page Backward

            Thread.sleep ( 3000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();

            //  Clicking the back arrow in the solution screen for coming to course > Quiz

            Thread.sleep ( 2000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();

        } else {
            System.out.println ( "The code was not executed in the quiz my notes" );
        }


    }


}

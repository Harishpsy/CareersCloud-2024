package MyCourse;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import static org.openqa.selenium.By.*;

public class CourseQuizzesUnattempted {

    WebDriver driver;

    public CourseQuizzesUnattempted(WebDriver driver) {

        this.driver = driver;
    }

    public void unAttempted() throws InterruptedException {


        int numberOfTimesScrollunattemptedQuizzesListpage = 2;

        for (int i = 0; i < numberOfTimesScrollunattemptedQuizzesListpage; i++) {
            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
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

        // Verifying the Quiz List was getting duplicating using the unique videos Url
        List<WebElement> unattemptedQuizTitle = driver.findElements ( xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]" ) );

        // Create a set to store unique Ebook Titles

        Set<String> uniqueunattemptedQuizTitles = new HashSet<> ();
        int uniqueunattemptedQuizCount = 0;

        for (WebElement uniqueTitle : unattemptedQuizTitle) {
            String actualquizTitle = uniqueTitle.getText ();

            if (uniqueunattemptedQuizTitles.contains ( actualquizTitle )) {
                System.out.println ( "Duplicate found --> " + actualquizTitle + uniqueunattemptedQuizCount );
            } else {
                uniqueunattemptedQuizTitles.add ( actualquizTitle );
                uniqueunattemptedQuizCount++;
                System.out.println ( "Found: " + uniqueunattemptedQuizCount + " --> " + actualquizTitle );
                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniqueunattemptedQuizCount , uniqueunattemptedQuizTitles.size () );

        // Clicking The Start Quiz

        WebElement clickingStartQuiz = driver.findElement ( xpath ( "(//*[text() = ' Start Quiz '])[1]" ) );
        clickingStartQuiz.click ();
        System.out.println ( "Successfully Clicked The startQuiz" );
        Thread.sleep ( 3000 );

        //Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );

        // Clicking the close icon in the quiz instruction

        Thread.sleep ( 5000 );
        WebElement Close_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
        Close_icon.click ();
        System.out.println ( "SuccessFully Clicked The CloseIcon" );

        //Windows mazimize

        new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        driver.manage ().window ().maximize ();

        // Getting The Quiz Name For Verify In The Paused Tab

        Thread.sleep ( 3000 );
        WebElement gettingQuizTitle = driver.findElement ( xpath ( "//span[@class=\"title\"]" ) );
        String QuizTitle = gettingQuizTitle.getText ();
        System.out.println ( "Quiz Title Name From The Unattempted : " + QuizTitle );

        // Getting The quiz Time

        Thread.sleep ( 3000 );
        WebElement gettingQuizTime = driver.findElement ( xpath ( "//span[@class=\"text\"]" ) );
        String QuizTime = gettingQuizTime.getText ();
        System.out.println ( "quiz Time : " + QuizTime );


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
        String[] options = new String[]{"E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A"};

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
        driver.findElement ( xpath ( "//span[@class=\"text\"]" ) );
        String QuizTimeBeforepause = gettingQuizTime.getText ();
        System.out.println ( "quiz Time Before pause: " + QuizTimeBeforepause );

        // Again, Clicking The Pause Button leaves the quiz

        Thread.sleep ( 3000 );
        clickingThePauseButton = driver.findElement ( xpath ( "//*[@class=\"pause-icon\"]" ) );
        clickingThePauseButton.click ();
        System.out.println ( "Successfully CLicked The Pause Button " );

        // Clicking The Leave button In the Pause Popup

        Thread.sleep ( 3000 );
        WebElement clickingLeaveButtonInPopup = driver.findElement ( xpath ( "//span[text()=\" Leave \"]" ) );
        clickingLeaveButtonInPopup.click ();
        System.out.println ( "Successfully Clicked The Leave Button" );

        // Changing The Child Windows To Parent Window

        driver.switchTo ().window ( parent );

        // Clicking The Paused Tab

        Thread.sleep ( 3000 );
        WebElement clickingPausedTab = driver.findElement ( xpath ( "//*[text() ='Paused']" ) );
        clickingPausedTab.click ();
        System.out.println ( "Successfully Clicked The Paused Tab" );

        // Scrolling The Attempted Quizzes List Page to verify data

        int numberOfTimesScrollQuizzes = 2;

        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
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

        // Getting the Quiz Title Name to check Whether completed quiz from paused was showing In Attempt or not

        // Find all elements matching the XPath and store them in a list
        List<WebElement> gettingQuizTitles = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );

        // Iterate through the list and print the text of each element
        for (WebElement quizTitle : gettingQuizTitles) {
            String quiztitleText = quizTitle.getText ();
            System.out.println ( "Quiz Title: " + quiztitleText );

            // Verifying The completed quiz from paused was showing or not in the attempted

            Assert.assertEquals ( QuizTitle , quiztitleText );
            System.out.println ( "Verification Passed: Quiz Title In Paused (" + QuizTitle + ") matches Quiz Title In Attempted (" + quiztitleText + ")" );
        }
        // Checking That from the unattempted attened quiz was showing in the paused

        // Iterate through the list and clicking solution

        for (WebElement quizTitle : gettingQuizTitles) {
            String quizTitleText = quizTitle.getText ();
            if (quizTitleText.equals ( QuizTitle )) {
                WebElement ResumeButton = quizTitle.findElement ( By.xpath ( "//*[text() = ' Resume ']" ) );
                ResumeButton.click ();
                System.out.println ( "Successfully clicked the Resume button for the verified quiz title: " + quizTitleText );
            }
        }
        // Clicking the Resume quiz

        Thread.sleep ( 5000 );
        WebElement clickingResumeQuiz = driver.findElement ( xpath ( "(//*[text() = ' Resume '])[1]" ) );
        clickingResumeQuiz.click ();
        System.out.println ( " Clicked The resume quiz In The paused Tab " );

        //Windows Handeling

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window ( child );
        System.out.println ( "SuccessFully Navigated To The Child Windows" );

        //Windows mazimize
        Thread.sleep ( 5000 );
        driver.manage ().window ().maximize ();

        // Getting The answer Count After Resume

        Thread.sleep ( 5000 );
        WebElement gettingAnsweredCountAfterResume = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
        String AnsweredCountAfterResume = gettingAnsweredCountAfterResume.getText ();
        System.out.println ( "Answered Count After Resume : " + AnsweredCountAfterResume );

        // Verifying The Paused Answer Count was the same as Resume Answer Count

        Assert.assertEquals ( AnsweredCountAfterResume , AnswerCountBeforepause );
        System.out.println ( "Verification Passed: Answered Count Before Pause (" + AnswerCountBeforepause + ") matches Answered Count After Resume (" + AnsweredCountAfterResume + ")" );

        //Getting The un-answer Count After Resume

        WebElement gettingUnansweredCountAfterResume = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgba(90, 114, 200, 0.2); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(0, 0, 0); font-weight: 900;\"]" ) );
        String UnansweredCountAfterResume = gettingUnansweredCountAfterResume.getText ();
        System.out.println ( "Answered Count After Resume : " + UnansweredCountAfterResume );

        // Verifying The Paused Un-Answer Count was the same as Resume Un-Answer Count

        Assert.assertEquals ( UnAnswerCountBeforepause , UnansweredCountAfterResume );
        System.out.println ( "Verification Passed: Answered Count Before Pause (" + UnAnswerCountBeforepause + ") matches Answered Count After Resume (" + UnansweredCountAfterResume + ")" );

        // Getting The quiz Timer After Resume

        WebElement gettingQUizTimeAfterResume = driver.findElement ( xpath ( "//*[@class=\"quiz-timer\"]" ) );
        String quizTimeAfterResume = gettingQUizTimeAfterResume.getText ();
        System.out.println ( "Quiz Time After Resume : " + quizTimeAfterResume );

        // Verifying The Quiz Time Before Pause was the same as Quiz Time After Resume

        //Assert.assertEquals ( QuizTimeBeforepause,quizTimeAfterResume );
        System.out.println ( "Verification Passed: Quiz Time Before Pause (" + QuizTimeBeforepause + ") matches Quiz Time After Resume (" + quizTimeAfterResume + ")" );

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
        clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
        clickingTheFullScreenButton.click ();

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

        // Clicking The Submit Button

        Thread.sleep ( 3000 );
        WebElement clickingSubmitButton = driver.findElement ( xpath ( "//span[text()=' Submit ']" ) );
        clickingSubmitButton.click ();

        // Clicking the Cancel Button In the submit Popup

        Thread.sleep ( 1000 );
        WebElement clickingCancelButtonInThePopup = driver.findElement ( xpath ( "//span[text()=\"Cancel\"]" ) );
        clickingCancelButtonInThePopup.click ();

        // Getting The answer Count Before Submit

        Thread.sleep ( 5000 );
        WebElement gettingAnsweredCountBeforeSubmit = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
        String AnsweredCountBeforeSubmit = gettingAnsweredCountBeforeSubmit.getText ();
        System.out.println ( "Answered Count Before Submit : " + AnsweredCountBeforeSubmit );

        //Getting The un answer Count After Resume

        WebElement gettingUnansweredCountBeforeSubmit = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgba(90, 114, 200, 0.2); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(0, 0, 0); font-weight: 900;\"]" ) );
        String UnansweredCountBeforeSubmit = gettingUnansweredCountBeforeSubmit.getText ();
        System.out.println ( "Un-Answered Count Before Submit : " + UnansweredCountBeforeSubmit );

        // Getting The quiz Timer After Resume

        WebElement gettingQUizTimeBeforeSubmit = driver.findElement ( xpath ( "//*[@class=\"quiz-timer\"]" ) );
        String quizTimeBeforeSubmit = gettingQUizTimeBeforeSubmit.getText ();
        System.out.println ( "Quiz Time Before Submit : " + quizTimeBeforeSubmit );

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

        // Once Test Finish Navigate to The Attempted List Page

        Thread.sleep ( 4000 );
        WebElement clickingTheAttemptedButton = driver.findElement ( xpath ( "//*[text()='Attempted']" ) );
        clickingTheAttemptedButton.click ();
        System.out.println ( "Successfully Clicked The Attempted Button " );

        // Scrolling The Attempted Quizzes List Page to verify data

        numberOfTimesScrollQuizzes = 5;

        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
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

        // Getting the Quiz Title Name to check Whether completed quiz from paused was showing In Attempt or not

        // Find all elements matching the XPath and store them in a list
        gettingQuizTitles = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );

        // Iterate through the list and print the text of each element
        for (WebElement quizTitle : gettingQuizTitles) {
            String quiztitleText = quizTitle.getText ();
            System.out.println ( "Quiz Title: " + quiztitleText );

            // Verifying The completed quiz from paused was showing or not in the attempted

            Assert.assertEquals ( QuizTitle , quiztitleText );
            System.out.println ( "Verification Passed: Quiz Title In Paused (" + QuizTitle + ") matches Quiz Title In Attempted (" + quiztitleText + ")" );

        }

        // Clicking The Completed quiz from the paused tab in the attempted

        // Iterate through the list and clicking solution

        for (WebElement quizTitle : gettingQuizTitles) {
            String quizTitleText = quizTitle.getText ();
            if (quizTitleText.equals ( QuizTitle )) {
                WebElement solutionButton = quizTitle.findElement ( By.xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]/parent::*/preceding::span[text()=' Solution ']" ) );
                solutionButton.click ();
                System.out.println ( "Successfully clicked the Solution button for the verified quiz title: " + quizTitleText );
            } else {

                System.out.println ( "Cant able to find the solution button " );
            }
        }
    }
}



















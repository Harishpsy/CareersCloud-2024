package MyCourse;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class CourseQuizzesUnattempted extends CourseQuizAttempted {

    WebDriver driver;

    public CourseQuizzesUnattempted(WebDriver driver) throws InterruptedException {

        this.driver = driver;
    }

    public void unAttempted() throws InterruptedException {

        WebElement clickingUnAttempted = driver.findElement ( By.xpath ( "//*[contains(text(), 'Unattempted')]" ) );
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        WebElement clickingStartQuiz = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "(//*[text() = ' Start Quiz '])[1]" ) ) );
        WebElement clickingAttemptedTab = driver.findElement ( By.xpath ( "//*[text()='Attempted']" ) );

        if (clickingUnAttempted.isDisplayed ()) {
            Thread.sleep ( 5000 ); // Pause to allow the element to be fully interactive
            clickingUnAttempted.click ();
            System.out.println ( "Successfully Clicked The Unattempted Tab" );

            // Clicking The Start Quiz button
            clickingStartQuiz.click ();
            System.out.println ( "Successfully Clicked the Start button" );

        } else if (clickingUnAttempted.isEnabled ()) {

            // Clicking The Start Quiz button because the Unattempted tab is already selected
            clickingStartQuiz.click ();
            System.out.println ( "Successfully Clicked the Start button because Unattempted tab was already clicked" );

        } else if (clickingAttemptedTab.isDisplayed ()) {

            // Perform action related to the Attempted tab
            CourseQuizAttempted attempted = new CourseQuizAttempted ( driver );
            attempted.attemptedTab ();

        } else {
            System.out.println ( "Neither Unattempted nor Attempted tab actions were performed" );
        }

//        int numberOfTimesScrollunattemptedQuizzesListpage = 2;
//
//        for (int i = 0; i < numberOfTimesScrollunattemptedQuizzesListpage; i++) {
//            try {
//                Thread.sleep ( 5000 );
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
//                System.out.println ( "Successfully scroll the Unattempted List Page " + (i + 1) + " time(s)." );
//            } catch (Exception scroll) {
//                System.out.println ( "Failed to Scrollthe Unattempted List Page : " + scroll.getMessage () );
//            }
//        }
//
//        // Clicking Float Icon
//        try {
//            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
//            if (clickingFloatIcon.isDisplayed ()) {
//                clickingFloatIcon.click ();
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println ( "FloatIcon Button Is Not Displayed" );
//        }
//
//        // Verifying the Quiz List was getting duplicating using the Unique Quiz Title
//        List<WebElement> unattemptedQuizTitle = driver.findElements ( xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]" ) );
//
//        // Create a set to store unique Quiz Titles
//
//        Set<String> uniqueunattemptedQuizTitles = new HashSet<> ();
//        int uniqueunattemptedQuizCount = 0;
//
//        for (WebElement uniqueTitle : unattemptedQuizTitle) {
//            String actualquizTitle = uniqueTitle.getText ();
//
//            if (uniqueunattemptedQuizTitles.contains ( actualquizTitle )) {
//                System.out.println ( "Duplicate found --> " + actualquizTitle + uniqueunattemptedQuizCount );
//            } else {
//                uniqueunattemptedQuizTitles.add ( actualquizTitle );
//                uniqueunattemptedQuizCount++;
//                System.out.println ( "Found: " + uniqueunattemptedQuizCount + " --> " + actualquizTitle );
//                System.out.println ( "-------------------------------------------------------------------------" );
//            }
//        }
//        // Assert that the number of unique URLs is equal to the number of elements
//        Assert.assertEquals ( uniqueunattemptedQuizCount , uniqueunattemptedQuizTitles.size () );

        //Windows Handeling

            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );
        System.out.println ( "SuccessFully Windows Handled To Child Windows" );

            // Clicking the close icon in the quiz instruction
//            WebDriverWait wait1 = new WebDriverWait ( driver , Duration.ofSeconds ( 50 ) );
//            WebElement closeIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class=\"ant-modal-close\"]" ) ) );
//            closeIcon.click ();
//            System.out.println ( "SuccessFully Clicked The CloseIcon" );

        Thread.sleep ( 10000 );
        WebElement Close_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close\"]" ) );
        Close_icon.click ();
            System.out.println ( "SuccessFully Clicked The CloseIcon" );

            //Windows mazimize

            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            // Getting The Quiz Name For Verify In The Paused Tab From The Unattempted Tab
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


            // Clicking or Unclicking the BookMark-icon By using try catch method
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

            // Define the options to be clicked'

            // Storing the choise in the array list and performing the action

            String[] options = new String[]{"E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A"};

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
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + options[i] );

                Thread.sleep ( 3000 );
                WebElement numberOnRightSide = driver.findElement ( xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "Successfully Clicked The Number: " + (16 + i) );
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

            int numberOfTimesScrollQuizzes = 5;

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
            List<WebElement> gettingQuizTitles = driver.findElements ( xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );

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
                    WebElement ResumeButton = quizTitle.findElement ( xpath ( "//*[text() = ' Resume ']" ) );
                    ResumeButton.click ();
                    System.out.println ( "Successfully clicked the Resume button for the verified quiz title: " + quizTitleText );
                } else {

                    System.out.println ( "Cannot get the quiz Title" );
                }
            }

            //Windows Handeling

            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child ); // Navigating to the clild window

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

            // Getting The Quiz Name For Verify In The Paused Tab From The Unattempted Tab

            Thread.sleep ( 3000 );
            gettingQuizTitle = driver.findElement ( By.xpath ( "//*[@class=\"ant-col title-column ant-col-xs-22 ant-col-sm-22 ant-col-md-22 ant-col-lg-22 ant-col-xl-22 ant-col-xxl-22 css-xu9wm8\"]" ) );
            String attemptedQuizTitle = gettingQuizTitle.getText ();
            System.out.println ( "Quiz Title Name From The Resume Test Before Submit: " + attemptedQuizTitle );

            // Again Clicking The Submit Button

            Thread.sleep ( 3000 );
            clickingSubmitButton = driver.findElement ( By.xpath ( "//*[text()=' Submit ']" ) );
            clickingSubmitButton.click ();

            // Clicking The Submit Button In The Submit Popup

            Thread.sleep ( 5000 );
            clickingSubmitButton = driver.findElement ( By.xpath ( "//*[text() = \"Submit\"]" ) );
            clickingSubmitButton.click ();
            System.out.println ( "Successfully Clicked The Submit Button In The Popup" );

            // Switching Windows From Child To Parent

            driver.switchTo ().window ( parent );

//            // Once Test Finish Navigate to The Attempted List Page

            Thread.sleep ( 4000 );
            WebElement clickingTheAttemptedButton = driver.findElement ( xpath ( "//*[text()='Attempted']" ) );
            clickingTheAttemptedButton.click ();
            System.out.println ( "Successfully Clicked The Attempted Button" );

            // Scrolling The Attempted Quizzes List Page to verify data

        int numberOfTimesScrollQuizze = 10;

            for (int i = 0; i < numberOfTimesScrollQuizze; i++) {
                try {
                    Thread.sleep ( 4000 );
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                    System.out.println ( "Successfully scrolled the Attempted list page " + (i + 1) + " time(s)." );
                } catch (Exception scroll) {
                    System.out.println ( "Failed to Scroll: " + scroll.getMessage () );
                }
            }

            // Clicking Float Icon

            try {
                WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
                if (clickingFloatIcon.isDisplayed ()) {
                    clickingFloatIcon.click ();
                } else {
                    System.out.println ( "Float button cant able to find " );
                }
            } catch (NoSuchElementException e) {
                System.out.println ( "FloatIcon Button Is Not Displayed" );
            }

            // Getting the Quiz Title Name to check whether completed quiz from paused was showing in Attempted or not

            // Find all elements matching the XPath and store them in a list
            gettingQuizTitles = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );
            Thread.sleep ( 5000 );

        // Iterate through the list and print the text of each element

        boolean matchFound = false;
            for (WebElement quizTitle : gettingQuizTitles) {
                String quiztitleText = quizTitle.getText ();
                System.out.println ( "Quiz Title " + quiztitleText );
                // Verifying the completed quiz from paused was showing or not in the attempted
                if (attemptedQuizTitle.equals ( quiztitleText )) {
                    matchFound = true;
                    System.out.println ( "Verification Passed: Quiz Title In Paused (" + attemptedQuizTitle + ") matches Quiz Title In Attempted Tabs (" + quiztitleText + ")" );
                } else {
                    System.out.println ( "Verification Failed" );
                }
            }
            // Verifying That the Both the Titles are equal
            Assert.assertTrue ( matchFound , "No matching quiz title found in the attempted list." );

            // Checking That from the Submitted quiz from the Paused was showing in the Attempted tab

//        // Iterate through the list and clicking solution
//        try {
//            List<WebElement> gettingQuizTitleSolution = driver.findElements(By.xpath("//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']"));
//            System.out.println("Entering the For loop");
//
//            for (WebElement quizTitlesolution : gettingQuizTitleSolution) {
//                gettingQuizTitleSolution = driver.findElements ( By.xpath ( "//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']" ) );
//                String quizTitleTextSolution = quizTitlesolution.getText().trim();
//
//                if (quizTitleTextSolution.equals(attemptedQuizTitle)) {
//                    try {
//                        // Locate and click the Solution button
//                        WebElement solutionButton = quizTitlesolution.findElement(By.xpath(".//*[text()='Solution']"));
//                        solutionButton.click();
//                        System.out.println("Successfully clicked the Solution button for the verified quiz title: " + quizTitleTextSolution);
//
//                        // Wait for a specific element that indicates page stabilization
//                        new WebDriverWait(driver, Duration.ofSeconds(10))
//                                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ant-row ant-row-center nowrap-content css-xu9wm8']")));
//                    } catch (NoSuchElementException e) {
//                        System.out.println("Solution button not found for the quiz title: " + quizTitleTextSolution);
//                    }
//                }
//            }
//        } catch (StaleElementReferenceException e) {
//            System.out.println("Error occurred: StaleElementReferenceException");
//        }

//            // Calling The solution

            Thread.sleep ( 5000 );
            WebElement clickingSolution = driver.findElement ( xpath ( "(//*[text()=' Solution '])[1]" ) );
            clickingSolution.click ();
            System.out.println ( "Successfully Clicked The Solution In The Quiz List Page" );

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

            // Scrolling and Clicking The Report Page

            Thread.sleep ( 3000 );
            WebElement scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            Actions actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            System.out.println ( "SuccessFully Scroll and clicked The Report Icon In Solution Page" );

            // Click The Translation Error In The Report Popup

            Thread.sleep ( 3000 );
            WebElement clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            System.out.println ( "Successfully clicked The Translation Error Radio Button" );

            // Clicking The Report Description button

            WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            System.out.println ( "SuccessFully Clicked The Enter_the_Enter_the_report In The Field" );

            // Clicking The Cancel Button

            WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel Button" );

            // Clicking The Report Button

            Thread.sleep ( 3000 );
            WebElement clickingReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            clickingReportIcon.click ();

            // Click The Translation Error In The Report Popup

            Thread.sleep ( 3000 );
            WebElement clickingIncompleteQuestionRadioButton = driver.findElement ( xpath ( "//span[text()='Incomplete Question']" ) );
            clickingIncompleteQuestionRadioButton.click ();
            System.out.println ( "Successfully clicked The IncompleteQuestion Radio Button" );

            // Clicking The Report Description button

            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            System.out.println ( "SuccessFully Clicked The Enter_the_Enter_the_report In The Field" );

            // Click the report button

            Thread.sleep ( 3000 );
            WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            System.out.println ( "Successfully Clicked The Report Button" );

            // Clicking The ReattempButton

            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) ); // Adjust the timeout as necessary

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
            options = new String[]{"A" , "A" , "A" , "A" , "A" , "B" , "B" , "B" , "C" , "C" , "C" , "D" , "D" , "E" , "E" ,};

            // Locate the Save & Next button
            saveAndNextButton = driver.findElement ( By.xpath ( "//div[text()='Save & Next']" ) );

            // Clicking the options and Save & Next button in a loop
            for (String option : options) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + option );

                Thread.sleep ( 3000 );
                saveAndNextButton.click ();
                System.out.println ( "Successfully Clicked The Save & Next Button" );
                break;
            }

            // Clicking options again after navigating back
            for (int i = 0; i < options.length - 2; i++) {
                Thread.sleep ( 3000 );
                WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                optionElement.click ();
                System.out.println ( "Successfully Clicked The Option: " + options[i] );

                Thread.sleep ( 3000 );
                WebElement numberOnRightSide = driver.findElement ( xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                numberOnRightSide.click ();
                System.out.println ( "Successfully Clicked The Number: " + (16 + i) );
            }

            // Clicking The Previous Button

            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();
            System.out.println ( "Successfully Clicked The Previous Button" );

            // Scrolling The Solution Page

        Thread.sleep ( 5000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            System.out.println ( "Successfully Scrolled and Clicked The Report icon" );

            // Click The Translation Error In The Report Popup

        Thread.sleep ( 5000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            System.out.println ( "Successfully Clicked Translation Error Radio Button" );

            //Entering the text inside the report text field In Solution Page

        Thread.sleep ( 5000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            System.out.println ( "Successfully Clicked Enter_the_report text field" );

            // Clicking The Cancel Button

        Thread.sleep ( 5000 );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked Cancel button" );

            // Scrolling The Solution Page

        Thread.sleep ( 5000 );
            scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
            actions = new Actions ( driver );
            actions.scrollToElement ( scrollToReportIcon ).perform ();
            scrollToReportIcon.click ();
            System.out.println ( "Successfully Scrolled and Clicked The Report icon" );

            // Click The Translation Error In The Report Popup

        Thread.sleep ( 5000 );
            clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
            clickingTranslationErrorRadioButton.click ();
            System.out.println ( "Successfully Clicked Translation Error Radio Button" );

            //Entering the text inside the report text field In Solution Page

        Thread.sleep ( 5000 );
            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            System.out.println ( "Successfully Clicked Enter_the_report text field" );

            // Click the report button

            Thread.sleep ( 5000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            System.out.println ( "Successfully Clicked Report button" );

            // Clicking The Share Icon In The Solution Page

        Thread.sleep ( 5000 );
            WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
            clickingTheShareIcon.click ();
            System.out.println ( "Successfully Clicked The Share Icon" );

            //click the copy link in the share popup

        Thread.sleep ( 5000 );
            WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully Clicked The Copy link Button" );

            //Clicking the cancel button in the in share popup

            WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel button" );

            // Clicking The ReattempButton

            Thread.sleep ( 5000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();
            System.out.println ( "Successfully Clicked The Reattempt Button" );

            //  Click the back arrow in the solution screen

        Thread.sleep ( 5000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
            System.out.println ( "Successfully Clicked The Back Arrow Button In Solution Screen " );

            // Clicking The solution button

        Thread.sleep ( 5000 );
            WebElement clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
            clickingSolutionButton.click ();
            System.out.println ( "Successfully Clicked The Solution Button In Solution Screen " );

            // Analysis was not working in site

            // Clicking The Analysis Icon

        Thread.sleep ( 10000 );
            WebElement clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );

            // Clicking The FullScreen Button

            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );

            // Exiting The FullScreen Button

            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
            WebElement exitingTheFullScreenButton = driver.findElement ( className ( "anticon-compress" ) );
            exitingTheFullScreenButton.click ();
            System.out.println ( "Successfully Clicked The Full Screen Button In Solution Screen " );

            // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

            Thread.sleep ( 3000 );
            WebElement clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Clicked The Back To Quiz Bread Crumbs In Solution Screen " );

            // Clicking The Analysis Icon

        Thread.sleep ( 10000 );
            clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
            clickingAnalysisIcon.click ();
            System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );

            // Clicking The Share Icon In The Analysis Page

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
                    WebElement likeButton = driver.findElement ( xpath ( "//*[@class='like']" ) );
                    if (likeButton.isDisplayed ()) {
                        likeButton.click ();
                        System.out.println ( "Successfully Clicked The Like Button" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( xpath ( "//*[@class='unlike']" ) );
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

//              // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();

            // Scrolling The analysis page Up

        Thread.sleep ( 5000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
            System.out.println ( "Successfully Scroll The Page" );


            // Clicking The Reattempt Button Inside The analysis page

        Thread.sleep ( 5000 );
            WebElement clickingReattempButton = driver.findElement ( xpath ( "//span[text()=' Reattempt ']" ) );
            clickingReattempButton.click ();
            System.out.println ( "Successfully clicked Reattemp Button" );

            //  Again Click the back arrow in the solution screen

        Thread.sleep ( 5000 );
            WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked Back Arrow" );

            // Clicking The Solution Button Inside The analysis page

        Thread.sleep ( 5000 );
            WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
            clickingSolutionButtonInAnalysis.click ();
            System.out.println ( "Successfully clicked Solution Button In Analysis" );

            //  Again Click the back arrow in the solution screen

        Thread.sleep ( 5000 );
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
            clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
            clickingBackToQuizBreadCrumbs.click ();
            System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );

            //  Clicking the back arrow in the solution screen for coming to course > Quiz

        Thread.sleep ( 5000 );
            againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            againclickingBackArrow.click ();
            System.out.println ( "Successfully clicked clicking Back Arrow" );

            // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz

        Thread.sleep ( 5000 );
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

            // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz

        Thread.sleep ( 5000 );
            Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            Threedots.click ();
            System.out.println ( "Successfully clicked The ThreeDots" );

            /* Clicking the share icon in Quiz Tab */

            Thread.sleep ( 10000 );
            WebElement Share_icon = driver.findElement ( xpath ( "//span[text()='Share']" ) );
            Share_icon.click ();
            System.out.println ( "Successfully clicked The Share Icon" );

            //click the copy link in the share popup

        Thread.sleep ( 5000 );
            Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
            Copy_link.click ();
            System.out.println ( "Successfully clicked The Copy Icon " );

            //Clicking the cancel button in the in share popup

            waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully clicked The Cancel button" );

            // Again Click the three dots in the Quiz Tab

        Thread.sleep ( 5000 );
            Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            Threedots.click ();
            System.out.println ( "Successfully clicked The ThreeDots" );

            //clicking the report icon

        Thread.sleep ( 5000 );
            WebElement Report_icon = driver.findElement ( xpath ( "//span[text()='Report']" ) );
            Report_icon.click ();
            System.out.println ( "Successfully clicked The Report Icon" );

            //Click the wrong information radio button

        Thread.sleep ( 5000 );
            WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
            Wrong_information_radio_button.click ();
            System.out.println ( "Successfully clicked The Wrong information radio button" );

            //Entering the text inside the report text field

            Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
            Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
            System.out.println ( "Successfully Entered The Text In The Enter the report" );

            // Click the report button

        Thread.sleep ( 5000 );
            Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
            Report_button.click ();
            System.out.println ( "Successfully Clicked The Report_button" );

            // Clicking The Cancel Button

        Thread.sleep ( 5000 );
            Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
            Cancel_button.click ();
            System.out.println ( "Successfully Clicked The Cancel button" );
            driver.quit ();

    }


}



























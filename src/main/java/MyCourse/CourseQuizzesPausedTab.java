package MyCourse;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class CourseQuizzesPausedTab {
    WebDriver driver;

    public CourseQuizzesPausedTab(WebDriver driver) {
        this.driver = driver;
    }

    public void pausedTab() throws InterruptedException {

        WebElement clickingThePausedTab = driver.findElement ( xpath ( "//*[text()='Paused']" ) );
        clickingThePausedTab.click ();
        System.out.println ( "SuccessFully Clicked The Paused Tab In The QUiz List Page" );

        // Scrolling The Quizzes List Page to verify data
        int numberOfTimesScrollQuizzes = 5;

        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The page In The Paused Tab  " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll The Page In The Paused Tab : " + scroll.getMessage () );
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
        List<WebElement> quizTitle = driver.findElements ( xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]" ) );

        // Create a set to store unique Ebook Titles
        Set<String> uniqueQuizTitles = new HashSet<> ();
        int uniqueQuizCount = 0;

        for (WebElement uniqueTitle : quizTitle) {
            String actualquizTitle = uniqueTitle.getText ();

            if (uniqueQuizTitles.contains ( actualquizTitle )) {
                System.out.println ( "Duplicate found In The Paused Tab--> " + actualquizTitle );
            } else {
                uniqueQuizTitles.add ( actualquizTitle );
                uniqueQuizCount++;
            }
        }

        // Print the total number of unique URLs found
        System.out.println ( "Total unique Quiz Name found In The Paused Tab: " + uniqueQuizCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniqueQuizCount , uniqueQuizTitles.size () );

        // Performing The Resume quiz Action
        CourseQuizzesPausedTab resume = new CourseQuizzesPausedTab ( driver );
        resume.resumeQuizs ();

    }

    private void resumeQuizs() throws InterruptedException {

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
            WebElement resumequiz = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt2-button\"]/child::span[text()=' Resume ']" ) );
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
            WebElement resumequiz = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt2-button\"]/child::span[text()=' Resume ']" ) );
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
            Thread.sleep ( 30000 );
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
            WebElement clickingAttemptedTab = driver.findElement ( xpath ( "//*[text()='Attempted']" ) );
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

            // Performing The Solution Action Here
            CourseQuizzesPausedTab solution = new CourseQuizzesPausedTab ( driver );
            solution.quizSolutions ();

        } else {
            System.out.println ( "No matching condition was found in the Resume quiz In The quiz List Page." );
        }
    }

    private void quizSolutions() throws InterruptedException {

        System.out.println ( "-----------------------Solutions---------------------------" );

        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean quizsolutionDisplayedInAllQuiz = false;

        try {
            WebElement quizsolution = driver.findElement ( xpath ( "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt1-solution-button\"]/child::*[text()=' Solution '])[1]" ) );
            quizsolutionDisplayedInAllQuiz = quizsolution.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Solution button element not found In The quiz List Page." );
        }

        // Log the visibility status of each element
        System.out.println ( "Solution button displayed In The quiz List Page: " + quizsolutionDisplayedInAllQuiz );

        if (quizsolutionDisplayedInAllQuiz) {
            WebElement quizsolution = driver.findElement ( xpath ( "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt1-solution-button\"]/child::*[text()=' Solution '])[1]" ) );
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

            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();

            // Clicking The Analysis Button In The MY Notes
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-background-ghost ant-btn-block quiz-attempt1-solution-button\"]/child::*[text()=' Analysis '])[1]" ) );
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

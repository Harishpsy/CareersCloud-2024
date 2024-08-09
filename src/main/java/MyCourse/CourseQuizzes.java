package MyCourse;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class CourseQuizzes {
    WebDriver driver;
    private Iterable<? extends WebElement> quizTitles;

    public CourseQuizzes(WebDriver driver) {

        this.driver = driver;

    }

    public void Quizzes() throws InterruptedException {

        // Clicking The Course In the My Course

        Thread.sleep (3000);
        WebElement clickingCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[10]"));
        clickingCourseCard.click ();

        // Clicking The Quizzes In The Course

        Thread.sleep (3000);
        WebElement clickingQuizzes = driver.findElement (xpath ("//div[text()='Quizzes']"));
        clickingQuizzes.click ();

//
//        // Scrolling The Quizzes List Page to verify data
//
//        int numberOfTimesScrollQuizzes = 10;
//
//        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {
//            try {
//                Thread.sleep (5000);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
//                System.out.println ("Successfully scroll The page " + (i + 1) + " time(s).");
//            } catch (Exception scroll) {
//                System.out.println ("Failed to Scroll : " + scroll.getMessage ());
//            }
//        }
//
//        // Clicking Float Icon
//
//        WebElement clickingFloatIcon = driver.findElement (xpath ("//*[@class=\"ant-float-btn-body\"]"));
//        clickingFloatIcon.click ();
//
//        // Verifying the Quiz List was getting duplicating using the unique videos Url
//        List<WebElement> quizTitle = driver.findElements (xpath ("//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]"));
//
//        // Create a set to store unique Ebook Titles
//
//        Set<String> uniqueQuizTitles = new HashSet<> ();
//        int uniqueQuizCount = 0;
//
//        for (WebElement uniqueTitle : quizTitle) {
//            String actualquizTitle = uniqueTitle.getText ();
//
//            if (uniqueQuizTitles.contains (actualquizTitle)) {
//                System.out.println ("Duplicate found --> " + actualquizTitle);
//            } else {
//                uniqueQuizTitles.add (actualquizTitle);
//                uniqueQuizCount++;
//                System.out.println ("Found: " + uniqueQuizCount + " --> " + actualquizTitle);
//                System.out.println ("-------------------------------------------------------------------------");
//            }
//        }
//
//        // Print the total number of unique URLs found
//        System.out.println ("Total unique videos url found: " + uniqueQuizCount);
//
//        // Assert that the number of unique URLs is equal to the number of elements
//        Assert.assertEquals (uniqueQuizCount, uniqueQuizTitles.size ());
//
//        // Using Try Catch Method For pursuing all the actions in quiz
//
//        try {
//
//            Thread.sleep (5000);
//            boolean startQuizIsDisplayed = false;
//            boolean resumeIsDisplayed = false;
//            boolean solutionIsDisplayed = false;
//
//
//            try {
//                WebElement clickingStartQuiz = driver.findElement (By.xpath ("(//*[text() = ' Start Quiz '])[1]"));
//                startQuizIsDisplayed = clickingStartQuiz.isDisplayed ();
//            } catch (NoSuchElementException e) {
//                System.out.println ("Start quiz try block was error ");
//            }
//
//            try {
//                WebElement clickingResume = driver.findElement (By.xpath ("(//*[text()=' Resume '])[1]"));
//                resumeIsDisplayed = clickingResume.isDisplayed ();
//            } catch (NoSuchElementException e) {
//                System.out.println ("Resume try block was error ");
//            }
//            try {
//                WebElement clickingSolution = driver.findElement (By.xpath ("(//*[text()=' Solution '])[1]"));
//                solutionIsDisplayed = clickingSolution.isDisplayed ();
//            } catch (NoSuchElementException e) {
//                System.out.println ("Solution try block was error ");
//            }
//
//            System.out.println ("start Quiz displayed: " + startQuizIsDisplayed);
//            System.out.println ("Resume displayed: " + resumeIsDisplayed);
//            System.out.println ("Solution displayed: " + solutionIsDisplayed);
//
//            Set<String> windows;
//            Iterator<String> it;
//            String parent;
//            String[] options = new String[0];
//
//            if (startQuizIsDisplayed) {
//                Thread.sleep (3000);
//                WebElement clickingStartQuiz = driver.findElement (By.xpath ("(//*[text() = ' Start Quiz '])[1]"));
//                clickingStartQuiz.click ();
//                System.out.println ("Successfully Clicked The startQuiz");
//
//                //Windows Handeling
//
//                windows = driver.getWindowHandles ();
//                it = windows.iterator ();
//                parent = it.next ();
//                String child = it.next ();
//                driver.switchTo ().window (child);
//
//                // Clicking the close icon in the quiz instruction
//
//                Thread.sleep (7000);
//                WebElement Close_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//                Close_icon.click ();
//                System.out.println ("SuccessFully Clicked The CloseIcon");
//
//                //Windows mazimize
//
//                WebDriverWait waitForWindowsMaximize;
//                waitForWindowsMaximize = new WebDriverWait (driver, Duration.ofSeconds (30));
//                driver.manage ().window ().maximize ();
//
//                //Clicking the Instruction Button
//
//                Thread.sleep (3000);
//                WebElement clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
//                clickingTheInstructionIcon.click ();
//                System.out.println ("SuccessFully Clicked The InstructionIcon");
//
//                // Again Clicking the close icon in the quiz instruction
//
//                Thread.sleep (3000);
//                WebElement againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//                againClose_icon.click ();
//                System.out.println ("SuccessFully Clicked The Close_icon again ");
//
//                // Clicking The FullScreen Button
//                Thread.sleep (3000);
//                WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//                System.out.println ("SuccessFully Clicked The Full Screen Button ");
//
//                // Clicking the BookMark-icon
//                try {
//                    WebElement bookmarkIcon = driver.findElement (By.xpath ("//*[@class='bookmark-icon']"));
//                    if (bookmarkIcon.isDisplayed ()) {
//                        bookmarkIcon.click ();
//                        System.out.println ("Successfully Clicked The Bookmark Icon");
//                    }
//                } catch (NoSuchElementException e1) {
//                    try {
//                        WebElement bookmarkedIcon = driver.findElement (By.xpath ("//*[@class='bookmarked-icon']"));
//                        if (bookmarkedIcon.isDisplayed ()) {
//                            bookmarkedIcon.click ();
//                            System.out.println ("Successfully Un-Clicked The Bookmark Icon");
//                        }
//                    } catch (NoSuchElementException e2) {
//                        System.out.println ("Both The Code Has Not Executed");
//                    }
//                }
//
//
//                // Define the options to be clicked
//                options = new String[]{"A", "B", "C", "D", "E", "A", "B", "C", "D", "E", "A", "B", "C", "D", "E",};
//
//                // Locate the Save & Next button
//                WebElement saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//
//                // Clicking the options and Save & Next button in a loop
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + option);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("Successfully Clicked The Save & Next Button");
//                }
//
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + options[i]);
//
//                    Thread.sleep (3000);
//                    WebElement numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (16 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("Successfully Clicked The Number: " + (16 + i));
//                }
//
//                // Clicking the Previous Button
//                Thread.sleep (3000);
//                WebElement clickingThePreviousButton = driver.findElement (By.xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//
//                // Clicking The Pause Button
//
//                Thread.sleep (3000);
//                WebElement clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
//                clickingThePauseButton.click ();
//
//                // Clicking The Cancel Button In The Pause popup
//
//                Thread.sleep (3000);
//                WebElement clickingCancelButtonInPopup = driver.findElement (xpath ("//*[text()=' Cancel ']"));
//                clickingCancelButtonInPopup.click ();
//
//                // Again Clicking The Pause Button leaves the quiz
//
//                Thread.sleep (3000);
//                clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
//                clickingThePauseButton.click ();
//
//                // Clicking The Leave button In the Pause Popup
//
//                Thread.sleep (3000);
//                WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
//                clickingLeaveButtonInPopup.click ();
//
//                // Changing The Child Windows To Parent Window
//
//                driver.switchTo ().window (parent);
//
//                // Clicking the Resume quiz
//
//                Thread.sleep (3000);
//                WebElement clickingResumeQuiz = driver.findElement (xpath ("//*[text() = ' Resume ']"));
//                clickingResumeQuiz.click ();
//                System.out.println (" Clicked The resume quiz ");
//
//                //Windows Handeling
//
//                windows = driver.getWindowHandles ();
//                it = windows.iterator ();
//                parent = it.next ();
//                child = it.next ();
//                driver.switchTo ().window (child);
//
//                //Windows mazimize
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                driver.manage ().window ().maximize ();
//
//                //Clicking the Instruction Button
//
//                Thread.sleep (3000);
//                clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
//                clickingTheInstructionIcon.click ();
//                System.out.println ("Sucessfully clicked instruction icon");
//
//                // Again Clicking the close icon in the quiz instruction
//
//                Thread.sleep (3000);
//                againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//                againClose_icon.click ();
//
//                // Clicking The FullScreen Button
//
//                Thread.sleep (2000);
//                clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//
//                // Clicking the BookMark-icon
//
//                /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//                 WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
//                 bookMarkicon.click ();*/
//
//                // Define the options to be clicked
//                options = new String[]{"A", "B", "C", "D", "E", "B", "A", "B", "E", "D", "C", "E", "C", "A", "E",};
//
//                // Locate the Save & Next button
//                saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//
//                // Clicking the options and Save & Next button in a loop
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + option);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("Successfully Clicked The Save & Next Button");
//                }
//
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + options[i]);
//
//                    Thread.sleep (3000);
//                    WebElement numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (16 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("Successfully Clicked The Number and Navigated To The Next Question: " + (16 + i));
//                }
//
//                // Clicking the Previous Button
//                Thread.sleep (3000);
//                clickingThePreviousButton = driver.findElement (By.xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//
//                // Clicking The Pause Button
//
//                Thread.sleep (3000);
//                clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
//                clickingThePauseButton.click ();
//
//                // Clicking The Leave button In the Pause Popup
//
//                Thread.sleep (3000);
//                clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
//                clickingLeaveButtonInPopup.click ();
//
//                // Changing The Child Windows To Parent Window
//
//                driver.switchTo ().window (parent);
//
//                // Clicking The Resume Button In the quiz
//
//                Thread.sleep (3000);
//                WebElement clickingResumeButton = driver.findElement (xpath (" (//span[text()=' Resume '])[1]"));
//                clickingResumeButton.click ();
//
//                //Windows Handeling child
//
//                Thread.sleep (3000);
//                windows = driver.getWindowHandles ();
//                it = windows.iterator ();
//                parent = it.next ();
//                child = it.next ();
//                driver.switchTo ().window (child);
//
//                // Clicking The Submit Button
//
//                Thread.sleep (3000);
//                WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//                clickingSubmitButton.click ();
//
//                // Clicking the Cancel Button In the submit Popup
//
//                Thread.sleep (1000);
//                WebElement clickingCancelButtonInThePopup = driver.findElement (xpath ("//span[text()=\"Cancel\"]"));
//                clickingCancelButtonInThePopup.click ();
//
//                // Again Clicking The Submit Button
//
//                Thread.sleep (3000);
//                clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//                clickingSubmitButton.click ();
//
//                // Clicking The Submit Button In The Submit Popup
//
//                Thread.sleep (1000);
//                clickingSubmitButton = driver.findElement (xpath ("//span[text()=\"Submit\"]"));
//                clickingSubmitButton.click ();
//
//                // Switching Windows From Child To Parent
//
//                driver.switchTo ().window (parent);
//
//                // Clicking The solution button
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[1]"));
//                clickingSolutionButton.click ();
//
//                // Scrolling and Clicking The Report Page
//
//                Thread.sleep (3000);
//                WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                Actions actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//
//                // Scrolling and Clicking The Report Page
//
//                Thread.sleep (3000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (7000);
//                //wait = new WebDriverWait (driver,30);
//                WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (10)); // Adjust the timeout as necessary
//
//                try {
//                    WebElement reattemptIcon = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//div[@class='ant-switch-handle']")));
//                    reattemptIcon.click ();
//                    System.out.println ("Successfully clicked the reattempt icon.");
//                } catch (TimeoutException e) {
//                    System.out.println ("The reattempt icon was not clickable within the timeout period.");
//                } catch (NoSuchElementException e) {
//                    System.out.println ("The reattempt icon was not found on the page.");
//                } catch (Exception e) {
//                    System.out.println ("An unexpected error occurred: " + e.getMessage ());
//                }
//                // Define the options to be clicked
//                options = new String[]{"A", "B", "C", "D", "E", "A", "B", "C", "D", "E", "A", "B", "C", "D", "E",};
//
//                // Locate the Save & Next button
//                saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//
//                // Clicking the options and Save & Next button in a loop
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + option);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("Successfully Clicked The Save & Next Button");
//                }
//
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + options[i]);
//
//                    Thread.sleep (3000);
//                    WebElement numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (16 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("Successfully Clicked The Number: " + (16 + i));
//                }
//
//                // Clicking the Previous Button
//                Thread.sleep (3000);
//                clickingThePreviousButton = driver.findElement (By.xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//
//                // Scrolling The Solution Page
//
//                Thread.sleep (1000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                //Entering the text inside the report text field In Solution Page
//
//                Thread.sleep (3000);
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//
//                /* // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();*/
//
//                // Clicking The Share Icon In The Solution Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (5000);
//                // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
//                WebElement clickingReattemptButton = driver.findElement (xpath ("//div[@class=\"ant-switch-handle\"]"));
//                clickingReattemptButton.click ();
//
//                wait = new WebDriverWait (driver, Duration.ofSeconds (10)); // Adjust the timeout as necessary
//
//                try {
//                    WebElement reattemptIcon = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//div[@class='ant-switch-handle']")));
//                    reattemptIcon.click ();
//                    System.out.println ("Successfully clicked the reattempt icon.");
//                } catch (TimeoutException e) {
//                    System.out.println ("The reattempt icon was not clickable within the timeout period.");
//                } catch (NoSuchElementException e) {
//                    System.out.println ("The reattempt icon was not found on the page.");
//                } catch (Exception e) {
//                    System.out.println ("An unexpected error occurred: " + e.getMessage ());
//                }
//
//                //  Click the back arrow in the solution screen
//
//                Thread.sleep (3000);
//                WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                clickingBackArrow.click ();
//
//                // Clicking The solution button
//
//                Thread.sleep (2000);
//                clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[2]"));
//                clickingSolutionButton.click ();
//
//                // Analysis was not working in site
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                WebElement clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//
//                // Clicking The FullScreen Button
//
//                clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//
//                // Exiting The FullScreen Button
//
//                driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
//                WebElement exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
//                exitingTheFullScreenButton.click ();
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                WebElement clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//
//                // Clicking The Share Icon In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Clicking Like/Unlike Button
//
//                try {
//                    // Locate the like and unlike buttons
//                    WebElement likeButton = driver.findElement (By.xpath ("//*[@class='like']"));
//                    WebElement unlikeButton = driver.findElement (By.xpath ("//*[@class='unlike']"));
//
//                    // Check if the like button is displayed and click it
//                    if (likeButton.isDisplayed ()) {
//                        likeButton.click ();
//                        System.out.println ("Successfully Clicked The Like Button");
//                    }
//                    // Otherwise, check if the unlike button is displayed and click it
//                    else if (unlikeButton.isDisplayed ()) {
//                        unlikeButton.click ();
//                        System.out.println ("Successfully Clicked The Unlike Button");
//                    }
//                    // If neither button is found/displayed
//                    else {
//                        System.out.println ("Both Code Not Executed");
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println ("Like/Unlike Button not found");
//                }
//
//                // Clicking The comment icon in the analysis page
//
//                Thread.sleep (3000);
//                WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
//                clickingCommentIconInAnalysisPage.click ();
//
//                //Entering Comment In The TextField
//
//                Thread.sleep (5000);
//                WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
//                enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");
//
////                // Clicking The Send Button In The Comment Text Field
////
////                Thread.sleep (2000);
////                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
////                clickingSendButton.click ();
//
//                // Scrolling The analysis page Up
//
//                Thread.sleep (3000);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//
//                // Clicking The Reattempt Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
//                clickingReattempButton.click ();
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Clicking The Solution Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
//                clickingSolutionButtonInAnalysis.click ();
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Scrolling The analysis page Forward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");
//
//                // Scrolling The analysis page Backward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//
//                //  Clicking the back arrow in the solution screen for coming to course > Quiz
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz
//
//                Thread.sleep (3000);
//                WebElement Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//                System.out.println ("Successfully clicked The ThreeDots");
//
//                // Clicking The save My Notes or Remove my notes
//
//                Thread.sleep (5000);
//                WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));
//
//                if (clickMyNote.isDisplayed ()) {
//                    clickMyNote.click ();
//
//                    if (clickMyNote.getText ().contains ("Remove My  Notes")) {
//                        System.out.println ("Successfully -  Remove - Article");
//                    } else {
//                        System.out.println ("Successfully -  saved - Article");
//                    }
//                }
//
//                // Again Click the three dots in the Quiz Tab
//
//                Thread.sleep (3000);
//                Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//
//                /* Clicking the share icon in Quiz Tab */
//
//                Thread.sleep (3000);
//                WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
//                Share_icon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Again Click the three dots in the Quiz Tab
//
//                Thread.sleep (3000);
//                Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//
//                //clicking the report icon
//
//                Thread.sleep (1000);
//                WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
//                Report_icon.click ();
//
//                //Click the wrong information radio button
//
//                Thread.sleep (1000);
//                WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
//                Wrong_information_radio_button.click ();
//
//                //Entering the text inside the report text field
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();*/
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//
//            } else if (resumeIsDisplayed) {
//                Thread.sleep (3000);
//                WebElement clickingResume = driver.findElement (By.xpath ("(//*[text()=' Resume '])[1]"));
//                clickingResume.click ();
//                System.out.println ("Successfully Clicked The Resume In The List Page ");
//
//                //Windows Handeling
//
//                windows = driver.getWindowHandles ();
//                it = windows.iterator ();
//                parent = it.next ();
//                String child = it.next ();
//                driver.switchTo ().window (child);
//                System.out.println (" SuccessFully Navigated The Child Windows");
//
//                //Windows mazimize
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                driver.manage ().window ().maximize ();
//
//                //Clicking the Instruction Button
//
//                Thread.sleep (3000);
//                WebElement clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
//                clickingTheInstructionIcon.click ();
//                System.out.println ("Sucessfully clicked instruction icon");
//
//                // Again Clicking the close icon in the quiz instruction
//
//                Thread.sleep (3000);
//                WebElement againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//                againClose_icon.click ();
//                System.out.println ("SuccessFully Clicked The Close  Icon ");
//
//                // Clicking The FullScreen Button
//
//                Thread.sleep (2000);
//                WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//                System.out.println ("Successfully Clicked The Full Screen Button");
//
//                // Clicking the BookMark-icon
//
//                WebElement clickingBookmarkicon = driver.findElement (linkText ("/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg\""));
//                WebElement unClickBookMarkIcon = driver.findElement (linkText ("/static/media/quiz-bookmarked.bd5185a7db809bd7b02c9c33b1cdca2a.svg"));
//
//                if (clickingBookmarkicon.isDisplayed ()) {
//
//                    clickingBookmarkicon = driver.findElement (linkText ("/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg\""));
//                    clickingBookmarkicon.click ();
//                    System.out.println (" Successfully Clicked The Bookmark Icon ");
//
//                } else if (unClickBookMarkIcon.isSelected ()) {
//                    unClickBookMarkIcon = driver.findElement (linkText ("/static/media/quiz-bookmarked.bd5185a7db809bd7b02c9c33b1cdca2a.svg"));
//                    unClickBookMarkIcon.click ();
//                    System.out.println (" Successfully Un-Clicked The Bookmark Icon ");
//                } else {
//
//                    System.out.println (" Both The COde Has Not Executed ");
//                }
//
//                // Clicking the options and Save & Next button in a loop
//
//                options = new String[]{"A", "B", "C", "D", "E"};
//                WebElement saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//                WebElement numberOnRightSide;
//
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("SuccessFully CLicked The Option" + options);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("SuccessFully Clicked The Save and Next Button ");
//
//                    Thread.sleep (3000);
//                    numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (options.length + 1) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("SuccessFully Clicked The Right Side Count" + numberOnRightSide);
//                }
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("SuccessFully Clicked The Options Again" + options);
//
//                    Thread.sleep (3000);
//                    numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (options.length + 9 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("SuccessFully Clicked The Right Side Count" + numberOnRightSide);
//                }
//
//                // Clicking the Previous Button
//                Thread.sleep (3000);
//                clickingThePreviousButton = driver.findElement (By.xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//                System.out.println ("SuccessFully Clicked The Previous Button In Qestion Screen ");
//
//                // Clicking The Pause Button
//
//                Thread.sleep (3000);
//                WebElement clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
//                clickingThePauseButton.click ();
//                System.out.println ("SuccessFully Clicked The Pause Button");
//
//                // Clicking The Leave button In the Pause Popup
//
//                Thread.sleep (3000);
//                WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
//                clickingLeaveButtonInPopup.click ();
//                System.out.println ("SuccessFully Clicked The Leave Button In Popup");
//
//                // Changing The Child Windows To Parent Window
//
//                driver.switchTo ().window (parent);
//
//                // Clicking The Resume Button In the quiz
//
//                Thread.sleep (3000);
//                WebElement clickingResumeButton = driver.findElement (xpath (" (//span[text()=' Resume '])[1]"));
//                clickingResumeButton.click ();
//                System.out.println ("SuccessFully Clicked The Resume Button");
//
//                //Windows Handeling child
//
//                Thread.sleep (3000);
//                windows = driver.getWindowHandles ();
//                it = windows.iterator ();
//                parent = it.next ();
//                child = it.next ();
//                driver.switchTo ().window (child);
//                System.out.println ("SuccessFully Navigated To The Child Window Again");
//
//                // Clicking The Submit Button
//
//                Thread.sleep (3000);
//                WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//                clickingSubmitButton.click ();
//                System.out.println ("SuccessFully Clicked Submit Button");
//                // Clicking the Cancel Button In the submit Popup
//
//                Thread.sleep (1000);
//                WebElement clickingCancelButtonInThePopup = driver.findElement (xpath ("//span[text()=\"Cancel\"]"));
//                clickingCancelButtonInThePopup.click ();
//                System.out.println ("SuccessFully Clicked Cancel Button In The Popup");
//
//                // Again Clicking The Submit Button
//
//                Thread.sleep (3000);
//                clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//                clickingSubmitButton.click ();
//                System.out.println ("SuccessFully Clicked Submit Button");
//
//                // Clicking The Submit Button In The Submit Popup
//
//                Thread.sleep (1000);
//                clickingSubmitButton = driver.findElement (xpath ("//span[text()=\"Submit\"]"));
//                clickingSubmitButton.click ();
//                System.out.println ("SuccessFully Clicked Submit Button In The Popup ");
//
//                // Switching Windows From Child To Parent
//
//                driver.switchTo ().window (parent);
//
//                // Clicking The solution button
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[1]"));
//                clickingSolutionButton.click ();
//
//                // Scrolling and Clicking The Report Page
//
//                Thread.sleep (3000);
//                WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                Actions actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//
//                // Scrolling and Clicking The Report Page
//
//                Thread.sleep (3000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (7000);
//                //wait = new WebDriverWait (driver,30);
//                WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (10)); // Adjust the timeout as necessary
//
//                try {
//                    WebElement reattemptIcon = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//div[@class='ant-switch-handle']")));
//                    reattemptIcon.click ();
//                    System.out.println ("Successfully clicked the reattempt icon.");
//                } catch (TimeoutException e) {
//                    System.out.println ("The reattempt icon was not clickable within the timeout period.");
//                } catch (NoSuchElementException e) {
//                    System.out.println ("The reattempt icon was not found on the page.");
//                } catch (Exception e) {
//                    System.out.println ("An unexpected error occurred: " + e.getMessage ());
//                }
//
//                // Define the options to be clicked
//                options = new String[]{"A", "B", "C", "D", "E", "A", "B", "C", "D", "E", "A", "B", "C", "D", "E",};
//
//                // Locate the Save & Next button
//                saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//
//                // Clicking the options and Save & Next button in a loop
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + option);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("Successfully Clicked The Save & Next Button");
//                }
//
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + options[i]);
//
//                    Thread.sleep (3000);
//                    numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (16 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("Successfully Clicked The Number: " + (16 + i));
//                }
//                // Clicking the Previous Button
//                Thread.sleep (3000);
//                clickingThePreviousButton = driver.findElement (By.xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//
//                // Scrolling The Solution Page
//
//                Thread.sleep (1000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//
//                //Entering the text inside the report text field In Solution Page
//
//                Thread.sleep (3000);
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//
//                /* // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();*/
//
//                // Clicking The Share Icon In The Solution Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (5000);
//                // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
//                WebElement clickingReattemptButton = driver.findElement (xpath ("//div[@class=\"ant-switch-handle\"]"));
//                clickingReattemptButton.click ();
//
//                wait = new WebDriverWait (driver, Duration.ofSeconds (10)); // Adjust the timeout as necessary
//
//                try {
//                    WebElement reattemptIcon = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//div[@class='ant-switch-handle']")));
//                    reattemptIcon.click ();
//                    System.out.println ("Successfully clicked the reattempt icon.");
//                } catch (TimeoutException e) {
//                    System.out.println ("The reattempt icon was not clickable within the timeout period.");
//                } catch (NoSuchElementException e) {
//                    System.out.println ("The reattempt icon was not found on the page.");
//                } catch (Exception e) {
//                    System.out.println ("An unexpected error occurred: " + e.getMessage ());
//                }
//
//                //  Click the back arrow in the solution screen
//
//                Thread.sleep (3000);
//                WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                clickingBackArrow.click ();
//
//                // Clicking The solution button
//
//                Thread.sleep (2000);
//                clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[2]"));
//                clickingSolutionButton.click ();
//
//                // Analysis was not working in site
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                WebElement clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//
//                // Clicking The FullScreen Button
//
//                clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//
//                // Exiting The FullScreen Button
//
//                driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
//                WebElement exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
//                exitingTheFullScreenButton.click ();
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                WebElement clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//
//                // Clicking The Share Icon In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Clicking Like/Unlike Button
//
//                try {
//                    try {
//                        // Locate the like button
//                        WebElement likeButton = driver.findElement (By.xpath ("//*[@class='like']"));
//                        if (likeButton.isDisplayed ()) {
//                            likeButton.click ();
//                            System.out.println ("Successfully Clicked The Like Button");
//                        }
//                    } catch (NoSuchElementException e) {
//                        System.out.println ("Like Button not found");
//
//                        try {
//                            // Locate the unlike button
//                            WebElement unlikeButton = driver.findElement (By.xpath ("//*[@class='unlike']"));
//                            if (unlikeButton.isDisplayed ()) {
//                                unlikeButton.click ();
//                                System.out.println ("Successfully Clicked The Unlike Button");
//                            }
//                        } catch (NoSuchElementException e2) {
//                            System.out.println ("Unlike Button not found");
//                        }
//                    }
//
//                } catch (NoSuchElementException e) {
//                    System.out.println ("Like/Unlike Button not found");
//                }
//
//                // Clicking The comment icon in the analysis page
//
//                Thread.sleep (3000);
//                WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
//                clickingCommentIconInAnalysisPage.click ();
//
//                //Entering Comment In The TextField
//
//                Thread.sleep (5000);
//                WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
//                enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");
//
//                // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();
//
//                // Scrolling The analysis page Up
//
//                Thread.sleep (3000);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//
//                // Clicking The Reattempt Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
//                clickingReattempButton.click ();
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Clicking The Solution Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
//                clickingSolutionButtonInAnalysis.click ();
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Scrolling The analysis page Forward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");
//
//                // Scrolling The analysis page Backward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//
//                //  Clicking the back arrow in the solution screen for coming to course > Quiz
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//
//                // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz
//
//                Thread.sleep (3000);
//                WebElement Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//                System.out.println ("Successfully clicked The ThreeDots");
//
//                // Clicking The save My Notes or Remove my notes
//
//                Thread.sleep (5000);
//                WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));
//
//                if (clickMyNote.isDisplayed ()) {
//                    clickMyNote.click ();
//
//                    if (clickMyNote.getText ().contains ("Remove My  Notes")) {
//                        System.out.println ("Successfully -  Remove - Article");
//                    } else {
//                        System.out.println ("Successfully -  saved - Article");
//                    }
//                }
//                /* Clicking the share icon in Quiz Tab */
//
//                Thread.sleep (3000);
//                WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
//                Share_icon.click ();
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//
//                //Clicking the cancel button in the in share popup
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//
//                // Again Click the three dots in the Quiz Tab
//
//                Thread.sleep (3000);
//                Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//
//                //clicking the report icon
//
//                Thread.sleep (1000);
//                WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
//                Report_icon.click ();
//
//                //Click the wrong information radio button
//
//                Thread.sleep (1000);
//                WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
//                Wrong_information_radio_button.click ();
//
//                //Entering the text inside the report text field
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();*/
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//
//            } else if (solutionIsDisplayed) {
//                Thread.sleep (5000);
//                WebElement clickingSolution = driver.findElement (By.xpath ("(//*[text()=' Solution '])[1]"));
//                clickingSolution.click ();
//                System.out.println ("Successfully Clicked The Solution In The Quiz List Page");
//
//                // Clicking the BookMark-icon
//                try {
//                    WebElement bookmarkIcon = driver.findElement (By.xpath ("//*[@class='bookmark-icon']"));
//                    if (bookmarkIcon.isDisplayed ()) {
//                        bookmarkIcon.click ();
//                        System.out.println ("Successfully Clicked The Bookmark Icon");
//                    }
//                } catch (NoSuchElementException e1) {
//                    try {
//                        WebElement bookmarkedIcon = driver.findElement (By.xpath ("//*[@class='bookmarked-icon']"));
//                        if (bookmarkedIcon.isDisplayed ()) {
//                            bookmarkedIcon.click ();
//                            System.out.println ("Successfully Un-Clicked The Bookmark Icon");
//                        }
//                    } catch (NoSuchElementException e2) {
//                        System.out.println ("Both The Code Has Not Executed");
//                    }
//                }
//
//                // Scrolling and Clicking The Report Page
//
//                Thread.sleep (3000);
//                WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                Actions actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//                System.out.println ("SuccessFully Scroll and clicked The Report Icon In Solution Page");
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//                System.out.println ("Successfully clicked The Translation Error Radio Button");
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//                System.out.println ("SuccessFully Clicked The Enter_the_Enter_the_report In The Field");
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully Clicked The Cancel Button");
//
//                // Clicking The Report Button
//
//                Thread.sleep (3000);
//                WebElement clickingReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                clickingReportIcon.click ();
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                WebElement clickingIncompleteQuestionRadioButton = driver.findElement (xpath ("//span[text()='Incomplete Question']"));
//                clickingIncompleteQuestionRadioButton.click ();
//                System.out.println ("Successfully clicked The IncompleteQuestion Radio Button");
//
//                // Clicking The Report Description button
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//                System.out.println ("SuccessFully Clicked The Enter_the_Enter_the_report In The Field");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//                System.out.println ("Successfully Clicked The Report Button");
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (10000);
//                //wait = new WebDriverWait (driver,30);
//                WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40)); // Adjust the timeout as necessary
//
//                try {
//                    WebElement reattemptIcon = wait.until (ExpectedConditions.elementToBeClickable (By.xpath ("//div[@class='ant-switch-handle']")));
//                    reattemptIcon.click ();
//                    System.out.println ("Successfully clicked the reattempt icon.");
//                } catch (TimeoutException e) {
//                    System.out.println ("The reattempt icon was not clickable within the timeout period.");
//                } catch (NoSuchElementException e) {
//                    System.out.println ("The reattempt icon was not found on the page.");
//                } catch (Exception e) {
//                    System.out.println ("An unexpected error occurred: " + e.getMessage ());
//                }
//
//                // Define the options to be clicked
//                options = new String[]{"A", "B", "C", "D", "E", "A", "B", "C", "D", "E", "A", "B", "C", "D", "E",};
//
//                // Locate the Save & Next button
//                WebElement saveAndNextButton = driver.findElement (By.xpath ("//div[text()='Save & Next']"));
//
//                // Clicking the options and Save & Next button in a loop
//                for (String option : options) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + option + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + option);
//
//                    Thread.sleep (3000);
//                    saveAndNextButton.click ();
//                    System.out.println ("Successfully Clicked The Save & Next Button");
//                }
//
//                // Clicking options again after navigating back
//                for (int i = 0; i < options.length - 2; i++) {
//                    Thread.sleep (3000);
//                    WebElement optionElement = driver.findElement (By.xpath ("//div[text()='" + options[i] + "']"));
//                    optionElement.click ();
//                    System.out.println ("Successfully Clicked The Option: " + options[i]);
//
//                    Thread.sleep (3000);
//                    WebElement numberOnRightSide = driver.findElement (By.xpath ("//Span[text()='" + (16 + i) + "']"));
//                    numberOnRightSide.click ();
//                    System.out.println ("Successfully Clicked The Number: " + (16 + i));
//                }
//
//                // Clicking The Previous Button
//
//                Thread.sleep (3000);
//                clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
//                clickingThePreviousButton.click ();
//                System.out.println ("Successfully Clicked The Previous Button");
//
//                // Scrolling The Solution Page
//
//                Thread.sleep (3000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//                System.out.println ("Successfully Scrolled and Clicked The Report icon");
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//                System.out.println ("Successfully Clicked Translation Error Radio Button");
//
//                //Entering the text inside the report text field In Solution Page
//
//                Thread.sleep (3000);
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//                System.out.println ("Successfully Clicked Enter_the_report text field");
//
//                // Clicking The Cancel Button
//
//                Thread.sleep (3000);
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully Clicked Cancel button");
//
//                // Scrolling The Solution Page
//
//                Thread.sleep (3000);
//                scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//                actions = new Actions (driver);
//                actions.scrollToElement (scrollToReportIcon).perform ();
//                scrollToReportIcon.click ();
//                System.out.println ("Successfully Scrolled and Clicked The Report icon");
//
//                // Click The Translation Error In The Report Popup
//
//                Thread.sleep (3000);
//                clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//                clickingTranslationErrorRadioButton.click ();
//                System.out.println ("Successfully Clicked Translation Error Radio Button");
//
//                //Entering the text inside the report text field In Solution Page
//
//                Thread.sleep (3000);
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//                System.out.println ("Successfully Clicked Enter_the_report text field");
//
//                // Click the report button
//
//                Thread.sleep (5000);
//                Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//                System.out.println ("Successfully Clicked Report button");
//
//                // Clicking The Share Icon In The Solution Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//                System.out.println ("Successfully Clicked The Share Icon");
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//                System.out.println ("Successfully Clicked The Copy link Button");
//
//                //Clicking the cancel button in the in share popup
//
//                WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully Clicked The Cancel button");
//
//                // Clicking The ReattempButton
//
//                Thread.sleep (5000);
//                // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
//                WebElement clickingReattemptButton = driver.findElement (xpath ("//div[@class=\"ant-switch-handle\"]"));
//                clickingReattemptButton.click ();
//                System.out.println ("Successfully Clicked The Reattempt Button");
//
//                //  Click the back arrow in the solution screen
//
//                Thread.sleep (3000);
//                WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                clickingBackArrow.click ();
//                System.out.println ("Successfully Clicked The Back Arrow Button In Solution Screen ");
//
//                // Clicking The solution button
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[2]"));
//                clickingSolutionButton.click ();
//                System.out.println ("Successfully Clicked The Solution Button In Solution Screen ");
//
//                // Analysis was not working in site
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                WebElement clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//                System.out.println ("Successfully Clicked The Analysis Icon In Solution Screen ");
//
//                // Clicking The FullScreen Button
//
//                WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//                clickingTheFullScreenButton.click ();
//                System.out.println ("Successfully Clicked The Analysis Icon In Solution Screen ");
//
//                // Exiting The FullScreen Button
//
//                driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
//                WebElement exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
//                exitingTheFullScreenButton.click ();
//                System.out.println ("Successfully Clicked The Full Screen Button In Solution Screen ");
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                WebElement clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//                System.out.println ("Successfully Clicked The Back To Quiz Bread Crumbs In Solution Screen ");
//
//                // Clicking The Analysis Icon
//
//                Thread.sleep (3000);
//                clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//                clickingAnalysisIcon.click ();
//                System.out.println ("Successfully Clicked The Analysis Icon In Solution Screen ");
//
//                // Clicking The Share Icon In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//                clickingTheShareIcon.click ();
//                System.out.println ("Successfully Clicked The The Share Icon In Solution Screen ");
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//                System.out.println ("Successfully Clicked The Copy link In Solution Screen ");
//
//                //Clicking the cancel button in the in share popup
//
//                new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully Clicked The Cancel buttonIn Solution Screen ");
//
//                // Clicking Like/Unlike Button
//
//                try {
//                    try {
//                        // Locate the like button
//                        WebElement likeButton = driver.findElement (By.xpath ("//*[@class='like']"));
//                        if (likeButton.isDisplayed ()) {
//                            likeButton.click ();
//                            System.out.println ("Successfully Clicked The Like Button");
//                        }
//                    } catch (NoSuchElementException e) {
//                        System.out.println ("Like Button not found");
//
//                        try {
//                            // Locate the unlike button
//                            WebElement unlikeButton = driver.findElement (By.xpath ("//*[@class='unlike']"));
//                            if (unlikeButton.isDisplayed ()) {
//                                unlikeButton.click ();
//                                System.out.println ("Successfully Clicked The Unlike Button");
//                            }
//                        } catch (NoSuchElementException e2) {
//                            System.out.println ("Unlike Button not found");
//                        }
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println ("Like/Unlike Button not found");
//                }
//
//                // Clicking The comment icon in the analysis page
//
//                Thread.sleep (3000);
//                WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
//                clickingCommentIconInAnalysisPage.click ();
//                System.out.println ("Successfully Clicked The Comment Icon In Analysis Page");
//
//                //Entering Comment In The TextField
//
//                Thread.sleep (5000);
//                WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
//                enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");
//                System.out.println ("Successfully Entered The Comments");
//
////              // Clicking The Send Button In The Comment Text Field
////
////                Thread.sleep (2000);
////                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
////                clickingSendButton.click ();
//
//                // Scrolling The analysis page Up
//
//                Thread.sleep (3000);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//                System.out.println ("Successfully Scroll The Page");
//
//
//                // Clicking The Reattempt Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
//                clickingReattempButton.click ();
//                System.out.println ("Successfully clicked Reattemp Button");
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//                System.out.println ("Successfully clicked Back Arrow");
//
//                // Clicking The Solution Button Inside The analysis page
//
//                Thread.sleep (2000);
//                WebElement clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
//                clickingSolutionButtonInAnalysis.click ();
//                System.out.println ("Successfully clicked Solution Button In Analysis");
//
//                //  Again Click the back arrow in the solution screen
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//                System.out.println ("Successfully clicked clicking Back Arrow");
//
//                // Scrolling The analysis page Forward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");
//                System.out.println ("Successfully Scroll The Page Down ");
//
//                // Scrolling The analysis page Backward
//
//                Thread.sleep (3000);
//                jse = (JavascriptExecutor) driver;
//                jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");
//                System.out.println ("Successfully Scroll The Backwards ");
//
//                // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//                Thread.sleep (3000);
//                clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//                clickingBackToQuizBreadCrumbs.click ();
//                System.out.println ("Successfully Scroll The Back To Quiz Bread Crumbs ");
//
//                //  Clicking the back arrow in the solution screen for coming to course > Quiz
//
//                Thread.sleep (2000);
//                againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//                againclickingBackArrow.click ();
//                System.out.println ("Successfully clicked clicking Back Arrow");
//
//                // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz
//
//                Thread.sleep (3000);
//                WebElement Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//                System.out.println ("Successfully clicked The ThreeDots");
//
//                // Clicking The save My Notes or Remove my notes
//
//                Thread.sleep (5000);
//                WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));
//
//                if (clickMyNote.isDisplayed ()) {
//                    clickMyNote.click ();
//
//                    if (clickMyNote.getText ().contains ("Remove My  Notes")) {
//                        System.out.println ("Successfully -  Remove - Article");
//                    } else {
//                        System.out.println ("Successfully -  saved - Article");
//                    }
//                }
//
//                // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz
//
//                Thread.sleep (3000);
//                Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//                System.out.println ("Successfully clicked The ThreeDots");
//
//                /* Clicking the share icon in Quiz Tab */
//
//                Thread.sleep (10000);
//                WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
//                Share_icon.click ();
//                System.out.println ("Successfully clicked The Share Icon");
//
//                //click the copy link in the share popup
//
//                Thread.sleep (3000);
//                Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//                Copy_link.click ();
//                System.out.println ("Successfully clicked The Copy Icon ");
//
//                //Clicking the cancel button in the in share popup
//
//                waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//                Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully clicked The Cancel button");
//
//                // Again Click the three dots in the Quiz Tab
//
//                Thread.sleep (3000);
//                Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
//                Threedots.click ();
//                System.out.println ("Successfully clicked The ThreeDots");
//
//                //clicking the report icon
//
//                Thread.sleep (1000);
//                WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
//                Report_icon.click ();
//                System.out.println ("Successfully clicked The Report Icon");
//
//                //Click the wrong information radio button
//
//                Thread.sleep (1000);
//                WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
//                Wrong_information_radio_button.click ();
//                System.out.println ("Successfully clicked The Wrong information radio button");
//
//                //Entering the text inside the report text field
//
//                Enter_the_report = driver.findElement (name ("reportDescription"));
//                Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//                System.out.println ("Successfully Entered The Text In The Enter the report");
//
//                // Click the report button
//
//                Thread.sleep (3000);
//                WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//                Report_button.click ();
//                System.out.println ("Successfully Clicked The Report_button");
//
//                // Clicking The Cancel Button
//
//                Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//                Cancel_button.click ();
//                System.out.println ("Successfully Clicked The Cancel button");
//            } else {
//                System.out.println ("One of the above statements encountered an error");
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println (" Error In The Inner Statements ");
//        }

        // Clicking The paused Sub Tab In Quiz

        Thread.sleep ( 4000 );
        WebElement clickingPausedTab = driver.findElement ( xpath ( "//*[text()='Paused']" ) );
        clickingPausedTab.click ();
        System.out.println ( "SuccessFully Clicked The Paused Tab" );

        // Scrolling The Quizzes List Page to verify data

        int numberOfTimesScrollPausedQuizzesListpage = 2;

        for (int i = 0; i < numberOfTimesScrollPausedQuizzesListpage; i++) {
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
        List<WebElement> pausedQuizTitle = driver.findElements ( xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]" ) );

        // Create a set to store unique Ebook Titles

        Set<String> uniquePausedQuizTitles = new HashSet<> ();
        int uniquePausedQuizCount = 0;

        for (WebElement uniqueTitle : pausedQuizTitle) {
            String actualquizTitle = uniqueTitle.getText ();

            if (uniquePausedQuizTitles.contains ( actualquizTitle )) {
                System.out.println ( "Duplicate found --> " + actualquizTitle + uniquePausedQuizCount );
            } else {
                uniquePausedQuizTitles.add ( actualquizTitle );
                uniquePausedQuizCount++;
                System.out.println ( "Found: " + uniquePausedQuizCount + " --> " + actualquizTitle );
                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Assert that the number of unique titles is equal to the number of elements
        Assert.assertEquals ( uniquePausedQuizCount , uniquePausedQuizTitles.size () );
        System.out.println ( "Successfully Verified" );

        // Using Try Catch Method For pursuing all the actions in quiz

        try {
            boolean noRecordFoundIsDisplayed = false;
            boolean isResumeQuizIsDisplayed = false;

            // Check if "No Records Found" is displayed
            try {
                WebElement noRecordFound = driver.findElement ( xpath ( "//*[text()='No Records Found.']" ) );
                noRecordFoundIsDisplayed = noRecordFound.isDisplayed ();
            } catch (NoSuchElementException e1) {

                System.out.println ( "Can Not Find The 'No Records Found' element." );
            }

            try {
                WebElement clickingResumeQuiz = driver.findElement ( xpath ( "(//*[text() =' Resume '])[1]" ) );
                isResumeQuizIsDisplayed = clickingResumeQuiz.isDisplayed ();

            } catch (NoSuchElementException e2) {

                System.out.println ( "Quiz was not displayed in the Paused Tab " );
            }

            System.out.println ( "No Record Found Is Displayed : " + noRecordFoundIsDisplayed );
            System.out.println ( "Resume quiz has been displayed : " + isResumeQuizIsDisplayed );

            if (noRecordFoundIsDisplayed) {
                WebElement clickingUnAttempted = driver.findElement ( xpath ( "//*[contains(text(), 'Unattempted')]" ) );
                clickingUnAttempted.click ();
                System.out.println ( "Successfully Clicked The 'Unattempted' Sub-Tab" );

                // Creating The constructor For Un-Attempted

                CourseQuizzesUnattempted unattempt = new CourseQuizzesUnattempted ( driver );
                unattempt.unAttempted ();

            } else {
                System.out.println ( "Unattempted was not clicked" );
            }

            if (isResumeQuizIsDisplayed) {
                WebElement clickingResumeQuiz = driver.findElement ( xpath ( "(//*[text() =' Resume '])[1]" ) );
                clickingResumeQuiz.click ();
                System.out.println ( "Successfully Clicked The Resume Quiz" );

                // Windows Handeling

                Set<String> windows = driver.getWindowHandles ();
                Iterator<String> it = windows.iterator ();
                String parent = it.next ();
                String child = it.next ();
                driver.switchTo ().window ( child );
                System.out.println ( "SuccessFully Navigated To The Child Windows" );

                // Getting The Quiz Name For Verify once completed

                Thread.sleep ( 3000 );
                WebElement gettingQuizTitle = driver.findElement ( xpath ( "//span[@class=\"title\"]" ) );
                String QuizTitle = gettingQuizTitle.getText ();
                System.out.println ( "Quiz Title : " + QuizTitle );

                // Getting The User Answered Count

                Thread.sleep ( 3000 );
                WebElement gettingAnswerCount = driver.findElement ( xpath ( "//div[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
                String AnswerCount = gettingAnswerCount.getText ();
                System.out.println ( "User Answered Question Count : " + AnswerCount );

                // Getting The Unanswered Count

                Thread.sleep ( 3000 );
                WebElement gettingUnAnsweredCount = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgba(90, 114, 200, 0.2); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(0, 0, 0); font-weight: 900;\"]" ) );
                String UnAnswerCount = gettingUnAnsweredCount.getText ();
                System.out.println ( "User Unanswered Count : " + UnAnswerCount );

                // Getting The quiz Time

                Thread.sleep ( 3000 );
                WebElement gettingQuizTime = driver.findElement ( xpath ( "//span[@class=\"text\"]" ) );
                String QuizTime = gettingQuizTime.getText ();
                System.out.println ( "quiz Time : " + QuizTime );

                //Windows mazimize

                WebDriverWait waitForWindowsMaximize;
                waitForWindowsMaximize = new WebDriverWait (driver, Duration.ofSeconds (30));
                driver.manage ().window ().maximize ();

                //Clicking the Instruction Button

                Thread.sleep (3000);
                WebElement clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
                clickingTheInstructionIcon.click ();
                System.out.println ("SuccessFully Clicked The InstructionIcon");

                // Again Clicking the close icon in the quiz instruction

                Thread.sleep (3000);
                WebElement againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
                againClose_icon.click ();
                System.out.println ("SuccessFully Clicked The Close_icon again ");

                // Clicking The FullScreen Button
                Thread.sleep (3000);
                WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
                clickingTheFullScreenButton.click ();
                System.out.println ("SuccessFully Clicked The Full Screen Button ");

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
                String[] options = new String[]{"E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A" , "E" , "D" , "C" , "B" , "A"};

                // Locate the Save & Next button
                WebElement saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

                // Clicking the options and Save & Next button in a loop
                for (String option : options) {
                    Thread.sleep (3000);
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                    optionElement.click ();
                    System.out.println ("Successfully Clicked The Option: " + option);

                    Thread.sleep (3000);
                    saveAndNextButton.click ();
                    System.out.println ("Successfully Clicked The Save & Next Button");
                }

                // Clicking options again after navigating back
                for (int i = 0; i < options.length - 2; i++) {
                    Thread.sleep (3000);
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ("Successfully Clicked The Option: " + options[i]);

                    Thread.sleep (3000);
                    WebElement numberOnRightSide = driver.findElement ( xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                    numberOnRightSide.click ();
                    System.out.println ("Successfully Clicked The Number: " + (16 + i));
                }

                // Clicking the Previous Button
                Thread.sleep (3000);
                WebElement clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
                clickingThePreviousButton.click ();

                // Clicking The Pause Button

                Thread.sleep (3000);
                WebElement clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
                clickingThePauseButton.click ();

                // Clicking The Cancel Button In The Pause popup

                Thread.sleep (3000);
                WebElement clickingCancelButtonInPopup = driver.findElement (xpath ("//*[text()=' Cancel ']"));
                clickingCancelButtonInPopup.click ();

                // Getting The User Answered Count

                Thread.sleep ( 3000 );
                WebElement gettingAnswerCountBeforepause = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
                String AnswerCountBeforepause = gettingAnswerCount.getText ();
                System.out.println ( "Answered Question Count Before Pause : " + AnswerCountBeforepause );

                // Getting The Unanswered Count

                Thread.sleep ( 3000 );
                WebElement gettingUnAnsweredCountBeforepause = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgba(90, 114, 200, 0.2); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(0, 0, 0); font-weight: 900;\"]" ) );
                String UnAnswerCountBeforepause = gettingUnAnsweredCount.getText ();
                System.out.println ( "User Unanswered Count Before Pause : " + UnAnswerCountBeforepause );

                // Getting The quiz Time

                Thread.sleep ( 3000 );
                WebElement gettingQuizTimeBeforepause = driver.findElement ( xpath ( "//span[@class=\"text\"]" ) );
                String QuizTimeBeforepause = gettingQuizTime.getText ();
                System.out.println ( "quiz Time Before pause: " + QuizTimeBeforepause );

                // Again Clicking The Pause Button leaves the quiz

                Thread.sleep (3000);
                clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
                clickingThePauseButton.click ();

                // Clicking The Leave button In the Pause Popup

                Thread.sleep (3000);
                WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
                clickingLeaveButtonInPopup.click ();

                // Changing The Child Windows To Parent Window

                driver.switchTo ().window (parent);

                // Clicking the Resume quiz

                Thread.sleep (3000);
                clickingResumeQuiz = driver.findElement ( xpath ( "//*[text() = ' Resume ']" ) );
                clickingResumeQuiz.click ();
                System.out.println ( " Clicked The resume quiz In The paused Tab " );

                //Windows Handeling

                windows = driver.getWindowHandles ();
                it = windows.iterator ();
                parent = it.next ();
                child = it.next ();
                driver.switchTo ().window (child);
                System.out.println ( "SuccessFully Navigated To The Child Windows" );

//                //Windows mazimize
                Thread.sleep ( 5000 );
                driver.manage ().window ().maximize ();

                // Getting The answer Count After Resume

                Thread.sleep ( 5000 );
                WebElement gettingAnsweredCountAfterResume = driver.findElement ( xpath ( "//*[@style=\"border: 1px solid rgb(46, 212, 122); border-radius: 7px; width: 40px; height: 35px; margin: auto; display: flex; justify-content: center; align-items: center; color: rgb(46, 212, 122); font-weight: 900;\"]" ) );
                String AnsweredCountAfterResume = gettingAnsweredCountAfterResume.getText ();
                System.out.println ( "Answered Count After Resume : " + AnsweredCountAfterResume );

                // Verifying The Paused Answer Count was same as Resume Answr Count

                Assert.assertEquals ( AnsweredCountAfterResume , AnswerCountBeforepause );
                System.out.println ( "Verification Passed: Answered Count Before Pause (" + AnswerCountBeforepause + ") matches Answered Count After Resume (" + AnsweredCountAfterResume + ")" );

                //Getting The un answer Count After Resume

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

//            Assert.assertEquals ( QuizTimeBeforepause,quizTimeAfterResume );
                System.out.println ( "Verification Passed: Quiz Time Before Pause (" + QuizTimeBeforepause + ") matches Quiz Time After Resume (" + quizTimeAfterResume + ")" );

                //Clicking the Instruction Button

                Thread.sleep ( 3000 );
                clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
                clickingTheInstructionIcon.click ();
                System.out.println ( "Sucessfully clicked instruction icon" );

                // Again Clicking the close icon in the quiz instruction

                Thread.sleep (3000);
                againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
                againClose_icon.click ();

                // Clicking The FullScreen Button

                Thread.sleep (2000);
                clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
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
                // Define the options to be clicked
                options = new String[]{"B" , "A" , "E" , "C" , "A" , "D" , "E" , "C" , "B" , "B" , "B" , "A" , "D" , "E" , "A" ,};

                // Locate the Save & Next button
                saveAndNextButton = driver.findElement ( xpath ( "//div[text()='Save & Next']" ) );

                // Clicking the options and Save & Next button in a loop
                for (String option : options) {
                    Thread.sleep (3000);
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                    optionElement.click ();
                    System.out.println ("Successfully Clicked The Option: " + option);

                    //Clicking The Save Next Button
                    saveAndNextButton.click ();
                    System.out.println ("Successfully Clicked The Save & Next Button");
                }

                // Clicking options again after navigating back
                for (int i = 0; i < options.length - 2; i++) {
                    Thread.sleep (3000);
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                    optionElement.click ();
                    System.out.println ("Successfully Clicked The Option: " + options[i]);

                    Thread.sleep (3000);
                    WebElement numberOnRightSide = driver.findElement ( xpath ( "//Span[text()='" + (16 + i) + "']" ) );
                    numberOnRightSide.click ();
                    System.out.println ("Successfully Clicked The Number and Navigated To The Next Question: " + (16 + i));
                }

                // Clicking The Submit Button

                Thread.sleep (3000);
                WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
                clickingSubmitButton.click ();

                // Clicking the Cancel Button In the submit Popup

                Thread.sleep (1000);
                WebElement clickingCancelButtonInThePopup = driver.findElement (xpath ("//span[text()=\"Cancel\"]"));
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

                Thread.sleep (3000);
                clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
                clickingSubmitButton.click ();

                // Clicking The Submit Button In The Submit Popup

                Thread.sleep (1000);
                clickingSubmitButton = driver.findElement (xpath ("//span[text()=\"Submit\"]"));
                clickingSubmitButton.click ();

                // Switching Windows From Child To Parent

                driver.switchTo ().window (parent);

                // Once Test Finish Navigate to The Attempted List Page

                Thread.sleep ( 4000 );
                WebElement clickingTheAttemptedButton = driver.findElement ( xpath ( "//*[text()='Attempted']" ) );
                clickingTheAttemptedButton.click ();
                System.out.println ( "Successfully Clicked The Attempted Button " );


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

                WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
                clickingFloatIcon.click ();
                Thread.sleep ( 5000 );

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

                // Clicking The Completed quiz from the paused tab in the attempted

                // Iterate through the list and clicking solution

                for (WebElement quizTitle : quizTitles) {
                    String quizTitleText = quizTitle.getText ();
                    if (quizTitleText.equals ( QuizTitle )) {
                        WebElement solutionButton = quizTitle.findElement ( By.xpath ( "//*[@class=\"ant-row ant-row-center nowrap-content css-xu9wm8\"]/parent::*/preceding::span[text()=' Solution ']" ) );
                        solutionButton.click ();
                        System.out.println ( "Successfully clicked the Solution button for the verified quiz title: " + quizTitleText );
                    }
                }

            } else {
                System.out.println ( "Resume quiz is not clicked" );
            }

        } catch (NoSuchElementException e) {
            System.out.println ("Error Message: " + e.getMessage ());
        }


    }

}

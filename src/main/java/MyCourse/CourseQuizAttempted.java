package MyCourse;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class CourseQuizAttempted {

    // Creating a Constructor
    WebDriver driver;

    public CourseQuizAttempted(WebDriver driver) {
        this.driver = driver;
    }

    public CourseQuizAttempted() {
    }

    public void attemptedTab() throws InterruptedException {
        WebElement clickingAttemptedTab = driver.findElement ( By.xpath ( "//*[text()='Attempted']" ) );
        WebElement clickingSolution = driver.findElement ( By.xpath ( "(//*[text()=' Solution '])[1]" ) );
        if (clickingAttemptedTab.isEnabled ()) {
            clickingSolution.click ();
        } else if (clickingAttemptedTab.isDisplayed ()) {
            clickingAttemptedTab.click ();
            Thread.sleep ( 5000 );
            clickingSolution.click ();
            System.out.println ( "Successfully Clicked The Solution In The Quiz List Page" );

        } else if (clickingSolution.isSelected ()) {

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

        } else {
            System.out.println ( "Both the functution has not executed" );
        }
    }

    public void clickingsolutionbutton() throws InterruptedException {

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
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) ); // Adjust the timeout as necessary

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

        // Clicking The Previous Button

        Thread.sleep ( 3000 );
        WebElement clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
        clickingThePreviousButton.click ();
        System.out.println ( "Successfully Clicked The Previous Button" );

        // Scrolling The Solution Page

        Thread.sleep ( 3000 );
        scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
        actions = new Actions ( driver );
        actions.scrollToElement ( scrollToReportIcon ).perform ();
        scrollToReportIcon.click ();
        System.out.println ( "Successfully Scrolled and Clicked The Report icon" );

        // Click The Translation Error In The Report Popup

        Thread.sleep ( 3000 );
        clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
        clickingTranslationErrorRadioButton.click ();
        System.out.println ( "Successfully Clicked Translation Error Radio Button" );

        //Entering the text inside the report text field In Solution Page

        Thread.sleep ( 3000 );
        Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
        Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
        System.out.println ( "Successfully Clicked Enter_the_report text field" );

        // Clicking The Cancel Button

        Thread.sleep ( 3000 );
        Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
        Cancel_button.click ();
        System.out.println ( "Successfully Clicked Cancel button" );

        // Scrolling The Solution Page

        Thread.sleep ( 3000 );
        scrollToReportIcon = driver.findElement ( xpath ( "//*[@class=\"report-image\"]" ) );
        actions = new Actions ( driver );
        actions.scrollToElement ( scrollToReportIcon ).perform ();
        scrollToReportIcon.click ();
        System.out.println ( "Successfully Scrolled and Clicked The Report icon" );

        // Click The Translation Error In The Report Popup

        Thread.sleep ( 3000 );
        clickingTranslationErrorRadioButton = driver.findElement ( xpath ( "//span[text()='Translations Error']" ) );
        clickingTranslationErrorRadioButton.click ();
        System.out.println ( "Successfully Clicked Translation Error Radio Button" );

        //Entering the text inside the report text field In Solution Page

        Thread.sleep ( 3000 );
        Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
        Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
        System.out.println ( "Successfully Clicked Enter_the_report text field" );

        // Click the report button

        Thread.sleep ( 5000 );
        Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
        Report_button.click ();
        System.out.println ( "Successfully Clicked Report button" );

        // Clicking The Share Icon In The Solution Page

        Thread.sleep ( 3000 );
        WebElement clickingTheShareIcon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
        clickingTheShareIcon.click ();
        System.out.println ( "Successfully Clicked The Share Icon" );

        //click the copy link in the share popup

        Thread.sleep ( 3000 );
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

        Thread.sleep ( 3000 );
        WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
        clickingBackArrow.click ();
        System.out.println ( "Successfully Clicked The Back Arrow Button In Solution Screen " );

        // Clicking The solution button

        Thread.sleep ( 2000 );
        WebElement clickingSolutionButton = driver.findElement ( xpath ( "(//span[text()=' Solution '])[2]" ) );
        clickingSolutionButton.click ();
        System.out.println ( "Successfully Clicked The Solution Button In Solution Screen " );

        // Analysis was not working in site

        // Clicking The Analysis Icon

        Thread.sleep ( 3000 );
        WebElement clickingAnalysisIcon = driver.findElement ( xpath ( "//*[@class=\"image-analysis\"]" ) );
        clickingAnalysisIcon.click ();
        System.out.println ( "Successfully Clicked The Analysis Icon In Solution Screen " );

        // Clicking The FullScreen Button

        WebElement clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
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

        Thread.sleep ( 3000 );
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

//              // Clicking The Send Button In The Comment Text Field
//
//                Thread.sleep (2000);
//                WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//                clickingSendButton.click ();

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

        Thread.sleep ( 2000 );
        WebElement againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
        againclickingBackArrow.click ();
        System.out.println ( "Successfully clicked Back Arrow" );

        // Clicking The Solution Button Inside The analysis page

        Thread.sleep ( 2000 );
        WebElement clickingSolutionButtonInAnalysis = driver.findElement ( xpath ( "//span[text()=' View Solution ']" ) );
        clickingSolutionButtonInAnalysis.click ();
        System.out.println ( "Successfully clicked Solution Button In Analysis" );

        //  Again Click the back arrow in the solution screen

        Thread.sleep ( 2000 );
        againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
        againclickingBackArrow.click ();
        System.out.println ( "Successfully clicked clicking Back Arrow" );

        // Scrolling The analysis page Forward

        Thread.sleep ( 3000 );
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
        System.out.println ( "Successfully Scroll The Page Down " );

        // Scrolling The analysis page Backward

        Thread.sleep ( 3000 );
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
        System.out.println ( "Successfully Scroll The Backwards " );

        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

        Thread.sleep ( 3000 );
        clickingBackToQuizBreadCrumbs = driver.findElement ( xpath ( "//span[text()='Back to Quiz']" ) );
        clickingBackToQuizBreadCrumbs.click ();
        System.out.println ( "Successfully Scroll The Back To Quiz Bread Crumbs " );

        //  Clicking the back arrow in the solution screen for coming to course > Quiz

        Thread.sleep ( 2000 );
        againclickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
        againclickingBackArrow.click ();
        System.out.println ( "Successfully clicked clicking Back Arrow" );

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

        // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz

        Thread.sleep ( 3000 );
        Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
        Threedots.click ();
        System.out.println ( "Successfully clicked The ThreeDots" );

        /* Clicking the share icon in Quiz Tab */

        Thread.sleep ( 10000 );
        WebElement Share_icon = driver.findElement ( xpath ( "//span[text()='Share']" ) );
        Share_icon.click ();
        System.out.println ( "Successfully clicked The Share Icon" );

        //click the copy link in the share popup

        Thread.sleep ( 3000 );
        Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
        Copy_link.click ();
        System.out.println ( "Successfully clicked The Copy Icon " );

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
        Cancel_button.click ();
        System.out.println ( "Successfully clicked The Cancel button" );

        // Again Click the three dots in the Quiz Tab

        Thread.sleep ( 3000 );
        Threedots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
        Threedots.click ();
        System.out.println ( "Successfully clicked The ThreeDots" );

        //clicking the report icon

        Thread.sleep ( 1000 );
        WebElement Report_icon = driver.findElement ( xpath ( "//span[text()='Report']" ) );
        Report_icon.click ();
        System.out.println ( "Successfully clicked The Report Icon" );

        //Click the wrong information radio button

        Thread.sleep ( 1000 );
        WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
        Wrong_information_radio_button.click ();
        System.out.println ( "Successfully clicked The Wrong information radio button" );

        //Entering the text inside the report text field

        Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
        Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );
        System.out.println ( "Successfully Entered The Text In The Enter the report" );

        // Click the report button

        Thread.sleep ( 3000 );
        Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
        Report_button.click ();
        System.out.println ( "Successfully Clicked The Report_button" );

        // Clicking The Cancel Button

        Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
        Cancel_button.click ();
        System.out.println ( "Successfully Clicked The Cancel button" );
    }


}



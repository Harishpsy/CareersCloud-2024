package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class CoursePath {

    WebDriver driver;

    public CoursePath(WebDriver driver) {
        this.driver = driver;
    }

    public void Path() throws InterruptedException {

        // Clicking The My Course Button

        Thread.sleep (3000);
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//a[text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The First Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[1]"));
        clickingFirstCourseCard.click ();

        // Clicking the Sub Title In Path

        Thread.sleep (3000);
        WebElement clickingsubTitleInPath = driver.findElement (xpath ("(//*[@class=\"ant-collapse-item collapse-panel\"])[2]"));
        clickingsubTitleInPath.click ();

        // Clicking The Right Arrow In The Path sub path

        Thread.sleep (3000);
        WebElement clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[3]"));
        clickingRightArrow.click ();

        // Clicking The Right Arrow In The Path next level sub path

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[8]"));
        clickingRightArrow.click ();

        // Clicking The Right Arrow In The Path next level sub path

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[9]"));
        clickingRightArrow.click ();

        // Clicking The Quiz In THe Next Leave Sub Path

        Thread.sleep (3000);
        WebElement clickingQuiz = driver.findElement (xpath ("(//a[text()='Quiz'])[2]"));
        clickingQuiz.click ();


//        //Windows Handeling
//
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        //Clicking the close icon in the quiz instruction
//        Thread.sleep (3000);
//        WebElement Close_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//        Close_icon.click ();
//
//        //Windows mazimize
//
//        WebDriverWait waitForWindowsMaximize = new WebDriverWait (driver, Duration.ofSeconds (30));
//        driver.manage ().window ().maximize ();
//
//        //Clicking the Instruction Button
//
//
//        WebElement clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
//        clickingTheInstructionIcon.click ();
//
//        // Again Clicking the close icon in the quiz instruction
//
//        Thread.sleep (3000);
//        WebElement againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//        againClose_icon.click ();
//
//        // Clicking The FullScreen Button
//
//        Thread.sleep (2000);
//        WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//        clickingTheFullScreenButton.click ();
//
//        // Clicking the BookMark-icon
//
//        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
//        bookMarkicon.click ();*/
//
//        // Clicking the First Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
//        clickingTheOption_A.click ();
//
//        //Clicking The Save & Next Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        WebElement clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Second Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
//        clickingTheOption_B.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Third Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
//        clickingTheOption_C.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Fourth Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
//        clickingTheOption_D.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Fifth Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
//        clickingTheOption_E.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
//        clickingTheNumber6OnTheRigntSide.click ();
//
//        // Clicking the First Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
//        clickingTheOption_A.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
//        clickingTheNumber7OnTheRightSide.click ();
//
//        // Clicking the Second Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
//        clickingTheOption_B.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        WebElement clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
//        clickingTheNumber8OnTheRightSide.click ();
//
//        // Clicking the Third Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
//        clickingTheOption_C.click ();
//
//        // Clicking The Previous Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
//        clickingThePreviousButton.click ();
//
//        // Clicking The Pause Button
//
//        Thread.sleep (3000);
//        WebElement clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
//        clickingThePauseButton.click ();
//
//        // Clicking The Cancel Button In The Pause popup
//
//        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        WebElement clickingCancelButtonInPopup = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButtonInPopup.click ();*/
//
//        // Clicking The Leave button In the Pause Popup
//
//        Thread.sleep (3000);
//        WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
//        clickingLeaveButtonInPopup.click ();
//
//        // Changing The Child Windows To Parent Window
//
//        driver.switchTo ().window (parent);
//
//        // Clicking The Quiz In THe Next Leave Sub Path
//
//        Thread.sleep (3000);
//        clickingQuiz = driver.findElement (xpath ("(//a[text()='Quiz'])[2]"));
//        clickingQuiz.click ();
//
//        //Windows Handeling
//
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Clicking The submit Button In The Quiz
//
//        WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//        clickingSubmitButton.click ();
//
//        // Clicking The submit Button Inside The Popup
//
//        Thread.sleep (3000);
//        WebElement clickingSubmitButtonInsidePopup = driver.findElement (xpath ("//span[text()='Submit']"));
//        clickingSubmitButtonInsidePopup.click ();
//
//        // Changing The Child Windows To Parent Window
//
//        driver.switchTo ().window (parent);

        //Scrolling down
//
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");
//
//        // Again Clicking The Quiz In THe Next Leave Sub Path For see The Solution
//
//        Thread.sleep (3000);
//        clickingQuiz = driver.findElement (xpath ("(//a[text()='Quiz'])[2]"));
//        clickingQuiz.click ();

        // Clicking The BookMark Icon

        Thread.sleep (3000);
        WebElement clickBookmarkicon = driver.findElement (xpath ("//*[@class=\"bookmark-icon\"]"));
        clickBookmarkicon.click ();
        System.out.println (" SuccessFully BookMarked");

        // Clicking The BookMarked Icon To UnBookMark

        Thread.sleep (3000);
        WebElement clickBookMarkedIcon = driver.findElement (xpath ("//*[@class=\"bookmarked-icon\"]"));
        clickBookMarkedIcon.click ();
        System.out.println ("SuccessFully Un-BookMarked");

        // Clicking The Next Button In The Solution Page

        Thread.sleep (1000);
        WebElement clickingTheNextButton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingTheNextButton.click ();

        // Clicking The Share Icon In The Solution Page

        Thread.sleep (3000);
        WebElement clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingTheShareIcon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Scrolling The Solution Page

        Thread.sleep (1000);
        WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        Actions actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click the report button

        Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The ReattempButton

        //Thread.sleep (7000);
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (60));
        WebElement reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
        reattempIcon.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button


        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        // Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
        clickingTheNumber8OnTheRightSide.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Clicking The Analysis Icon In The Solution Page

        Thread.sleep (2000);
        WebElement clickingAnalysisIcon = driver.findElement (xpath ("// *[@class=\"image-analysis\"]"));
        clickingAnalysisIcon.click ();

        // Clicking The FullScreen Button

        WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
        clickingTheFullScreenButton.click ();

        // Exiting The FullScreen Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
        WebElement exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
        exitingTheFullScreenButton.click ();

        //  Clicking The Back To Quiz Button

        WebElement clickingBackToQuizButton = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
        clickingBackToQuizButton.click ();

        // Clicking The Analysis Icon In The Solution Page

        Thread.sleep (2000);
        clickingAnalysisIcon = driver.findElement (xpath ("// *[@class=\"image-analysis\"]"));
        clickingAnalysisIcon.click ();

        // Clicking The Share Icon In The Analysis Page

        Thread.sleep (3000);
        clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingTheShareIcon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Clicking The Like Button

        Thread.sleep (3000);
        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
        clickingLikeButton.click ();
        System.out.println ("SucessFully Liked ");

        // Clicking The Un Like Button

        Thread.sleep (3000);
        WebElement clickingUnLikeButton = driver.findElement (xpath ("//*[@class=\"like\"]"));
        clickingUnLikeButton.click ();
        System.out.println ("SucessFully Un Liked ");

        // Clicking The comment icon in the analysis page

        WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
        clickingCommentIconInAnalysisPage.click ();

        //  Entering Comment In The TextField

        Thread.sleep (5000);
        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
        clickingSendButton.click ();

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The Reattempt Button Inside The analysis page

        Thread.sleep (2000);
        WebElement clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
        clickingReattempButton.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The Solution Button Inside The analysis page

        Thread.sleep (2000);
        WebElement clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
        clickingSolutionButtonInAnalysis.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

        WebElement clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
        clickingBackToQuizBreadCrumbs.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The Right Arrow In The Path Tab sub path

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[8]"));
        clickingRightArrow.click ();

        // Clicking The Right Arrow In The Path next level sub path

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[9]"));
        clickingRightArrow.click ();

        // Clicking The Ebook in The sub Path

        WebElement clickingEbookInSubPath = driver.findElement (xpath ("(//a[text()='Ebook'])[1]"));
        clickingEbookInSubPath.click ();

        // Clicking The Like Button

        Thread.sleep (3000);
        clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
        clickingLikeButton.click ();
        System.out.println ("SucessFully Liked ");

        // Clicking The Un Like Button

        Thread.sleep (3000);
        clickingUnLikeButton = driver.findElement (xpath ("//*[@class=\"like\"]"));
        clickingUnLikeButton.click ();
        System.out.println ("SucessFully Un Liked ");

        // Clicking Comment Icon

        Thread.sleep (3000);
        WebElement clickingCommentIcon = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
        clickingCommentIcon.click ();

        //  Entering Comment In The TextField

        Thread.sleep (3000);
        enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Good Content");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        clickingSendButton = driver.findElement (className ("anticon-send"));
        clickingSendButton.click ();

        // Clicking the share icon in My Notes

        Thread.sleep (5000);
        WebElement Share_icon = driver.findElement (xpath ("//*[@class=\"share\"]"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (1000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Scroling BackWard The Ebook page

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The View Button In The Ebook

        WebElement clickingViewButtonInEbook = driver.findElement (xpath ("//span[text()='View']"));
        clickingViewButtonInEbook.click ();

        //Windows Handeling child to parent

        Thread.sleep (3000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Clicking Back Button in the Ebook Page

        driver.switchTo ().window (parent);
        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();

        // Clicking The  Notification Icon (Turn off)

        Thread.sleep (3000);
        WebElement clickingNotificationIconTurnOff = driver.findElement (xpath ("//*[@class=\"notified\"]"));
        clickingNotificationIconTurnOff.click ();
        System.out.println ("Successfully Turn OFF Notification");

        // Clicking The  Notification Icon (Turn on)

        Thread.sleep (3000);
        WebElement clickingNotificationIconTurnOn = driver.findElement (xpath ("//*[@class=\"notify\"]"));
        clickingNotificationIconTurnOn.click ();
        System.out.println ("Successfully Turn On Notification");
    }


}

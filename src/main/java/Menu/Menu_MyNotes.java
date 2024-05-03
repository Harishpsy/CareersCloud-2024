package Menu;

import PageObjectModule.Mynotespageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Mynotespageobject.*;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class Menu_MyNotes {
    WebDriver driver;

    public Menu_MyNotes(WebDriver driver) {
        this.driver = driver;
    }

    public void MyNotes() throws InterruptedException {

        //Then click the MyNote

        PageFactory.initElements (driver, Mynotespageobject.class);

        Thread.sleep (7000);
        MyNotes.click ();

        // Click the three dots in the My notes

        Thread.sleep (3000);
        Threedots.click ();

        //Clicking the remove My notes icon in dropdown

        Thread.sleep (3000);
        Remove_My_Notes.click ();

        // Again Click the three dots in the My notes

        Thread.sleep (3000);
        Threedots.click ();

        /* Clicking the share icon in My Notes */

        Thread.sleep (3000);
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button.click ();

        // Again Click the three dots in the My notes

        Thread.sleep (3000);
        Threedots.click ();

        //clicking the report icon

        Thread.sleep (1000);
        Report_icon.click ();

        //Click the wrong information radio button

        Thread.sleep (1000);
        Wronginformationradiobutton.click ();

        //Entering the text inside the report text field

        Enterthereport.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

//        Thread.sleep (3000);
//        Reportbutton.click ();

        // Clicking The Cancel Button

        Cancel_button.click ();

//        //Clicking the Course name in My Notes Card

        Thread.sleep (3000);
        ClickingCourseName.click ();

        //Clicking the breadcrums to navigate backward to My notes page

        Thread.sleep (3000);
        ClickingCoursebreadcrums.click ();

        // Clicking the like button

        Thread.sleep (1000);
        Likebutton.click ();

        // Clicking the start button

        Thread.sleep (3000);
        Clickingstartbutton.click ();

        //Clicking the Resume Quiz

        clickingTheResumequiz.click ();

        //Windows Handeling


        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        //Clicking the close icon in the quiz instruction

        Thread.sleep (3000);
        Closeicon.click ();

        //Windows mazimize

        WebDriverWait waitForWindowsMaximize = new WebDriverWait (driver, Duration.ofSeconds (30));
        driver.manage ().window ().maximize ();

        //Clicking the Instruction Button

        clickingTheInstructionIcon.click ();

        // Clicking the close icon in the quiz instruction

        Thread.sleep (3000);
        againCloseicon.click ();

        // Clicking The FullScreen Button

        clickingTheFullScreenButton.click ();

        // Clicking the BookMark-icon

        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        bookMarkicon.click ();*/

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
        clickingTheNumber8OnTheRightSide.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C.click ();

        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Clicking The Pause Button

        Thread.sleep (3000);
        clickingThePauseButton.click ();

        // Clicking The Cancel Button In The Pause popup

        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickingCancelButtonInPopup.click ();*/

        // Clicking The Leave button In the Pause Popup

        Thread.sleep (3000);
        WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
        clickingLeaveButtonInPopup.click ();

        // Changing The Child Windows To Parent Window

        driver.switchTo ().window (parent);

        //Clicking the Resume Quiz

        Thread.sleep (3000);
        clickingTheResumequiz.click ();


        // Again Handeling Windows

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);

        // Window Maximize

        driver.manage ().window ().maximize ();

        // Clicking The Quiz BackButton

        quizBackButton.click ();

        // Clicking The Leave button In the BackArrow Popup

        Thread.sleep (3000);
        clickingLeaveButtonPopup.click ();

        // Again Changing The Child Windows To Parent Window

        driver.switchTo ().window (parent);

        //Clicking the Resume Quiz

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        clickingTheResumequiz.click ();

        // Again Handeling Windows

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);

        // Window Maximize

        driver.manage ().window ().maximize ();

        // Clicking The Submit Button

        Thread.sleep (1000);
        WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
        clickingSubmitButton.click ();

        // Clicking the Cancel Button In the submit Popup

        /*Thread.sleep (1000);
        clickingCancelButtonInThePopup.click ();

        // Clicking The Submit Button In The Submit Popup

        Thread.sleep (1000);

        clickingSubmitButton.click ();

        // Again Changing The Child Windows To Parent Window

        driver.switchTo ().window (parent);

        // Clicking The solution button

        Thread.sleep (2000);
        clickingSolutionButton.click ();

        // Clicking The Next Button In The Solution Page

        Thread.sleep (1000);
        clickingTheNextButton.click ();

        /*Clicking The BookMark Button For UnBookMark

        Thread.sleep (3000);
        WebElement clickingTheBookMarkedButton = driver.findElement(className ("bookmark-icon"));
        clickingTheBookMarkedButton.click ();*/

        // Clicking The Share Icon In The Solution Page

        Thread.sleep (3000);
        WebElement clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingTheShareIcon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button.click ();

        // Scrolling The Solution Page

        Thread.sleep (1000);
        WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        Actions actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        Enterthereport.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Reportbutton.click ();

        // Clicking The Cancel Button

        //  Cancel_button.click ();

        // Clicking The ReattempButton

        Thread.sleep (5000);
        reattempIcon.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber8OnTheRightSide.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C.click ();

        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingThePreviousButton.click ();

        // Scrolling The Solution Page

        Thread.sleep (1000);
        scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        clickingTranslationErrorButton.click ();

        //Entering the text inside the report text field In Solution Page

        Enterthereport.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Reportbutton.click ();

        // Clicking The Cancel Button

        // Cancel_button.click ();

        // Clicking The Share Icon In The Solution Page

        Thread.sleep (3000);
        clickingTheShareIcon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button.click ();

        String src = "/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg";

//        WebElement clickingBookmark;
//
//        if (src.equals("/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg"))
//        {
//            clickingBookmark = driver.findElement(xpath("//*[@class='bookmark-icon']"));
//        }
//        else
//        {
//            clickingBookmark = driver.findElement(xpath("//*[@class='bookmarked-icon']"));
//        }
//
//        // Clicking the bookmark or bookmarked icon
//        clickingBookmark.click();

        // Clicking The ReattemptButton

        Thread.sleep (5000);
        clickingReattemptButton.click ();


        //  Click the back arrow in the solution screen

        clickingBackArrow.click ();

        // Clicking The solution button

        Thread.sleep (2000);
        clickingSolutionButton.click ();

        // Analysis was not working in site

        // Clicking The Analysis Icon

        clickingAnalysisIcon.click ();

        // Clicking The FullScreen Button

        clickingTheFullScreenButton.click ();

        // Exiting The FullScreen Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
        exitingTheFullScreenButton.click ();

        //  Again Click the back arrow in the solution screen

        WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The Analysis Button

        WebElement clickingAnalysisButton = driver.findElement (xpath ("//span[text()='Analysis']"));
        clickingAnalysisButton.click ();

        // Clicking The Share Icon In The Analysis Page

        Thread.sleep (3000);
        clickingTheShareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button.click ();

        // Clicking The comment icon in the analysis page

        clickingCommentIconInAnalysisPage.click ();

        // Clicking The Like Button

        clickingunLikeButton.click ();

        // Clicking The unlike Button

        clickingLikeButton.click ();

        //  Entering Comment In The TextField

        Thread.sleep (5000);
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
        clickingSendButton.click ();

        // Clicking The Reattempt Button Inside The analysis page

        Thread.sleep (2000);
        clickingReattempButton.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        clickingBackArrow.click ();

        // Clicking The Solution Button Inside The analysis page

        Thread.sleep (2000);
        clickingSolutionButtonInAnalysis.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        clickingBackArrow.click ();

        // Scrolling The analysis page Forward

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

        clickingBackToQuizBreadCrumbs.click ();

        // Scrolling The analysis page Forward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The Article

        clickingArticle.click ();

        // Scrolling The Article page Forward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling The Article  page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The comment icon in the Article page

        clickingCommentIconInAnalysisPage.click ();

        //  Entering Comment In The TextField

        Thread.sleep (5000);
        enteringTheCommentInTextField.sendKeys ("Easy To UnderStand, Thank You ");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        clickingSendButton.click ();

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The Share Icon In The Article Page

        Thread.sleep (3000);
        clickingTheShareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button.click ();

        // Clicking The Recent Article

        clickingRecentArticle.click ();

        // Clicking Back Button In The article page

        Thread.sleep (2000);
        clickingBackButton.click ();

        // Again Clicking Back Button In The article page

        Thread.sleep (2000);
        clickingBackButton.click ();
    }

}

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static javax.xml.crypto.dsig.Transform.XPATH;
import static org.openqa.selenium.By.*;


public class Login_page {
    public static void main(String[] args) throws InterruptedException {
        // Setup for browser launch

        WebDriver driver = new ChromeDriver ();

        // Entering the url

        driver.get ("https://careerscloud.in/");
        driver.manage ().window ().maximize ();

        // Waiting for element visible

        Thread.sleep (5000);

        // Clicking the login button

        WebElement LoginButton = driver.findElement (xpath ("//span[text()='Log in with Google']"));
        LoginButton.click ();
        Thread.sleep (3000);

        //Windows Handeling

        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        //Entering the mailId

        WebElement Entering_mailId = driver.findElement (id ("identifierId"));
        Entering_mailId.sendKeys ("harishpsy12@gmail.com");

        //Clicking the next button

        WebElement Nextbutton = driver.findElement (xpath ("//span[text()='Next']"));
        Nextbutton.click ();

        //Entering Password

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40)); // 40 seconds timeout
        WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//*[@name='Passwd']")));
        wait.until (ExpectedConditions.visibilityOf (passwordField));
        passwordField.sendKeys ("Harish@1998");

        //Clicking the next button

        Thread.sleep (2000);
        WebElement Next_button = driver.findElement (xpath ("//span[text()='Next']"));
        Next_button.click ();

        //Clicking the Continue_button

        Thread.sleep (5000);
        WebElement Continuebutton = driver.findElement (xpath ("//span[text()='Continue']"));
        Continuebutton.click ();

        //Changing the focus to the parent window
        driver.switchTo ().window (parent);

//        //Then click the MyNote
//
//        Thread.sleep (7000);
//        WebElement MyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
//        MyNotes.click ();
//
//        // Click the three dots in the My notes
//
//        Thread.sleep (3000);
//        WebElement Threedots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
//        Threedots.click ();
//
//        //Clicking the remove My notes icon in dropdown
//
//        Thread.sleep (3000);
//        WebElement Remove_My_Notes = driver.findElement (xpath ("//span[text()='Remove My  Notes']"));
//        Remove_My_Notes.click ();

//        // Again Click the three dots in the My notes
//
//        Thread.sleep (3000);
//        WebElement Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
//        Three_dots.click ();
//
//        /* Clicking the share icon in My Notes */
//
//        Thread.sleep (3000);
//        WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
//        Share_icon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver,Duration.ofSeconds (30));
//        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        // Again Click the three dots in the My notes
//
//        Thread.sleep (3000);
//        Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
//        Three_dots.click ();
//
//        //clicking the report icon
//
//        Thread.sleep (1000);
//        WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
//        Report_icon.click ();
//
//        //Click the wrong information radio button
//
//        Thread.sleep (1000);
//        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
//        Wrong_information_radio_button.click ();
//
//        //Entering the text inside the report text field
//
//        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
//        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//        // Click the report button
//
//        Thread.sleep (3000);
//        /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();*/
//
//        // Clicking The Cancel Button
//
//        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//        Cancel_button.click ();
//
////        //Clicking the Course name in My Notes Card
//
//        Thread.sleep (3000);
//        WebElement Clicking_Course_Name = driver.findElement (xpath ("//*[@class=\"anticon anticon-right right-arrow-icon\"]"));
//        Clicking_Course_Name.click ();
//
//        //Clicking the breadcrums to navigate backward to My notes page
//
//        Thread.sleep (3000);
//        WebElement Clicking_Course_breadcrums = driver.findElement (xpath ("//span[text()='Course']"));
//        Clicking_Course_breadcrums.click ();
//
//        // Clicking the like button
//
//        Thread.sleep (1000);
//        WebElement Like_button = driver.findElement (xpath ("//*[@class=\"feed-card-footer-like-icon\"]"));
//        Like_button.click ();
//
//        // Clicking the start button
//
//        Thread.sleep (3000);
//        WebElement Clicking_start_button = driver.findElement (xpath ("//span[text()='Start']"));
//        Clicking_start_button.click ();
//
//        //Clicking the Resume Quiz
//
////        WebElement clickingTheResumequiz = driver.findElement (xpath ("//span[text()='Resume']"));
////        clickingTheResumequiz.click ();
//
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
//        WebDriverWait waitForWindowsMaximize = new WebDriverWait (driver,Duration.ofSeconds (30));
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
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
//        clickingTheOption_A.click ();
//
//        //Clicking The Save & Next Button
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Second Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
//        clickingTheOption_B.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Third Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
//        clickingTheOption_C.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Fourth Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
//        clickingTheOption_D.click ();
//
//        //Again Clicking The Save & Next Button
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
//        clickingTheSaveAndNextbutton.click ();
//
//        // Clicking the Fifth Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
//        clickingTheOption_E.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        WebElement clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
//        clickingTheNumber6OnTheRigntSide.click ();
//
//        // Clicking the First Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
//        clickingTheOption_A.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
//        clickingTheNumber7OnTheRightSide.click ();
//
//        // Clicking the Second Option
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
//        clickingTheOption_C.click ();
//
//        // Clicking The Previous Button
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
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
//        //Clicking the Resume Quiz
//
//        Thread.sleep (3000);
//        WebElement clickingTheResumequiz = driver.findElement (xpath ("//span[text()='Resume']"));
//        clickingTheResumequiz.click ();
//
//
//        // Again Handeling Windows
//
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Window Maximize
//
//        driver.manage ().window ().maximize ();
//
//        // Clicking The Quiz BackButton
//
//        WebElement quizBackButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//        quizBackButton.click ();
//
//        // Clicking The Leave button In the BackArrow Popup
//
//        Thread.sleep (3000);
//        clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
//        clickingLeaveButtonInPopup.click ();
//
//        // Again Changing The Child Windows To Parent Window
//
//        driver.switchTo ().window (parent);
//
//        //Clicking the Resume Quiz
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        clickingTheResumequiz = driver.findElement (xpath ("//span[text()='Resume']"));
//        clickingTheResumequiz.click ();
//
//        // Again Handeling Windows
//
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Window Maximize
//
//        driver.manage ().window ().maximize ();
//
//        // Clicking The Submit Button
//
//        Thread.sleep (1000);
//        WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//        clickingSubmitButton.click ();
//
//        // Clicking the Cancel Button In the submit Popup
//
//        /*Thread.sleep (1000);
//        WebElement clickingCancelButtonInThePopup = driver.findElement (xpath ("//span[text()=\"Cancel\"]"));
//        clickingCancelButtonInThePopup.click ();*/
//
//        // Clicking The Submit Button In The Submit Popup
//
//        Thread.sleep (1000);
//        clickingSubmitButton = driver.findElement (xpath ("//span[text()=\"Submit\"]"));
//        clickingSubmitButton.click ();
//
//        // Again Changing The Child Windows To Parent Window
//
//        driver.switchTo ().window (parent);

        // Clicking The solution button
//
//        Thread.sleep (2000);
//        WebElement clickingSolutionButton = driver.findElement (xpath ("//span[text()='Solution']"));
//        clickingSolutionButton.click ();

//        // Clicking The Next Button In The Solution Page
//
//        Thread.sleep (1000);
//        WebElement clickingTheNextButton = driver.findElement (xpath ("//div[text()='Next']"));
//        clickingTheNextButton.click ();

        /*// Clicking The BookMark Button For UnBookMark

        Thread.sleep (3000);
        WebElement clickingTheBookMarkedButton = driver.findElement(className ("bookmark-icon"));
        clickingTheBookMarkedButton.click ();*/

//        // Clicking The Share Icon In The Solution Page
//
//        Thread.sleep (3000);
//        WebElement clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//        clickingTheShareIcon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        // Scrolling The Solution Page
//
//        Thread.sleep (1000);
//        WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//        Actions actions = new Actions (driver);
//        actions.scrollToElement (scrollToReportIcon).perform ();
//        scrollToReportIcon.click ();
//
//        // Click The Translation Error In The Report Popup
//
//        Thread.sleep (3000);
//        WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//        clickingTranslationErrorRadioButton.click ();
//
//        //Entering the text inside the report text field In Solution Page
//
//        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
//        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//        // Click the report button
//
//        Thread.sleep (3000);
//        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();
//
//        /* // Clicking The Cancel Button
//
//        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//        Cancel_button.click ();*/
//
//        // Clicking The ReattempButton
//
//        Thread.sleep (5000);
//        WebElement reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
//        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
//        reattempIcon.click ();
//
//        // Clicking the First Option
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
//        WebElement clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
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
//        WebElement clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
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
//        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
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
//        WebElement clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
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
//        WebElement clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
//        clickingTheOption_E.click ();
//
//        // Clicking The Number on the right side Count Status
//
//        WebElement clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
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
//        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
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
//        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
//        clickingThePreviousButton.click ();
//
//        // Scrolling The Solution Page
//
//        Thread.sleep (1000);
//        scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
//        actions = new Actions (driver);
//        actions.scrollToElement (scrollToReportIcon).perform ();
//        scrollToReportIcon.click ();
//
//        // Click The Translation Error In The Report Popup
//
//        Thread.sleep (3000);
//        clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
//        clickingTranslationErrorRadioButton.click ();
//
//        //Entering the text inside the report text field In Solution Page
//
//        Enter_the_report = driver.findElement (name ("reportDescription"));
//        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//        // Click the report button
//
//        Thread.sleep (3000);
//        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();
//
//        /* // Clicking The Cancel Button
//
//        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//        Cancel_button.click ();*/
//
//        // Clicking The Share Icon In The Solution Page
//
//        Thread.sleep (3000);
//        clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//        clickingTheShareIcon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        String src = "/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg";
//
//        WebElement clickingBookmark;
//
//        if (src.equals("/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg"))
//        {
//            clickingBookmark = driver.findElement(By.xpath("//*[@class='bookmark-icon']"));
//        }
//        else
//        {
//            clickingBookmark = driver.findElement(By.xpath("//*[@class='bookmarked-icon']"));
//        }
//
//        // Clicking the bookmark or bookmarked icon
//        clickingBookmark.click()

        // Clicking The ReattempButton

//        Thread.sleep (5000);
//
//        WebElement clickingReattemptButton = driver.findElement (xpath ("//div[@class=\"ant-switch-handle\"]"));
//        clickingReattemptButton.click ();
//
////        reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
////        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
////        reattempIcon.click ();
//
//        //  Click the back arrow in the solution screen
//
//        WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//        clickingBackArrow.click ();
//
//        // Clicking The solution button
//
//        Thread.sleep (2000);
//        clickingSolutionButton = driver.findElement (xpath ("//span[text()='Solution']"));
//        clickingSolutionButton.click ();
//
//        // Analysis was not working in site
//
//        // Clicking The Analysis Icon

//       WebElement clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
//       clickingAnalysisIcon.click ();
//
//        // Clicking The FullScreen Button
//
//        WebElement clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
//        clickingTheFullScreenButton.click ();
//
//        // Exiting The FullScreen Button
//
//        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
//        WebElement exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
//        exitingTheFullScreenButton.click ();
//
//        //  Again Click the back arrow in the solution screen
//
//        WebElement againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//        againclickingBackArrow.click ();
//
//        // Clicking The Analysis Button
//
//        WebElement clickingAnalysisButton = driver.findElement (xpath ("//span[text()='Analysis']"));
//        clickingAnalysisButton.click ();
//
//        // Clicking The Share Icon In The Analysis Page
//
//        Thread.sleep (3000);
//        clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//        clickingTheShareIcon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        // Clicking The comment icon in the analysis page
//
//        WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
//        clickingCommentIconInAnalysisPage.click ();
//
////        // Clicking The Like Button
////
////        WebElement clickingunLikeButton = driver.findElement (xpath ("//*[@class=\"like\"]"));
////        clickingunLikeButton.click ();
////
////        // Clicking The unlike Button
////
////        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
////        clickingLikeButton.click ();
//
//        //  Entering Comment In The TextField
//
//        Thread.sleep (5000);
//        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
//        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");
//
//        // Clicking The Send Button In The Comment Text Field
//
//        Thread.sleep (2000);
//        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//        clickingSendButton.click ();
//
//        // Clicking The Reattempt Button Inside The analysis page
//
//        Thread.sleep (2000);
//        WebElement clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
//        clickingReattempButton.click ();
//
//        //  Again Click the back arrow in the solution screen
//
//        Thread.sleep (2000);
//        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//        againclickingBackArrow.click ();
//
//        // Clicking The Solution Button Inside The analysis page
//
//        Thread.sleep (2000);
//        WebElement clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
//        clickingSolutionButtonInAnalysis.click ();
//
//        //  Again Click the back arrow in the solution screen
//
//        Thread.sleep (2000);
//        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
//        againclickingBackArrow.click ();
//
//        // Scrolling The analysis page Forward
//
//        Thread.sleep (3000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        // Scrolling The analysis page Backward
//
//        Thread.sleep (3000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
//
//        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page
//
//        WebElement clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
//        clickingBackToQuizBreadCrumbs.click ();
//
//        // Scrolling The analysis page Forward
//
//        Thread.sleep (3000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        // Scrolling The analysis page Backward
//
//        Thread.sleep (3000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");

//        // Clicking The Article
//
//        WebElement clickingArticle = driver.findElement (xpath ("//*[@class=\"my-notest article-feed-image\"]"));
//        clickingArticle.click ();
//
//        // Scrolling The analysis page Forward
//
//        Thread.sleep (3000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        // Scrolling The analysis page Backward
//
//        Thread.sleep (3000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
//
//        // Clicking The comment icon in the Article page
//
//        WebElement clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
//        clickingCommentIconInAnalysisPage.click ();

//        //  Entering Comment In The TextField
//
//        Thread.sleep (5000);
//        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
//        enteringTheCommentInTextField.sendKeys ("Easy To UnderStand, Thank You ");
//
//        // Clicking The Send Button In The Comment Text Field
//
//        Thread.sleep (2000);
//        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//        clickingSendButton.click ();
//
//        // Scrolling The analysis page Backward
//
//        Thread.sleep (3000);
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
//
//        // Clicking The Share Icon In The Article Page
//
//        Thread.sleep (3000);
//         WebElement  clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//        clickingTheShareIcon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
//        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        // Clicking The Recent Article
//
//
//        WebElement clickingRecentArticle = driver.findElement (xpath ("//div[text()='Current Affairs 17 February 2024']"));
//        clickingRecentArticle.click ();
//
//        // Clicking Back Button In The article page
//
//        Thread.sleep (2000);
//        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
//        clickingBackButton.click ();
//
//        // Again Clicking Back Button In The article page
//
//        Thread.sleep (2000);
//        clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
//        clickingBackButton.click ();

        // Clicking My Question Button

        Thread.sleep (7000);
        WebElement clickingMyQuestion = driver.findElement (xpath ("//*[@id=\"2\"]"));
        clickingMyQuestion.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        WebElement clickBookMarkQuestion = driver.findElement (xpath ("//div[@class=\"ant-card-cover\"]"));
        clickBookMarkQuestion.click ();

//        // Click The UnBookMark Icon
//
//        Thread.sleep (3000);
//        WebElement clickingUnBookmarkIcon = driver.findElement (xpath ("//*[@class=\"bookmarked-icon\"]"));
//        clickingUnBookmarkIcon.click ();

        // Clicking The Quiz BackButton

        Thread.sleep (3000);
        WebElement quizBackButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        quizBackButton.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        clickBookMarkQuestion = driver.findElement (xpath ("//div[@class=\"ant-card-cover\"]"));
        clickBookMarkQuestion.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

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


        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Clicking The Share Icon In The MyQuestion

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

        // Scrolling The My Question Page

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

        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The Quiz BackButton

        Thread.sleep (4000);
        quizBackButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        quizBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The My ebooks

        WebElement clickingTheMyEbooks = driver.findElement (xpath ("//*[@id=\"3\"]"));
        clickingTheMyEbooks.click ();

        // Click the three dots in the My Ebook

        Thread.sleep (5000);
        WebElement Threedots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Threedots.click ();

//        //Clicking the remove My ebook icon in dropdown
//
//        Thread.sleep (3000);
//        WebElement Remove_My_ebook = driver.findElement (xpath ("//span[text()='Remove My  Ebook']"));
//        Remove_My_ebook.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        WebElement Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Three_dots.click ();

        /* Clicking the share icon in My Ebook */

        Thread.sleep (3000);
        WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Three_dots.click ();

        //clicking the report icon

        Thread.sleep (1000);
        WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
        Report_icon.click ();

        //Click the wrong information radio button

        Thread.sleep (1000);
        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();

        //Clicking the Course name in My ebook Card

        Thread.sleep (3000);
        WebElement Clicking_Course_Name = driver.findElement (xpath ("//*[@class=\"anticon anticon-right right-arrow-icon\"]"));
        Clicking_Course_Name.click ();

        //Clicking the breadcrums to navigate backward to My ebook page

        Thread.sleep (3000);
        WebElement Clicking_Course_breadcrums = driver.findElement (xpath ("//span[text()='Course']"));
        Clicking_Course_breadcrums.click ();

        // Clicking the like button

        Thread.sleep (3000);
        WebElement Like_button = driver.findElement (xpath ("//*[@class=\"feed-card-footer-like-icon\"]"));
        Like_button.click ();

        // ClickingTheLikesButton

        WebElement clickingUnlikeButton = driver.findElement (xpath ("//span[text()='Likes']"));
        clickingUnlikeButton.click ();

        // Clicking The Ebook

        WebElement clickingEbook = driver.findElement (xpath ("//*[@class=\"ebook-cover-image-container\"]"));
        clickingEbook.click ();

//        // Clicking Like Button
//
//        Thread.sleep (3000);
//        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
//        clickingLikeButton.click ();

        // Clicking Comment Icon

        Thread.sleep (3000);
        WebElement clickingCommentIcon = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
        clickingCommentIcon.click ();

        //  Entering Comment In The TextField

        Thread.sleep (3000);
        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

//        // Clicking The Send Button In The Comment Text Field
//
//        Thread.sleep (2000);
//        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//        clickingSendButton.click ();

        // Clicking the share icon in My Notes

        Thread.sleep (5000);
        Share_icon = driver.findElement (xpath ("//*[@class=\"share\"]"));
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The View Button In The Ebook

        WebElement clickingViewButtonInEbook = driver.findElement (xpath ("//span[text()='View']"));
        clickingViewButtonInEbook.click ();

        //Windows Handeling child to parent

        Thread.sleep (3000);
        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Clicking Back Button in the Ebook Page

        driver.switchTo ().window (parent);
        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The My Coin

        WebElement clickingMycoin = driver.findElement (xpath ("//*[@id=\"4\"]"));
        clickingMycoin.click ();

        // Clicking Coin Earning Arrow

        Thread.sleep (3000);
        WebElement clickingCoinEarningText = driver.findElement (xpath ("//div[text()='Coin Earning']"));
        clickingCoinEarningText.click ();

        // Clicking The close Button

        Thread.sleep (3000);
        WebElement clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        // Scrolling backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        //Scrolling forward

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");

        // clicking The Google Play Button

        WebElement clickingGooglePlayButton = driver.findElement (xpath ("//span[text()='Google Play']"));
        clickingGooglePlayButton.click ();

        //Windows Handeling child to parent

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        Thread.sleep (3000);
        driver.switchTo ().window (parent);

        //Scrolling forward

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( document.body.scrollHeight, 0)");

        // Clicking The My Points

        WebElement clickingMyPoints = driver.findElement (xpath ("//*[@id=\"5\"]"));
        clickingMyPoints.click ();

        // Clicking The View Earn Points

        Thread.sleep (3000);
        WebElement clickingViewEarnPoints = driver.findElement (xpath ("//span[text()='View Earn Points']"));
        clickingViewEarnPoints.click ();

        // Clicking The close Button

        Thread.sleep (5000);
        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // Clicking The Dropdown Menu

        WebElement clickingDropDown = driver.findElement (xpath ("//*[@class=\"icon-vector ant-collapse-arrow\"]"));
        actions = new Actions (driver);
        actions.scrollToElement (clickingDropDown).perform ();
        clickingDropDown.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The Invite Friends

        WebElement clickingInviteFriends = driver.findElement (xpath ("//*[@id=\"6\"]"));
        clickingInviteFriends.click ();

        // Clicking The Home Button

        clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The Rate App

        WebElement clickingRateApp = driver.findElement (xpath ("//*[@id=\"7\"]"));
        clickingRateApp.click ();

        //Windows Handeling child to parent

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        Thread.sleep (3000);

        // Clicking The My Purchase

        driver.switchTo ().window (parent);
        WebElement clickingMyPurchase = driver.findElement (xpath ("//*[@id=\"8\"]"));
        clickingMyPurchase.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        //Scrolling up Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight, 0 )");

        // Clicking The Home Button

        clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The Hire US Button

        WebElement clickingHireUs = driver.findElement (xpath ("//*[@id=\"9\"]"));
        clickingHireUs.click ();

        //Windows Handeling child to parent and parent to child

        Thread.sleep (3000);
        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Writing For Home Feed

        // clicking Preference Button

        WebElement clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Railway Button

        WebElement clickingRailwayButton = driver.findElement (xpath ("//div[text()='Railway']"));
        clickingRailwayButton.click ();

        // clicking Preference Button

        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Bank&Insurance Button

        Thread.sleep (2000);
        WebElement clickingBankandInsuranceButton = driver.findElement (xpath ("//div[text()='Bank & Insurance']"));
        clickingBankandInsuranceButton.click ();

        // clicking Preference Button

        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Add Preference

        WebElement clickingAddPreferencebutton = driver.findElement (xpath ("//a[text()=' Add Preference']"));
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (2000);
        WebElement clickingUPSCButton = driver.findElement (xpath ("//div[text()='UPSC']"));
        clickingUPSCButton.click ();

        // Clicking Save Preference

        WebElement clickingsavePreference = driver.findElement (xpath ("//span[text()='Save Preference']"));
        clickingsavePreference.click ();

        // clicking Preference Button

        Thread.sleep (7000);
        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Add Preference

        Thread.sleep (3000);
        clickingAddPreferencebutton = driver.findElement (xpath ("//a[text()=' Add Preference']"));
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (3000);
        clickingUPSCButton = driver.findElement (xpath ("//div[text()='UPSC']"));
        clickingUPSCButton.click ();

        // Clicking Save Preference

        clickingsavePreference = driver.findElement (xpath ("//span[text()='Save Preference']"));
        clickingsavePreference.click ();


//        // Clicking Cancel Button In Profile
//
//        WebElement clickingCancelButton = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButton.click ();

        //Scrolling Down in Coursepage

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        //Scrolling up in Coursepage

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        WebElement clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        Thread.sleep (3000);
        WebElement clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/94cbaa46bc54ec537cc339f5199b390e.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        WebElement clickingCourseInBreadCrumbs = driver.findElement (xpath ("//span[text()='Course']"));
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/2901af2b7017b7d126b7c7493c0a2b8d.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        clickingCourseInBreadCrumbs = driver.findElement (xpath ("//span[text()='Course']"));
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/b26df9a2c61c98268b1ab9e34cb9fbdb.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking The Close icon In The Course Banner Modal

        Thread.sleep (3000);
        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        // Clcking The Google Play Button

        WebElement clickingGoooglePlayButton = driver.findElement (xpath ("//span[text()='Google Play']"));
        clickingGoooglePlayButton.click ();

        //Windows Handeling child to parent and parent to child

        Thread.sleep (3000);
        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // Clicking The Aboutus In The Footer Section

        Thread.sleep (3000);
        WebElement clickingAboutUs = driver.findElement (xpath ("//a[text()='About Us']"));
        clickingAboutUs.click ();

        // Clicking The Authors In The Footer Section

        Thread.sleep (3000);
        WebElement clickingAuthors = driver.findElement (xpath ("//a[text()='Authors']"));
        clickingAuthors.click ();

//        // Clicking The contactus In The Footer Section
//
//        Thread.sleep (3000);
//        WebElement clickingcontactUs = driver.findElement (xpath ("//span[text()='Contact Us']"));
//        clickingcontactUs.click ();
//
//        // Entering The text In The Contactus TextField
//
//        Thread.sleep (3000);
//        WebElement enteringTextInTextField = driver.findElement (name ("queries"));
//        enteringTextInTextField.sendKeys ("Checking The Text Was Entering");
//
////        // Clicking The upload Button
////
////       WebElement clickingUploadButton = driver.findElement (xpath ("//span[text()='Upload']"));
////       clickingUploadButton.click ();
//
//        // Clicking The Send Button
//
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//span[text()='Send']"));
//        clickingSendButton.click ();

//        // Clicking the close icon
//
//        Thread.sleep (2000);
//        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//        clickingCloseIcon.click ();

        // Clicking The FAQ Button In The Footer Section

        Thread.sleep (3000);
        WebElement clickingFAQButton = driver.findElement (xpath ("//a[text()='FAQs']"));
        clickingFAQButton.click ();

        // Clicking The Terms And Condition Button In The Footer Section

        Thread.sleep (3000);
        WebElement clickingTermsAndConditionButton = driver.findElement (xpath ("//a[text()='Terms and Conditions']"));
        clickingTermsAndConditionButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The Terms And Condition Button In The Footer Section

        Thread.sleep (3000);
        WebElement clickingPrivacyPolicyButton = driver.findElement (xpath ("//a[text()='Privacy Policy']"));
        clickingPrivacyPolicyButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The Careers Button In The Footer Section

        Thread.sleep (1000);
        WebElement clickingCareersButton = driver.findElement (xpath ("//a[text()='Careers']"));
        clickingCareersButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The sitemap Button In The Footer Section

        Thread.sleep (1000);
        WebElement clickingsitemapButton = driver.findElement (xpath ("//a[text()='Sitemap']"));
        clickingsitemapButton.click ();

        // Clicking The My Course Button

        WebElement clickingMyCourseButton = driver.findElement (xpath ("//a[text()='My Course']"));
        clickingMyCourseButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        //Scrolling page up Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The filter main (Free)

        Thread.sleep (3000);
        WebElement clickingFreeButtonInFilter = driver.findElement (xpath ("//div[text()='Free']"));
        clickingFreeButtonInFilter.click ();

        // UnClicking The filter main (Free)

        Thread.sleep (3000);
        WebElement UnclickingFreeButtonInFilter = driver.findElement (xpath ("//div[text()='Free']"));
        UnclickingFreeButtonInFilter.click ();

        // Clicking The filter main (Paid)

        Thread.sleep (3000);
        WebElement clickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        clickingPaidButtonInFilter.click ();

        // UnClicking The filter main (Paid)

        Thread.sleep (3000);
        WebElement UnclickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        UnclickingPaidButtonInFilter.click ();

        // Clicking The filter main (featured)

        Thread.sleep (3000);
        WebElement clickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        clickingFeaturedButtonInFilter.click ();

        // UnClicking The filter main (featured)

        Thread.sleep (3000);
        WebElement UnclickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        UnclickingFeaturedButtonInFilter.click ();

        // Clicking The filter main (Subjects)

        Thread.sleep (3000);
        WebElement clickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        clickingSubjectsButtonInFilter.click ();

        // unClicking The filter main (Subjects)

        Thread.sleep (3000);
        WebElement UnclickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        UnclickingSubjectsButtonInFilter.click ();

        // Clicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement clickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        clickingExamsButtonInFilter.click ();

        // UnClicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement UnclickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        UnclickingExamsButtonInFilter.click ();

        // Clicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement clickingAllButtonInFilter = driver.findElement (xpath ("//div[text()='All']"));
        clickingAllButtonInFilter.click ();

        // Clicking The Filter Icon

        Thread.sleep (3000);
        WebElement clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Paid Radio Button

        Thread.sleep (3000);
        WebElement clickingPaidRadioButton = driver.findElement (xpath ("//span[text()='Paid']"));
        clickingPaidRadioButton.click ();

        // Clicking The Apply Button

        WebElement clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();


        // Clicking The Free Radio Button

        Thread.sleep (3000);
        WebElement clickingFreeRadioButton = driver.findElement (xpath ("//span[text()='Free']"));
        clickingFreeRadioButton.click ();

        // Clicking The Apply Button

        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();


        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        WebElement clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Featured In The popup

        Thread.sleep (3000);
        WebElement clickingFeaturedButton = driver.findElement (xpath ("(//div[text()='Featured'])[2]"));
        clickingFeaturedButton.click ();

        // Clicking The Yes Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingYesButton = driver.findElement (xpath ("//span[text()='Yes']"));
        clickingYesButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The No Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingNoButton = driver.findElement (xpath ("//span[text()='No']"));
        clickingNoButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Subjects Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingSubjectButton = driver.findElement (xpath ("(//div[text()='Subjects'])[2]"));
        clickingSubjectButton.click ();

        // Clicking The Current Affairs CheckBox IN The Popup

        Thread.sleep (3000);
        WebElement clickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        clickingCurrentAffairsCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Current Affairs CheckBox IN The Popup

        Thread.sleep (3000);
        WebElement unclickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        unclickingCurrentAffairsCheckBox.click ();

        // Clicking The Logical Reasoning CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        clickingLogicalReasoningCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Logical Reasoning CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        unclickingLogicalReasoningCheckBox.click ();

        // Clicking The Quantitative Aptitude CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        clickingQuantitativeAptitudeCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Quantitative Aptitude CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        unclickingQuantitativeAptitudeCheckBox.click ();

        // Clicking The English CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        clickingEnglishCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The English CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        unclickingEnglishCheckBox.click ();

        // Clicking The Exam Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingExamButton = driver.findElement (xpath ("(//div[text()='Exam'])[2]"));
        clickingExamButton.click ();

        // Clicking The Bank PO In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        clickingBankPoButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Bank PO In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        unclickingBankPoButton.click ();

        // Clicking The Bank Clerk In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        clickingBankClerkButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Bank Clerk In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        unclickingBankClerkButton.click ();

        // Clicking The Insurance In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        clickingInsuranceButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Insurance In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        unclickingInsuranceButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Coin Discount Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingCoinDiscountButton = driver.findElement (xpath ("//div[text()='Coin Discount']"));
        clickingCoinDiscountButton.click ();

        // Clicking The 90+ in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking90Plus = driver.findElement (xpath ("//span[text()='90+']"));
        clicking90Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 89 - 70 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking89_70Plus = driver.findElement (xpath ("//span[text()='89 - 70']"));
        clicking89_70Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 69 - 40 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking69_40Plus = driver.findElement (xpath ("//span[text()='69 - 40']"));
        clicking69_40Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 39 - 20 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking39_20Plus = driver.findElement (xpath ("//span[text()='39 - 20']"));
        clicking39_20Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 19 - 01 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking19_01Plus = driver.findElement (xpath ("//span[text()='19 - 01']"));
        clicking19_01Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();
        System.out.println ("Reset Button Has Been Success Executed");

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
        clickingRightArrow = driver.findElement (xpath ("(//*[@class=\"ant-collapse-expand-icon\"])[3]"));
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


//
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

        // Scrolling The Solution Page

        Thread.sleep (1000);
        scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click the report button

        Thread.sleep (3000);
        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The ReattempButton

        Thread.sleep (5000);
        WebElement reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
        reattempIcon.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button


        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        // Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
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
        clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
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
        enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
        clickingSendButton.click ();

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");

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
        clickingCommentIcon = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
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
        Share_icon = driver.findElement (xpath ("//*[@class=\"share\"]"));
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

        clickingViewButtonInEbook = driver.findElement (xpath ("//span[text()='View']"));
        clickingViewButtonInEbook.click ();

        //Windows Handeling child to parent

        Thread.sleep (3000);
        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Clicking Back Button in the Ebook Page

        driver.switchTo ().window (parent);
        clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();

        // Clicking The  Notification Icon (Turn off)

        Thread.sleep (3000);
        WebElement clickingNotificationIconTurnOff =  driver.findElement (xpath ("//*[@class=\"notified\"]"));
        clickingNotificationIconTurnOff.click ();
        System.out.println ("Successfully Turn OFF Notification");

        // Clicking The  Notification Icon (Turn on)

        Thread.sleep (3000);
        WebElement clickingNotificationIconTurnOn =  driver.findElement (xpath ("//*[@class=\"notify\"]"));
        clickingNotificationIconTurnOn.click ();
        System.out.println ("Successfully Turn On Notification");

        // Clicking The Quizzes In The Course

        Thread.sleep (2000);
        WebElement clickingQuizzes = driver.findElement (xpath ("//div[text()='Quizzes']"));
        clickingQuizzes.click ();

//        // Clicking The Resume Button In the quiz
//
//        WebElement clickingResumeButton = driver.findElement (xpath (" (//span[text()=' Resume '])[1]"));
//        clickingResumeButton.click ();
//
//        //Windows Handeling child
//
//        Thread.sleep (3000);
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
////        //Clicking the close icon in the quiz instruction
////        Thread.sleep (3000);
////        WebElement Close_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
////        Close_icon.click ();
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
//        clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
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
//        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
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
//        clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
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
//        // Clicking The Resume Button In the quiz
//
//        clickingResumeButton = driver.findElement (xpath (" (//span[text()=' Resume '])[1]"));
//        clickingResumeButton.click ();
//
//        //Windows Handeling child
//
//        Thread.sleep (3000);
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Clicking The Submit Button
//
//        Thread.sleep (1000);
//        WebElement clickingSubmitButton = driver.findElement (xpath ("//span[text()=' Submit ']"));
//        clickingSubmitButton.click ();
//
//        // Clicking the Cancel Button In the submit Popup
//
//        /*Thread.sleep (1000);
//        WebElement clickingCancelButtonInThePopup = driver.findElement (xpath ("//span[text()=\"Cancel\"]"));
//        clickingCancelButtonInThePopup.click ();*/
//
//        // Clicking The Submit Button In The Submit Popup
//
//        Thread.sleep (1000);
//        clickingSubmitButton = driver.findElement (xpath ("//span[text()=\"Submit\"]"));
//        clickingSubmitButton.click ();
//
//        // Switching Windows From Child To Parent
//
//        driver.switchTo ().window (parent);

        // Clicking The solution button

        Thread.sleep (2000);
        WebElement clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[2]"));
        clickingSolutionButton.click ();

        // Scrolling and Clicking The Report Page

        Thread.sleep (1000);
        scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();


        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        // Clicking The Report Description button

        Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The ReattempButton

        Thread.sleep (5000);
        reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
        reattempIcon.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
        clickingTheNumber8OnTheRightSide.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Scrolling The Solution Page

        Thread.sleep (1000);
        scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();


        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The Share Icon In The Solution Page

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

//        if (src.equals("/static/media/quiz-bookmark.2ee759e3701295a6112f7b214e743556.svg"))
//        {
//            clickingBookmark = driver.findElement(By.xpath("//*[@class='bookmark-icon']"));
//        }
//        else
//        {
//            clickingBookmark = driver.findElement(By.xpath("//*[@class='bookmarked-icon']"));
//        }

        // Clicking The ReattempButton

        Thread.sleep (5000);

        WebElement clickingReattemptButton = driver.findElement (xpath ("//div[@class=\"ant-switch-handle\"]"));
        clickingReattemptButton.click ();

        reattempIcon = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//div[@class=\"ant-switch-handle\"]")));
        wait.until (ExpectedConditions.visibilityOf (reattempIcon));
        reattempIcon.click ();

        //  Click the back arrow in the solution screen

        WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        clickingBackArrow.click ();

        // Clicking The solution button

        Thread.sleep (2000);
        clickingSolutionButton = driver.findElement (xpath ("(//span[text()=' Solution '])[2]"));
        clickingSolutionButton.click ();

        // Analysis was not working in site

        // Clicking The Analysis Icon

        clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
       clickingAnalysisIcon.click ();

        // Clicking The FullScreen Button

        clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
        clickingTheFullScreenButton.click ();

        // Exiting The FullScreen Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
        exitingTheFullScreenButton = driver.findElement (className ("anticon-compress"));
        exitingTheFullScreenButton.click ();

        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

        clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
        clickingBackToQuizBreadCrumbs.click ();

        // Clicking The Analysis Icon

        clickingAnalysisIcon = driver.findElement (xpath ("//*[@class=\"image-analysis\"]"));
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

        // Clicking The comment icon in the analysis page

        clickingCommentIconInAnalysisPage = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
        clickingCommentIconInAnalysisPage.click ();
//
//        // Clicking The Like Button
//
//        WebElement clickingunLikeButton = driver.findElement (xpath ("//*[@class=\"like\"]"));
//        clickingunLikeButton.click ();
//
//        // Clicking The unlike Button
//
//        Thread.sleep (2000);
//        clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
//        clickingLikeButton.click ();

          //Entering Comment In The TextField

        Thread.sleep (5000);
        enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

        // Clicking The Send Button In The Comment Text Field

        Thread.sleep (2000);
        clickingSendButton = driver.findElement (className ("anticon-send"));
        clickingSendButton.click ();

        // Scrolling The analysis page Up

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");


        // Clicking The Reattempt Button Inside The analysis page

        Thread.sleep (2000);
        clickingReattempButton = driver.findElement (xpath ("//span[text()=' Reattempt ']"));
        clickingReattempButton.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The Solution Button Inside The analysis page

        Thread.sleep (2000);
        clickingSolutionButtonInAnalysis = driver.findElement (xpath ("//span[text()=' View Solution ']"));
        clickingSolutionButtonInAnalysis.click ();

        //  Again Click the back arrow in the solution screen

        Thread.sleep (2000);
        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Scrolling The analysis page Forward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling The analysis page Backward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

        clickingBackToQuizBreadCrumbs = driver.findElement (xpath ("//span[text()='Back to Quiz']"));
        clickingBackToQuizBreadCrumbs.click ();

        //  Clicking the back arrow in the solution screen for coming to course > Quiz 

        Thread.sleep (2000);
        againclickingBackArrow = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        againclickingBackArrow.click ();

        // Clicking The paused Sub Tab In Quiz

        Thread.sleep (2000);
        WebElement clickingPausedTab = driver.findElement (xpath ("//*[text()='Paused']"));
        clickingPausedTab.click ();

       // Clicking The ThreeDots in The MyCourse > Quizzes > Paussed > Quiz

        Thread.sleep (3000);
        Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        Threedots.click ();

        // Clicking The Save My Notes

        Thread.sleep (3000);
        WebElement clickingSaveMyNotes = driver.findElement (xpath ("//*[text()='Save to My Notes']"));
        clickingSaveMyNotes.click ();
        System.out.println ("Sucessfully Save My Notes Clicked ");

        // Again Click the three dots in the Quiz Tab

        Thread.sleep (3000);
        Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        Threedots.click ();


        // Clicking The Remove My Notes

        Thread.sleep (3000);
        WebElement Remove_My_Notes = driver.findElement (xpath ("//span[text()='Remove My  Notes']"));
        Remove_My_Notes.click ();
        System.out.println ("Sucessfully remove My Notes Clicked ");

        // Again Click the three dots in the Quiz Tab

        Thread.sleep (3000);
        Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        Threedots.click ();

        /* Clicking the share icon in Quiz Tab */

        Thread.sleep (3000);
        Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Again Click the three dots in the Quiz Tab

        Thread.sleep (3000);
        Threedots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        Threedots.click ();
        //clicking the report icon

        Thread.sleep (1000);
        Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
        Report_icon.click ();

        //Click the wrong information radio button

        Thread.sleep (1000);
        Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();

        // Clicking The BreadCrumbs inside the course

        WebElement clickingBreadCrumbs = driver.findElement (xpath ("//span[text()='Course']"));
        clickingBreadCrumbs.click ();

        // Scrolling The analysis page Forward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Clicking The Last Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingLastCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[9]"));
        clickingLastCourseCard.click ();

        // Clicking The Quizzes In The Course

        Thread.sleep (2000);
        clickingQuizzes = driver.findElement (xpath ("//div[text()='Quizzes']"));
        clickingQuizzes.click ();

        // Clicking The paused Sub Tab In Quiz

        Thread.sleep (2000);
        clickingPausedTab = driver.findElement (xpath ("//*[text()='Paused']"));
        clickingPausedTab.click ();

        // Scrolling The analysis page Forward

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Clicking The Unattempted Tab

        Thread.sleep (2000);
        WebElement clickingUnattemptab = driver.findElement (xpath ("//span[text()='Unattempted']"));
        clickingUnattemptab.click ();

        // Clicking the quiz in the unattempted tab

        WebElement clickingStartQuiz = driver.findElement (xpath ("//*[text()= ' Start Quiz ']"));
        clickingStartQuiz.click ();

        //Windows Handeling

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);

        // Clicking the close icon in the quiz instruction
        Thread.sleep (3000);
        WebElement Close_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        Close_icon.click ();

        //Windows mazimize

        WebDriverWait waitForWindowsMaximize = new WebDriverWait (driver,Duration.ofSeconds (30));
        driver.manage ().window ().maximize ();

        //Clicking the Instruction Button


        WebElement clickingTheInstructionIcon = driver.findElement (xpath ("//*[@alt=\"quiz_info\"]"));
        clickingTheInstructionIcon.click ();

        // Again Clicking the close icon in the quiz instruction

        Thread.sleep (3000);
        WebElement againClose_icon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        againClose_icon.click ();

        // Clicking The FullScreen Button

        clickingTheFullScreenButton = driver.findElement (className ("anticon-expand"));
        clickingTheFullScreenButton.click ();

        // Clicking the BookMark-icon

        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
        bookMarkicon.click ();*/

        // Clicking the First Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Save & Next Button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Second Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        //Again Clicking The Save & Next Button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Third Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Again Clicking The Save & Next Button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Again Clicking The Save & Next Button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheSaveAndNextbutton = driver.findElement (xpath ("//div[text()='Save & Next']"));
        clickingTheSaveAndNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber8OnTheRightSide = driver.findElement (xpath ("//Span[text()='8']"));
        clickingTheNumber8OnTheRightSide.click ();

        // Clicking the Third Option

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        // Clicking The Previous Button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Clicking The Pause Button

        Thread.sleep (3000);
        WebElement clickingThePauseButton = driver.findElement (xpath ("//*[@class=\"pause-icon\"]"));
        clickingThePauseButton.click ();

        // Clicking The Cancel Button In The Pause popup

        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement clickingCancelButtonInPopup = driver.findElement (xpath ("//span[text()='Cancel']"));
        clickingCancelButtonInPopup.click ();*/

        // Clicking The Leave button In the Pause Popup

        Thread.sleep (3000);
        WebElement clickingLeaveButtonInPopup = driver.findElement (xpath ("//span[text()=\" Leave \"]"));
        clickingLeaveButtonInPopup.click ();

        // Changing The Child Windows To Parent Window

        driver.switchTo ().window (parent);

        // Clicking The Paused tab to atten the resume quiz

        WebElement clickingPausedtab = driver.findElement (xpath ("//*[text() ='Paused']"));
        clickingPausedtab.click ();

        // Clicking the Resume quiz

        Thread.sleep (3000);
        WebElement clickingResumeQuiz = driver.findElement (xpath ("//*[text() = ' Resume ']"));
        clickingResumeQuiz.click ();

        //Windows Handeling

        windows = driver.getWindowHandles ();
        it = windows.iterator ();
        parent = it.next ();
        child = it.next ();
        driver.switchTo ().window (child);














    }
}

package MyCourse;

import PageObjectModule.Myebookspageobject;
import PageObjectModule.Mynotespageobject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static PageObjectModule.Myebookspageobject.*;
import static PageObjectModule.Mynotespageobject.*;
import static org.openqa.selenium.By.*;

public class CoursePath {
    WebDriver driver;
    public CoursePath(WebDriver driver) {
        this.driver = driver;
    }
    public void Path() throws InterruptedException {
        // Initialize WebDriverWait with a maximum wait time of 10 seconds
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) );

        try {
            // Clicking the First Course Card In the "My Course"
            WebElement clickingFirstCourseCard = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "(//*[@class=\"my-courses-banner-image\"])[2]" ) ) );
            clickingFirstCourseCard.click ();
            System.out.println ( "Successfully Clicked The Course name" );

            // Click the title in the path page
            List<WebElement> clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );

            // Iterate through the list without re-fetching inside the loop
            for (int i = 0; i < clickingExamName.size (); i++) {

                WebElement currentElement = clickingExamName.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Click the current element in the main path
                Thread.sleep ( 3000 );
                wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();
                System.out.println ( "Successfully clicked The Main Name in the path" );

                // Exam Sub-Path Clicking

//                List<WebElement> clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse-content ant-collapse-content-inactive ant-collapse-content-hidden\"]/ancestor::*[@class=\"ant-collapse-item\"]" ) ) );
                List<WebElement> clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])" ) ) );

                // Iterate through the list without re-fetching inside the loop
                for (int j = 0; j < clickingExamNameSubPath.size (); j++) {

                    WebElement currentSubElement = clickingExamNameSubPath.get ( j );

                    // Scroll the current element into view
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubElement );
                    Thread.sleep ( 3000 );  // Wait for scrolling to complete

                    // Click the current sub-path element
                    wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();
                    System.out.println ( "Successfully clicked The Current sub element in the path" );

                    // Clicking the Sub-Sub-Path In The path page
                    //  List<WebElement> clickingExamNameSubSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@id=\"subsublevel_695\"]" ) ) );

                    List<WebElement> clickingExamNameSubSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" ) ) );
                    try {
                        for (int k = 0; k <= clickingExamNameSubSubPath.size (); k++) {

                            // Re-fetch the list of elements to avoid StaleElementReferenceException
                            System.out.println ( "Successfully clicked The Current sub element in the path to work on on the below code " );
                            currentSubElement = clickingExamNameSubPath.get ( j );

                            //Clicking The sub sub element in the path page
                            WebElement currentSubSubElement = clickingExamNameSubSubPath.get ( k );

                            // Scroll the current element into view
                            ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubSubElement );
                            Thread.sleep ( 3000 );  // Wait for scrolling to complete

                            // Click the current sub-sub-path element
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();
                            System.out.println ( "Successfully clicked The Current sub-sub element in the path" );

                            // Verifying The Article was displaying In The page or Not
                            CoursePath patharticle = new CoursePath ( driver );
                            patharticle.pathArticle ();

//                            clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );
//                            wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();
//
//                            clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])" ) ) );
//                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();
//
//                            clickingExamNameSubSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" ) ) );
//                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();

                            // Verifying The ebooks Sub-sub-Tab element
                            CoursePath pathebook = new CoursePath ( driver );
                            pathebook.PathEbooks ();

                            clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();

                            clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();

                            wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();

                            //Verifying The Start quiz In Path
                            CoursePath startquiz = new CoursePath ( driver );
                            startquiz.startquiz ();

                            clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();

                            clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();

                            wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();

                            //Verifying The Resume quiz In Path
                            CoursePath resumequiz = new CoursePath ( driver );
                            resumequiz.resumequiz ();

                            clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();

                            clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();

                            wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" ) ) );
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();

                            //Verifying The Soution quiz In Path
                            CoursePath solutionquiz = new CoursePath ( driver );
                            solutionquiz.solutionpath ();

                        }
                        break;
                    } catch (IndexOutOfBoundsException | StaleElementReferenceException e1) {
                        System.out.println ( "Index Out Of Bound Exception Has Been Occured or StaleElementReferenceException " );
                    }
                }
                break;
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "No such Element exception" );
        }

        //Clicking The Course Back-Button
        WebElement clickingcoursebutton = driver.findElement ( xpath ( "//*[text()='Course']" ) );
        clickingcoursebutton.click ();
    }

    public void pathArticle() throws InterruptedException {

        // Check if noRecordFound element is displayed and log the result
        Thread.sleep ( 5000 );
        boolean noRecordfoundDisplayedInPath = false;
        boolean ArticleDisplayedInPath = false;

        try {
            WebElement norecordfoundPath = driver.findElement ( xpath ( "(//*[text()='No Records'])[1]" ) );
            noRecordfoundDisplayedInPath = norecordfoundPath.isDisplayed ();
            System.out.println ( "noRecordFound displayed In Path : " + noRecordfoundDisplayedInPath );
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In Path ." );
        }

        try {
            WebElement clickingArticleInPath = driver.findElement ( xpath ( "//*[text()='Article']" ) );
            ArticleDisplayedInPath = clickingArticleInPath.isDisplayed ();
            System.out.println ( "Article displayed In Path: " + ArticleDisplayedInPath );
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "Article element not found In Path ." );
        }

        // Proceed with if-else logic
        if (noRecordfoundDisplayedInPath) {
            Thread.sleep ( 3000 );
            System.out.println ( "No records found message is displayed In Path." );

        } else if (ArticleDisplayedInPath) {
            Thread.sleep ( 3000 );
            WebElement clickingArticleInPath = driver.findElement ( xpath ( "//*[text()='Article']" ) );
            clickingArticleInPath.click ();
            System.out.println ( "Successfully Clicked The Article In Path" );

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
            System.out.println ( "Navigated To My Notes List Page" );

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

//      // Clicking The report Button
//         WebElement clickingReport = driver.findElement (xpath ( "(//*[@class=\"quiz-popup-modal-body-report-footer-buttons\"])[2]" ));
//         clickingReport.click ();

            // Clicking the three Dots in the CourseCard
            Thread.sleep ( 5000 );
            clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
            clickingThreeDots.click ();

            // Clicking The Remove My Notes
            Thread.sleep ( 3000 );
            WebElement clickingRemoveMyNotes = driver.findElement ( xpath ( "(//span[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
            clickingRemoveMyNotes.click ();

        } else {
            System.out.println ( "Both The Code Has Not Executed In The Path for article " );
        }
    }

    public void PathEbooks() throws InterruptedException {

        PageFactory.initElements ( driver , Myebookspageobject.class );

        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        boolean noRecordFoundDisplayed = false;
        boolean ebooksPath = false;

        try {
            WebElement norecordfoundPath = driver.findElement ( xpath ( "(//*[text()='No Records'])[1]" ) );
            noRecordFoundDisplayed = norecordfoundPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In The Path." );
        }

        try {
            WebElement clickingEbookInPath = driver.findElement ( xpath ( "(//*[text()='Ebook'])[1]" ) );
            ebooksPath = clickingEbookInPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "Threedots element not found In My Ebooks." );
        }

        System.out.println ( "noRecordFound displayed In My Ebooks: " + noRecordFoundDisplayed );
        System.out.println ( "Ebooks Displayed In The Path: " + ebooksPath );

        // Proceed with if-else logic
        if (noRecordFoundDisplayed) {
            Thread.sleep ( 3000 );
            System.out.println ( "No records found message is displayed, In the path." );

            // Handle the case when no records are found
        } else if (ebooksPath) {

            // Click the menu and perform actions
            Thread.sleep ( 9000 );
            WebElement clickingEbookInPath = driver.findElement ( xpath ( "(//*[text()='Ebook'])[1]" ) );
            clickingEbookInPath.click ();
            System.out.println ( "Successfully Clicked " );

            // Needs to write code for like and unlike

            // Click the comment icon
            Thread.sleep ( 3000 );
            clickingCommentIcon.click ();

            // Enter comment in the text field
            Thread.sleep ( 3000 );
            WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name='comments1']" ) );
            enteringTheCommentInTextField.sendKeys ( "Thanks For The Updates" );

            // Click the share icon in My Notes
            Thread.sleep ( 5000 );
            shareicon.click ();

            // Click the copy link in the share popup
            Thread.sleep ( 5000 );
            Copy_link.click ();

            // Click the cancel button in the share popup
            wait.until ( ExpectedConditions.elementToBeClickable ( Cancelbutton ) ).click ();

            // Scroll backward on the Ebook page
            Thread.sleep ( 3000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

            // Click the view button in the Ebook
            clickingViewButtonInEbook.click ();

            // Window handling: switching from child to parent
            Thread.sleep ( 3000 );
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );
            driver.close ();
            driver.switchTo ().window ( parent );

            // Click the back button on the Ebook page
            clickingBackButton.click ();

        } else {
            System.out.println ( "Neither noRecordFound nor Threedots are displayed." );
        }
    }

    public void startquiz() throws InterruptedException {

        PageFactory.initElements ( driver , Mynotespageobject.class );

        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        System.out.println ( "----------------------Start Quiz---------------------------" );
        boolean noRecordfoundDisplayedInPath = false;
        boolean quizStartDisplayedInPath = false;

        try {
            WebElement norecordfoundPath = driver.findElement ( xpath ( "(//*[text()='No Records'])[1]" ) );
            noRecordfoundDisplayedInPath = norecordfoundPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In Path." );
        }

        try {
            WebElement clickingstartquizinpath = driver.findElement ( xpath ( "(//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Start'])" ) );
            quizStartDisplayedInPath = clickingstartquizinpath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "StartQuiz element not found ." );
        }

        // Log the visibility status of each element
        System.out.println ( "noRecordFound displayed In Path: " + noRecordfoundDisplayedInPath );
        System.out.println ( "StartQuiz displayed In Path: " + quizStartDisplayedInPath );

        // Perform actions based on which element is visible
        if (noRecordfoundDisplayedInPath) {
            System.out.println ( "No records found message is displayed In Path." );
        } else if (quizStartDisplayedInPath) {
            Thread.sleep ( 5000 );
            WebElement clickingStartQuiz = driver.findElement ( xpath ( "(//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Start'])" ) );
            clickingStartQuiz.click ();
            System.out.println ( "Successfully clicked the Start button in Path:." );

            //Windows Handeling
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Clicking the close icon in the quiz instruction
            Thread.sleep ( 7000 );
            WebElement Close_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            Close_icon.click ();
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
                WebElement bookmarkIcon = driver.findElement ( By.xpath ( "//*[@class='bookmark-icon']" ) );
                if (bookmarkIcon.isDisplayed ()) {
                    bookmarkIcon.click ();
                    System.out.println ( "Successfully Clicked The Bookmark Icon" );
                }
            } catch (org.openqa.selenium.NoSuchElementException e1) {
                try {
                    WebElement bookmarkedIcon = driver.findElement ( By.xpath ( "//*[@class='bookmarked-icon']" ) );
                    if (bookmarkedIcon.isDisplayed ()) {
                        bookmarkedIcon.click ();
                        System.out.println ( "Successfully Un-Clicked The Bookmark Icon" );
                    }
                } catch (org.openqa.selenium.NoSuchElementException e2) {
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

            // Clicking The resume Button
            Thread.sleep ( 3000 );
            WebElement clickingResumeinPath = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Resume']" ) );
            clickingResumeinPath.click ();
            System.out.println ( "Successfully clicked the Resume button In The Path." );

            //Windows Handeling
            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( child );

            //Windows mazimize
            new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
            driver.manage ().window ().maximize ();

            //Clicking the Instruction Button
            driver.manage ().timeouts ().implicitlyWait ( 30 , TimeUnit.SECONDS );
            clickingTheInstructionIcon = driver.findElement ( xpath ( "//*[@alt=\"quiz_info\"]" ) );
            clickingTheInstructionIcon.click ();
            System.out.println ( "Sucessfully clicked instruction icon" );

            // Again Clicking the close icon in the quiz instruction
            Thread.sleep ( 3000 );
            againClose_icon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
            againClose_icon.click ();

            // Clicking The FullScreen Button
            Thread.sleep ( 2000 );
            clickingTheFullScreenButton = driver.findElement ( className ( "anticon-expand" ) );
            clickingTheFullScreenButton.click ();

            // Clicking the BookMark-icon

                /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                 WebElement bookMarkicon = driver.findElement(className ("bookmark-icon"));
                 bookMarkicon.click ();*/

            // Define the options to be clicked
            options = new String[]{"A" , "A" , "B" , "D" , "E" , "C" , "C" , "A" , "D" , "E" , "A" , "E" , "A" , "C" , "E" ,};

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
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println ( "Failed to find an element during the loop." );
                }
            }

            // Clicking the Previous Button
            Thread.sleep ( 3000 );
            clickingThePreviousButton = driver.findElement ( xpath ( "//div[text()='Previous']" ) );
            clickingThePreviousButton.click ();

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
            WebElement clickingSolutionQuiz = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Resume']" ) );
            clickingSolutionQuiz.click ();

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
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period1." );
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" , "A" , "D" , "E" , "D" ,};

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
                } catch (org.openqa.selenium.NoSuchElementException e) {
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

            Thread.sleep ( 10000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period2." );
            } catch (org.openqa.selenium.NoSuchElementException e) {
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
            clickingSolutionquiz.click ();

            // Analysis was not working in site
            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
//
            // Clicking The Analysis Button In The MY Notes
            Thread.sleep ( 3000 );
            WebElement clickingAnalysisButton = driver.findElement ( xpath ( "//*[text()='Analysis']" ) );
            clickingAnalysisButton.click ();

            // Clicking The FullScreen Button
            Thread.sleep ( 3000 );
            clickingTheFullScreenButton = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-expand\"]" ) );
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
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println ( "Like Button not found" );

                    try {
                        // Locate the unlike button
                        WebElement unlikeButton = driver.findElement ( By.xpath ( "//*[@class='unlike']" ) );
                        if (unlikeButton.isDisplayed ()) {
                            unlikeButton.click ();
                            System.out.println ( "Successfully Clicked The Unlike Button" );
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e2) {
                        System.out.println ( "Unlike Button not found" );
                    }
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
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
            System.out.println ( "No matching condition was found in the Start quiz In The Path." );
        }
    }

    public void resumequiz() throws InterruptedException {

        PageFactory.initElements ( driver , Mynotespageobject.class );

        System.out.println ( "----------------------Resume Quiz---------------------------" );
        boolean noRecordFoundDisplayed = false;
        boolean quizresumeDisplayedInPath = false;

        try {
            WebElement norecordfoundPath = driver.findElement ( xpath ( "(//*[text()='No Records'])[1]" ) );
            noRecordFoundDisplayed = norecordfoundPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In The Path." );
        }
        try {
            WebElement clickingResumeinPath = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Resume']" ) );
            quizresumeDisplayedInPath = clickingResumeinPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "ResumeQuiz element not found In The Path." );
        }

        System.out.println ( "noRecordFound displayed In The Path: " + noRecordFoundDisplayed );
        System.out.println ( "ResumeQuiz displayed In The Path: " + quizresumeDisplayedInPath );

        if (noRecordFoundDisplayed) {
            System.out.println ( "No record found was not displayed" );
        } else if (quizresumeDisplayedInPath) {

            Thread.sleep ( 3000 );
            WebElement clickingResumeinPath = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='Resume']" ) );
            clickingResumeinPath.click ();
            System.out.println ( "Successfully clicked the Resume button In The Path." );

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
                } catch (org.openqa.selenium.NoSuchElementException e) {
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
            WebElement clickingSolutionQuiz = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='View Solution']" ) );
            clickingSolutionQuiz.click ();

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
            Thread.sleep ( 10000 );
            //wait = new WebDriverWait (driver,30);
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary

            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period1." );
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }
            // Define the options to be clicked
            options = new String[]{"B" , "A" , "D" , "C" , "A" , "E" , "C" , "B" , "E" , "D" , "B" , "A" , "D" , "E" , "D" ,};

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
                } catch (org.openqa.selenium.NoSuchElementException e) {
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
            Thread.sleep ( 10000 );
            // wait = new WebDriverWait (driver, Duration.ofSeconds (30));
            WebElement clickingReattemptButton = driver.findElement ( xpath ( "//div[@class=\"ant-switch-handle\"]" ) );
            clickingReattemptButton.click ();

            wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // Adjust the timeout as necessary
            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period2." );
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen
            Thread.sleep ( 3000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();


        } else {
            System.out.println ( "No matching condition was found in the Resume quizIn The Path." );
        }
    }

    public void solutionpath() throws InterruptedException {

        PageFactory.initElements ( driver , Mynotespageobject.class );

        System.out.println ( "-----------------------Solutions---------------------------" );
        // Check if elements are displayed and log the results
        Thread.sleep ( 5000 );

        // Initialize flags to track the visibility of different elements
        boolean noRecordfoundDisplayedInPath = false;
        boolean quizsolutionDisplayedInMyNotes = false;

        try {
            WebElement norecordfoundPath = driver.findElement ( xpath ( "(//*[text()='No Records'])[1]" ) );
            noRecordfoundDisplayedInPath = norecordfoundPath.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "noRecordFound element not found In The Path." );
        }

        try {
            WebElement clickingSolutionQuiz = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='View Solution']" ) );
            quizsolutionDisplayedInMyNotes = clickingSolutionQuiz.isDisplayed ();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println ( "Solution button element not found In The Path." );
        }

        // Log the visibility status of each element
        System.out.println ( "noRecordFound displayed In The Path: " + noRecordfoundDisplayedInPath );
        System.out.println ( "Solution button displayed In The Path: " + quizsolutionDisplayedInMyNotes );

        if (noRecordfoundDisplayedInPath) {
        } else if (quizsolutionDisplayedInMyNotes) {
            WebElement clickingSolutionQuiz = driver.findElement ( xpath ( "//*[@class=\"path-content-scroll\"]/child::*[@class=\"sub-sub-level-content\"]/child::*[@style=\"padding: 5px 0px; color: grey; font-size: 10px;\"]/child::*[text()='Quiz']/following::*[text()='View Solution']" ) );
            clickingSolutionQuiz.click ();
            System.out.println ( "Successfully clicked the Solution button In The Path." );

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
            } catch (org.openqa.selenium.NoSuchElementException e) {
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
                } catch (org.openqa.selenium.NoSuchElementException e) {
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
            Thread.sleep ( 10000 );
            try {
                WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class=\"ant-switch ant-switch-small css-xu9wm8 ant-switch-checked\"]" ) ) );
                reattemptIcon.click ();
                System.out.println ( "Successfully clicked the reattempt icon." );
            } catch (TimeoutException e) {
                System.out.println ( "The reattempt icon was not clickable within the timeout period4." );
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println ( "The reattempt icon was not found on the page." );
            } catch (Exception e) {
                System.out.println ( "An unexpected error occurred: " + e.getMessage () );
            }

            //  Click the back arrow in the solution screen
            Thread.sleep ( 30000 );
            WebElement clickingBackArrow = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-arrow-left back-icon\"]" ) );
            clickingBackArrow.click ();
        } else {
            System.out.println ( "No matching condition was found in the Solution quiz In The Path." );
        }

    }
}




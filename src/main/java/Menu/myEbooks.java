package Menu;

import PageObjectModule.Myebookspageobject;
import ScreenShot.ScreenShot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Myebookspageobject.*;
import static org.openqa.selenium.By.xpath;

public class myEbooks {
    WebDriver driver;

    public myEbooks(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Test method that automates the navigation and interaction with the "My Ebooks" section.
     *
     * The method performs the following actions:
     * - Initializes web elements for the "My Ebooks" page.
     * - Clicks on the "My Ebooks" section.
     * - Checks for the presence of content in the "My Ebooks" section.
     * - If no content is found, navigates to the "My Coin" page.
     * - If content is found, interacts with various elements such as three dots menu, share icons, report buttons, comments, etc.
     * - Logs various activities and interactions, handling cases where certain elements are not found.
     * - Includes several sleep times to wait for elements to appear and actions to complete.
     *
     * @throws InterruptedException when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted.
     */
    @Test
    public void MyEbooks() throws InterruptedException, IOException {

        PageFactory.initElements ( driver , Myebookspageobject.class );

        // Clicking My ebooks
        Thread.sleep ( 5000 );
        clickingTheMyEbooks.click ();
        ScreenShot.captureScreenshot ( "Clicked The My Ebooks" );

        //Verifying there is content is present if not there navigate to the next module
        //Check if "No Records Found." element is displayed
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );

        // Sleep for 3 seconds
        Thread.sleep ( 3000 );

        try {
            // Check if noRecordFound element is displayed and log the result
            boolean noRecordFoundDisplayed = false;
            boolean threedotsDisplayed = false;

            try {
                noRecordFoundDisplayed = noRecordFound.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "noRecordFound element not found In My Ebooks ." );
            }

            try {
                threedotsDisplayed = Threedots.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "Threedots element not found In My Ebooks." );
            }

            System.out.println ( "noRecordFound displayed In My Ebooks: " + noRecordFoundDisplayed );
            System.out.println ( "Threedots displayed In My Ebooks: " + threedotsDisplayed );

            // Proceed with if-else logic
            if (noRecordFoundDisplayed) {
                Thread.sleep ( 3000 );
                clickingMycoin.click ();
                ScreenShot.captureScreenshot ( "No Record Found, Clicked The My coin" );
                System.out.println ( "No records found message is displayed, navigating to My Coin page." );

                // Handle the case when no records are found
            } else if (threedotsDisplayed) {

//                    // Click the course name in My ebook Card
//                    Thread.sleep ( 5000 );
//                    ClickingCourseName.click ();
//                    System.out.println ( "Successfully CLicked The Course Name" );
//
//                    // Click the breadcrumbs to navigate backward to My ebook page
//                    Thread.sleep ( 5000 );
//                    ClickingCoursebreadcrums.click ();
//                    // Course breadcrumbs was not working for first time, user needs to click two times
//                    System.out.println ( "Successfully CLicked The Breadcrumbs" );

                // Click the ebook
                Thread.sleep ( 5000 );
                WebElement clickingEbook = driver.findElement ( xpath ( "//*[@class=\"ebook-cover-image-container\"]" ) );
                clickingEbook.click ();
                ScreenShot.captureScreenshot ( "Clicked The Ebook" );

                // Assume a method isLiked() returns true if already liked, false otherwise

                // Clicking the like and unlike button
                Thread.sleep ( 5000 );
                WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

                if (clickAction.isDisplayed ()) {
                    clickAction.click ();
                    if (clickAction.getAttribute ( "class" ).contains ( "unlike" )) {
                        System.out.println ( "Liked Successfully" );
                        ScreenShot.captureScreenshot ( "Clicked The like and unlike button" );
                    } else {
                        System.out.println ( "Un Liked Successfully" );
                    }
                }

                // Click the comment icon
                    Thread.sleep ( 3000 );
                    clickingCommentIcon.click ();
                System.out.println ( "Successfully CLick The Comment Icon" );
                ScreenShot.captureScreenshot ( "Clicked The Comment Icon" );

                    // Enter comment in the text field
                    Thread.sleep ( 3000 );
                    WebElement enteringTheCommentInTextField = driver.findElement ( xpath ( "//*[@name='comments1']" ) );
                    enteringTheCommentInTextField.sendKeys ( "Thanks For The Updates" );
                ScreenShot.captureScreenshot ( "Entered The Comment In The Text Field" );

                    // Click the share icon in My Notes
                    Thread.sleep ( 5000 );
                    shareicon.click ();
                System.out.println ( "Successfully Click The Share Icon" );
                ScreenShot.captureScreenshot ( "Clicked The Share Icon" );

                    // Click the copy link in the share popup
                    Thread.sleep ( 5000 );
                    Copy_link.click ();
                System.out.println ( "Successfully CLick The Copy Link" );
                ScreenShot.captureScreenshot ( "Clicked The Copy Link" );

                    // Click the cancel button in the share popup
                    wait.until ( ExpectedConditions.elementToBeClickable ( Cancelbutton ) ).click ();

                    // Scroll backward on the Ebook page
                    Thread.sleep ( 3000 );
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );

                    // Click the view button in the Ebook
                    clickingViewButtonInEbook.click ();
                System.out.println ( "Successfully CLick The View Button" );
                ScreenShot.captureScreenshot ( "Clicked The View Button" );

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
                System.out.println ( "Successfully Click The Back Button" );
                ScreenShot.captureScreenshot ( "Clicked The Back Button" );

                // Click the three-dot menu and perform actions
                Thread.sleep ( 9000 );
                Threedots.click ();
                System.out.println ( "Successfully Clicked Three Dots " );
                ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

                // Click the share icon in My Ebook
                Thread.sleep ( 3000 );
                Share_icon.click ();
                System.out.println ( "Successfully CLick The Share icon" );
                ScreenShot.captureScreenshot ( "Clicked The Share icon" );

                // Click the copy link in the share popup
                Thread.sleep ( 3000 );
                Copy_link.click ();
                System.out.println ( "Successfully Click The Copy link " );
                ScreenShot.captureScreenshot ( "Clicked The Copy link" );

                // Click the cancel button in the share popup
                wait.until ( ExpectedConditions.elementToBeClickable ( Cancelbutton ) ).click ();

                // Click the three dots again
                Thread.sleep ( 3000 );
                Threedots.click ();
                System.out.println ( "Successfully Click The Three Dots" );
                ScreenShot.captureScreenshot ( "Clicked The Three Dots" );

                // Click the report icon
                Thread.sleep ( 1000 );
                Reporticon.click ();
                System.out.println ( "Successfully Click The Report icon " );
                ScreenShot.captureScreenshot ( "Clicked The Report icon" );

                // Click the wrong information radio button
                Thread.sleep ( 1000 );
                Wronginformationradiobutton.click ();
                System.out.println ( "Successfully Click The Radio button " );
                ScreenShot.captureScreenshot ( "Clicked The Radio button" );

                // Enter text inside the report text field
                Enterthereport.sendKeys ( "Checking The text was Entering In The Report Text Field" );
                System.out.println ( "Successfully Entered The text" );
                ScreenShot.captureScreenshot ( "Clicked The Radio button" );

                // Click the report button (currently commented out)
                // Thread.sleep(3000);
                // Reportbutton.click();

                // Click the cancel button
                Thread.sleep ( 3000 );
                CANCELbutton.click ();
                System.out.println ( "Successfully Click The Cancel Button" );
                ScreenShot.captureScreenshot ( "Clicked The Cancel Button" );

                // Click the three dots again
                Thread.sleep ( 3000 );
                Threedots.click ();
                System.out.println ( "Successfully Click The Three Dots" );
                ScreenShot.captureScreenshot ( "Clicked The Three Dots " );

                // Clicking the remove My ebook icon in dropdown
                Thread.sleep ( 3000 );
                Remove_My_ebook.click ();
                System.out.println ( "Successfully Click The Remove My Ebook" );
                ScreenShot.captureScreenshot ( "Clicked The Remove My Ebook " );

            } else {
                System.out.println ( "Neither noRecordFound nor Threedots are displayed." );
            }
        } catch (Exception e) {
            System.out.println ( "An error occurred In The My Ebook Page: " + e.getMessage () );
            e.printStackTrace ();
        }
    }
}



package Menu;

import PageObjectModule.Myebookspageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Myebookspageobject.*;
import static org.openqa.selenium.By.xpath;

public class Menu_MyEbooks {
    WebDriver driver;

    public Menu_MyEbooks(WebDriver driver) {
        this.driver = driver;
    }

    public void MyEbooks() throws InterruptedException {

        PageFactory.initElements ( driver , Myebookspageobject.class );

        // Clicking My ebooks

        Thread.sleep ( 5000 );
        clickingTheMyEbooks.click ();

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
                System.out.println ( "No records found message is displayed, navigating to My Coin page." );

                // Handle the case when no records are found

            } else if (threedotsDisplayed) {

                // Click the three-dot menu and perform actions

                Thread.sleep ( 9000 );
                Threedots.click ();
                System.out.println ( "Successfully Clicked Three Dots " );

                // Clicking the remove My ebook icon in dropdown

                Thread.sleep ( 3000 );
                Remove_My_ebook.click ();
                Thread.sleep ( 5000 );

                // Check if noRecordFound element is displayed and log the result

                boolean noRecordFoundDisplayedAfterRemove = false;
                boolean threedotsDisplayedAfterRemove = false;

                try {
                    noRecordFoundDisplayedAfterRemove = noRecordFound.isDisplayed ();
                } catch (NoSuchElementException e) {
                    System.out.println ( "noRecordFound element not found." );
                }

                try {
                    threedotsDisplayedAfterRemove = Threedots.isDisplayed ();
                } catch (NoSuchElementException e) {
                    System.out.println ( "Threedots element not found." );
                }

                if (noRecordFoundDisplayedAfterRemove) {
                    // Clicking My coins
                    Thread.sleep ( 5000 );
                    clickingMycoin.click ();
                    System.out.println ( "No records found message is displayed In My Ebooks,So navigating to My Coin page." );

                } else if (threedotsDisplayedAfterRemove) {
                    // Click the three dots again
                    Thread.sleep ( 5000 );
                    Threedots.click ();

                    // Click the share icon in My Ebook
                    Thread.sleep ( 3000 );
                    Share_icon.click ();

                    // Click the copy link in the share popup
                    Thread.sleep ( 3000 );
                    Copy_link.click ();

                    // Click the cancel button in the share popup
                    wait.until ( ExpectedConditions.elementToBeClickable ( Cancelbutton ) ).click ();

                    // Click the three dots again
                    Thread.sleep ( 3000 );
                    Threedots.click ();

                    // Click the report icon
                    Thread.sleep ( 1000 );
                    Reporticon.click ();

                    // Click the wrong information radio button
                    Thread.sleep ( 1000 );
                    Wronginformationradiobutton.click ();

                    // Enter text inside the report text field
                    Enterthereport.sendKeys ( "Checking The text was Entering In The Report Text Field" );

                    // Click the report button (currently commented out)

                    // Thread.sleep(3000);
                    // Reportbutton.click();

                    // Click the cancel button
                    Thread.sleep ( 3000 );
                    CANCELbutton.click ();

                    // Click the course name in My ebook Card
                    Thread.sleep ( 3000 );
                    ClickingCourseName.click ();

                    // Click the breadcrumbs to navigate backward to My ebook page
                    Thread.sleep ( 3000 );
                    ClickingCoursebreadcrums.click ();

                    // Click the like button
                    Thread.sleep ( 3000 );
                    Likebutton.click ();

                    // Click the unlike button
                    Thread.sleep ( 3000 );
                    clickingUnlikeButton.click ();

                    // Click the ebook
                    WebElement clickingEbook = driver.findElement ( xpath ( "//*[@class='ebook-cover-image-container']" ) );
                    clickingEbook.click ();

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
                    System.out.println ( "Both are not presented" );
                }
            } else {
                System.out.println ( "Neither noRecordFound nor Threedots are displayed." );
            }
        } catch (Exception e) {
            System.out.println ( "An error occurred: " + e.getMessage () );
            e.printStackTrace ();
        }
    }
}



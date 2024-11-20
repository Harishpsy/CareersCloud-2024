package Home;

import Master.MainObjects.BaseObjects;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticleEbooksandCourseActions extends ScreenShot {

    WebDriver driver;

    public ArticleEbooksandCourseActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Test method for interacting with articles, ebooks, and courses on the home feed.
     *
     * <ul>
     * <li>Finds elements with the class 'feed-card-body'.</li>
     * <li>Iterates through the list of elements, ensuring the list is re-fetched during each iteration to avoid StaleElementReferenceException.</li>
     * <li>Scrolls each element into view and clicks it.</li>
     * <li>Attempts to click a breadcrumb link if present; if not, attempts to click a back button.</li>
     * <li>Logs success or failure of finding breadcrumb or back button.</li>
     * </ul>
     *
     * @throws InterruptedException if the thread is interrupted during sleep intervals.
     */
    @Test
    public void ArticleEbooksandCourse() throws InterruptedException, IOException {

        // Clicking the list of elements present in the form of Article and Course
        Thread.sleep ( 3000 );
        List<WebElement> clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
        int totalElements = clickingArticleandCourse.size ();

        try {

            for (int i = 0; i < totalElements; i++) {

                // Re-fetch the list of elements to avoid StaleElementReferenceException
                Thread.sleep ( 3000 );
                clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
                WebElement currentElement = clickingArticleandCourse.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Capture the name of the course or article for logging purposes
                String courseName = currentElement.getAttribute ( "src" );  // Replace it with the correct attribute if src isn't correct
//                System.out.println ("Current Clicked Course, Article Or Ebook Name:" + courseName );

                // Click the current article or course
                if (currentElement.isDisplayed ()) {
                    Thread.sleep ( 3000 );
                    currentElement.click ();
                    System.out.println ( "Successfully Clicked The Article Or Course Or Ebooks" );
                    ScreenShot.captureScreenshot ( "Clicked The Article Or Course Or Ebooks" );
                } else {
                    System.out.println ( "Current Clicked Course, Article Or Ebook Was Not Dispayed" );
                }

                // Try to click the breadcrumb link, if present
                try {
                    WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                    Thread.sleep ( 10000 ); // Wait for the page to load
                    breadcrumbLink.click ();
                    System.out.println ( "Successfully clicked the breadcrumb link" );
                    ScreenShot.captureScreenshot ( "Clicked the breadcrumb link" );
                } catch (NoSuchElementException e1) {

                    // If a breadcrumb is not found, try to click the Back button
                    try {
                        WebElement backButton = driver.findElement ( By.xpath ( "//*[text()='Back']" ) );
                        Thread.sleep ( 5000 ); // Wait for the page to load
                        backButton.click ();
                        System.out.println ( "Successfully clicked the Back button" );
                        ScreenShot.captureScreenshot ( "Clicked the Back button" );
                        ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                    } catch (NoSuchElementException e2) {
                        // If both elements are not found, log the failure
                        System.out.println ( "Neither breadcrumb nor back button is present on the page for " + courseName );
                    }
                }

                // Wait before moving to the next item
                Thread.sleep ( 5000 );

            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println ( "Index Out Of Bounds Exception has been Occured" + e.getMessage () );
        }
    }
}
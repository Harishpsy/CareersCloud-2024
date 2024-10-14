package Home;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class ArticleEbooksandCourseActions {

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
    public void ArticleEbooksandCourse() throws InterruptedException {

        // Clicking the list of elements present in the form of Article and Course
        List<WebElement> clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
        int totalElements = clickingArticleandCourse.size ();

        try {

            for (int i = 0; i < totalElements; i++) {

                // Re-fetch the list of elements to avoid StaleElementReferenceException
                clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
                WebElement currentElement = clickingArticleandCourse.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Capture the name of the course or article for logging purposes
                String courseName = currentElement.getAttribute ( "src" );  // Replace with the correct attribute if src isn't correct

                // Click the current article or course
                Thread.sleep ( 3000 );
                currentElement.click ();

                // Try to click the breadcrumb link, if present
                try {
                    WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                    Thread.sleep ( 5000 ); // Wait for the page to load
                    breadcrumbLink.click ();
                    System.out.println ( "Successfully clicked the breadcrumb link" );
                } catch (NoSuchElementException e1) {

                    // If a breadcrumb is not found, try to click the Back button
                    try {
                        WebElement backButton = driver.findElement ( By.xpath ( "//*[text()='Back']" ) );
                        Thread.sleep ( 5000 ); // Wait for the page to load
                        backButton.click ();
                        System.out.println ( "Successfully clicked the Back button" );
                    } catch (NoSuchElementException e2) {
                        // If both elements are not found, log the failure
                        System.out.println ( "Neither breadcrumb nor back button is present on the page for " + courseName );
                    }
                }

                // Wait before moving to the next item
                Thread.sleep ( 3000 );
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println ( "Index Out Of Bounds Exception has been Occured" );
        }

    }

}

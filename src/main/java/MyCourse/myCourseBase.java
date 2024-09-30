package MyCourse;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class myCourseBase {
    WebDriver driver;

    public myCourseBase(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void courseClicking() throws InterruptedException, AWTException {

        /*Opening All The course In The Course List Page and click the back button or Course Breadcrumbs Making This InLoop Initial delay to allow the page to load fully*/

        // Initial delay to allow the page to load fully
        Thread.sleep ( 5000 );

        // Counter to track total elements clicked
        int totalElementsClicked = 0;

        // Infinite loop will break once all elements are processed
        while (true) {

            // Fetch the current list of elements (including newly loaded ones)
            List<WebElement> clickingCourse = driver.findElements ( By.xpath ( "(//*[@class='ant-typography all-courses-card-title css-xu9wm8'])" ) );
            int totalElements = clickingCourse.size (); // Get the current total number of elements

            // If no new elements are loaded after scrolling, break the loop
            if (totalElementsClicked >= totalElements) {
                System.out.println ( "All elements have been processed." );
                break;
            }

            // Loop through and click the remaining unclicked elements
            for (int i = totalElementsClicked; i < totalElements; i++) {

                try {
                    // Refetch the element list before interacting to avoid stale references
                    clickingCourse = driver.findElements ( By.xpath ( "(//*[@class='ant-typography all-courses-card-title css-xu9wm8'])" ) );

                    // Ensure the index is within bounds to avoid IndexOutOfBoundsException
                    if (i >= clickingCourse.size ()) {
                        break;
                    }

                    WebElement courseElement = clickingCourse.get ( i );

                    // Get the text or another unique attribute of the element to track it
                    String elementText = courseElement.getText ();

                    // Ensure the element is visible and interactable
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , courseElement );
                    Thread.sleep ( 2000 ); // Allow some time for the scroll

                    // Log the text of the element
                    System.out.println ( "Course Name Which Has Been Clicked: " + elementText );

                    // Click the Course element
                    courseElement.click ();
                    Thread.sleep ( 3000 ); // Wait for page navigation

                    // Perform actions on the sub-modules as per your code (articles, videos, quizzes, ebooks, etc.)

                    /* Perform actions on path tab */
                    path path = new path ( driver );
                    path.allpath ();

                    /* Creating An Object For The Article Sub Module, Performing The Actions */
                    article article = new article ( driver );
                    article.Article ();

                    /* Creating An Object For The Videos Sub Module, Performing The Actions */
                    videos video = new videos ( driver );
                    video.videos ();

                    /* Creating An Object For The Quizzes Sub Module, Performing The Actions */
                    quizzes quizzes = new quizzes ( driver );
                    quizzes.Quizzes ();

                    /* Creating An Object For The Ebooks Sub Module, Performing The Actions */
                    ebooks ebooks = new ebooks ( driver );
                    ebooks.Ebooks ();

                    /* Creating An Object For The Doubts Sub Module, Performing The Actions */
                    doubts doubtPage = new doubts ( driver );
                    doubtPage.doubtbase ();

                    /* Creating An Object For The Free Sub Module, Performing The Actions */
                    free freetab = new free ( driver );
                    freetab.freeTab ();

                    /* Creating An Object For The Article, Performing The Actions */
                    details detailsPage = new details ( driver );
                    detailsPage.details ();

                    // Go back to the course list using breadcrumb (if available)
                    try {
                        WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                        Thread.sleep ( 3000 ); // Wait for the page to load
                        breadcrumbLink.click ();
                        Thread.sleep ( 3000 ); // Wait for the course list to reload
                    } catch (NoSuchElementException e1) {
                        System.out.println ( "Breadcrumb link not found" );
                    }

                    totalElementsClicked++; // Increment the clicked elements counter
                    Thread.sleep ( 2000 ); // Wait before moving to the next element

//                    // Break after clicking one element
//                    break; // <<< BREAK STATEMENT HERE: Remove this to click all elements

                } catch (StaleElementReferenceException e) {
                    System.out.println ( "StaleElementReferenceException occurred. Refetching elements." );
                    i--; /* Retry the current element */
                } catch (NoSuchElementException e) {
                    System.out.println ( "An error occurred In The Course Base:" + e.getMessage () );
                }
            }

            // Scroll the page to load more elements
            try {
                ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
                Thread.sleep ( 3000 ); // Wait for new elements to load

                ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
                Thread.sleep ( 3000 ); // Wait for new elements to load
            } catch (Exception e) {
                System.out.println ( "An error occurred while scrolling: " + e.getMessage () );
            }
//
//            // Remove this break if you want to keep processing all elements
//            break; // <<< OUTER LOOP BREAK: Remove this to process all elements after scrolling
        }


    }
}



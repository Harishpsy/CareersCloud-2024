package MyCourse;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class myCourseBase {
    WebDriver driver;
    public myCourseBase(WebDriver driver) {
        this.driver = driver;
    }
    @Test
    public void courseClicking() throws InterruptedException {

        /*Opening All The course In The Course List Page and click the back button or Course Breadcrumbs Making This InLoop Initial delay to allow the page to load fully*/

        Thread.sleep ( 5000 );

        /* Counter to track total elements clicked */
        int totalElementsClicked = 0;

        /* Infinite loop will break once all elements are processed or after one will click */
        while (true) {

            /* Fetch the current list of elements (including newly loaded ones) */
            List<WebElement> clickingCourse = driver.findElements ( By.xpath ( "(//*[@class='ant-typography all-courses-card-title css-xu9wm8'])" ) );
            int totalElements = clickingCourse.size (); // Get the current total number of elements

            /* If no new elements are loaded after scrolling, break the loop */
            if (totalElementsClicked >= totalElements) {
                System.out.println ( "All elements have been processed." );
                break;
            }

            /* Loop through and click the remaining unclicked elements */
            for (int i = totalElementsClicked; i < totalElements; i++) {

                try {
                    /* Refetch the element list before interacting to avoid stale references */
                    clickingCourse = driver.findElements ( By.xpath ( "(//*[@class='ant-typography all-courses-card-title css-xu9wm8'])" ) );

                    /* Ensure the index is within bounds to avoid IndexOutOfBoundsException */
                    if (i >= clickingCourse.size ()) {
                        break;
                    }

                    WebElement courseElement = clickingCourse.get ( i );

                    /* Ensure the element is visible and interactable */
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , courseElement );
                    Thread.sleep ( 2000 ); // Allow some time for the scroll

                    /* Log the text of the element */
                    String elementText = courseElement.getText ();
                    System.out.println ( "Course Name WHich Has Been Clicked: " + elementText );

                    /* Click the Course element */
                    courseElement.click ();
                    Thread.sleep ( 3000 );  // Wait for page navigation

                    /* Creating An Object And Performing The Actions Of The Sub-Modules */

                    /* Perform actions on path tab */
                    CoursePath path = new CoursePath ( driver );
                    path.allpath ();

                    /* Creating An Object For The Article Sub Module, Performing The Actions */
                    CourseArticle article = new CourseArticle ( driver );
                    article.Article ();

                    /* Creating An Object For The Videos Sub Module, Performing The Actions */
                    CourseVideos video = new CourseVideos ( driver );
                    video.videos ();

                    /* Creating An Object For The Quizzes Sub Module, Performing The Actions */
                    CourseQuizzes quizzes = new CourseQuizzes ( driver );
                    quizzes.Quizzes ();

                    /* Creating An Object For The Ebooks Sub Module, Performing The Actions */
                    CourseEbooks ebooks = new CourseEbooks ( driver );
                    ebooks.Ebooks ();

                    /* Creating An Object For The Doubts Sub Module, Performing The Actions */
                    CourseDoubts doubt = new CourseDoubts ( driver );
                    doubt.Doubts ();

                    /* Creating An Object For The Free Sub Module, Performing The Actions */
                    courseFreeTab freetab = new courseFreeTab ( driver );
                    freetab.freeTab ();

                    /* Creating An Object For The Article, Performing The Actions */
                    CourseDetails detailsPage = new CourseDetails ( driver );
                    detailsPage.details ();

                    // Go back to the course list using breadcrumb (if available)
                    try {
                        WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                        Thread.sleep ( 3000 );  // Wait for the page to load
                        breadcrumbLink.click ();
                        Thread.sleep ( 3000 );  // Wait for the course list to reload
                    } catch (NoSuchElementException e1) {
                        System.out.println ( "Breadcrumb link not found" );
                    }

                    totalElementsClicked++;  // Increment the clicked elements counter
                    Thread.sleep ( 2000 );  // Wait before moving to the next element

                    // Break after clicking one element
                    break;  // <<< BREAK STATEMENT HERE: Remove this to click all elements

                } catch (StaleElementReferenceException e) {
                    System.out.println ( "StaleElementReferenceException occurred. Refetching elements." );
                    i--;  /* Retry the current element */
                } catch (Exception e) {
                    System.out.println ( "An error occurred: " + e.getMessage () );
                }
            }

            // **Scroll the page to load more elements**
            try {
                ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
                Thread.sleep ( 3000 ); // Wait for new elements to load
            } catch (Exception e) {
                System.out.println ( "An error occurred while scrolling: " + e.getMessage () );
            }

            // Break out of the outer loop as well after clicking one element
            break;  // <<< OUTER LOOP BREAK: Remove this to process all elements after scrolling
        }

    }

}



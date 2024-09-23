package AllCourse;

import org.openqa.selenium.*;

import java.util.List;

public class allCoursesActions {

    public WebDriver driver;

    public allCoursesActions(WebDriver driver) {
        this.driver = driver;
    }

    public void courseClicking() throws InterruptedException {

        //Opening All The course In The All Course List Page and click the back button or Course Breadcrumbs Making This In Loop
        // Initial delay to allow the page to load fully
        Thread.sleep(5000);

        // Counter to track total elements clicked
        int totalElementsClicked = 0;

        // Infinite loop, will break once all elements are processed
        while (true) {
            // Fetch the current list of elements (including newly loaded ones)
            List<WebElement> clickingCourse = driver.findElements ( By.xpath ( "(//*[@class='ant-typography all-courses-card-title css-xu9wm8'])" ) );
            int totalElements = clickingCourse.size(); // Get the current total number of elements

            // If no new elements are loaded after scrolling, break the loop
            if (totalElementsClicked >= totalElements) {
                System.out.println("All elements have been processed.");
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

                    // Ensure the element is visible and interactable
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , courseElement );
                    Thread.sleep ( 2000 ); // Allow some time for the scroll

                    // Log the text of the element
                    String elementText = courseElement.getText ();
                    System.out.println ( "Course Name Before Clicking: " + elementText );

                    // Click the element
                    courseElement.click ();
                    Thread.sleep ( 3000 );  // Wait for page navigation

                    // **Re-initialize the subscribeNow object to handle dynamic page reloading**
                    allCourseSubscribeActions subscribeNow = new allCourseSubscribeActions ( driver );
//                    System.out.println ( "Attempting to click the subscribe button for: " + elementText );
                    subscribeNow.subscribeNowButton ();  // Perform the subscription action
//                    System.out.println ( "Subscribe button clicked for: " + elementText );

                    //DetailsPage In The all Course
                    allCourseDetails detailsPage = new allCourseDetails ( driver ); // Details Page Object has been created to preforme the actions after the subscribe
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

                } catch (StaleElementReferenceException e) {
                    System.out.println ( "StaleElementReferenceException occurred. Refetching elements." );
                    i--;  // Retry the current element
                } catch (Exception e) {
                    System.out.println ( "An error occurred: " + e.getMessage () );
                }
            }

            // **Scroll the page to load more elements**
            try {
//                System.out.println ( "Scrolling to load more elements." );
                ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
                Thread.sleep ( 3000 ); // Wait for new elements to load

//                System.out.println ( "Scrolling to load more elements." );
                ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
                Thread.sleep ( 3000 ); // Wait for new elements to load

                // **Re-initialize the subscribeNow object after scrolling** (in case the page reloads or elements change)
                allCourseSubscribeActions subscribeNowAfterScroll = new allCourseSubscribeActions ( driver );
//                System.out.println ( "Re-initialized subscribeNow after scrolling." );
            } catch (Exception e) {
                System.out.println ( "An error occurred while scrolling: " + e.getMessage () );
            }
        }


    }
}

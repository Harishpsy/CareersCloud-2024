package AllCourse;

import org.openqa.selenium.*;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class allCoursesActions {

    public WebDriver driver;

    public allCoursesActions(WebDriver driver) {
        this.driver = driver;
    }

    public void courseClicking() throws InterruptedException {

        //Opening All The course In The All Course List Page and click the back button or Course Breadcrumbs Making This In Loop

        // Initial delay to allow the page to load
        Thread.sleep(5000);

        // Counter to track total elements clicked
        int totalElementsClicked = 0;
        int previousTotalElements = 0;  // To track the number of elements after each scroll

        // Infinite loop, will break once all elements are processed
        while (true) {
            // Fetch the current list of elements, including newly loaded ones
            List<WebElement> clickingCourse = driver.findElements ( By.xpath ( "(//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"])" ) );
            int totalElements = clickingCourse.size(); // Get the current total number of elements

            // If no new elements were loaded after scrolling, and all elements have been clicked, break the loop
            if (totalElementsClicked >= totalElements) {
                System.out.println("All elements have been processed.");
                break;
            }

            // Loop through and click the remaining unclicked elements
            for (int i = totalElementsClicked; i < totalElements; i++) {
                try {
                    // Refetch the element list to avoid stale element issues
                    clickingCourse = driver.findElements ( By.xpath ( "(//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"])" ) );

                    // Ensure the index is within bounds to avoid IndexOutOfBoundsException
                    if (i >= clickingCourse.size ()) {
                        break;
                    }

                    WebElement courseElement = clickingCourse.get ( i );

                    // Get the text of the element
                    String elementText = courseElement.getText ();
                    System.out.println ( "Course Name: " + elementText );

                    // Scroll the current element into view
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , courseElement );
                    System.out.println ( "Successfully Scrolled 1" );
                    Thread.sleep ( 2000 );  // Optional wait after scrolling

                    // Scroll the current element into view
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , courseElement );
                    System.out.println ( "Successfully Scrolled 2" );

                    Thread.sleep ( 5000 );  // Optional wait after scrolling

                    // Click the element
                    courseElement.click ();
                    Thread.sleep ( 3000 );  // Optional wait after clicking

                    // Try to click the breadcrumb link, if present, to go back to the list
                    try {
                        WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                        Thread.sleep ( 2000 );  // Wait for the page to load
                        breadcrumbLink.click ();
                    } catch (NoSuchElementException e1) {
                        System.out.println ( "Breadcrumb link not found" );
                    }

                    totalElementsClicked++; // Increment the clicked elements counter
                    Thread.sleep ( 3000 );  // Wait before moving to the next element
                } catch (StaleElementReferenceException e) {
                    System.out.println ( "StaleElementReferenceException occurred. Refetching elements." );
                    // Retry by refetching elements and continuing
                    i--;  // Decrement index to retry the current element
                }
            }

            // Scroll down to load more content after clicking the visible elements
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(5000); // Wait for new elements to load after scrolling
            ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
            Thread.sleep ( 5000 ); // Wait for new elements to load after scrolling
            ((JavascriptExecutor) driver).executeScript ( "window.scrollBy(0,document.body.scrollHeight)" );
            Thread.sleep ( 5000 ); // Wait for new elements to load after scrolling
        }




    }
}
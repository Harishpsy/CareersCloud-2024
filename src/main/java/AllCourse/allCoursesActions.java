package AllCourse;

import org.openqa.selenium.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int currentIndex = 0;  // This will track the index of the element to be clicked next

// Set to keep track of clicked elements to avoid duplicates
        Set<WebElement> clickedElements = new HashSet<> ();

        while (true) {
            // Fetch the current list of elements, including any new ones loaded after scrolling
            List<WebElement> clickingCourse = driver.findElements(By.xpath("//*[@class='all-courses-card-inner-img-div']"));
            int totalElements = clickingCourse.size(); // Get the current total number of elements

            // Check if we have reached the end of the elements (no more new elements)
            if (currentIndex >= totalElements) {
                System.out.println("All elements have been processed.");
                break;
            }

            // Loop through each unclicked element and click it
            for (int i = currentIndex; i < totalElements; i++) {
                WebElement currentElement = clickingCourse.get(i);

                // Check if the element has already been clicked
                if (clickedElements.contains(currentElement)) {
                    continue; // Skip if already clicked
                }

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentElement);
                Thread.sleep(3000);  // Wait for scrolling to complete

                // Click the course
                currentElement.click();
                Thread.sleep(1000); // Optional delay between clicks

                // Try to click the breadcrumb link, if present
                try {
                    WebElement breadcrumbLink = driver.findElement(By.xpath("(//*[@class='ant-breadcrumb-link'])[1]"));
                    Thread.sleep(5000); // Wait for the page to load
                    breadcrumbLink.click();
                    System.out.println("Successfully clicked the breadcrumb link");
                } catch (NoSuchElementException e1) {
                    System.out.println("Breadcrumb link not found");
                }

                totalElementsClicked++; // Increment the clicked elements counter
                clickedElements.add(currentElement); // Mark this element as clicked
                Thread.sleep(3000); // Wait before moving to the next item
            }

            // Scroll down to load more content after clicking the visible elements
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(5000); // Wait for new elements to load after scrolling

            // Refetch the list of elements to check if more have been loaded
            clickingCourse = driver.findElements(By.xpath("//*[@class='all-courses-card-inner-img-div']"));
            totalElements = clickingCourse.size(); // Update the total number of elements

            // Update the index of the element to be clicked next (continue from where we left off)
            currentIndex = totalElementsClicked;
        }





    }
}

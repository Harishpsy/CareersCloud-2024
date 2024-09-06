package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.By.xpath;

public class CoursePath {

    WebDriver driver;

    public CoursePath(WebDriver driver) {
        this.driver = driver;
    }

    public void Path() throws InterruptedException {
        // Initialize WebDriverWait with a maximum wait time of 10 seconds
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );

        try {
            // Clicking the First Course Card In the "My Course"
            WebElement clickingFirstCourseCard = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "(//*[@class=\"my-courses-banner-image\"])[2]" ) ) );
            clickingFirstCourseCard.click ();
            System.out.println ( "Successfully Clicked The Course name" );

            // Click the title in the path page
            List<WebElement> clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"]" ) ) );

            // Iterate through the list without re-fetching inside the loop
            for (int i = 0; i < clickingExamName.size (); i++) {

                WebElement currentElement = clickingExamName.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Click the current element in the main path
                wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();
                System.out.println ( "Successfully clicked The Current element in the path" );

                // Exam Sub-Path Clicking

//                List<WebElement> clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse-content ant-collapse-content-inactive ant-collapse-content-hidden\"]/ancestor::*[@class=\"ant-collapse-item\"]" ) ) );
                List<WebElement> clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"]" ) ) );

                // Iterate through the list without re-fetching inside the loop
                for (int j = 0; j < clickingExamNameSubPath.size (); j++) {

                    WebElement currentSubElement = clickingExamNameSubPath.get ( j );

                    // Scroll the current element into view
                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubElement );
                    Thread.sleep ( 3000 );  // Wait for scrolling to complete

                    // Click the current sub-path element
                    wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();
                    System.out.println ( "Successfully clicked The Current sub element in the path" );

//                    // Clicking the Sub-Sub-Path In The path page
//                   List<WebElement> clickingExamNameSubSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse-header\"]/ancestor::*[@class=\"ant-collapse-content ant-collapse-content-active\"]" ) ) );
//                    try {
//                       for (int k = 0 ; k <= clickingExamNameSubSubPath.size (); k++) {
//
//                           // Re-fetch the list of elements to avoid StaleElementReferenceException
//                           WebElement currentSubSubElement = clickingExamNameSubSubPath.get ( k );
//
//                           // Scroll the current element into view
//                           ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubSubElement );
//                           Thread.sleep ( 3000 );  // Wait for scrolling to complete
//
//                           // Click the current sub-sub-path element
//                           wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();
//                           System.out.println ( "Successfully clicked The Current sub-sub element in the path" );
//                       }
//                   }catch (IndexOutOfBoundsException e1){
//                       System.out.println ("Index Out Of Bound Exception Has Been Occured");
//                   }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "No such Element exception" );
        }
    }
}

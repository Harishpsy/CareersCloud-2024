package AllCourse;

import MyCourse.CoursePath;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class allCoursePath extends CoursePath {
    WebDriver driver;

    public allCoursePath(WebDriver driver) {
        this.driver = driver;
    }

    public void allpath() throws InterruptedException {

        try {
            WebElement clickingPathTab = driver.findElement ( By.xpath ( "//*[text()='Paths']" ) );

            if (clickingPathTab.isSelected ()) {
                System.out.println ( "Path Tab Is Already Selected So performing The Below Acrion In The Path List Page " );
            } else if (clickingPathTab.isDisplayed ()) {
                clickingPathTab = driver.findElement ( By.xpath ( "//*[text()='Paths']" ) );
                clickingPathTab.click ();
                System.out.println ( "Successfully Clicked The Path Tab And Performing The Below Path List Actions" );
            } else {
                System.out.println ( "Both The Actions Are Not Performed Error In The Path Clicking" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Error Message : " + e.getMessage () );
        }

        // Creating An Object For The Path List Page Actions
        allCoursePath pathActions = new allCoursePath ( driver );
        pathActions.pathListActions ();
    }

    public void pathListActions() throws InterruptedException {

        // Initialize WebDriverWait with a maximum wait time of 10 seconds
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) );

        try {

            // Click the title in the path page
            List<WebElement> clickingExamName = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost main-collapse css-xu9wm8\"])" ) ) );

            // Iterate through the list without re-fetching inside the loop
            for (int i = 0; i < clickingExamName.size (); i++) {

                WebElement currentElement = clickingExamName.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Click the current element in the main path
                Thread.sleep ( 3000 );
                wait.until ( ExpectedConditions.elementToBeClickable ( currentElement ) ).click ();
                System.out.println ( "Successfully clicked The Main Name in the All Course path " );

                // Exam Sub-Path Clicking
                try {
                    List<WebElement> clickingExamNameSubPath = wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy ( xpath ( "//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"]/child::*[@class=\"ant-collapse-item\"]" ) ) );

                    // Iterate through the list without re-fetching inside the loop
                    for (int j = 0; j < clickingExamNameSubPath.size (); j++) {

                        WebElement currentSubElement = clickingExamNameSubPath.get ( j );

                        if (currentSubElement.isDisplayed ()) {
                            // Scroll the current element into view
                            ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubElement );
                            Thread.sleep ( 3000 );  // Wait for scrolling to complete

                            // Click the current sub-path element
                            wait.until ( ExpectedConditions.elementToBeClickable ( currentSubElement ) ).click ();
                            System.out.println ( "Successfully clicked The Current sub element in the path" );
                        } else {
                            System.out.println ( "Sub Path was not present" );
                        }

                        // Clicking the Sub-Sub-Path In The path page
                        try {
                            // Waiting for the presence of elements
                            List<WebElement> clickingExamNameSubSubPath = wait.until (
                                    ExpectedConditions.presenceOfAllElementsLocatedBy (
                                            xpath ( "(//*[@class=\"ant-collapse ant-collapse-icon-position-end ant-collapse-ghost css-xu9wm8\"])[2]/child::*[@class=\"ant-collapse-item\"]" )
                                    )
                            );

                            System.out.println ( "Attempting to click the current sub element in the path." );

                            for (int k = 0; k < clickingExamNameSubSubPath.size (); k++) {
                                WebElement currentSubSubElement = clickingExamNameSubSubPath.get ( k );

                                // Check if the individual element is displayed
                                if (currentSubSubElement.isDisplayed ()) {
                                    // Scroll the current element into view
                                    ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentSubSubElement );
                                    Thread.sleep ( 3000 );  // Wait for scrolling to complete

                                    // Click the current sub-sub-path element
                                    wait.until ( ExpectedConditions.elementToBeClickable ( currentSubSubElement ) ).click ();
                                    System.out.println ( "Successfully clicked the current sub-sub element in the path." );
                                } else {
                                    // If the element is not displayed, print a message
                                    System.out.println ( "Element is not displayed, skipping to the next element." );
                                }
                            }
                        } catch (TimeoutException e) {
                            // Handle the case where no elements are found
                            System.out.println ( "No elements found, skipping this step." );
                        }

                    }
                } catch (TimeoutException e1) {
                    // Handle the case where no elements are found
                    System.out.println ( "No elements found, skipping this step." );
                }


//                // Perform the following actions if the element is displayed
//                CoursePath patharticle = new CoursePath ( driver );
//                patharticle.pathArticle ();
//
//                CoursePath pathebook = new CoursePath ( driver );
//                pathebook.PathEbooks ();
//
//                CoursePath startquiz = new CoursePath ( driver );
//                startquiz.startquiz ();
//
//                CoursePath resumequiz = new CoursePath ( driver );
//                resumequiz.resumequiz ();
//
//                CoursePath solutionquiz = new CoursePath ( driver );
//                solutionquiz.solutionpath ();

            }

        } catch (NoSuchElementException e) {
            System.out.println ( "No such Element exception Occured In The All Course Path " );
        }


    }

}

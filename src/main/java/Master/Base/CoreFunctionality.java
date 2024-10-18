package Master.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class CoreFunctionality {

    WebDriver driver;

    public CoreFunctionality(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void Scroll() {
        // Scrolling The Quizzes List Page to verify data
        int numberOfTimesScrollQuizzes = 5;

        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {

            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver; // javascript executer for scrolling the page
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The pages " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }
    }

    @Test(enabled = true)
    public void floatButton() {

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-content\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 30 ) );// using implicity wait
                clickingFloatIcon.click ();
                System.out.println ( "Successfully Clicked The Float Icon" );
            } else {
                System.out.println ( "Float Icon Is Not Displayed" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "FloatIcon Button Is Not Displayed" );
        }
    }

    @Test(enabled = true)
    public void identifingDuplicate() {

        // Finding All The elements Based On The Xpath (Ebooks, Article, Videos, Quiz, My Courses, All Courses)
        try {
            // Retrieve the list of elements for the categories (Ebooks, Article, Videos, Quiz, My Courses, All Courses)
            List<WebElement> allName = driver.findElements ( xpath ( "//*[@class='ant-row ant-row-middle nowrap-content css-xu9wm8']" ) );

            // Check if the list is empty
            if (allName.isEmpty ()) {
                System.out.println ( "No elements found for Ebooks, Articles, Videos, Quiz, My Courses, All Courses." );
            } else {
                // Create a set to store unique names
                Set<String> uniqueNames = new HashSet<> ();
                int uniqueCount = 0;

                // Iterate through the list of elements
                for (WebElement element : allName) {
                    String actualName = element.getText ();

                    // Check if the name is already in the set (duplicate)
                    if (uniqueNames.contains ( actualName )) {
                        System.out.println ( "Duplicate Found In The List Page: " + actualName );
                    } else {
                        uniqueNames.add ( actualName );
                        uniqueCount++;
                    }
                }

                // Assert that the number of unique names matches the size of the unique set
                Assert.assertEquals ( uniqueCount , uniqueNames.size () );

                // Print the total number of unique names found
                System.out.println ( "Total unique counts found: " + uniqueCount );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "The Article, Quiz, or Ebooks elements were not found." );
        }

        // Writing For My Question
        try {
            // Retrieve the list of elements for My Question Name
            List<WebElement> myQuestionName = driver.findElements ( xpath ( "//*[@class='ant-card-body']" ) );

            // Check if the list is empty
            if (myQuestionName.isEmpty ()) {
                System.out.println ( "No elements found for My Question Name." );
            } else {
                // Perform similar actions if required for myQuestionName elements
                // Create a set to store unique names
                Set<String> uniqueNames = new HashSet<> ();
                int uniqueCount = 0;

                // Iterate through the list of elements
                for (WebElement element : myQuestionName) {
                    String actualName = element.getText ();

                    // Check if the name is already in the set (duplicate)
                    if (uniqueNames.contains ( actualName )) {
                        System.out.println ( "Duplicate Found In The List Page: " + actualName );
                    } else {
                        uniqueNames.add ( actualName );
                        uniqueCount++;
                    }
                }

                // Assert that the number of unique names matches the size of the unique set
                Assert.assertEquals ( uniqueCount , uniqueNames.size () );

                // Print the total number of unique names found
                System.out.println ( "Total unique counts found: " + uniqueCount );
            }
        } catch (NoSuchElementException e1) {
            System.out.println ( "My Question Name elements were not found." );
        }


    }
}

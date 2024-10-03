package AllCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class allCourseModule {

    public WebDriver driver;

    public allCourseModule(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void allCourse() throws InterruptedException, AWTException {

        //Clicking The All Course Button In the Header
        Thread.sleep ( 3000 );
        WebElement clickingAllCourse = driver.findElement ( xpath ( "//*[text()='All Course']" ) );
        clickingAllCourse.click ();
        System.out.println ( "SuccessFully Clicked The All Course Button In The Header" );

    }

    @Test
    public void verifyingDuplicate() throws InterruptedException {

        //Scrolling The Page
        int numberoftimesscrollAllcourselistpage = 5;
        for (int i = 0; i < numberoftimesscrollAllcourselistpage; i++) {
            try {
                Thread.sleep ( 3000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The All Course List page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll The All Course List page : " + scroll.getMessage () );
            }
        }

        //Scrolling The Page up
        numberoftimesscrollAllcourselistpage = 3;
        for (int i = 0; i < numberoftimesscrollAllcourselistpage; i++) {
            try {
                Thread.sleep ( 3000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
                System.out.println ( "Successfully scroll The All Course List page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll The All Course List page : " + scroll.getMessage () );
            }
        }
        //Clicking The Float Icon In The All Course List Page
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//button[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingFloatIcon.click ();
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "FloatIcon Button Is Not Displayed In The All Course List Page " );
        }

        //Verifying The Duplicate Course was Found In The All Course List Page

        // Finding All The elements From the Course components
        List<WebElement> allCourseName = driver.findElements ( xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]" ) );

        // Create a set to store unique Course Name
        Set<String> uniqueAllcourseName = new HashSet<> ();
        int uniquesAllcourseCount = 0;

        // Iterate through the list of elements
        for (WebElement MyCourseElement : allCourseName) {
            String actualCourseName = MyCourseElement.getText ();
//          System.out.println ( "Original Course Name: " + actualCourseName );
            if (uniqueAllcourseName.contains ( actualCourseName )) {
                System.out.println ( "Duplicate Course Name found In The ALl Course List Page--> " + actualCourseName );
            } else {
                uniqueAllcourseName.add ( actualCourseName );
                uniquesAllcourseCount++;
//             System.out.println ( "Course Name Found: " + uniquesAllcourseCount + " --> " + actualCourseName );
//            System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique Courses found
        System.out.println ( "Total unique Courses found In All Course List Page: " + uniquesAllcourseCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquesAllcourseCount , uniqueAllcourseName.size () );

        // Getting The List Of featured Course In The Course List Before Filter
        // Getting the featured Course List
        List<WebElement> featuredCourseName = driver.findElements ( xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]/preceding::*[@alt=\"fearured_tag\"]" ) );

        // Print the total number of unique Featured Courses found
        System.out.println ( "Total unique Featured Course found: " + featuredCourseName.size () );

    }
}

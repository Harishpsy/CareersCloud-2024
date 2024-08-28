package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class myCourse {

    WebDriver driver;

    public myCourse(WebDriver driver) {

        this.driver = driver;
    }

    public void myCourseClicking() throws InterruptedException {

        // Clicking My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();
        System.out.println ("Successfully Clicked The My Course");

        //Scrolling My Course List Page Down
        int numberoftimesscrollMycourselistpage = 3;
        for (int i = 0; i < numberoftimesscrollMycourselistpage; i++) {
            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The My Course List page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }

        // Scrolling My Course List Page Up
        numberoftimesscrollMycourselistpage = 3;
        for (int i = 0; i < numberoftimesscrollMycourselistpage; i++) {
            try {
                Thread.sleep ( 3000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
                System.out.println ( "Successfully scroll The My Course List page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }

//        // Clicking Float Icon
//        try {
//            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]" ) );
//            if (clickingFloatIcon.isDisplayed ()) {
//                Thread.sleep ( 5000 );
//                clickingFloatIcon.click ();
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println ( "FloatIcon Button Is Not Displayed" );
//        }

        // Verifying The list of Featured Course     any one of them was getting Duplicate or Not

        // Finding All The elements From the Article components
        List<WebElement> allCourseName = driver.findElements ( xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]" ) );

        // Create a set to store unique Article URLs
        Set<String> uniqueMycourseName = new HashSet<> ();
        int uniquesMycourseCount = 0;

        // Iterate through the list of elements
        for (WebElement MyCourseElement : allCourseName) {
            String actualCourseName = MyCourseElement.getText ();
//            System.out.println ( "Original Course Name: " + actualCourseName );
            if (uniqueMycourseName.contains ( actualCourseName )) {
                System.out.println ( "Duplicate Course Name found --> " + actualCourseName );
            } else {
                uniqueMycourseName.add ( actualCourseName );
                uniquesMycourseCount++;
//                System.out.println ( "Course Name Found: " + uniquesMycourseCount + " --> " + actualCourseName );
//                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique Courses found
        System.out.println ( "Total unique Courses found In My Course: " + uniquesMycourseCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquesMycourseCount , uniqueMycourseName.size () );

        // Getting the featured Course List
        List<WebElement> featuredCourseName = driver.findElements ( xpath ( "//img[@alt=\"fearured_tag\"]/preceding::*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]" ) );

        Set<String> uniqueFeaturedCourseName = new HashSet<> ();
        int uniqueFeaturedCourseCount = 0;

        for (WebElement FeaturedCourse : featuredCourseName) {
            String actualFeaturedCourseName = FeaturedCourse.getText ();
            System.out.println ( "Featured Course Name: " + actualFeaturedCourseName );
            if (uniqueFeaturedCourseName.contains ( actualFeaturedCourseName )) {
                System.out.println ( "Duplicate Featured Course Name: " + actualFeaturedCourseName );
            } else {
                uniqueFeaturedCourseName.add ( actualFeaturedCourseName );
                uniqueFeaturedCourseCount++;
            }
        }
        // Print the total number of unique Featured Courses found
        System.out.println ( "Total unique Featured Course found: " + uniqueFeaturedCourseCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniqueFeaturedCourseCount , uniqueFeaturedCourseName.size () );
    }
}

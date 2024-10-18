package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class myCourseModule {

    WebDriver driver;

    public myCourseModule(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = false)
    public void myCourseClicking() throws InterruptedException, AWTException {

        // Clicking My Course Button
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 30 ) );
        WebElement clickingMyCourseButton = driver.findElement ( xpath ( "//* [text()='My Course']" ) );
        clickingMyCourseButton.click ();
        System.out.println ( "Successfully Clicked The My Course" );

//        /* Verifying The Duplicate Course In My Course List And All Course List // Creating An Object */
//        allCourseModule duplicateCourseName = new allCourseModule ( driver ); // We Are Reusing From The All Course
//        duplicateCourseName.verifyingDuplicate ();

//        /* My Course Filters > Creating An Object For Filter */
//        filters myCourseFilter = new filters ( driver );
//        myCourseFilter.Filter ();

        /* Creating An Object For My Course Base, From This Object We Can Access All The Sub-Modules Inside The Course */
        myCourseInnerActions courseClick = new myCourseInnerActions ( driver );
        courseClick.courseClicking ();
    }

}

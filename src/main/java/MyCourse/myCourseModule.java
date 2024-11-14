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
//
//        /* Verifying The Duplicate Course In My Course List And All Course List // Creating An Object */
//        allCourseModule duplicateCourseName = new allCourseModule ( driver ); // We Are Reusing From The All Course
//        duplicateCourseName.verifyingDuplicate ();
//
//        /* My Course Filters > Creating An Object For Filter */
//        filters myCourseFilter = new filters ( driver );
//        myCourseFilter.Filter ();

//        /* Creating An Object For My Course Base, From This Object We Can Access All The Sub-Modules Inside The Course */
//        myCourseInnerActions courseClick = new myCourseInnerActions ( driver );
//        courseClick.courseClicking ();

        // Creating an Object for the Path Module
        path clickingpath = new path ( driver );
        clickingpath.allpath ();

        // Creating an object for the Article Module
        article clickingarticle = new article ( driver );
        clickingarticle.Article ();

        // Creating an object for the Videos Module
        videos clickingvideos = new videos ( driver );
        clickingvideos.videos ();

// Creating an object for the Quiz Module
//        quizzes clickingquiz = new quizzes ( driver );
//        clickingquiz.Quizzes ();

        // Creating an object for the ebook Module
        ebooks clickingebook = new ebooks ( driver );
        clickingebook.Ebooks ();

        // Creating an object for The Doubts
        doubts clickingdoubt = new doubts(driver);
        clickingdoubt.doubtbase();

        // Creating an object for the free tab
        free clickingfreetab = new free(driver);
        clickingfreetab.freeTab();

        // Creating an object for the details
        details clickingdetails = new details(driver);
        clickingdetails.details();



    }

    @Test
    public void courseClicking() {
        // Clicking The particular Course
        try {
            WebElement clickingCourse = driver.findElement(xpath("//*[text()='Crack Current Affairs 2024 PDF']"));
            clickingCourse.click();
        }catch (Exception e){
            System.out.println("Error");
        }
    }

}

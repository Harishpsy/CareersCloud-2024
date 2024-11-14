package AllCourse;
import Master.Base.CoreFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;


import static org.openqa.selenium.By.xpath;

public class allCourseModule {

    WebDriver driver;

    public allCourseModule(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void allCourse() throws InterruptedException{

        //Clicking The All Course Button In the Header
        Thread.sleep ( 5000 );
        WebElement clickingAllCourse = driver.findElement ( xpath ( "//*[text()='All Course']" ) );
        clickingAllCourse.click ();
        System.out.println ( "SuccessFully Clicked The All Course Button In The Header" );

    }

    @Test
    public void verifyingDuplicate() throws InterruptedException, AWTException {

        // Scrolling The page In the ebook list page
        CoreFunctionality scroll = new CoreFunctionality(driver);
        scroll.Scroll();

        // Clicking Float Icon
        CoreFunctionality floatIcon = new CoreFunctionality(driver);
        floatIcon.floatButton();

        // Verifying The list of Ebooks any one of them was getting Duplicate or Not
        CoreFunctionality duplicatefinding =  new CoreFunctionality(driver);
        duplicatefinding.identifingDuplicate();

        // Getting The List Of featured Course In The Course List Before Filter
        // Getting the featured Course List
        List<WebElement> featuredCourseName = driver.findElements ( xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]/preceding::*[@alt=\"fearured_tag\"]" ) );

        // Print the total number of unique Featured Courses found
        System.out.println ( "Total unique Featured Course found: " + featuredCourseName.size () );

        //Clicking the course
        allCourseBase clickingcourse = new allCourseBase(driver);
        clickingcourse.courseclicking();

    }
}

package AllCourse;

import MyCourse.MyCourse_Filters;
import org.openqa.selenium.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class allCourseFilter extends MyCourse_Filters {

    public WebDriver driver;

    public allCourseFilter(WebDriver driver) {
        this.driver = driver;
    }

    public void filter() throws InterruptedException {

        //Performing The Same action From The My Course to The All Course For The Filter
//        MyCourse_Filters filter = new MyCourse_Filters ( driver );
//        filter.Filter ();
        System.out.println ( "Successfully Filter Performed In The All Course Tab" );

        //Non Subscribe Course List
        allCourseFilter nonSibscribrded = new allCourseFilter ( driver );
        nonSibscribrded.nonSubscribedCourseList ();

        //Subscribe Course List
        allCourseFilter subscribedlist = new allCourseFilter ( driver );
        subscribedlist.subscribedCourse ();
    }

    public void nonSubscribedCourseList() throws InterruptedException {

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

//        // Getting the non-subscribed Course List
        List<WebElement> nonSubscribedCourseName = driver.findElements ( By.xpath ( "//*[@class='ant-typography all-courses-special-price css-xu9wm8']" ) );

        Set<String> uniquenonSubscribedCourseName = new HashSet<> ();

        // Print the total number of elements found by the XPath
        System.out.println ( "Total number of elements found with the given XPath: " + nonSubscribedCourseName.size () );

        for (WebElement FeaturedCourse : nonSubscribedCourseName) {
            String actualFeaturedCourseName = FeaturedCourse.getText ();
            if (!uniquenonSubscribedCourseName.contains ( actualFeaturedCourseName )) {
                uniquenonSubscribedCourseName.add ( actualFeaturedCourseName );
            }
        }
        // Print the count of unique Featured Courses
//        System.out.println("Total unique Featured Courses found: " + uniquenonSubscribedCourseName.size());
    }

    public void subscribedCourse() {

        // Getting the subscribed Course List
        List<WebElement> subscribedCourseName = driver.findElements ( By.xpath ( "//*[@class=\"ant-typography all-courses-subscribed-text css-xu9wm8\"]" ) );

        Set<String> uniqueSubscribedCourseName = new HashSet<> ();

        // Print the total number of elements found by the XPath
        System.out.println ( "Total number of elements found with the given XPath In The Subscribed List: " + subscribedCourseName.size () );

        for (WebElement subscribedCourse : subscribedCourseName) {
            String actualSubscribedCourseName = subscribedCourse.getText ();
            if (!uniqueSubscribedCourseName.contains ( actualSubscribedCourseName )) {
                uniqueSubscribedCourseName.add ( actualSubscribedCourseName );
            }
        }
        // Print the count of unique Featured Courses
//        System.out.println("Total unique Featured Courses found: " + uniquenonSubscribedCourseName.size());
    }

}









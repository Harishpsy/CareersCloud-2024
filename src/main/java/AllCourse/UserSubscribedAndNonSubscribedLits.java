package AllCourse;

import Master.Base.CoreFunctionality;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class UserSubscribedAndNonSubscribedLits {

    public WebDriver driver;

    public UserSubscribedAndNonSubscribedLits(WebDriver driver) {
        this.driver = driver;
    }


    @Test
    public void UserSubscribedAndNoSubscribed() throws InterruptedException {

        //Non Subscribe Course List
        UserSubscribedAndNonSubscribedLits nonSubscribed = new UserSubscribedAndNonSubscribedLits ( driver );
        nonSubscribed.nonSubscribedCourseList ();

        //Subscribe Course List
        UserSubscribedAndNonSubscribedLits subscribedlist = new UserSubscribedAndNonSubscribedLits ( driver );
        subscribedlist.subscribedCourse ();

        //Free Course Which Is Not Subscribed In The All Course List Page
        UserSubscribedAndNonSubscribedLits free = new UserSubscribedAndNonSubscribedLits ( driver );
        free.freeCourse ();

    }
    public void nonSubscribedCourseList() throws InterruptedException {

        // Scrolling The page In the ebook list page
        CoreFunctionality scroll = new CoreFunctionality(driver);
        scroll.Scroll();

        // Clicking Float Icon
        CoreFunctionality floatIcon = new CoreFunctionality(driver);
        floatIcon.floatButton();

        // Getting the non-subscribed Course List
        List<WebElement> nonSubscribedCourseName = driver.findElements ( By.xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]/following::*[@class=\"ant-typography all-courses-special-price css-xu9wm8\"]" ) );

        // Print the total number of elements found by the XPath
        System.out.println ( "Total number of Courses found In The Non-Subscribed List: " + nonSubscribedCourseName.size () );

    }

    public void subscribedCourse() {

        // Getting the subscribed Course List
        //  <WebElement> subscribedCourseName = driver.findElements ( By.xpath ( "//*[@class=\"ant-typography all-courses-subscribed-text css-xu9wm8\"]" ) );
        List<WebElement> subscribedCourseName = driver.findElements ( By.xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]/following::*[@class=\"ant-typography all-courses-subscribed-text css-xu9wm8\"]" ) );

        // Print the total number of elements found by the XPath
        System.out.println ( "Total number of Courses found In The Subscribed List: " + subscribedCourseName.size () );

    }

    public void freeCourse() {

        List<WebElement> freeCourseNonSubscribed = driver.findElements ( xpath ( "//*[@class=\"ant-typography all-courses-card-title css-xu9wm8\"]/following::*[@class=\"ant-typography all-courses-free-text css-xu9wm8\"]" ) );

        //Printing The Total Number Of Elements Present For Free
        System.out.println ( "Total number of Courses found In The Free Course which Not Subscribed:" + freeCourseNonSubscribed.size () );

    }

}









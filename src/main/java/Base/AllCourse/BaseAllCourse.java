package Base.AllCourse;

import AllCourse.UserSubscribedAndNonSubscribedLits;
import AllCourse.allCourseModule;
import MyCourse.filters;
import MyCourse.myCourseInnerActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class BaseAllCourse {

    WebDriver driver;

    // Creating A Constructor For The All Course Base, We Can Access All Through Here
    public BaseAllCourse(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void allCourseModule() throws InterruptedException, AWTException {

        // Creating An Object For The All Course Module We Can Access Through This Class,
        // This is using For Click The All Course Modules Only
        allCourseModule allcourse = new allCourseModule ( driver );
        allcourse.allCourse ();

        //Verifying The Duplicate Course In The all Course List Feeds
        allCourseModule duplicateCourseName = new allCourseModule ( driver );
        duplicateCourseName.verifyingDuplicate ();

        //Performing The Filter action From The My Course to The All Course For The Filter
        filters allCourseFilter = new filters ( driver );
        allCourseFilter.Filter ();
        System.out.println ( "Successfully Filter Performed In The All Course Tab" );

        // Getting The Total Count Of Subscriber Course And Non-Subscriber Course List In The All Courses
        UserSubscribedAndNonSubscribedLits courses = new UserSubscribedAndNonSubscribedLits ( driver );
        courses.UserSubscribedAndNoSubscribed ();

        // Creating An Object For My Course Base, From This Object We Can Access All The Sub-Modules Inside The Course
        myCourseInnerActions courseClick = new myCourseInnerActions ( driver );
        courseClick.courseClicking ();

    }
}

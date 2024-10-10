package Master.MyCourse;

import AllCourse.allCourseSubscribeNow;
import Master.MainObjects.BaseObjects;
import MyCourse.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class BaseMyCourse extends BaseObjects {

    static WebDriver driver;

    // Creating A Constructor For My Course Mobules
    public BaseMyCourse(WebDriver driver) {
        BaseMyCourse.driver = driver;
    }

    @Test
    public static void myCourseModule() throws InterruptedException, AWTException {

        /* Clicking My Course Module In The Header Section */
        myCourseModule Mycourse = new myCourseModule ( driver );
        Mycourse.myCourseClicking ();
        /* My Course Sub Modules Was Performing In The My Course Inner Action Class You Can Visit There */
    }

    // Perform actions on the submodules as per your code (articles, videos, quizzes, ebooks, etc.)
    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void myCourseSubModules() throws InterruptedException, AWTException {

        // **Re-initialize the subscribeNow object to handle dynamic page reloading**
        allCourseSubscribeNow subscribeNow = new allCourseSubscribeNow ( driver );
        subscribeNow.subscribeNowButton ();  // Perform the subscription action
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void path() throws InterruptedException {
        /* Perform actions on path tab */
        path path = new path ( driver );
        path.allpath ();
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void article() throws InterruptedException {
        /* Creating An Object For The Article Sub Module, Performing The Actions */
        article article = new article ( driver );
        article.Article ();
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void videos() throws InterruptedException {
        /* Creating An Object For The Videos Sub Module, Performing The Actions */
        videos video = new videos ( driver );
        video.videos ();
    }

//        /* Creating An Object For The Quizzes Sub Module, Performing The Actions */
//        quizzes quizzes = new quizzes ( driver );
//        quizzes.Quizzes ();

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void ebooks() {
        /* Creating An Object For The Ebooks Sub Module, Performing The Actions */
        ebooks ebooks = new ebooks ( driver );
        ebooks.Ebooks ();
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void doubtbase() throws InterruptedException, AWTException {
        /* Creating An Object For The Doubts Sub Module, Performing The Actions */
        doubts doubtPage = new doubts ( driver );
        doubtPage.doubtbase ();
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void freetab() throws InterruptedException {
        /* Creating An Object For The Free Sub Module, Performing The Actions */
        free freetab = new free ( driver );
        freetab.freeTab ();
    }

    @Test(enabled = true, dependsOnMethods = "myCourseModule")
    public static void details() throws InterruptedException, AWTException {
        /* Creating An Object For The Article, Performing The Actions */
        details detailsPage = new details ( driver );
        detailsPage.details ();
    }

}

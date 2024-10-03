package Base.MyCourse;

import AllCourse.allCourseSubscribeNow;
import MyCourse.*;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class BaseMyCourse {

    WebDriver driver;

    // Creating A Constructor For My Course Mobules
    public BaseMyCourse(WebDriver driver) {
        this.driver = driver;
    }

    public void myCourseModule() throws InterruptedException, AWTException {

        /* Clicking My Course Module In The Header Section */
        myCourseModule Mycourse = new myCourseModule ( driver );
        Mycourse.myCourseClicking ();

        /* My Course Sub Modules Was Performing In The My Course Inner Action Class You Can Visit There */
    }

    public void myCourseSubModules() throws InterruptedException, AWTException {

        // Perform actions on the submodules as per your code (articles, videos, quizzes, ebooks, etc.)

        // **Re-initialize the subscribeNow object to handle dynamic page reloading**
        allCourseSubscribeNow subscribeNow = new allCourseSubscribeNow ( driver );
        subscribeNow.subscribeNowButton ();  // Perform the subscription action

        /* Perform actions on path tab */
        path path = new path ( driver );
        path.allpath ();

        /* Creating An Object For The Article Sub Module, Performing The Actions */
        article article = new article ( driver );
        article.Article ();

        /* Creating An Object For The Videos Sub Module, Performing The Actions */
        videos video = new videos ( driver );
        video.videos ();

        /* Creating An Object For The Quizzes Sub Module, Performing The Actions */
        quizzes quizzes = new quizzes ( driver );
        quizzes.Quizzes ();

        /* Creating An Object For The Ebooks Sub Module, Performing The Actions */
        ebooks ebooks = new ebooks ( driver );
        ebooks.Ebooks ();

        /* Creating An Object For The Doubts Sub Module, Performing The Actions */
        doubts doubtPage = new doubts ( driver );
        doubtPage.doubtbase ();

        /* Creating An Object For The Free Sub Module, Performing The Actions */
        free freetab = new free ( driver );
        freetab.freeTab ();

        /* Creating An Object For The Article, Performing The Actions */
        details detailsPage = new details ( driver );
        detailsPage.details ();

    }
}

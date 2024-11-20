package Master.Home;

import Home.ArticleEbooksandCourseActions;
import Home.FooterSections;
import Home.HomeFeedActions;
import Home.VerifyingDuplicateInHomeFeeds;
import Master.MainObjects.BaseObjects;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BaseHomePage class orchestrates all the actions and verifications related to the Home Page.
 * It acts as a central point for executing:
 * 1. Home Feed actions.
 * 2. Footer section interactions.
 * 3. Article, eBook, and course-related actions.
 * 4. Duplicate verification in Home Feeds.
 */
public class BaseHomePage extends ScreenShot {

    public WebDriver driver;

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver WebDriver instance for the test.
     */
    public BaseHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Executes all Home Page-related modules.
     *
     * @throws InterruptedException If thread sleep is interrupted during test execution.
     * @throws IOException          If an error occurs during file handling.
     */
    @Test
    public void HomeModule() throws InterruptedException, IOException {
        System.out.println ( "Starting Home Page Module..." );

        // 1. Execute Home Feed Actions
        System.out.println ( "Executing Home Feed Actions..." );
        HomeFeedActions homeFeedActions = new HomeFeedActions ( driver );
        homeFeedActions.homePageActions ();
        System.out.println ( "Home Feed Actions completed successfully." );
        ScreenShot.captureScreenshot ( "Home Feed Actions completed" );

        // 2. Verify Duplicates in Home Feeds
        Thread.sleep ( 5000 );
        System.out.println ( "Verifying duplicates in Home Feeds..." );
        VerifyingDuplicateInHomeFeeds duplicateVerifier = new VerifyingDuplicateInHomeFeeds ( driver );
        duplicateVerifier.verifyingDuplicate ();
        System.out.println ( "Duplicate verification completed successfully." );
        ScreenShot.captureScreenshot ( "Duplicate verification completed" );

        // 3. Perform Actions on Articles, eBooks, and Courses
        System.out.println ( "Performing actions on Articles, eBooks, and Courses..." );
        ArticleEbooksandCourseActions articleActions = new ArticleEbooksandCourseActions ( driver );
        articleActions.ArticleEbooksandCourse ();
        System.out.println ( "Article, eBook, and Course actions completed successfully." );
        ScreenShot.captureScreenshot ( "Article, eBook, and Course actions completed" );

        // 4. Interact with Footer Sections
        System.out.println ( "Interacting with Footer Sections..." );
        FooterSections footerSections = new FooterSections ( driver );
        footerSections.footerSection ();
        System.out.println ( "Footer Section interactions completed successfully." );
        ScreenShot.captureScreenshot ( "Footer Section interactions completed" );

    }
}

package Master.MainObjects;

import LoginPage.Loginpage;
import Logout.Logout;
import Master.AllCourse.BaseAllCourse;
import Master.Base.CoreFunctionality;
import Master.Doubt.BaseDoubts;
import Master.Home.BaseHomePage;
import Master.Menu.BaseMenu;
import Master.MyCourse.BaseMyCourse;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BaseObjects class for test automation with ExtentReports and screenshot logging.
 */
public class BaseObjects {

    public static WebDriver driver;
    protected static ExtentTest test;
    private static ExtentReports extentReports;

    /**
     * Captures a screenshot of the current browser window.
     *
     * @param testName Name of the test case.
     * @return Path to the saved screenshot.
     */

    @Test
    public static String captureScreenshot(String testName) throws IOException {
        String timestamp = new SimpleDateFormat ( "yyyyMMdd_HHmmss" ).format ( new Date () );
        String screenshotPath = "./screenshots/" + testName + "_" + timestamp + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );

        try {
            File destination = new File ( screenshotPath );
            Files.createDirectories ( destination.getParentFile ().toPath () );
            Files.copy ( screenshotFile.toPath () , destination.toPath () );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return screenshotPath;
    }

    /**
     * Sets up the WebDriver and ExtentReports.
     */
    @BeforeClass
    public void setup() {
        // Initialize ExtentReports
        ExtentSparkReporter reporter = new ExtentSparkReporter ( "./TestReport.html" );
        reporter.config ().setDocumentTitle ( "Automation Test Report" );
        reporter.config ().setReportName ( "Module Testing" );
        extentReports = new ExtentReports ();
        extentReports.attachReporter ( reporter );

        // Set up ChromeDriver with incognito mode
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( "--incognito" );
        driver = new ChromeDriver ( options );
    }

    /**
     * Logs test results and captures screenshots for failures.
     */
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        // Capture the screenshot
        String screenshotPath = captureScreenshot ( result.getName () );

        if (result.getStatus () == ITestResult.SUCCESS) {
            test.pass ( result.getName () + " passed successfully." ,
                    MediaEntityBuilder.createScreenCaptureFromPath ( screenshotPath ).build () );
        } else if (result.getStatus () == ITestResult.FAILURE) {
            test.fail ( result.getName () + " failed: " + result.getThrowable () ,
                    MediaEntityBuilder.createScreenCaptureFromPath ( screenshotPath ).build () );
        } else if (result.getStatus () == ITestResult.SKIP) {
            test.skip ( result.getName () + " was skipped." ,
                    MediaEntityBuilder.createScreenCaptureFromPath ( screenshotPath ).build () );
        }
    }

    /**
     * Cleans up WebDriver resources and flushes the ExtentReport.
     */
    @AfterClass
    public void tearDown() {
        extentReports.flush ();
    }

    // Test methods follow, same as before...
    @Test(enabled = true, priority = 1)
    public void loginTest() throws InterruptedException, IOException {
        test = extentReports.createTest ( "Login Test" );
        Loginpage loginPage = new Loginpage ( driver );
        loginPage.login ();
    }

    @Test(enabled = false, priority = 2)
    public void homeModuleTest() throws InterruptedException, IOException {
        test = extentReports.createTest ( "Home Module Test" );
        BaseHomePage home = new BaseHomePage ( driver );
        home.HomeModule ();
    }

    @Test(enabled = true, priority = 3)
    public void menuModuleTest() throws InterruptedException, IOException {
        test = extentReports.createTest ( "Menu Module Test" );
        BaseMenu menu = new BaseMenu ( driver );
        menu.testMyNotes ();
        menu.testMyNotesArticle ();
        menu.testMyNotesVideos ();
//      menu.testMyNotesStartQuiz ();
//      menu.testMyNotesResumeQuiz ();
//      menu.testMyNotesQuizSolution ();
        menu.testMyQuestions ();
        menu.testMyEbooks ();
        menu.testMyCoins ();
        menu.testMyPoints ();
        menu.testInviteFriends ();
        menu.testRateApp ();
        menu.testMyPurchase ();
        menu.testHireUs ();
    }

    @Test(enabled = true, priority = 4)
    public void myCourseModuleTest() throws InterruptedException, AWTException, IOException {
        test = extentReports.createTest ( "My Course Module Test" );
        BaseMyCourse course = new BaseMyCourse ( driver );
        course.myCourseModule ();
    }
    @Test(enabled = false, priority = 5)
    public void allCoursesModuleTest() throws InterruptedException, AWTException, IOException {
        test = extentReports.createTest ( "All Courses Module Test" );
        BaseAllCourse allCourse = new BaseAllCourse ( driver );
        allCourse.allCourseModule ();
    }

    @Test(enabled = false, priority = 6)
    public void doubtsModuleTest() throws InterruptedException, AWTException {
        test = extentReports.createTest ( "Doubts Module Test" );
        BaseDoubts doubts = new BaseDoubts ( driver );
        doubts.doubtsModule ();
    }

    @Test(enabled = false, priority = 7)
    public void logout() throws InterruptedException {
        test = extentReports.createTest ( "Logout Test" );
        Logout logout = new Logout ( driver );
        logout.clickingLogout ();
    }
}
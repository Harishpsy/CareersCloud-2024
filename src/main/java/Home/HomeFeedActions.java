package Home;

import Master.Base.CoreFunctionality;
import Master.MainObjects.BaseObjects;
import PageObjectModule.Homepageobject;
import ScreenShot.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Homepageobject.*;

public class HomeFeedActions extends ScreenShot {

    WebDriver driver;

    public HomeFeedActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Automates various actions on the home page including clicking buttons, scrolling, and handling windows.
     * It performs the following actions in sequence:
     * - Initializes page elements for the homepage.
     * - Clicks the preference, railway, and bank & insurance buttons with delays.
     * - Adds preferences by clicking corresponding buttons and scrolling the page.
     * - Saves preferences and interacts with the UPSC button.
     * - Handles right arrow clicks for home feed navigation.
     * - Interacts with banners in the home feed and Course BreadCrumbs to return.
     * - Clicks and interacts with the Google Play button.
     * - Manages window handles to switch between parent and child windows and back.
     * - Scrolls the homepage a specified number of times.
     * - Clicks a floating icon if it is displayed, with handling for exceptions.
     *
     * @throws InterruptedException if any thread.sleep() operations are interrupted.
     */
    @Test
    public void homePageActions() throws InterruptedException, IOException {

        // Writing For Home Feed
        PageFactory.initElements ( driver , Homepageobject.class );

        // clicking Preference Button
        Thread.sleep ( 20000 );
        clickingPreferenceButton.click ();
        ScreenShot.captureScreenshot ( "Clicking Preference Button" );
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Railway Button
        Thread.sleep ( 10000 );
        clickingRailwayButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Railway Button" );
        System.out.println ( "SuccessFully Clicked The Railway Button" );

        // clicking Preference Button
        Thread.sleep ( 10000 );
        clickingPreferenceButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Preference Button" );
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Bank&Insurance Button
        Thread.sleep ( 5000 );
        clickingBankandInsuranceButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Bank&Insurance Button" );
        System.out.println ( "SuccessFully Clicked The Bank&Insurance Button" );

        // clicking Preference Button
        Thread.sleep ( 30000 );
        clickingPreferenceButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Preference Button" );
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 10000 );
        clickingAddPreferencebutton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Add Preference Button" );
        System.out.println ( "SuccessFully Clicked The Add Preference Button" );

        //Scrolling Down Function
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
        ScreenShot.captureScreenshot ( "Scrolling The Page" );

        // clicking UPSC Button
        Thread.sleep ( 5000 );
        clickingUPSCButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The UPSC Button" );
        System.out.println ( "SuccessFully Un-Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 5000 );
        clickingsavePreference.click ();
        ScreenShot.captureScreenshot ( "Clicked The Save Preference Button" );
        System.out.println ( "SuccessFully Clicked The Save Preference Button" );

        // clicking Preference Button
        Thread.sleep ( 10000 );
        clickingPreferenceButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Preference Button" );
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 10000 );
        clickingAddPreferencebutton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Add Preference" );
        System.out.println ( "SuccessFully Clicked The Add Preference" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
        ScreenShot.captureScreenshot ( "Scrolling The Page" );

        // clicking UPSC Button
        Thread.sleep ( 5000 );
        clickingUPSCButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The UPSC Button" );
        System.out.println ( "SuccessFully Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 3000 );
        clickingsavePreference.click ();
        ScreenShot.captureScreenshot ( "Clicked The Save Preference" );
        System.out.println ( "SuccessFully Clicked The Save Preference" );

        // Clicking Cancel Button In Profile
//        WebElement clickingCancelButton = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButton.click ();
//        captureScreenshot ( "Clicked The Right arrow in the Home feed" );

        // Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 5000 );
        clickingBannerInHomeFeed.click ();
        ScreenShot.captureScreenshot ( "Clicked The banners in the home feed" );
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        ScreenShot.captureScreenshot ( "Clicked The course BreadCrumbs" );
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 7000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed1.click ();
        ScreenShot.captureScreenshot ( "Clicked The banners in the home feed 2" );
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        ScreenShot.captureScreenshot ( "Clicked The course BreadCrumbs for coming back" );
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs for coming back" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 5000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        ScreenShot.captureScreenshot ( "Clicked The Right arrow in the Home feed" );
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed2.click ();
        ScreenShot.captureScreenshot ( "Clicked The banners in the home feed 3 " );
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking The Close icon In The Course Banner Modal
        Thread.sleep ( 3000 );
        clickingCloseIcon.click ();
        ScreenShot.captureScreenshot ( "Clicked Close icon In The Course Banner Modal" );
        System.out.println ( "SuccessFully Clicked Close icon In The Course Banner Modal" );

        // Clcking The Google Play Button
        Thread.sleep ( 3000 );
        clickingGoooglePlayButton.click ();
        ScreenShot.captureScreenshot ( "Clicked The Google Play Button" );
        System.out.println ( "SuccessFully Clicked The Google Play Button" );

        //Windows Handeling child to parent and parent to child
        Thread.sleep ( 3000 );
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
        ScreenShot.captureScreenshot ( "Navigated To The Chid Page" );
        driver.close ();
        driver.switchTo ().window ( parent );
        ScreenShot.captureScreenshot ( "Navigated To The Parent Page" );

        // Scrolling the HomePage page
        CoreFunctionality scroll = new CoreFunctionality ( driver );
        scroll.Scroll ();
        ScreenShot.captureScreenshot ( "Scrolled The Page" );

        // Clicking Float Icon
        CoreFunctionality floatButton = new CoreFunctionality ( driver );
        floatButton.floatButton ();
        ScreenShot.captureScreenshot ( "Clicked The Float Button" );
    }
}

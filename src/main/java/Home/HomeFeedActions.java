package Home;

import Master.Base.CoreFunctionality;
import PageObjectModule.Homepageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Homepageobject.*;

public class HomeFeedActions {

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
    public void homePageActions() throws InterruptedException {

        // Writing For Home Feed
        PageFactory.initElements ( driver , Homepageobject.class );

        // clicking Preference Button
        Thread.sleep ( 15000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Railway Button
        Thread.sleep ( 5000 );
        clickingRailwayButton.click ();
        System.out.println ( "SuccessFully Clicked The Railway Button" );

        // clicking Preference Button
        Thread.sleep ( 5000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Bank&Insurance Button
        Thread.sleep ( 5000 );
        clickingBankandInsuranceButton.click ();
        System.out.println ( "SuccessFully Clicked The Bank&Insurance Button" );

        // clicking Preference Button
        Thread.sleep ( 5000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 20000 );
        clickingAddPreferencebutton.click ();
        System.out.println ( "SuccessFully Clicked The Add Preference Button" );

        //Scrolling Down Function
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );

        // clicking UPSC Button
        Thread.sleep ( 5000 );
        clickingUPSCButton.click ();
        System.out.println ( "SuccessFully Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 5000 );
        clickingsavePreference.click ();
        System.out.println ( "SuccessFully Clicked The Save Preference Button" );

        // clicking Preference Button
        Thread.sleep ( 40000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 40000 );
        clickingAddPreferencebutton.click ();
        System.out.println ( "SuccessFully Clicked The Add Preference" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );

        // clicking UPSC Button
        Thread.sleep ( 3000 );
        clickingUPSCButton.click ();
        System.out.println ( "SuccessFully Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 3000 );
        clickingsavePreference.click ();
        System.out.println ( "SuccessFully Clicked The Save Preference" );

        // Clicking Cancel Button In Profile
//        WebElement clickingCancelButton = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButton.click ();

        // Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 5000 );
        clickingBannerInHomeFeed.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 7000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed1.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs for coming back" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 5000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed2.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking The Close icon In The Course Banner Modal
        Thread.sleep ( 3000 );
        clickingCloseIcon.click ();
        System.out.println ( "SuccessFully Clicked Close icon In The Course Banner Modal" );

        // Clcking The Google Play Button
        Thread.sleep ( 3000 );
        clickingGoooglePlayButton.click ();
        System.out.println ( "SuccessFully Clicked The Google Play Button" );

        //Windows Handeling child to parent and parent to child
        Thread.sleep ( 3000 );
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
        driver.close ();
        driver.switchTo ().window ( parent );

        // Scrolling the HomePage page
        CoreFunctionality scroll = new CoreFunctionality ( driver );
        scroll.Scroll ();

        // Clicking Float Icon
        CoreFunctionality floatButton = new CoreFunctionality ( driver );
        floatButton.floatButton ();
    }


}

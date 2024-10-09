package MyCourse;

import Master.Base.CoreFunctionality;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.By.xpath;


public class videos {
    WebDriver driver;
    public videos(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void videos() throws InterruptedException {

        // Verifying The Videos Sub-Module Was Displaying, if Display Perform The Below Action
        try {
            WebElement clickingVideoTab = driver.findElement ( xpath ( "//*[text()='Videos']" ) );

            if (clickingVideoTab.isSelected ()) {
                System.out.println ( "Videos Tab Is Already Selected, We Are Performing The Below Actions In The Videos Tab List Page" );
            } else if (clickingVideoTab.isDisplayed ()) {
                clickingVideoTab = driver.findElement ( xpath ( "//*[text()='Videos']" ) );
                clickingVideoTab.click ();
                System.out.println ( "Successfully Clicked The Videos Tab, And Performing The action In The List Page" );
            } else {
                System.out.println ( "Both The Code Has Not Executed In The Course Videos Tab" );
            }

            videos actions = new videos ( driver );
            actions.videosActions ();

        } catch (Exception e) {
            System.out.println ( "Videos Tab Is Not Present In The Current Course" );
        }

    }

    @Test
    public void videosActions() throws InterruptedException {

        // Scrolling The Videos List Page
        CoreFunctionality scroll = new CoreFunctionality ( driver );
        scroll.Scroll ();

        // Clicking Float Icon
        CoreFunctionality floatIcon = new CoreFunctionality ( driver );
        floatIcon.floatButton ();

        // Verifying the videoscard was getting duplicating using the unique videos Url
        List<WebElement> cards = driver.findElements (xpath ("//*[@class=\"video-iframe\"]"));

        // Create a set to store unique Ebook Titles
        Set<String> uniqueUrls = new HashSet<> ();
        int uniqueCount = 0;

        for (WebElement card : cards) {
            String actualUrl = card.getAttribute ("src");

            if (uniqueUrls.contains (actualUrl)) {
                System.out.println ("Duplicate found --> " + actualUrl);
            } else {
                uniqueUrls.add (actualUrl);
                uniqueCount++;
                //System.out.println ("Found: " + uniqueCount + " --> " + actualUrl);
                //System.out.println ("-------------------------------------------------------------------------");
            }
        }

        // Print the total number of unique URLs found
        System.out.println ("Total unique videos url found: " + uniqueCount);

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals (uniqueCount, uniqueUrls.size ());

        // Clicking The View Button
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (30));
        WebElement clickingViewButton = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//*[@class=\"video-card-inner-content\"]")));
        wait.until (ExpectedConditions.visibilityOf (clickingViewButton));
        clickingViewButton.click ();

        // Getting The video Name For Verify In The My Notes
        WebElement gettingVideoName = driver.findElement ( xpath ( "//*[@class=\"ant-typography title css-xu9wm8\"]" ) );
        String VideoName = gettingVideoName.getText ();
        System.out.println ( "Original Video Name:" + VideoName );

        // Clicking the like and unlike button
        WebElement clickAction = driver.findElement (xpath ("//*[contains(@class, 'like') or contains(@class, 'unlike')]"));

        if (clickAction.isDisplayed ()) {
            clickAction.click ();

            if (clickAction.getAttribute ("class").contains ("unlike")) {
                System.out.println ("Un Liked Successfully ");
            } else {
                System.out.println (" Liked Successfully ");
            }
        }

//        // Clicking The Comment Icon
//        WebElement clickingCommentIcon = driver.findElement (id ("comments-icon"));
//        clickingCommentIcon.click ();
//
//        // Entering The comments
//        Thread.sleep (3000);
//        WebElement enteringComments = driver.findElement (name ("comments1"));
//        enteringComments.sendKeys ("Thanks For the update");
//        System.out.println ("Comment Added Sucessfully");
//
//       // Clicking The send Button
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

        // Clicking the share icon
        Thread.sleep (3000);
        WebElement clickingshareicon = driver.findElement (xpath ("//*[@class=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup
        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        Thread.sleep (3000);
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();
        System.out.println ("Clicked cancel button");

        // Clicking The Pause Button In The Viedos
        driver.switchTo ().frame (0);
        Thread.sleep (3000);
        WebElement clickingPauseButton = driver.findElement ( xpath ( "//*[@class=\"ytp-play-button ytp-button\"]" ) );
        clickingPauseButton.click ();
        System.out.println ("SucessFully Clicked Paused button");

        // Click the mute button in the video
        Thread.sleep ( 3000 );
        WebElement clickingMuteButton = driver.findElement ( xpath ( "//*[@class=\"ytp-mute-button ytp-button\"]" ) );
        clickingMuteButton.click ();
        System.out.println ("SucessFully Clicked Mute button");

        // Clicking The Caption button
        WebElement clickingCaptionButton = driver.findElement (xpath ("//*[@title=\"Subtitles/closed captions (c)\"]"));
        clickingCaptionButton.click ();
        System.out.println ("SucessFully Clicked Caption (ON) button");

        // Clicking the Full screen Button
        Thread.sleep (3000);
        WebElement clickingFullScreenButton = driver.findElement (xpath ("//*[@title=\"Full screen (f)\"]"));
        clickingFullScreenButton.click ();
        System.out.println ("SucessFully Clicked The Full Screen Button");

        // Clicking the Exit The Full screen Button
        Thread.sleep (3000);
        WebElement clickingExitFullScreenButton = driver.findElement (xpath ("//*[@title=\"Exit full screen (f)\"]"));
        clickingExitFullScreenButton.click ();
        System.out.println ("SucessFully Clicked The Exit Full Screen Button");


        // Clicking the YouTube Logo, It will navigate to YouTube or new windows
        Thread.sleep (3000);
        WebElement clickingYouTubeLogo = driver.findElement (xpath ("//*[@title=\"Watch on YouTube\"]"));
        clickingYouTubeLogo.click ();
        System.out.println ("SucessFully Clicked The YouTube Logo ");

        // Windows Handeling
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        // Navigating to viedos Page
        Thread.sleep (3000);
        driver.close ();

        // Switching Windows to Parent
        driver.switchTo ().window (parent);

        // Another Method for verifying Duplicate In The Wep page Using HashSet
        List<WebElement> recentVideos = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));

        // Create a set to store unique Recent Videos
        Set<String> uniqueurl = new HashSet<> ();
        int uniquevideosurlcount = 0;

        // Iterate through the list of elements
        for (WebElement recentVideo : recentVideos) {
            String actualUrls = recentVideo.getAttribute ("href");

            if (uniqueurl.contains (actualUrls)) {
                System.out.println ( "Duplicate found Recent Videos--> " + actualUrls );
            } else {
                uniqueurl.add (actualUrls);
                uniquevideosurlcount++;
                System.out.println ( "Recent Videos Found: " + uniquevideosurlcount + "-->" + actualUrls );
            }
        }
        System.out.println ("Total unique videos url found: " + uniquevideosurlcount);
        Assert.assertEquals (uniquevideosurlcount, uniqueurl.size ());

        // Clicking The Back Arrow in Viedos page
        Thread.sleep (3000);
        WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"ant-breadcrumb-link\"]"));
        clickingBackArrow.click ();
        System.out.println ("--------------------------------");
        System.out.println ("Sucessfully Clicking Back Arrow");

        // Clicking the three Dots in the CourseCard
        Thread.sleep ( 5000 );
        WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
        clickingThreeDots.click ();

        // Clicking The save My Notes OR Remove My Notes
        wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );

        try {
            Thread.sleep ( 3000 );
            WebElement saveMyEbookElement = wait.until ( ExpectedConditions.visibilityOfElementLocated ( xpath ( "(//*[@class=\"ant-dropdown-menu-title-content\"])[1]" ) ) );
            if (saveMyEbookElement.isDisplayed ()) {
                saveMyEbookElement.click ();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println ( "Save Or Remove My Ebook is not displayed." );
        }

//        // Clicking The Breadcrumbs
//        Thread.sleep (5000);
//        WebElement clickingBreadCrumbs = driver.findElement (xpath ("//*[text()='Course']"));
//        clickingBreadCrumbs.click ();
//        System.out.println ("SuccessFully Clicked The Bread crumbs and navigated to the My Course List Page");
//
//        // Clicking The home button
//        Thread.sleep ( 3000 );
//        WebElement clickingHomeButton = driver.findElement ( xpath ( "//*[text()='Home']" ) );
//        clickingHomeButton.click ();
//        System.out.println ( "SuccessFully Clicked The HomeButton" );
//
//        // Clicking The MyNotes
//        Thread.sleep ( 5000 );
//        WebElement clickingMyNotes = driver.findElement ( xpath ( "//*[@id=\"1\"]" ) );
//        clickingMyNotes.click ();
//        System.out.println ( "SuccessFully Clicked The My-Notes" );
//
//        // Verifying saved or removed article was showing in the My Notes Page
//        List<WebElement> videoMyNotes = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]" ) );
//
//        boolean videoFound = false;
//
//        for (WebElement Video : videoMyNotes) {
//            String videoNameInMyNotes = Video.getText ();
//            System.out.println ( videoNameInMyNotes );
//
//            if (VideoName.equals ( videoNameInMyNotes )) {
//                System.out.println ( "Verification Passed: Video Title (" + VideoName + ") matches Video Title In My Notes (" + videoNameInMyNotes + ")" );
//                videoFound = true;
//            }
////            else {
////                System.out.println ( "Video Name Does Not Match" );
////            }
//        }
//        if (!videoFound) {
//            System.out.println ( "Video Is Not Showing In The My Notes" );
//        }

    }
}



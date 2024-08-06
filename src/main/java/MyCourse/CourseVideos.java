package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.By.xpath;


public class CourseVideos {
    WebDriver driver;

    public CourseVideos(WebDriver driver) {
        this.driver = driver;
    }

    public void videos() throws InterruptedException {

        // Clicking The Ninth Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[9]"));
        clickingFirstCourseCard.click ();


        // Clicking The Videos

        Thread.sleep (3000);
        WebElement clickingVideoTab = driver.findElement (xpath ("//*[@id=\"rc-tabs-0-tab-4\"]"));
        clickingVideoTab.click ();

        // Scrolling The Videos List Page

        int numberOfTimesScrollVideos = 10;

        for (int i = 0; i < numberOfTimesScrollVideos; i++) {
            try {
                Thread.sleep (5000);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
                System.out.println ("Successfully scroll The page " + (i + 1) + " time(s).");
            } catch (Exception scroll) {
                System.out.println ("Failed to Scroll : " + scroll.getMessage ());
            }
        }

        // Clicking Float Icon

        WebElement clickingFloatIcon = driver.findElement (xpath ("//*[@class=\"ant-float-btn-body\"]"));
        clickingFloatIcon.click ();

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
                System.out.println ("Found: " + uniqueCount + " --> " + actualUrl);
                System.out.println ("-------------------------------------------------------------------------");
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
//
//        WebElement clickingCommentIcon = driver.findElement (id ("comments-icon"));
//        clickingCommentIcon.click ();
//
//        // Entering The comments
//
//        Thread.sleep (3000);
//        WebElement enteringComments = driver.findElement (name ("comments1"));
//        enteringComments.sendKeys ("Thanks For the update");
//        System.out.println ("Comment Added Sucessfully");
//
//       // Clicking The send Button
//
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
        WebElement clickingPauseButton = driver.findElement (xpath ("//*[@title=\"Pause (k)\"]"));
        clickingPauseButton.click ();
        System.out.println ("SucessFully Clicked Paused button");

        // Click the mute button in the video

        WebElement clickingMuteButton = driver.findElement (xpath ("//*[@title=\"Mute (m)\"]"));
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


        // Clicking the YouTube Logo It will navigate to YouTube or new windows

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

                System.out.println ("Duplicate found --> " + actualUrls);
            } else {
                uniqueurl.add (actualUrls);
                    uniquevideosurlcount++;
                    System.out.println ("Found: " + uniquevideosurlcount + "-->" + actualUrls);
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

        // Clicking The Breadcrumbs

        Thread.sleep (5000);
        WebElement clickingBreadCrumbs = driver.findElement (xpath ("//*[text()='Course']"));
        clickingBreadCrumbs.click ();
        System.out.println ("SuccessFully Clicked The Bread crumbs and navigated to the My Course List Page");

    }
}



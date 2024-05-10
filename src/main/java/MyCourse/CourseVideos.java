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

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The Ninth Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[9]"));
        clickingFirstCourseCard.click ();


        // Clicking The Videos

        Thread.sleep (3000);
        WebElement clickingVideoTab = driver.findElement (xpath ("//*[@id=\"rc-tabs-0-tab-4\"]"));
        clickingVideoTab.click ();

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

        String[] videosLinks = {"https://careerscloud.in/course-details/6/video/2164", "https://careerscloud.in/course-details/6/video/2158",
                "https://careerscloud.in/course-details/6/video/2162", "https://careerscloud.in/course-details/6/video/2160",
                "https://careerscloud.in/course-details/6/video/2155"};

        List<WebElement> recentVideos = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));
        Set<String> uniqueurl = new HashSet<> ();
        int uniquevideosurlcount = 0;

        for (WebElement recentVideo : recentVideos) {
            String actualUrls = recentVideo.getAttribute ("href");

            if (uniqueurl.contains (actualUrls)) {

                System.out.println ("Duplicate found --> " + actualUrls);
            } else {
                uniqueurl.add (actualUrls);
                if (Arrays.asList (videosLinks).contains (actualUrls)) {
                    uniquevideosurlcount++;
                    System.out.println ("Found: " + uniquevideosurlcount + "-->" + actualUrls);
                }
            }
        }
        System.out.println ("Total unique videos url found: " + uniquevideosurlcount);
        Assert.assertEquals (uniquevideosurlcount, videosLinks.length);


        // Clicking The Back Arrow in Viedo page

        Thread.sleep (3000);
        WebElement clickingBackArrow = driver.findElement (xpath ("//*[@class=\"ant-breadcrumb-link\"]"));
        clickingBackArrow.click ();
        System.out.println ("--------------------------------");
        System.out.println ("Sucessfully Clicking Back Arrow");

        // Scrolling the page down

        Thread.sleep (3000);
        JavascriptExecutor scrollpage = (JavascriptExecutor) driver;
        scrollpage.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Again Scrolling the page down

        Thread.sleep (3000);
        scrollpage = (JavascriptExecutor) driver;
        scrollpage.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling the page Up
        JavascriptExecutor scrollpageup = (JavascriptExecutor) driver;
        scrollpageup.executeScript ("window.scrollTo(0,0)");

        // Verifying the videoscard was getting duplicating using the unique videos Url

        String[] videoscard = {"https://www.youtube.com/embed/WesnnBbVMNs", "https://www.youtube.com/embed/I6jckmkU90w", "https://www.youtube.com/embed/66dm-vf3Yew", "https://www.youtube.com/embed/2YF_wwrUFBU"
                , "https://www.youtube.com/embed/tzWTqG6AjgA", "https://www.youtube.com/embed/BVxZTcXCQ1w", "https://www.youtube.com/embed/hCG1fxWsiIs", "https://www.youtube.com/embed/nXFDs9-d98k"
                , "https://www.youtube.com/embed/0w6kk-NvtaM", "https://www.youtube.com/embed/Eqt0azCKCmY", "https://www.youtube.com/embed/MrScTfvFVDk", "https://www.youtube.com/embed/yX5tOeyGMpE",
                "https://www.youtube.com/embed/B4x0o3Xxh0I", "https://www.youtube.com/embed/aZlCCjH224I", "https://www.youtube.com/embed/TmLHK6yZ_1U", "https://www.youtube.com/embed/7HoLC0bouZM", "https://www.youtube.com/embed/5kDFVNrB_uE", "https://www.youtube.com/embed/l_U14N2OZ3Y"
                , "https://www.youtube.com/embed/yQyqSFvhV6E", "https://www.youtube.com/embed/sSisSX7mRTs", "https://www.youtube.com/embed/j9gCpOpSd5c", "https://www.youtube.com/embed/uD8COFsPXI4",
                "https://www.youtube.com/embed/ksytSb7-QKI", "https://www.youtube.com/embed/Mh1v2nPnXEw", "https://www.youtube.com/embed/xgSncNI1uMU", "https://www.youtube.com/embed/e4TWEFT-eR0"
                , "https://www.youtube.com/embed/iBxsIZ2jyog", "https://www.youtube.com/embed/x94bd9BOZhA", "https://www.youtube.com/embed/3Edf_H2aKD8", "https://www.youtube.com/embed/7mB3UecOb-Y"};

        List<WebElement> cards = driver.findElements (xpath ("//*[@class=\"video-iframe\"]"));

        Set<String> uniqueUrls = new HashSet<> ();
        int uniqueCount = 0;

        for (WebElement card : cards) {
            String actualUrl = card.getAttribute ("src");

            if (uniqueUrls.contains (actualUrl)) {
                System.out.println ("Duplicate found --> " + actualUrl);
            } else {
                uniqueUrls.add (actualUrl);
                if (Arrays.asList (videoscard).contains (actualUrl)) {
                    uniqueCount++;
                    System.out.println ("Found: " + uniqueCount + "-->" + actualUrl);
                }
            }
        }

        System.out.println ("Total unique videos url found: " + uniqueCount);
        Assert.assertEquals (uniqueCount, videoscard.length);
    }

}

package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40));
        WebElement clickingViewButton = wait.until (ExpectedConditions.elementToBeClickable (xpath ("//*[text()='VIEW >']")));
        wait.until (ExpectedConditions.visibilityOf (clickingViewButton));
        clickingViewButton.click ();
        System.out.println ("Sucessfully Video playing");

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

//        // Clicking the Full screen Button
//
//        Thread.sleep (3000);
//        WebElement clickingFullScreenButton = driver.findElement (xpath ("//*[@aria-label=\"Full screen keyboard shortcut f\"]"));
//        clickingFullScreenButton.click ();
//        System.out.println ("SucessFully Clicked The Full Screen Button");

        // Clicking the YouTube Logo It will navigate to YouTube or new windows

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


    }
}

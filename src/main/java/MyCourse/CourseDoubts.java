package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CourseDoubts {
    WebDriver driver;

    public CourseDoubts(WebDriver driver) {

        this.driver = driver;
    }

    public void Doubts() throws InterruptedException, AWTException {

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The First Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[1]"));
        clickingFirstCourseCard.click ();

        // Clicking the Doubts Tab

        WebElement clickingDoubts = driver.findElement (id ("rc-tabs-0-tab-8"));
        clickingDoubts.click ();

        // Clicking the Follow Icon

        WebElement clickingFollowicon = driver.findElement (xpath ("//*[@alt=\"follow\"]"));
        clickingFollowicon.click ();
        System.out.println ("Successfully clicked like");


        // Clicking the Answer Icon

        WebElement clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();

        // Entering the text

        WebElement Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");

        // Clicking the upload Buttton

        WebElement clickingupload = driver.findElement (xpath ("//*[@alt=\"upload\"]"));
        clickingupload.click ();

        // Uploading Image in the Comment text field

        Thread.sleep (3000);
        String file = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled155.png";
        StringSelection selection = new StringSelection (file);
        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents (selection, null);
        System.out.println ("Sucessfully Uploaded The Image");

        // Pressing the keyboard button

        Robot robot = new Robot ();

        //Pressing The Key

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_CONTROL);
        robot.keyPress (KeyEvent.VK_V);

        // Releasing the Key

        Thread.sleep (3000);
        robot.keyRelease (KeyEvent.VK_V);
        robot.keyRelease (KeyEvent.VK_CONTROL);

        // Clicking The Enter Key

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releasing The Enter Key

        Thread.sleep (3000);
        robot.keyRelease (KeyEvent.VK_ENTER);

//        // Clicking the Send button
//
//        Thread.sleep (3000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendbutton.click ();




    }


}

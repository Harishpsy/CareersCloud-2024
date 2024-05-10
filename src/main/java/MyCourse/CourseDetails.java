package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class CourseDetails {
    WebDriver driver;

    public CourseDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void Details() throws InterruptedException, AWTException {

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The First Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[1]"));
        clickingFirstCourseCard.click ();

        // Clicking the Details Tab

        WebElement clickingDetails = driver.findElement (xpath ("//*[text()='Details']"));
        clickingDetails.click ();

        // Clicking The Email Icon

        WebElement clickingEmailIcon = driver.findElement (xpath ("(//*[@class=\"icon\"])[1]"));
        clickingEmailIcon.click ();

        // Entering the text in the text field

        WebElement clickingtextfield = driver.findElement (name ("queries"));
        clickingtextfield.sendKeys ("Thanks for your  Information");

        // Clicking Upload button

        WebElement clickinguploadbutton = driver.findElement (xpath ("//*[text()='Upload']"));
        clickinguploadbutton.click ();

//      Uploading the image

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

        // Clicking the Send Button

//        Thread.sleep (6000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[text()='Send']"));
//        clickingSendButton.click ();

        // Clicking The close icon in the popup

        Thread.sleep (6000);
        WebElement clickingCloseicon = driver.findElement (xpath ("//*[@class=\"ant-modal-close\"]"));
        clickingCloseicon.click ();
        System.out.println ("Sucessfully Clicked Cancel Icon");

//        // Clicking The Contact Icon
//
//        WebElement clickingContactIcon = driver.findElement (xpath ("(//*[@class=\"icon\"])[2]"));
//        clickingContactIcon.click ();
//
//        // Clicking The close icon in the popup
//
//        Thread.sleep (3000);
//        clickingCloseicon = driver.findElement (xpath ("//*[@class=\"ant-modal-close\"]"));
//        clickingCloseicon.click ();
//
//        // Clicking The Contact Icon
//
//        WebElement clickingChatIcon = driver.findElement (xpath ("(//*[@class=\"icon\"])[3]"));
//        clickingChatIcon.click ();
//
//        // Windows Handeling
//
//        Set<String> windows = driver.getWindowHandles ();
//        Iterator<String> it = windows.iterator ();
//        String parent = it.next ();
//        String child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Maximixe The Windows
//
//        driver.manage ().window ().maximize ();
//
//        //
//        driver.close ();
//
//        driver.switchTo ().window (parent);
//
//        // Clicking The Contact Icon
//
//        clickingChatIcon = driver.findElement (xpath ("(//*[@class=\"icon\"])[3]"));
//        clickingChatIcon.click ();
//
//        // Windows Handeling
//
//        windows = driver.getWindowHandles ();
//        it = windows.iterator ();
//        parent = it.next ();
//        child = it.next ();
//        driver.switchTo ().window (child);
//
//        // Maximixe The Windows
//
//        driver.manage ().window ().maximize ();
//
//
//        // Clicking the user profile in the whatsapp
//
//        Thread.sleep (60000);
//        WebElement clickingProfile = driver.findElement (xpath ("(//*[@class=\"_ak72 _ak73 _ak75\"])[4]"));
//        clickingProfile.click ();
//        System.out.println ("Sucessfully Logined The Whatsapp");
//
//
//        // Clicking the clicking send icon in the whatsapp
//
//        Thread.sleep (3000);
//        WebElement clickingsendicon = driver.findElement (xpath ("//*[@data-icon=\"send\"]"));
//        clickingsendicon.click ();
//
//        // Clicking the clicking send icon inside the whatsapp
//
//        Thread.sleep (3000);
//        clickingsendicon = driver.findElement (xpath ("//*[@data-icon=\"send\"]"));
//        clickingsendicon.click ();
//


    }
}

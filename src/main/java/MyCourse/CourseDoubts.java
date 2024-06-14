package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.openqa.selenium.By.*;

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

//        // Clicking the Follow Icon
//
//        WebElement clickingFollowicon = driver.findElement (xpath ("//*[@alt=\"follow\"]"));
//        clickingFollowicon.click ();
//        System.out.println ("Successfully clicked Follow");
//
//
//        // Clicking the Answer Icon
//
//        WebElement clickingAnswericon = driver.findElement (id ("comments-icon"));
//        clickingAnswericon.click ();
//
//        // Entering the text
//
//        WebElement Enteringtext = driver.findElement (id ("teatx-area-id"));
//        Enteringtext.sendKeys ("Thanks");
//
//        // Clicking the upload Buttton
//
//        WebElement clickingupload = driver.findElement (xpath ("//*[@alt=\"upload\"]"));
//        clickingupload.click ();
//
//        // Uploading Image in the Comment text field
//
//        Thread.sleep (3000);
//        String file = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png\"";
//        StringSelection selection = new StringSelection (file);
//        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents (selection, null);
//        System.out.println ("Sucessfully Uploaded The Image");
//
//        // Pressing the keyboard button
//
//        Robot robot = new Robot ();
//
//        //Pressing The Key
//
//        Thread.sleep (3000);
//        robot.keyPress (KeyEvent.VK_CONTROL);
//        robot.keyPress (KeyEvent.VK_V);
//
//        // Releasing the Key
//
//        Thread.sleep (3000);
//        robot.keyRelease (KeyEvent.VK_V);
//        robot.keyRelease (KeyEvent.VK_CONTROL);
//
//        // Clicking The Enter Key
//
//        Thread.sleep (3000);
//        robot.keyPress (KeyEvent.VK_ENTER);
//
//        // Releasing The Enter Key
//
//        Thread.sleep (3000);
//        robot.keyRelease (KeyEvent.VK_ENTER);
//
//        // Clicking the Send button
//
//        Thread.sleep (3000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendbutton.click ();
//
//        // Clicking The share Icon
//
//        Thread.sleep (3000);
//        WebElement clickingshareicon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
//        clickingshareicon.click ();
//
//        //click the copy link in the share popup
//
//        Thread.sleep (3000);
//        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
//        Copy_link.click ();
//
//        //Clicking the cancel button in the in share popup
//
//        Thread.sleep (3000);
//        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
//        Cancel_button.click ();
//
//        // Clicking The three Dots in the doubts
//
//        Thread.sleep (3000);
//        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"doubts-Menu\"]"));
//        clickingThreeDots.click ();
//
//        // Clicking The report Icon in the dropdown
//
//        Thread.sleep (3000);
//        WebElement clickingReport = driver.findElement (xpath ("//*[text()='Report']"));
//        clickingReport.click ();
//
//        //Click the wrong information radio button
//
//        Thread.sleep (3000);
//        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
//        Wrong_information_radio_button.click ();
//
//        //Entering the text inside the report text field
//
//        Thread.sleep (3000);
//        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
//        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");
//
//        // Click the report button
//
//        Thread.sleep (3000);
//        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();
//
////        // Clicking The Cancel Button
////
////        Thread.sleep (5000);
////        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
////        Cancel_button.click ();

        // Clicking The Create Button

        Thread.sleep (3000);
        WebElement clickingCreate = driver.findElement (xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary add-doubts-btn\"]"));
        clickingCreate.click ();

        // Entering the text inside the create doubt text field

        Thread.sleep (3000);
        WebElement enteringtext = driver.findElement (xpath ("(//*[@class=\"ant-input css-xu9wm8\"])"));
        enteringtext.sendKeys ("Where The Course Is Present ?...");

        // Clicking the upload Buttton

        Thread.sleep (3000);
        WebElement clickingupload = driver.findElement (xpath ("//*[@alt=\"image_upload\"]"));
        clickingupload.click ();

        // Uploading Image in the Comment text field

        Thread.sleep (3000);
        String file = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png\"";
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

        // Clicking the Send button
//
//        Thread.sleep (10000);
//         WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendbutton.click ();
//        System.out.println ("Sucessfully Doubt Uploaded");

        // Clicking The Close Icon

        WebElement clickingCloseIcon = driver.findElement (xpath ("//*[@alt=\"Close\"]"));
        clickingCloseIcon.click ();

        // Clicking the My Doubts

        Thread.sleep (3000);
        WebElement clickingMydoubts = driver.findElement (xpath ("//*[text()='My Doubts']"));
        clickingMydoubts.click ();


        // Clicking the Answer Icon

        WebElement clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();

        // Entering the text

        WebElement Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");

        // Clicking the Send button

        Thread.sleep (3000);
        WebElement clickingSendbutton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendbutton.click ();

        // Clicking the Reply button

        WebElement clickingReplyButton = driver.findElement (xpath ("//*[text()=' Reply']"));
        clickingReplyButton.click ();

        // Entering the text in reply text field

        WebElement enteringText = driver.findElement (id ("reply_text"));
        enteringText.sendKeys ("Thanks For the answer   ");

        // Clicking the send button

        WebElement clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendButton.click ();

        // Clicking The Like Button

        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@alt=\"liked\"]"));
        clickingLikeButton.click ();


//        // Clicking The Mark As Best Answer
//
//        Thread.sleep (3000);
//        WebElement clickBestAnswer = driver.findElement (xpath ("//*[@alt=\"award\"]"));
//        clickBestAnswer.click ();
//
//        // Clicking The Close Icon
//
//        Thread.sleep (3000);
//        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"doubt-answer-btn\"]"));
//        clickingCloseIcon.click ();
//
//        // Clicking the Answer Icon
//
//        clickingAnswericon = driver.findElement (id ("comments-icon"));
//        clickingAnswericon.click ();

//        // Clicking The undo Button
//
//        Thread.sleep (3000);
//        WebElement clickUndo = driver.findElement (xpath ("//*[@alt=\"doubts_undo\"]"));
//        clickUndo.click ();

        // Clicking The Close Icon

        Thread.sleep (5000);
        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"doubt-answer-btn\"]"));
        clickingCloseIcon.click ();

        // CLicking The My Answered Tab

        Thread.sleep (5000);
        WebElement clickingMyAnswered = driver.findElement (xpath ("//*[text()=\"My Answered\"]"));
        clickingMyAnswered.click ();

        // Clicking the Follow Icon

        Thread.sleep (5000);
        WebElement clickingFollowicon = driver.findElement (xpath ("(//*[@alt=\"follow\"])[1]"));
        clickingFollowicon.click ();
        System.out.println ("Successfully clicked Follow");

        // Clicking the Answer Icon

        Thread.sleep (5000);
        clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();


        // Entering the text

        Thread.sleep (5000);
        Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");


        // Clicking the send button

        Thread.sleep (5000);
        clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendButton.click ();

        // Clicking the Reply button

        Thread.sleep (5000);
        clickingReplyButton = driver.findElement (xpath ("//*[text()=' Reply']"));
        clickingReplyButton.click ();


        // Entering the text in reply text field

        enteringText = driver.findElement (id ("reply_text"));
        enteringText.sendKeys ("Thanks For the answer");


        // Clicking the send button

        Thread.sleep (5000);
        clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendButton.click ();


        // Clicking The Like Button

        Thread.sleep (5000);
        clickingLikeButton = driver.findElement (xpath ("//*[@alt=\"liked\"]"));
        clickingLikeButton.click ();


        // Clicking The Close Icon

        Thread.sleep (5000);
        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"doubt-answer-btn\"]"));
        clickingCloseIcon.click ();
        System.out.println ("Close Icon");

        // Clicking The share Icon

        Thread.sleep (5000);
        WebElement clickingshareicon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (5000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        Thread.sleep (5000);
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Clicking The Followed

        Thread.sleep (5000);
        WebElement clickingFollowedTab = driver.findElement (xpath ("//span[text()='Followed']"));
        clickingFollowedTab.click ();

        // Clicking the Answer Icon

        Thread.sleep (5000);
        clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();


        // Entering the text

        Thread.sleep (5000);
        Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");


        // Clicking the send button

        Thread.sleep (5000);
        clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendButton.click ();

        // Clicking the Reply button

        Thread.sleep (5000);
        clickingReplyButton = driver.findElement (xpath ("//*[text()=' Reply']"));
        clickingReplyButton.click ();


        // Entering the text in reply text field

        enteringText = driver.findElement (id ("reply_text"));
        enteringText.sendKeys ("Thanks For the answer");


        // Clicking the send button

        Thread.sleep (5000);
        clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
        clickingSendButton.click ();


        // Clicking The Like Button

        Thread.sleep (5000);
        clickingLikeButton = driver.findElement (xpath ("//*[@alt=\"liked\"]"));
        clickingLikeButton.click ();


        // Clicking The Close Icon

        Thread.sleep (5000);
        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"doubt-answer-btn\"]"));
        clickingCloseIcon.click ();
        System.out.println ("Close Icon");

        // Clicking The share Icon

        Thread.sleep (5000);
        clickingshareicon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (5000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        Thread.sleep (5000);
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Clicking The three Dots in the doubts

        Thread.sleep (3000);
        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"doubts-Menu\"]"));
        clickingThreeDots.click ();

        // Clicking The report Icon in the dropdown

        Thread.sleep (3000);
        WebElement clickingReport = driver.findElement (xpath ("//*[text()='Report']"));
        clickingReport.click ();

        //Click the wrong information radio button

        Thread.sleep (3000);
        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        Thread.sleep (3000);
        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

//        // Clicking The Cancel Button
//
//        Thread.sleep (5000);
//        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
//        Cancel_button.click ();

        // Click the breadcrums in the course list page

        Thread.sleep (5000);
        WebElement clickingBreadCrums = driver.findElement (xpath ("//*[text()='Course']"));
        clickingBreadCrums.click ();









    }

}

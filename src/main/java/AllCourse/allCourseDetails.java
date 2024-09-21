package AllCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class allCourseDetails {
    WebDriver driver;

    public allCourseDetails(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void details() throws InterruptedException, AWTException {

        //Using The try, catch method to identify whether the details tab was present or not or else already clicked of not
        boolean detailsPageSelected = false;
        boolean detailsPageDisplayed = false;

        try {
            WebElement clickingDetails = driver.findElement ( By.xpath ( "//*[text()='Details']" ) );
            detailsPageSelected = clickingDetails.isSelected ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Detail Page Was Not Displayed In The List Page" );
        }

        try {
            WebElement clickingDetails = driver.findElement ( By.xpath ( "//*[text()='Details']" ) );
            detailsPageSelected = clickingDetails.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Detail Page Was Not Displayed In The List Page" );
        }

        //Log the visibility status of each element
        System.out.println ( "Subscribe Now Button Is Displayed: " + detailsPageSelected );

        //Performing The Action In The Details Page
        if (detailsPageSelected) {
            System.out.println ( "Detail Page Is Already Selected, So Performing The Below Actions " );
        } else if (detailsPageDisplayed) {
            Thread.sleep ( 3000 );
            WebElement clickingDetails = driver.findElement ( By.xpath ( "//*[text()='Details']" ) );
            clickingDetails.click ();
            System.out.println ( "Detail Page Is Clicked Successfully" );
        } else {
            System.out.println ( "Details Page Is Not Displayed In The Course List Page,So We Are Skipping And Move To Next Module" );
        }

        // Creating The Object For The Support > Email
        allCourseDetails email = new allCourseDetails ( driver );
        email.emialIcon ();

        // Creating The Object For The Support > phone
        allCourseDetails phone = new allCourseDetails ( driver );
        phone.phoneIcon ();

        //Creating The Object For The Support > WhatsApp Chat
        allCourseDetails whatappchat = new allCourseDetails ( driver );
        whatappchat.whatsAppChat ();

    }

    @Test
    public void emialIcon() throws InterruptedException, AWTException {

        //Checking The Email Icon Is Displaying Or Not, If it displayed Performing The Actions, If It is Not Displayed Skipping The Action
        boolean emailIconDisplayed = false;

        //We're Using try,catch method to check that the email icon is Present or Not In The Detail Page
        try {
            WebElement clickingEmailIcon = driver.findElement ( By.xpath ( "//*[@src=\"/static/media/email.f798934d5591653bcab2b2671290cdad.svg\"]" ) );
            emailIconDisplayed = clickingEmailIcon.isDisplayed ();

        } catch (NoSuchElementException e) {
            System.out.println ( "Email Icon Is Not Present In The Detail Page " );
        }

        // Printing The Log
        System.out.println ( "Email Icon Is Present: " + emailIconDisplayed );

        if (emailIconDisplayed) {
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
            WebElement clickingEmailIcon = driver.findElement ( By.xpath ( "//*[@src=\"/static/media/email.f798934d5591653bcab2b2671290cdad.svg\"]" ) );
            clickingEmailIcon.click ();

            // Entering the text in the text field
            WebElement clickingtextfield = driver.findElement ( name ( "queries" ) );
            clickingtextfield.sendKeys ( "Thanks for your  Information" );

            // Clicking Upload button
            WebElement clickinguploadbutton = driver.findElement ( xpath ( "//*[text()='Upload']" ) );
            clickinguploadbutton.click ();

            // Uploading the image
            Thread.sleep ( 3000 );
            String file = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled155.png";
            StringSelection selection = new StringSelection ( file );
            Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents ( selection , null );
            System.out.println ( "Sucessfully Uploaded The Image" );

            // Pressing the keyboard button
            Robot robot = new Robot ();

            //Pressing The Key
            Thread.sleep ( 3000 );
            robot.keyPress ( KeyEvent.VK_CONTROL );
            robot.keyPress ( KeyEvent.VK_V );

            // Releasing the Key
            Thread.sleep ( 3000 );
            robot.keyRelease ( KeyEvent.VK_V );
            robot.keyRelease ( KeyEvent.VK_CONTROL );

            // Clicking The Enter Key
            Thread.sleep ( 3000 );
            robot.keyPress ( KeyEvent.VK_ENTER );

            // Releasing The Enter Key
            Thread.sleep ( 3000 );
            robot.keyRelease ( KeyEvent.VK_ENTER );

            // Clicking the Send Button
//         Thread.sleep (6000);
//         WebElement clickingSendButton = driver.findElement (xpath ("//*[text()='Send']"));
//         clickingSendButton.click ();

            // Clicking The close icon in the popup
            Thread.sleep ( 6000 );
            WebElement clickingCloseicon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close\"]" ) );
            clickingCloseicon.click ();
            System.out.println ( "Sucessfully Clicked Cancel Icon" );

        } else {
            System.out.println ( "Email Icon Is Not Displayed, So We Looking Next Action In The Detail Page" );
        }
    }

    @Test
    public void phoneIcon() throws InterruptedException {

        //Checking The Email Icon Is Displaying Or Not, If it displayed Performing The Actions, If It is Not Displayed Skipping The Action
        boolean phoneIconDisplayed = false;

        //We're Using try,catch method to check that the email icon is Present or Not In The Detail Page
        try {
            WebElement clickingPhoneIcon = driver.findElement ( xpath ( "//*[@src=\"/static/media/phone-voice.499d15994eb8b4704d97a5de16bc4cd4.svg\"]" ) );
            phoneIconDisplayed = clickingPhoneIcon.isDisplayed ();

        } catch (NoSuchElementException e) {
            System.out.println ( "Email Icon Is Not Present In The Detail Page " );
        }

        // Printing The Log
        System.out.println ( "Phone Icon Is Displayed: " + phoneIconDisplayed );

        if (phoneIconDisplayed) {

            // Clicking The Phone Icon
            Thread.sleep ( 3000 );
            WebElement clickingPhoneIcon = driver.findElement ( xpath ( "//*[@src=\"/static/media/phone-voice.499d15994eb8b4704d97a5de16bc4cd4.svg\"]" ) );
            clickingPhoneIcon.click ();
            System.out.println ( "Successfully Clicked The Phone Icon" );

            // Clicking The Close Icon In The Call Support Popup
            WebElement clickingClose = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-close-circle\"]" ) );
            clickingClose.click ();
            System.out.println ( "SuccessFully Clicked The Close Icon " );

        } else {
            System.out.println ( "Phone Icon Is Not Displayed In The Details Page" );
        }
    }

    @Test
    public void whatsAppChat() throws InterruptedException {

        //Checking The WhatsApp Chat Icon Is Displaying Or Not If it displayed Performing The Actions, If It is Not Displayed Skipping The Action
        boolean whatsappChatIconDisplayed = false;

        //We're Using try,catch method to check that the email icon is Present or Not In The Detail Page
        try {
            WebElement clickingWhatsappChat = driver.findElement ( xpath ( "//*[@src=\"/static/media/chat.216be488af93fc69d54ce1b02de52596.svg\"]" ) );
            whatsappChatIconDisplayed = clickingWhatsappChat.isDisplayed ();

        } catch (NoSuchElementException e) {
            System.out.println ( "Email Icon Is Not Present In The Detail Page " );
        }

        // Printing The Log
        System.out.println ( "Phone Icon Is Displayed: " + whatsappChatIconDisplayed );

        if (whatsappChatIconDisplayed) {

            // Clicking The WhatsApp Chat Icon
            Thread.sleep ( 3000 );
            WebElement clickingWhatsappChat = driver.findElement ( xpath ( "//*[@src=\"/static/media/chat.216be488af93fc69d54ce1b02de52596.svg\"]" ) );
            clickingWhatsappChat.click ();

            // Windows Handeling Switching To The Child Tab
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );

            // Closing The WhatsApp Chat Window
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
//            Thread.sleep ( 5000 );
            driver.close ();

            // Wnidows Handeing Switching To Parent Tab
            windows = driver.getWindowHandles ();
            it = windows.iterator ();
            parent = it.next ();
            child = it.next ();
            driver.switchTo ().window ( parent );

        } else {
            System.out.println ( "whatsapp Chat Icon was Not Displayed In The Detail Page" );
        }
    }


}

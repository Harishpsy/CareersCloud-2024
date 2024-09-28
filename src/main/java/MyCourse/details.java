package MyCourse;

import AllCourse.detailsTab;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class details {
    WebDriver driver;

    public details(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void details() throws InterruptedException, AWTException {
        try {
            WebElement clickingDetails = driver.findElement ( By.xpath ( "//*[text()='Details']" ) );

            // Check if the "Details" tab is already selected
            if (clickingDetails.isSelected ()) {
                System.out.println ( "Details Page is already selected, proceeding with the actions." );
            }
            // Check if the "Details" tab is displayed but not selected
            else if (clickingDetails.isDisplayed ()) {
                System.out.println ( "Details Page is displayed, clicking to select it." );
                clickingDetails.click ();
                System.out.println ( "Successfully clicked the Details page." );
            }
        } catch (NoSuchElementException e) {
            // Handle a case when the "Details" tab is not found
            System.out.println ( "Details Page is not found in the Course List, skipping to the next module." );
        }


        // Creating The Object For The Support > Email
        detailsTab email = new detailsTab ( driver );
        email.emialIcon ();

        // Creating The Object For The Support > phone
        detailsTab phone = new detailsTab ( driver );
        phone.phoneIcon ();

        //Creating The Object For The Support > WhatsApp Chat
        detailsTab whatappchat = new detailsTab ( driver );
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
            String file = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Pic1.jpg";
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

        try {
            WebElement clickingPhoneIcon = driver.findElement ( By.xpath ( "//*[@src=\"/static/media/phone-voice.499d15994eb8b4704d97a5de16bc4cd4.svg\"]" ) );
            phoneIconDisplayed = clickingPhoneIcon.isDisplayed ();

            if (phoneIconDisplayed) {
                clickingPhoneIcon.click ();
                System.out.println ( "Successfully Clicked The Phone Icon" );

                // Using explicit wait to find and click the close icon
                WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
                WebElement closeIcon = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//*[@class=\"ant-modal-close-x\"]" ) ) );
                closeIcon.click ();
                System.out.println ( "Successfully Clicked The Close Icon" );
            } else {
                System.out.println ( "Phone Icon Is Not Displayed In the Details Page" );
            }

        } catch (NoSuchElementException e) {
            System.out.println ( "Phone Icon Is Not Present In the Detail Page" );
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
            System.out.println ( "Successfully Clicked The Whatsapp Chat icon" );

            //Windows Handeling child to parent
            Thread.sleep ( 5000 );
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );
            Thread.sleep ( 3000 );
            driver.close ();
            driver.switchTo ().window ( parent );

        } else {
            System.out.println ( "whatsapp Chat Icon was Not Displayed In The Detail Page" );
        }
    }
}

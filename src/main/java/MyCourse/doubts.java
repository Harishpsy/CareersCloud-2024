package MyCourse;

import Base.General.CoreFunctionality;
import Doubts.MyAnswered;
import Doubts.Mydoubts;
import Doubts.Myfollowed;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class doubts {
    WebDriver driver;

    public doubts(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void doubtbase() throws InterruptedException, AWTException {

        try {
            // Verifying The Doubts' Sub-Module Was Displaying, if Display Perform The Below Action
            Thread.sleep(3000);
            boolean doubtsModuleDisplayed = false;

            try {
                Thread.sleep(5000);
                WebElement clickingDoubts = driver.findElement ( xpath ( "(//*[text()='Doubts'])[2]" ) );
                doubtsModuleDisplayed = clickingDoubts.isDisplayed ();
                clickingDoubts.click();
            } catch (NoSuchElementException e) {
                System.out.println ( "Doubts Sub Module Is Not Displayed" );
            }

            System.out.println ( "Doubt Sub Module Displayed In The Current Course: " + doubtsModuleDisplayed );

            doubts doubt = new doubts ( driver );
            doubt.allDoubts ();

            //Creating an object for an my doubts, and performing The Actions
            //My Doubts
            Mydoubts myDoubts = new Mydoubts ( driver );
            myDoubts.myDoubts ();

            //My Answered
            MyAnswered answered = new MyAnswered ( driver );
            answered.myAnswered ();

            // My Followed
            Myfollowed myFollowed = new Myfollowed ( driver );
            myFollowed.myFollow ();

        } catch (NoSuchElementException e) {
            System.out.println ( "Doubt Sub Tab Was Not Present" );
        }
    }

    @Test
    public void allDoubts() throws InterruptedException, AWTException {

        try {

            // Storing The Web Element
            WebElement clickingAllDoubts = driver.findElement ( xpath ( "//*[@class=\"ant-radio-button ant-radio-button-checked\"]" ) );

            // Using If else statement to handle
            if (clickingAllDoubts.isDisplayed ()) {
                System.out.println ( "All Doubt Has Displayed SuccessFully,And Performing The Below action In The List Page" );

                // Scrolling the doubt page
                // Scrolling The Quizzes List Page to verify data
                CoreFunctionality scroll = new CoreFunctionality ( driver );
                scroll.Scroll ();

                // Clicking Float Icon
                CoreFunctionality floatbutton = new CoreFunctionality ( driver );
                floatbutton.floatButton ();

                try {
                    /* Clicking the image in the doubt if the image is not there then skip it */
                    Thread.sleep ( 5000 );
                    WebElement clickingDoubtImage = driver.findElement ( xpath ( "(//*[@class=\"ant-image-mask\"])[1]" ) );

                    // Check if the element is found before clicking
                    if (clickingDoubtImage != null) {
                        clickingDoubtImage.click ();
                        System.out.println ( "Successfully click the Doubt Image " );

                        // Clicking The Flip Button in the Y axis
                        Thread.sleep ( 5000 );
                        WebElement clickingFlipButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-flipY\"]" ) );
                        clickingFlipButton.click ();

                        // Clicking The Flip Button in the X axis
                        Thread.sleep ( 5000 );
                        WebElement clickingFlipButtonXAxis = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-flipX\"]" ) );
                        clickingFlipButtonXAxis.click ();

                        // Clicking The Rotated Left Button In Doubt Image
                        Thread.sleep ( 5000 );
                        WebElement clickingRotateLeftButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-rotateLeft\"]" ) );
                        clickingRotateLeftButton.click ();

                        // Clicking The Rotated Right Button In Doubt Image
                        Thread.sleep ( 5000 );
                        WebElement clickingRotateRightButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-rotateRight\"]" ) );
                        clickingRotateRightButton.click ();

                        // Clicking The ZoomIn Button
                        Thread.sleep ( 5000 );
                        WebElement clickingZoomInButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-zoomIn\"]" ) );
                        clickingZoomInButton.click ();

                        // Click The Zoom Out Button
                        Thread.sleep ( 5000 );
                        WebElement clickingZoomOutButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-zoomOut\"]" ) );
                        clickingZoomOutButton.click ();

                        // Clicking The Cancel Button
                        Thread.sleep ( 3000 );
                        WebElement clickingTheCancelButton = driver.findElement ( xpath ( "//button[@class=\"ant-image-preview-close\"]" ) );
                        clickingTheCancelButton.click ();

                    } else {
                        System.out.println ( "Doubt Image not found." );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Image Is Not Present" );
                }

                // Wait for the page to load completely
                Thread.sleep ( 5000 );

                // Find all elements with the specified class
                java.util.List<WebElement> allDoubtImageURL = driver.findElements ( xpath ( "//*[@class='ant-image-img css-xu9wm8']" ) );

                //Create a set to store unique URLs
                Set<String> uniqueDoubtUrls = new HashSet<> ();
                int uniqueDoubtUrlCount = 0;

                // Iterate through the list of elements
                for (WebElement doubtUrlElement : allDoubtImageURL) {
                    String actualDoubtImageUrl = doubtUrlElement.getAttribute ( "src" );
//                System.out.println ( "Original Doubt Image In The List: " + actualDoubtImageUrl );

                    if (uniqueDoubtUrls.contains ( actualDoubtImageUrl )) {
                        System.out.println ( "Duplicate found --> " + actualDoubtImageUrl );
                    } else {
                        uniqueDoubtUrls.add ( actualDoubtImageUrl );
                        uniqueDoubtUrlCount++;
//                System.out.println ( "Found: " + uniqueDoubtUrlCount + " --> " + actualDoubtImageUrl );
//                System.out.println ( "-------------------------------------------------------------------------" );
                    }
                }

                // Print the total number of unique URLs found
                System.out.println ( "Total unique image URLs found: " + uniqueDoubtUrlCount );

                // Assert that the number of unique URLs is equal to the number of elements
                Assert.assertEquals ( uniqueDoubtUrlCount , uniqueDoubtUrls.size () );

                // Clicking the Follow Icon
                Thread.sleep ( 3000 );
                WebElement followIcon = driver.findElement ( xpath ( "//*[@alt=\"follow\"]" ) );
                WebElement unfollowIcon = driver.findElement ( xpath ( "//*[@alt=\"follow\"]" ) );

                if (followIcon != null) {
                    followIcon.click ();
                    System.out.println ( "Successfully clicked Follow" );
                } else if (unfollowIcon != null) {
                    unfollowIcon.click ();
                    System.out.println ( "Successfully clicked Unfollow" );
                } else {
                    System.out.println ( "Could not find follow or unfollow icon element." );
                }

                // Clicking the Answer Icon
                WebElement clickingAnswericon = driver.findElement ( id ( "comments-icon" ) );
                clickingAnswericon.click ();
                System.out.println ( "Successfully Clicked The Answer Icon" );
                try {
                    WebElement Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
                    if (Enteringtext.isDisplayed ()) {

                        // Entering the text
                        Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
                        Enteringtext.sendKeys ( "Thanks" );
                        System.out.println ( "Successfully Entered The Text" );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Text Field Is Not Displayed " );
                }

//        // Clicking the upload Buttton
//        Thread.sleep ( 5000 );
//        WebElement clickingupload = driver.findElement ( xpath ( "//*[@alt=\"upload\"]" ) );
//        clickingupload.click ();
//
//        try {
//            // Locate the file input element (adjust the locator to match your file input element)
//            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//
//            // Specify the file path you want to upload (without extra quotes)
//            String filePath = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Pic1.jpg";
//
//            // Upload the file by sending the file path to the input field
//            fileInput.sendKeys(filePath);
//
//            // Log success message
//            System.out.println("Image successfully uploaded.");
//
//        } catch (NoSuchElementException e) {
//            System.out.println("File input element not found: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("An error occurred during the image upload: " + e.getMessage());
//        }

//        try {
//            // Short delay to ensure the comment text field is ready
//            Thread.sleep(2000);
//
//            // Define the file path and copy it to the clipboard
//            String filePath = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png";
//            StringSelection selection = new StringSelection(filePath);
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//            System.out.println("File path copied to clipboard successfully.");
//
//            // Initialize Robot instance for keyboard actions
//            Robot robot = new Robot();
//
//            // Small delay before performing keyboard actions
//            Thread.sleep(1000);
//
//            // Simulate CTRL + V to paste the file path
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//
//            // Brief pause before pressing ENTER
//            Thread.sleep(500);
//
//            // Press and release ENTER to confirm upload
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//            System.out.println("Image uploaded successfully.");
//
//        } catch (Exception e) {
//            System.out.println("An error occurred during the image upload: " + e.getMessage());
//        }

//        // Clicking the Send button
//        Thread.sleep ( 3000 );
//        WebElement clickingSendbutton = driver.findElement ( xpath ( "//*[@alt=\"send_doubts\"]" ) );
//        clickingSendbutton.click ();
//        System.out.println ("Successfully Clicked The Send Button ");

                // Clicking The cancel Icon
                Thread.sleep ( 5000 );
//          WebElement clickingCancelIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
                WebElement clickingCancelIcon = driver.findElement ( xpath ( "//*[@alt=\"Close\"]" ) );
                clickingCancelIcon.click ();

                // Clicking The share Icon
                Thread.sleep ( 3000 );
                WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
                clickingshareicon.click ();

                //click the copy link in the share popup
                Thread.sleep ( 3000 );
                WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup
                Thread.sleep ( 3000 );
                WebElement Cancel_button = driver.findElement ( xpath ( "(//*[text() = 'Cancel'])[2]" ) );
                Cancel_button.click ();

                // Clicking The three Dots in the doubts
                Thread.sleep ( 3000 );
                WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"doubts-Menu\"]" ) );
                clickingThreeDots.click ();

                // Clicking The report Icon in the dropdown
                Thread.sleep ( 3000 );
                WebElement clickingReport = driver.findElement ( xpath ( "(//*[text()='Report'])[3]" ) );
                clickingReport.click ();

//        //Click the wrong information radio button
//        Thread.sleep ( 3000 );
//        WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "(//*[text()='Wrong Information'])[2]" ) );
//        Wrong_information_radio_button.click ();

                //Entering the text inside the report text field
                Thread.sleep ( 3000 );
                WebElement Enter_the_report = driver.findElement ( xpath ( "(//*[@name=\"reportDescription\"])[2]" ) );
                Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

//        // Click the report button
//        Thread.sleep ( 3000 );
//        WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
//        Report_button.click ();

                // Clicking The Cancel Button
                Thread.sleep ( 5000 );
                Cancel_button = driver.findElement ( xpath ( "(//span[text()='CANCEL'])[2]" ) );
                Cancel_button.click ();

                // Clicking The Create Button
                Thread.sleep ( 3000 );
                WebElement clickingCreate = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary add-doubts-btn\"]" ) );
                clickingCreate.click ();

                // Entering the text inside the create doubt text field
                Thread.sleep ( 5000 );
                WebElement enteringtext = driver.findElement ( xpath ( "(//*[@class=\"ant-input css-xu9wm8\"])[3]" ) );
                enteringtext.sendKeys ( "Where The Course Is Present ?..." );

//        // Clicking the upload Buttton
//        Thread.sleep ( 3000 );
//        clickingupload = driver.findElement ( xpath ( "//*[@alt=\"image_upload\"]" ) );
//        clickingupload.click ();

//        try {
//            // Short delay to ensure the comment text field is ready
//            Thread.sleep(2000);
//
//            // Define the file path and copy it to the clipboard
//            String filePath = "C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png";
//            StringSelection selection = new StringSelection(filePath);
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//            System.out.println("File path copied to clipboard successfully.");
//
//            // Initialize Robot instance for keyboard actions
//            Robot robot = new Robot();
//
//            // Small delay before performing keyboard actions
//            Thread.sleep(1000);
//
//            // Simulate CTRL + V to paste the file path
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//
//            // Brief pause before pressing ENTER
//            Thread.sleep(500);
//
//            // Press and release ENTER to confirm upload
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//            System.out.println("Image uploaded successfully.");
//
//        } catch (Exception e) {
//            System.out.println("An error occurred during the image upload: " + e.getMessage());
//        }

//        try {
//            // Locate the file input element (adjust the locator to match your file input element)
//            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//
//            // Specify the file path you want to upload
//            String filePath = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Pic1.jpg\"";
//
//            // Upload the file by sending the file path to the input field
//            fileInput.sendKeys(filePath);
//
//            // Log success message
//            System.out.println("Image successfully uploaded.");
//
//        } catch (NoSuchElementException e) {
//            System.out.println("File input element not found: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("An error occurred during the image upload: " + e.getMessage());
//        }

                // Clicking the Send button
//        Thread.sleep (5000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendbutton.click ();
//        System.out.println ("Sucessfully Doubt Uploaded");

                // Clicking The Close Icon
                Thread.sleep ( 4000 );
                WebElement clickingCloseIcon = driver.findElement ( xpath ( "(//*[@alt=\"Close\"])[2]" ) );
                clickingCloseIcon.click ();

            } else {
                System.out.println ( "Code Has Not excuted For All Doubts Sub-Sub-Modules" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "All Doubt Sub-Sub-Module Was Not Present In The Current Course, So Skipping And Moving To Next Module " );
        }
    }

}

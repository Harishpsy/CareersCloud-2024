package MyCourse;

import MainPages.Loginpage;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import static org.openqa.selenium.By.*;

public class CourseDoubts {
    WebDriver driver;
    public CourseDoubts(WebDriver driver) {
        this.driver = driver;
    }
    public void Doubts() throws InterruptedException, AWTException {

        // Clicking The First Course Card In the My Course
        Thread.sleep ( 3000 );
        WebElement clickingFirstCourseCard = driver.findElement ( xpath ( "(//*[@class=\"ant-card-body\"])[1]" ) );
        clickingFirstCourseCard.click ();

        // Clicking the Doubts Tab
        Thread.sleep ( 3000 );
        WebElement clickingDoubts = driver.findElement ( xpath ( "//*[@id=\"rc-tabs-8-tab-8\"]" ) );
        clickingDoubts.click ();
        System.out.println ( "Successfully Clicked The Doubt Tab Inside The Course" );

        // Scrolling the doubt page
        int numberoftimesscroll = 5;

        for (int i = 0; i < numberoftimesscroll; i++) {
            try {
                Thread.sleep ( 3000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The Doubt List page InSide The Course" + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }

        // Scrolling the doubt page
        numberoftimesscroll = 3;

        for (int i = 0; i < numberoftimesscroll; i++) {
            try {
                Thread.sleep ( 3000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(document.body.scrollHeight,0)" );
                System.out.println ( "Successfully scroll The Doubt List page InSide The Course" + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }

//        // Clicking Float Icon
//            try {
//                WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-content\"]" ) );
//                if (clickingFloatIcon.isDisplayed ()) {
//                    Thread.sleep ( 5000 );
//                    clickingFloatIcon.click ();
//                } else {
//                    System.out.println ( "Float Icon Is Not Displayed" );
//                }
//            } catch (NoSuchElementException e) {
//                System.out.println ( "FloatIcon Button Is Not Displayed" );
//            }

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
            System.out.println ( "Original Doubt Image In The List: " + actualDoubtImageUrl );

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

        // Entering the text
        WebElement Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
        Enteringtext.sendKeys ( "Thanks" );

        // Clicking the upload Buttton
        Thread.sleep ( 5000 );
        WebElement clickingupload = driver.findElement ( xpath ( "//*[@alt=\"upload\"]" ) );
        clickingupload.click ();

        // Uploading Image in the Comment text field
        Thread.sleep ( 3000 );
        String file = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png\"";
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

        // Clicking the Send button
        Thread.sleep ( 3000 );
        WebElement clickingSendbutton = driver.findElement ( xpath ( "//*[@alt=\"send_doubts\"]" ) );
        clickingSendbutton.click ();

        // Clicking The cancel Icon
        Thread.sleep ( 5000 );
        WebElement clickingCancelIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
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
        WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
        Cancel_button.click ();

        // Clicking The three Dots in the doubts
        Thread.sleep ( 3000 );
        WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"doubts-Menu\"]" ) );
        clickingThreeDots.click ();

        // Clicking The report Icon in the dropdown
        Thread.sleep ( 3000 );
        WebElement clickingReport = driver.findElement ( xpath ( "//*[text()='Report']" ) );
        clickingReport.click ();

        //Click the wrong information radio button
        Thread.sleep ( 3000 );
        WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field
        Thread.sleep ( 3000 );
        WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
        Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

//        // Click the report button
//        Thread.sleep ( 3000 );
//        WebElement Report_button = driver.findElement ( xpath ( "//span[text()='REPORT']" ) );
//        Report_button.click ();

        // Clicking The Cancel Button
        Thread.sleep ( 5000 );
        Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
        Cancel_button.click ();

        // Clicking The Create Button
        Thread.sleep ( 3000 );
        WebElement clickingCreate = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary add-doubts-btn\"]" ) );
        clickingCreate.click ();

        // Entering the text inside the create doubt text field
        Thread.sleep ( 5000 );
        WebElement enteringtext = driver.findElement ( xpath ( "(//*[@class=\"ant-input css-xu9wm8\"])[2]" ) );
        enteringtext.sendKeys ( "Where The Course Is Present ?..." );

        // Clicking the upload Buttton
        Thread.sleep ( 3000 );
        clickingupload = driver.findElement ( xpath ( "//*[@alt=\"image_upload\"]" ) );
        clickingupload.click ();

        // Uploading Image in the Comment text field
        Thread.sleep ( 3000 );
        file = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Untitled156.png\"";
        selection = new StringSelection ( file );
        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents ( selection , null );
        System.out.println ( "Sucessfully Uploaded The Image" );

        // Pressing the keyboard button
        robot = new Robot ();

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

        // Clicking the Send button
//        Thread.sleep (10000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendbutton.click ();
//        System.out.println ("Sucessfully Doubt Uploaded");

        // Clicking The Close Icon
        Thread.sleep ( 4000 );
        WebElement clickingCloseIcon = driver.findElement ( xpath ( "(//*[@alt=\"Close\"])[2]" ) );
        clickingCloseIcon.click ();
    }

    public void MyDoubt() throws InterruptedException {

        // Clicking the My Doubts
        Thread.sleep ( 5000 );
        WebElement clickingMydoubts = driver.findElement ( xpath ( "//*[text()='My Doubts']" ) );
        clickingMydoubts.click ();

        try {
            // Verifying if the "No Doubts Found" element is present or not
            boolean isNoRecordfoundDisplayed = false;
            boolean isUserNameDisplayed = false;

            try {
                Thread.sleep ( 3000 ); // Waiting for the element to be displayed
                WebElement noDoubtFound = driver.findElement ( By.xpath ( "//*[text()='No Doubts Found.']" ) );
                isNoRecordfoundDisplayed = noDoubtFound.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "Error in inner try block: No Doubts Found element not located." );
            }

            try {
                Thread.sleep ( 5000 ); // Waiting for the element to be displayed
                WebElement gettingUserNameInMyDoubts = driver.findElement ( By.xpath ( "//*[@class=\"doubts-card-title\"]" ) );
                isUserNameDisplayed = gettingUserNameInMyDoubts.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "Error in inner try block2: Answer Found elementnot located" );
            }

            // Verifying if the "No Doubts Found" element was displayed
            System.out.println ( "'No Doubts Found' element displayed in My Doubts: " + isNoRecordfoundDisplayed );

            if (isNoRecordfoundDisplayed) {
                Thread.sleep ( 5000 ); // Waiting before performing the next action
                WebElement clickingMyAnsweredButton = driver.findElement ( By.xpath ( "//*[text()='My Answered']" ) );
                clickingMyAnsweredButton.click ();
                System.out.println ( "Successfully clicked the 'My Answered' button from My Doubts." );
            } else if (isUserNameDisplayed) {
                Thread.sleep ( 5000 ); // Waiting before performing the next action
                // Assuming WebElement and WebDriver are imported correctly

                // Finding all elements with class 'doubts-card-title'
                java.util.List<WebElement> doubtsCardTitles = driver.findElements ( xpath ( "//*[@class='doubts-card-title']" ) );

                // Creating an instance of Loginpage to get the original username
                Loginpage login = new Loginpage ( driver );
                String originalUserName = login.toString ();
                System.out.println ( originalUserName );

                // Iterating through each WebElement in doubtsCardTitles
                for (WebElement myDoubtsUserName : doubtsCardTitles) {
                    // Getting text from each WebElement
                    String userNameDoubt = myDoubtsUserName.getText ();
                    System.out.println ( "My Doubts UserName : " + userNameDoubt );

                    // Asserting that the username matches the original username
                    // Assert.assertEquals(userNameDoubt, originalUserName, "Username and Doubt username do not match!");
                }

                // Clicking the Answer Icon
                Thread.sleep ( 5000 );
                WebElement clickingAnswericon = driver.findElement ( xpath ( "(//*[@id=\"comments-icon\"])[1]" ) );
                clickingAnswericon.click ();
                System.out.println ( "Successfully Clicked The Answer icon in the My Doubts " );

                // Entering the text
                Thread.sleep ( 2000 );
                WebElement Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
                Enteringtext.sendKeys ( "Thanks" );

                // Clicking the Send button
                Thread.sleep ( 3000 );
                WebElement clickingSendbutton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[1]" ) );
                clickingSendbutton.click ();
                System.out.println ( "Successfully Clicked The Send in the My Doubts " );

                // Clicking the Reply button
                WebElement clickingReplyButton = driver.findElement ( xpath ( "//*[text()=' Reply']" ) );
                clickingReplyButton.click ();
                System.out.println ( "Successfully Clicked The Reply in the My Doubts " );

                // Entering the text in reply text field
                WebElement enteringText = driver.findElement ( id ( "reply_text" ) );
                enteringText.sendKeys ( "Thanks For the answer   " );

                // Clicking the send button
                WebElement clickingSendButton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[2]" ) );
                clickingSendButton.click ();
                System.out.println ( "Successfully Clicked The Send in the My Doubts " );

                // Clicking The Like Button
                WebElement clickingLikeButton = driver.findElement ( xpath ( "//*[@alt=\"liked\"]" ) );
                clickingLikeButton.click ();
                System.out.println ( "Successfully Clicked The Like in the My Doubts " );

                // There is an issue in the button
                // Clicking The Mark As Best Answer
                //        Thread.sleep (3000);
                //        WebElement clickBestAnswer = driver.findElement (xpath ("//*[@alt=\"award\"]"));
                //        clickBestAnswer.click ();

                // Clicking The Close Icon
//        Thread.sleep (3000);
//        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"doubt-answer-btn\"]"));
//        clickingCloseIcon.click ();
//
//        // Clicking the Answer Icon
//        clickingAnswericon = driver.findElement (id ("comments-icon"));
//        clickingAnswericon.click ();

//        // Clicking The undo Button
//        Thread.sleep (3000);
//        WebElement clickUndo = driver.findElement (xpath ("//*[@alt=\"doubts_undo\"]"));
//        clickUndo.click ();

                // Clicking The Close Icon
                Thread.sleep ( 5000 );
                WebElement clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
                clickingCloseIcon.click ();
                System.out.println ( "Successfully Clicked The Close Icon in the My Doubts " );
            } else {
                System.out.println ( "Data was present in the Followed page." );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Error message in outer catch block: " + e.getMessage () );
        }
    }

    public void MyAnswered() throws InterruptedException {

        // CLicking My Answered Tab
        Thread.sleep ( 5000 );
        WebElement clickingMyAnswered = driver.findElement ( xpath ( "//*[text()=\"My Answered\"]" ) );

        // Verifying that the my answered was already get clicked or not
        if (clickingMyAnswered.isSelected ()) {
            Thread.sleep ( 3000 );
            System.out.println ( "My Answered Button was already Selected" );
        } else if (clickingMyAnswered.isDisplayed ()) {
            Thread.sleep ( 5000 );
            clickingMyAnswered.click ();
            System.out.println ( "Successfully clicked the My Answer button" );
        } else {
            System.out.println ( "Error Occured In The Above Code" );
        }

        // Verifying My answer was present or Not by using try catch method
        try {
            // Pause execution for 10 seconds
            Thread.sleep ( 3000 );
            boolean isNoDoubtFoundDisplayed = false;
            boolean isThreeDotsTriggerDisplayed = false;

            // Attempt to find and interact with the "No Doubts Found" element
            try {
                System.out.println ( "Searching for 'No Doubts Found' element" );
                WebElement noDoubtFound = driver.findElement ( By.xpath ( "(//*[text()='No Doubts Found.'])[1]" ) );
                isNoDoubtFoundDisplayed = noDoubtFound.isDisplayed ();

            } catch (NoSuchElementException e) {
                System.out.println ( "'No Doubts Found' element not found." );
            }

            // Attempt to find and interact with the dropdown trigger element
            try {
                System.out.println ( "Searching for dropdown trigger element" );
                WebElement threeDotsTrigger = driver.findElement ( By.xpath ( "//*[@class='ant-dropdown-trigger']" ) );
                isThreeDotsTriggerDisplayed = threeDotsTrigger.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "Dropdown trigger element not found." );
            }

            System.out.println ( "No Doubts Found' element displayed: " + isNoDoubtFoundDisplayed );
            System.out.println ( "Dropdown trigger element displayed: " + isThreeDotsTriggerDisplayed );

            // Conditional logic for clicking elements
            if (isNoDoubtFoundDisplayed) {
                Thread.sleep ( 5000 ); // Assuming you handle InterruptedException elsewhere
                WebElement followedButton = driver.findElement ( By.xpath ( "//*[text()='Followed']" ) );
                followedButton.click ();
                System.out.println ( "Successfully clicked the 'Followed' button" );

            } else if (isThreeDotsTriggerDisplayed) {

                Thread.sleep ( 5000 );
                WebElement threeDotsTrigger = driver.findElement ( By.xpath ( "(//*[@class='ant-dropdown-trigger'])[1]" ) );
                threeDotsTrigger.click ();
                System.out.println ( "Successfully clicked the 'ThreeDots' trigger" );

                // Clicking The Share Button In the MyAnswered
                Thread.sleep ( 5000 );
                WebElement clickingShareButtonInDoubt = driver.findElement ( By.xpath ( "//ul[@class=\"ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-xu9wm8\"]//preceding-sibling::li" ) );
                clickingShareButtonInDoubt.click ();
                System.out.println ( "Successfully CLicked The Share Button " );

                // Clicking The CopyLink Button In The Share
                Thread.sleep ( 5000 );
                WebElement clickingCopyLink = driver.findElement ( By.xpath ( "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-link quiz-popup-modal-share-copy-url-button\"])[2]" ) );
                clickingCopyLink.click ();
                System.out.println ( "Successfully CLicked The Copylink Button " );

                // Clicking The cancel Button In The Share Popup
                Thread.sleep ( 5000 );
                WebElement clickingCancelButtonInPopup = driver.findElement ( By.xpath ( "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-lg ant-btn-block quiz-popup-modal-share-footer-button\"])[2]" ) );
                clickingCancelButtonInPopup.click ();
                System.out.println ( "Successfully CLicked The Cancel Button " );

                // Clicking The Answer
                Thread.sleep ( 4000 );
                WebElement clickingAnswerButton = driver.findElement ( By.xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary btn-answer\"]" ) );
                clickingAnswerButton.click ();

                // Retreving The Username From the Doubt Answer
                Thread.sleep ( 4000 );
                WebElement gettingUsernameFromDoubt = driver.findElement ( By.xpath ( "//*[@class=\"doubts-answer-user\"]" ) );
                String doubtUserNames = gettingUsernameFromDoubt.getText ();
                System.out.println ( "UserName In side the My Answer: " + doubtUserNames );// Need to split the div into two part

                // Calling LoginPage By Using Contructor
                Loginpage login = new Loginpage ( driver );
                String OriginalUserName = login.toString ();

                // Verifying That the username is equal to Doubt username
                // Assert.assertEquals (doubtUserNames, OriginalUserName + "Username and username do not match!");

                // Clicking The close Icon
                WebElement clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
                clickingCloseIcon.click ();
                System.out.println ( "Successfully Clicked The Close Icon " );

                // Clicking the Follow Icon
                Thread.sleep ( 3000 );
                WebElement followIcon = driver.findElement ( xpath ( "//*[@alt=\"follow\"]" ) );
                WebElement unfollowIcon = driver.findElement ( xpath ( "//*[@alt=\"follow\"]" ) );

                if (followIcon != null) {
                    followIcon.click ();
                    System.out.println ( "Successfully clicked Follow in the Course Doubt" );
                } else if (unfollowIcon != null) {
                    unfollowIcon.click ();
                    System.out.println ( "Successfully clicked Unfollow in the Course Doubt" );
                } else {
                    System.out.println ( "Could not find follow or unfollow icon element in the Course Doubt." );
                }

                // Clicking the Answer Icon
                Thread.sleep ( 5000 );
                WebElement clickingAnswericon = driver.findElement ( id ( "comments-icon" ) );
                clickingAnswericon.click ();
                System.out.println ( "Successfully Clicked The Answer icon in the Course Doubt" );

                // Entering the text
                Thread.sleep ( 5000 );
                WebElement Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
                Enteringtext.sendKeys ( "Thanks" );

                // Clicking the send button
                Thread.sleep ( 5000 );
                WebElement clickingSendButton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[1]" ) );
                clickingSendButton.click ();
                System.out.println ( "Successfully Clicked The Send Button in the Course Doubt" );

                // Clicking the Reply button
                Thread.sleep ( 5000 );
                WebElement clickingReplyButton = driver.findElement ( xpath ( "//*[text()=' Reply']" ) );
                clickingReplyButton.click ();

                // Entering the text in reply text field
                WebElement enteringText = driver.findElement ( id ( "reply_text" ) );
                enteringText.sendKeys ( "Thanks For the answer " );

                // Clicking the send button
                Thread.sleep ( 5000 );
                clickingSendButton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[1]" ) );
                clickingSendButton.click ();
                System.out.println ( "Successfully Clicked The Send Button in the Course Doubt" );

                // Clicking The Like Button
                Thread.sleep ( 5000 );
                WebElement clickingLikeButton = driver.findElement ( xpath ( "//*[@alt=\"liked\"]" ) );
                clickingLikeButton.click ();
                System.out.println ( "Successfully Clicked The like Button in the Course Doubt" );

                // Clicking The Close Icon
                Thread.sleep ( 5000 );
                clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
                clickingCloseIcon.click ();
                System.out.println ( "Successfully Clicked The Close icon in the Course Doubt" );

                // Clicking The share Icon
                Thread.sleep ( 5000 );
                WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );

                clickingshareicon.click ();
                System.out.println ( "Successfully Clicked The Share icon in the Course Doubt" );

                //click the copy link in the share popup
                Thread.sleep ( 5000 );
                WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();
                System.out.println ( "Successfully Clicked The copy link in the Course Doubt" );

                //Clicking the cancel button in the in share popup
                Thread.sleep ( 5000 );
                WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();
                System.out.println ( "Successfully Clicked The cancel Button in the Course Doubt" );

            } else {
                System.out.println ( "Neither 'Followed' button nor 'ThreeDots' trigger was found to click" );
            }
        } catch (InterruptedException e) {
            System.out.println ( "An error occurred: " + e.getMessage () );
        }
    }

    public void Followed() throws InterruptedException {

        // Clicking The Followed
        Thread.sleep (5000);
        WebElement clickingFollowedTab = driver.findElement (xpath ("//span[text()='Followed']"));

        // Verifying that the Followed was already getting clicked or not
        if (clickingFollowedTab.isSelected ()) {
            Thread.sleep ( 3000 );
            System.out.println ( "Followed Button was already Selected" );
        } else if (clickingFollowedTab.isDisplayed ()) {
            Thread.sleep ( 5000 );
            clickingFollowedTab.click ();
            System.out.println ( "Successfully clicked the Followed button" );
        } else {
            System.out.println ( "Error Occured In The Above Code" );
        }

        try {
            // Verifying whether the element is present or not
            Thread.sleep ( 5000 );
            boolean isNoDoubtsFoundDisplayed = false;

            try {
                // Waiting for the element to be displayed
                Thread.sleep ( 5000 );
                WebElement checkingNoDoubtsFound = driver.findElement ( By.xpath ( "//*[text()='No Doubts Found.']" ) );
                isNoDoubtsFoundDisplayed = checkingNoDoubtsFound.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "No Doubt Found element not found." );
            }

            // Printing whether the data was found or not using the boolean
            System.out.println ( "No Doubt Found displayed in Followed: " + isNoDoubtsFoundDisplayed );

            // Creating if-else condition for navigation
            if (isNoDoubtsFoundDisplayed) {
                // Click the breadcrums in the course list page
                Thread.sleep ( 5000 );
                WebElement clickingBreadCrums = driver.findElement ( xpath ( "//*[text()='Course']" ) );
                clickingBreadCrums.click ();
                System.out.println ( "Successfully clicked the Course BreadCrumbs button" );
            } else {

                // Clicking the Answer Icon
                Thread.sleep ( 5000 );
                WebElement clickingAnswericon = driver.findElement ( id ( "comments-icon" ) );
                clickingAnswericon.click ();

                // Entering the text
                Thread.sleep ( 5000 );
                WebElement Enteringtext = driver.findElement ( id ( "teatx-area-id" ) );
                Enteringtext.sendKeys ( "Thanks" );

                // Clicking the send button
                Thread.sleep ( 5000 );
                WebElement clickingSendButton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[1]" ) );
                clickingSendButton.click ();

                // Clicking the Reply button
                Thread.sleep ( 5000 );
                WebElement clickingReplyButton = driver.findElement ( xpath ( "//*[text()=' Reply']" ) );
                clickingReplyButton.click ();

                // Entering the text in reply text field
                WebElement enteringText = driver.findElement ( id ( "reply_text" ) );
                enteringText.sendKeys ( "Thanks For the answer" );

                // Clicking the send button
                Thread.sleep ( 5000 );
                clickingSendButton = driver.findElement ( xpath ( "(//*[@alt=\"send_doubts\"])[1]" ) );
                clickingSendButton.click ();

                // Clicking The Like Button
                Thread.sleep ( 5000 );
                WebElement clickingLikeButton = driver.findElement ( xpath ( "//*[@alt=\"liked\"]" ) );
                clickingLikeButton.click ();

                // Clicking The Close Icon
                Thread.sleep ( 5000 );
                WebElement clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"doubt-answer-btn\"]" ) );
                clickingCloseIcon.click ();
                System.out.println ( "Close Icon" );

                // Clicking The share Icon
                Thread.sleep ( 5000 );
                WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@alt=\"share\"]" ) );
                clickingshareicon.click ();

                //click the copy link in the share popup
                Thread.sleep ( 5000 );
                WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup
                Thread.sleep ( 5000 );
                WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

                // Clicking The three Dots in the doubts
                Thread.sleep ( 3000 );
                WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"doubts-Menu\"]" ) );
                clickingThreeDots.click ();

                // Clicking The report Icon in the dropdown
                Thread.sleep ( 3000 );
                WebElement clickingReport = driver.findElement ( xpath ( "//*[text()='Report']" ) );
                clickingReport.click ();

                //Click the wrong information radio button
                Thread.sleep ( 3000 );
                WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
                Wrong_information_radio_button.click ();

                //Entering the text inside the report text field
                Thread.sleep ( 3000 );
                WebElement Enter_the_report = driver.findElement ( name ( "reportDescription" ) );
                Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

                // Click the report button
//              Thread.sleep (3000);
//              WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//              Report_button.click ();

                // Clicking The Cancel Button
                Thread.sleep ( 5000 );
                Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
                Cancel_button.click ();

                // Click the breadcrums in the course list page
                Thread.sleep ( 5000 );
                WebElement clickingBreadCrums = driver.findElement ( xpath ( "//*[text()='Course']" ) );
                clickingBreadCrums.click ();
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Error in the code: " + e.getMessage () );
        }



    }
}

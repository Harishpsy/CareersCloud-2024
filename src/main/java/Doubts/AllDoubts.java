package Doubts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.*;

import static org.openqa.selenium.By.*;

public class AllDoubts {

    WebDriver driver;

    public AllDoubts(WebDriver driver) {

        this.driver = driver;
    }

    public void allDoubts() throws AWTException, InterruptedException {


        // Clicking The Create Doubt Button

        WebElement clickingCreateButton = driver.findElement (xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary add-doubts-btn\"]"));
        clickingCreateButton.click ();


        // Clicking the search textfield and searching the course

        Thread.sleep (5000);
        WebElement clickingSearch = driver.findElement (xpath ("(//*[@name=\"comments2\"])[2]"));
        clickingSearch.sendKeys ("Mock");

        // Pressing The KeyBoard Action

        Robot robot = new Robot ();

        // clicking The Enter Button

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releasing The Enter Button

        Thread.sleep (5000);
        robot.keyRelease (KeyEvent.VK_ENTER);

        // Pressing Backspace Button In The Keyboard

        // Set the number of times to perform the action

        int numberOfTimes = 4;

        // Creating a Loop to performe this action multiple times

        for (int i = 0; i < numberOfTimes; i++) {
            Thread.sleep (3000);
            robot.keyPress (KeyEvent.VK_BACK_SPACE);

            // Releasing the BackSpace

            robot.keyRelease (KeyEvent.VK_BACK_SPACE);
        }

        // Pressing The Enter Button In The Keyboard

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releassing The Enter Button In The Keyboard

        robot.keyRelease (KeyEvent.VK_ENTER);
        System.out.println ("SucessFully Released The Enter Button");

//        // Focucing the popup
//
//        WebElement foucsingPopup = driver.findElement (By.xpath (""));
//        foucsingPopup.click ();
//
//       // Scroll The Page Using Java Executer
//
//        System.out.println ("Entering Scroll ");
//        Thread.sleep (3000);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
//        System.out.println ("SucessFully Released The Enter Button");

        // Clicking the Course to Create the Doubt

        Thread.sleep (5000);
        WebElement clickingCourse = driver.findElement (xpath ("(//*[@class=\"doubt2\"])[1]"));
        clickingCourse.click ();

        // Clicking the post-Doubts

        Thread.sleep (5000);
        WebElement clickingPostDoubts = driver.findElement (xpath ("//*[text()=\"Post Doubts\"]"));
        clickingPostDoubts.click ();

        // Entering The Text

        Thread.sleep (5000);
        WebElement enteringText = driver.findElement (xpath ("//*[@placeholder=\"Write your Doubts & Just paste(Ctrl+v) your cropped image here\"]"));
        enteringText.sendKeys ("Where Can I Buy The Crack Current Affairs");

//        // Clicking the upload Buttton
//
//        WebElement clickingupload = driver.findElement (xpath ("//*[@alt=\"image_upload\"]"));
//        clickingupload.click ();
//
//        // Uploading Image in the Comment text field
//
//        Thread.sleep (3000);
//        String file = "\"C:\\Users\\Lenovo Desktop 03\\Downloads\\Telegram Desktop\\Blank log.png\"";
//        StringSelection selection = new StringSelection (file);
//        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents (selection, null);
//        System.out.println (file);
//
//        // Pressing the keyboard button
//
//        robot = new Robot ();
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

        // Clicking the close Button

        Thread.sleep (5000);
        WebElement clickingCancelButton = driver.findElement (xpath ("(//*[@alt=\"Close\"])[2]"));
        clickingCancelButton.click ();

//        // Clicking The send-Button
//
//        Thread.sleep (5000);
//        WebElement clickingSendButton= driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendButton.click();

        // Clicking the Follow Icon
        Thread.sleep (3000);
        WebElement followIcon = driver.findElement (xpath ("//*[@alt=\"followed\"]"));
        WebElement unfollowIcon = driver.findElement (xpath ("//*[@alt=\"followed\"]"));

        if (followIcon != null) {
            followIcon.click ();
            System.out.println ("Successfully clicked Follow");
        } else if (unfollowIcon != null) {
            unfollowIcon.click ();
            System.out.println ("Successfully clicked Unfollow");
        } else {
            System.out.println ("Could not find follow or unfollow icon element.");
        }

        // Clicking the Answer Icon

        WebElement clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();

        // Entering the text

        WebElement Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");

//        // Clicking the Send button
//
//        Thread.sleep (3000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
//        clickingSendbutton.click ();
//
//        // Clicking the Reply button
//
//        WebElement clickingReplyButton = driver.findElement (xpath ("//*[text()=' Reply']"));
//        clickingReplyButton.click ();
//
//        // Entering the text in reply text field
//
//        Thread.sleep (5000);
//        enteringText = driver.findElement (id ("reply_text"));
//        enteringText.sendKeys ("Thanks For the answer");
//
//        // Clicking the send button
//
//        Thread.sleep (5000);
//        WebElement clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
//        clickingSendButton.click ();
//
//        // Clicking The Like Button
//
//        Thread.sleep (5000);
//        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@alt=\"liked\"]"));
//        clickingLikeButton.click ();

        // Clicking the close Button

        Thread.sleep (5000);
        WebElement clickingCloseButton = driver.findElement (xpath ("(//img[@alt=\"Close\"])[3]"));
        clickingCloseButton.click ();

        // Clicking The share Icon

        Thread.sleep (5000);
        WebElement clickingshareicon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        Thread.sleep (5000);
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Clicking The three Dots in the doubts

        Thread.sleep (5000);
        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"doubts-Menu\"]"));
        clickingThreeDots.click ();

        // Clicking The report Icon in the dropdown

        Thread.sleep (5000);
        WebElement clickingReport = driver.findElement (xpath ("//*[text()='Report']"));
        clickingReport.click ();

        //Click the wrong information radio button

        Thread.sleep (5000);
        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        Thread.sleep (5000);
        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Clicking The Cancel Button

        Thread.sleep (5000);
        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();

//        // Click the report button
//
//        Thread.sleep (5000);
//        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();

        // Clicking The Doubt card Publish

        Thread.sleep (5000);
        WebElement clickingdoubtname = driver.findElement (xpath ("(//*[@class=\"anticon anticon-right\"])[2]"));
        clickingdoubtname.click ();
        System.out.println ("SucessFully clicked");

        int numberoftimeclickingarrow = 1;

        for (int i = 0; i < numberoftimeclickingarrow; i++) {
            try {
                Thread.sleep (5000);
                clickingdoubtname = driver.findElement (xpath ("(//*[@class=\"anticon anticon-right\"])[2]"));
                clickingdoubtname.click ();
                System.out.println ("Successfully clicked on element " + (i + 1) + " time(s).");
            } catch (Exception e) {
                System.out.println ("Failed to find or click element: " + e.getMessage ());
            }
        }


        // Scrolling the doubt page

        int numberoftimesscroll = 5;

        for (int i = 0; i < numberoftimesscroll; i++) {
            try {
                Thread.sleep (3000);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
                System.out.println ("Successfully scroll The page " + (i + 1) + " time(s).");
            } catch (Exception scroll) {
                System.out.println ("Failed to Scroll : " + scroll.getMessage ());
            }
        }

        // clicking the Float button

        Thread.sleep (5000);
        WebElement clickingFloatButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-vertical-align-top\"]"));
        clickingFloatButton.click ();

        /* Clicking the image in the doubt if the image is not there then skip it */

        Thread.sleep (5000);
        WebElement clickingDoubtImage = driver.findElement (xpath ("(//*[@class=\"ant-image-mask\"])[1]"));

        // Check if the element is found before clicking

        if (clickingDoubtImage != null) {
            clickingDoubtImage.click ();
            System.out.println ("Doubt Image Clicked SucessFully");

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

        /* Getting The Value of the User Asked Doubt */

        // Wait for the page to load completely

        Thread.sleep (5000);

        // Find all elements with the specified class

        java.util.List<WebElement> allDoubtImageURL = driver.findElements (xpath ("//*[@class='ant-image-img css-xu9wm8']"));

        // Create a set to store unique URLs

        Set<String> uniqueDoubtUrls = new HashSet<> ();
        int uniqueDoubtUrlCount = 0;

        // Iterate through the list of elements

        for (WebElement doubtUrlElement : allDoubtImageURL) {
            String actualDoubtImageUrl = doubtUrlElement.getAttribute ("src");
            System.out.println (actualDoubtImageUrl);

            if (uniqueDoubtUrls.contains (actualDoubtImageUrl)) {
                System.out.println ("Duplicate found --> " + actualDoubtImageUrl);
            } else {
                uniqueDoubtUrls.add (actualDoubtImageUrl);
                uniqueDoubtUrlCount++;
                System.out.println ("Found: " + uniqueDoubtUrlCount + " --> " + actualDoubtImageUrl);
                System.out.println ("-------------------------------------------------------------------------");
            }
        }

        // Print the total number of unique URLs found
        System.out.println ("Total unique image URLs found: " + uniqueDoubtUrlCount);

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals (uniqueDoubtUrlCount, uniqueDoubtUrls.size ());

      // Clicking The Googleplay Button
        Thread.sleep (5000);
        WebElement clickingGooglePlayButton = driver.findElement (xpath ("//a[@href=\"https://play.google.com/store/apps/details?id=com.affairscloud\"]"));
        clickingGooglePlayButton.click ();

        // Windows Handeling
        Thread.sleep (3000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        // Closing the current tab
        Thread.sleep (5000);
        driver.close ();

        // Changing the current focus to Parent
        driver.switchTo ().window (parent);

        // Clicking The course In the OverFlow on The right Side
        Thread.sleep (5000);
        WebElement clickingCourseOnRightside = driver.findElement (xpath ("//*[@alt=\"cc69e8a3b3440463929f5f59e45f3175.webp\"]"));
        clickingCourseOnRightside.click ();
        System.out.println ("SuccessFully Navigated To the course");

        // Clicking The Breadcrumbs to Navigate
        Thread.sleep (5000);
        WebElement clickingCourseBreadcrumbs = driver.findElement (xpath ("//*[text()=\"Course\"]"));
        clickingCourseBreadcrumbs.click ();
        System.out.println ("SuccessFully Navigated To the Doubts Page");

        // Clicking The Search On the Left side Filter
        Thread.sleep (5000);
        clickingSearch = driver.findElement (xpath ("//*[@name=\"comments2\"]"));
        clickingSearch.sendKeys ("Mock");

        // Pressing The KeyBoard Action
        robot = new Robot ();

        // clicking The Enter Button
        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releasing The Enter Button
        Thread.sleep (3000);
        robot.keyRelease (KeyEvent.VK_ENTER);

        // Set the number of times to perform the action
        int numberOfTimesClickingBack = 4;

        // Creating a Loop to performe this action multiple times
        for (int i = 0; i < numberOfTimesClickingBack; i++) {
            robot.keyPress (KeyEvent.VK_BACK_SPACE);

            // Releasing the BackSpace
            robot.keyRelease (KeyEvent.VK_BACK_SPACE);
        }

        // Pressing The Enter Button In The Keyboard
        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releassing The Enter Button In The Keyboard
        robot.keyRelease (KeyEvent.VK_ENTER);

        // Clicking The Course For Filter The Doubts
        int clickingCoursetwotimes = 2;

        for (int i = 0; i < clickingCoursetwotimes; i++) {

            try {
                Thread.sleep (5000);
                WebElement clickingCourseForFilter = driver.findElement (xpath ("(//*[@class=\"doubt-left-sidebar-course-body\"])[2]"));
                clickingCourseForFilter.click ();
                System.out.println ("Course SuccessFully Clicked ");
            } catch (Exception Clicking) {
                System.out.println ("Course was Not Found");

            }

        }

        // Clicking The Subject In the Doubt Filter
        Thread.sleep (5000);
        WebElement clickingSubject = driver.findElement (xpath ("//*[text() = 'Subjects']"));
        clickingSubject.click ();


        // Getting the text From The Filter and Verifying
        Thread.sleep (3000);
        WebElement printingTheSubjectFilter = driver.findElement (id ("doubt-sidebar-body"));
        String subjectCourse = printingTheSubjectFilter.getText ();
        System.out.println ("List Of Subject Course are Below While Filtering");
        System.out.println (subjectCourse);
        System.out.println ("-------------------------------------------------------");

        // Verifying the Exam Filter by using the Assertion method
        String[] subjectcourseNames = subjectCourse.split ("\n"); // Splitting text into course names
        System.out.println ("SuccessFully Fetching The Course Names -->" + Arrays.toString (subjectcourseNames));

        // Fetching the course list elements
        java.util.List<WebElement> subjectcourseLists = driver.findElements (xpath ("//div[@class='doubt-left-sidebar-course-body']"));

        Set<String> uniquesubjectCourse = new HashSet<> ();

        int uniqueSubjectCourseCount = 0;

        // Iterating through course lists to find unique courses and count matches
        for (WebElement subjectcourseList : subjectcourseLists) {
            String actualsubjectCourseList = subjectcourseList.getText ().trim ();

            if (uniquesubjectCourse.contains (actualsubjectCourseList)) {
                System.out.println ("Duplicate found --> " + actualsubjectCourseList);
            } else {
                uniquesubjectCourse.add (actualsubjectCourseList);
                if (Arrays.asList (subjectcourseNames).contains (actualsubjectCourseList)) {
                    uniqueSubjectCourseCount++;
                    System.out.println ("Found: " + uniqueSubjectCourseCount + " --> " + actualsubjectCourseList);
                }
            }
        }
        System.out.println ("Total unique CourseName found: " + uniqueSubjectCourseCount);
        try {
            Assert.assertEquals ( "Verification Passed" + uniqueSubjectCourseCount , subjectcourseNames.length );
        } catch (AssertionError e) {
            System.out.println ( "Verification Failed, can't able to find the Course" );
        }
        System.out.println ("-------------------------------------------------------");

        // Clicking The Exams In The Doubt Filter..............
        Thread.sleep (5000);
        WebElement clickingExamFilter = driver.findElement (xpath ("//*[text() = 'Exams']"));
        clickingExamFilter.click ();

        // Getting the text From The Exam Filter and Verifying
        Thread.sleep (5000);
        WebElement printingTheExamFilter = driver.findElement (id ("doubt-sidebar-body"));
        String examText = printingTheExamFilter.getText ();
        System.out.println ("List Of Exam Course are Below While Filtering");
        System.out.println (examText);
        System.out.println ("-------------------------------------------------------");


        // Verifying the Exam Filter by using the Assertion method
        String[] ExamcourseNames = examText.split ("\n"); // Splitting text into course names

        System.out.println ("SuccessFully Fetching The Course Names -->" + Arrays.toString (ExamcourseNames));

        // Fetching the course list elements
        List<WebElement> ExamcourseLists = driver.findElements (xpath ("//div[@class='doubt-left-sidebar-course-body']"));

        Set<String> uniqueExamCourse = new HashSet<> ();

        int uniqueExamCourseCount = 0;

        // Iterating through course lists to find unique courses and count matches
        for (WebElement ExamcourseList : ExamcourseLists) {
            String actualExamCourseList = ExamcourseList.getText ().trim ();

            if (uniqueExamCourse.contains (actualExamCourseList)) {
                System.out.println ("Duplicate found --> " + actualExamCourseList);
            } else {
                uniqueExamCourse.add (actualExamCourseList);

                if (Arrays.asList (ExamcourseNames).contains (actualExamCourseList)) {
                    uniqueExamCourseCount++;
                    System.out.println ("Found: " + uniqueExamCourseCount + " --> " + actualExamCourseList);
                }
            }
        }

        System.out.println ("Total unique CourseName found: " + uniqueExamCourseCount);
        Assert.assertEquals (uniqueExamCourseCount, ExamcourseNames.length);
        System.out.println ("-------------------------------------------------------");

        // Clicking The All In The Doubt Filter
        WebElement clickingAllFilter = driver.findElement (xpath ("//*[text() = 'All']"));
        clickingAllFilter.click ();

        // Getting the text From The All Filter and Verifying there is any duplicate present
        Thread.sleep (5000);

        // Fetching the text from the doubt-sidebar-body element
        WebElement printingTheAllFilter = driver.findElement (id ("doubt-sidebar-body"));
        String allText = printingTheAllFilter.getText ();
        System.out.println ("List Of All Course are Below");
        System.out.println (allText);
        System.out.println ("-------------------------------------------------------");

        // Verifying the All Filter by using the Assertion method
        String[] courseNames = allText.split ("\n"); // Splitting text into course names
        System.out.println ("SuccessFully Fetching The Course Names -->" + Arrays.toString (courseNames));

        // Fetching the course list elements
        java.util.List<WebElement> courseLists = driver.findElements (xpath ("//div[@class='doubt-left-sidebar-course-body']"));

        Set<String> uniqueCourse = new HashSet<> ();

        int uniqueCourseCount = 0;

        // Iterating through course lists to find unique courses and count matches
        for (WebElement courseList : courseLists) {
            String actualAllCourseList = courseList.getText ().trim ();

            if (uniqueCourse.contains (actualAllCourseList)) {
                System.out.println ("Duplicate found --> " + actualAllCourseList);
            } else {
                uniqueCourse.add (actualAllCourseList);

                if (Arrays.asList (courseNames).contains (actualAllCourseList)) {
                    uniqueCourseCount++;
                    System.out.println ("Found: " + uniqueCourseCount + " --> " + actualAllCourseList);
                }
            }
        }
        System.out.println ("Total unique CourseName found: " + uniqueCourseCount);
        Assert.assertEquals (uniqueCourseCount, courseNames.length);

    }
}


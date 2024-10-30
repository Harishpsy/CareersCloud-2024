package Doubts;

import Master.Base.CoreFunctionality;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.*;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class AllDoubts {

    WebDriver driver;

    public AllDoubts(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void allDoubts() throws AWTException, InterruptedException {

        // Initialize WebDriverWait for explicit waits
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) ); // 10-second timeout

        // Click the "Create" button
        WebElement createButton = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[text()='Create']" ) ) );
        createButton.click ();
        System.out.println ( "Successfully clicked the 'Create' button." );

        // Locate the search field and enter the course name
        WebElement searchField = wait.until ( ExpectedConditions.visibilityOfElementLocated ( xpath ( "(//*[@name='comments2'])[2]" ) ) );
        String courseName = "Mock";
        searchField.sendKeys ( courseName );
        System.out.println ( "Successfully entered the course name." );

        // Get the length of the entered text to dynamically press BACK_SPACE for each character
        int textLength = courseName.length ();
        Actions actions = new Actions ( driver );
        actions.sendKeys ( Keys.ENTER )
                .pause ( 500 ); // Short pause between actions

        // Press BACK_SPACE based on text length
        for (int i = 0; i < textLength; i++) {
            actions.sendKeys ( Keys.BACK_SPACE );
        }

        // Complete the action chain by pressing ENTER again
        actions.pause ( 500 )
                .sendKeys ( Keys.ENTER )
                .perform ();
        System.out.println ( "Successfully completed all actions with dynamic BACK_SPACE based on text length." );

        // Clicking the Course to Create the Doubt
        sleep ( 5000 );
        WebElement clickingCourse = driver.findElement (xpath ("(//*[@class=\"doubt2\"])[1]"));
        clickingCourse.click ();

        // Clicking the post-Doubts
        sleep ( 5000 );
        WebElement clickingPostDoubts = driver.findElement (xpath ("//*[text()=\"Post Doubts\"]"));
        clickingPostDoubts.click ();

        // Entering The Text
        sleep ( 5000 );
        WebElement enteringText = driver.findElement (xpath ("//*[@placeholder=\"Write your Doubts & Just paste(Ctrl+v) your cropped image here\"]"));
        enteringText.sendKeys ("Where Can I Buy The Crack Current Affairs");

        // Creating An Object for Uploading Image
        CoreFunctionality upload = new CoreFunctionality ( driver );
        upload.uploadImage ();

        // Clicking the close Button
        sleep ( 5000 );
        WebElement clickingCancelButton = driver.findElement (xpath ("(//*[@alt=\"Close\"])[2]"));
        clickingCancelButton.click ();

//        // Clicking The send-Button
//        Thread.sleep (5000);
//        WebElement clickingSendButton= driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
//        clickingSendButton.click();

        // Clicking the Follow Icon
        sleep ( 3000 );
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
//        Thread.sleep (3000);
//        WebElement clickingSendbutton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
//        clickingSendbutton.click ();
//
//        // Clicking the Reply button
//        WebElement clickingReplyButton = driver.findElement (xpath ("//*[text()=' Reply']"));
//        clickingReplyButton.click ();
//
//        // Entering the text in reply text field
//        Thread.sleep (5000);
//        enteringText = driver.findElement (id ("reply_text"));
//        enteringText.sendKeys ("Thanks For the answer");
//
//        // Clicking the send button
//        Thread.sleep (5000);
//        WebElement clickingSendButton = driver.findElement (xpath ("(//*[@alt=\"send_doubts\"])[2]"));
//        clickingSendButton.click ();
//
//        // Clicking The Like Button
//        Thread.sleep (5000);
//        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@alt=\"liked\"]"));
//        clickingLikeButton.click ();

        // Clicking the close Button
        sleep ( 5000 );
        WebElement clickingCloseButton = driver.findElement (xpath ("(//img[@alt=\"Close\"])[3]"));
        clickingCloseButton.click ();

        // Clicking The share Icon
        sleep ( 5000 );
        WebElement clickingshareicon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup
        sleep ( 3000 );
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        sleep ( 5000 );
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Clicking The three Dots in the doubts
        sleep ( 5000 );
        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"doubts-Menu\"]"));
        clickingThreeDots.click ();

        // Clicking The report Icon in the dropdown
        sleep ( 5000 );
        WebElement clickingReport = driver.findElement (xpath ("//*[text()='Report']"));
        clickingReport.click ();

        //Click the wrong information radio button
        sleep ( 3000 );
        WebElement Wrong_information_radio_button = driver.findElement ( xpath ( "(//*[@name=\"selectedReportType\"])[2]" ) );
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field
        sleep ( 5000 );
        WebElement Enter_the_report = driver.findElement ( xpath ( "//*[@placeholder=\"Enter Your Report\"]" ) );
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Clicking The Cancel Button
        sleep ( 5000 );
        Cancel_button = driver.findElement ( xpath ( "//*[text()='CANCEL']" ) );
        Cancel_button.click ();

//        // Click the report button
//        Thread.sleep (5000);
//        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
//        Report_button.click ();

        // Clicking The Doubt card Publish
        sleep ( 5000 );
        WebElement clickingdoubtname = driver.findElement (xpath ("(//*[@class=\"anticon anticon-right\"])[2]"));
        clickingdoubtname.click ();
        System.out.println ("SucessFully clicked");

        int numberoftimeclickingarrow = 1;

        for (int i = 0; i < numberoftimeclickingarrow; i++) {
            try {
                sleep ( 5000 );
                clickingdoubtname = driver.findElement (xpath ("(//*[@class=\"anticon anticon-right\"])[2]"));
                clickingdoubtname.click ();
                System.out.println ("Successfully clicked on element " + (i + 1) + " time(s).");
            } catch (Exception e) {
                System.out.println ("Failed to find or click element: " + e.getMessage ());
            }
        }

        // Scrolling the doubt page
        CoreFunctionality scrollPage = new CoreFunctionality ( driver );
        scrollPage.Scroll ();

        // clicking the Float button
        sleep ( 5000 );
        WebElement clickingFloatButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-vertical-align-top\"]"));
        clickingFloatButton.click ();

        /* Clicking the image in the doubt if the image is not there then skip it */
        sleep ( 5000 );
        WebElement clickingDoubtImage = driver.findElement (xpath ("(//*[@class=\"ant-image-mask\"])[1]"));

        // Check if the element is found before clicking
        if (clickingDoubtImage != null) {
            clickingDoubtImage.click ();
            System.out.println ("Doubt Image Clicked SucessFully");

            // Clicking The Flip Button in the Y axis
            sleep ( 5000 );
            WebElement clickingFlipButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-flipY\"]" ) );
            clickingFlipButton.click ();

            // Clicking The Flip Button in the X axis
            sleep ( 5000 );
            WebElement clickingFlipButtonXAxis = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-flipX\"]" ) );
            clickingFlipButtonXAxis.click ();

            // Clicking The Rotated Left Button In Doubt Image
            sleep ( 5000 );
            WebElement clickingRotateLeftButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-rotateLeft\"]" ) );
            clickingRotateLeftButton.click ();

            // Clicking The Rotated Right Button In Doubt Image
            sleep ( 5000 );
            WebElement clickingRotateRightButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-rotateRight\"]" ) );
            clickingRotateRightButton.click ();

            // Clicking The ZoomIn Button
            sleep ( 5000 );
            WebElement clickingZoomInButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-zoomIn\"]" ) );
            clickingZoomInButton.click ();

            // Click The Zoom Out Button
            sleep ( 5000 );
            WebElement clickingZoomOutButton = driver.findElement ( xpath ( "//*[@class=\"ant-image-preview-operations-operation ant-image-preview-operations-operation-zoomOut\"]" ) );
            clickingZoomOutButton.click ();

            // Clicking The Cancel Button
            sleep ( 3000 );
            WebElement clickingTheCancelButton = driver.findElement ( xpath ( "//button[@class=\"ant-image-preview-close\"]" ) );
            clickingTheCancelButton.click ();

        } else {
            System.out.println ( "Doubt Image not found." );
        }

        /* Getting The Value of the User Asked Doubt */

        // Wait for the page to load completely
        sleep ( 5000 );

        // Find all elements In The All Doubts URL
        List<WebElement> allDoubtImageURL = driver.findElements ( xpath ( "//*[@class=\"ant-image-img css-xu9wm8\"]" ) );

        // Create a set to store unique URLs
        Set<String> uniqueDoubtUrls = new HashSet<> ();
        int uniqueDoubtUrlCount = 0;

        // Iterate through the list of elements
        for (WebElement doubtUrlElement : allDoubtImageURL) {
            String actualDoubtImageUrl = doubtUrlElement.getAttribute ("src");
            System.out.println ( "Original Doubt Image: " + actualDoubtImageUrl );

            if (uniqueDoubtUrls.contains (actualDoubtImageUrl)) {
                System.out.println ( "Duplicate Doubt Images found --> " + actualDoubtImageUrl );
            } else {
                uniqueDoubtUrls.add (actualDoubtImageUrl);
                uniqueDoubtUrlCount++;
//                System.out.println ("Found: " + uniqueDoubtUrlCount + " --> " + actualDoubtImageUrl);
                System.out.println ("-------------------------------------------------------------------------");
            }
        }

        // Print the total number of unique URLs found
        System.out.println ("Total unique image URLs found: " + uniqueDoubtUrlCount);

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals (uniqueDoubtUrlCount, uniqueDoubtUrls.size ());

      // Clicking The Googleplay Button
        sleep ( 5000 );
        WebElement clickingGooglePlayButton = driver.findElement (xpath ("//a[@href=\"https://play.google.com/store/apps/details?id=com.affairscloud\"]"));
        clickingGooglePlayButton.click ();

        // Windows Handeling
        sleep ( 3000 );
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);

        // Closing the current tab
        sleep ( 5000 );
        driver.close ();

        // Changing the current focus to Parent
        driver.switchTo ().window (parent);

        // Clicking The course In the OverFlow on The right Side
        sleep ( 5000 );
        WebElement clickingCourseOnRightside = driver.findElement (xpath ("//*[@alt=\"cc69e8a3b3440463929f5f59e45f3175.webp\"]"));
        clickingCourseOnRightside.click ();
        System.out.println ("SuccessFully Navigated To the course");

        // Clicking The Breadcrumbs to Navigate
        sleep ( 5000 );
        WebElement clickingCourseBreadcrumbs = driver.findElement (xpath ("//*[text()=\"Course\"]"));
        clickingCourseBreadcrumbs.click ();
        System.out.println ("SuccessFully Navigated To the Doubts Page");

        // Clicking the search on the left side filter with WebDriverWait for better stability
        WebDriverWait waits = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
        searchField = wait.until ( ExpectedConditions.visibilityOfElementLocated ( xpath ( "//*[@name='comments2']" ) ) );
        String course = "Mock";
        searchField.sendKeys ( course );
        System.out.println ( "Successfully entered the course name." );

        // Get the length of the entered text to dynamically press BACK_SPACE for each character
        textLength = course.length ();
        Actions action = new Actions ( driver );
        actions.sendKeys ( Keys.ENTER )
                .pause ( 500 ); // Short pause between actions

        // Press BACK_SPACE based on text length
        for (int i = 0; i < textLength; i++) {
            actions.sendKeys ( Keys.BACK_SPACE );
        }

        // Press Enter again
        actions.sendKeys ( Keys.ENTER ).perform ();

        // Clicking The Course For Filter The Doubts
        int clickingCoursetwotimes = 2;

        for (int i = 0; i < clickingCoursetwotimes; i++) {

            try {
                sleep ( 5000 );
                WebElement clickingCourseForFilter = driver.findElement (xpath ("(//*[@class=\"doubt-left-sidebar-course-body\"])[2]"));
                clickingCourseForFilter.click ();
                System.out.println ("Course SuccessFully Clicked ");
            } catch (Exception Clicking) {
                System.out.println ("Course was Not Found");
            }
        }

        // Clicking The Subject In the Doubt Filter
        sleep ( 5000 );
        WebElement clickingSubject = driver.findElement (xpath ("//*[text() = 'Subjects']"));
        clickingSubject.click ();

        // Getting the text From The Filter and Verifying
        sleep ( 3000 );
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
            break;
        }
        System.out.println ("Total unique CourseName found: " + uniqueSubjectCourseCount);
        try {
            Assert.assertEquals ( "Verification Passed" + uniqueSubjectCourseCount , subjectcourseNames.length );
        } catch (AssertionError e) {
            System.out.println ( "Verification Failed, can't able to find the Course" );
        }
        System.out.println ("-------------------------------------------------------");

        // Clicking The Exams In The Doubt Filter..............
        sleep ( 5000 );
        WebElement clickingExamFilter = driver.findElement (xpath ("//*[text() = 'Exams']"));
        clickingExamFilter.click ();

        // Getting the text From The Exam Filter and Verifying
        sleep ( 5000 );
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
        sleep ( 5000 );

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


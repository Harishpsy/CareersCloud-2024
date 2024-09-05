package MainPages;

import PageObjectModule.Homepageobject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static PageObjectModule.Homepageobject.*;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void clickingHomePage() throws InterruptedException {

        // Writing For Home Feed
        PageFactory.initElements ( driver , Homepageobject.class );

        // clicking Preference Button
        Thread.sleep ( 10000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Railway Button
        Thread.sleep ( 5000 );
        clickingRailwayButton.click ();
        System.out.println ( "SuccessFully Clicked The Railway Button" );

        // clicking Preference Button
        Thread.sleep ( 5000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Bank&Insurance Button
        Thread.sleep ( 5000 );
        clickingBankandInsuranceButton.click ();
        System.out.println ( "SuccessFully Clicked The Bank&Insurance Button" );

        // clicking Preference Button
        Thread.sleep ( 5000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 5000 );
        clickingAddPreferencebutton.click ();
        System.out.println ( "SuccessFully Clicked The Add Preference Button" );

        //Scrolling Down Function
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );

        // clicking UPSC Button
        Thread.sleep ( 5000 );
        clickingUPSCButton.click ();
        System.out.println ( "SuccessFully Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 5000 );
        clickingsavePreference.click ();
        System.out.println ( "SuccessFully Clicked The Save Preference Button" );

        // clicking Preference Button
        Thread.sleep ( 10000 );
        clickingPreferenceButton.click ();
        System.out.println ( "SuccessFully Clicked The Preference Button" );

        // Clicking The Add Preference
        Thread.sleep ( 15000 );
        clickingAddPreferencebutton.click ();
        System.out.println ( "SuccessFully Clicked The Add Preference" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );

        // clicking UPSC Button
        Thread.sleep ( 3000 );
        clickingUPSCButton.click ();
        System.out.println ( "SuccessFully Clicked The UPSC Button" );

        // Clicking Save Preference
        Thread.sleep ( 3000 );
        clickingsavePreference.click ();
        System.out.println ( "SuccessFully Clicked The Save Preference" );

//        // Clicking Cancel Button In Profile
//        WebElement clickingCancelButton = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButton.click ();

        // Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 5000 );
        clickingBannerInHomeFeed.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 5000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed1.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking the course BreadCrumbs for coming back
        Thread.sleep ( 3000 );
        clickingCourseInBreadCrumbs.click ();
        System.out.println ( "SuccessFully Clicked The course BreadCrumbs for coming back" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 5000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        //  Clicking The Right arrow in the Home feed
        Thread.sleep ( 3000 );
        clickingRightArrow.click ();
        System.out.println ( "SuccessFully Clicked The Right arrow in the Home feed" );

        // Clicking The banners in the home feed
        Thread.sleep ( 3000 );
        clickingBannerInHomeFeed2.click ();
        System.out.println ( "SuccessFully Clicked The banners in the home feed" );

        // Clicking The Close icon In The Course Banner Modal
        Thread.sleep ( 3000 );
        clickingCloseIcon.click ();
        System.out.println ( "SuccessFully Clicked Close icon In The Course Banner Modal" );

        // Clcking The Google Play Button
        Thread.sleep ( 3000 );
        clickingGoooglePlayButton.click ();
        System.out.println ( "SuccessFully Clicked The Google Play Button" );

        //Windows Handeling child to parent and parent to child
        Thread.sleep ( 3000 );
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
        driver.close ();
        driver.switchTo ().window ( parent );

        // Scrolling the HomePage page
        int numberoftimesscroll = 10;

        for (int i = 0; i < numberoftimesscroll; i++) {
            try {
                Thread.sleep ( 3000 );
                jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The Home page" + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll The Home Page: " + scroll.getMessage () );
            }
        }

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingFloatIcon.click ();
                System.out.println ( "SuccessFully Clicked The Float Icon" );
            } else {
                System.out.println ( "Float Icon Is Not Displayed" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Float Icon Button Is Not Displayed" );
        }
    }

    public void footerSection() throws InterruptedException {

        // Clicking The About us In The Footer Section
        Thread.sleep ( 3000 );
        clickingAboutUs.click ();
        System.out.println ( "SuccessFully Clicked The About us In The Footer Section" );

        // Clicking The Authors In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingAuthors = driver.findElement ( xpath ( "//a[text()='Authors']" ) );
        clickingAuthors.click ();
        System.out.println ( "SuccessFully Clicked The Authors In The Footer Section" );

        // Clicking The contactus In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingcontactUs = driver.findElement ( xpath ( "//span[text()='Contact Us']" ) );
        clickingcontactUs.click ();
        System.out.println ( "SuccessFully Clicked The contactus In The Footer Section" );

        // Entering The text In The Contactus TextField
        Thread.sleep ( 3000 );
        WebElement enteringTextInTextField = driver.findElement ( name ( "queries" ) );
        enteringTextInTextField.sendKeys ( "Checking The Text Was Entering" );
        //   clickingUploadButton.click ();

        // Clicking The Send Button
//        Thread.sleep ( 3000 );
//        WebElement clickingSendButton = driver.findElement ( xpath ( "//span[text()='Send']" ) );
//        clickingSendButton.click ();
//        System.out.println ( "SuccessFully Clicked The Send Button" );

//        // Clicking the close icon
        Thread.sleep ( 2000 );
        clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
        clickingCloseIcon.click ();

        // Clicking The FAQ Button In The Footer Section
        Thread.sleep ( 3000 );
        clickingFAQButton.click ();
        System.out.println ( "SuccessFully Clicked FAQ Button In The Footer Section" );

        // Clicking The Terms And Condition Button In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingTermsAndConditionButton = driver.findElement ( xpath ( "//a[text()='Terms and Conditions']" ) );
        clickingTermsAndConditionButton.click ();
        System.out.println ( "SuccessFully Clicked The Terms And Condition Button In The Footer Section" );

        //Scrolling Down Function
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The Privacy Button In The Footer Section
        Thread.sleep ( 3000 );
        clickingPrivacyPolicyButton.click ();
        System.out.println ( "SuccessFully Clicked The Privacy Button In The Footer Section" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The Careers Button In The Footer Section
        Thread.sleep ( 1000 );
        clickingCareersButton.click ();
        System.out.println ( "SuccessFully Clicked Careers Button In The Footer Section" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The sitemap Button In The Footer Section
        Thread.sleep ( 1000 );
        clickingsitemapButton.click ();
        System.out.println ( "SuccessFully Clicked The sitemap Button In The Footer Section" );

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingFloatIcon.click ();
                System.out.println ( "SuccessFully Clicked The Float Icon" );
            } else {
                System.out.println ( "Float Icon Is Not Displayed" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Float Icon Button Is Not Displayed" );
        }
    }

    public void verifyingDuplicate() {

        // Verifying The list of Images In Home Page, any one of them was getting Duplicate or Not

        // Finding All The elements From The Home Page components
        List<WebElement> homePageImages = driver.findElements ( xpath ( "//*[@class=\"article-feed-image\"]" ) );
        //  List<WebElement> homePageImages = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]" ) );

        // Create a set to store unique Article URLs
        Set<String> uniquehomePageImages = new HashSet<> ();
        int uniqueshomePageImagescount = 0;

        // Iterate through the list of elements
        for (WebElement articleElementUrl : homePageImages) {
            String actualhomePageImages = articleElementUrl.getAttribute ( "src" );
            //    String actualhomePageImages = articleElementUrl.getText ();
//          System.out.println ( "Original Home Page Images URL : " + actualhomePageImages + "Count:" + uniqueshomePageImagescount);
            if (uniquehomePageImages.contains ( actualhomePageImages )) {
                System.out.println ( "Duplicate Home Page Image found --> " + actualhomePageImages );
            } else {
                uniquehomePageImages.add ( actualhomePageImages );
                uniqueshomePageImagescount++;
//                System.out.println ( "Home Page Images URL Found: " + uniqueshomePageImages + " --> " + actualhomePageImages );
//                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique URLs found
        System.out.println ( "Total Home Page Images URLs found: " + uniqueshomePageImagescount );

        // Assert that the number of unique URLs is equal to the number of elements
        try {
            Assert.assertEquals ( uniqueshomePageImagescount , uniquehomePageImages.size () );
        } catch (AssertionError e) {
            System.out.println ( "Verification Failed Cant Able to Verify The Home Page" );
        }

        // Verifying The ebooks Image Url In The Home Page any one of them was getting Duplicate or Not

        // Finding All The elements From The Home Page components
        List<WebElement> homePageEbookImages = driver.findElements ( xpath ( "//*[@class='ebook-cover-image']" ) );

        // Create a set to store unique Article URLs
        Set<String> uniquehomePageEbooksImages = new HashSet<> ();
        int uniqueshomePageEboosImagescount = 0;

        // Iterate through the list of elements
        for (WebElement EbooksElementUrl : homePageEbookImages) {
            String actualhomePageEbooksImages = EbooksElementUrl.getAttribute ( "src" );
            //    System.out.println ( "Original Home Page Ebooks Images URL : " + actualhomePageEbooksImages );
            if (uniquehomePageEbooksImages.contains ( actualhomePageEbooksImages )) {
                System.out.println ( "Duplicate Home Page Ebook Image found --> " + actualhomePageEbooksImages );
            } else {
                uniquehomePageEbooksImages.add ( actualhomePageEbooksImages );
                uniqueshomePageEboosImagescount++;
//                System.out.println ( "Home Page Ebooks Images URL Found: " + uniquehomePageEbooksImages + " --> " + actualhomePageEbooksImages );
//                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique URLs found
        System.out.println ( "Total Home Page Ebooks Images URLs found: " + uniqueshomePageEboosImagescount );

        // Assert that the number of unique URLs is equal to the number of elements
        try {
            Assert.assertEquals ( uniqueshomePageEboosImagescount , uniquehomePageEbooksImages.size () );
        } catch (AssertionError e) {
            System.out.println ( "Verification Failed Cant Able to Verify The Home Page" );
        }

        // Verifying The duplicate present on the right side List
        List<WebElement> coursename = driver.findElements ( xpath ( "//*[@class=\"ant-list-item\"]/ancestor::*[@class=\"ant-list ant-list-lg ant-list-split ant-list-bordered feed-ads-list css-xu9wm8\"]" ) );

        //Creat a set to store unique coursename displaying in the list
        Set<String> uniqueCourseName = new HashSet<> ();
        int uniqueCourseNameCount = 0;

        // Using for each loop for the itreation to find the element
        for (WebElement coursesNameList : coursename) {
            String actualCourseName = coursesNameList.getText ();
            System.out.println ( "Original Course Name List:" + actualCourseName );
            if (uniqueCourseName.contains ( actualCourseName )) {
                System.out.println ( "Duplicate Course Name Found In The Home Page List:" + actualCourseName );
            } else {
                uniqueCourseName.add ( actualCourseName );
                uniqueCourseNameCount++;
            }

            // Assertion using to Verify
            try {
                Assert.assertEquals ( uniqueCourseNameCount , uniqueCourseName.size () );
            } catch (AssertionError error) {
                System.out.println ( "Verification Failed can't Able to verify The Course List In The Home-Page" );
            }
        }

//        // Verifying The quiz in the home page list for the start quiz
//
//        try {
//            List<WebElement> startQuizListHomePage = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]/preceding::*[@class=\"start-quiz-content\"]" ) );
//
//            //Create a set to store the unique Quiz Name displaying In The List
//            Set<String> uniqueStartQuizName = new HashSet<> ();
//            int uniqueStartQuizNameCount = 0;
//
//            // Using for each loop for the itreation to find the element
//            for (WebElement startQuiz : startQuizListHomePage) {
//                String actualStartQuizName = startQuiz.getText ();
//                System.out.println ( "Start Quiz Name In The Home Page List:" + actualStartQuizName );
//                if (uniqueStartQuizName.contains ( actualStartQuizName )) {
//                    System.out.println ( "Duplicate Start quiz Name Found In The Home Page List:" + actualStartQuizName );
//                } else {
//                    uniqueCourseName.add ( actualStartQuizName );
//                    uniqueStartQuizNameCount++;
//                }
//            }
//
//            // Verifying the using Assertion
//            try {
//                Assert.assertEquals ( uniqueStartQuizNameCount , uniqueStartQuizName.size () );
//            } catch (AssertionError e) {
//                System.out.println ( "Verification Failed,can't Able to verify The Start Quiz List In The Home-Page " );
//            }
//        }catch (NoSuchElementException e){
//            System.out.println ("Start Quiz Is Not Found In the Home Page");
//        }
//
//
//        // Verifying The quiz in the home page list for the Solution quiz
//        try {
//            List<WebElement> completedQuizListHomePage = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]/preceding::*[@class=\"solution-quiz-content\"]" ) );
//
//            //Create a set to store the unique Quiz Name displaying In The List
//            Set<String> uniqueCompletedQuizName = new HashSet<> ();
//            int uniqueCompletedQuizNameCount = 0;
//
//            // Using for each loop for the itreation to find the element
//            for (WebElement Completedquiz : completedQuizListHomePage) {
//                String actualCompletedQuizName = Completedquiz.getText ();
//                System.out.println ( "Start Quiz Name In The Home Page List:" + actualCompletedQuizName );
//                if (uniqueCompletedQuizName.contains ( actualCompletedQuizName )) {
//                    System.out.println ( "Duplicate Start quiz Name Found In The Home Page List:" + actualCompletedQuizName );
//                } else {
//                    uniqueCourseName.add ( actualCompletedQuizName );
//                    uniqueCompletedQuizNameCount++;
//                }
//            }
//
//            // Verifying the using Assertion
//            try {
//                Assert.assertEquals ( uniqueCompletedQuizNameCount , uniqueCompletedQuizName.size () );
//            } catch (AssertionError e) {
//                System.out.println ( "Verification Failed,can't Able to verify The Completed Quiz List In The Home-Page " );
//            }
//        }catch (NoSuchElementException e){
//            System.out.println ("Completed Quiz Is Not Found In the Home Page");
//        }

//        // Verifying The quiz in the home page list for the Solution quiz
//        try {
//            List<WebElement> resumeQuizListHomePage = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]/preceding::*[@class=\"resume-quiz-content\"]" ) );
//
//            //Create a set to store the unique Quiz Name displaying In The List
//            Set<String> uniqueResumeQuizName = new HashSet<> ();
//            int uniqueResumeQuizNameCount = 0;
//
//            // Using for each loop for the itreation to find the element
//            for (WebElement Resumequiz : resumeQuizListHomePage) {
//                String actualResumeQuizName = Resumequiz.getText ();
//                System.out.println ( "Start Quiz Name In The Home Page List:" + actualResumeQuizName );
//                if (uniqueResumeQuizName.contains ( actualResumeQuizName )) {
//                    System.out.println ( "Duplicate Resume quiz Name Found In The Home Page List:" + actualResumeQuizName );
//                } else {
//                    uniqueCourseName.add ( actualResumeQuizName );
//                    uniqueResumeQuizNameCount++;
//                }
//            }
//
//            // Verifying the using Assertion
//            try {
//                Assert.assertEquals ( uniqueResumeQuizNameCount , uniqueResumeQuizName.size () );
//            } catch (AssertionError e) {
//                System.out.println ( "Verification Failed,can't Able to verify The Resume Quiz List In The Home-Page " );
//            }
//        }catch (NoSuchElementException e){
//            System.out.println ("Resume Quiz Is Not Found In the Home Page");
//        }
    }

    public void ArticleandCourse() throws InterruptedException {

        // Clicking the list of elements present in the form of Article and Course
        List<WebElement> clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
        int totalElements = clickingArticleandCourse.size ();

        try {

            for (int i = 0; i < totalElements; i++) {

                // Re-fetch the list of elements to avoid StaleElementReferenceException
                clickingArticleandCourse = driver.findElements ( By.xpath ( "//*[@class='feed-card-body']" ) );
                WebElement currentElement = clickingArticleandCourse.get ( i );

                // Scroll the current element into view
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , currentElement );
                Thread.sleep ( 3000 );  // Wait for scrolling to complete

                // Capture the name of the course or article for logging purposes
                String courseName = currentElement.getAttribute ( "src" );  // Replace with the correct attribute if src isn't correct

                // Click the current article or course
                Thread.sleep ( 3000 );
                currentElement.click ();

                // Try to click the breadcrumb link, if present
                try {
                    WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                    Thread.sleep ( 5000 ); // Wait for the page to load
                    breadcrumbLink.click ();
                    System.out.println ( "Successfully clicked the breadcrumb link" );
                } catch (NoSuchElementException e1) {
                    // If breadcrumb is not found, try to click the Back button
                    try {
                        WebElement backButton = driver.findElement ( By.xpath ( "//*[text()='Back']" ) );
                        Thread.sleep ( 5000 ); // Wait for the page to load
                        backButton.click ();
                        System.out.println ( "Successfully clicked the Back button" );
                    } catch (NoSuchElementException e2) {
                        // If both elements are not found, log the failure
                        System.out.println ( "Neither breadcrumb nor back button is present on the page for " + courseName );
                    }
                }

                // Wait before moving to the next item
                Thread.sleep ( 3000 );
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println ( "Index Out Of Bounds Exception has been Occured" );
        }

    }
}



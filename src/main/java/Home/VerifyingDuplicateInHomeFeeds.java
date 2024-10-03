package Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class VerifyingDuplicateInHomeFeeds {

    WebDriver driver;

    public VerifyingDuplicateInHomeFeeds(WebDriver driver) {
        this.driver = driver;
    }

    @Test
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


}

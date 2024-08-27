package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.openqa.selenium.By.*;


public class CourseArticle {
    WebDriver driver;

    public CourseArticle(WebDriver driver) {

        this.driver = driver;
    }

    public void Article() throws InterruptedException {

        // Clicking The Eigth Course Card In the My Course
        Thread.sleep ( 5000 );
        WebElement clickingFirstCourseCard = driver.findElement ( xpath ( "(//*[@class=\"ant-card-body\"])[8]" ) );
        clickingFirstCourseCard.click ();

        // Clicking The Article
        WebElement clickingArticleTab = driver.findElement ( xpath ( "//*[text()='Articles']" ) );
        clickingArticleTab.click ();

        int numberoftimesscrollarticle = 5;

        for (int i = 0; i < numberoftimesscrollarticle; i++) {
            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The page " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "(//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"])[2]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingFloatIcon.click ();
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "FloatIcon Button Is Not Displayed" );
        }

        // Verifying The list of Articles any one of them was getting Duplicate or Not

        // Finding All The elements From the Article components
        List<WebElement> allArticleName = driver.findElements ( xpath ( "//*[@class=\"ant-col column ant-col-xs-23 ant-col-sm-23 ant-col-md-23 ant-col-lg-23 ant-col-xl-23 ant-col-xxl-23 css-xu9wm8\"]" ) );

        // Create a set to store unique Article URLs
        Set<String> uniqueArticleUrl = new HashSet<> ();
        int uniquesArticleCount = 0;

        // Iterate through the list of elements
        for (WebElement articleElementUrl : allArticleName) {
            String actualArticleName = articleElementUrl.getText ();
            System.out.println ( "Original Article Name: " + actualArticleName );
            if (uniqueArticleUrl.contains ( actualArticleName )) {
                System.out.println ( "Duplicate Article found --> " + actualArticleName );
            } else {
                uniqueArticleUrl.add ( actualArticleName );
                uniquesArticleCount++;
                System.out.println ( "Article Found: " + uniquesArticleCount + " --> " + actualArticleName );
                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique URLs found
        System.out.println ( "Total unique image URLs found: " + uniquesArticleCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquesArticleCount , uniqueArticleUrl.size () );

        // Clicking the view Article
        Thread.sleep ( 5000 );
        WebElement clickingViewButton = driver.findElement ( xpath ( "//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]" ) );
        clickingViewButton.click ();
        System.out.println ( "Succesfully Clicked The View Article" );

        // Getting The Article Name To Verify In My Notes

        WebElement gettingArticleName = driver.findElement ( xpath ( "(//span[@class=\"ant-typography text css-xu9wm8\"])[1]" ) );
        String articleName = gettingArticleName.getText ();
        System.out.println ( "Article Name: " + articleName );

        // Clicking the like and unlike button
        Thread.sleep ( 5000 );
        WebElement clickAction = driver.findElement ( xpath ( "//*[contains(@class, 'like') or contains(@class, 'unlike')]" ) );

        if (clickAction.isDisplayed ()) {
            clickAction.click ();
            if (clickAction.getAttribute ( "class" ).contains ( "unlike" )) {
                System.out.println ( "Un Liked Successfully" );
            } else {
                System.out.println ( "Liked Successfully" );
            }
        }
        // Clicking The Comment Icon
        Thread.sleep ( 5000 );
        WebElement clickingCommentIcon = driver.findElement ( id ( "comments-icon" ) );
        clickingCommentIcon.click ();

        // Entering The comments
        Thread.sleep ( 5000 );
        WebElement enteringComments = driver.findElement ( name ( "comments1" ) );
        enteringComments.sendKeys ( "Thanks For the update" );
        System.out.println ( "Comment Added Sucessfully" );

//        // Clicking The send Button
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

        // Clicking Float button
        Thread.sleep ( 5000 );
        WebElement clickingFloatButton = driver.findElement ( xpath ( "//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]" ) );
        clickingFloatButton.click ();

        // Clicking the share icon
        Thread.sleep ( 3000 );
        WebElement clickingshareicon = driver.findElement ( xpath ( "//*[@class=\"share\"]" ) );
        clickingshareicon.click ();

        //click the copy link in the share popup
        Thread.sleep ( 3000 );
        WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        Thread.sleep ( 3000 );
        WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
        Cancel_button.click ();
        System.out.println ( "Clicked cancel button" );

        // Verifying the Recent article in the webpage
        List<WebElement> recentArticle = driver.findElements ( xpath ( "//*[@class=\"ant-list-items\"]/child::*" ) );

        // Create a set to store unique URLs
        Set<String> uniquerecentArticleUrls = new HashSet<> ();
        int uniquerecentArticlelCount = 0;

        for (WebElement articles : recentArticle) {
            String actuarecentArticlelLink = articles.getAttribute ( "href" );
            System.out.println ( "Original Recent Article Link: " + actuarecentArticlelLink );

            if (uniquerecentArticleUrls.contains ( actuarecentArticlelLink )) {
                uniquerecentArticlelCount++;
                System.out.println ( "Duplicate found --> " + actuarecentArticlelLink );
            } else {
                uniquerecentArticleUrls.add ( actuarecentArticlelLink );
                uniquerecentArticlelCount++;
                System.out.println ( "Article Found: " + uniquerecentArticlelCount + " --> " + actuarecentArticlelLink );
                System.out.println ( "-------------------------------------------------------------------------" );
            }
        }

        // Print the total number of unique URLs found
        System.out.println ( "Total unique Article Name found: " + uniquerecentArticlelCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquerecentArticlelCount , uniquerecentArticleUrls.size () );

        // Click the BackButton In The Article
        Thread.sleep ( 5000 );
        WebElement clickingBackButton = driver.findElement ( xpath ( "//*[@class=\"ant-breadcrumb-link\"]" ) );
        clickingBackButton.click ();
        System.out.println ( "Navigated To Article List Page" );

        // Clicking the three Dots in the CourseCard
        Thread.sleep ( 5000 );
        WebElement clickingThreeDots = driver.findElement ( xpath ( "//*[@class=\"anticon anticon-more\"]" ) );
        clickingThreeDots.click ();

        // Clicking The save My Notes or Remove my notes
        Thread.sleep ( 5000 );
        WebElement clickMyNote = driver.findElement ( xpath ( "//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]" ) );

        if (clickMyNote.isDisplayed ()) {
            clickMyNote.click ();
            if (clickMyNote.getText ().contains ( "Remove My  Notes" )) {
                System.out.println ( "Successfully -  Remove - Article" );
            } else {
                System.out.println ( "Successfully -  saved - Article" );
            }
        }

        // Clicking The home button
        Thread.sleep ( 3000 );
        WebElement clickingHomeButton = driver.findElement ( xpath ( "//*[text()='Home']" ) );
        clickingHomeButton.click ();
        System.out.println ( "SuccessFully Clicked The HomeButton" );

        // Clicking The MyNotes
        Thread.sleep ( 5000 );
        WebElement clickingMyNotes = driver.findElement ( xpath ( "//*[@id=\"1\"]" ) );
        clickingMyNotes.click ();
        System.out.println ( "SuccessFully Clicked The My-Notes" );

        // Verifying saved or removed article was showing in the My Notes Page

        List<WebElement> articleMyNotes = driver.findElements ( xpath ( "//*[@class=\"feed-card-cover-inner-content\"]" ) );

        boolean articleFound = false;

        for (WebElement Article : articleMyNotes) {
            String articlenameInMyNotes = Article.getText ();
            System.out.println ( "Article Name In My Notes: " + articlenameInMyNotes );

            if (articleName.equals ( articlenameInMyNotes )) {
                System.out.println ( "Verification Passed: Article Title (" + articleName + ") matches Article In My Notes (" + articlenameInMyNotes + ")" );
                articleFound = true;
            } else {
                System.out.println ( "Article Name Does Not Match" );
            }
        }
        if (!articleFound) {
            System.out.println ( "Article Is Not Showing In The My Notes" );
        }

    }
}



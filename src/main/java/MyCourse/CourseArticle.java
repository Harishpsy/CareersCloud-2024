package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;


public class CourseArticle {
    WebDriver driver;

    public CourseArticle(WebDriver driver) {

        this.driver = driver;
    }

    public void Article() throws InterruptedException {

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (5000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        WebElement clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        int numberoftimesscrollarticle = 5;

        for (int i = 0; i < numberoftimesscrollarticle; i++) {
            try {
                Thread.sleep (5000);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
                System.out.println ("Successfully scroll The page " + (i + 1) + " time(s).");
            } catch (Exception scroll) {
                System.out.println ("Failed to Scroll : " + scroll.getMessage ());
            }
        }

        // clicking the Float button

        Thread.sleep (5000);
        WebElement clickingFloatButton = driver.findElement (xpath ("(//*[@class=\"ant-float-btn-body\"])[2]"));
        clickingFloatButton.click ();

        // Verifying The list of Articles any one of them was getting Duplicate or Not

        // Finding All The elements From the Article components

        List<WebElement> allArticleUrl = driver.findElements (xpath ("//*[@class=\"image1\"]"));

        // Create a set to store unique Article URLs

        Set<String> uniqueArticleUrl = new HashSet<> ();
        int uniquesArticleUrlCount = 0;

        // Iterate through the list of elements

        for (WebElement articleElementUrl : allArticleUrl) {

            String actualArticleImageUrl = articleElementUrl.getAttribute ("src");
            System.out.println (actualArticleImageUrl);

            if (uniqueArticleUrl.contains (actualArticleImageUrl)) {
                System.out.println ("Duplicate found --> " + actualArticleImageUrl);

            } else {

                uniqueArticleUrl.add (actualArticleImageUrl);
                uniquesArticleUrlCount++;
                System.out.println ("Found: " + uniquesArticleUrlCount + " --> " + actualArticleImageUrl);
                System.out.println ("-------------------------------------------------------------------------");

            }

        }

        // Print the total number of unique URLs found
        System.out.println ("Total unique image URLs found: " + uniquesArticleUrlCount);

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals (uniquesArticleUrlCount, uniqueArticleUrl.size ());


        // Clicking the three Dots in the CourseCard

        Thread.sleep (5000);
        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        clickingThreeDots.click ();

        // Clicking The save My Notes or Remove my notes

        Thread.sleep (5000);
        WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));

        if (clickMyNote.isDisplayed ()) {
            clickMyNote.click ();

            if (clickMyNote.getText ().contains ("Remove My  Notes")) {
                System.out.println ("Successfully -  Remove - Article");
            } else {
                System.out.println ("Successfully -  saved - Article");
            }
        }

        // Clicking The home button

        Thread.sleep (3000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//*[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The MyNotes

        Thread.sleep (5000);
        WebElement clickingMyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
        clickingMyNotes.click ();

        // Verifying the article in my notes By using If Else Statement

        Thread.sleep (5000);
        final List<WebElement> savedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));
        // Verification (assuming you have a way to verify card existence)

        if (savedarticle.isEmpty ()) {

            Thread.sleep (5000);
            System.out.println ("Verification Failed : Article not present ");

        } else {
            Thread.sleep (5000);
            System.out.println ("Verification Passed: 'Article present...' cards.");
        }

        // Clicking The My Course Button

        Thread.sleep (5000);
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (5000);
        clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        Thread.sleep (5000);
        clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        // Clicking the view Article

        Thread.sleep (5000);
        WebElement clickingViewButton = driver.findElement (xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]"));
        clickingViewButton.click ();

        // Clicking the like and unlike button

        Thread.sleep (5000);
        WebElement clickAction = driver.findElement (xpath ("//*[contains(@class, 'like') or contains(@class, 'unlike')]"));

        if (clickAction.isDisplayed ()) {
            clickAction.click ();


            if (clickAction.getAttribute ("class").contains ("unlike")) {
                System.out.println (" Un Liked Successfully ");
            } else {
                System.out.println (" Liked Successfully ");
            }
        }

        // Clicking The Comment Icon

        Thread.sleep (5000);
        WebElement clickingCommentIcon = driver.findElement (id ("comments-icon"));
        clickingCommentIcon.click ();

        // Entering The comments

        Thread.sleep (5000);
        WebElement enteringComments = driver.findElement (name ("comments1"));
        enteringComments.sendKeys ("Thanks For the update");
        System.out.println ("Comment Added Sucessfully");

//        // Clicking The send Button
//
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

        // Clicking Float button

        Thread.sleep (5000);
        clickingFloatButton = driver.findElement (xpath ("//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]"));
        clickingFloatButton.click ();

        // Clicking the share icon

        Thread.sleep (3000);
        WebElement clickingshareicon = driver.findElement (xpath ("//*[@class=\"share\"]"));
        clickingshareicon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        Thread.sleep (3000);
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();
        System.out.println ("Clicked cancel button");

        // Verifying the Recent article in the webpage

        List<WebElement> recentArticle = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));

        // Create a set to store unique URLs

        Set<String> uniquerecentArticleUrls = new HashSet<> ();
        int uniquerecentArticlelCount = 0;

        for (WebElement articles : recentArticle) {
            String actuarecentArticlelLink = articles.getAttribute ("href");
            System.out.println (actuarecentArticlelLink);

            if (uniquerecentArticleUrls.contains (actuarecentArticlelLink)) {
                uniquerecentArticlelCount++;
                System.out.println ("Duplicate found --> " + actuarecentArticlelLink);
            } else {
                uniquerecentArticleUrls.add (actuarecentArticlelLink);
                uniquerecentArticlelCount++;
                System.out.println ("Found: " + uniquerecentArticlelCount + " --> " + actuarecentArticlelLink);
                System.out.println ("-------------------------------------------------------------------------");
            }
        }

        // Print the total number of unique URLs found
        System.out.println ("Total unique image URLs found: " + uniquerecentArticlelCount);

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals (uniquerecentArticlelCount, uniquerecentArticleUrls.size ());

        // Click the BackButton In The Article

        Thread.sleep (5000);
        WebElement clickingBackButton = driver.findElement (xpath ("//*[@class=\"ant-breadcrumb-link\"]"));
        clickingBackButton.click ();
        System.out.println ("Navigated To Article List Page");

    }

}


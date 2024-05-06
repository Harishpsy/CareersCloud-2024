package MyCourse;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

        // Clcking Course

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        WebElement clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        // Find elements using either XPath or loop through individual cards

        final List<WebElement> mainsCards = driver.findElements (xpath ("//*[text()='GA Questions Asked in SBI Clerk Mains Exam 2023 - 2024']"));
        final List<WebElement> prelimsCards = driver.findElements (xpath ("//*[text()='SBI Clerk Prelims Exam 2023 Quants - Self Analysis']"));

        // Verification (assuming you have a way to verify card existence)

        if (mainsCards.isEmpty ()) {
            System.out.println ("Verification failed: 'GA Questions...' cards not found.");
        } else {
            System.out.println ("Found 'GA Questions...' cards.");
        }

        if (prelimsCards.isEmpty ()) {
            System.out.println ("Verification failed: 'SBI Clerk Prelims...' cards not found.");
        } else {
            System.out.println ("Found 'SBI Clerk Prelims...' cards.");
        }

        //  Method for Counting How many Cards present in the list


//        List<WebElement> articleCards = new ArrayList<> ();
//
//        // Add elements using either XPath or loop through individual cards
//
//        articleCards.addAll(driver.findElements(xpath("//*[text()='GA Questions Asked in SBI Clerk Mains Exam 2023 - 2024']")));
//        articleCards.addAll(driver.findElements(xpath("//*[text()='SBI Clerk Prelims Exam 2023 Quants - Self Analysis']")));
//
//        // Verification (assuming you have a way to verify the expected number of cards)
//
//        int expectedCards = 10; // Replace with your expected number
//        if (articleCards.size() == expectedCards) {
//            System.out.println("List of article cards verified. Found " + articleCards.size() + " cards.");
//        } else {
//            System.out.println("List verification failed. Expected " + expectedCards + ", found " + articleCards.size() + " cards.");
//        }

        // Clicking the three Dots in the CourseCard

        Thread.sleep (3000);
        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        clickingThreeDots.click ();

        // Clicking The save My Notes or Remove my notes

        Thread.sleep (3000);
        WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));

        if (clickMyNote.isDisplayed ()) {
            clickMyNote.click ();

            if (clickMyNote.getText ().contains ("Remove My  Notes")) {
                System.out.println ("Successfully - Removed - Article");
            } else {
                System.out.println ("Successfully - Saved - Article");
            }
        }

        // Clicking The home button

        Thread.sleep (3000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//*[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The MyNotes

        Thread.sleep (3000);
        WebElement clickingMyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
        clickingMyNotes.click ();

        // Verifying the article in my notes

        final List<WebElement> savedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));

        // Verification (assuming you have a way to verify card existence)

        if (savedarticle.isEmpty ()) {

            System.out.println ("Verification failed: 'Article was not present...' cards not found.");

        } else {

            System.out.println ("Verification Passed: 'Article present...' cards.");
        }

//        final List<WebElement> savedArticle = driver.findElements (xpath ("//img[@src='https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp']"));
//
//        // Verification (using assertion)
//
//        Assert.assertEquals (savedArticle.isEmpty (), "Verification failed: 'Article was not present...' ");
//        System.out.println ("Verification Passed: 'Article present...'.");

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (3000);
        clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        Thread.sleep (3000);
        clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        // Clicking the view Article

        Thread.sleep (3000);
        WebElement clickingViewButton = driver.findElement (xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-ghost ant-btn-block card-view-button\"]"));
        clickingViewButton.click ();

        // Clicking the like and unlike button

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

        WebElement clickingCommentIcon = driver.findElement (id ("comments-icon"));
        clickingCommentIcon.click ();

        // Entering The comments

        Thread.sleep (3000);
        WebElement enteringComments = driver.findElement (name ("comments1"));
        enteringComments.sendKeys ("Thanks For the update");
        System.out.println ("Comment Added Sucessfully");

        // Clicking The send Button

        Thread.sleep (3000);
        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
        clickingSendButton.click ();

        // Clicking Float button

        WebElement clickingFloatButton = driver.findElement (xpath ("//*[@class=\"css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle\"]"));
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

        // Verifying the Recent article

        String[] articleLinks = {"/course-details/62/article/3758", "/course-details/62/article/3586", "/course-details/62/article/3557", "/course-details/62/article/3510", "/course-details/62/article/3408"};

        List<WebElement> recentArticle = driver.findElements (tagName ("a"));

        int count = 2;

        for (WebElement recentArticles : recentArticle) {

            String actuallinks = recentArticles.getAttribute ("href");

            if (Arrays.asList (articleLinks).contains (actuallinks)) {
                count++;
                System.out.println ("All the article was present");
            }
        }
        Assert.assertEquals (count, articleLinks.length);


























    }
}

package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


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

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        WebElement clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        // Scrolling the page down

        Thread.sleep (3000);
        JavascriptExecutor scrollpage = (JavascriptExecutor) driver;
        scrollpage.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Again Scrolling the page down

        Thread.sleep (3000);
        scrollpage = (JavascriptExecutor) driver;
        scrollpage.executeScript ("window.scrollTo(0, document.body.scrollHeight)");

        // Scrolling the page Up
        JavascriptExecutor scrollpageup = (JavascriptExecutor) driver;
        scrollpageup.executeScript ("window.scrollTo(0,0)");

        // Verifying The List Of cards was getting duplicating or not

        String[] ArticleCards = {"https://assets.careerscloud.in/course/article/images/c2113c87210d2718aa625f9197817216.webp", "https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp", "https://assets.careerscloud.in/course/article/images/fcb6c606cdafa519a1890771f57edf4a.webp", "https://assets.careerscloud.in/course/article/images/5e04b7cd2e3ea898c0b2edc7841c1328.webp"
                , "https://assets.careerscloud.in/course/article/images/ec428c6a121667134eb7cbacf3f67351.webp", "https://assets.careerscloud.in/course/article/images/69109f10b2cdaccc9216126292b8dfc8.webp",
                "https://assets.careerscloud.in/course/article/images/208645246de3c6b62587a5889727bc2c.webp", "https://assets.careerscloud.in/course/article/images/db144ac76bb53fcc90d528a249058a81.webp", "https://assets.careerscloud.in/course/article/images/45edfb09904144471d389f54c6981130.webp", "https://assets.careerscloud.in/course/article/images/6f8fdf6e275c0b45a38b8311a1046f1e.webp",
                "https://assets.careerscloud.in/course/article/images/8f0ddd398a23ff67aaaf7901ff57178e.webp", "https://assets.careerscloud.in/course/article/images/81d1c8d42093f4ce19865393244be820.webp", "https://assets.careerscloud.in/course/article/images/2605d1cb4009d6b46b67e43ad9a14716.webp", "https://assets.careerscloud.in/course/article/images/9a2c5d7a0de5558f4a188fc2de80ff67.webp", "https://assets.careerscloud.in/course/article/images/a03f53d18b2a19db6670f5f8b6e82e98.webp",
                "https://assets.careerscloud.in/course/article/images/a06b2e3280a30d220fd4a980b609d2e5.webp", "https://assets.careerscloud.in/course/article/images/0f9a885a59c4a53681eb105292bdb363.webp", "https://assets.careerscloud.in/course/article/images/004c5ade5b2a7abe38d0ec44ceccb84d.webp", "https://assets.careerscloud.in/course/article/images/6f6bfbf577c47f2316e4165ee6835cc6.webp", "https://assets.careerscloud.in/course/article/images/a7eb552df57b919497e393719a12c008.webp", "https://assets.careerscloud.in/course/article/images/75ec2c4316f41d5f84d1d6c96d081351.webp"
                , "https://assets.careerscloud.in/course/article/images/78268628278d369c26a41dd436f34a0d.webp", "https://assets.careerscloud.in/course/article/images/72156b53494b9dfcfb078716d9ab5e3f.webp", "https://assets.careerscloud.in/course/article/images/366cffd43f6b57f04155ff8930915e28.webp", "https://assets.careerscloud.in/course/article/images/ba32bf2b87841c62ee246be7dea7a15b.webp"
                , "https://assets.careerscloud.in/course/article/images/f5408475fe1ce28d3e2642ba22b54cf8.webp",
                "https://assets.careerscloud.in/course/article/images/72b58e715eed7a3f53d2097bb8b5aa60.webp",
                "https://assets.careerscloud.in/course/article/images/60fd1bdd78f50382f6f356d083d8576a.webp",
                "https://assets.careerscloud.in/course/article/images/2ec8bbd7f0becbc4caf5ad74dafe21d8.webp",
                "https://assets.careerscloud.in/course/article/images/4545ffbebb564275db8bd767cac9a4f7.webp"
        };

        List<WebElement> ArticleCard = driver.findElements (xpath ("//*[@class=\"image1\"]"));

        int cardscount = 0;

        for (WebElement Card : ArticleCard) {

            String Actualcard = Card.getAttribute ("src");

            //To cross verify I have written the sop statement below

            System.out.println (Actualcard);

            if (Arrays.asList (ArticleCards).contains (Actualcard)) {
                cardscount++;
                System.out.println ("Found " + cardscount + Actualcard);
            }
        }
        Assert.assertEquals (cardscount, ArticleCards.length);

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

        Thread.sleep (3000);
        WebElement clickingMyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
        clickingMyNotes.click ();

        // Verifying the article in my notes By using If Else Statement

        final List<WebElement> savedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));

        // Verification (assuming you have a way to verify card existence)

        if (savedarticle.isEmpty ()) {

            System.out.println ("Verification Failed : Article not present ");

        } else {

            System.out.println ("Verification Passed: 'Article present...' cards.");
        }

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
//
//        // Entering The comments
//
//        Thread.sleep (3000);
//        WebElement enteringComments = driver.findElement (name ("comments1"));
//        enteringComments.sendKeys ("Thanks For the update");
//        System.out.println ("Comment Added Sucessfully");
//
//        // Clicking The send Button
//
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-send\"]"));
//        clickingSendButton.click ();

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

        // Verifying the Recent article in the webpage

        String[] articleLinks = {"https://careerscloud.in/course-details/62/article/3758", "https://careerscloud.in/course-details/62/article/3586", "https://careerscloud.in/course-details/62/article/3557", "https://careerscloud.in/course-details/62/article/3510", "https://careerscloud.in/course-details/62/article/3408"};

        List<WebElement> recentArticle = driver.findElements (xpath ("//*[@class=\"ant-list-items\"]/child::*"));

        int count = 0;

        for (WebElement articles : recentArticle) {

            String actualLink = articles.getAttribute ("href");

            // WE Can Write the sop for cross verify

            System.out.println (actualLink);

            if (Arrays.asList (articleLinks).contains (actualLink)) {
                count++;
                System.out.println ("Found " + count + actualLink);
            }
        }

        Assert.assertEquals (count, articleLinks.length);
//        System.out.println (Arrays.toString (articleLinks));


        // Click the BackButton In The Article

        WebElement clickingBackButton = driver.findElement (xpath ("//*[@class=\"ant-breadcrumb-link\"]"));
        clickingBackButton.click ();
        System.out.println ("Navigated To Article List Page");

    }

}


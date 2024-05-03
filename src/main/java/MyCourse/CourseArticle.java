package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

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

        // Clcking Course

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        WebElement clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

//       // Find elements using either XPath or loop through individual cards
//
//       final List<WebElement> mainsCards = driver.findElements(xpath("//*[text()='GA Questions Asked in SBI Clerk Mains Exam 2023 - 2024']"));
//       final List<WebElement> prelimsCards = driver.findElements(xpath("//*[text()='SBI Clerk Prelims Exam 2023 Quants - Self Analysis']"));
//
//      // Verification (assuming you have a way to verify card existence)
//
//        if (mainsCards.isEmpty()) {
//            System.out.println("Verification failed: 'GA Questions...' cards not found.");
//        } else {
//            System.out.println("Found 'GA Questions...' cards.");
//        }
//
//        if (prelimsCards.isEmpty()) {
//            System.out.println("Verification failed: 'SBI Clerk Prelims...' cards not found.");
//        } else {
//            System.out.println("Found 'SBI Clerk Prelims...' cards.");
//        }

        //  Method for Counting How many Cards present


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

        WebElement clickingThreeDots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        clickingThreeDots.click ();

        // Clicing The save My Notes

        Thread.sleep (3000);
        WebElement clickingSaveMyNotes = driver.findElement (xpath ("//*[text()='Save to My Notes']"));
        clickingSaveMyNotes.click ();
        System.out.println ("Sucessfully - Saved - Article");

//
//        WebElement SaveMynotes = driver.findElement (xpath ("//*[text()='Save to My Notes']"));
//
//
//        if (SaveMynotes.isDisplayed())
//        {
//            SaveMynotes.click ();
//            System.out.println("Verification paused: Sucessfully clicked SaveMyNotes.");
//        }
//     else
//        {
//            WebElement clickingRemoveMyNotes = driver.findElement (xpath ("//*[text()='Remove My  Notes']"));
//            clickingRemoveMyNotes.click ();
//            System.out.println("Verification Failed: Both Not Clicked.");
//
//        }

        // Clicking The home button

        WebElement clickingHomeButton = driver.findElement (xpath ("//*[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The MyNotes

        WebElement clickingMyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
        clickingMyNotes.click ();

        // Verifying the saved Notes was showing in MyNotes page

        final List<WebElement> savedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));

        // Verification (assuming you have a way to verify card existence)

        if (savedarticle.isEmpty ()) {
            System.out.println ("Verification failed: 'Article was not present...' cards not found.");
        } else {
            System.out.println ("Verification Passed:  'Article present...' cards.");
        }

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clcking Course

        // Clicking The Eigth Course Card In the My Course

        Thread.sleep (3000);
        clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[8]"));
        clickingFirstCourseCard.click ();

        // Clicking The Article

        clickingArticleTab = driver.findElement (xpath ("//*[text()='Articles']"));
        clickingArticleTab.click ();

        // Clicking the three Dots in the CourseCard

        clickingThreeDots = driver.findElement (xpath ("//*[@class=\"anticon anticon-more\"]"));
        clickingThreeDots.click ();

        // Clicing The Remove My Notes

        Thread.sleep (3000);
        WebElement clickingRemoveMyNotes = driver.findElement (xpath ("//*[text()='Remove My  Notes']"));
        clickingRemoveMyNotes.click ();
        System.out.println ("Sucessfully - Removed - Article");

        // Clicking The home button

        clickingHomeButton = driver.findElement (xpath ("//*[text()='Home']"));
        clickingHomeButton.click ();

        // Clicking The MyNotes

        clickingMyNotes = driver.findElement (xpath ("//*[@id=\"1\"]"));
        clickingMyNotes.click ();

        // Verifying the Article Removed Notes was showing in MyNotes page

        final List<WebElement> Removedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));

        // Verification (assuming you have a way to verify card existence)

        if (Removedarticle.isEmpty ()) {
            System.out.println ("Verification failed: 'Article was not present...' cards not found.");
        } else {
            System.out.println ("Verification Passed:  'Article present...' cards.");
        }




























    }
}

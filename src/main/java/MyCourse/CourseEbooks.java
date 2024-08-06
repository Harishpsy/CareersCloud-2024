package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class CourseEbooks {
    WebDriver driver;

    public CourseEbooks(WebDriver driver) {
        this.driver = driver;
    }

    public void Ebooks() throws InterruptedException {

        // Clicking The Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[2]"));
        clickingCourseCard.click ();

        // Clicking the Ebooks

        Thread.sleep (3000);
        WebElement clickingEbooksTab = driver.findElement (xpath ("//*[text()='Ebooks']"));
        clickingEbooksTab.click ();

        int numberOfTimesScrollEbooks = 10;

        for (int i = 0; i < numberOfTimesScrollEbooks; i++) {
            try {
                Thread.sleep (5000);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");
                System.out.println ("Successfully scroll The page " + (i + 1) + " time(s).");
            } catch (Exception scroll) {
                System.out.println ("Failed to Scroll : " + scroll.getMessage ());
            }
        }

        // Clicking Float Icon

        WebElement clickingFloatIcon = driver.findElement (xpath ("//*[@class=\"ant-float-btn-body\"]"));
        clickingFloatIcon.click ();

        // Verifying Weather There is Duplicate was find in the Ebooks or not

        List<WebElement> ebookTitle = driver.findElements (xpath ("//*[@class=\"ant-row ant-row-middle nowrap-content css-xu9wm8\"]"));

        // Create a set to store unique Ebook Titles

        Set<String> uniqueTitleName = new HashSet<> ();
        int ebookTitleCount = 0;

        // Iterate through the list of elements

        for (WebElement ebooksTitleName : ebookTitle) {

            String actualEbookTitle = ebooksTitleName.getText ();
            System.out.println (actualEbookTitle);

            if (uniqueTitleName.contains (actualEbookTitle)) {
                System.out.println ("Duplicate Found ---> " + actualEbookTitle);

            } else {

                uniqueTitleName.add (actualEbookTitle);
                ebookTitleCount++;
                System.out.println ("Found: " + ebookTitleCount + " --> " + actualEbookTitle);
                System.out.println ("-------------------------------------------------------------------------");
            }

            // Print the total number of unique URLs found
            System.out.println ("Total unique Ebook Titles found: " + ebookTitleCount);

            // Assert that the number of unique URLs is equal to the number of elements
            Assert.assertEquals (ebookTitleCount, uniqueTitleName.size ());
        }

        // Clicking The Three dots

        Thread.sleep (3000);
        WebElement Threedots = driver.findElement (xpath ("(//*[@class=\"ant-dropdown-trigger\"])[2]"));
        Threedots.click ();

        /* Clicking the share icon in My Ebook */

        Thread.sleep (3000);
        WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        WebElement Three_dots = driver.findElement (xpath ("(//*[@class=\"ant-dropdown-trigger\"])[2]"));
        Three_dots.click ();

        //clicking the report icon

        Thread.sleep (3000);
        WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
        Report_icon.click ();
        System.out.println ("SuccessFully Clicked The Report icon");

        //Click the wrong information radio button

        Thread.sleep (3000);
        WebElement Wronginformationradiobutton = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wronginformationradiobutton.click ();
        System.out.println ("SuccessFully Clicked The Wrong information radio button");


        //Entering the text inside the report text field

        WebElement Enterthereport = driver.findElement (name ("reportDescription"));
        Enterthereport.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        /* Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button

        Thread.sleep (3000);
        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();
        System.out.println ("SuccessFully Clicked The Cancel Button");

        // Clicking The View Button

        Thread.sleep (3000);
        WebElement clickingViewButton = driver.findElement (xpath ("//*[text()='VIEW >']"));
        clickingViewButton.click ();
        System.out.println ("SuccessFully Clicked The view Button");

//
//        WebElement clickingLikeButton = driver.findElement(xpath("//*[@class=\"like\"]"));
//        WebElement clickingunlikeButton = driver.findElement(xpath("//*[@class=\"unlike\"]"));
//
//        if (clickingLikeButton.getText().contains("like")) {
//
//            // Clicking Like Button
//            clickingLikeButton.click();
//            System.out.println("Liked");
//
//        }
//
//        else if (clickingLikeButton.getText().contains("unlike")){
//
//            // Clicking Unlike Button
//            clickingunlikeButton.click();
//            System.out.println("Un-Liked");
//
//        }
//        else {
//            System.out.println("Both is not presented");
//
//        }


        // Clicking The View Button In The Ebook

        Thread.sleep (3000);
        WebElement clickingViewButtonInEbook = driver.findElement (xpath ("//span[text()='View']"));
        clickingViewButtonInEbook.click ();
        System.out.println ("SuccessFully Clicked The View Button In Ebook ");

        //Windows Handeling child to parent

        Thread.sleep (5000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Clicking Back Button in the Ebook Page

        Thread.sleep (5000);
        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();
        System.out.println ("SuccessFully Clicked The BackButton ");

        // Clicking The Breadcrumbs

        Thread.sleep (5000);
        WebElement clickingBreadCrumbs = driver.findElement (xpath ("//*[text()='Course']"));
        clickingBreadCrumbs.click ();
        System.out.println ("SuccessFully Clicked The Bread crumbs and navigated to the My Course List Page");

    }
}

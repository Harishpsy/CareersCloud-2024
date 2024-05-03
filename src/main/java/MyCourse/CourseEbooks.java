package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class CourseEbooks {
    WebDriver driver;

    public CourseEbooks(WebDriver driver) {

        this.driver = driver;

    }

    public void Ebooks() throws InterruptedException {

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The First Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[1]"));
        clickingFirstCourseCard.click ();

        // Clicking the Ebooks

        Thread.sleep (3000);
        WebElement clickingEbooksTab = driver.findElement (xpath ("//*[text()='Ebooks']"));
        clickingEbooksTab.click ();

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

        Thread.sleep (3000);
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

        //Click the wrong information radio button

        Thread.sleep (3000);
        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        /* Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();

        // Clicking The View Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingViewButton = driver.findElement (xpath ("//*[text()='VIEW >']"));
        clickingViewButton.click ();
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

        WebElement clickingViewButtonInEbook = driver.findElement (xpath ("//span[text()='View']"));
        clickingViewButtonInEbook.click ();

        //Windows Handeling child to parent

        Thread.sleep (3000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        // Clicking Back Button in the Ebook Page

        Thread.sleep (3000);
        driver.switchTo ().window (parent);
        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();



    }
}

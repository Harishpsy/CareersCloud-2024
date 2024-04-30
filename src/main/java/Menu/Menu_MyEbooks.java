package Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Menu_MyEbooks {
    WebDriver driver;

    public Menu_MyEbooks(WebDriver driver) {
        this.driver = driver;
        // PageFactory.initElements (driver.this);
    }

    public void MyEbooks() throws InterruptedException {

        // Clicking My ebooks
        Thread.sleep (5000);
        WebElement clickingTheMyEbooks = driver.findElement (xpath ("//*[@id=\"3\"]"));
        clickingTheMyEbooks.click ();

        // Click the three dots in the My Ebook

        Thread.sleep (5000);
        WebElement Threedots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Threedots.click ();

//        //Clicking the remove My ebook icon in dropdown
//
//        Thread.sleep (3000);
//        WebElement Remove_My_ebook = driver.findElement (xpath ("//span[text()='Remove My  Ebook']"));
//        Remove_My_ebook.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        WebElement Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Three_dots.click ();

        /* Clicking the share icon in My Ebook */

        Thread.sleep (3000);
        WebElement Share_icon = driver.findElement (xpath ("//span[text()='Share']"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        Three_dots = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        Three_dots.click ();

        //clicking the report icon

        Thread.sleep (1000);
        WebElement Report_icon = driver.findElement (xpath ("//span[text()='Report']"));
        Report_icon.click ();

        //Click the wrong information radio button

        Thread.sleep (1000);
        WebElement Wrong_information_radio_button = driver.findElement (xpath ("//span[text()='Wrong Information']"));
        Wrong_information_radio_button.click ();

        //Entering the text inside the report text field

        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        /*WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();

        //Clicking the Course name in My ebook Card

        Thread.sleep (3000);
        WebElement Clicking_Course_Name = driver.findElement (xpath ("//*[@class=\"anticon anticon-right right-arrow-icon\"]"));
        Clicking_Course_Name.click ();

        //Clicking the breadcrums to navigate backward to My ebook page

        Thread.sleep (3000);
        WebElement Clicking_Course_breadcrums = driver.findElement (xpath ("//span[text()='Course']"));
        Clicking_Course_breadcrums.click ();

        // Clicking the like button

        Thread.sleep (3000);
        WebElement Like_button = driver.findElement (xpath ("//*[@class=\"feed-card-footer-like-icon\"]"));
        Like_button.click ();

        // ClickingTheLikesButton

        WebElement clickingUnlikeButton = driver.findElement (xpath ("//span[text()='Likes']"));
        clickingUnlikeButton.click ();

        // Clicking The Ebook

        WebElement clickingEbook = driver.findElement (xpath ("//*[@class=\"ebook-cover-image-container\"]"));
        clickingEbook.click ();

//        // Clicking UnLike Button
//
//        Thread.sleep (3000);
//        WebElement clickingLikeButton = driver.findElement (xpath ("//*[@class=\"unlike\"]"));
//        clickingLikeButton.click ();

        // Clicking Comment Icon

        Thread.sleep (3000);
        WebElement clickingCommentIcon = driver.findElement (xpath ("//*[@id=\"comments-icon\"]"));
        clickingCommentIcon.click ();

        //  Entering Comment In The TextField

        Thread.sleep (3000);
        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Checking The Comment Text Field");

//        // Clicking The Send Button In The Comment Text Field
//
//        Thread.sleep (2000);
//        WebElement clickingSendButton = driver.findElement (className ("anticon-send"));
//        clickingSendButton.click ();

        // Clicking the share icon in My Notes

        Thread.sleep (5000);
        Share_icon = driver.findElement (xpath ("//*[@class=\"share\"]"));
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (1000);
        Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Scroling BackWard The Ebook page

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

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

        driver.switchTo ().window (parent);
        WebElement clickingBackButton = driver.findElement (xpath ("//span[text()='Back']"));
        clickingBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();
    }


}


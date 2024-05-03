package Menu;

import PageObjectModule.Myebookspageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Myebookspageobject.*;
import static org.openqa.selenium.By.xpath;

public class Menu_MyEbooks {
    WebDriver driver;

    public Menu_MyEbooks(WebDriver driver) {
        this.driver = driver;
    }

    public void MyEbooks() throws InterruptedException {

        PageFactory.initElements (driver, Myebookspageobject.class);

        // Clicking My ebooks

        Thread.sleep (5000);
        clickingTheMyEbooks.click ();

        // Click the three dots in the My Ebook

        Thread.sleep (5000);
        Threedots.click ();

        //Clicking the remove My ebook icon in dropdown
//
//        Thread.sleep (3000);
//        Remove_My_ebook.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        Threedots.click ();

        /* Clicking the share icon in My Ebook */

        Thread.sleep (3000);
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancelbutton.click ();

        // Again Click the three dots in the My Ebook

        Thread.sleep (3000);
        Threedots.click ();

        //clicking the report icon

        Thread.sleep (1000);
        Reporticon.click ();

        //Click the wrong information radio button

        Thread.sleep (1000);
        Wronginformationradiobutton.click ();

        //Entering the text inside the report text field

        Enterthereport.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        // Reportbutton.click ();

        // Clicking The Cancel Button

        Cancelbutton.click ();

        //Clicking the Course name in My ebook Card

        Thread.sleep (3000);
        ClickingCourseName.click ();

        //Clicking the breadcrums to navigate backward to My ebook page

        Thread.sleep (3000);
        ClickingCoursebreadcrums.click ();

        // Clicking the like button

        Thread.sleep (3000);
        Likebutton.click ();

        // ClickingTheUnLikesButton

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
        clickingCommentIcon.click ();

        //  Entering Comment In The TextField

        Thread.sleep (3000);
        WebElement enteringTheCommentInTextField = driver.findElement (xpath ("//*[@name=\"comments1\"]"));
        enteringTheCommentInTextField.sendKeys ("Thanks For The Updates");

//        // Clicking The Send Button In The Comment Text Field
//
//        Thread.sleep (2000);
//        clickingSendButton.click ();

        // Clicking the share icon in My Notes

        Thread.sleep (5000);
        Share_icon.click ();

        //click the copy link in the share popup

        Thread.sleep (1000);
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        Cancelbutton.click ();

        // Scroling BackWard The Ebook page

        Thread.sleep (3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The View Button In The Ebook

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
        clickingBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        clickingHomeButton.click ();
    }


}


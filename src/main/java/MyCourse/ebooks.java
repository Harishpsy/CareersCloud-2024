package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.By.*;

public class ebooks {
    WebDriver driver;

    public ebooks(WebDriver driver) {
        this.driver = driver;
    }

    public void Ebooks() throws InterruptedException {

        // Verifying The Ebooks Sub-Module Was Displaying, if Display Perform The Below Action
        try {
            WebElement clickingEbooksTab = driver.findElement ( xpath ( "//*[text()='Ebooks']" ) );

            if (clickingEbooksTab.isSelected ()) {
                System.out.println ( "Ebooks Tab Is Already Selected, We Are Performing The Below Actions In The Ebooks Tab List Page" );
            } else if (clickingEbooksTab.isDisplayed ()) {
                clickingEbooksTab = driver.findElement ( xpath ( "//*[text()='Ebooks']" ) );
                clickingEbooksTab.click ();
                System.out.println ( "Successfully Clicked The Ebooks Tab, And Performing The action In The List Page" );
            } else {
                System.out.println ( "Both The Code Has Not Executed In The Course Ebooks Tab" );
            }
        } catch (java.util.NoSuchElementException e) {
            System.out.println ( "Ebooks Tab Is Not Present In The Current Course" );
        }

        // Scrolling The page In the ebook list page
        int numberOfTimesScrollEbooks = 5;
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
        try {
            // Wait for the float icon to become clickable (10-second timeout)
            WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
            WebElement clickingFloatIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class='css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle']" ) ) );

            // Check if the float icon is displayed
            if (clickingFloatIcon.isDisplayed ()) {
                // Optional wait before clicking
                Thread.sleep ( 2000 );
                clickingFloatIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//*[@class='css-xu9wm8 ant-float-btn ant-float-btn-default ant-float-btn-circle']" ) ) );
                clickingFloatIcon.click ();
                System.out.println ( "Float Icon clicked successfully." );
            }
        } catch (Exception e) {
            System.out.println ( "FloatIcon Button is not displayed." );
        }

        System.out.println ( "Verifying Whether Duplicate Was Present,Wait For Few Seconds" );
        // Verifying Weather There is Duplicate was find in the Ebooks or not
        List<WebElement> ebookTitle = driver.findElements (xpath ("//*[@class=\"ant-row ant-row-middle nowrap-content css-xu9wm8\"]"));

        // Create a set to store unique Ebook Titles
        Set<String> uniqueTitleName = new HashSet<> ();
        int ebookTitleCount = 0;

        // Iterate through the list of elements
        for (WebElement ebooksTitleName : ebookTitle) {
            String actualEbookTitle = ebooksTitleName.getText ();
            //System.out.println ("Original Ebook Name:" + actualEbookTitle);

            if (uniqueTitleName.contains (actualEbookTitle)) {
                System.out.println ("Duplicate Found ---> " + actualEbookTitle);
            } else {
                uniqueTitleName.add (actualEbookTitle);
                ebookTitleCount++;
//                System.out.println ("Ebook Title Found: " + ebookTitleCount + " --> " + actualEbookTitle);
            }
            // Assert that the number of unique URLs is equal to the number of elements
            Assert.assertEquals (ebookTitleCount, uniqueTitleName.size ());
        }

        // Clicking The View Button
        Thread.sleep (3000);
        WebElement clickingViewButton = driver.findElement ( xpath ( "//*[@class=\"image2\"]/following::*[text()='VIEW >']" ) );
        clickingViewButton.click ();
        System.out.println ("SuccessFully Clicked The view Button");

        // Getting The Clicked Ebook Name
        Thread.sleep ( 5000 );
        WebElement gettingEbookName = driver.findElement ( xpath ( "//*[@class=\"ant-typography text css-xu9wm8\"]" ) );
        String EbookName = gettingEbookName.getText ();
        System.out.println ( "Ebook Name: " + EbookName );

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

        // Clicking The Three dots
        Thread.sleep ( 3000 );
        WebElement Threedots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[2]" ) );
        Threedots.click ();

        // Clicking The save My Notes OR Remove My Notes
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) ); // 30 seconds timeout

        try {
            Thread.sleep ( 3000 );
            WebElement saveMyEbookElement = wait.until ( ExpectedConditions.visibilityOfElementLocated ( xpath ( "(//*[@class=\"ant-dropdown-menu-title-content\"])[1]" ) ) );
            if (saveMyEbookElement.isDisplayed ()) {
                saveMyEbookElement.click ();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println ( "Save Or Remove My Ebook is not displayed." );
        }

        // Clicking The Three dots
        Thread.sleep ( 3000 );
        Threedots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[2]" ) );
        Threedots.click ();

        /* Clicking the share icon in My Ebook */
        Thread.sleep ( 3000 );
        WebElement Share_icon = driver.findElement ( xpath ( "//span[text()='Share']" ) );
        Share_icon.click ();

        //click the copy link in the share popup
        Thread.sleep ( 3000 );
        WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
        Copy_link.click ();

        //Clicking the cancel button in the in share popup
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 30 ) );
        WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
        Cancel_button.click ();

        // Again Click the three dots in the My Ebook
        Thread.sleep ( 3000 );
        WebElement Three_dots = driver.findElement ( xpath ( "(//*[@class=\"ant-dropdown-trigger\"])[2]" ) );
        Three_dots.click ();

        //clicking the report icon
        Thread.sleep ( 3000 );
        WebElement Report_icon = driver.findElement ( xpath ( "//span[text()='Report']" ) );
        Report_icon.click ();
        System.out.println ( "SuccessFully Clicked The Report icon" );

        //Click the wrong information radio button
        Thread.sleep ( 3000 );
        WebElement Wronginformationradiobutton = driver.findElement ( xpath ( "//span[text()='Wrong Information']" ) );
        Wronginformationradiobutton.click ();
        System.out.println ( "SuccessFully Clicked The Wrong information radio button" );

        //Entering the text inside the report text field
        WebElement Enterthereport = driver.findElement ( name ( "reportDescription" ) );
        Enterthereport.sendKeys ( "Checking The text was Entering In The Report Text Field" );

        // Click the report button
        /* Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();*/

        // Clicking The Cancel Button
        Thread.sleep ( 3000 );
        Cancel_button = driver.findElement ( xpath ( "//span[text()='CANCEL']" ) );
        Cancel_button.click ();
        System.out.println ( "SuccessFully Clicked The Cancel Button" );
//
//        // Clicking The home button
//        Thread.sleep ( 3000 );
//        WebElement clickingHomeButton = driver.findElement ( xpath ( "//*[text()='Home']" ) );
//        clickingHomeButton.click ();
//        System.out.println ( "SuccessFully Clicked The HomeButton" );
//
//        // Clicking The Ebook
//        Thread.sleep ( 3000 );
//        WebElement clickingEbookInMenu = driver.findElement ( id ( "3" ) );
//        clickingEbookInMenu.click ();
//
//        // Verifying saved or removed article was showing in the My Notes Page
//        List<WebElement> ebookTitleElements = driver.findElements ( xpath ( "//*[@class='feed-card-cover-inner-content']" ) );
//        boolean isEbookFound = false;
//
//        for (WebElement ebookElement : ebookTitleElements) {
//            String ebookName = ebookElement.getText ();
//            System.out.println ( "Ebook Title in My Notes: " + ebookName );
//
//            if (ebookName.equals ( EbookName )) {
//                System.out.println ( "Verification Passed: Ebook Title (" + EbookName + ") matches Ebook in My Notes (" + ebookName + ")" );
//                isEbookFound = true;
//            } else {
//                System.out.println ( "Ebook Title Does Not Match" );
//            }
//        }
//        if (!isEbookFound) {
//            System.out.println ( "Ebook is Not Showing in My-Ebooks" );
//        }


    }
}

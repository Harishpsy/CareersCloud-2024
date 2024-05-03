package MainPages;

import PageObjectModule.Homepageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Homepageobject.*;
import static org.openqa.selenium.By.xpath;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickingHomePage() throws InterruptedException {

        // Writing For Home Feed

        PageFactory.initElements (driver, Homepageobject.class);

        // clicking Preference Button

        Thread.sleep (7000);
        clickingPreferenceButton.click ();

        // Clicking The Railway Button

        clickingRailwayButton.click ();

        // clicking Preference Button

        clickingPreferenceButton.click ();

        // Clicking The Bank&Insurance Button

        Thread.sleep (2000);
        clickingBankandInsuranceButton.click ();

        // clicking Preference Button
        Thread.sleep (2000);
        clickingPreferenceButton.click ();

        // Clicking The Add Preference

        Thread.sleep (2000);
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (2000);
        clickingUPSCButton.click ();

        // Clicking Save Preference

        Thread.sleep (2000);
        clickingsavePreference.click ();

        // clicking Preference Button

        Thread.sleep (7000);
        clickingPreferenceButton.click ();

        // Clicking The Add Preference

        Thread.sleep (3000);
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (3000);
        clickingUPSCButton.click ();

        // Clicking Save Preference

        clickingsavePreference.click ();


//        // Clicking Cancel Button In Profile
//
//        WebElement clickingCancelButton = driver.findElement (xpath ("//span[text()='Cancel']"));
//        clickingCancelButton.click ();

        //Scrolling Down in Coursepage

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        //Scrolling up in Coursepage

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        Thread.sleep (3000);
        clickingBannerInHomeFeed.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed1.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed2.click ();

        // Clicking The Close icon In The Course Banner Modal

        Thread.sleep (3000);
        clickingCloseIcon.click ();

        // Clcking The Google Play Button

        Thread.sleep (3000);
        clickingGoooglePlayButton.click ();

        //Windows Handeling child to parent and parent to child

        Thread.sleep (3000);
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
        driver.close ();
        driver.switchTo ().window (parent);

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        //Scrolling Down in Home Feed

        Thread.sleep (3000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // Clicking The Aboutus In The Footer Section

        Thread.sleep (3000);
        clickingAboutUs.click ();

        // Clicking The Authors In The Footer Section

        Thread.sleep (3000);
        WebElement clickingAuthors = driver.findElement (xpath ("//a[text()='Authors']"));
        clickingAuthors.click ();

//        // Clicking The contactus In The Footer Section
//
//        Thread.sleep (3000);
//        WebElement clickingcontactUs = driver.findElement (xpath ("//span[text()='Contact Us']"));
//        clickingcontactUs.click ();
//
//        // Entering The text In The Contactus TextField
//
//        Thread.sleep (3000);
//        WebElement enteringTextInTextField = driver.findElement (name ("queries"));
//        enteringTextInTextField.sendKeys ("Checking The Text Was Entering");
//        clickingUploadButton.click ();
//
//        // Clicking The Send Button
//
//        Thread.sleep (3000);
//        WebElement clickingSendButton = driver.findElement (xpath ("//span[text()='Send']"));
//        clickingSendButton.click ();

//        // Clicking the close icon
//
//        Thread.sleep (2000);
//        clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
//        clickingCloseIcon.click ();

        // Clicking The FAQ Button In The Footer Section

        Thread.sleep (3000);
        clickingFAQButton.click ();

        // Clicking The Terms And Condition Button In The Footer Section

        Thread.sleep (3000);
        WebElement clickingTermsAndConditionButton = driver.findElement (xpath ("//a[text()='Terms and Conditions']"));
        clickingTermsAndConditionButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The Terms And Condition Button In The Footer Section

        Thread.sleep (3000);
        clickingPrivacyPolicyButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The Careers Button In The Footer Section

        Thread.sleep (1000);
        clickingCareersButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The sitemap Button In The Footer Section

        Thread.sleep (1000);
        clickingsitemapButton.click ();
    }
}

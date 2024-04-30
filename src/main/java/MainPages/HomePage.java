package MainPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickingHomePage() throws InterruptedException {

        // Writing For Home Feed

        // clicking Preference Button

        Thread.sleep (7000);
        WebElement clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Railway Button

        WebElement clickingRailwayButton = driver.findElement (xpath ("//div[text()='Railway']"));
        clickingRailwayButton.click ();

        // clicking Preference Button

        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Bank&Insurance Button

        Thread.sleep (2000);
        WebElement clickingBankandInsuranceButton = driver.findElement (xpath ("//div[text()='Bank & Insurance']"));
        clickingBankandInsuranceButton.click ();

        // clicking Preference Button
        Thread.sleep (2000);
        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Add Preference
        Thread.sleep (2000);
        WebElement clickingAddPreferencebutton = driver.findElement (xpath ("//a[text()=' Add Preference']"));
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (2000);
        WebElement clickingUPSCButton = driver.findElement (xpath ("//div[text()='UPSC']"));
        clickingUPSCButton.click ();

        // Clicking Save Preference

        Thread.sleep (2000);
        WebElement clickingsavePreference = driver.findElement (xpath ("//span[text()='Save Preference']"));
        clickingsavePreference.click ();

        // clicking Preference Button

        Thread.sleep (7000);
        clickingPreferenceButton = driver.findElement (xpath ("//*[@name=\"selectedPreference\"]"));
        clickingPreferenceButton.click ();

        // Clicking The Add Preference

        Thread.sleep (3000);
        clickingAddPreferencebutton = driver.findElement (xpath ("//a[text()=' Add Preference']"));
        clickingAddPreferencebutton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // clicking UPSC Button

        Thread.sleep (3000);
        clickingUPSCButton = driver.findElement (xpath ("//div[text()='UPSC']"));
        clickingUPSCButton.click ();

        // Clicking Save Preference

        clickingsavePreference = driver.findElement (xpath ("//span[text()='Save Preference']"));
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
        WebElement clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        Thread.sleep (3000);
        WebElement clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/94cbaa46bc54ec537cc339f5199b390e.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        WebElement clickingCourseInBreadCrumbs = driver.findElement (xpath ("//span[text()='Course']"));
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/2901af2b7017b7d126b7c7493c0a2b8d.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking the course BreadCrumbs for coming back

        Thread.sleep (3000);
        clickingCourseInBreadCrumbs = driver.findElement (xpath ("//span[text()='Course']"));
        clickingCourseInBreadCrumbs.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        //  Clicking The Right arrow in the Home feed

        Thread.sleep (3000);
        clickingRightArrow = driver.findElement (xpath ("//span[@class=\"anticon anticon-right action-icon\"]"));
        clickingRightArrow.click ();

        // Clicking The banners in the home feed

        clickingBannerInHomeFeed = driver.findElement (xpath ("//*[@src=\"https://assets.careerscloud.in/banner/images/b26df9a2c61c98268b1ab9e34cb9fbdb.webp\"]"));
        clickingBannerInHomeFeed.click ();

        // Clicking The Close icon In The Course Banner Modal

        Thread.sleep (3000);
        WebElement clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        // Clcking The Google Play Button

        Thread.sleep (3000);
        WebElement clickingGoooglePlayButton = driver.findElement (xpath ("//span[text()='Google Play']"));
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
        WebElement clickingAboutUs = driver.findElement (xpath ("//a[text()='About Us']"));
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
        WebElement clickingFAQButton = driver.findElement (xpath ("//a[text()='FAQs']"));
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
        WebElement clickingPrivacyPolicyButton = driver.findElement (xpath ("//a[text()='Privacy Policy']"));
        clickingPrivacyPolicyButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The Careers Button In The Footer Section

        Thread.sleep (1000);
        WebElement clickingCareersButton = driver.findElement (xpath ("//a[text()='Careers']"));
        clickingCareersButton.click ();

        //Scrolling Down Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        // Clicking The sitemap Button In The Footer Section

        Thread.sleep (1000);
        WebElement clickingsitemapButton = driver.findElement (xpath ("//a[text()='Sitemap']"));
        clickingsitemapButton.click ();
    }
}

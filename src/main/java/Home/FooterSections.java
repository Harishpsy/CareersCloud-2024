package Home;

import Master.Base.CoreFunctionality;
import ScreenShot.ScreenShot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static PageObjectModule.Homepageobject.*;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class FooterSections extends ScreenShot {

    WebDriver driver;

    // Constructor for FooterSections
    public FooterSections(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Tests various interaction elements within the footer section of a web page.
     * Captures screenshots for each action.
     *
     * @throws InterruptedException if the thread sleep is interrupted
     * @throws IOException          if capturing screenshots fails
     */
    @Test
    public void footerSection() throws InterruptedException, IOException {

        System.out.println ( "Entering In To The Footer Sections" );

        // Scrolling the HomePage page
        CoreFunctionality scroll = new CoreFunctionality ( driver );
        scroll.Scroll ();
        ScreenShot.captureScreenshot ( "Scrolled The Page" );

        // Clicking "About Us" in the Footer Section
        Thread.sleep(3000);
        clickingAboutUs.click();
        ScreenShot.captureScreenshot ( "Clicked About Us" );
        System.out.println ( "Successfully Clicked 'About Us' in the Footer Section" );

        // Clicking "Authors" in the Footer Section
        Thread.sleep(3000);
        WebElement clickingAuthors = driver.findElement(xpath("//a[text()='Authors']"));
        clickingAuthors.click();
        ScreenShot.captureScreenshot ( "Clicked Authors" );
        System.out.println ( "Successfully Clicked 'Authors' in the Footer Section" );

        // Clicking "Contact Us" in the Footer Section
        Thread.sleep(3000);
        WebElement clickingcontactUs = driver.findElement(xpath("//span[text()='Contact Us']"));
        clickingcontactUs.click();
        ScreenShot.captureScreenshot ( "Clicked Contact Us" );
        System.out.println ( "Successfully Clicked 'Contact Us' in the Footer Section" );

        // Entering text in the "Contact Us" TextField
        Thread.sleep(3000);
        WebElement enteringTextInTextField = driver.findElement(name("queries"));
        enteringTextInTextField.sendKeys ( "Checking the text was entered" );
        ScreenShot.captureScreenshot ( "Entered Text in Contact Us" );

        // Clicking the Close Icon
        Thread.sleep(2000);
        clickingCloseIcon = driver.findElement(xpath("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click();
        ScreenShot.captureScreenshot ( "Clicked Close Icon" );

        // Clicking the FAQ Button in the Footer Section
        Thread.sleep(3000);
        clickingFAQButton.click();
        ScreenShot.captureScreenshot ( "Clicked FAQ Button" );
        System.out.println ( "Successfully Clicked FAQ Button in the Footer Section" );

        // Clicking "Terms and Conditions" in the Footer Section
        Thread.sleep(3000);
        WebElement clickingTermsAndConditionButton = driver.findElement(xpath("//a[text()='Terms and Conditions']"));
        clickingTermsAndConditionButton.click();
        ScreenShot.captureScreenshot ( "Clicked Terms and Conditions" );
        System.out.println ( "Successfully Clicked 'Terms and Conditions' in the Footer Section" );

        // Scrolling Down to the Bottom of the Page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

        // Clicking "Privacy Policy" in the Footer Section
        Thread.sleep(3000);
        clickingPrivacyPolicyButton.click();
        ScreenShot.captureScreenshot ( "Clicked Privacy Policy" );
        System.out.println ( "Successfully Clicked 'Privacy Policy' in the Footer Section" );

        // Scrolling Down Again
        jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

        // Clicking "Careers" in the Footer Section
        Thread.sleep(1000);
        clickingCareersButton.click();
        ScreenShot.captureScreenshot ( "Clicked Careers" );
        System.out.println ( "Successfully Clicked 'Careers' in the Footer Section" );

        // Scrolling Down Again
        jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );

        // Clicking "Sitemap" in the Footer Section
        Thread.sleep(1000);
        clickingsitemapButton.click();
        ScreenShot.captureScreenshot ( "Clicked Sitemap" );
        System.out.println ( "Successfully Clicked 'Sitemap' in the Footer Section" );

        // Clicking Float Icon
        CoreFunctionality floatIcon = new CoreFunctionality(driver);
        floatIcon.floatButton();
        ScreenShot.captureScreenshot ( "Clicked Float Icon" );
    }

    /**
     * Captures a screenshot for the current browser state and saves it with a unique name.
     *
     * @param actionName Description of the action performed.
     * @throws IOException If an error occurs while saving the screenshot.
     */
}

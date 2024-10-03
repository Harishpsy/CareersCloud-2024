package Home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static PageObjectModule.Homepageobject.*;
import static org.openqa.selenium.By.*;

public class FooterSections {

    WebDriver driver;

    // Creating A Constructor For The Footer Section
    public FooterSections(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void footerSection() throws InterruptedException {

        // Clicking The About us In The Footer Section
        Thread.sleep ( 3000 );
        clickingAboutUs.click ();
        System.out.println ( "SuccessFully Clicked The About us In The Footer Section" );

        // Clicking The Authors In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingAuthors = driver.findElement ( xpath ( "//a[text()='Authors']" ) );
        clickingAuthors.click ();
        System.out.println ( "SuccessFully Clicked The Authors In The Footer Section" );

        // Clicking The contactus In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingcontactUs = driver.findElement ( xpath ( "//span[text()='Contact Us']" ) );
        clickingcontactUs.click ();
        System.out.println ( "SuccessFully Clicked The contactus In The Footer Section" );

        // Entering The text In The Contactus TextField
        Thread.sleep ( 3000 );
        WebElement enteringTextInTextField = driver.findElement ( name ( "queries" ) );
        enteringTextInTextField.sendKeys ( "Checking The Text Was Entering" );

        //   clickingUploadButton.click ();

        // Clicking The Send Button
//        Thread.sleep ( 3000 );
//        WebElement clickingSendButton = driver.findElement ( xpath ( "//span[text()='Send']" ) );
//        clickingSendButton.click ();
//        System.out.println ( "SuccessFully Clicked The Send Button" );

        // Clicking the close icon
        Thread.sleep ( 2000 );
        clickingCloseIcon = driver.findElement ( xpath ( "//*[@class=\"ant-modal-close-x\"]" ) );
        clickingCloseIcon.click ();

        // Clicking The FAQ Button In The Footer Section
        Thread.sleep ( 3000 );
        clickingFAQButton.click ();
        System.out.println ( "SuccessFully Clicked FAQ Button In The Footer Section" );

        // Clicking The Terms And Condition Button In The Footer Section
        Thread.sleep ( 3000 );
        WebElement clickingTermsAndConditionButton = driver.findElement ( xpath ( "//a[text()='Terms and Conditions']" ) );
        clickingTermsAndConditionButton.click ();
        System.out.println ( "SuccessFully Clicked The Terms And Condition Button In The Footer Section" );

        //Scrolling Down Function
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The Privacy Button In The Footer Section
        Thread.sleep ( 3000 );
        clickingPrivacyPolicyButton.click ();
        System.out.println ( "SuccessFully Clicked The Privacy Button In The Footer Section" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The Careers Button In The Footer Section
        Thread.sleep ( 1000 );
        clickingCareersButton.click ();
        System.out.println ( "SuccessFully Clicked Careers Button In The Footer Section" );

        //Scrolling Down Function
        jse = (JavascriptExecutor) driver;
        jse.executeScript ( "window.scrollTo( 0, document.body.scrollHeight)" );

        // Clicking The sitemap Button In The Footer Section
        Thread.sleep ( 1000 );
        clickingsitemapButton.click ();
        System.out.println ( "SuccessFully Clicked The sitemap Button In The Footer Section" );

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-body\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                Thread.sleep ( 5000 );
                clickingFloatIcon.click ();
                System.out.println ( "SuccessFully Clicked The Float Icon" );
            } else {
                System.out.println ( "Float Icon Is Not Displayed" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Float Icon Button Is Not Displayed" );
        }
    }
}

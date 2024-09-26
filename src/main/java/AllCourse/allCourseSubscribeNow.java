package AllCourse;

import org.openqa.selenium.*;

import java.awt.*;
import java.time.Duration;

public class allCourseSubscribeNow {
    WebDriver driver;

    public allCourseSubscribeNow(WebDriver driver) {
        this.driver = driver;
    }

    public void subscribeNowButton() throws InterruptedException, AWTException {


        //Using try, catch method to Hanle whether The subscribe button is present of not
        Thread.sleep ( 5000 );
        boolean subscribeNowButtonDisplayed = false;

        try {
            WebElement subscribeNow = driver.findElement ( By.xpath ( "//*[text()='Subscribe Now']" ) );
            subscribeNowButtonDisplayed = subscribeNow.isDisplayed ();
        } catch (NoSuchElementException e) {
            System.out.println ( "Subscribe Now Button Is Not Displayed" );
        }

        // Log the visibility status of each element
        System.out.println ( "Subscribe Now Button Is Displayed:" + subscribeNowButtonDisplayed );

        // Handeling The If, else statement, to perfom the action in the subscribe now page
        Thread.sleep ( 5000 );
        if (subscribeNowButtonDisplayed) {
            driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );// Implicit Wait we are using Here
            WebElement subscribeNow = driver.findElement ( By.xpath ( "//*[text()='Subscribe Now']" ) );
            subscribeNow.click ();
            System.out.println ( "Successfully Clicked The Subscribe Now Button" );

            // Checking Whether The Popup was displaying Or Not to do the action in The Popup
            Thread.sleep ( 10000 );// Waiting To Page Load
            boolean useCoinIsDisplayed = false;
            boolean unsubscribeButtonDispayed = false;

            try {
                WebElement clickingUseCoin = driver.findElement ( By.xpath ( "//*[@class=\"ant-checkbox ant-wave-target css-xu9wm8\"]" ) );
                useCoinIsDisplayed = clickingUseCoin.isDisplayed ();
            } catch (NoSuchElementException e1) {
                System.out.println ( "Use Coin Is No Displayed" );
            }

            try {
                WebElement unsubscribebutton = driver.findElement ( By.xpath ( "//*[text()='Unsubscribe']" ) );
                unsubscribeButtonDispayed = unsubscribebutton.isDisplayed ();
            } catch (NoSuchElementException e2) {
                System.out.println ( "Un Subscribe Button is Not Displayed" );
            }

            //Printing The Log
            System.out.println ( "Use Coin Button Is Displayed:" + useCoinIsDisplayed );
            System.out.println ( "Un subscribe Button Is Displayed:" + unsubscribeButtonDispayed );

            if (useCoinIsDisplayed) {

                //Clicking The Use Coin In The Subscribtion Popup
                Thread.sleep ( 5000 );
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );// Implicit Wait we are using Here
                WebElement clickingUseCoin = driver.findElement ( By.xpath ( "//*[@class=\"ant-checkbox ant-wave-target css-xu9wm8\"]" ) );
                clickingUseCoin.click ();
                System.out.println ( "Successfully Clicked The Subscribe Now Button" );

                // Entering Coupon Code
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
                WebElement enteringCouponCode = driver.findElement ( By.xpath ( "//input[@name=\"coupon_code\"]" ) );
                enteringCouponCode.sendKeys ( "CR15" );
                System.out.println ( "Successfully Entered Coupon Code" );

                //Clicking The Apply Button After entering The coupon Code
                Thread.sleep ( 10000 );
//              driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
                WebElement clickingApplyButton = driver.findElement ( By.xpath ( "//*[text()='Apply']" ) );
                ((JavascriptExecutor) driver).executeScript ( "arguments[0].scrollIntoView(true);" , clickingApplyButton );
                clickingApplyButton.click ();
                System.out.println ( "Successfully Clicked The Apply Button" );

                // Clicking The Close Icon In The Subscribe Now Popup
                Thread.sleep ( 10000 );
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );// Implicit Wait we are using Here
                WebElement closeIcon = driver.findElement ( By.xpath ( "//*[@class=\"anticon anticon-close-circle\"]" ) );
                closeIcon.click ();
                System.out.println ( "Successfully Clicked The Close Icon" );

//                // Clicking The Continue Button In The Payment Popup
//                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
//                WebElement clickingCotinueButton = driver.findElement ( By.xpath ( "//button[@class=\"ant-btn css-xu9wm8 ant-btn-default\"]" ) );
//                clickingCotinueButton.click ();
//
//                Thread.sleep ( 5000 );
////                WebElement outerIFrame = driver.findElement ( By.xpath ( "//iframe[@cd_frame_id_=\"3542d870cdf5bc4cc985e665d276f45b\"]" ) );
////                driver.switchTo ().frame (outerIFrame);
//
//                WebElement innerIFrame = driver.findElement ( By.xpath ( "//*[@id=\"scroll-container\"]" ) );
//                driver.switchTo ().frame (innerIFrame);
//
//                // Getting Text
//                WebElement text = driver.findElement ( By.xpath ( "data-testid=\"title\"" ) );
//                String title = text.getText ();
//                System.out.println ("Title:" + title);

//                //Clicking The close Icon In The Razorpay Popup
//                Thread.sleep ( 10000 );
//                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
//                WebElement clickingcloseicon = driver.findElement ( By.xpath ( "(//*[@class=\"inline-flex h-4 items-center *:h-full \"])[3]" ) );
//                clickingcloseicon.click ();
//
//                //Clicking The Exit Button In The RazorPay Popup
//                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 3 ) );
//                WebElement clickingExit = driver.findElement ( By.xpath ( "//*[@data-testid=\"confirm-positive\"]" ) );
//                clickingExit.click ();
//
//                //Clicking The Dismiss Button In The Payment Cancelled Popup
//                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 3 ) );
//                WebElement clickingDismissButton = driver.findElement ( By.xpath ( "//*[text()='Dismiss']" ) );
//                clickingDismissButton.click ();

            } else if (unsubscribeButtonDispayed) {
                System.out.println ( "Unsubscribed Button Is displayed,So It Is An Free Course So Popup Won't Display, It Get Subscribe Automatically without Payment" );

                //DetailsPage In The all Course
                detailsTab detailsPage = new detailsTab ( driver ); // Details Page Object has been created to preforme the actions after the subscribe
                detailsPage.details ();

                // Go back to the course list using breadcrumb (if available)
                try {
                    WebElement breadcrumbLink = driver.findElement ( By.xpath ( "(//*[@class='ant-breadcrumb-link'])[1]" ) );
                    Thread.sleep ( 3000 );  // Wait for the page to load
                    breadcrumbLink.click ();
                    Thread.sleep ( 3000 );  // Wait for the course list to reload
                } catch (NoSuchElementException e1) {
                    System.out.println ( "Breadcrumb link not found" );
                }

            } else {
                System.out.println ( "Both The Code Has Not Executed So Error In The Course Subscribe Page" );
            }

        } else {
            System.out.println ( "Subscribe Now Button Is Not Displayed In The All Course Page" );
        }
    }
}

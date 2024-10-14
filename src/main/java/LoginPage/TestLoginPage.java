package LoginPage;

import PageObjectModule.Loginpageobject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Loginpageobject.*;
import static org.openqa.selenium.By.xpath;

public class TestLoginPage {
    WebDriver driver;

    public TestLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void testLogin() throws InterruptedException {

        // Navigate to the URL and maximize the window
        driver.get ( "https://testweb.careerscloud.in/" );
        driver.manage ().window ().maximize ();

        // Clear cookies to avoid issues with corrupted data
        driver.manage ().deleteAllCookies ();

        // Wait for elements to be visible
        Thread.sleep ( 5000 );

        // Initialize page elements using PageFactory
        PageFactory.initElements ( driver , Loginpageobject.class );

        // Click the login button
        Thread.sleep ( 10000 );
        LoginButton.click ();
        System.out.println ( "SuccessFully Clicked The Login Button" );

        // Handle window switching
        switchToChildWindow ();

        // Enter email ID and click next
        Thread.sleep ( 5000 );
        Entering_mailID.sendKeys ( "harishpsy12@gmail.com" );
        Nextbutton.click ();
        System.out.println ( "SuccessFully Clicked The Next Button" );

        // Enter password and click next
        enterPassword ();

        // Click the continuing button and switch back to a parent window
        Thread.sleep ( 7000 );
        Continuebutton.click ();
        System.out.println ( "SuccessFully Clicked The Continue Button" );
        switchToParentWindow ();

        //  Performing The Profile Action
        TestLoginPage profile = new TestLoginPage ( driver );
        profile.profile ();
    }

    /**
     * Switches the WebDriver context to a child window.
     * This method assumes that there are exactly two windows, the parent and the child,
     * and switches to the child window for further operations.
     */
    @Test
    // Method to switch to the child window
    public void switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window ( child );
    }

    /**
     * Switches the WebDriver context back to the parent window.
     * This method is typically used after navigating to a child window
     * to perform operations and then returning to the parent window.
     */
    // Method to switch back to the parent window
    @Test
    public void switchToParentWindow() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        it.next (); // Skip the child window
        driver.switchTo ().window ( parent );

    }

    /**
     * This method enters the password into the password field of the login page and clicks the 'Next' button.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test()
    // Method to enter password
    public void enterPassword() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 40 ) );
        wait.until ( ExpectedConditions.visibilityOf ( passwordField ) );
        passwordField.sendKeys ( "Harish@1998" );
        Thread.sleep ( 2000 );
        Nextbutton.click ();
        System.out.println ( "SuccessFully Clicked The Next Button" );
    }

    //Click The Profile Button On The Right Side of the home page
    @Test
    public void profile() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        Thread.sleep ( 30000 );
        WebElement profileButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//*[@class=\"profile-span\"]" ) ) );
        profileButton.click ();
        System.out.println ( "Successfully CLicked The Profile" );

        //Clicking The switch to Test Environment To live enevironment
        wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );

        // Clicking The ReattempButton
        Thread.sleep ( 10000 );
        //wait = new WebDriverWait (driver,30);
        wait = new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );

        try {
            WebElement reattemptIcon = wait.until ( ExpectedConditions.elementToBeClickable ( xpath ( "//div[@class='ant-switch-handle']" ) ) );
            reattemptIcon.click ();
            System.out.println ( "Successfully clicked the Switch icon." );
        } catch (TimeoutException e) {
            System.out.println ( "The Switch icon was not clickable within the timeout period3." );
        } catch (NoSuchElementException e) {
            System.out.println ( "The Switch icon was not found on the page." );
        } catch (Exception e) {
            System.out.println ( "An unexpected error occurred: " + e.getMessage () );
        }

        // Click the login button
        Thread.sleep ( 10000 );
        LoginButton.click ();
        System.out.println ( "SuccessFully Clicked The Login Button" );

        // Handle window switching
        switchToChildWindow ();

        // Clicking email ID and click next
        Thread.sleep ( 3000 );
        WebElement clickmailID = driver.findElement ( xpath ( "//*[@class=\"DOLDDf\"]" ) );
        clickmailID.click ();

        // Click the continuing button and switch back to a parent window
        Thread.sleep ( 7000 );
        Continuebutton.click ();
        System.out.println ( "SuccessFully Clicked The Continue Button" );
        switchToParentWindow ();

    }

}

package LoginPage;

import Base.MainObjects.BaseObjects;
import PageObjectModule.Loginpageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static PageObjectModule.Loginpageobject.*;

public class Loginpage  {
    /**
     * The WebDriver instance used to interact with the web browser.
     * This variable is initialized via the Loginpage constructor and is utilized by various methods
     * to perform actions such as navigating to URLs, interacting with web elements, and managing browser windows.
     */
    WebDriver driver;

    /**
     * Constructor to set the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by this page
     */
    // Constructor to set the WebDriver instance
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method performs the login functionality.
     * It navigates to the specified URL, maximizes the browser window,
     * clears cookies, waits for elements to be visible, and interacts
     * with various elements on the login page to authenticate the user.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    // Method to perform login
    @Test(enabled = true)
    public void login() throws InterruptedException {

        // Navigate to the URL and maximize the window
        driver.get ( "https://careerscloud.in" );
        driver.manage ().window ().maximize ();

        // Clear cookies to avoid issues with corrupted data
        driver.manage ().deleteAllCookies ();

        // Wait for elements to be visible
        Thread.sleep (5000);

        // Initialize page elements using PageFactory
        PageFactory.initElements (driver, Loginpageobject.class);

        // Click the login button
        Thread.sleep ( 7000 );
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
    }

    /**
     * Switches the WebDriver context to a child window.
     * This method assumes that there are exactly two windows, the parent and the child,
     * and switches to the child window for further operations.
     */
    @Test(enabled = true)
    // Method to switch to the child window
    private void switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
    }

    /**
     * Switches the WebDriver context back to the parent window.
     * This method is typically used after navigating to a child window
     * to perform operations and then returning to the parent window.
     */
    // Method to switch back to the parent window
    @Test(enabled = true)
    private void switchToParentWindow() {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        it.next (); // Skip the child window
        driver.switchTo ().window (parent);
    }

    /**
     * This method enters the password into the password field of the login page and clicks the 'Next' button.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Test(enabled = true)
    // Method to enter password
    private void enterPassword() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (40));
        wait.until (ExpectedConditions.visibilityOf (passwordField));
        passwordField.sendKeys ("Harish@1998");
        Thread.sleep (2000);
        Nextbutton.click ();
        System.out.println ( "SuccessFully Clicked The Next Button" );
    }
}
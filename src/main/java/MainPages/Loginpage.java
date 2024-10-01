package MainPages;


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

public class Loginpage {

    public WebDriver driver;
    // Constructor to set the WebDriver instance
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform login
    @Test
    public void login() throws InterruptedException {
        // Navigate to the URL and maximize the window
        driver.get ("https://careerscloud.in/home-feed");
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
//        Entering_mailID.sendKeys ("harishpoker8@gmail.com");
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

    @Test
    // Method to switch to the child window
    private void switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        String child = it.next ();
        driver.switchTo ().window (child);
    }

    // Method to switch back to the parent window
    @Test
    private void switchToParentWindow() {
        Set<String> windows = driver.getWindowHandles ();
        Iterator<String> it = windows.iterator ();
        String parent = it.next ();
        it.next (); // Skip the child window
        driver.switchTo ().window (parent);
    }

    @Test
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
package Menu;

import PageObjectModule.Mycoinpageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static PageObjectModule.Mycoinpageobject.*;
import static PageObjectModule.Myebookspageobject.clickingHomeButton;

public class myCoins {
    WebDriver driver;
    public myCoins(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This test method navigates and performs operations on the "My Coins" page.
     *
     * The method includes the following steps:
     * - Initializes the page elements using PageFactory.
     * - Clicks on the "My Coin" menu item and verifies its selection.
     * - Interacts with the "Coin Earning" text if the "My Coin" menu item is either selected or displayed.
     * - Clicks the close button on the coin page.
     * - Scrolls the page backward and forward.
     * - Clicks the "Google Play" button and handles window switching to and from the child window.
     * - Finally, clicks the home button to exit the "My Coin" section.
     *
     * In case any element is not found, an exception is caught and an error message is printed.
     *
     * @throws InterruptedException when a thread is interrupted during sleep.
     */
    @Test
    public void MyCoins() throws InterruptedException {

        PageFactory.initElements ( driver , Mycoinpageobject.class );

        // Using Try Catch Method TO Handle The Exception
        try {
            // Clicking The My Coin in the Menu
            if (clickingMycoin.isSelected ()) {

                // Click The Coin earning Text
                System.out.println ( "SucessFully My coin is selected 1" );
                Thread.sleep ( 5000 );
                clickingCoinEarningText.click (); // clicking COin Earning Text
                System.out.println ( "SucessFully clicked the clickingCoinEarningText 1 " );

            } else if (clickingMycoin.isDisplayed ()) {
                System.out.println ( "SucessFully My coin is displayed 2" );
                Thread.sleep ( 5000 );
                clickingMycoin.click (); // Clicking The My Coin

                // Clicking My coin
                if (clickingMycoin.isEnabled ()) {

                    Thread.sleep ( 5000 );
                    clickingCoinEarningText.click (); // Clicking The Coin Earning Text
                    System.out.println ( "Sucessfully Clicked the coin earning page" );

                } else {
                    System.out.println ( "Error occured " );
                }
            } else {
                System.out.println ( "Both has been not excecuted" );
            }
            // Clicking The close Button
            Thread.sleep ( 5000 );
            clickingCloseIcon.click ();
            System.out.println ( "SucessFully clicked the clickingCloseIcon" );

            // Scrolling backward
            Thread.sleep ( 5000 );
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo(0, document.body.scrollHeight)" );
            System.out.println ( "SucessFully page scroll" );

            //Scrolling forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo( document.body.scrollHeight, 0)" );
            System.out.println ( "SucessFully page scroll" );

            // clicking The Google Play Button
            Thread.sleep ( 5000 );
            clickingGooglePlayButton.click ();
            System.out.println ( "SucessFully clicked clickingGooglePlayButton" );

            //Windows Handeling child to parent
            Thread.sleep ( 5000 );
            Set<String> windows = driver.getWindowHandles ();
            Iterator<String> it = windows.iterator ();
            String parent = it.next ();
            String child = it.next ();
            driver.switchTo ().window ( child );
            driver.close ();
            Thread.sleep ( 3000 );
            driver.switchTo ().window ( parent );

            //Scrolling forward
            Thread.sleep ( 5000 );
            jse = (JavascriptExecutor) driver;
            jse.executeScript ( "window.scrollTo( document.body.scrollHeight, 0)" );

            // Click the home button
            Thread.sleep ( 2000 );
            clickingHomeButton.click ();
            System.out.println ( "Exiting if-else statement From The My Coin : Navigating To The Next Module" );

        } catch (NoSuchElementException e) {

            System.out.println ( "Error Msg In The My Coin Page  : " + e.getMessage () );

        }
    }

}

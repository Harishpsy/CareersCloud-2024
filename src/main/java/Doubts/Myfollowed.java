package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class Myfollowed {

    WebDriver driver;

    public Myfollowed(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void myFollow() throws InterruptedException {

        // Clicking The Followed Button In The Doubt Page
        Thread.sleep ( 5000 );
        WebElement clickingFollowedTab = driver.findElement ( xpath ( "//*[text()='Followed']" ) );

        // Verifying that the Followed was already getting clicked or not
        if (clickingFollowedTab.isSelected ()) {
            Thread.sleep ( 3000 );
            System.out.println ( "Followed Button was already Selected" );
        } else if (clickingFollowedTab.isDisplayed ()) {
            Thread.sleep ( 5000 );
            clickingFollowedTab.click ();
            System.out.println ( "Successfully clicked the Followed button" );
        } else {
            System.out.println ( "Error Occured In The Above Code" );
        }

        // Checking wheather there is data present Or Not In the Followed If Not Navigate to the Next Module
        try {
            // Verifying whether the element is present or not
            Thread.sleep (5000);
            boolean isNoDoubtsFoundDisplayed = false;

            try {
                // Waiting for the element to be displayed
                Thread.sleep (5000);
                WebElement checkingNoDoubtsFound = driver.findElement (By.xpath ("//*[text()='No Doubts Found.']/ancestor::*[self::div and @id=\"rc-tabs-0-panel-4\"]"));
                isNoDoubtsFoundDisplayed = checkingNoDoubtsFound.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ("No Doubt Found element not found.");
            }

            // Printing whether the data was found or not using the boolean
            System.out.println ("No Doubt Found displayed in Followed: " + isNoDoubtsFoundDisplayed);

            // Creating if-else condition for navigation
            if (isNoDoubtsFoundDisplayed) {
                // Clicking the My Points button when no record found was displayed
                Thread.sleep (5000);
                WebElement clickingMyPointsPage = driver.findElement (By.xpath ("//*[text()='My Points']"));
                clickingMyPointsPage.click ();
                System.out.println ("Successfully clicked the My Points button");
            } else {
                System.out.println ("Data was present in the Followed page");
            }
        } catch (NoSuchElementException e) {
            System.out.println ("Error in the code: " + e.getMessage ());
        }
    }
}

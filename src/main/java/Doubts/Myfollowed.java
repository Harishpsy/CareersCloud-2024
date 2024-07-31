package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Myfollowed {

    WebDriver driver;

    public Myfollowed(WebDriver driver) {

        this.driver = driver;

    }

    public void myFollow() throws InterruptedException {

        // Clicking The Followed Button In The Doubt Page

        Thread.sleep (3000);
        WebElement clickingFollowedButton = driver.findElement (By.xpath ("//*[text()='Followed']"));
        clickingFollowedButton.click ();
        System.out.println ("Successfully Clicked The Followed Button");

        // Checking wheather there is data present Or Not In the Followed If Not Navigate to the Next Module

        Thread.sleep (5000); // Waiting for the element display

        try {

            WebElement checkingNoDoubtsFound = driver.findElement (By.xpath ("//span[text()=\"No Doubts Found.\"]"));

            // Verifying That the element was present or Not

            boolean isnoDoubtsFoundDisplayed = false;

            try {

                isnoDoubtsFoundDisplayed = checkingNoDoubtsFound.isDisplayed ();

            } catch (NoSuchElementException e) {

                System.out.println ("No Doubt Found element not found.");

            }

            // Printing Wheather data was Found or Not By using Boolean

            System.out.println ("No Doubt Found displayed: " + isnoDoubtsFoundDisplayed);

            // In Here we are creating IF else condition for the navigations

            if (isnoDoubtsFoundDisplayed) {

                // Clicking The My Points button when No record Found was displayed

                Thread.sleep (4000);
                WebElement clickingMyPointsPage = driver.findElement (By.xpath ("//*[text()='My Points']"));
                clickingMyPointsPage.click ();
                System.out.println ("Successfully Clicked The My Points Button ");

            } else {

                System.out.println ("Data Was Present In The Followed Page");

            }
        } catch (NoSuchElementException e) {

            System.out.println ("Error In The Code " + e.getMessage ());

        }


    }


}

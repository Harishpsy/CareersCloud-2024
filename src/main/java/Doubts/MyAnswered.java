package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAnswered {

    WebDriver driver;


    public MyAnswered(WebDriver driver) {
        this.driver = driver;

    }

    public void myAnswered() throws InterruptedException {

        // Clciking My Answered Button in Doubt Page,

        Thread.sleep (3000);
        WebElement clickingMyAnsweredButton = driver.findElement (By.xpath ("//*[text()='My Answered']"));
        clickingMyAnsweredButton.click ();
        System.out.println ("SuccessFully Clicked The My Answered Button ");

        // Verifying My answer was present or Not by using try catch method

        try {

            try {
                // Pause execution for 10 seconds
                Thread.sleep (3000);

                boolean isNoDoubtFoundDisplayed = false;
                boolean isThreeDotsTriggerDisplayed = false;

                // Attempt to find and interact with the "No Doubts Found" element

                try {
                    System.out.println ("Searching for 'No Doubts Found' element");
                    WebElement noDoubtFound = driver.findElement (By.xpath ("(//*[text()='No Doubts Found.'])[1]"));
                    isNoDoubtFoundDisplayed = noDoubtFound.isDisplayed ();

                } catch (NoSuchElementException e) {
                    System.out.println ("'No Doubts Found' element not found.");
                }

                // Attempt to find and interact with the dropdown trigger element

                try {
                    System.out.println ("Searching for dropdown trigger element");
                    WebElement threeDotsTrigger = driver.findElement (By.xpath ("(//*[@class='ant-dropdown-trigger'])[16]"));
                    isThreeDotsTriggerDisplayed = threeDotsTrigger.isDisplayed ();
                } catch (NoSuchElementException e) {
                    System.out.println ("Dropdown trigger element not found.");
                }

                System.out.println ("'No Doubts Found' element displayed: " + isNoDoubtFoundDisplayed);
                System.out.println ("Dropdown trigger element displayed: " + isThreeDotsTriggerDisplayed);

                // Conditional logic for clicking elements
                if (isNoDoubtFoundDisplayed) {
                    Thread.sleep (5000); // Assuming you handle InterruptedException elsewhere
                    WebElement followedButton = driver.findElement (By.xpath ("//*[text()='Followed']"));
                    followedButton.click ();
                    System.out.println ("Successfully clicked the 'Followed' button");
                } else if (isThreeDotsTriggerDisplayed) {
                    Thread.sleep (5000);
                    WebElement threeDotsTrigger = driver.findElement (By.xpath ("(//*[@class='ant-dropdown-trigger'])[16]"));
                    threeDotsTrigger.click ();
                    System.out.println ("Successfully clicked the 'ThreeDots' trigger");
                } else {
                    System.out.println ("Neither 'Followed' button nor 'ThreeDots' trigger was found to click");
                }
            } catch (InterruptedException e) {
                System.out.println ("An error occurred: " + e.getMessage ());
            }

        } catch (Exception e) {
            System.out.println ("An unexpected error occurred: " + e.getMessage ());
        }
    }


}


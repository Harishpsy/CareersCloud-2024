package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mydoubts {

    WebDriver driver;

    public Mydoubts(WebDriver driver) {

        this.driver = driver;

    }

    public void myDoubts() throws InterruptedException {

        // Clicking My Doubts

        Thread.sleep (4000);
        WebElement clickingMyDoubts = driver.findElement (By.xpath ("//*[text()='My Doubts']"));
        clickingMyDoubts.click ();

        try {
            // Verifying if the "No Doubts Found" element is present or not
            boolean isNoRecordfoundDisplayed = false;

            try {
                Thread.sleep (5000); // Waiting for the element to be displayed
                WebElement noDoubtFound = driver.findElement (By.xpath ("//*[text()='No Doubts Found.']/ancestor::*[self::div and @id=\"rc-tabs-0-panel-2\"]"));
                isNoRecordfoundDisplayed = noDoubtFound.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ("Error in inner try block: No Doubts Found element not located.");
            }

            try {


            } catch (NoSuchElementException e) {

                System.out.println ("Error in inner try block2: Answer Found elementnot located");

            }


            // Verifying if the "No Doubts Found" element was displayed
            System.out.println ("'No Doubts Found' element displayed in My Doubts: " + isNoRecordfoundDisplayed);

            if (isNoRecordfoundDisplayed) {
                Thread.sleep (5000); // Waiting before performing the next action
                WebElement clickingMyAnsweredButton = driver.findElement (By.xpath ("//*[text()='My Answered']"));
                clickingMyAnsweredButton.click ();
                System.out.println ("Successfully clicked the 'My Answered' button from My Doubts.");
            } else {
                System.out.println ("Data was present in the Followed page.");
            }
        } catch (NoSuchElementException e) {
            System.out.println ("Error message in outer catch block: " + e.getMessage ());
        }


    }


}

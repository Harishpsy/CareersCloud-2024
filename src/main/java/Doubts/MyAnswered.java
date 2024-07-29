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

        Thread.sleep (5000);

        try {

            WebElement noDoubtFoundElement = driver.findElement (By.xpath ("//span[text()='No Doubts Found.']"));
            WebElement clickingThreeDots = driver.findElement (By.xpath ("(//*[@class=\"ant-dropdown-trigger\"])[16]"));

            boolean isNoDoubtFoundDisplayed = false;
            boolean isThreeDotsDisplayed = false;

            try {
                isNoDoubtFoundDisplayed = noDoubtFoundElement.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ("No Doubt Found element not found.");
            }

            try {
                isThreeDotsDisplayed = clickingThreeDots.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ("No Doubt Found element not found.");
            }

            System.out.println ("No Doubt Found displayed: " + isNoDoubtFoundDisplayed);
            System.out.println ("Threedots was displayed:" + isThreeDotsDisplayed);

            if (isNoDoubtFoundDisplayed) {

                Thread.sleep (4000); // Assuming you handle InterruptedException elsewhere
                WebElement followedButton = driver.findElement (By.xpath ("//*[text()='Followed']"));
                followedButton.click ();
                System.out.println ("Successfully Clicked The Followed Button");

            } else if (isThreeDotsDisplayed) {

                Thread.sleep (4000);
                WebElement clickingThreeDoubt = driver.findElement (By.xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
                clickingThreeDoubt.click ();
                System.out.println ("SuccessFully Clicked The ThreeDots");

            } else {

                System.out.println ("Followed button was not clicked");

            }

        } catch (NoSuchElementException e) {

            System.out.println ("An error occurred : " + e.getMessage ());

        } catch (Exception e) {

            System.out.println ("An error occurred: " + e.getMessage ());

        }


    }


}

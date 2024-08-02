package Doubts;

import MainPages.Login_page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAnswered {

    WebDriver driver;
    Login_page loginPage;


    public MyAnswered(WebDriver driver) {
        this.driver = driver;

    }

    public void myAnswered() throws InterruptedException {

        try {

            // Clicking My Answered Button in Doubt Page,

            WebElement clickingMyAnsweredButton = driver.findElement (By.xpath ("//*[text()='My Answered']"));

            if (clickingMyAnsweredButton.isSelected ()) {

                Thread.sleep (3000);
                System.out.println ("My Answered Button was already Selected");
            } else if (clickingMyAnsweredButton.isDisplayed ()) {

                Thread.sleep (5000);
                clickingMyAnsweredButton.click ();
                System.out.println ("Successfully clicked the My Answer button");

            } else {
                System.out.println ("Error Occured In The Above Code");
            }
            // Verifying My answer was present or Not by using try catch method
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

                System.out.println ("No Doubts Found' element displayed: " + isNoDoubtFoundDisplayed);
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

                    // Clicking The Share Button In the MyAnswered

                    Thread.sleep (5000);
                    WebElement clickingShareButtonInDoubt = driver.findElement (By.xpath ("//ul[@class=\"ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-xu9wm8\"]//preceding-sibling::li"));
                    clickingShareButtonInDoubt.click ();
                    System.out.println ("Successfully CLicked The Share Button ");

                    // Clicking The CopyLink Button In The Share

                    Thread.sleep (5000);
                    WebElement clickingCopyLink = driver.findElement (By.xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-link quiz-popup-modal-share-copy-url-button\"]"));
                    clickingCopyLink.click ();
                    System.out.println ("Successfully CLicked The Copylink Button ");

                    // Clicking The cancel Button In The Share Popup

                    Thread.sleep (5000);
                    WebElement clickingCancelButtonInPopup = driver.findElement (By.xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-default ant-btn-lg ant-btn-block quiz-popup-modal-share-footer-button\"]"));
                    clickingCancelButtonInPopup.click ();
                    System.out.println ("Successfully CLicked The Cancel Button ");

                    // Clicking The Answer

                    Thread.sleep (4000);
                    WebElement clickingAnswerButton = driver.findElement (By.xpath ("(//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary btn-answer\"])[15]"));
                    clickingAnswerButton.click ();

                    // Retreving The Username From the Doubt Answer

                    Thread.sleep (4000);
                    WebElement gettingUsernameFromDoubt = driver.findElement (By.xpath ("//*[@class=\"doubts-answer-user\"]"));
                    String doubtUserNames = gettingUsernameFromDoubt.getText ();
                    System.out.println ("UserNames: " + doubtUserNames);

                    // Calling LoginPage By Using Contructor

                    loginPage = new Login_page (driver);
                    String userName = loginPage.toString ();
                    // Verifying That the username is equal to Doubt username

                    Assert.assertEquals (doubtUserNames, userName + "Username and user name do not match!");

                } else {
                    System.out.println ("Neither 'Followed' button nor 'ThreeDots' trigger was found to click");
                }
            } catch (InterruptedException e) {
                System.out.println ("An error occurred: " + e.getMessage ());
            }
        } catch (NoSuchElementException e) {
            System.out.println ("Error " + e.getMessage ());
        }

    }


}




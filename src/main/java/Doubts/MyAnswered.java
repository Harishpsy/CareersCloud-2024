package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MyAnswered {

    WebDriver driver;
    public MyAnswered(WebDriver driver) {
        this.driver = driver;
    }

    @Test
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
                    WebElement clickingShareButtonInDoubt = driver.findElement ( By.xpath ( "(//*[@class=\"ant-dropdown-menu-title-content\"])[1]" ) );
                    //WebElement clickingShareButtonInDoubt = driver.findElement (By.xpath ("//ul[@class=\"ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-xu9wm8\"]//preceding-sibling::li"));
                    clickingShareButtonInDoubt.click ();
                    System.out.println ("Successfully CLicked The Share Button ");

                    // Clicking The CopyLink Button In The Share
                    Thread.sleep (5000);

                    //  WebElement clickingCopyLink = driver.findElement (By.xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-link quiz-popup-modal-share-copy-url-button\"]"));
                    WebElement clickingCopyLink = driver.findElement ( By.xpath ( "//*[text()='COPY LINK']" ) );
                    clickingCopyLink.click ();
                    System.out.println ("Successfully CLicked The Copylink Button ");

                    // Clicking The cancel Button In The Share Popup
                    Thread.sleep (5000);
                    WebElement clickingCancelButtonInPopup = driver.findElement ( By.xpath ( "//*[@class=\"ant-btn css-f7vrd6 ant-btn-default ant-btn-lg ant-btn-block quiz-popup-modal-share-footer-button\"]" ) );
                    clickingCancelButtonInPopup.click ();
                    System.out.println ("Successfully CLicked The Cancel Button ");

                    // This method needs to work once the developing tean finish the work
//                    //Clicking The Answer
//                    List<WebElement> clickingAnswerButton = driver.findElements(By.xpath("//*[text()='Answer']"));
//                    for (WebElement answeredClick : clickingAnswerButton) {
//                        String myAnswer = answeredClick.getText ();
//                        System.out.println ("Name:"+ myAnswer);
//                        answeredClick.click ();  // Click the myanswer element
//                    }

                    // Needs to write this in loop There is an issue in that once it fix we can move further
                    //Clicking The Answer
                    Thread.sleep ( 4000 );
                    WebElement clickingAnswerbutton = driver.findElement ( By.xpath ( "(//*[text()='Answer'])[150]" ) );
                    clickingAnswerbutton.click ();

                    // Retreving The Username From the Doubt Answer
                    Thread.sleep (4000);
                    WebElement gettingUsernameFromDoubt = driver.findElement (By.xpath ("//*[@class=\"doubts-answer-user\"]"));
                    String doubtUserNames = gettingUsernameFromDoubt.getText ();
                    System.out.println ("UserNames: " + doubtUserNames);

                    // Verifying That the username is equal to Doubt username
                    // It was still in pending Needs to find an way to Solve that issue

                    //Clicking The close icon in the MyAnswer > User Doubt > Popup
                    Thread.sleep ( 3000 );
                    WebElement clickingcloseicon = driver.findElement ( By.xpath ( "//div[@class=\"doubt-answer-btn\"]" ) );
                    clickingcloseicon.click ();

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




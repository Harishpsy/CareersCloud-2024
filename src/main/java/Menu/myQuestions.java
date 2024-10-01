package Menu;

import PageObjectModule.Myquestionpageobject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static PageObjectModule.Myquestionpageobject.*;
import static org.openqa.selenium.By.xpath;

public class myQuestions {
    WebDriver driver;

    public myQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void Myquestion() throws InterruptedException {

        PageFactory.initElements ( driver , Myquestionpageobject.class );

        // Clicking The My Questions
        Thread.sleep ( 3000 );
        clickingMyQuestion.click ();
        System.out.println ( "Succesfully Clicked The My Question" );

        try {
            // Check if noRecordFound element is displayed and log the result
            Thread.sleep ( 5000 );
            boolean noRecordFoundDisplayed = false;

            try {
                noRecordFoundDisplayed = noRecordsFoundMyQuestion.isDisplayed ();
            } catch (NoSuchElementException e) {
                System.out.println ( "noRecordFound element not found in My Question." );
            }
            System.out.println ( "noRecordFound displayed: " + noRecordFoundDisplayed );

            if (noRecordFoundDisplayed) {
                Thread.sleep ( 5000 );
                clickingTheMyEbooks.click ();
                System.out.println ( "No records found message is displayed In My Questions, navigating to My Ebooks page." );
            } else if (clickingMyQuestion.isDisplayed ()) {
                System.out.println ( "Entered In To If-else Statement" );

                if (clickingMyQuestion.isSelected ()) {

                    System.out.println ( "SucessFully My coin is selected 1" );
                    Thread.sleep ( 5000 );
                    clickBookMarkQuestion.click ();
                    System.out.println ( "SucessFully clicked the clicking My Question " );

                } else if (clickingMyQuestion.isDisplayed ()) {
                    System.out.println ( "SucessFully My Question Is Displayed" );
                    Thread.sleep ( 5000 );
                    clickingMyQuestion.click ();

                    // Clicking The Bookmarked Question
                    if (clickingMyQuestion.isEnabled ()) {

                        Thread.sleep ( 5000 );
                        clickBookMarkQuestion.click ();
                        System.out.println ( "Sucessfully Clicked the My Question Page " );
                    } else {
                        System.out.println ( "Error occured " );
                    }
                } else {
                    System.out.println ( "Both has been not excecuted" );
                }
                // Click The UnBookMark Icon
                // Thread.sleep (3000);
                // clickingUnBookmarkIcon.click ();

                // Clicking The Quiz BackButton
                Thread.sleep ( 5000 );
                quizBackButton.click ();

                // Click The BookMarked Question
                Thread.sleep ( 5000 );
                clickBookMarkQuestion.click ();

                // Define the options to be clicked
                String[] options = new String[]{"B" , "A" , "E" , "C"};

                // Clicking the options and Save & Next button in a loop
                for (String option : options) {
                    Thread.sleep ( 3000 );
                    WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + option + "']" ) );
                    optionElement.click ();
                    System.out.println ( "Successfully Clicked The Option: " + option );

                    //Clicking The Next Button
                    try {
                        WebElement nextButton = driver.findElement ( xpath ( "//*[text()='Next']" ) );
                        if (nextButton.isDisplayed ()) {
                            nextButton.click ();
                            System.out.println ( "Successfully clicked the Next button." );
                        } else {
                            System.out.println ( "Next button is not displayed." );
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println ( "Next button was not found on the page." );
                    }

                }
                // Clicking options again after navigating back
                for (int i = 0; i < options.length - 2; i++) {
                    try {
                        Thread.sleep ( 3000 );

                        // Click the option
                        WebElement optionElement = driver.findElement ( xpath ( "//div[text()='" + options[i] + "']" ) );
                        optionElement.click ();
                        System.out.println ( "Successfully clicked the option: " + options[i] );

                        Thread.sleep ( 3000 );

                        // Try to find and click the number on the right side
                        List<WebElement> numberOnRightSideList = driver.findElements ( xpath ( "//span[text()='" + (6 + i) + "']" ) );
                        if (!numberOnRightSideList.isEmpty ()) {
                            WebElement numberOnRightSide = numberOnRightSideList.get ( 0 );
                            numberOnRightSide.click ();
                            System.out.println ( "Successfully clicked the number and navigated to the next question: " + (6 + i) );
                        } else {
                            System.out.println ( "Number " + (6 + i) + " not found, skipping to the next iteration." );
                        }

                    } catch (InterruptedException e) {
                        System.out.println ( "Thread sleep was interrupted." );
                    } catch (NoSuchElementException e) {
                        System.out.println ( "Failed to find an element during the loop." );
                    }
                }

                // Clicking The Previous Button
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
                try {
                    if (clickingThePreviousButton.isDisplayed ()) {
                        clickingThePreviousButton.click ();
                        System.out.println ( "Successfully clicked the Previous button." );
                    } else {
                        System.out.println ( "Previous button is not displayed." );
                    }
                } catch (NoSuchElementException e) {
                    System.out.println ( "Previous button was not found on the page." );
                }

                // Clicking The Share Icon In The MyQuestion
                Thread.sleep ( 3000 );
                clickingTheShareIcon.click ();

                //click the copy link in the share popup
                Thread.sleep ( 3000 );
                WebElement Copy_link = driver.findElement ( xpath ( "//span[text()='COPY LINK']" ) );
                Copy_link.click ();

                //Clicking the cancel button in the in share popup
                WebDriverWait waitforCancelButtonclick = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
                WebElement Cancel_button = driver.findElement ( xpath ( "//span[text()='Cancel']" ) );
                Cancel_button.click ();

                // Scrolling The My Question Page
                Thread.sleep ( 1000 );
                Actions actions = new Actions ( driver );
                actions.scrollToElement ( scrollToReportIcon ).perform ();
                scrollToReportIcon.click ();

                // Click The Translation Error In The Report Popup
                Thread.sleep ( 3000 );
                clickingTranslationErrorRadioButton.click ();

                //Entering the text inside the report text field In Solution Page
                Enter_the_report.sendKeys ( "Checking The text was Entering In The Report Text Field" );

                // Click the report button
                // Thread.sleep (3000);
                // Report_button.click ();

                // Clicking The Cancel Button In The Report Popup
                clickingCancelButtonInReport.click ();

                // Clicking The Quiz BackButton
                Thread.sleep ( 4000 );
                quizBackButton.click ();

            } else {
                System.out.println ( "Both the code was Executed In The My Question " );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "Error Msg In The Inner If Else Statement " + e.getMessage () );
        }
    }
}




package Menu;

import PageObjectModule.Myquestionpageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PageObjectModule.Myquestionpageobject.*;
import static org.openqa.selenium.By.xpath;

public class Menu_MyQuestions {
    WebDriver driver;

    public Menu_MyQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void Myquestion() throws InterruptedException {

        PageFactory.initElements (driver, Myquestionpageobject.class
        );

        // Clicking My Question Button

        Thread.sleep (7000);
        clickingMyQuestion.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        clickBookMarkQuestion.click ();

//        // Click The UnBookMark Icon

//        Thread.sleep (3000);
//        clickingUnBookmarkIcon.click ();

        // Clicking The Quiz BackButton

        Thread.sleep (3000);
        quizBackButton.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        clickBookMarkQuestion.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_D.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B.click ();


        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingThePreviousButton.click ();

        // Clicking The Share Icon In The MyQuestion

        Thread.sleep (3000);
        clickingTheShareIcon.click ();

        //click the copy link in the share popup

        Thread.sleep (3000);
        WebElement Copy_link = driver.findElement (xpath ("//span[text()='COPY LINK']"));
        Copy_link.click ();

        //Clicking the cancel button in the in share popup

        WebDriverWait waitforCancelButtonclick = new WebDriverWait (driver, Duration.ofSeconds (30));
        WebElement Cancel_button = driver.findElement (xpath ("//span[text()='Cancel']"));
        Cancel_button.click ();

        // Scrolling The My Question Page

        Thread.sleep (1000);
        Actions actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button.click ();*/

        // Clicking The Quiz BackButton

        Thread.sleep (4000);
        quizBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        clickingHomeButton.click ();
    }

}

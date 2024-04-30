package Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class Menu_MyQuestions {
    WebDriver driver;

    public Menu_MyQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void Myquestion() throws InterruptedException {


        // Clicking My Question Button

        Thread.sleep (7000);
        WebElement clickingMyQuestion = driver.findElement (xpath ("//*[@id=\"2\"]"));
        clickingMyQuestion.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        WebElement clickBookMarkQuestion = driver.findElement (xpath ("//div[@class=\"ant-card-cover\"]"));
        clickBookMarkQuestion.click ();

//        // Click The UnBookMark Icon

//        Thread.sleep (3000);
//        WebElement clickingUnBookmarkIcon = driver.findElement (xpath ("//*[@class=\"bookmarked-icon\"]"));
//        clickingUnBookmarkIcon.click ();

        // Clicking The Quiz BackButton

        Thread.sleep (3000);
        WebElement quizBackButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        quizBackButton.click ();

        // Click The BookMarked Question

        Thread.sleep (5000);
        clickBookMarkQuestion = driver.findElement (xpath ("//div[@class=\"ant-card-cover\"]"));
        clickBookMarkQuestion.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Third Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_C = driver.findElement (xpath ("//div[text()='C']"));
        clickingTheOption_C.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Fourth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_D = driver.findElement (xpath ("//div[text()='D']"));
        clickingTheOption_D.click ();

        //Clicking The Next Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingNextbutton = driver.findElement (xpath ("//div[text()='Next']"));
        clickingNextbutton.click ();

        // Clicking the Fifth Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingTheOption_E = driver.findElement (xpath ("//div[text()='E']"));
        clickingTheOption_E.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber6OnTheRigntSide = driver.findElement (xpath ("//Span[text()='6']"));
        clickingTheNumber6OnTheRigntSide.click ();

        // Clicking the First Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_A = driver.findElement (xpath ("//div[text()='A']"));
        clickingTheOption_A.click ();

        // Clicking The Number on the right side Count Status

        WebElement clickingTheNumber7OnTheRightSide = driver.findElement (xpath ("//Span[text()='7']"));
        clickingTheNumber7OnTheRightSide.click ();

        // Clicking the Second Option

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        clickingTheOption_B = driver.findElement (xpath ("//div[text()='B']"));
        clickingTheOption_B.click ();


        // Clicking The Previous Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (5));
        WebElement clickingThePreviousButton = driver.findElement (xpath ("//div[text()='Previous']"));
        clickingThePreviousButton.click ();

        // Clicking The Share Icon In The MyQuestion

        Thread.sleep (3000);
        WebElement clickingTheShareIcon = driver.findElement (xpath ("//*[@alt=\"share\"]"));
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
        WebElement scrollToReportIcon = driver.findElement (xpath ("//*[@class=\"report-image\"]"));
        Actions actions = new Actions (driver);
        actions.scrollToElement (scrollToReportIcon).perform ();
        scrollToReportIcon.click ();

        // Click The Translation Error In The Report Popup

        Thread.sleep (3000);
        WebElement clickingTranslationErrorRadioButton = driver.findElement (xpath ("//span[text()='Translations Error']"));
        clickingTranslationErrorRadioButton.click ();

        //Entering the text inside the report text field In Solution Page

        WebElement Enter_the_report = driver.findElement (name ("reportDescription"));
        Enter_the_report.sendKeys ("Checking The text was Entering In The Report Text Field");

        // Click the report button

        Thread.sleep (3000);
        WebElement Report_button = driver.findElement (xpath ("//span[text()='REPORT']"));
        Report_button.click ();

        /* // Clicking The Cancel Button

        Cancel_button = driver.findElement (xpath ("//span[text()='CANCEL']"));
        Cancel_button.click ();*/

        // Clicking The Quiz BackButton

        Thread.sleep (4000);
        quizBackButton = driver.findElement (xpath ("//*[@class=\"anticon anticon-arrow-left back-icon\"]"));
        quizBackButton.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();
    }

}

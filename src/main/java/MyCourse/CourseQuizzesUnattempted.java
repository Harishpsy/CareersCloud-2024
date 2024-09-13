package MyCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseQuizzesUnattempted extends CourseQuizAttempted {

    WebDriver driver;

    public CourseQuizzesUnattempted(WebDriver driver) throws InterruptedException {

        this.driver = driver;
    }

    public void unAttempted() throws InterruptedException {

        WebElement clickingUnAttempted = driver.findElement ( By.xpath ( "//*[contains(text(), 'Unattempted')]" ) );
        WebDriverWait wait = new WebDriverWait ( driver , Duration.ofSeconds ( 30 ) );
        WebElement clickingStartQuiz = wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "(//*[text() = ' Start Quiz '])[1]" ) ) );
        WebElement clickingAttemptedTab = driver.findElement ( By.xpath ( "//*[text()='Attempted']" ) );

        if (clickingUnAttempted.isDisplayed ()) {
            Thread.sleep ( 5000 ); // Pause to allow the element to be fully interactive
            clickingUnAttempted.click ();
            System.out.println ( "Successfully Clicked The Unattempted Tab" );

            // Clicking The Start Quiz button
            clickingStartQuiz.click ();
            System.out.println ( "Successfully Clicked the Start button" );

        } else if (clickingUnAttempted.isEnabled ()) {

            // Clicking The Start Quiz button because the Unattempted tab is already selected
            clickingStartQuiz.click ();
            System.out.println ( "Successfully Clicked the Start button because Unattempted tab was already clicked" );

        } else if (clickingAttemptedTab.isDisplayed ()) {

            // Perform action related to the Attempted tab
            CourseQuizAttempted attempted = new CourseQuizAttempted ( driver );
            attempted.attemptedTab ();

        } else {
            System.out.println ( "Neither Unattempted nor Attempted tab actions were performed" );
        }
    }
}



























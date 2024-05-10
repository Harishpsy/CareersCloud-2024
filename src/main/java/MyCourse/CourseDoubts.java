package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CourseDoubts {
    WebDriver driver;

    public CourseDoubts(WebDriver driver) {

        this.driver = driver;
    }

    public void Doubts() throws InterruptedException {

        // Clicking The My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();

        // Clicking The First Course Card In the My Course

        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement (xpath ("(//*[@class=\"ant-card-body\"])[1]"));
        clickingFirstCourseCard.click ();

        // Clicking the Doubts Tab

        WebElement clickingDoubts = driver.findElement (id ("rc-tabs-0-tab-8"));
        clickingDoubts.click ();

        // Clicking the Follow Icon

        WebElement clickingFollowicon = driver.findElement (xpath ("//*[@alt=\"follow\"]"));
        clickingFollowicon.click ();

        // Clicking the Answer Icon

        WebElement clickingAnswericon = driver.findElement (id ("comments-icon"));
        clickingAnswericon.click ();

        // Entering the text

        WebElement Enteringtext = driver.findElement (id ("teatx-area-id"));
        Enteringtext.sendKeys ("Thanks");

        // Clicking the Send button

        Thread.sleep (3000);
        WebElement clickingSendbutton = driver.findElement (xpath ("//*[@alt=\"send_doubts\"]"));
        clickingSendbutton.click ();


    }


}

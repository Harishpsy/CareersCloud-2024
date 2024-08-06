package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class myCourse {

    WebDriver driver;

    public myCourse(WebDriver driver) {

        this.driver = driver;
    }

    public void myCourseClicking() {

        // Clicking My Course Button

        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (30));
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//* [text()='My Course']"));
        clickingMyCourseButton.click ();
        System.out.println ("Successfully Clicked The My Course");
    }
}

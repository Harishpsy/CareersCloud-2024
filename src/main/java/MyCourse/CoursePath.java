package MyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class CoursePath {

    WebDriver driver;

    public CoursePath(WebDriver driver) {
        this.driver = driver;
    }
    public void Path() throws InterruptedException {

        // Clicking The First Course Card In the My Course
        Thread.sleep (3000);
        WebElement clickingFirstCourseCard = driver.findElement ( xpath ( "(//*[@class=\"my-courses-banner-image\"])[2]" ) );
        clickingFirstCourseCard.click ();

    }
    // Path Arrow Pending

}

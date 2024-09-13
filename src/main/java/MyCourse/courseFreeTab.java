package MyCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class courseFreeTab {

    WebDriver driver;

    public courseFreeTab(WebDriver driver) {
        this.driver = driver;
    }

    public void freeTab() {

        // Clicking The Course Card In The My Course Page
        WebElement clickingCourseCard = driver.findElement ( By.xpath ( "(//*[@class=\"my-courses-banner-image\"])[2]" ) );
        clickingCourseCard.click ();
        System.out.println ( "Successfully Clicked The Course card " );

        //clicking The Free Tab In The Course List Page
        WebElement clickingFreeTab = driver.findElement ( By.xpath ( "//*[@id=\"rc-tabs-0-tab-10\"]" ) );
        clickingFreeTab.click ();
        System.out.println ( "SuccessFully Clicked The Free Tab In The Course List Page" );

    }

}

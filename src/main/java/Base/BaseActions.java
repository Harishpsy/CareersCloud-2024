package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class BaseActions {
    WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void Scroll() {

        // Scrolling The Quizzes List Page to verify data
        int numberOfTimesScrollQuizzes = 5;

        for (int i = 0; i < numberOfTimesScrollQuizzes; i++) {

            try {
                Thread.sleep ( 5000 );
                JavascriptExecutor jse = (JavascriptExecutor) driver; // javascript executer for scrolling the page
                jse.executeScript ( "window.scrollTo(0,document.body.scrollHeight)" );
                System.out.println ( "Successfully scroll The pages " + (i + 1) + " time(s)." );
            } catch (Exception scroll) {
                System.out.println ( "Failed to Scroll : " + scroll.getMessage () );
            }
        }
    }

    @Test(enabled = true)
    public void floatButton() {

        // Clicking Float Icon
        try {
            WebElement clickingFloatIcon = driver.findElement ( xpath ( "//*[@class=\"ant-float-btn-content\"]" ) );
            if (clickingFloatIcon.isDisplayed ()) {
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 30 ) );// using implicity wait
                clickingFloatIcon.click ();
                System.out.println ( "Successfully Clicked The Float Icon" );
            } else {
                System.out.println ( "Float Icon Is Not Displayed" );
            }
        } catch (NoSuchElementException e) {
            System.out.println ( "FloatIcon Button Is Not Displayed" );
        }
    }

    @Test(enabled = true)
    public void imdentifingDuplicaye() {
        // Verifying The list of Articles any one of them was getting Duplicate or Not
        // Finding All The elements From the Article components
        List<WebElement> allName = driver.findElements ( xpath ( "//*[@class=\"ant-col column ant-col-xs-23 ant-col-sm-23 ant-col-md-23 ant-col-lg-23 ant-col-xl-23 ant-col-xxl-23 css-xu9wm8\"]" ) );

        // Create a set to store unique Article URLs
        Set<String> uniqueName = new HashSet<> ();
        int uniquesCount = 0;

        // Iterate through the list of elements
        for (WebElement articleElementUrl : allName) {
            String actualCardsName = articleElementUrl.getText ();
            //    System.out.println ( "Original Article Name: " + actualArticleName );
            if (uniqueName.contains ( actualCardsName )) {
                System.out.println ( "Duplicate In The List Page found --> " + actualCardsName );
            } else {
                uniqueName.add ( actualCardsName );
                uniquesCount++;
                // System.out.println ( "Article Found: " + uniquesArticleCount + " --> " + actualArticleName );
                //  System.out.println ( "-------------------------------------------------------------------------" );
            }
        }
        // Print the total number of unique URLs found
        System.out.println ( "Total unique Article Name found: " + uniquesCount );

        // Assert that the number of unique URLs is equal to the number of elements
        Assert.assertEquals ( uniquesCount , uniqueName.size () );


    }


}

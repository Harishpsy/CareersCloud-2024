package Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class Menu_MyPoints {

    WebDriver driver;

    public Menu_MyPoints(WebDriver driver) {
        this.driver = driver;
    }

    public void MyPoints() throws InterruptedException {

        // Clicking The My Points

        Thread.sleep (3000);
        WebElement clickingMyPoints = driver.findElement (xpath ("//*[@id=\"5\"]"));
        clickingMyPoints.click ();

        // Clicking The View Earn Points

        Thread.sleep (3000);
        WebElement clickingViewEarnPoints = driver.findElement (xpath ("//span[text()='View Earn Points']"));
        clickingViewEarnPoints.click ();

        // Clicking The close Button

        Thread.sleep (5000);
        WebElement clickingCloseIcon = driver.findElement (xpath ("//*[@class=\"ant-modal-close-x\"]"));
        clickingCloseIcon.click ();

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(0,document.body.scrollHeight)");

        // Clicking The Dropdown Menu

        WebElement clickingDropDown = driver.findElement (xpath ("//*[@class=\"icon-vector ant-collapse-arrow\"]"));
        Actions actions = new Actions (driver);
        actions.scrollToElement (clickingDropDown).perform ();
        clickingDropDown.click ();

        // Clicking The Home Button

        Thread.sleep (2000);
        WebElement clickingHomeButton = driver.findElement (xpath ("//a[text()='Home']"));
        clickingHomeButton.click ();


    }


}

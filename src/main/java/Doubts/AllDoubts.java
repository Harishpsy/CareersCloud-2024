package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AllDoubts {

    WebDriver driver;

    public AllDoubts(WebDriver driver) {

        this.driver = driver;
    }

    public void allDoubts() throws AWTException, InterruptedException {

        // Clicking The Create Doubt Button

        WebElement clickingCreateButton = driver.findElement (By.xpath ("//*[@class=\"ant-btn css-xu9wm8 ant-btn-primary add-doubts-btn\"]"));
        clickingCreateButton.click ();


        // Clicking the search textfield and searching the course

        Thread.sleep (5000);
        WebElement clickingSearch = driver.findElement (By.xpath ("(//*[@name=\"comments2\"])[2]"));
        clickingSearch.sendKeys ("Mock");

        // Pressing The KeyBoard Action

        Robot robot = new Robot ();

        // clicking The Enter Button

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releasing The Enter Button

        Thread.sleep (5000);
        robot.keyRelease (KeyEvent.VK_ENTER);

        // Pressing Backspace Button In The Keyboard

        // Set the number of times to perform the action

        int numberOfTimes = 4;

        // Creating an Loop to performe this action multiple times

        for (int i = 0; i < numberOfTimes; i++) {
            Thread.sleep (3000);
            robot.keyPress (KeyEvent.VK_BACK_SPACE);
        }

        // Releasing the BackSpace

        robot.keyRelease (KeyEvent.VK_BACK_SPACE);

        // Pressing The Enter Button In The Keyboard

        Thread.sleep (3000);
        robot.keyPress (KeyEvent.VK_ENTER);

        // Releassing The Enter Button In The Keyboard

        robot.keyRelease (KeyEvent.VK_ENTER);

        // Scroll The Page Using Java Executer


    }


}

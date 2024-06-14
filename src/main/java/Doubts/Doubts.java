package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Doubts {

    WebDriver driver;

    public Doubts(WebDriver driver) {

        this.driver = driver;
    }

    public void doubts() throws InterruptedException {

        Thread.sleep (5000);
        WebElement clickingDoubtsButton = driver.findElement (By.xpath ("//a[text()='Doubts']"));
        clickingDoubtsButton.click ();

    }


}

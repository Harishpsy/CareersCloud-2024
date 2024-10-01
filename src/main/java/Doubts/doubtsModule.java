package Doubts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class doubtsModule {

    WebDriver driver;

    public doubtsModule(WebDriver driver) {

        this.driver = driver;
    }
    public void doubts() throws InterruptedException {

        // Click The Doubts Button In The Header
        Thread.sleep ( 5000 ); // Waiting for element visible
        WebElement clickingDoubtsButton = driver.findElement (By.xpath ("//*[text()='Doubts']"));
        clickingDoubtsButton.click ();
        System.out.println ("SuccessFully Clicked The Doubts Button");

    }

}

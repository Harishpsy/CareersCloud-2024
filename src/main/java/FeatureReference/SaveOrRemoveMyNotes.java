package FeatureReference;

import org.openqa.selenium.WebElement;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class SaveOrRemoveMyNotes {

    public void SaveOrRemove() throws InterruptedException {

        //Clicking The save My Notes or Remove my notes

        Thread.sleep (3000);
        WebElement clickMyNote = driver.findElement (xpath ("//*[contains(text(), 'Save to My Notes') or contains(text(), 'Remove My  Notes')]"));

        if (clickMyNote.isDisplayed ()) {
            clickMyNote.click ();

            if (clickMyNote.getText ().contains ("Remove My  Notes")) {
                System.out.println ("Successfully -  Remove - Article");
            } else {
                System.out.println ("Successfully -  saved - Article");
            }
        }

    }
}


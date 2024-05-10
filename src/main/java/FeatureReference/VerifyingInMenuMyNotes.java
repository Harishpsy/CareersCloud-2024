package FeatureReference;

import org.openqa.selenium.WebElement;

import java.util.List;

import static MainPages.Login_page.driver;
import static org.openqa.selenium.By.xpath;

public class VerifyingInMenuMyNotes {

    final List<WebElement> savedArticle = driver.findElements (xpath ("//img[@src='https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp']"));

    // Using Assertion Method

    public void MenuMyNotes() {

        // Verifying the article in my notes

        final List<WebElement> savedarticle = driver.findElements (xpath ("//*[@src=\"https://assets.careerscloud.in/course/article/images/57f0d0c460019c05a8f66e6a9b3476d0.webp\"]"));

        // Verification (assuming you have a way to verify card existence)

        if (savedarticle.isEmpty ()) {

            System.out.println ("Verification Failed : Article not present ");

        } else {

            System.out.println ("Verification Passed: 'Article present...' cards.");
        }
    }
//        Assert.assertEquals (savedArticle.isEmpty (), "Verification failed: 'Article was not present...' ");
//        System.out.println ("Verification Passed: 'Article present...'.");
}

package FeatureReference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static MainPages.Login_page.driver;

public class VerifyingUsingGetTextMethod {

    public void Gettext() throws InterruptedException {

        // Getting the text From The All Filter and Verifying there is any duplicate present

        Thread.sleep (5000);

        // Fetching the text from the doubt-sidebar-body element

        WebElement printingTheAllFilter = driver.findElement (By.id ("doubt-sidebar-body"));
        String allText = printingTheAllFilter.getText ();
        System.out.println (allText);
        System.out.println ("-------------------------------------------------------");

        // Verifying the All Filter by using the Assertion method

        String[] courseNames = allText.split ("\n"); // Splitting text into course names

        System.out.println ("SuccessFully Fetching The Course Names -->" + Arrays.toString (courseNames));

        // Fetching the course list elements

        List<WebElement> courseLists = driver.findElements (By.xpath ("//div[@class='doubt-left-sidebar-course-body']"));

        Set<String> uniqueCourse = new HashSet<> ();
        int uniqueCourseCount = 0;

        // Iterating through course lists to find unique courses and count matches
        for (WebElement courseList : courseLists) {
            String actualCourseList = courseList.getText ().trim ();

            if (uniqueCourse.contains (actualCourseList)) {
                System.out.println ("Duplicate found --> " + actualCourseList);
            } else {
                uniqueCourse.add (actualCourseList);

                if (Arrays.asList (courseNames).contains (actualCourseList)) {
                    uniqueCourseCount++;
                    System.out.println ("Found: " + uniqueCourseCount + " --> " + actualCourseList);
                }
            }
        }

        System.out.println ("Total unique CourseName found: " + uniqueCourseCount);
        Assert.assertEquals (uniqueCourseCount, courseNames.length);
    }
}

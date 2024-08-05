//package FeatureReference;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static MainPages.Login_page.driver;
//import static org.openqa.selenium.By.xpath;
//
//public class VerifyingUsingGetTextMethod {
//
//    public void Gettext() throws InterruptedException {
//
//        // Getting the text From The All Filter and Verifying there is any duplicate present
//
//        Thread.sleep (5000);
//
//        // Fetching the text from the doubt-sidebar-body element
//
//        WebElement printingTheAllFilter = driver.findElement (By.id ("doubt-sidebar-body"));
//        String allText = printingTheAllFilter.getText ();
//        System.out.println (allText);
//        System.out.println ("-------------------------------------------------------");
//
//        // Verifying the All Filter by using the Assertion method
//
//        String[] courseNames = allText.split ("\n"); // Splitting text into course names
//
//        System.out.println ("SuccessFully Fetching The Course Names -->" + Arrays.toString (courseNames));
//
//        // Fetching the course list elements
//
//        List<WebElement> courseLists = driver.findElements (By.xpath ("//div[@class='doubt-left-sidebar-course-body']"));
//
//        Set<String> uniqueCourse = new HashSet<> ();
//        int uniqueCourseCount = 0;
//
//        // Iterating through course lists to find unique courses and count matches
//        for (WebElement courseList : courseLists) {
//            String actualCourseList = courseList.getText ().trim ();
//
//            if (uniqueCourse.contains (actualCourseList)) {
//                System.out.println ("Duplicate found --> " + actualCourseList);
//            } else {
//                uniqueCourse.add (actualCourseList);
//
//                if (Arrays.asList (courseNames).contains (actualCourseList)) {
//                    uniqueCourseCount++;
//                    System.out.println ("Found: " + uniqueCourseCount + " --> " + actualCourseList);
//                }
//            }
//        }
//
//        System.out.println ("Total unique CourseName found: " + uniqueCourseCount);
//        Assert.assertEquals (uniqueCourseCount, courseNames.length);
//
//
//        // Another Method to find the duplicate values
//
//
//        // Find all elements with the specified class
//
//        List<WebElement> allDoubtImageURL = driver.findElements (xpath ("//*[@class='ant-image-img css-xu9wm8']"));
//
//        // Create a set to store unique URLs
//
//        Set<String> uniqueDoubtUrls = new HashSet<> ();
//        int uniqueDoubtUrlCount = 0;
//
//        // Iterate through the list of elements
//
//        for (WebElement doubtUrlElement : allDoubtImageURL) {
//            String actualDoubtImageUrl = doubtUrlElement.getAttribute ("src");
//            System.out.println (actualDoubtImageUrl);
//
//            if (uniqueDoubtUrls.contains (actualDoubtImageUrl)) {
//                System.out.println ("Duplicate found --> " + actualDoubtImageUrl);
//            } else {
//                uniqueDoubtUrls.add (actualDoubtImageUrl);
//                uniqueDoubtUrlCount++;
//                System.out.println ("Found: " + uniqueDoubtUrlCount + " --> " + actualDoubtImageUrl);
//                System.out.println ("-------------------------------------------------------------------------");
//            }
//        }
//
//        // Print the total number of unique URLs found
//        System.out.println ("Total unique image URLs found: " + uniqueDoubtUrlCount);
//
//        // Assert that the number of unique URLs is equal to the number of elements
//        Assert.assertEquals (uniqueDoubtUrlCount, uniqueDoubtUrls.size ());
//
//    }
//}

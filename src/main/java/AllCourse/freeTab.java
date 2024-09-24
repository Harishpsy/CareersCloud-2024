package AllCourse;

import MyCourse.courseFreeTab;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class freeTab {
    WebDriver driver;

    public freeTab(WebDriver driver) {
        this.driver = driver;
    }

    public void free() throws InterruptedException {
        // Clicking Free Tab In the all course list page

        try {
            WebElement clickingFreeTab = driver.findElement ( By.xpath ( "//*[text()='Free']" ) );

            if (clickingFreeTab.isSelected ()) {
                System.out.println ( "Free Tab Is Already Selected, We Are Performing The Below Actions In The Free Tab List Page" );
            } else if (clickingFreeTab.isDisplayed ()) {
                clickingFreeTab = driver.findElement ( By.xpath ( "//*[text()='Free']" ) );
                clickingFreeTab.click ();
                System.out.println ( "Successfully Clicked The Free Tab, And Performing The action In The " );
            } else {
                System.out.println ( "Both The Code Has Not Executed In The All Course Free Tab" );
            }

        } catch (NoSuchElementException e) {
            System.out.println ( "Error In The All Course Free Tab: " + e.getMessage () );
        }

        // Calling The Object From My Course Free Tab TO Performe The Action In The All Course List Page

        // Performing The Article
        courseFreeTab article = new courseFreeTab ( driver );
        article.artilces ();

        //Performing The Ebook
        courseFreeTab ebook = new courseFreeTab ( driver );
        ebook.Ebooks ();

//        // Performing The Videos
//        courseFreeTab videos = new courseFreeTab ( driver );
//        videos.videos ();

        // Performing the start quiz action
        courseFreeTab startquiz = new courseFreeTab ( driver );
        startquiz.quizStart ();

        //Performing The resume quiz
        courseFreeTab resumequiz = new courseFreeTab ( driver );
        resumequiz.resumeQuiz ();

        // Performing The Solutions Action
        courseFreeTab solutionquiz = new courseFreeTab ( driver );
        solutionquiz.quizSolutions ();


    }

}

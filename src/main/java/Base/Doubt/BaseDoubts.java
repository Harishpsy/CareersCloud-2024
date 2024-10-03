package Base.Doubt;

import Doubts.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class BaseDoubts {
    WebDriver driver;

    public BaseDoubts(WebDriver driver) {
        this.driver = driver;
    }

    @Test(enabled = true)
    public void doubtsModule() throws InterruptedException, AWTException {

        // Clicking The Doubts Module In The Header Section Of The Website
        doubtsModule doubts = new doubtsModule ( driver );
        doubts.doubts ();

        // Performing The Sub-Modules Actions Of The Doubts Module
        BaseDoubts actions = new BaseDoubts ( driver );
        actions.baseDoubts ();
    }

    @Test(enabled = true)
    private void baseDoubts() throws InterruptedException, AWTException {

        // Creating Object For The All Doubts
        AllDoubts allDoubts = new AllDoubts ( driver ); // We Are Calling From The Doubts Module
        allDoubts.allDoubts ();

        //Creating Object For The My Doubts
        Mydoubts myDoubts = new Mydoubts ( driver );// We Are Calling Form The My Course Module
        myDoubts.myDoubts ();

        //Creating Object For The My Answered
        MyAnswered answered = new MyAnswered ( driver );// We Are Calling Form The My Course Module
        answered.myAnswered ();

        // Creating Object For The My Followed
        Myfollowed myFollowed = new Myfollowed ( driver ); // We Are Calling Form The My Course Module
        myFollowed.myFollow ();

        // My Points in the Doubts Page
        Mypoints myPointsInDoubts = new Mypoints ( driver );
        myPointsInDoubts.myPoints ();

    }
}

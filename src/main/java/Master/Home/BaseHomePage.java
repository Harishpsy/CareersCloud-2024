package Master.Home;

import Home.ArticleEbooksandCourseActions;
import Home.FooterSections;
import Home.HomeFeedActions;
import Home.VerifyingDuplicateInHomeFeeds;
import org.openqa.selenium.WebDriver;

public class BaseHomePage {

    WebDriver driver;

    // Creating A Constructor For Home Base We Can Access All The Action Through Here Itself
    public BaseHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void HomeModule() throws InterruptedException {

        // Creating an Object For Home Feeds After Landing All The Action Needs to Perform In The Home Feeds
        HomeFeedActions clickingHomePage = new HomeFeedActions ( driver );
        clickingHomePage.homePageActions ();

        // Creating An Object For The Footer Sections
        FooterSections footer = new FooterSections ( driver );
        footer.footerSection ();

        // Creating An Object For The Articles, Ebooks And Courses Clicking In The Home Feeds Except Quiz
        ArticleEbooksandCourseActions actions = new ArticleEbooksandCourseActions ( driver );
        actions.ArticleEbooksandCourse ();

        // Verifying Duplicate In The Home Feeds, Whether Getting In The Same Article, Ebooks, Courses Images
        VerifyingDuplicateInHomeFeeds duplicate = new VerifyingDuplicateInHomeFeeds ( driver );
        duplicate.verifyingDuplicate ();
    }

}

package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mynotespageobject {

    // clicking the MyNote

    @FindBy(xpath = "//*[@id=\"1\"]")
    public static WebElement MyNotes;

    @FindBy(xpath = "//*[text() ='No Records Found.']")
    public static WebElement noRecordfoundMyNotes;

    @FindBy(xpath = "//*[@id=\"2\"]")
    public static WebElement clickingMyQuestion;

    // Writing for the article present in the My Notes

    @FindBy(xpath = "//*[@class=\"my-notest article-feed-image\"]")
    public static WebElement clickingArticle;

    // Writing for the videos present in the My Notes

    @FindBy(xpath = "//*[@class=\"video-iframe-overlay\"]")
    public static WebElement clickingVideos;

    // Writing for the quiz present in the My Notes

    @FindBy(xpath = "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default start-quiz-button\"]")
    public static WebElement clickingStartQuiz;

    @FindBy(xpath = "//*[@class=\"ant-btn css-xu9wm8 ant-btn-default resume-quiz-button\"]")
    public static WebElement clickingResumequiz;

    @FindBy(xpath = "(//*[@class=\"ant-btn css-xu9wm8 ant-btn-default solution-quiz-button\"])[1]")
    public static WebElement clickingSolutionquiz;





}

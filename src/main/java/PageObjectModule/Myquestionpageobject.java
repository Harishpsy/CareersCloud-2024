package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myquestionpageobject {

    // Clicking My Question Button

    @FindBy(xpath = "//*[@id=\"2\"]")
    public static WebElement clickingMyQuestion;

    // Click The BookMarked Question

    @FindBy(xpath = "//div[@class=\"ant-card-cover\"]")
    public static WebElement clickBookMarkQuestion;

    // Click The UnBookMark Icon

    @FindBy(xpath = "//*[@class=\"bookmarked-icon\"]")
    public static WebElement clickingUnBookmarkIcon;

    // Clicking The Quiz BackButton

    @FindBy(xpath = "//*[@class=\"anticon anticon-arrow-left back-icon\"]")
    public static WebElement quizBackButton;

    // Clicking the First Option

    @FindBy(xpath = "//div[text()='A']")
    public static WebElement clickingTheOption_A;

    //Clicking The Next Button

    @FindBy(xpath = "//div[text()='Next']")
    public static WebElement clickingNextbutton;

    // Clicking the Second Option

    @FindBy(xpath = "//div[text()='B']")
    public static WebElement clickingTheOption_B;

    // Clicking the Third Option

    @FindBy(xpath = "//div[text()='C']")
    public static WebElement clickingTheOption_C;

    // Clicking the Fourth Option

    @FindBy(xpath = "//div[text()='D']")
    public static WebElement clickingTheOption_D;

    // Clicking the Fifth Option

    @FindBy(xpath = "//div[text()='E']")
    public static WebElement clickingTheOption_E;

    // Clicking The Number on the right side Count Status

    @FindBy(xpath = "//Span[text()='6']")
    public static WebElement clickingTheNumber6OnTheRigntSide;

    // Clicking The Number on the right side Count Status

    @FindBy(xpath = "//Span[text()='7']")
    public static WebElement clickingTheNumber7OnTheRigntSide;

    // Clicking The Previous Button

    @FindBy(xpath = "//div[text()='Previous']")
    public static WebElement clickingThePreviousButton;

    // Clicking The Share Icon In The MyQuestion

    @FindBy(xpath = "//*[@alt=\"share\"]")
    public static WebElement clickingTheShareIcon;

    //click the copy link in the share popup

    @FindBy(xpath = "//span[text()='COPY LINK']")
    public static WebElement Copy_link;

    //Clicking the cancel button in the in share popup

    @FindBy(xpath = "//span[text()='Cancel']")
    public static WebElement Cancel_button;

    // Scrolling The My Question Page

    @FindBy(xpath = "//*[@class=\"report-image\"]")
    public static WebElement scrollToReportIcon;

    // Click The Translation Error In The Report Popup

    @FindBy(xpath = "//span[text()='Translations Error']")
    public static WebElement clickingTranslationErrorRadioButton;

    //Entering the text inside the report text field In Solution Page

    @FindBy(name = "reportDescription")
    public static WebElement Enter_the_report;

    // Click the report button

    @FindBy(xpath = "//span[text()='REPORT']")
    public static WebElement Report_button;

    // Clicking The Home Button

    @FindBy(xpath = "//a[text()='Home']")
    public static WebElement clickingHomeButton;


}

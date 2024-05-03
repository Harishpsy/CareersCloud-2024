package PageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mynotespageobject {

    // clicking the MyNote

    @FindBy(xpath = "//*[@id=\"1\"]")
    public static WebElement MyNotes;

    // Click the three dots in the My notes

    @FindBy(xpath = "//*[@class=\"ant-dropdown-trigger\"]")
    public static WebElement Threedots;

    //Clicking the remove My notes icon in dropdown

    @FindBy(xpath = "//span[text()='Remove My  Notes']")
    public static WebElement Remove_My_Notes;

    /* Clicking the share icon in My Notes */

    @FindBy(xpath = "//span[text()='Share']")
    public static WebElement Share_icon;

    //click the copy link in the share popup

    @FindBy(xpath = "//span[text()='COPY LINK']")
    public static WebElement Copy_link;

    //Clicking the cancel button in the in share popup

    @FindBy(xpath = "//span[text()='Cancel']")
    public static WebElement Cancel_button;

    //clicking the report icon

    @FindBy(xpath = "//span[text()='Report']")
    public static WebElement Report_icon;

    //Click the wrong information radio button

    @FindBy(xpath = "//span[text()='Wrong Information']")
    public static WebElement Wronginformationradiobutton;

    //Entering the text inside the report text field

    @FindBy(name = "reportDescription")
    public static WebElement Enterthereport;

    // Click the report button

    @FindBy(xpath = "//span[text()='REPORT']")
    public static WebElement Reportbutton;

    //Clicking the Course name in My Notes Card

    @FindBy(xpath = "//*[@class=\"anticon anticon-right right-arrow-icon\"]")
    public static WebElement ClickingCourseName;

    //Clicking the breadcrums to navigate backward to My notes page

    @FindBy(xpath = "//span[text()='Course']")
    public static WebElement ClickingCoursebreadcrums;

    // Clicking the like button

    @FindBy(xpath = "//*[@class=\"feed-card-footer-like-icon\"]")
    public static WebElement Likebutton;

    // Clicking the start button

    @FindBy(xpath = "//span[text()='Start']")
    public static WebElement Clickingstartbutton;

    //Clicking the Resume Quiz

    @FindBy(xpath = "//span[text()='Resume']")
    public static WebElement clickingTheResumequiz;

    //Clicking the close icon in the quiz instruction

    @FindBy(xpath = "//*[@class=\"ant-modal-close-x\"]")
    public static WebElement Closeicon;

    //Clicking the Instruction Button

    @FindBy(xpath = "//*[@alt=\"quiz_info\"]")
    public static WebElement clickingTheInstructionIcon;

    //Clicking the close icon in the quiz instruction

    @FindBy(xpath = "//*[@class=\"ant-modal-close-x\"]")
    public static WebElement againCloseicon;

    // Clicking The FullScreen Button

    @FindBy(className = "anticon-expand")
    public static WebElement clickingTheFullScreenButton;

    // Clicking the BookMark-icon

    @FindBy(xpath = "bookmark-icon")
    public static WebElement bookMarkicon;

    // Clicking the First Option

    @FindBy(xpath = "//div[text()='A']")
    public static WebElement clickingTheOption_A;

    //Clicking The Save & Next Button

    @FindBy(xpath = "//div[text()='Save & Next']")
    public static WebElement clickingTheSaveAndNextbutton;

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

    // Clicking The Number on the right side Count Status

    @FindBy(xpath = "//Span[text()='8']")
    public static WebElement clickingTheNumber8OnTheRigntSide;

    // Clicking The Previous Button

    @FindBy(xpath = "//*[@class=\"pause-icon\"]")
    public static WebElement clickingThePauseButton;

    // Clicking The Cancel Button In The Pause popup

    @FindBy(xpath = "//span[text()='Cancel']")
    public static WebElement clickingCancelButtonInPopup;

    // Clicking The Leave button In the Pause Popup

    @FindBy(xpath = "//span[text()=\" Leave \"]")
    public static WebElement clickingLeaveButtonInPopup;

    // Clicking The Quiz BackButton

    @FindBy(xpath = "//*[@class=\"anticon anticon-arrow-left back-icon\"]")
    public static WebElement quizBackButton;

    // Clicking The Leave button In the BackArrow Popup

    @FindBy(xpath = "//span[text()=\" Leave \"]")
    public static WebElement clickingLeaveButtonPopup;

    // Clicking The Submit Button

    @FindBy(xpath = "//span[text()=' Submit ']")
    public static WebElement clickingSubmitButton;

    // Clicking the Cancel Button In the submit Popup

    @FindBy(xpath = "//span[text()=\"Cancel\"]")
    public static WebElement clickingCancelButtonInThePopup;

    // Clicking The solution button

    @FindBy(xpath = "//span[text()='Solution']")
    public static WebElement clickingSolutionButton;

    // Clicking The Next Button In The Solution Page

    @FindBy(xpath = "//div[text()='Next']")
    public static WebElement clickingTheNextButton;

    //Clicking The BookMark Button For UnBookMark

    @FindBy(className = "bookmark-icon")
    public static WebElement clickingTheBookMarkedButton;

    // Clicking The Share Icon In The Solution Page

    @FindBy(xpath = "//*[@alt=\"share\"]")
    public static WebElement clickingTheShareIcon;

    // Clicking The ReattempButton

    @FindBy(xpath = "//div[@class=\"ant-switch-handle\"]")
    public static WebElement reattempIcon;

    // Click The Translation Error In The Report Popup

    @FindBy(xpath = "//span[text()='Translations Error']")
    public static WebElement clickingTranslationErrorButton;

    // Clicking The ReattemptButton

    @FindBy(xpath = "//div[@class=\"ant-switch-handle\"]")
    public static WebElement clickingReattemptButton;

    //  Click the back arrow in the solution screen

    @FindBy(xpath = "//*[@class=\"anticon anticon-arrow-left back-icon\"]")
    public static WebElement clickingBackArrow;

    // Clicking The Analysis Icon

    @FindBy(xpath = "//*[@class=\"image-analysis\"]")
    public static WebElement clickingAnalysisIcon;

    // Exiting The FullScreen Button

    @FindBy(className = "anticon-compress")
    public static WebElement exitingTheFullScreenButton;

    // Clicking The Analysis Button

    @FindBy(className = "//span[text()='Analysis']")
    public static WebElement clickingAnalysisButton;

    // Clicking The Share Icon In The Analysis Page

    @FindBy(xpath = "//*[@alt=\"share\"]")
    public static WebElement clickingTheShareicon;

    // Clicking The comment icon in the analysis page

    @FindBy(xpath = "//*[@id=\"comments-icon\"]")
    public static WebElement clickingCommentIconInAnalysisPage;

    // Clicking The Like Button

    @FindBy(xpath = "//*[@class=\"like\"]")
    public static WebElement clickingunLikeButton;

    // Clicking The unlike Button

    @FindBy(xpath = "//*[@class=\"unlike\"]")
    public static WebElement clickingLikeButton;

    //  Entering Comment In The TextField

    @FindBy(xpath = "//*[@name=\"comments1\"]")
    public static WebElement enteringTheCommentInTextField;

    // Clicking The Send Button In The Comment Text Field

    @FindBy(className = "anticon-send")
    public static WebElement clickingSendButton;

    // Clicking The Reattempt Button Inside The analysis page

    @FindBy(xpath = "//span[text()=' Reattempt ']")
    public static WebElement clickingReattempButton;

    // Clicking The Solution Button Inside The analysis page

    @FindBy(xpath = "//span[text()=' View Solution ']")
    public static WebElement clickingSolutionButtonInAnalysis;

    // Clicking The Back To Quiz Breadcrumbs In The Analysis Page

    @FindBy(xpath = "//span[text()='Back to Quiz']")
    public static WebElement clickingBackToQuizBreadCrumbs;

    // Clicking The Article

    @FindBy(xpath = "//*[@class=\"my-notest article-feed-image\"]")
    public static WebElement clickingArticle;

    // Clicking The Recent Article

    @FindBy(xpath = "//div[text()='Current Affairs 17 February 2024']")
    public static WebElement clickingRecentArticle;

    // Clicking Back Button In The article page

    @FindBy(xpath = "//span[text()='Back']")
    public static WebElement clickingBackButton;




}

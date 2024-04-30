package MyCourse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class MyCourse_Filters {

    WebDriver driver;

    public MyCourse_Filters(WebDriver driver) {
        this.driver = driver;
    }

    public void Filter() throws InterruptedException {

        // Clicking The My Course Button

        Thread.sleep (3000);
        WebElement clickingMyCourseButton = driver.findElement (xpath ("//a[text()='My Course']"));
        clickingMyCourseButton.click ();

        //Scrolling Down Function

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo( 0, document.body.scrollHeight)");

        //Scrolling page up Function

        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollTo(document.body.scrollHeight,0)");

        // Clicking The filter main (Free)

        Thread.sleep (3000);
        WebElement clickingFreeButtonInFilter = driver.findElement (xpath ("//div[text()='Free']"));
        clickingFreeButtonInFilter.click ();

        // UnClicking The filter main (Free)

        Thread.sleep (3000);
        WebElement UnclickingFreeButtonInFilter = driver.findElement (xpath ("//div[text()='Free']"));
        UnclickingFreeButtonInFilter.click ();

        // Clicking The filter main (Paid)

        Thread.sleep (3000);
        WebElement clickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        clickingPaidButtonInFilter.click ();

        // UnClicking The filter main (Paid)

        Thread.sleep (3000);
        WebElement UnclickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        UnclickingPaidButtonInFilter.click ();

        // Clicking The filter main (featured)

        Thread.sleep (3000);
        WebElement clickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        clickingFeaturedButtonInFilter.click ();

        // UnClicking The filter main (featured)

        Thread.sleep (3000);
        WebElement UnclickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        UnclickingFeaturedButtonInFilter.click ();

        // Clicking The filter main (Subjects)

        Thread.sleep (3000);
        WebElement clickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        clickingSubjectsButtonInFilter.click ();

        // unClicking The filter main (Subjects)

        Thread.sleep (3000);
        WebElement UnclickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        UnclickingSubjectsButtonInFilter.click ();

        // Clicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement clickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        clickingExamsButtonInFilter.click ();

        // UnClicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement UnclickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        UnclickingExamsButtonInFilter.click ();

        // Clicking The filter main (Exams)

        Thread.sleep (3000);
        WebElement clickingAllButtonInFilter = driver.findElement (xpath ("//div[text()='All']"));
        clickingAllButtonInFilter.click ();

        // Clicking The Filter Icon

        Thread.sleep (3000);
        WebElement clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Paid Radio Button

        Thread.sleep (3000);
        WebElement clickingPaidRadioButton = driver.findElement (xpath ("//span[text()='Paid']"));
        clickingPaidRadioButton.click ();

        // Clicking The Apply Button

        WebElement clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();


        // Clicking The Free Radio Button

        Thread.sleep (3000);
        WebElement clickingFreeRadioButton = driver.findElement (xpath ("//span[text()='Free']"));
        clickingFreeRadioButton.click ();

        // Clicking The Apply Button

        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();


        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        WebElement clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Featured In The popup

        Thread.sleep (3000);
        WebElement clickingFeaturedButton = driver.findElement (xpath ("(//div[text()='Featured'])[2]"));
        clickingFeaturedButton.click ();

        // Clicking The Yes Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingYesButton = driver.findElement (xpath ("//span[text()='Yes']"));
        clickingYesButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The No Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingNoButton = driver.findElement (xpath ("//span[text()='No']"));
        clickingNoButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Subjects Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingSubjectButton = driver.findElement (xpath ("(//div[text()='Subjects'])[2]"));
        clickingSubjectButton.click ();

        // Clicking The Current Affairs CheckBox IN The Popup

        Thread.sleep (3000);
        WebElement clickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        clickingCurrentAffairsCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Current Affairs CheckBox IN The Popup

        Thread.sleep (3000);
        WebElement unclickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        unclickingCurrentAffairsCheckBox.click ();

        // Clicking The Logical Reasoning CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        clickingLogicalReasoningCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Logical Reasoning CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        unclickingLogicalReasoningCheckBox.click ();

        // Clicking The Quantitative Aptitude CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        clickingQuantitativeAptitudeCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Quantitative Aptitude CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        unclickingQuantitativeAptitudeCheckBox.click ();

        // Clicking The English CheckBox In The Popup

        Thread.sleep (3000);
        WebElement clickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        clickingEnglishCheckBox.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The English CheckBox In The Popup

        Thread.sleep (3000);
        WebElement unclickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        unclickingEnglishCheckBox.click ();

        // Clicking The Exam Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingExamButton = driver.findElement (xpath ("(//div[text()='Exam'])[2]"));
        clickingExamButton.click ();

        // Clicking The Bank PO In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        clickingBankPoButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Bank PO In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        unclickingBankPoButton.click ();

        // Clicking The Bank Clerk In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        clickingBankClerkButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Bank Clerk In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        unclickingBankClerkButton.click ();

        // Clicking The Insurance In The Filter Popup

        Thread.sleep (3000);
        WebElement clickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        clickingInsuranceButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // UnClicking The Insurance In The Filter Popup

        Thread.sleep (3000);
        WebElement unclickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        unclickingInsuranceButton.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The Coin Discount Button In The Filter popup

        Thread.sleep (3000);
        WebElement clickingCoinDiscountButton = driver.findElement (xpath ("//div[text()='Coin Discount']"));
        clickingCoinDiscountButton.click ();

        // Clicking The 90+ in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking90Plus = driver.findElement (xpath ("//span[text()='90+']"));
        clicking90Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 89 - 70 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking89_70Plus = driver.findElement (xpath ("//span[text()='89 - 70']"));
        clicking89_70Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 69 - 40 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking69_40Plus = driver.findElement (xpath ("//span[text()='69 - 40']"));
        clicking69_40Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 39 - 20 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking39_20Plus = driver.findElement (xpath ("//span[text()='39 - 20']"));
        clicking39_20Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The 19 - 01 in The coin discount sub-popup

        Thread.sleep (3000);
        WebElement clicking19_01Plus = driver.findElement (xpath ("//span[text()='19 - 01']"));
        clicking19_01Plus.click ();

        // Clicking The Apply Button

        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();

        // Again Clicking The Filter Icon

        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();

        // Clicking The reset Button

        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();
        System.out.println ("Reset Button Has Been Success Executed");
    }
}

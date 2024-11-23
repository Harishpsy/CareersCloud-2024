package MyCourse;

import ScreenShot.ScreenShot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.openqa.selenium.By.xpath;

public class filters extends ScreenShot {
    WebDriver driver;
    public filters(WebDriver driver) {
        this.driver = driver;
    }
    @Test
    public void Filter() throws InterruptedException, IOException {

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
        captureScreenShot ( "Clicked The filter main (Free)" );

        // UnClicking The filter main (Free)
        Thread.sleep (3000);
        WebElement UnclickingFreeButtonInFilter = driver.findElement (xpath ("//div[text()='Free']"));
        UnclickingFreeButtonInFilter.click ();
        captureScreenShot ( "Un-Clicked The filter main (Free)" );

        // Clicking The filter main (Paid)
        Thread.sleep (3000);
        WebElement clickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        clickingPaidButtonInFilter.click ();
        captureScreenShot ( "Clicked The filter main (Paid)" );

        // UnClicking The filter main (Paid)
        Thread.sleep (3000);
        WebElement UnclickingPaidButtonInFilter = driver.findElement (xpath ("//div[text()='Paid']"));
        UnclickingPaidButtonInFilter.click ();
        captureScreenShot ( "Un-Clicked The filter main (Paid)" );

        // Clicking The filter main (featured)
        Thread.sleep (3000);
        WebElement clickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        clickingFeaturedButtonInFilter.click ();
        captureScreenShot ( "Clicked The filter main (featured)" );

        // UnClicking The filter main (featured)
        Thread.sleep (3000);
        WebElement UnclickingFeaturedButtonInFilter = driver.findElement (xpath ("//div[text()='Featured']"));
        UnclickingFeaturedButtonInFilter.click ();
        captureScreenShot ( "Un-Clicked The filter main (featured)" );

        // Clicking The filter main (Subjects)
        Thread.sleep (3000);
        WebElement clickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        clickingSubjectsButtonInFilter.click ();
        captureScreenShot ( "Clicked The filter main (Subjects)" );

        // UnClicking The filter main (Subjects)
        Thread.sleep (3000);
        WebElement UnclickingSubjectsButtonInFilter = driver.findElement (xpath ("//div[text()='Subjects']"));
        UnclickingSubjectsButtonInFilter.click ();
        captureScreenShot ( "Un-Clicked The filter main (Subjects)" );

        // Clicking The filter main (Exams)
        Thread.sleep (3000);
        WebElement clickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        clickingExamsButtonInFilter.click ();
        captureScreenShot ( "Clicked The filter main (Exams)" );

        // UnClicking The filter main (Exams)
        Thread.sleep (3000);
        WebElement UnclickingExamsButtonInFilter = driver.findElement (xpath ("//div[text()='Exam']"));
        UnclickingExamsButtonInFilter.click ();
        captureScreenShot ( "Un-Clicked The filter main (Exams)" );

        // Clicking The filter main (Exams)
        Thread.sleep (3000);
        WebElement clickingAllButtonInFilter = driver.findElement (xpath ("//div[text()='All']"));
        clickingAllButtonInFilter.click ();
        captureScreenShot ( "Clicked The filter main (Exams)" );

        // Clicking The Filter Icon
        Thread.sleep (3000);
        WebElement clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The Paid Radio Button
        Thread.sleep (3000);
        WebElement clickingPaidRadioButton = driver.findElement (xpath ("//span[text()='Paid']"));
        clickingPaidRadioButton.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The Apply Button
        WebElement clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The Free Radio Button
        Thread.sleep (3000);
        WebElement clickingFreeRadioButton = driver.findElement (xpath ("//span[text()='Free']"));
        clickingFreeRadioButton.click ();
        captureScreenShot ( "Clicked The Free Radio Button" );

        // Clicking The Apply Button
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The reset Button
        Thread.sleep (3000);
        WebElement clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();
        captureScreenShot ( "Clicked The reset Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The Featured In The popup
        Thread.sleep (3000);
        WebElement clickingFeaturedButton = driver.findElement (xpath ("(//div[text()='Featured'])[2]"));
        clickingFeaturedButton.click ();
        captureScreenShot ( "Clicked The Featured In The popup" );

        // Clicking The Yes Button In The Filter popup
        Thread.sleep (3000);
        WebElement clickingYesButton = driver.findElement (xpath ("//span[text()='Yes']"));
        clickingYesButton.click ();
        captureScreenShot ( "Clicked The Yes Button In The Filter popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Clicking The No Button In The Filter popup
        Thread.sleep (3000);
        WebElement clickingNoButton = driver.findElement (xpath ("//span[text()='No']"));
        clickingNoButton.click ();
        captureScreenShot ( "Clicked The No Button In The Filter popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The No Button In The Filter popup" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The reset Button
        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();
        captureScreenShot ( "Clicked The Reset Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The Subjects Button In The Filter popup
        Thread.sleep (3000);
        WebElement clickingSubjectButton = driver.findElement (xpath ("(//div[text()='Subjects'])[2]"));
        clickingSubjectButton.click ();
        captureScreenShot ( "Clicked The Subjects Button In The Filter popup" );

        // Clicking The Current Affairs CheckBox IN The Popup
        Thread.sleep (3000);
        WebElement clickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        clickingCurrentAffairsCheckBox.click ();
        captureScreenShot ( "Clicked The Current Affairs CheckBox In The Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon Again" );

        // UnClicking The Current Affairs CheckBox IN The Popup
        Thread.sleep (3000);
        WebElement unclickingCurrentAffairsCheckBox = driver.findElement (xpath ("//span[text()='Current Affairs']"));
        unclickingCurrentAffairsCheckBox.click ();
        captureScreenShot ( "Un-Clicked The Current Affairs CheckBox In The Popup" );

        // Clicking The Logical Reasoning CheckBox In The Popup
        Thread.sleep (3000);
        WebElement clickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        clickingLogicalReasoningCheckBox.click ();
        captureScreenShot ( "Clicked The Logical Reasoning CheckBox In The Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon Again" );

        // UnClicking The Logical Reasoning CheckBox In The Popup
        Thread.sleep (3000);
        WebElement unclickingLogicalReasoningCheckBox = driver.findElement (xpath ("//span[text()='Logical Reasoning']"));
        unclickingLogicalReasoningCheckBox.click ();
        captureScreenShot ( "Un-Clicked The Logical Reasoning CheckBox In The Popup" );

        // Clicking The Quantitative Aptitude CheckBox In The Popup
        Thread.sleep (3000);
        WebElement clickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        clickingQuantitativeAptitudeCheckBox.click ();
        captureScreenShot ( "Clicked The Quantitative Aptitude CheckBox In The Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // UnClicking The Quantitative Aptitude CheckBox In The Popup
        Thread.sleep (3000);
        WebElement unclickingQuantitativeAptitudeCheckBox = driver.findElement (xpath ("//span[text()='Quantitative Aptitude']"));
        unclickingQuantitativeAptitudeCheckBox.click ();
        captureScreenShot ( "Un-Clicked The Quantitative Aptitude CheckBox In The Popup" );

        // Clicking The English CheckBox In The Popup
        Thread.sleep (3000);
        WebElement clickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        clickingEnglishCheckBox.click ();
        captureScreenShot ( "Clicked The Quantitative Aptitude CheckBox In The Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // UnClicking The English CheckBox In The Popup
        Thread.sleep (3000);
        WebElement unclickingEnglishCheckBox = driver.findElement (xpath ("//span[text()='English']"));
        unclickingEnglishCheckBox.click ();
        captureScreenShot ( "un-Clicked English CheckBox In The Popup" );

        // Clicking The Exam Button In The Filter popup
        Thread.sleep (3000);
        WebElement clickingExamButton = driver.findElement (xpath ("(//div[text()='Exam'])[2]"));
        clickingExamButton.click ();
        captureScreenShot ( "Clicked The Exam Button In The Filter popup" );

        // Clicking The Bank PO In The Filter Popup
        Thread.sleep (3000);
        WebElement clickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        clickingBankPoButton.click ();
        captureScreenShot ( "Clicked The Bank PO In The Filter Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // UnClicking The Bank PO In The Filter Popup
        Thread.sleep (3000);
        WebElement unclickingBankPoButton = driver.findElement (xpath ("//span[text()='Bank PO']"));
        unclickingBankPoButton.click ();
        captureScreenShot ( "Un-Clicked The Bank PO In The Filter Popup" );

        // Clicking The Bank Clerk In The Filter Popup
        Thread.sleep (3000);
        WebElement clickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        clickingBankClerkButton.click ();
        captureScreenShot ( "Clicked The Bank Clerk In The Filter Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( " Again Clicked The Filter Icon" );

        // UnClicking The Bank Clerk In The Filter Popup
        Thread.sleep (3000);
        WebElement unclickingBankClerkButton = driver.findElement (xpath ("//span[text()='Bank Clerk']"));
        unclickingBankClerkButton.click ();
        captureScreenShot ( "Un-Clicked The Bank Clerk In The Filter Popup" );

        // Clicking The Insurance In The Filter Popup
        Thread.sleep (3000);
        WebElement clickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        clickingInsuranceButton.click ();
        captureScreenShot ( "Clicked The Insurance In The Filter Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // UnClicking The Insurance In The Filter Popup
        Thread.sleep (3000);
        WebElement unclickingInsuranceButton = driver.findElement (xpath ("//span[text()='Insurance']"));
        unclickingInsuranceButton.click ();
        captureScreenShot ( "Un-Clicked The Insurance In The Filter Popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // Clicking The Coin Discount Button In The Filter popup
        Thread.sleep (3000);
        WebElement clickingCoinDiscountButton = driver.findElement (xpath ("//div[text()='Coin Discount']"));
        clickingCoinDiscountButton.click ();
        captureScreenShot ( "Clicked Coin Discount Button In The Filter popup" );

        // Clicking The 90+ in The coin discount sub-popup
        Thread.sleep (3000);
        WebElement clicking90Plus = driver.findElement (xpath ("//span[text()='90+']"));
        clicking90Plus.click ();
        captureScreenShot ( "Clicked The 90+ in The coin discount sub-popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // Clicking The 89-70 in The coin discount sub-popup
        Thread.sleep (3000);
        WebElement clicking89_70Plus = driver.findElement (xpath ("//span[text()='89 - 70']"));
        clicking89_70Plus.click ();
        captureScreenShot ( "Clicked The 89-70 in The coin discount sub-popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Clicked The Filter Icon" );

        // Clicking The 69-40 in The coin discount sub-popup
        Thread.sleep (3000);
        WebElement clicking69_40Plus = driver.findElement (xpath ("//span[text()='69 - 40']"));
        clicking69_40Plus.click ();
        captureScreenShot ( "Clicked The 69-40 in The coin discount sub-popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // Clicking The 39-20 in The coin discount sub-popup
        Thread.sleep (3000);
        WebElement clicking39_20Plus = driver.findElement (xpath ("//span[text()='39 - 20']"));
        clicking39_20Plus.click ();
        captureScreenShot ( "Clicked The 39-20 in The coin discount sub-popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // Clicking The 19-01 in The coin discount sub-popup
        Thread.sleep (3000);
        WebElement clicking19_01Plus = driver.findElement (xpath ("//span[text()='19 - 01']"));
        clicking19_01Plus.click ();
        captureScreenShot ( "Clicked The 19-01 in The coin discount sub-popup" );

        // Clicking The Apply Button
        Thread.sleep (3000);
        clickingApplyButton = driver.findElement (xpath ("//span[text()='Apply']"));
        clickingApplyButton.click ();
        captureScreenShot ( "Clicked The Apply Button" );

        // Again Clicking The Filter Icon
        Thread.sleep (3000);
        clickingFilterIcon = driver.findElement (xpath ("//*[@class=\"ant-dropdown-trigger\"]"));
        clickingFilterIcon.click ();
        captureScreenShot ( "Again Clicked The Filter Icon" );

        // Clicking The reset Button
        Thread.sleep (3000);
        clickingResetButton = driver.findElement (xpath ("//span[text()='Reset']"));
        clickingResetButton.click ();
        System.out.println ("Reset Button Has Been Success Executed");
        captureScreenShot ( "Clicked The reset Button" );
    }
}

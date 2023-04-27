package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sogeti.pages.AutomationPage;
import com.sogeti.pages.BasePage;
import com.sogeti.pages.SogetiHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class secondCaseTest {
    WebDriver driver;
    BasePage basePage;
    SogetiHomePage sogetiHomePage;
    AutomationPage automationPage;

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
    @BeforeMethod
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.basePage = new BasePage(driver);
        this.sogetiHomePage = new SogetiHomePage(driver);
        this.automationPage = new AutomationPage(driver);
/////// #1- Navigate to the URL https://www.sogeti.com/ ///////
        driver.get("https://www.sogeti.com/");

    }
    @Test()
    public void secondTestCase ( ) {
        sogetiHomePage.declineCookie();
/////// #2- Hover over Services Link and then Click Automation link. ///////
        sogetiHomePage.hoverOnServices();
        sogetiHomePage.clickAutomation();

/////// #3- On Automation Page, scroll down to the Contact us Form. ///////
        automationPage.scrollToContactForm();

/////// #4- Fill the First Name, Last Name, Email, Phone and Message fields with Random Generated Data. ///////
        automationPage.fillFirstName();
        automationPage.fillLastName();
        automationPage.fillEmail();
        automationPage.fillPhone();
        automationPage.fillCompany();
        automationPage.chooseCountry();
        automationPage.fillMessage();

/////// #5- Check the I agree checkbox. ///////
        automationPage.clickAgree();

////////////////////////# The following steps were not possible to be automated ////////////////////////
//****************************************************************************************************//
/////// #6- Then Click SUBMIT button.
/////// #7- After clicking SUBMIT button the form is submitted and Thank you message is displayed
///////     Assert the Thank you message.

        //automationPage.clicknotRobot();
        //automationPage.clickSubmit();
//****************************************************************************************************//


/////////// # Note: explain in comments in why it is not possible to automate the Test Step?////////////
//****************************************************************************************************//
// It was required to click the CAPTCHA to be able to submit the form, and it is not possible
// to automate the captcha click.
//****************************************************************************************************//


///////////// # What are the possible workarounds to Test such Test Case? ////////////////////////
//****************************************************************************************************//
// After I searched I found that there are several workarounds to solve the CAPTCHA automation issue.
// These solutions are as following:

// #1-By disabling the Captcha in the testing environment
// #2-Adding a hook to click the Captcha checkbox
// #3-By adding a delay to the Webdriver and manually solve Captcha while testing
//****************************************************************************************************//


    }
    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}

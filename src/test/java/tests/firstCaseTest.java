package tests;

//import io.github.bonigarcia.wdm.OperatingSystem;
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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class firstCaseTest {
    WebDriver driver;
    BasePage basePage;
    SogetiHomePage sogetiHomePage;
    AutomationPage automationPage;

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
    @BeforeMethod
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        //chromeOptions.addArguments("--incognito");
       // chromeOptions.addArguments("--headless");
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.basePage = new BasePage(driver);
        this.sogetiHomePage = new SogetiHomePage(driver);
        this.automationPage = new AutomationPage(driver);

/////// #1- Navigate to the URL https://www.sogeti.com/ ///////
        driver.get("https://www.sogeti.com/");

    }
    public WebDriver getDriver() {
        return driverThread.get();
    }

    @Test()
    public void hoverAndClickAutomation ( ) {
        SoftAssert softAssert = new SoftAssert();
        sogetiHomePage.declineCookie();
/////// #2- Hover over Services Link and then Click Automation link. ///////
        sogetiHomePage.hoverOnServices();
        sogetiHomePage.clickAutomation();

/////// #3- Verify that Automation Screen is displayed, and “Automation” text is visible in Page. ///////
        boolean isAutomationTextVisible= automationPage.checkAutomationTextIsVisible();
        softAssert.assertEquals(isAutomationTextVisible,true);
        //Assert.assertEquals(isAutomationTextVisible,true);

/////// #4- Hover again over Services Link. Verify that the Services and Automation are selected ///////
        automationPage.hoverAgainOnServices();
        boolean isServicesLinkSelected= automationPage.checkServicesLinkIsSelected();
        softAssert.assertEquals(isServicesLinkSelected,true);
        //Assert.assertEquals(isServicesLinkSelected,true);

        boolean isAutomationLinkSelected= automationPage.checkAutomationLinkIsSelected();
        softAssert.assertEquals(isAutomationLinkSelected,true);
        //Assert.assertEquals(isAutomationLinkSelected,true);
        softAssert.assertAll();

    }
    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}

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
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class thirdCaseTest {
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

/////// #1- Navigate to the URL https://www.sogeti.com ///////
        driver.get("https://www.sogeti.com/");

    }
    @Test()
    public void thirdTestCase ( ) {
        SoftAssert softAssert = new SoftAssert();

        sogetiHomePage.declineCookie();

/////// #2- Click the Worldwide Dropdown link in Page Header. ///////
        sogetiHomePage.clickWorldWideDropDowm();

/////// #3- A Country dropdown list is displayed. These are the Country specific Sogeti links. ///////
/////// #4- Assert that all the Country specific Sogeti links are working.. ///////
        int countrySize= sogetiHomePage.getCountryListSize();
        for(int i=0;i<countrySize;i++){
            List<String> expected_actual_url= sogetiHomePage.getCountryLinkHrefAndActualURL(i);
            softAssert.assertEquals(expected_actual_url.get(0),expected_actual_url.get(1));
            softAssert.assertAll();
            //Assert.assertEquals(expected_actual_url.get(0),expected_actual_url.get(1));
        }

    }
    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

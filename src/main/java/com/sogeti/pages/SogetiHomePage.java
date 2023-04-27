package com.sogeti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SogetiHomePage {

    private By servicesLink = By.xpath( "//*[@id=\"main-menu\"]/ul/li[3]");
    private By automationLink = By.xpath( "//a[contains(@class,'subMenuLink')][normalize-space()='Automation']");
    private By cookieConsentButton = By.xpath( "//*[@id=\"CookieConsent\"]/div[1]/div/div[2]/div[2]/button[3]");
    private By worldWideDropDown = By.xpath( "//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/div[2]/span");
    private By belgiumLink = By.xpath( "//*[@id=\"country-list-id\"]/ul/li[1]/a");

    private By FinlandLink = By.xpath( "//*[@id=\"country-list-id\"]/ul/li[1]/a");
    private By FranceLink = By.xpath( "//*[@id=\"country-list-id\"]/ul/li[1]/a");
    private By GermanyLink = By.xpath( "//*[@id=\"country-list-id\"]/ul/li[1]/a");
    private By countryList = By.xpath( "//*[@id=\"country-list-id\"]/ul");
    private By countryListElements = By.tagName("li");


    WebDriver webDriver;
    public SogetiHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void hoverOnServices(){
        this.webDriver.findElement(servicesLink).click();

    }

    public void declineCookie(){
        this.webDriver.findElement(cookieConsentButton).click();

    }
    public AutomationPage clickAutomation(){
        this.webDriver.findElement(automationLink).click();
        return new AutomationPage(this.webDriver);
    }
    public void clickWorldWideDropDowm(){
        this.webDriver.findElement(worldWideDropDown).click();
    }

    public Integer getCountryListSize() {
        List<WebElement> AllCountries=this.webDriver.findElements(By.xpath("//*[@id=\"country-list-id\"]/ul/li"));
        int linksCount= AllCountries.size();
        return linksCount;
    }
    public List<String> getCountryLinkHrefAndActualURL(int index) {

        List<WebElement> AllCountries=this.webDriver.findElements(By.xpath("//*[@id=\"country-list-id\"]/ul/li"));
        String currentHref= AllCountries.get(index).findElement(By.tagName("a")).getAttribute("href");
        AllCountries.get(index).click();

        String winHandleBefore = webDriver.getWindowHandle();
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }

        String URL = webDriver.getCurrentUrl();
        webDriver.switchTo().window(winHandleBefore);


        //// returning a list containing the expected link (href), and Actual URL after clicking the country link
        List<String> href_ActualURL = new ArrayList<String>();
        href_ActualURL.add(currentHref);
        href_ActualURL.add(URL);

        return href_ActualURL;
    }

}

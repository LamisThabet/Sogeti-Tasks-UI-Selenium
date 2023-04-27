package com.sogeti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.sogeti.utilities.WebDriverUtilities;
import org.openqa.selenium.WebElement;

public class AutomationPage {

    private By automationTextField = By.xpath( "//div[@class='case-item-box']");
    private By selectedServicesLink = By.xpath( "//*[@id=\"main-menu\"]/ul/li[3]");
    private By selectedAutomationLink = By.xpath( "//*[@id=\"main-menu\"]/ul/li[3]/div[2]/ul/li[4]");
    private By contactUsForm = By.xpath( "//*[@id=\"99a12a58-3899-4fe1-a5c7-b9065fe635b0\"]/h2");

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private By firstNameField = By.id( "4ff2ed4d-4861-4914-86eb-87dfa65876d8");
    private By lastNameField = By.id( "11ce8b49-5298-491a-aebe-d0900d6f49a7");
    private By emailField = By.id( "056d8435-4d06-44f3-896a-d7b0bf4d37b2");
    private By phoneField = By.id( "755aa064-7be2-432b-b8a2-805b5f4f9384");
    private By messageField = By.id( "88459d00-b812-459a-99e4-5dc6eff2aa19");
    private By countryField = By.id( "e74d82fb-949d-40e5-8fd2-4a876319c45a");
    private By countrySelection = By.xpath( "//*[@id=\"e74d82fb-949d-40e5-8fd2-4a876319c45a\"]/option[2]");
    private By companyField = By.id( "703dedb1-a413-4e71-9785-586d609def60");
    private By agreeCheckBox = By.xpath( "//label[@for='__field_1239350']");
    private By notRobotCheckBox = By.xpath( "//div[@class='recaptcha-checkbox-border']");
    private By submitBtn = By.id( "b35711ee-b569-48b4-8ec4-6476dbf61ef8");
    WebDriver webDriver;
    public AutomationPage(WebDriver webDriver){
        this.webDriver = webDriver;
        //WebDriverUtilities.checkCorrectPage("https://www.sogeti.com/services/automation/",this.webDriver);
    }
    public void hoverAgainOnServices(){
        this.webDriver.findElement(selectedServicesLink).click();

    }
    public boolean checkAutomationTextIsVisible(){

        return WebDriverUtilities.checkExpectedtextisVisible(automationTextField,this.webDriver,"automation");

    }

    public boolean checkServicesLinkIsSelected(){

        return WebDriverUtilities.checkElementIsSelected(selectedServicesLink,this.webDriver);

    }
    public boolean checkAutomationLinkIsSelected(){

        return WebDriverUtilities.checkElementIsSelected(selectedAutomationLink,this.webDriver);

    }
    public void scrollToContactForm(){

        // use driver object to find the 'Locations' field content and return it

        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        WebElement contactUsFormWeb = this.webDriver.findElement(contactUsForm);
        js.executeScript("arguments[0].scrollIntoView();", contactUsFormWeb);

    }

    public void scrollToSubmitBtn(){

        // use driver object to find the 'Locations' field content and return it

        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        WebElement submitBtnPosition = this.webDriver.findElement(submitBtn);
        js.executeScript("arguments[0].scrollIntoView();", submitBtnPosition);

    }

    public void fillFirstName(){
        String firstName=WebDriverUtilities.randomText();
        this.webDriver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillLastName(){
        String lastName=WebDriverUtilities.randomText();
        this.webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillMessage(){
        String message=WebDriverUtilities.randomText();
        this.webDriver.findElement(messageField).sendKeys(message);
    }

    public void fillCompany(){
        String company=WebDriverUtilities.randomText();
        this.webDriver.findElement(companyField).sendKeys(company);
    }

    public void fillEmail(){
        String email= WebDriverUtilities.randomEmail();
        this.webDriver.findElement(emailField).sendKeys(email);

    }

    public void fillPhone(){
        String phone= WebDriverUtilities.randomNumber();
        this.webDriver.findElement(phoneField).sendKeys(phone);

    }

    public void chooseCountry(){

        this.webDriver.findElement(countryField).click();
        this.webDriver.findElement(countrySelection).click();

    }

    public void clickAgree(){

        this.webDriver.findElement(agreeCheckBox).click();

    }
    public void clicknotRobot(){

        this.webDriver.findElement(notRobotCheckBox).click();

    }
    public void clickSubmit(){

        this.webDriver.findElement(submitBtn).click();

    }

}

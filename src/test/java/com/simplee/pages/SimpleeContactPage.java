package com.simplee.pages;

import com.simplee.util.LogLog4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

/**
 * Created by Vinokur on 5/20/2017.
 *
 * Hello,
 * In this project you will find 2 classes:
 * 1) SimpleeContactPage class - contains all needed elements locators from
 * webContactPage http://www2.simplee.com/forms/get-in-touch/
 * and all methods what are used in testClass.
 *
 * 2) SimpleeContactTest class - contains few examples of negative and positive tests
 * for filling contact forms.
 *
 * I made this project using testNG-archetype "ru.stqa.selenium" from Maven repository.
 * Link: http://search.maven.org/#artifactdetails%7Cru.stqa.selenium%7Cwebdriver-testng-archetype%7C4.0%7Cmaven-archetype
 *
 */
public class SimpleeContactPage extends Page{
    @FindBy(xpath = "//input[@id='input_45_1']")
    WebElement inputFirstName;         //or
    @FindBy(id = "input_45_1")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input_45_2']")
    WebElement inputLastName;         //or
    @FindBy(id = "input_45_2")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input_45_3']")
    WebElement inputEmail;       //or
    @FindBy(id = "input_45_3")
    WebElement email;

    @FindBy(xpath = "//input[@id='input_45_4']")
    WebElement inputCompany;       //or
    @FindBy(id = "input_45_4")
    WebElement company;

    @FindBy(xpath = "//input[@id='input_45_5']")
    WebElement inputPhone;       //or
    @FindBy(id = "input_45_5")
    WebElement phone;

    @FindBy(xpath = "//input[@id='input_45_6']")
    WebElement inputMessage;       //or
    @FindBy(id = "input_45_5")
    WebElement message;

    @FindBy(xpath = "//input[@id='choice_45_30_1']")
    WebElement subscribeNews;       //or
    @FindBy(id = "choice_45_30_1")
    WebElement subscribe;

    @FindBy(id = "mktFrmSubmit")
    WebElement buttonSend;

    @FindBy(xpath = "//form[@id='gform_45']/div[2]")
    WebElement validError; //or
    @FindBy(id = "gform_45")
    WebElement errorSendMessage;
    // text present: There was a problem with your submission. Errors have been highlighted below.

    @FindBy(id = "gform_ajax_spinner_45")
    WebElement emailSendingSpinner;

    @FindBy(id = "thankyou-section")
    WebElement thankYouSection;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public SimpleeContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void OpenPage () {
        driver.get ("http://www2.simplee.com/forms/get-in-touch/");
    }

    public void WaitContactPageIsLoaded (){ waitUntilIsLoadedCustomTime(firstName, 7);
        Log.info("Waiting until Conatact page is loaded");
    }
    public void FillFirstName(String firstNameText) {  setElementText(inputFirstName, firstNameText);
        Log.info("Filling form Name with " + firstNameText);
    }
    public void FillLastName(String lastNameText) {  setElementText(lastName, lastNameText);
        Log.info("Filling form Name with " + lastNameText);
    }
    public void FillEmail(String emailText) { setElementText(email, emailText);
        Log.info("Filling form Email with " + emailText);
    }
    public void FillCompany(String companyText) { setElementText(company, companyText);
        Log.info("Filling form Email with " + companyText);
    }
    public void FillPhone(String phoneNumbText) {setElementText(phone, phoneNumbText);
        Log.info("Filling form Subject with " + phoneNumbText);
    }
    public void FillMessage(String messageText) {setElementText(message, messageText);
        Log.info("Filling form Message with " + messageText);
    }
    public void Clicksubscribe() {clickElement(subscribe);
        Log.info("Subscribe button is clicked");
    }
    public void ClickbuttonSend() {clickElement(buttonSend);
        Log.info("Send button is clicked");
    }

    public String GetTextFromErrorMessage(){
        String TextFromExitLink = validError.getText();
        Log.info("Text validation error = " + TextFromExitLink);
        return TextFromExitLink;
    }
    public Boolean IsErrorPresent(){
        return verifyElementIsPresent(validError);
    }

    public Boolean IsMessageSent(){
        return verifyElementIsPresent(thankYouSection);
    }

    public void WaitSentPageIsLoaded (){ waitUntilIsLoadedCustomTime(thankYouSection, 10);
        Log.info("Waiting until Thank you page is loaded");}

}

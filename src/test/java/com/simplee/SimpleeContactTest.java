package com.simplee;

import com.simplee.pages.SimpleeContactPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by user on 5/20/2017.
 */
public class SimpleeContactTest extends TestNgTestBase {
    // variables for positive tests
    public static String textFirstName = "Jacque";
    public static String textLastName = "Fresco";
    public static String textEmail = "test@yopmail.com";
    public static String textCompany = "The Venus Project";
    public static String textPhoneNumb = "1234567890";
    public static String textMessage = "Only working together we can make the world a better place";
    // variables for negative tests
    public static String textFirstNameNegative1 = " ";
    public static String textLastNameNegative1 = " ";
    public static String textCompanyNegative1 = " ";
    public static String textEmailNegative1 = "test@@yopmail,com";
    public static String textPhoneNumbNegative1 = "1";
    // variables for negative tests (not used)
    public static String textFirstNameNegative2 = "♣ ♂";
    public static String textLastNameNegative2 = "♣ ♂";
    public static String textEmailNegative2 = "moc.liampoy@tset";
    public static String textCompanyNegative2 = "♣ ♂";
    public static String textPhoneNumbNegative2 = "One Two";

    private SimpleeContactPage simpleeContactPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        /** or if we need Mozilla:
         System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
         driver = new FirefoxDriver();
         */
        simpleeContactPage = PageFactory.initElements(driver, SimpleeContactPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        simpleeContactPage.OpenPage();
    }

    @Test(groups = {"contactPage", "positive"})
    public void testPositiveFillRequiredForms() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsMessageSent(),
                "Message didn't send in positive test");
    }

    @Test(groups = {"contactPage", "positive"})
    public void testPositiveFillAllForms() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsMessageSent(),
                "Message didn't send in positive test");
    }

    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongFirstName() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstNameNegative1);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsErrorPresent(),
                "Message sent in negative test. textFirstNameNegative1 ");
        Assert.assertEquals("There was a problem with your submission. Errors have been highlighted below.",
                simpleeContactPage.GetTextFromErrorMessage(), "Message sent in negative test. textFirstNameNegative1");
    }
    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongLastName() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastNameNegative1);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsErrorPresent(),
                "Message sent in negative test. textLastNamenegative1 ");
        Assert.assertEquals("There was a problem with your submission. Errors have been highlighted below.",
                simpleeContactPage.GetTextFromErrorMessage(), "Message sent in negative test. textLastNamenegative1");
    }

    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongEmail() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmailNegative1);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsErrorPresent(),
                "Message sent in negative test. textEmailNegative1 ");
        Assert.assertEquals("There was a problem with your submission. Errors have been highlighted below.",
                simpleeContactPage.GetTextFromErrorMessage(), "Message sent in negative test. textEmailNegative1");
    }
    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongPhone() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompany);
        simpleeContactPage.FillPhone(textPhoneNumbNegative1);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsErrorPresent(),
                "Message sent in negative test. textPhoneNumbNegative1 ");
        Assert.assertEquals("There was a problem with your submission. Errors have been highlighted below.",
                simpleeContactPage.GetTextFromErrorMessage(), "Message sent in negative test. textPhoneNumbNegative1");
    }
    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongCompany() {
        simpleeContactPage.WaitContactPageIsLoaded();
        simpleeContactPage.FillFirstName(textFirstName);
        simpleeContactPage.FillLastName(textLastName);
        simpleeContactPage.FillEmail(textEmail);
        simpleeContactPage.FillCompany(textCompanyNegative1);
        simpleeContactPage.FillPhone(textPhoneNumb);
        simpleeContactPage.FillMessage(textMessage);
        simpleeContactPage.Clicksubscribe();
        simpleeContactPage.ClickbuttonSend();
        simpleeContactPage.WaitSentPageIsLoaded();
        Assert.assertTrue(simpleeContactPage.IsErrorPresent(),
                "Message sent in negative test. textPhoneNumbNegative1 ");
        Assert.assertEquals("There was a problem with your submission. Errors have been highlighted below.",
                simpleeContactPage.GetTextFromErrorMessage(), "Message sent in negative test. textPhoneNumbNegative1");
    }
}


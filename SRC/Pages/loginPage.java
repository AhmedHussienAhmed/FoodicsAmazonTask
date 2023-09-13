package SRC.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

    @FindBy(
            id = "ap_email"
    )
    WebElement emailTextField;

    @FindBy(
            id = "continue"
    )
    WebElement continueBtn;

    @FindBy(
            id = "ap_password"
    )
    WebElement passwTextField;


    @FindBy(
            id = "signInSubmit"
    )
    WebElement submitBtn;


    public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
        if (this.emailTextField.isDisplayed()) {
            setText(this.emailTextField, phoneNumber);
            System.out.println("* entered phoneNumber successfully");
        } else {
            System.out.println("* Failed to enter phoneNumber");
        }

    }

    public void clickOnContinueBtn() throws InterruptedException {
        if (this.continueBtn.isDisplayed()) {
            clickButton(this.continueBtn);
            System.out.println("* clicked on continue Btn Successfully");
        } else {
            System.out.println("* Failed to click on continue Btn Successfully");
        }

    }

    public void enterPassword(String passw) throws InterruptedException {
        if (this.passwTextField.isDisplayed()) {
            setText(this.passwTextField, passw);
            System.out.println("* entered passw successfully");
        } else {
            System.out.println("* Failed to enter passw");
        }

    }

    public void clickOnSubmitBtn() throws InterruptedException {
        if (this.submitBtn.isDisplayed()) {
            clickButton(this.submitBtn);
            System.out.println("* clicked on submit Btn Successfully");
        } else {
            System.out.println("* Failed to click on submit Btn Successfully");
        }

    }

    public void loginSuccessfullyToAmazonWebsite(String phoneNumber, String passw) throws InterruptedException {
        this.enterPhoneNumber(phoneNumber);
        this.clickOnContinueBtn();
        this.enterPassword(passw);
        this.clickOnSubmitBtn();
    }


    public loginPage(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }
}


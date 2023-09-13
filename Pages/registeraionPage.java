//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import SRC.Pages.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class registeraionPage extends basePage {
    @FindBy(
            id = "ap_customer_name"
    )
    WebElement customerNameTxt;
    @FindBy(
            id = "ap_email"
    )
    WebElement emailTxt;
    @FindBy(
            id = "ap_password"
    )
    WebElement passwordTxt;
    @FindBy(
            id = "ap_password_check"
    )
    WebElement reEnterPasswordTxt;
    @FindBy(
            id = "continue"
    )
    WebElement createBtn;

    public registeraionPage(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }

    public void userFillRequiredData(String customerName, String customerEmail, String password) throws InterruptedException {
        this.wait(1000);
//        if (this.driver.getPageSource().contains("Your name") && this.driver.getPageSource().contains("Email") && this.driver.getPageSource().contains("Password") && this.driver.getPageSource().contains("Re-enter password")) {
//            setText(this.customerNameTxt, customerName);
//            setText(this.emailTxt, customerEmail);
//            this.scrollDown(200);
//            setText(this.passwordTxt, password);
//            setText(this.reEnterPasswordTxt, password);
//            System.out.println("* Data Filled Successfully");
//        } else {
//            System.out.println("* Failed To fill customer data");
//        }

    }

    public void clickon_createAccountBtn() {
        if (this.createBtn.isDisplayed()) {
            clickButton(this.createBtn);
            System.out.println("* customer clicks on create Btn");
        } else {
            System.out.println("* Failed To click on create Btn");
        }

    }
}

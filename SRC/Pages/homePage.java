//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Pages;

import SRC.Pages.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class homePage extends basePage {

    @FindBy(
            css = "a[id='nav-link-accountList']"
    ) //a[id='nav-link-accountList']
    WebElement menuItm;
    @FindBy(
            css = "#id=nav-flyout-ya-signin"
    ) //a[id='nav-link-accountList']
    WebElement signInBtn;

    @FindBy(
            id = "nav-hamburger-menu"
    )
    WebElement AllMenuBtn;

    @FindBy(
            css = "a[data-menu-id='16']"
    )
    WebElement videGamesSection;

    @FindBy(
            css = "a[class='hmenu-item hmenu-compressed-btn']"
    )

    WebElement seeAllBtn;

    @FindBy(
            linkText = "All Video Games"
    )

    WebElement AllVideoGamesBtn;


    public homePage(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }

    public void clickOn_SignInMenu() throws InterruptedException {
        if (this.menuItm.isDisplayed()) {
            clickButton(this.menuItm);
            System.out.println("* Clicked on MenuItm list");
        } else {
            System.out.println("* Failed to  click on MenuItm list");
        }
    }
    public void clickOn_SignInBtn() throws InterruptedException {
        if (this.signInBtn.isDisplayed()) {
            clickButton(this.signInBtn);
            System.out.println("* Clicked on signInBtn list");
        } else {
            System.out.println("* Failed to  click on signInBtn list");
        }
    }

    public void openMenuList() throws InterruptedException {
        if (this.AllMenuBtn.isDisplayed()) {
            clickButton(this.AllMenuBtn);
            System.out.println("* Clicked on Menu list");
        } else {
            System.out.println("* Failed to  click on Menu list");
        }

    }

    public void clickOnSeeAllBtn() throws InterruptedException {
        if (this.seeAllBtn.isDisplayed()) {
            clickButton(this.seeAllBtn);
            System.out.println("* Clicked on see All btn in list");
        } else {
            System.out.println("* Failed to  click on on see All btn in lis");
        }

    }

    public void chooseVideoGameSection() throws InterruptedException {
        if (this.videGamesSection.isDisplayed()) {
            clickButton(this.videGamesSection);
            System.out.println("* Clicked on videGame Tab btn in list");
        } else {
            System.out.println("* Failed to  click on videGame Tab bt in lis");
        }

    }

    public void chooseAllVideoGames() throws InterruptedException {
        if (this.AllVideoGamesBtn.isDisplayed()) {
            clickButton(this.AllVideoGamesBtn);
            System.out.println("* Clicked on All video Games");
        } else {
            System.out.println("* Failed to  click on All video Games");
        }

    }


}

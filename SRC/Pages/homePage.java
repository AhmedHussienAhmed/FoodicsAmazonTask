//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Pages;

import SRC.Pages.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class homePage extends basePage {

    @FindBy(
            css = "a[id='nav-link-accountList']"
    )
    WebElement menuItm;
    @FindBy(
            css = "#id=nav-flyout-ya-signin"
    )
    WebElement signInBtn;

    @FindBy(
            css = "a[id='nav-hamburger-menu']"
    )
    WebElement AllMenuBtn;

    @FindBy(
            linkText = "Video Games"
    )
    WebElement videGamesSection;

    @FindBy(
            css = "a[class*='hmenu-compressed-btn']"
    )
    List<WebElement> seeAllBtn;

    @FindBy(
            css = "#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a"
    )
    WebElement AllVideoGamesBtn;

    @FindBy(
            css = "ul[data-menu-id=\"16\"]\n"
    )
    WebElement AllVideoGamesList;


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

    public void openMenuList() throws InterruptedException {
        if (this.AllMenuBtn.isDisplayed()) {
            clickButton(this.AllMenuBtn);
            System.out.println("* Clicked on Menu list");
        } else {
            System.out.println("* Failed to  click on Menu list");
        }

    }

    public void clickOnSeeAllBtn() throws InterruptedException {
        scrollDown(500);
        if (!this.seeAllBtn.isEmpty()) {
            for (WebElement seeAllBtn : this.seeAllBtn){
                clickButton(seeAllBtn);
                WebElement compressedMenu =  seeAllBtn.findElement(By.xpath("..")).
                        findElement(By.xpath("preceding-sibling::*[1]"));

                WebElement targetCategory = compressedMenu.findElement(By.linkText("Video Games"));
                if (targetCategory.isDisplayed()){
                    clickButton(targetCategory);
                    break;
                }

            }
            System.out.println("* Clicked on see All btn in list");
        } else {
            System.out.println("* Failed to  click on on see All btn in list");
        }
    }

    public void chooseVideoGameSection() throws InterruptedException {
        scrollDown(300);
        if (this.videGamesSection.isDisplayed()) {
            clickButton(this.videGamesSection);
            System.out.println("* Clicked on videGame Tab btn in list");
        } else {
            System.out.println("* Failed to  click on videoGame Tab bt in lis");
        }
    }

    public void chooseAllVideoGames() throws InterruptedException {

        if (this.AllVideoGamesBtn.isDisplayed()) {
            List<WebElement> VideoElements = driver.findElements(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a"));
            clickButton(VideoElements.get(1));
            System.out.println("* Clicked on All video Games");
        } else {
            System.out.println("* Failed to  click on All video Games");
        }


    }
}
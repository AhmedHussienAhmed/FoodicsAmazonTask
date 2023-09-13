//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class basePage {
    protected WebDriver driver;
    public Select select;
    public Actions action;

    public basePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setText(WebElement textElement, String value) {
        textElement.sendKeys(new CharSequence[]{value});
    }

    public void scrollDown(int number) {
        ((JavascriptExecutor)this.driver).executeScript("scroll(0," + number + ")", new Object[0]);
    }

    public void scrollUp(int number) {
        ((JavascriptExecutor)this.driver).executeScript("scroll(" + number + ",0)", new Object[0]);
    }

    public void wait(int number) throws InterruptedException {
        Thread.sleep((long)number);
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }











}

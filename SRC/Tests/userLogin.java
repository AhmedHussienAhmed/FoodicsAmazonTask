//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Tests;

import SRC.Pages.homePage;
import SRC.Pages.loginPage;
import SRC.Pages.videoGamesPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class userLogin extends SRC.Tests.testBase {
    homePage homePageObject;
    loginPage loginPageObject;
    videoGamesPage videoGamesPageObject;

    @Test
    @Description("user able to add video games item to his cart")
    public void AddVideoGamesItemsToCart() throws IOException, ParseException, InterruptedException {
        homePageObject = new homePage(driver);
        loginPageObject = new loginPage(driver);
        videoGamesPageObject = new videoGamesPage(driver);
        homePageObject.clickOn_SignInMenu();
        loginPageObject.loginSuccessfullyToAmazonWebsite("01001433239", "123456Aa");
        homePageObject.openMenuList();
        homePageObject.clickOnSeeAllBtn();
        homePageObject.chooseVideoGameSection();
        homePageObject.chooseAllVideoGames();
        videoGamesPageObject.clickOn_freeShippingCheckBox();
        videoGamesPageObject.clickOn_newFilteration();
        videoGamesPageObject.clickOn_sortBtn();
        videoGamesPageObject.clickOn_HighToLow();
        videoGamesPageObject.checkAllItemList(15000);
        videoGamesPageObject.clickOn_GoToBasket();
        videoGamesPageObject.compareItemsInBasket();
        videoGamesPageObject.clickOn_ProcessToBuy();
        videoGamesPageObject.compareItemsInBasket();
        videoGamesPageObject.addNewAddressFullName("ragab");
        videoGamesPageObject.addNewAddressMobileNumber("01001433239");
        videoGamesPageObject.addNewAddressStreetName("Abou Bakr el sedeeek");
        videoGamesPageObject.addNewAddressBuildingNumber("12");
        videoGamesPageObject.addNewAddressCity("Cairo");
        videoGamesPageObject.addNewAddressDistrict("Zeitoun-Toman Bai");
        videoGamesPageObject.addNewAddressLandmark("cfc");
        videoGamesPageObject.clickOn_addAddress();
        videoGamesPageObject.select_COD();
    }
}

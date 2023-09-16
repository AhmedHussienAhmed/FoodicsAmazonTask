//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Tests;

import SRC.Pages.homePage;
import SRC.Pages.loginPage;
import SRC.Pages.videoGamesPage;
import  SRC.TestData.jsonReader;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class userLoginThenAddVideoGamesItemToCart extends SRC.Tests.testBase {
    homePage homePageObject;
    loginPage loginPageObject;
    videoGamesPage videoGamesPageObject;
    jsonReader jsonReaderObject;

    @BeforeClass
    public void loadNecesseray(){
        try{
            jsonReaderObject = new jsonReader();
            jsonReaderObject.jsonFileReader();
        }catch( Exception e){
            System.out.println(e);
        }
    }

    @Test
    @Description("user able to add video games item to his cart")
    public void AddVideoGamesItemsToCart() throws IOException, ParseException, InterruptedException {
        homePageObject = new homePage(driver);
        loginPageObject = new loginPage(driver);
        videoGamesPageObject = new videoGamesPage(driver);

        homePageObject.clickOn_SignInMenu();
        loginPageObject.loginSuccessfullyToAmazonWebsite(jsonReaderObject.phoneNumber,jsonReaderObject.password);
        Thread.sleep(10000);
        homePageObject.openMenuList();
        homePageObject.clickOnSeeAllBtn();
        homePageObject.chooseAllVideoGames();
        videoGamesPageObject.clickOn_freeShippingCheckBox();
        videoGamesPageObject.enterMAxValuePrice(jsonReaderObject.pricePerItem);
        videoGamesPageObject.clickOnGoBtn();

        videoGamesPageObject.clickOn_newFiltration();
        videoGamesPageObject.clickOn_sortBtn();
        videoGamesPageObject.clickOn_HighToLow();

        String[] desiredItem = videoGamesPageObject.checkAllItemList(15000);
        videoGamesPageObject.addItemToBasket(desiredItem);
        videoGamesPageObject.clickOn_ProceedToBuy();
        boolean itemCorrect =  videoGamesPageObject.compareItemsInBasket(desiredItem);
        videoGamesPageObject.addNewAddressFullName(jsonReaderObject.fullName);
        videoGamesPageObject.addNewAddressMobileNumber(jsonReaderObject.mobileNumber);
        videoGamesPageObject.addNewAddressStreetName(jsonReaderObject.streetName);
        videoGamesPageObject.addNewAddressBuildingNumber(jsonReaderObject.buildingNumber);
        videoGamesPageObject.addNewAddressCity(jsonReaderObject.city);
        videoGamesPageObject.addNewAddressDistrict(jsonReaderObject.district);
        videoGamesPageObject.addNewAddressLandmark(jsonReaderObject.landmark);
        videoGamesPageObject.clickOn_addAddress();
        videoGamesPageObject.select_COD(); //btn is always dimmed from website
    }
}

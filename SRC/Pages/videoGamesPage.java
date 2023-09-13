package SRC.Pages;


import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class videoGamesPage extends basePage {

    @FindBy(
            css = "input[id='apb-browse-refinements-checkbox_2']"
    )
    WebElement freeShippingCheckBox;

    @FindBy(
            css = "select[id='s-result-sort-select']"
    )
    WebElement newBtnFilter;

    @FindBy(
            css = "li[id='p_n_condition-type/28071525031']"
    )
    WebElement sortBtn;

    @FindBy(
            linkText = "Price: High to Low"
    )
    WebElement highToLowSortBtn;

    @FindBy(
            css = "div[data-cel-widget*='search_result_']"
    )
    WebElement videoGamesItems;


    @FindBy(
            css = "h2[class*='a-size-mini a-spacing-none']"
    )
    WebElement itemName;

    @FindBy(
            css = "div[data-cel-widget*='search_result_'] span[class='a-price-whole']"
    )
    WebElement itemPrice;

    @FindBy(
            css = "input[id='add-to-cart-button']"
    )
    WebElement addToCartBtn;

    @FindBy(
            css = "span[id='sw-gtc']"
    )
    WebElement goToBasketBtn;


    @FindBy(
            css = "input[name='proceedToRetailCheckout']"
    )
    WebElement proceedToBuyBtn;


    @FindBy(
            css = "input[id='address-ui-widgets-enterAddressFullName']"
    )
    WebElement addressFullName;


    @FindBy(
            css = "input[id='address-ui-widgets-enterAddressPhoneNumber']"
    )
    WebElement addressMobileNumber;

    @FindBy(
            css = "input[id='address-ui-widgets-enterAddressLine1']"
    )
    WebElement addressStreetName;

    @FindBy(
            css = "input[id='address-ui-widgets-enter-building-name-or-number']"
    )
    WebElement addressBuildingName;

    @FindBy(
            css = "input[id='address-ui-widgets-enterAddressCity']"
    )
    WebElement addressCity;

    @FindBy(
            css = "input[id='address-ui-widgets-enterAddressDistrictOrCounty']"
    )
    WebElement addressDistrict;
    //Zeitoun-Toman Bai

    @FindBy(
            css = "input[id='address-ui-widgets-landmark']"
    )
    WebElement addressLandmark;

    @FindBy(
            css = "span[id='address-ui-widgets-form-submit-button-announce']"
    )
    WebElement addAddressBtn;


    @FindBy(
            css = "input[name='ppw-instrumentRowSelection']"
    )
    WebElement CODBtn;

    public void clickOn_freeShippingCheckBox() throws InterruptedException {
        if (this.freeShippingCheckBox.isDisplayed()) {
            clickButton(this.freeShippingCheckBox);
            System.out.println("* Clicked on free Shipping CheckBox");
        } else {
            System.out.println("* Failed to  click on free Shipping CheckBox");
        }
    }

    public void clickOn_newFilteration() throws InterruptedException {
        if (this.newBtnFilter.isDisplayed()) {
            clickButton(this.newBtnFilter);
            System.out.println("* Clicked on new Filteration");
        } else {
            System.out.println("* Failed to  click on new Filteration");
        }

    }

    public void clickOn_sortBtn() throws InterruptedException {
        if (this.sortBtn.isDisplayed()) {
            clickButton(this.sortBtn);
            System.out.println("* Clicked on sortBtn");
        } else {
            System.out.println("* Failed to  click on sortBtn");
        }

    }

    public void clickOn_HighToLow() throws InterruptedException {
        if (this.highToLowSortBtn.isDisplayed()) {
            clickButton(this.highToLowSortBtn);
            System.out.println("* Clicked on highToLowSortBtn");
        } else {
            System.out.println("* Failed to  click on highToLowSortBtn");
        }
    }

    public void checkAllItemList(int thresVar) throws InterruptedException {
        Stream<String[]> itemsList = driver.findElements(new By.ByCssSelector("div[data-cel-widget*='search_result_']"))
                .stream().map((element) -> {
                    WebElement itemTitle = element.findElement(By.cssSelector("h2"));
                    String itemName = itemTitle.getText();
                    String itemPrice = element.findElement(By.cssSelector(("span[class='a-price-whole']"))).getText();
                    String itemLink = itemTitle.getAttribute("href");
                    return new String[]{itemName, itemPrice, itemLink};
                });

        // Filter items based method
        List<String[]> targetItems = itemsList.filter(itm -> Integer.parseInt(itm[1]) < thresVar).toList();

        // Add items to card method
        for (String[] itm : targetItems) {
            driver.get(itm[2]);
            WebElement cartButton = driver.findElement(By.cssSelector("input[id='add-to-cart-button']"));
            clickButton(this.addToCartBtn);
        }
    }


    public void clickOn_GoToBasket() throws InterruptedException {
        if (this.newBtnFilter.isDisplayed()) {
            clickButton(this.newBtnFilter);
            System.out.println("* Clicked on add to basket");
        } else {
            System.out.println("* Failed to  click on add to basketn");
        }

    }

    public void compareItemsInBasket() throws InterruptedException {


    }

    public void clickOn_ProcessToBuy() throws InterruptedException {
        if (this.proceedToBuyBtn.isDisplayed()) {
            clickButton(this.proceedToBuyBtn);
            System.out.println("* Clicked on proceed to Buy btn");
        } else {
            System.out.println("* Failed to  click on proceed to Buy btn");
        }

    }

    public void addNewAddressFullName(String fullName) throws InterruptedException {
        if (this.addressFullName.isDisplayed()) {
            setText(this.addressFullName, fullName);
            System.out.println("* entered address fullName successfully");
        } else {
            System.out.println("* Failed to enter address fullName");
        }
    }

    public void addNewAddressMobileNumber(String mobileNumber) throws InterruptedException {
        if (this.addressMobileNumber.isDisplayed()) {
            setText(this.addressMobileNumber, mobileNumber);
            System.out.println("* entered address number successfully");
        } else {
            System.out.println("* Failed to enter address number");
        }
    }

    public void addNewAddressStreetName(String streetName) throws InterruptedException {
        if (this.addressStreetName.isDisplayed()) {
            setText(this.addressStreetName, streetName);
            System.out.println("* entered address streetName successfully");
        } else {
            System.out.println("* Failed to enter address streetName");
        }
    }

    public void addNewAddressBuildingNumber(String buildingNumber) throws InterruptedException {
        if (this.addressBuildingName.isDisplayed()) {
            setText(this.addressBuildingName, buildingNumber);
            System.out.println("* entered address building number successfully");
        } else {
            System.out.println("* Failed to enter building number streetName");
        }
    }

    public void addNewAddressCity(String city) throws InterruptedException {
        if (this.addressCity.isDisplayed()) {
            setText(this.addressCity, city);
            System.out.println("* entered address city successfully");
        } else {
            System.out.println("* Failed to enter address city");
        }
    }

    public void addNewAddressDistrict(String district) throws InterruptedException {
        if (this.addressDistrict.isDisplayed()) {
            setText(this.addressDistrict, district);
            System.out.println("* entered address district successfully");
        } else {
            System.out.println("* Failed to enter address district");
        }
    }

    public void addNewAddressLandmark(String landmark) throws InterruptedException {
        if (this.addressLandmark.isDisplayed()) {
            setText(this.addressLandmark, landmark);
            System.out.println("* entered address landmark successfully");
        } else {
            System.out.println("* Failed to enter address landmark");
        }
    }

    public void clickOn_addAddress() throws InterruptedException {
        if (this.addAddressBtn.isDisplayed()) {
            clickButton(this.addAddressBtn);
            System.out.println("* clicked on add address successfully");
        } else {
            System.out.println("* Failed to click on add address");
        }
    }

    public void select_COD() throws InterruptedException {
        if (this.CODBtn.isDisplayed()) {
            clickButton(this.CODBtn);
            System.out.println("* clicked on COD selector");
        } else {
            System.out.println("* Failed to click on COD selector");
        }
    }

    public videoGamesPage(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }
}

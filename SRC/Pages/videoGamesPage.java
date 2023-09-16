package SRC.Pages;


import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class videoGamesPage extends basePage {

    @FindBy(xpath = "//*[@id=\"s-refinements\"]/div[2]/ul/li/span/a/div[1]/label/ancestor::a")
    WebElement freeShippingCheckBox;

    @FindBy(id = "p_n_condition-type/28071525031")
    WebElement newBtnFilter;

    @FindBy(xpath = "//select[@id='s-result-sort-select']/following-sibling::span[1]"

    )
    WebElement sortBtn;

    @FindBy(css = "input[name='high-price']"

    )
    WebElement maxValue;

    @FindBy(css = "input[class='a-button-input']"

    )
    WebElement GoBtn;

    @FindBy(linkText = "Price: High to Low")
    WebElement highToLowSortBtn;

    @FindBy(css = "div[data-cel-widget*='search_result_']")
    WebElement videoGamesItems;


    @FindBy(css = "h2[class*='a-size-mini a-spacing-none']")
    WebElement itemName;

    @FindBy(css = "div[data-cel-widget*='search_result_'] span[class='a-price-whole']")
    WebElement itemPrice;

    @FindBy(css = "input[id='add-to-cart-button']")
    WebElement addToCartBtn;

    @FindBy(css = "span[id='sw-gtc']")
    WebElement goToBasketBtn;


    @FindBy(css = "input[name='proceedToRetailCheckout']")
    WebElement proceedToBuyBtn;


    @FindBy(css = "input[id='address-ui-widgets-enterAddressFullName']")
    WebElement addressFullName;


    @FindBy(css = "input[id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement addressMobileNumber;

    @FindBy(css = "input[id='address-ui-widgets-enterAddressLine1']")
    WebElement addressStreetName;

    @FindBy(css = "input[id='address-ui-widgets-enter-building-name-or-number']")
    WebElement addressBuildingName;

    @FindBy(css = "input[id='address-ui-widgets-enterAddressCity']")
    WebElement addressCity;

    @FindBy(css = "input[id='address-ui-widgets-enterAddressDistrictOrCounty']")
    WebElement addressDistrict;

    @FindBy(css = "input[id='address-ui-widgets-landmark']")
    WebElement addressLandmark;

    @FindBy(css = "input[type='submit']")
    WebElement addAddressBtn;


    @FindBy(css = "input[name='ppw-instrumentRowSelection']")
    WebElement CODBtn;

    public void clickOn_freeShippingCheckBox() throws InterruptedException {

        if (this.freeShippingCheckBox.isDisplayed()) {
            clickButton(this.freeShippingCheckBox);
            System.out.println("* Clicked on free Shipping CheckBox");
        } else {
            System.out.println("* Failed to  click on free Shipping CheckBox");
        }
    }

    public void clickOn_newFiltration() throws InterruptedException {
        if (this.newBtnFilter.isDisplayed()) {
            clickButton(this.newBtnFilter);
            System.out.println("* Clicked on new Filtration");
        } else {
            System.out.println("* Failed to  click on new Filtration");
        }
    }

    public void clickOn_sortBtn() throws InterruptedException {
        scrollUp(300);
        Thread.sleep(300);
        if (this.sortBtn.isDisplayed()) {
            clickButton(this.sortBtn);
            System.out.println("* Clicked on sortBtn");
        } else {
            System.out.println("* Failed to  click on sortBtn");
        }
    }

    public void enterMAxValuePrice(String price) throws InterruptedException {
        scrollDown(300);
        if (this.maxValue.isDisplayed()) {
            setText(this.maxValue, price);
            System.out.println("* entered Max value");
            } else {
                System.out.println("* Failed to  enter Max value");
            }
    }
    public void clickOnGoBtn() throws InterruptedException {
        if (this.GoBtn.isDisplayed()) {

            clickButton(this.GoBtn);
            System.out.println("* CClicked on Go Btn");
        } else {
            System.out.println("* Failed to  click on Go Btn");
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

    public String[] checkAllItemList(int var) throws InterruptedException {
        List<String[]> itemsList = driver.findElements(new By.ByCssSelector("div[data-component-type='s-search-result']")).stream().map((element) -> {
            WebElement itemTitle = element.findElement(By.cssSelector("h2"));
            String itemName = itemTitle.getText();
            try {
                String itemPrice = element.findElement(By.cssSelector(("span[class='a-price-whole']"))).getText();
                String itemLink = itemTitle.findElement(new By.ByCssSelector("a")).getAttribute("href");
                return new String[]{itemName, itemPrice, itemLink};
            } catch (Exception e) {
                return null;
            }
        }).toList();
        System.out.printf("* Found %s of search results. %n", itemsList.size());

        // Filter items based method
        List<String[]> targetItems = itemsList.stream().filter(Objects::nonNull).filter(itm -> Integer.parseInt(itm[1].replace(",", "")) < var).toList();
        System.out.printf("* Only found %s below 15,000. %n", targetItems.size());
        return targetItems.get(0);
    }

    public void addItemToBasket(String[] targetItem) throws InterruptedException {
        String itemUrl = targetItem[2];
        System.out.printf("* Navigating to %s. %n", itemUrl);
        if (itemUrl != null) {
            driver.get(itemUrl);
            WebElement cartButton = driver.findElement(By.cssSelector("input[id='add-to-cart-button']"));
            clickButton(cartButton);
            System.out.println("* added item into basket");

        } else {
            System.out.println("* failed to add item into basket");
        }
    }

    public boolean compareItemsInBasket(String[] selectedItem) throws InterruptedException {
        List<String> cartItems = driver.findElements(new By.ByCssSelector("div[data-price]")).stream().map((element) -> {
            WebElement itemTitle = element.findElement(By.cssSelector("span.sc-grid-item-product-title"));
            return itemTitle.getText();
        }).toList();
        return true;
    }

    public void clickOn_ProceedToBuy() throws InterruptedException {
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
            clickButton(this.addressCity);
            this.addressCity.findElement(new By.ByXPath("following-sibling::ul"))
                    .findElement(new By.ByCssSelector("li:nth-of-type(1)")).click();
            System.out.println("* entered address city successfully");
        } else {
            System.out.println("* Failed to enter address city");
        }
    }

    public void addNewAddressDistrict(String district) throws InterruptedException {
        if (this.addressDistrict.isDisplayed()) {
            clickButton(this.addressDistrict);
            setText(this.addressDistrict,"10th District");
//            this.addressDistrict.findElement(new By.ByXPath("following-sibling::ul")).
//                    findElement(new By.ByCssSelector("li:nth-of-type(1)")).click();
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
        List<WebElement> submitBtn = driver.findElements(By.cssSelector("input[type='submit']"));
        clickButton(submitBtn.get(2));
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

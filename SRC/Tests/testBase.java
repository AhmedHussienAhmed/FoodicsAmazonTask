//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SRC.Tests;

import SRC.Utilities.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class testBase {
    public static WebDriver driver;
    public String Baseurl = "https://www.amazon.eg/?language=en_AE";
    String chromeDriverPath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
    String firefoxDriverPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";


    public testBase() {
    }

    @BeforeTest
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", this.chromeDriverPath);
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", this.firefoxDriverPath);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(this.Baseurl);
    }


    @AfterTest
    public void stopDriver() throws InterruptedException {
        Thread.sleep(8000L);
        driver.close();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == 2) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            helper.captureScreenshot(driver, result.getName());
        }

    }
}

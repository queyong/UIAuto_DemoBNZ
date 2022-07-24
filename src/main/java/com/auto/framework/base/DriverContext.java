package com.auto.framework.base;

import com.auto.framework.config.Setting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverContext {
    public enum DriverType {
        Firefox,
        Chrome,
        IE,
        Edge
    }

    private static DriverType driverType;
    private static WebDriver driver = null;

    private DriverContext() {
        //hidden constructor from outer calls
    }

    public static void setDriver(DriverType driverType) {
        DriverContext.driverType = driverType;
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (driverType) {
                case Firefox:
//                    System.setProperty("webdriver.gecko.driver", Setting.DriverPath.concat("/geckodriver.exe"));
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case Edge:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void quit() {
        if(driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static void waitUntilPageIsFullyLoaded(int maxTimeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 250);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    //TODO
    public static void waitElementClickable(final WebElement elementFindBy, long... timeOutInSec) {
        WebDriverWait wait;
        if (timeOutInSec.length == 0)
            wait = new WebDriverWait(getDriver(), Setting.GlobalTimeout);
        else
            wait = new WebDriverWait(getDriver(), timeOutInSec[0]);
        wait.until(ExpectedConditions.elementToBeClickable(elementFindBy));
    }

    //TODO
    public static WebElement waitElementClickable(final By by, long... timeOutInSec) {
        WebDriverWait wait;
        if (timeOutInSec.length == 0)
            wait = new WebDriverWait(getDriver(), Setting.GlobalTimeout);
        else
            wait = new WebDriverWait(getDriver(), timeOutInSec[0]);
        wait.until(ExpectedConditions.elementToBeClickable(by));

        return getDriver().findElement(by);
    }

    //TODO
    public static void waitUntilElementExist(final WebElement ele, long... timeOutInSec) {
        WebDriverWait wait;
        if(timeOutInSec.length == 0)
            wait = new WebDriverWait(driver, Setting.GlobalTimeout);
        else
            wait = new WebDriverWait(driver, timeOutInSec[0]);

         wait.until(ExpectedConditions.elementToBeSelected(ele));
    }

    public static void waitUntilElementExist(final By by, long... timeOutInSec) {
        WebDriverWait wait;
        if(timeOutInSec.length == 0)
            wait = new WebDriverWait(driver, Setting.GlobalTimeout, 20);
        else
            wait = new WebDriverWait(driver, timeOutInSec[0], 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

//    public static void waitUntilElementExist(By locator, int maxTimeOutSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 250);
//        wait.until(dr ->
//        {
//            try {
//                return dr.findElements(locator).size() > 0;
//            } catch (WebDriverException e) {
//                return false;
//            }
//        });
//    }

    public void waitUntilElementIsClickable(By locator, int maxTimeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 250);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementIsClickable(WebElement webElement, int maxTimeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 250);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilElementIsVisible(By locator, int maxTimeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilElementIsNotVisible(By locator, int maxTimeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeOutSeconds, 250);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void scrollToElement(final WebElement elementFindBy, long... timeOutInSec) {
        WebDriverWait wait;
        if (timeOutInSec.length == 0)
            wait = new WebDriverWait(getDriver(), Setting.GlobalTimeout);
        else
            wait = new WebDriverWait(getDriver(), timeOutInSec[0]);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementFindBy);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }



}

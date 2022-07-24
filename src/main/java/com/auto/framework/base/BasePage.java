package com.auto.framework.base;

import com.auto.framework.config.Setting;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;

    public BasePage (){
        DriverContext.setDriver(Setting.DriverType);
        this.driver = DriverContext.getDriver();
    }

    protected static void shouldAppearTitle(String title) {
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        waiter.until(ExpectedConditions.titleIs(title));
        Assert.assertTrue("Title is incorrect. Actual: " + driver.getTitle()
                + ", expected: " + title, driver.getTitle().contains(title));
    }

    protected static void isPageLoaded(WebElement ele) {
        DriverContext.waitUntilPageIsFullyLoaded(5);
    }


}

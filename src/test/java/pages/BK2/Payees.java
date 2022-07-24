package pages.BK2;

import com.auto.framework.base.BasePage;
import com.auto.framework.base.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Payees extends BasePage {
    private String pageUrl = "https://www.demo.bnz.co.nz/client/payees";
    private By byAddButton = By.xpath("//button[@class='Button Button--sub Button--translucid js-add-payee']");

    //payee modal
    private By byAddPayeeModal = By.xpath("//div[@id='modal-form-manager']");
    private By byPayeeAddButton = By.xpath("//button[text()='Add']");
    private By byInputPayeeName = By.id("ComboboxInput-apm-name");
    private By byApmBank = By.id("apm-bank");
    private By byApmBranch = By.id("apm-branch");
    private By byApmAccount = By.id("apm-account");
    private By byApmSuffix = By.id("apm-suffix");
    private By byErrorBox = By.xpath("//div[@class='error-box']");
    private By byNameOfPayeesList = By.xpath("//span[@class='js-payee-name']");
    private By byNameHeader = By.xpath("//h3[@class='js-payee-name-column CustomSection-headingSpread u-textStyle-bold']");



    public void isPageFullyLoaded() {
        DriverContext.waitUntilPageIsFullyLoaded(10);
    }

    public void clickAddButton() {
        driver.findElement(byAddButton).click();
    }

    public void inputPayeeName(String name) {
        driver.findElement(byAddPayeeModal).findElement(byInputPayeeName).sendKeys(name + Keys.ENTER);
    }

    public void inputPayeeAccount(String accountNumber) {
        DriverContext.waitUntilElementExist(byApmBank);
        String account = accountNumber.replaceAll("[^0-9]","");
        driver.findElement(byAddPayeeModal).findElement(byApmBank).sendKeys(account + Keys.ENTER);

    }

    public void clickPayeeAdd() {
        driver.findElement(byPayeeAddButton).click();
    }

    public void isPayeeInList (String name, String account){
        String locRec = String.format("//div[./p/span[text()='%s'] and .//p[text()='%s']]", name, account);
        By ele = By.xpath(locRec);
        DriverContext.waitUntilElementExist(ele, 2);
    }

    public void hasNotification(String message) {
        String locMessage = String.format("//span[text()='%s']", message);
        By byMessage = By.xpath(locMessage);
//        DriverContext.waitUntilElementIsVisible(byMessage, 5);
        DriverContext.waitUntilElementExist(byMessage, 2);
    }

    public void hasErrorMessage() {
        DriverContext.waitUntilElementIsVisible(byErrorBox, 2);
    }

    public void hasNoErrorMessage() {
        DriverContext.waitUntilElementIsNotVisible(byErrorBox, 2);
    }

    public void isPayeeSort(String sortOrder) {
        ArrayList<String> obtainedList = new ArrayList<>();

        List<WebElement> elementList= driver.findElements(byNameOfPayeesList);
        for(WebElement ele:elementList){
            obtainedList.add(ele.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }

        Comparator comparator = (sortOrder.equalsIgnoreCase("Ascending")) ?
                String.CASE_INSENSITIVE_ORDER: String.CASE_INSENSITIVE_ORDER.reversed();
        Collections.sort(sortedList, comparator);

        Assert.assertTrue(sortedList.equals(obtainedList));
    }

    public void clickNameHeader() {
        driver.findElement(byNameHeader).click();
    }
}

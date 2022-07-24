package pages.BK2;

import com.auto.framework.base.BasePage;
import com.auto.framework.base.DriverContext;
import org.openqa.selenium.By;

public class BNZDemoMainPage extends BasePage {
    private String pageTitle = "Internet Banking";
    private String pageUrl = "https://www.demo.bnz.co.nz/client/";

    private By byMenuButton = By.xpath("//button[@class='Button Button--transparent js-main-menu-btn MenuButton']");

    public  void  navigate() {
        driver.get(pageUrl);
        shouldAppearTitle (pageTitle);
    }

    public void clickMenuButton() {
        DriverContext.waitElementClickable(byMenuButton);
        DriverContext.getDriver().findElement(byMenuButton).click();
    }

}

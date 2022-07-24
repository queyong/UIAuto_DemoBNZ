package pages.BK2;

import com.auto.framework.base.BasePage;
import org.openqa.selenium.By;

public class NavMenu extends BasePage {
    private By byMainMenu = By.xpath("//section[@class='MainMenu']");
    private By byMainMenuNav = By.xpath("//nav[@class='MainMenu-nav']");

    public void clickMenuNav(String menuItem) {
        String loc = "//span[text()='" + menuItem + "']";
        driver.findElement(byMainMenuNav).findElement(By.xpath(loc)).click();
    }

}

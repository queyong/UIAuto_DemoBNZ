package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BK2.BNZDemoMainPage;
import pages.BK2.NavMenu;
import pages.BK2.Payees;

import java.util.List;
import java.util.Map;


public class PayeesSteps {
    private BNZDemoMainPage mainPage;
    private NavMenu menu;
    private Payees payeesPage;

    public PayeesSteps() {
        this.mainPage = new BNZDemoMainPage();
        this.menu = new NavMenu();
        this.payeesPage = new Payees();
    }

    @When("^I click Menu button$")
    public void iClickMenuButton() {
        mainPage.clickMenuButton();
    }

    @And("^I click \"([^\"]*)\" item from Menu$")
    public void iClickItemFromMenu(String item)  {
        menu.clickMenuNav(item);
    }

    @Then("^I can see Payees page is loaded$")
    public void iCanSeePayeesPageIsLoaded() {
        payeesPage.isPageFullyLoaded();
    }

    @When("^I click Add button$")
    public void iClickButton() {
        payeesPage.clickAddButton();
    }

    @And("^I add following Payee details into the table$")
    public void iAddFollowingPayeeDetailsIntoTheTable(DataTable payee) {
        List<Map<String, String>> rows = payee.asMaps(String.class, String.class);

        for (Map<String, String> col: rows) {
            String name = col.get("name");
            String account = col.get("account");

            payeesPage.inputPayeeName(name);
            payeesPage.inputPayeeAccount(account);
        }
    }

    @And("^I click Add button in the table$")
    public void iClickAddButtonInTheTable() {
        payeesPage.clickPayeeAdd();
    }

    @Then("^I can see the \"([^\"]*)\" is displayed$")
    public void iCanSeeTheIsDisplayed(String message)  {
        payeesPage.hasNotification(message);
    }

    @And("^I can see the following Payee is added in the list$")
    public void iCanSeeTheFollowingPayeeIsAddedInTheList(DataTable payee) {
        List<Map<String, String>> rows = payee.asMaps(String.class, String.class);

        for (Map<String, String> col: rows) {
            String name = col.get("name");
            String account = col.get("account");

            payeesPage.isPayeeInList(name, account);
        }
    }

    @And("^I can see the error message in the table$")
    public void iCanSeeTheErrorMessageInTheTable() {
        payeesPage.hasErrorMessage();
    }

    @Then("^the error messages in the table are gone$")
    public void theErrorMessagesInTheTableAreGone() {
        payeesPage.hasNoErrorMessage();
    }

    @Then("^I can see the list is sorted in \"([^\"]*)\" order$")
    public void iCanSeeTheListIsSortedInOrder(String order) {
        payeesPage.isPayeeSort(order);
    }

    @And("^I click the Name header$")
    public void iClickTheNameHeader() {
        payeesPage.clickNameHeader();
    }

    @When("^I navigate demo main page$")
    public void iNavigateDemoMainPage() {
        mainPage.navigate();
    }
}

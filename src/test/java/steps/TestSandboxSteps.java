package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestSandboxPage;

public class TestSandboxSteps {

    TestSandboxPage sandboxPage = new TestSandboxPage();

    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandboxSite() {
        sandboxPage.navigateToTheSandboxSite();
    }

    @And("^select a value from the dropdown$")
    public void selectState() {
        //sandboxPage.selectCategory("Magenta");
        sandboxPage.selectAllCategories();
    }

}

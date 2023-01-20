package pages;

public class TestSandboxPage extends BasePage {

    private String categoryDropdown = "//select[@id='oldSelectMenu']";

    public TestSandboxPage() {
        super(driver);
    }

    public void navigateToTheSandboxSite() {
        navigateTo("https://demoqa.com/select-menu");
    }

    public void selectCategory(String item) {
        selectFromDropdownByText(categoryDropdown, item);
    }

    public void selectAllCategories() {
        selectFromDropdownAllItems(categoryDropdown);
    }

}

package pages;

public class GooglePage extends BasePage {

    private String searchButton = "//input[@value='Google Search']";

    private String searchTextField = "//input[@title='Search']";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch() {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);
    }

}

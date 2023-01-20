package pages;

import java.time.Duration;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;

    private static WebDriverWait wait;

    private static Duration timeout = Duration.ofSeconds(10);

    static {
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver, timeout);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);

    }

    public static void navigateTo(String url) {
        driver.get(url);

    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();

        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void selectFromDropdownAllItems(String locator) {
        WebElement dropdown = driver.findElement(By.xpath(locator));

        List<WebElement> allItems = dropdown.findElements(By.xpath(".//option"));

        for (WebElement item : allItems) {
            System.out.println("element: " + item.getText() + "is palidrom: " + isPalindrome(item.getText()));
        }
    }

    private boolean isPalindrome(String word) {

        StringBuilder textReverse = new StringBuilder();

        textReverse.append(word);

        if (textReverse.reverse().equals(word)) {
            return true;
        }

        return false;
    }

}

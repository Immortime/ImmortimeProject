import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmAccessPage extends BasePageObject{

    public ConfirmAccessPage (WebDriver driver) {
        super(driver);
    }

    private static final String inputPasswordXpath = "//input[contains(@type, 'password')]";

    @FindBy(xpath = inputPasswordXpath)
    WebElement inputPassword;

    @FindBy(xpath = "//button[contains(text(), 'Confirm password')]")
    WebElement buttonConfirmPassword;

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Ввести пароль для подтверждения пользователя")
    public ProductAskForPermissionPage confirmUserPassword(String password) {
        inputPassword.click();
        inputPassword.sendKeys(password);
        buttonConfirmPassword.click();
        return new ProductAskForPermissionPage(driver);
    }

    public ProductAskForPermissionPage confirmUserPasswordIsNeeded(String password) {
        if (isElementPresent(By.xpath(inputPasswordXpath)))
            return confirmUserPassword(password);
        else
            return new ProductAskForPermissionPage(driver);
    }
}

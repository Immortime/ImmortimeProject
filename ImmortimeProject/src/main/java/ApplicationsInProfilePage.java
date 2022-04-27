import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationsInProfilePage extends BasePageObject {

    public ApplicationsInProfilePage(WebDriver driver) {
        super(driver);
    }

    public static final String buttonConfigureXpath = "//a[contains(text(), 'Configure')]";
    private static final String buttonAuthorizedAppsXpath = "//a[contains(text(), 'Authorized GitHub Apps')]";
    private static final String confirmAccessUsernameInputXpath = "//input[contains(@class, 'form-control input-block mt-1')]";
    private static final String buttonDisableAttributeCssSelector = ".btn-danger:disabled";
    private static final String buttonInstalledAppsXpath = "//a[contains(text(), 'Installed GitHub Apps')]";
    public final static String buttonRevokeInAuthorizedAppsXpath = "//summary[contains(text(), 'Revoke all')]";

    @FindBy(xpath = buttonInstalledAppsXpath)
    WebElement buttonInstalledApps;

    @FindBy(xpath = buttonConfigureXpath)
    WebElement buttonConfigure;

    @FindBy(xpath = buttonAuthorizedAppsXpath)
    WebElement buttonAuthorizedApps;

    @FindBy(xpath = buttonRevokeInAuthorizedAppsXpath)
    WebElement buttonRevokeInAuthorizedApps;

    @FindBy(xpath = confirmAccessUsernameInputXpath)
    WebElement confirmAccessUsernameInput;

    @FindBy(xpath = "//button[contains(@data-type, 'application')]")
    WebElement buttonDangerToDelete;

    @Step("Нажать на кнопку Configure")
    public InformationAboutApplicationPage clickOnConfigureButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonConfigureXpath)));
        buttonConfigure.click();
        return new InformationAboutApplicationPage(driver);
    }

    @Step("Сброить авторизацию на приложении")
    public ApplicationsInProfilePage revokeAllApps(String username) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonAuthorizedAppsXpath)));
        buttonAuthorizedApps.click();
        buttonRevokeInAuthorizedApps.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmAccessUsernameInputXpath)));
        confirmAccessUsernameInput.click();
        confirmAccessUsernameInput.sendKeys(username);
        buttonDangerToDelete.click();
        return this;
    }

    @Step("Кликнуть на кнопку Installed Apps")
    public void clickOnIntalledApps() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonInstalledAppsXpath)));
        buttonInstalledApps.click();
    }

}

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InstallImgBotPage extends BasePageObject {

    public InstallImgBotPage (WebDriver driver) {
        super(driver);
    }

    private static final String installationButtonXpath = "//button[contains(@data-octo-click, 'install_integration')]";

    @FindBy(xpath = installationButtonXpath)
    WebElement installationButton;

    @Step("Кликнуть по кнопке установки")
    public ConfirmAccessPage clickOnInstallationButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(installationButtonXpath)));
        installationButton.click();
        return new ConfirmAccessPage(driver);
    }
}

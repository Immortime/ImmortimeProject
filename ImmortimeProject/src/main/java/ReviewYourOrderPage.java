import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReviewYourOrderPage extends BasePageObject {

    public ReviewYourOrderPage(WebDriver driver) {
        super(driver);
    }

    private final static String buttonOrderAndBeginInstallationXpath = "//button[contains(@data-octo-click, 'marketplace-listing_complete_click')]";

    @FindBy(xpath = buttonOrderAndBeginInstallationXpath)
    WebElement buttonOrderAndBeginInstallation;

    @Step ("Кликнуть по кнопке заказа")
    public InstallImgBotPage clickOnButtonOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonOrderAndBeginInstallationXpath)));
        buttonOrderAndBeginInstallation.click();
        return new InstallImgBotPage(driver);
    }
}

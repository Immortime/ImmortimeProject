import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfileSettingsPage extends BasePageObject {

    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }

    private static final String buttonBillingAndPlansXpath = "//ul[contains(@role, 'list')]//a[contains(@href, '/settings/billing')]";
    private static final String buttonApplicationsXpath = "//ul[contains(@role, 'list')]//a[contains(@href, '/settings/installations')]";

    @FindBy (xpath = buttonBillingAndPlansXpath)
    WebElement buttonBillingAndPlans;

    @FindBy (xpath = buttonApplicationsXpath)
    WebElement buttonApplications;

    @Step("Кликнуть на Billing and Plans")
    public BillingAndPlansPage clickOnBillingAndPlans() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonBillingAndPlansXpath)));
        buttonBillingAndPlans.click();
        return new BillingAndPlansPage(driver);
    }

    @Step("Кликнуть на Applications")
    public ApplicationsInProfilePage clickOnApplications() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonApplicationsXpath)));
        buttonApplications.click();
        return new ApplicationsInProfilePage(driver);
    }


}

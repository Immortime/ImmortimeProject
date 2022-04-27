import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MarketplaceImgBotPage extends BasePageObject {

    //We're using ImgBot as example for TestCase

    public MarketplaceImgBotPage(WebDriver driver) {
        super(driver);
    }

    public static final String openSourceButtonXpath = "//a[contains(@href, '/marketplace/imgbot/plan/MLP_kgDNGw8#pricing-and-setup')]";
    private static final String buttonInstallForFreeXpath = "//button[contains(@data-ga-click, 'Marketplace listing, install it for free, marketplace_id:497')]";

    @FindBy(xpath = openSourceButtonXpath)
    WebElement openSourceButton;

    @FindBy(xpath=buttonInstallForFreeXpath)
    WebElement buttonInstallForFree;

    @Step("Взять ImgBot на FreeTrial")
    public ReviewYourOrderPage takeImgBotOnFreeTrial() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openSourceButtonXpath)));
        openSourceButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonInstallForFreeXpath)));
        buttonInstallForFree.click();
        return new ReviewYourOrderPage(driver);
    }
}

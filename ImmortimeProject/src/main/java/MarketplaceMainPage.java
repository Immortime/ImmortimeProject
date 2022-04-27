import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class MarketplaceMainPage extends BasePageObject {

    public MarketplaceMainPage(WebDriver driver) {
        super(driver);
    }

    public static final String appsAndActionsXpath = "//a[contains(@class, 'col-md-6 mb-4 d-flex no-underline')]//h3";

    @FindBy(xpath=appsAndActionsXpath)
    private List<WebElement> appsAndActions;

    @Step("Кликнуть на товар по названию")
    public MarketplaceImgBotPage clickOnAppOrActionByName(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appsAndActionsXpath)));
        appsAndActions.stream().filter(s -> s.getText().contains(name)).findFirst().get().click();
        return new MarketplaceImgBotPage(driver);
    }
}

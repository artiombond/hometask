package com.github.artiombond.cloud_platform.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResults extends AbstractPage {

    @FindBy (xpath = "//b[text() = 'Google Cloud Platform Pricing Calculator']")
    WebElement calculator;

    public GoogleCloudSearchResults(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculatorPage goToCalculatorPage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(calculator)).click();
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

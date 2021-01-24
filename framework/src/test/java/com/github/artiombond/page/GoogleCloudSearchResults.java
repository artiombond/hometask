package com.github.artiombond.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResults extends AbstractPage {

    By calculatorLocator = new By.ByXPath("//b[text() = 'Google Cloud Platform Pricing Calculator']");

    public GoogleCloudSearchResults(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculatorPage goToCalculatorPage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(calculatorLocator)).click();
        logger.info("Open Google Cloud Platform Pricing Calculator");
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

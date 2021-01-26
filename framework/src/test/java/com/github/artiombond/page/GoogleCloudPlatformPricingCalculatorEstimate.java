package com.github.artiombond.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPlatformPricingCalculatorEstimate extends AbstractPage {

    @FindBy (xpath = "//b[contains(.,'Estimated Component Cost:')]")
    WebElement estimatedCostField;
    @FindBy (id = "email_quote")
    WebElement emailEstimateButton;
    @FindBy (xpath = "//input[@type = 'email']")
    WebElement emailInput;
    @FindBy (xpath = "//button[@aria-label = 'Send Email']")
    WebElement sendEmailButton;

    public GoogleCloudPlatformPricingCalculatorEstimate(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculatorEstimate invokeEmailEstimate(){
        ((Locatable) emailEstimateButton).getCoordinates().inViewPort();
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorEstimate sendEmail(String email){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id = 'cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        ((Locatable) emailInput).getCoordinates().inViewPort();
        emailInput.sendKeys(email);
        ((Locatable) sendEmailButton).getCoordinates().inViewPort();
        sendEmailButton.click();
        logger.info("Estimate sent to email");
        return this;
    }

    public String getEstimatedCost(){
        return estimatedCostField.getText()
                .replace("Estimated Component Cost: USD ", "")
                .replace(" per 1 month","");
    }

    public boolean isEstimatedResultsAdded(){
        return estimatedCostField.isDisplayed();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

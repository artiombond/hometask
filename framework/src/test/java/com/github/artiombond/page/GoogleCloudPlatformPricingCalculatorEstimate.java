package com.github.artiombond.page;

import com.github.artiombond.model.ComputeEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorEstimate sendEmail(String email){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id = 'cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        emailInput.sendKeys(email);
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

package com.github.artiombond.cloud_platform.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorEstimate extends AbstractPage {
    @FindBy (xpath = "//md-list-item//div[contains(.,'VM class:')]")
    WebElement machineClassField;
    @FindBy (xpath = "//md-list-item//div[contains(.,'Instance type:')]")
    WebElement machineTypeField;
    @FindBy (xpath = "//md-list-item//div[contains(.,'Total available local SSD space')]")
    WebElement localSSDField;
    @FindBy (xpath = "//md-list-item//div[contains(.,'Region:')]")
    WebElement regionField;
    @FindBy (xpath = "//md-list-item//div[contains(.,'Commitment term:')]")
    WebElement commitmentTermField;
    @FindBy (xpath = "//b[contains(.,'Estimated Component Cost:')]")
    WebElement estimatedCostField;

    public GoogleCloudPlatformPricingCalculatorEstimate(WebDriver driver) {
        super(driver);
    }

    public String getMachineClass(){
        return getFieldValue(machineClassField, "VM class: ");
    }
    public String getMachineType(){
        return getFieldValue(machineTypeField, "Instance type: ");
    }
    public String getLocalSSD(){
        return getFieldValue(localSSDField, "Total available local SSD space ").replace(" GiB", "");
    }
    public String getRegion(){
        return getFieldValue(regionField, "Region: ");
    }
    public String getCommitmentTerm(){
        return getFieldValue(commitmentTermField, "Commitment term: ");
    }
    public String getEstimatedCost(){
        return getFieldValue(estimatedCostField, "Estimated Component Cost: USD ");
    }

    private String getFieldValue(WebElement field, String fieldName){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(field))
                .getText()
                .replace(fieldName, "");
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}

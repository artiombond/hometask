package com.github.artiombond.page;

import com.github.artiombond.model.ComputeEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-tab-item//div[text() = 'Compute Engine']")
    WebElement selectComputeEngine;
    @FindBy (xpath = "//label[contains(.,'Number of instances')]/../input")
    WebElement numberOfInstancesInput;
    @FindBy (xpath = "//md-select[@placeholder = 'Series']")
    WebElement machineSeriesDropDown;
    @FindBy (xpath = "//md-select[@placeholder = 'Instance type']")
    WebElement machineTypeDropDown;
    @FindBy (xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement checkBoxAddGPUs;
    @FindBy (xpath = "//md-select[@placeholder = 'Number of GPUs']")
    WebElement numberOfGPUsDropDown;
    @FindBy (xpath = "//md-select[@placeholder = 'GPU type']")
    WebElement typeOfGPUDropDown;
    @FindBy (xpath = "//md-select[@placeholder = 'Local SSD']")
    WebElement localSSDDropDown;
    @FindBy (xpath = "//md-select[@placeholder = 'Committed usage']")
    WebElement committedUsageDropDown;
    @FindBy (xpath = "//md-select[@placeholder = 'Datacenter location']")
    WebElement datacenterLocationDropDown;
    @FindBy (xpath = "//form[@name='ComputeEngineForm']//button[@aria-label = 'Add to Estimate']")
    WebElement addToEstimateButton;

    private String containerDropDownLocator = "//div[@id = '%s']";
    private String optionDropDownLocator = "//md-option//div[contains(.,'%s')]";
    
    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculatorEstimate fillTheFormAndAddToEstimate(ComputeEngine computeEngine){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id = 'cloud-site']/devsite-iframe/iframe"))).switchTo();
        driver.switchTo().frame("myFrame");

        selectComputeEngine.click();
        numberOfInstancesInput.sendKeys(String.valueOf(computeEngine.getNumberOfInstances()));
        selectFromDropDownByName(machineSeriesDropDown, computeEngine.getMachineSeries());
        selectFromDropDownByName(machineTypeDropDown, computeEngine.getMachineType());
        checkBoxAddGPUs.click();
        selectFromDropDownByName(numberOfGPUsDropDown, String.valueOf(computeEngine.getNumberOfGPUs()));
        selectFromDropDownByName(typeOfGPUDropDown, computeEngine.getGpuType());
        selectFromDropDownByName(localSSDDropDown, computeEngine.getLocalSSD());
        selectFromDropDownByName(datacenterLocationDropDown, computeEngine.getDatacentrLocation());
        selectFromDropDownByName(committedUsageDropDown, computeEngine.getCommittedUsage());
        addToEstimateButton.click();
        logger.info("Form filled and add to estimate");
        return  new GoogleCloudPlatformPricingCalculatorEstimate(driver);
    }

    private void selectFromDropDownByName(WebElement selectDropDown, String selectableElement){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(selectDropDown)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(containerDropDownLocator,selectDropDown.getAttribute("aria-owns"))
                                + String.format(optionDropDownLocator,selectableElement)))).click();
    }

    @Override
    public GoogleCloudPlatformPricingCalculatorPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}

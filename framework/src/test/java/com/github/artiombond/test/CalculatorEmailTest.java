package com.github.artiombond.test;

import com.github.artiombond.service.ComputeEngineCreator;
import com.github.artiombond.model.ComputeEngine;
import com.github.artiombond.page.GoogleCloudMainPage;
import com.github.artiombond.page.GoogleCloudPlatformPricingCalculatorEstimate;
import com.github.artiombond.page.TenMinuteMailPaige;
import com.github.artiombond.util.TabSwitch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorEmailTest extends CommonConditions{
    private GoogleCloudPlatformPricingCalculatorEstimate calculatorEstimate;
    private TenMinuteMailPaige tenMinuteMailPaige;

    @Test
    public void sendEstimateToEmail(){
        ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngineWithCredentials();
        calculatorEstimate = new GoogleCloudMainPage(driver)
                .openPage()
                .searchForGoogleCloudPlatformCalculator()
                .goToCalculatorPage()
                .fillTheFormAndAddToEstimate(computeEngine)
                .invokeEmailEstimate();
        TabSwitch.createNewTab(driver);
        tenMinuteMailPaige = new TenMinuteMailPaige(driver)
                .openPage();
        String email = tenMinuteMailPaige .getEmailAddress();
        TabSwitch.switchTab(driver, 1);
        calculatorEstimate.sendEmail(email);
        String costFromCalculatorPage = calculatorEstimate.getEstimatedCost();
        TabSwitch.switchTab(driver,2);
        String costFromMessage = tenMinuteMailPaige.getCostFromMessage();
        Assert.assertEquals(costFromCalculatorPage, costFromMessage);
    }
}

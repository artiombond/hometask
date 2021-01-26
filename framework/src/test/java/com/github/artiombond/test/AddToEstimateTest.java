package com.github.artiombond.test;


import com.github.artiombond.model.ComputeEngine;
import com.github.artiombond.page.GoogleCloudPlatformPricingCalculatorPage;
import com.github.artiombond.service.ComputeEngineCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToEstimateTest extends CommonConditions{

    @Test
    public void canAddToEstimate(){
        ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngineWithCredentials();
        boolean isEstimatedResultsAdded = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .openPage()
                .fillTheFormAndAddToEstimate(computeEngine)
                .isEstimatedResultsAdded();
        Assert.assertTrue(isEstimatedResultsAdded);
    }

}

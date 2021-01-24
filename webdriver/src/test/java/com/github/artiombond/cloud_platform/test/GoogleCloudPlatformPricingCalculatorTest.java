package com.github.artiombond.cloud_platform.test;

import com.github.artiombond.cloud_platform.model.ComputeEngine;
import com.github.artiombond.cloud_platform.page.GoogleCloudMainPage;
import com.github.artiombond.cloud_platform.page.GoogleCloudPlatformPricingCalculatorEstimate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleCloudPlatformPricingCalculatorTest {
    private WebDriver driver;
    private GoogleCloudPlatformPricingCalculatorEstimate estimatedForm;
    private ComputeEngine computeEngine;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        computeEngine = new ComputeEngine(4,
                "regular",
                "N1",
                "n1-standard-8",
                1,
                "NVIDIA Tesla V100",
                "2x375",
                "Frankfurt",
                "1 Year");
        estimatedForm = new GoogleCloudMainPage(driver).openPage()
                .searchForGoogleCloudPlatformCalculator()
                .goToCalculatorPage()
                .fillTheFormAndAddToEstimate(computeEngine);
    }

    @Test
    public void vmClassInEstimateMatchesSelected (){
        String machineClass = estimatedForm.getMachineClass();
        String expectedMachineClass = computeEngine.getMachineClass();
        Assert.assertEquals(machineClass,expectedMachineClass);

    }

    @Test
    public void instanceTypeInEstimateMatchesSelected (){
        String machineType = estimatedForm.getMachineType();
        String expectedMachineType = computeEngine.getMachineType();
        Assert.assertEquals(machineType,expectedMachineType);
    }

    @Test
    public void regionInEstimateMatchesSelected (){
        String region = estimatedForm.getRegion();
        String expectedRegion = computeEngine.getDatacentrLocation();
        Assert.assertEquals(region,expectedRegion);
    }

    @Test
    public void localSSDInEstimateMatchesSelected (){
        String localSSD = estimatedForm.getLocalSSD();
        String expectedLocalSSD = computeEngine.getLocalSSD();
        Assert.assertEquals(localSSD,expectedLocalSSD);
    }

    @Test
    public void commitmentTermInEstimateMatchesSelected (){
        String commitmentTerm = estimatedForm.getCommitmentTerm();
        String expectedCommitmentTerm = computeEngine.getCommitmentTerm();
        Assert.assertEquals(commitmentTerm,expectedCommitmentTerm);
    }

    @Test
    public void estimatedCostMatchesHandResult (){
        String estimatedCost = estimatedForm.getEstimatedCost();
        Assert.assertEquals(estimatedCost,"1,082.77 per 1 month");
    }


    @AfterClass()
    public void stopBrowser() {
        driver.quit();
    }
}

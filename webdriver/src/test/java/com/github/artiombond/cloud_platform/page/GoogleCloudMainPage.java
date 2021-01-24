package com.github.artiombond.cloud_platform.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@aria-label = 'Search']")
    WebElement searchButton;

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudSearchResults searchForGoogleCloudPlatformCalculator(){
        searchButton.click();
        searchButton.sendKeys("Google Cloud Platform Pricing Calculator");
        searchButton.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchResults(driver);
    }


}

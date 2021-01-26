package com.github.artiombond.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPaige extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";

    @FindBy (id = "mail_address")
    WebElement emailAddress;
    @FindBy (xpath = "//h2[contains(.,'Estimated Monthly Cost:')]")
    WebElement costInMessage;

    By messageLocator = new By.ByXPath("//div[@class = 'message_top']");

    public TenMinuteMailPaige(WebDriver driver) {
        super(driver);
    }

    public String getEmailAddress(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.attributeToBeNotEmpty(emailAddress, "value"));
        return emailAddress.getAttribute("value");
    }

    public String getCostFromMessage(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(messageLocator)).click();
        return costInMessage.getText().replace("Estimated Monthly Cost: USD ","");
    }
    @Override
    public TenMinuteMailPaige openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("TenMinuteMail opened");
        return this;
    }
}

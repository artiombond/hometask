package com.github.artiombond.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinMainPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement inputCode;

    @FindBy (id = "postform-name")
    private WebElement inputTitle;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement selectExpiration;

    @FindBy (xpath = "//button[@type = 'submit']")
    private WebElement createNewPasteButton;

    @FindBy (id = "select2-postform-format-container")
    private WebElement selectSyntaxHighlighting;


    public PastebinMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinBinPage createNewPaste(String code, String title){
        inputCode.sendKeys(code);
        selectExpiration.click();
        driver.findElement(By.xpath("//li[text() = '10 Minutes']")).click();
        selectSyntaxHighlighting.click();
        driver.findElement(By.xpath("//li[text() = 'Bash']")).click();
        inputTitle.sendKeys(title);
        createNewPasteButton.click();
        return new PastebinBinPage(driver);
    }
}

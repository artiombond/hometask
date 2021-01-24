package com.github.artiombond.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PastebinBinPage extends AbstractPage {

    @FindBy (xpath = "//div[@class = 'info-top']/h1")
    WebElement pageHeader;

    @FindBy (xpath = "//textarea[@class = 'textarea']")
    WebElement binText;

    String codeLocator = "//span[text() = '%s']";


    public PastebinBinPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTtle(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(pageHeader)).getText();
    }

    public String getCode(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(binText)).getText();
    }

    public boolean isSyntaxHighlighted(String binCode){
        return isElementOfCodeHighlighted(binCode, "(?<=\\s)-{1,2}[^\\s]+", "rgba(102, 0, 51, 1)")
                && isElementOfCodeHighlighted(binCode, "git\\s[^\\s]+", "rgba(194, 12, 185, 1)")
                && isElementOfCodeHighlighted(binCode, "\"[^\\\"]*\"", "rgba(255, 0, 0, 1)");
    }

    private boolean isElementOfCodeHighlighted(String binCode, String regex, String expectedColor){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(binCode);
        while (matcher.find()) {
            String color = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(codeLocator,binCode.substring(matcher.start(), matcher.end())))))
                    .getCssValue("color");
            if (!color.equals(expectedColor)){
                return false;
            }
        }
        return true;
    }

    @Override
    public PastebinBinPage openPage() {
        return null;
    }
}

package com.github.artiombond.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabSwitch {

    public TabSwitch(WebDriver driver) { }

    public static void createNewTab(WebDriver driver){
        int countOfTabs = driver.getWindowHandles().size();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(countOfTabs));
    }
    public static void switchTab(WebDriver driver, int tabIndex){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        if (tabs.size() >= tabIndex){
            driver.switchTo().window(tabs.get(tabIndex - 1));
        }
    }
}


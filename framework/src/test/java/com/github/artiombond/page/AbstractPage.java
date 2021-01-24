package com.github.artiombond.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected final Logger logger = LogManager.getRootLogger();

    protected abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
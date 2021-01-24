package com.github.artiombond.pastebin.test;
import com.github.artiombond.pastebin.page.PastebinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPastebinTest {
    private WebDriver driver;

    private String binTitle = "how to gain dominance among developers";
    private String binCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void binCodeMatchesPasteCode(){
        String createdCode = new PastebinMainPage(driver)
                .openPage()
                .createNewPaste(binCode, binTitle)
                .getCode();
        Assert.assertEquals(binCode,createdCode);
    }

    @Test
    public void pageTitleMatchesPasteTitle() {
        String createdTitle = new PastebinMainPage(driver)
                .openPage()
                .createNewPaste(binCode, binTitle)
                .getPageTtle();
        Assert.assertEquals(binTitle, createdTitle);
    }

    @Test
    public void codeIsHighlighted() {
        boolean isSyntaxHighlighted = new PastebinMainPage(driver)
                .openPage()
                .createNewPaste(binCode, binTitle)
                .isSyntaxHighlighted(binCode);
        Assert.assertTrue(isSyntaxHighlighted);
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}

package test;

import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static test.Locators.*;

@Epic("Test task for Emotorwerks")
@Feature("Search keyword in google, check footer at the main page")
public class Main_Emotorwerks_Test {


    WebDriver driver;
    Locators page = new Locators(driver);
    String browser = "chrome";

    @BeforeClass
     public void setup() {
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.out.println("chrome");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("firefox");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.out.println("IE");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().setScriptTimeout(30, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
    }
    @Test(priority =0, description = "Search keyword")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test case description : Searching a keyword in google")
    @Story("Story name: To check google search)")
    public void openGoogleAndSearch()
    {
        driver.get(page.googleUrl);
        driver.findElement(googleSearchField).sendKeys("emotorwerks.com");
        driver.findElement(googleSearchField).sendKeys(Keys.RETURN);
    }
    @Test(priority =1, description = "search links at h the google page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Searching in the search result for a specific links")
    @Story("Story name: To check search results")
    public void searchKeyword()
    {
        Assert.assertEquals(true, driver.findElement(emotorwerkOfficial).isDisplayed());
        Assert.assertEquals(true, driver.findElement(emotorwerksWiki).isDisplayed());
    }
    @Test(priority =2, description = "check footer elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Check if the footer links are displayed")
    @Story("Story name: To check footer links")
    public void emotorwerksCheckFooter()
    {
        driver.findElement(emotorwerkOfficial).click();
        Assert.assertEquals(true, driver.findElement(footerReturnandRefund).isDisplayed());
        Assert.assertEquals(true, driver.findElement(footerCookiePolicy).isDisplayed());
        Assert.assertEquals(true, driver.findElement(footerPrivacy).isDisplayed());
        Assert.assertEquals(true, driver.findElement(footerSitemap).isDisplayed());
        driver.findElement(cookieMessageClose).click();
    }
    @Test(priority =3 )
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Check the 'refund policy' footer's link ")
    @Story("Story name: To check footer links")
    public void emotorwerkCheckRedirects_ReturnAndRefund()
    {
        driver.findElement(footerReturnandRefund).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://evcharging.enelx.com/return-and-refund-policy" );
    }
    @Test(priority =4 )
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Check the 'cookie policy' footer's link")
    @Story("Story name: To check footer links")
    public void emotorwerkCheckRedirects_CookiePolicy()
    {
        driver.get(emotorwerkOfficialUrl);
        driver.findElement(footerCookiePolicy).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://evcharging.enelx.com/cookie-policy" );
    }
    @Test(priority =5 )
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Check the 'privacy policy' footer's link")
    @Story("Story name: To check footer links")
    public void emotorwerkCheckRedirects_Privacy()
    {
        driver.get(emotorwerkOfficialUrl);
        driver.findElement(footerPrivacy).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://evcharging.enelx.com/privacy-policy" );
    }
    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description : Check the 'sitemap' footer's link")
    @Story("Story name: To check footer links")
    public void emotorwerkCheckRedirects_Sitemap()
    {
        driver.get(emotorwerkOfficialUrl);
        driver.findElement(footerSitemap).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://evcharging.enelx.com/sitemap" );
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

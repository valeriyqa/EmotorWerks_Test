package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

    WebDriver driver;
    public static String googleUrl = "https://www.google.com";
    public static String emotorwerkOfficialUrl = "https://emotorwerks.com/";
    public static By googleSearchField = By.name("q");
    public static By googleSearchButton = By.name("btnK");
    public static By emotorwerkOfficial = By.xpath("//a[@href='https://www.emotorwerks.com/']");
    public static By emotorwerksWiki = By.xpath("//a[@href='https://en.wikipedia.org/wiki/EMotorWerks']");
    public static By cookieMessageClose = By.id("pwebbox204_toggler");
    //#region footer emotorwerkOfficial locators
    public static By footerReturnandRefund = By.xpath("//a[@href ='/return-and-refund-policy']");
    public static By footerPrivacy = By.xpath("//a[@href = '/privacy-policy']");
    public static By footerCookiePolicy = By.xpath("//a[@class='b-footer-bottom-menu__link ' and @href = '/cookie-policy']");
    public static By footerSitemap = By.xpath("//a[@href = '/sitemap']");
    //endregion
    public Locators(WebDriver driver)
    {
        this.driver = driver;
    }

}

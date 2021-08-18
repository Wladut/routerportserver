package com.vrinceanuvladut.routerportserver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RouterConnection implements IRouterConnection {

    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;
    private final int WAIT_TIME = 10;

    public RouterConnection(String webDriverPath){
        System.setProperty("webdriver.chrome.driver", webDriverPath);      
        ChromeOptions chromeOptions = new ChromeOptions();      
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        this.chromeDriver = new ChromeDriver(); 
        webDriverWait = new WebDriverWait(chromeDriver, WAIT_TIME); 
    }

    @Override
    public boolean loginPage(String loginPage, String name, String password) {
        Boolean result = true;
        chromeDriver.get(loginPage);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("details-button"))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link"))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("name"))).sendKeys(name);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("button-blue"))).click();
        return result;
    }

    @Override
    public boolean openAccessControlPage() {
        Boolean result = true;
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[ui-sref='user.accessControl']"))).click();
        return result;
    }

    @Override
    public boolean openPortForwardingPage() {
        Boolean result = true;
        webDriverWait.until(ExpectedConditions
        .elementToBeClickable(By.cssSelector("a[ui-sref='user.accessControl.portForwarding']"))).click();
        return result;
    }

    @Override
    public boolean portForwardingStatus(boolean activationStatus) {
        Boolean result = true;
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@for='port-00']"))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@ng-click='apply()']"))).click();
        return result;
    }

    @Override
    public boolean logout(){
        Boolean result = true;
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@ng-click='logout()']"))).click();
        return result;
    }

    @Override
    public boolean close(){
        Boolean result = true;
        chromeDriver.close();
        return result;
    }
}


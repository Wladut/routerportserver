package com.vrinceanuvladut.routerportserver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RouterConnection implements IRouterConnection {

    private WebDriver chromeDriver;

    public RouterConnection(String webDriverPath){
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        this.chromeDriver = new ChromeDriver();  
    }

    @Override
    public boolean loginPage(String loginPage, String name, String password) {
        Boolean result = true;
        chromeDriver.get(loginPage);
        WebElement advanceButton = chromeDriver.findElement(By.id("details-button"));
        advanceButton.click();
        WebElement proceedLink = chromeDriver.findElement(By.id("proceed-link"));
        proceedLink.click();
        wait(5);
        WebElement username = chromeDriver.findElement(By.id("name"));
        WebElement pword = chromeDriver.findElement(By.id("password"));
        WebElement loginButton = chromeDriver.findElement(By.id("button-blue"));
        username.sendKeys(name);
        pword.sendKeys(password);
        loginButton.click();
        wait(25);
        return result;
    }

    @Override
    public boolean openAccessControlPage() {
        Boolean result = true;
        WebElement accessControl = chromeDriver.findElement(By.cssSelector("a[ui-sref='user.accessControl']"));
        accessControl.click();
        wait(5);
        return result;
    }

    @Override
    public boolean openPortForwardingPage() {
        Boolean result = true;
        WebElement portForwardingTabButton = chromeDriver.findElement(By.cssSelector("a[ui-sref='user.accessControl.portForwarding']"));
        portForwardingTabButton.click();
        wait(5);
        return result;
    }

    @Override
    public boolean portForwardingStatus(boolean activationStatus) {
        Boolean result = true;
        WebElement togglePortForwardButton = chromeDriver.findElement(By.xpath(".//*[@for='port-00']"));
        togglePortForwardButton.click();
        WebElement applyButton = chromeDriver.findElement(By.xpath("//*[@ng-click='apply()']"));
        applyButton.click();
        wait(5);
        return result;
    }

    @Override
    public boolean logout(){
        Boolean result = true;
        WebElement applyButton = chromeDriver.findElement(By.xpath("//*[@ng-click='logout()']"));
        applyButton.click();
        return result;
    }

    @Override
    public boolean close(){
        Boolean result = true;
        wait(3);
        chromeDriver.close();
        return result;
    }

    private void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


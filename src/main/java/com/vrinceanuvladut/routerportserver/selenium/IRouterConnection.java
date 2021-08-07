package com.vrinceanuvladut.routerportserver.selenium;

public interface IRouterConnection {

    boolean loginPage(String loginPage, String name, String password);
    boolean openAccessControlPage();
    boolean openPortForwardingPage();
    boolean portForwardingStatus(boolean activationStatus);
    boolean logout();
    boolean close();
}

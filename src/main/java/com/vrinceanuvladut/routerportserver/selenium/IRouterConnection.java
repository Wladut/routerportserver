package com.vrinceanuvladut.routerportserver.selenium;

public interface IRouterConnection {

    boolean loginPage(String name, String password);
    boolean openAccessControlPage();
    boolean openPortForwardingPage();
    boolean portForwardingStatus(boolean activationStatus);

}

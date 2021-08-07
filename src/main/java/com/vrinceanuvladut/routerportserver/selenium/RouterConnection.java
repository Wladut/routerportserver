package com.vrinceanuvladut.routerportserver.selenium;

public class RouterConnection implements IRouterConnection {

    private String webDriverPath;

    public RouterConnection(String webDriverPath){
        this.webDriverPath = webDriverPath;
    }

    @Override
    public boolean loginPage(String name, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean openAccessControlPage() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean openPortForwardingPage() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean portForwardingStatus(boolean activationStatus) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

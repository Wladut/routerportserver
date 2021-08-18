package com.vrinceanuvladut.routerportserver.selenium;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestRouterConnection {

    @Test
    void loginPageTestPositiveCase(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ip address (eg. https://192.168.1.1): ");
        String ip = scanner.nextLine();
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        RouterConnection routerConnection = new RouterConnection("D:/sleniumdriver/chromedriver_win32/chromedriver.exe");
        routerConnection.loginPage(ip,username, password);
        routerConnection.openAccessControlPage();
        routerConnection.openPortForwardingPage();
        routerConnection.portForwardingStatus(true);
        routerConnection.logout();
        routerConnection.close();
    }
    
}

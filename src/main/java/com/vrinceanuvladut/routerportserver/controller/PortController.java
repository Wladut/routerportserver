package com.vrinceanuvladut.routerportserver.controller;

import com.vrinceanuvladut.routerportserver.selenium.RouterConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {   

    private boolean portActivationStatus = false;

    @RequestMapping("/activateport")
    public String activatePort(@RequestParam(required = true) String ip
    , @RequestParam(required = true) String username, @RequestParam(required = true) String password){
        
        StringBuilder errorResponse = new StringBuilder();
        if(ip.isEmpty()){
             errorResponse.append("Please enter ip in http request.");
        }
        if(username.isEmpty()){
            errorResponse.append("\nPlease enter username in http request.");
        }
        if(password.isEmpty()){
            errorResponse.append("\nPlease enter password in http request.");
        }
        if(errorResponse.length() != 0){
            return errorResponse.toString();
        }

        if(portActivationStatus == false){
            Thread portActivationThread = new Thread(() -> {
                RouterConnection routerConnection = new RouterConnection("D:/sleniumdriver/chromedriver_win32/chromedriver.exe");
                routerConnection.loginPage(ip, username, password);
                routerConnection.openAccessControlPage();
                routerConnection.openPortForwardingPage();
                routerConnection.portForwardingStatus(true);
                routerConnection.logout();
                routerConnection.close();
            });
            
            portActivationThread.start();
    
            //wait for threads to end
            try {
                portActivationThread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.portActivationStatus = true;
    
            return "Port activated.";
        }

        return "Port is already activated. To deactivate, please use /deactivateport.";

    }

    @RequestMapping("/deactivateport")
    public String deactivatePort(@RequestParam(required = true) String ip
    , @RequestParam(required = true) String username, @RequestParam(required = true) String password){

        StringBuilder errorResponse = new StringBuilder();
        if(ip.isEmpty()){
             errorResponse.append("Please enter ip in http request.");
        }
        if(username.isEmpty()){
            errorResponse.append("\nPlease enter username in http request.");
        }
        if(password.isEmpty()){
            errorResponse.append("\nPlease enter password in http request.");
        }
        if(errorResponse.length() != 0){
            return errorResponse.toString();
        }

        if(portActivationStatus == true){
            Thread portActivationThread = new Thread(() -> {
                RouterConnection routerConnection = new RouterConnection("D:/sleniumdriver/chromedriver_win32/chromedriver.exe");
                routerConnection.loginPage(ip, username, password);
                routerConnection.openAccessControlPage();
                routerConnection.openPortForwardingPage();
                routerConnection.portForwardingStatus(true);
                routerConnection.logout();
                routerConnection.close();
            });
            
            portActivationThread.start();
    
            //wait for threads to end
            try {
                portActivationThread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.portActivationStatus = false;
    
            return "Port deactivated.";
        }

        return "Port is already deactivated. To activate, please use /activateport.";

    }
}

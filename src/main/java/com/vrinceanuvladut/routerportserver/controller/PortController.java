package com.vrinceanuvladut.routerportserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {   

    @RequestMapping("/activateport")
    public String activatePort(@RequestParam(required = true) String port){
        if(port.isEmpty()){
            return "Please set parameter port number.";
        }
        return "Port " + port + " activated.";
    }

    @RequestMapping("/deactivateport")
    public String deactivatePort(@RequestParam(required = true) String port){
        return "Port " + port + " deactivated.";
    }
}

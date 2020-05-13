package com.l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("registerPage")
    public String registerPage(){
        return "registerPage";
    }

    @RequestMapping("main")
    public String main() {
        return "main";
    }

    @RequestMapping("warning")
    public String warning() {
        return "warning";
    }

    @RequestMapping("device")
    public String device() {
        return "device";
    }

    @RequestMapping("addDevicePage")
    public String addDevicePage() {
        return "addDevicePage";
    }

    @RequestMapping("userInfo")
    public String userInfo() {
        return "userInfoPage";
    }

    @RequestMapping("modelPage")
    public String modelPage() {
        return "modelPage";
    }

}

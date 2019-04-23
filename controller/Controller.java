package com.itheima.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cy452
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "nihao";
    }
}

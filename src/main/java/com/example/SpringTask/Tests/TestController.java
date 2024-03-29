package com.example.SpringTask.Tests;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("message", "This is a message from the controller!");
        return modelAndView;
    }
}

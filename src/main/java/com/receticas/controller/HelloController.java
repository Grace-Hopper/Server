package com.receticas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * =====================================================================================
 * Filename: BaseController.java
 * Version: 1.0
 * Created: 3/9/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
@Controller
@RequestMapping("/welcome")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        String message = "This is the hello world";
        return new ModelAndView("hello", "message", message);
    }
}

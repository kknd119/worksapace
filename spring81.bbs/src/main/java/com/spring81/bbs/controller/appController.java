package com.spring81.bbs.controller;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class appController extends JFrame {
	
    private static final Logger logger = LoggerFactory.getLogger(homeController.class);
    
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public static String app(Model model) {
        logger.info("app:get");
                        
        return "h0";
   
    }
	@RequestMapping(value = "/appr", method = RequestMethod.POST)
    public static String main(Model model
            ,@RequestParam(defaultValue="10") int no  ) {
        logger.info("index:post");
        
        int result = factorial(no);
        System.out.println(result);
        model.addAttribute("result",result);
       
        
        return "h1";
   
	}
	static int factorial(int n) {
        int result = 0;
        
        if(n==1)
            result = 1;
        else
            result = n*factorial(n-1);
        
        return result ;
    }
	@RequestMapping(value = "/appr2", method = RequestMethod.POST)
    public static String appr2(Model model
            
            ,@RequestParam String aa) {
        logger.info("appr2:get");
        
       
        System.out.println(aa);
       
        model.addAttribute("result2",aa);
        
        return "h1";
   
    }
	
}
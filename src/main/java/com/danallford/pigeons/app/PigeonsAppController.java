package com.danallford.pigeons.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PigeonsAppController {

//    @Autowired
//    MessageProducer messageProducer;

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping("/submitlogin")
    public ModelAndView submitLogin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("memberhome");
        return mav;
    }

    @RequestMapping("/memberhome")
    public ModelAndView memberHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("memberhome");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


//    @PostMapping("/notify")
//    public String sendNotificationPost(@RequestBody String message) {
//        System.out.println("sendNotificationPost - sending message : " + message);
//        messageProducer.send(message);
//        System.out.println("sendNotificationPost - sent message : " + message);
//        return "'" + message + "' has been sent.";
//    }
//
//    @GetMapping("/notify")
//    public String sendNotificationGet(@RequestParam(name = "message") String message) {
//        System.out.println("sendNotificationGet - sending message : " + message);
//        messageProducer.send(message);
//        System.out.println("sendNotificationGet - sent message : " + message);
//        return "'" + message + "' has been sent.";
//    }


    @RequestMapping("/*")
    public ModelAndView homeDefault() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}

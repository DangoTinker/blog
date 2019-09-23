package com.tianmaying.controller;


import com.tianmaying.TblogApplication;
import com.tianmaying.model.User;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@SpringBootApplication


public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(User user, @RequestParam("next") Optional<String> next, HttpSession session){
        User temp=userService.login(user.getEmail(), user.getPassword());

//        if(temp!=null){
        session.setAttribute("CURRENT_USER",temp);
//        }



//        if(next!=null){
//            return "redirect:"+next;
//        }

//        redirectAttributes.addAttribute("message","success");
        return "redirect:".concat(next.orElse("/"+temp.getName()));
//        return "redirect:/admin";
    }


}

package com.tianmaying.controller;






import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class AdminController {
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    @RequestMapping(value="/admin",method = RequestMethod.GET)
//    @GetMapping
    public String get(@PageableDefault(size=15,sort = {"id"},direction = Sort.Direction.DESC)Pageable pageable,
                      Model model,
                      HttpSession session){
        model.addAttribute("blogs",blogService.findBlogs((User) session.getAttribute("CURRENT_USER"),pageable));

        if(!model.containsAttribute("message")){
           model.addAttribute("message",null);
        }
        else{
            model.addAttribute("message","success");
        }
        if(!model.containsAttribute("Flash")){
            model.addAttribute("Flash","success");
        }
//
//        model.addAttribute("message","success");
//

        return "admin";
    }





}

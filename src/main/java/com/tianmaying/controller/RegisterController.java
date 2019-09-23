package com.tianmaying.controller;


import com.tianmaying.form.UserRegisterForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;


    @GetMapping
    public String register(){
        return "register";
    }
    @PostMapping
    public String doRegister(@ModelAttribute("user") @Valid UserRegisterForm userRegisterForm, BindingResult result, final RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "register";
        }

        redirectAttributes.addFlashAttribute("message","success");
        User user=userRegisterForm.toUser();
        userService.register(user);

        blogService.createBlog(new Blog("1","1",user));
//        return "redirect:/"+user.getName();
        return "redirect:/admin";
    }


}

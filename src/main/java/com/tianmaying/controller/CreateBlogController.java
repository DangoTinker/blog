package com.tianmaying.controller;


import com.tianmaying.form.BlogCreateForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class CreateBlogController {
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;

    @RequestMapping(value="/blogs/create",method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute(new Blog());
//        model.addAttribute("methodPost",true);
        return "create";
    }

//    @RequestMapping("/blogs/null")
//    @ResponseBody
//    public String asd(){
//        return "asd";
//    }
//
//    @RequestMapping("/blogs/{id}")
//    @ResponseBody
//    public String asdd(@PathVariable("id") long id){
//        return "asd";
//    }



    @RequestMapping(value = "/blogs",method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("blog") @Valid BlogCreateForm blogCreateForm,
                           BindingResult bindingResult,
                           HttpSession session,
                            Model model){
//        blogService.cr

        if(bindingResult.hasErrors()){

            model.addAttribute(new Blog());
//            model.addAttribute("methodPost",true);
            return "create";
        }


        Blog blog=blogCreateForm.toBlog((User)session.getAttribute("CURRENT_USER"));

        Blog temp=blogService.createBlog(blog);//??????????

        return "redirect:/blogs/"+temp.getId();
    }


}

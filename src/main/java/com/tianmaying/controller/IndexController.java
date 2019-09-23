package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blog;
    @Autowired
    private UserService user;


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/{username:[a-z0-9_]+}")

    public String t(@PathVariable("username") String username, Model model,
                    @PageableDefault(size=15,sort={"id"},direction = Sort.Direction.DESC)Pageable pageable){

        model.addAttribute("blogs",(blog.findBlogs(user.findByName(username),pageable)));
        model.addAttribute("user",user.findByName(username));
        return "list";

    }


}

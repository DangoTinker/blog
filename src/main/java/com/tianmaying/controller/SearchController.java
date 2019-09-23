package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class SearchController {
    @Autowired
    private BlogService blog;

    @RequestMapping(value="/search",method= RequestMethod.GET)
    @ResponseBody
    public List<Blog> search(String key){
        return blog.findBlogsByKey(key);
    }


}

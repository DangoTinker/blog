package com.tianmaying.controller;



import com.tianmaying.form.BlogCreateForm;
import com.tianmaying.model.Blog;
import com.tianmaying.model.Comment;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class BlogController {

    @Autowired
    private BlogService blog;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/blogs/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable("id") long id, Model model){
        Blog temp=blog.findBlog(id);
        model.addAttribute("blog",temp);
        model.addAttribute("comments",commentService.getCommentOfBlog(temp));

        return "item";
    }


    @RequestMapping(value="/blogs/{id}",method =RequestMethod.PUT)
    public String updateDo(@ModelAttribute("blog") @Valid BlogCreateForm blogCreateForm,
                           @PathVariable("id") long id,
                            Model model,
                           BindingResult bindingResult,
                            HttpSession session){
//        blog.updateBlog(blog.findBlog(id));



        if(bindingResult.hasErrors()){
            model.addAttribute("blog",blog.findBlog(id));
//            model.addAttribute("methodPut",true);
            return "create";
        }


        Blog b=blogCreateForm.toBlog(blog.findBlog(id).getAuthor());

//        Blog b=blogCreateForm.toBlog((User)session.getAttribute("CURRENT_USER"));

        Blog newBlog=blog.updateBlog(b);
        return "redirect:/blogs/"+newBlog.getId();
    }


    @RequestMapping(value = "/blogs/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id,Model model,
                         final RedirectAttributes redirectAttributes){

        blog.deleteBlog(blog.findBlog(id));
        redirectAttributes.addFlashAttribute("Flash","success");
        return "redirect:/admin";

    }

    @RequestMapping(value="/blogs/{id}/edit",method = RequestMethod.GET)
    public String update(@PathVariable("id") long id,Model model){
        model.addAttribute("blog",blog.findBlog(id));
        model.addAttribute("put","success");
        return "create";
    }





    @RequestMapping(value="/blogs/{id}/comments",method = RequestMethod.POST)
    public String createCommnent(@PathVariable Long id, Comment comment, HttpSession session){
        commentService.createComment(comment);
        comment.setBlog(blog.findBlog(id));
        comment.setCommentor((User)session.getAttribute("CURRENT_USER"));



        Date now = new Date();



        comment.setCreatedTime(now);
        return "redirect:/blogs/"+id.toString();
    }

}

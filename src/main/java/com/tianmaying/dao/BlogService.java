package com.tianmaying.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    BlogRepository br;

    public Blog findById(long id){
        return br.findById(id);
    }
    public Blog findByAuthor(long authorId){
        return br.findByAuthor(authorId);
    }
    public void createBlog(Blog blog){
        br.save(blog);
    }
    public void updateBlog(Blog blog){
        br.save(blog);
    }
    public void deleteBlog(Blog blog){
        br.delete(blog);
    }
    public void deleteBlog(long id){
        br.delete(id);
    }
}

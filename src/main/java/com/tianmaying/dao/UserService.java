package com.tianmaying.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public User findById(long id){
        return ur.findById(id);
    }
    public void register(User user){
        ur.save(user);
    }
    public User login(String email,String password){
        return ur.findByEmailAndPassword(email,password);
    }


}

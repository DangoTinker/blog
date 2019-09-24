package com.tianmaying.dao;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(long id);
    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String eamil);
    public User findByUsername(String username);

}

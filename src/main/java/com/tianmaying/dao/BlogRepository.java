package com.tianmaying.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {

    public Blog findById(long id);
    public Blog findByAuthor(long authorId);




}

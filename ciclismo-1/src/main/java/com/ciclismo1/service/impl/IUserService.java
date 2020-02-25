package com.ciclismo1.service.impl;

import java.util.List;

import com.ciclismo1.entity.User;

public interface IUserService
{
    public List<User> findAll();

    public void saveUser(User book);

   
    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

}
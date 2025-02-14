package com.mamba.main.services;

import com.mamba.main.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    public User insertdata(User user);//Insert data

    List<User> getdata(User user);//Get data

    public Optional<User> getdetailsbyid(Long UID);//Get data By id

    public User updatedetails(Long UID,User user);//Update data
    void deleteUser(Long UID);
}

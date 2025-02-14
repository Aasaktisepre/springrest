package com.mamba.main.services;

import com.mamba.main.entity.User;
import com.mamba.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    public UserRepository userRepository;

    @Override
    public User insertdata(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getdata(User user) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getdetailsbyid(Long UID) {

        return userRepository.findById(UID);
    }

    @Override
    public User updatedetails(Long UID, User newuser) {

        User userdata= userRepository.findById(UID).orElse(null);

        if(userdata != null)
        {
            return userRepository.save(newuser);
        }
        else
        {
            throw new RuntimeException("user not found do it again " +UID);
        }


    }

    @Override
    public void deleteUser(Long UID) {
        if (!userRepository.existsById(UID)) {
            System.out.println("user not found do it again " +UID);
        }
        userRepository.deleteById(UID);
    }


}

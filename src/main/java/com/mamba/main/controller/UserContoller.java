package com.mamba.main.controller;

import com.mamba.main.entity.User;
import com.mamba.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserContoller
{
    @Autowired
    public UserService userservice;


    @PostMapping("/user")
    public User showuserdetails(@RequestBody User user)
    {
        return userservice.insertdata(user) ;
    }
    @GetMapping("/user")
    public List<User> givemeuserdet(@RequestBody User user)
    {
        return userservice.getdata(user);

    }
    @GetMapping("/user/{UID}")
    public ResponseEntity<User> findingbyid(@PathVariable Long UID)
    {
        User user = userservice.getdetailsbyid(UID).orElse(null);

        if(user != null)
        {
            return ResponseEntity.ok().body(user);

        }
        else
        {
            return ResponseEntity.notFound().build();
        }


    }

    @PutMapping("/user/{UID}")
    public ResponseEntity<User> updateDetails (@PathVariable Long UID,@RequestBody User user)
    {
        User updateduser=userservice.updatedetails(UID, user);
        if(updateduser != null)
        {
            return ResponseEntity.ok(updateduser);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{UID}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long UID) {
        userservice.deleteUser(UID);

        // Creating a response JSON
        Map<String, String> response = new HashMap<>();
        response.put("message", "User  is deleted bro  successfully.");

        return ResponseEntity.ok(response);
    }


}

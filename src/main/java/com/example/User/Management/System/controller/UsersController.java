package com.example.User.Management.System.controller;

import com.example.User.Management.System.model.Users;
import com.example.User.Management.System.service.UsersService;
import com.example.User.Management.System.util.UsersUtil;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    public UsersService service;

    @PostMapping(value = "addUser")
    public ResponseEntity<String> addUser(@RequestBody String user) {
        JSONObject json = new JSONObject(user);

        List<String> validationList = UsersUtil.userValidation(json);
        if (validationList.isEmpty()) {
            Users users = UsersUtil.setUser(json);
            service.saveUsers(users);
            return new ResponseEntity<>("User Saved", HttpStatus.CREATED);
        } else {
            String[] ans = Arrays.copyOf(validationList.toArray(), validationList.size(), String[].class);
            return new ResponseEntity<>("Please pass this mandatory parameters:- " + Arrays.toString(ans), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "getAllUser")
    public List<Users> getAllUsers(@Nullable @RequestParam String userId) {
        return service.getUser(userId);
    }

    @PutMapping(value = "updateUserInfo/{id}")
    public void updateUsers(@PathVariable int id, @RequestBody Users users) {
        service.updateUsers(id, users);
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUsers(@RequestParam int id) {
        service.deleteUsers(id);
    }
}

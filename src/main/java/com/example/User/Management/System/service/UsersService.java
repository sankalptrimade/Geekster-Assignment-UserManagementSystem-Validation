package com.example.User.Management.System.service;

import com.example.User.Management.System.dao.UsersRepository;
import com.example.User.Management.System.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    public UsersRepository repository;


    public Users saveUsers(Users users) {
        return repository.save(users);
    }

    public List<Users> getUser(String userId) {
        List<Users> userList;
        if(null != userId){
            userList = new ArrayList<>();
            userList.add(repository.findById(Integer.valueOf(userId)).get());
        }else {
            userList = repository.findAll();
        }
        return userList;
    }

    public void updateUsers(int id, Users newUsers) {
        Users users = repository.findById(id).get();
        users.setUserName(newUsers.getUserName());
        users.setDateOfBirth(newUsers.getDateOfBirth());
        users.setEmail(newUsers.getEmail());
        users.setPhoneNumber(newUsers.getPhoneNumber());
        repository.save(users);
    }

    public void deleteUsers(int id) {
        repository.deleteById(id);
    }
}

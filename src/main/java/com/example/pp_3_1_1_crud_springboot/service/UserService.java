package com.example.pp_3_1_1_crud_springboot.service;

import com.example.pp_3_1_1_crud_springboot.model.User;
import com.example.pp_3_1_1_crud_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    Iterable<User> getAllUsers ();
    User getUserById (int id);
    void addUser (User user);
    void removeUser (int id);
    void updateUser (int id);
}

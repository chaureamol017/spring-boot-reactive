package com.mycomp.reactive.service.impl;

import com.mycomp.reactive.persistence.dao.UserDao;
import com.mycomp.reactive.service.api.UserService;
import com.mycomp.reactive.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Flux<User> getAllUsersStream() {
        return userDao.getAllUsersStream();
    }


}

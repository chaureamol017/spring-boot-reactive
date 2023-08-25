package com.mycomp.reactive.service.api;

import com.mycomp.reactive.persistence.entity.User;
import reactor.core.publisher.Flux;

import java.util.List;


public interface UserService {

    public List<User> getAllUsers();
    Flux<User> getAllUsersStream();

}

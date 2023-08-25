package com.mycomp.reactive.web.controller;

import com.mycomp.reactive.persistence.entity.User;
import com.mycomp.reactive.service.api.ReactiveUserService;
import com.mycomp.reactive.service.api.UserService;
import com.mycomp.reactive.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("reactive/user")
public class ReactiveUserController {
    @Autowired private ReactiveUserService reactiveUserService;


    @GetMapping
    public Flux<UserModel> getAllUsers() {
        return reactiveUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserModel> getUser(@PathVariable Long id) {
        return reactiveUserService.getUser(id);
    }

    @PostMapping
    public Mono<UserModel> saveUser(@RequestBody Mono<UserModel> userModelMono) {
        return reactiveUserService.saveUser(userModelMono);
    }

    @PutMapping
    public Mono<UserModel> updateUser(@RequestBody Mono<UserModel> userModelMono) {
        return reactiveUserService.updateUser(userModelMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return reactiveUserService.deleteUser(id);
    }

}

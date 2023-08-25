package com.mycomp.reactive.service.api;

import com.mycomp.reactive.service.model.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveUserService {

    Flux<UserModel> getAllUsers();
    Mono<UserModel> getUser(Long id);
    Mono<UserModel> saveUser(Mono<UserModel> userModelMono);
    Mono<UserModel> updateUser(Mono<UserModel> userModelMono);
    Mono<Void> deleteUser(Long id);

}

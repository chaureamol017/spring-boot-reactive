package com.mycomp.reactive.service.impl;

import com.mycomp.reactive.persistence.entity.User;
import com.mycomp.reactive.persistence.repository.UserRepository;
import com.mycomp.reactive.service.adapter.UserAdapter;
import com.mycomp.reactive.service.api.ReactiveUserService;
import com.mycomp.reactive.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveUserServiceImpl implements ReactiveUserService {
    private UserAdapter adapter = UserAdapter.INSTANCE;
    @Autowired private UserRepository userRepository;

    @Override
    public Flux<UserModel> getAllUsers() {
        final Flux<User> users = userRepository.findAll();

        return users.map(adapter::toModel);
    }

    @Override
    public Mono<UserModel> getUser(final String id) {
        final Mono<User> userMono = userRepository.findById(id);
        return userMono.map(adapter::toModel);
    }

    @Override
    public Mono<UserModel> saveUser(Mono<UserModel> userModelMono) {
        final Mono<User> userMono = userModelMono.map(adapter::toEntityMinimal);
        final Mono<User> userMonoAfterSave = userMono.flatMap(userRepository::insert);
        return userMonoAfterSave.map(adapter::toModel);
    }

    @Override
    public Mono<UserModel> updateUser(Mono<UserModel> userModelMono) {
        final Mono<User> userMono = userModelMono.map(adapter::toEntity);
        final Mono<User> userMonoAfterSave = userMono.flatMap(userRepository::save);
        return userMonoAfterSave.map(adapter::toModel);
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }


}

package com.mycomp.reactive.web.handler;

import com.mycomp.reactive.persistence.dao.UserDao;
import com.mycomp.reactive.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {
    @Autowired private UserDao userDao;

    public Mono<ServerResponse> loadUsers(ServerRequest request) {
        final Flux<User> userList = userDao.getAllUserList();

        return ServerResponse.ok().body(userList, User.class);
    }

    public Mono<ServerResponse> findUser(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));

        final Mono<User> userMono = userDao.getAllUserList().filter(user -> user.getUserId() == id).next();

        return ServerResponse.ok().body(userMono, User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);

        final Mono<String> resp = userMono.map(user -> user.getUserId() + " : " + user.getName());

        return ServerResponse.ok().body(userMono, User.class);
    }
}

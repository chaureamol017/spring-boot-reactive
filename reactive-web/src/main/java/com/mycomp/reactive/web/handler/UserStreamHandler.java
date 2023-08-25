package com.mycomp.reactive.web.handler;

import com.mycomp.reactive.persistence.dao.UserDao;
import com.mycomp.reactive.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserStreamHandler {
    @Autowired private UserDao userDao;


    public Mono<ServerResponse> loadAllUsers(ServerRequest request) {
        final Flux<User> userList = userDao.getAllUsersStream();

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userList, User.class);
    }
}

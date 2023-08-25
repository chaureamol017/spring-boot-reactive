package com.mycomp.reactive.web.config;

import com.mycomp.reactive.web.handler.UserHandler;
import com.mycomp.reactive.web.handler.UserStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Autowired private UserHandler userHandler;
    @Autowired private UserStreamHandler userStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("router/user", userHandler::loadUsers)
                .GET("router/user/{id}", userHandler::findUser)
                .POST("router/user", userHandler::saveUser)
                .GET("router/user/stream", userStreamHandler::loadAllUsers)
                .build();
    }
}

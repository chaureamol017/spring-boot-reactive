package com.mycomp.reactive.persistence.dao;

import com.mycomp.reactive.common.thread.ThreadSleeper;
import com.mycomp.reactive.persistence.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class UserDao {
    public List<User> getAllUsers() {
        return LongStream.rangeClosed(1, 10)
                .peek(index -> System.out.println("Processing count: " + index))
                .peek(index -> ThreadSleeper.sleepExecution(500))
                .mapToObj(index -> new User(index, "New User " + index))
                .collect(Collectors.toList());
    }

    public Flux<User> getAllUsersStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofMillis(500))
                .doOnNext(index -> System.out.println("Stream processing count: " + index))
                .map(index -> new User((long) index, "New User " + index));
    }

    public Flux<User> getAllUserList() {
        return Flux.range(1, 10)
                .doOnNext(index -> System.out.println("Stream processing count: " + index))
                .map(index -> new User((long) index, "New User " + index));
    }
}

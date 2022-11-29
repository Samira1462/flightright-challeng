package com.flightright.codechallenge.service;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.flightright.codechallenge.model.User;

import java.util.List;
import java.util.Map;

public class UserService {
    public Map<User, Long> count(List<User> users) {
        requireNonNull(users, "users list is null");

        return users.stream()
                .collect(groupingBy(user -> user, counting()));
    }
}

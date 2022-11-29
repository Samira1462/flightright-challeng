package com.flightright.codechallenge.transformer;

import static com.flightright.codechallenge.util.StringUtils.isBlank;
import static java.util.Objects.requireNonNull;

import com.flightright.codechallenge.model.User;

import java.util.function.Function;

public final class UserTransformer implements Function<String, User> {

    private static final String COLUMN_SEPARATOR = ",";

    @Override
    public User apply(String entry) {
        if (isBlank(entry)) {
            requireNonNull(entry, "entry is null");
        }

        var columns = entry.split(COLUMN_SEPARATOR);

        if (isBlank(columns[0]) || isBlank(columns[1]) || isBlank(columns[2])) {
            return null;
        }

        return new User(columns[0], Integer.parseInt(columns[1]), columns[2]);
    }

}

package com.flightright.codechallenge.model;

import java.util.Objects;

public final class User {

    private final String email;

    private final int phone;

    private final String source;

    public User(String email, int phone, String source) {
        this.email = email;
        this.phone = phone;
        this.source = source;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return phone == user.phone && Objects.equals(email, user.email) && Objects.equals(source, user.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone, source);
    }

}

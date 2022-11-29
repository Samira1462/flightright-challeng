package com.flightright.codechallenge;

import com.flightright.codechallenge.model.User;
import com.flightright.codechallenge.service.UserService;
import com.flightright.codechallenge.transformer.UserTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.flightright.codechallenge.util.CsvFileUtils.read;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Tests")
class UserServiceTest {

    private final UserService underTest = new UserService();

    private final List<User> givenUsers = read("src/test/resources/users.csv", new UserTransformer());

    @BeforeEach
    void setUp() {
        assertNotNull(givenUsers);
    }


    @Test
    @DisplayName("if users Is Null Should throws NullPointerException")
    void ifUsersIsNullShouldThrowNullPointerException() {

        var result = assertThrows(NullPointerException.class, () -> underTest.count(null));
        assertEquals("users list is null", result.getMessage());

    }

    @Test
    @DisplayName("if users Is empty Should Return Empty Map")
    void ifUsersIsEmptyShouldReturnEmptyMap() {
        var givenUsers = new ArrayList<User>();
        var result = underTest.count(givenUsers);
        assertNotNull(result);
        assertEquals(0, result.size());
    }


    @Test
    @DisplayName("get the count of visitor")
    void givenUserCollectionThenReturnMapOfUsersAndCountOfUsers() {

        var result = underTest.count(givenUsers);

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(2, result.get(new User("test@test.com", 3045250, "google.com")));
        assertEquals(2, result.get(new User("test1@test.com", 321, "google.com")));
        assertEquals(1, result.get(new User("test@test.com", 123, "google.com")));
        assertEquals(2, result.get(new User("test@test.com", 123, "yahoo.com")));
    }

}

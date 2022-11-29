package com.flightright.codechallenge;


import com.flightright.codechallenge.transformer.UserTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserTransformer Tests")
class UserTransformerTest {

    private final UserTransformer underTest = new UserTransformer();

    @Test
    @DisplayName("if entry is Null Should throws NullPointerException")
    void ifTransformerIsNullShouldThrowNullPointerException1() {
        var result = assertThrows(NullPointerException.class, () ->  underTest.apply(null));
        assertEquals("entry is null", result.getMessage());
    }

    @Test
    @DisplayName("user row with a null field")
    void ifUserRowHasNullFieldShouldReturnNull() {
        var givenRow = "test@test.com,,google.com";

        var user = underTest.apply(givenRow);

        assertNull(user);
    }


    @Test
    @DisplayName("user row with not null fields")
    void givenUserRowAsStringThenReturnUserAsBean() {
        var givenRow = "test@test.com,123456789,google.com";

        var user = underTest.apply(givenRow);

        assertNotNull(user);
        assertEquals("test@test.com", user.getEmail());
        assertEquals(123456789, user.getPhone());
        assertEquals("google.com", user.getSource());
    }
}

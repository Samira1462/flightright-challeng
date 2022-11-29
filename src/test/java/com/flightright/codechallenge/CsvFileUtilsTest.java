package com.flightright.codechallenge;

import com.flightright.codechallenge.transformer.UserTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.flightright.codechallenge.util.CsvFileUtils.read;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CsvFileUtils Tests")
class CsvFileUtilsTest {

    @Test
    @DisplayName("if transformer Is Null Should throws NullPointerException")
    void ifTransformerIsNullShouldThrowNullPointerException() {
        var givenFilePath = "src/test/resources/users-empty.csv";
        var result = assertThrows(NullPointerException.class, () -> read(givenFilePath, null));
        assertEquals("transformer is null", result.getMessage());
    }


    @Test
    @DisplayName("if file path Is empty Should throws IllegalArgumentException")
    void ifFilePathIsEmptyShouldThrowsIllegalArgumentException() {
        var givenFilePath = "";
        var givenTransformer = new UserTransformer();
        var result = assertThrows(IllegalArgumentException.class, () -> read(givenFilePath, givenTransformer));
        assertEquals("file path is empty", result.getMessage());
    }

    @Test
    @DisplayName("if file path Is empty Should return EmptyList")
    void ifFilePathIsEmptyShouldReturnEmptyList() {
        var givenFilePath = "src/test/resources/users-not-exist-file.csv";
        var givenTransformer = new UserTransformer();
        var result = read(givenFilePath, givenTransformer);
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("if file is empty")
    void ifFileIsEmptyShouldReturnEmptySet() {
        var givenFilePath = "src/test/resources/users-empty.csv";
        var givenTransformer = new UserTransformer();

        var expected = 0;

        var result = read(givenFilePath, givenTransformer);

        assertNotNull(result);
        assertEquals(result.size(), expected);
    }

    @Test
    @DisplayName("if file is not empty")
    void ifFileHasRowShouldReturnTotalRowsCount() {
        var givenFilePath = "src/test/resources/users.csv";
        var givenTransformer = new UserTransformer();

        var expected = 7;

        var result = read(givenFilePath, givenTransformer);

        assertNotNull(result);
        assertEquals(result.size(), expected);
    }

}

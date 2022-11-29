package com.flightright.codechallenge.util;

import static com.flightright.codechallenge.util.StringUtils.isBlank;
import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CsvFileUtils {

    private CsvFileUtils() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileUtils.class.getSimpleName());

    private static final int HEADER_ROW = 1;

    public static <E> List<E> read(String filePath, Function<String, E> transformer) {

        if (isBlank(filePath)) {
            throw new IllegalArgumentException("file path is empty");
        }

        requireNonNull(transformer, "transformer is null");

        var file = new File(filePath);

        try (InputStream inputFS = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFS))) {

            return bufferedReader.lines()
                    .skip(HEADER_ROW)
                    .map(transformer)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }

        return emptyList();
    }
}

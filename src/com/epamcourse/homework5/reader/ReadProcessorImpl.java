package com.epamcourse.homework5.reader;

import com.epamcourse.homework5.exception.ProjectInvalidDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadProcessorImpl implements ReadProcessor {
    public List<String> readLines(Path path) throws ProjectInvalidDataException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProjectInvalidDataException("Error reading file", e);
        }
    }
}

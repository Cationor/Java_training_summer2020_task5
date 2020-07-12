package com.epamcourse.homework5.reader;

import com.epamcourse.homework5.exception.ProjectInvalidDataException;

import java.nio.file.Path;
import java.util.List;

public interface ReadProcessor {
    List<String> readLines(Path path) throws ProjectInvalidDataException;
}

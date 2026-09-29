package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class ReadFileCountLines {

    public static long getCountOfLines(Path filePath) throws IOException {

        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

        if (Files.isDirectory(filePath)) {
            throw new IllegalArgumentException("Path is a directory: " + filePath);
        }

        if (Files.size(filePath) == 0) {
            return 0;
        }

        try (var stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return stream.count();
        }
    }

    @Test
    void shouldReturnCountOfLines() throws IOException{
        assertEquals(5,getCountOfLines(Path.of("/src/test/fivelines.txt")));
    }

    @Test
    void shouldReturnCountOfLinesZero() throws IOException{
        assertEquals(0, getCountOfLines(Path.of("/src/test/zerolines.txt")));
    }

    @Test
    void shouldThrowErrorDirectory(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> getCountOfLines(Path.of("/src/folder")));
        assertEquals("Path is Directory",exception.getMessage());
    }

    @Test
    void shouldThrowErrorFileDoesNotExist(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getCountOfLines(Path.of("src/folder/invalidfile.txt")));
        assertEquals("File doesn't exist",exception.getMessage());
    }

    @Test
    void shouldThrowErrorNullPath(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getCountOfLines(Path.of(null)));
        assertEquals("Path Cannot be Null",exception.getMessage());
    }
}

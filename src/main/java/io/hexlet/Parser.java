package io.hexlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IOException("File '" + path + "' does not exist");
        }

        String content = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }
}

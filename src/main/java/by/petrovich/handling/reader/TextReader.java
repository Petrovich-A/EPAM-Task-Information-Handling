package by.petrovich.handling.reader;

import by.petrovich.handling.exception.CompositeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextReader {
    static Logger logger = LogManager.getLogger();
    private static final String LINE_DELIMITER_REGEX = "\n";

    public String read(String filePath) throws CompositeException {
        if (filePath == null || filePath.isBlank()){
            throw new CompositeException(String.format("File %s not found", filePath));
        }
        String text = "";
        Path path = Paths.get(filePath);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.lines().collect(Collectors.joining(LINE_DELIMITER_REGEX));
        } catch (IOException e) {
            logger.log(Level.ERROR, "read: file isn't read", e);
            throw new CompositeException("read: during read file", e);
        }
        logger.log(Level.INFO, "read: File {} is read", path.getFileName());
        return text;
    }

}

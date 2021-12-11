package by.petrovich.handling.reader;

import by.petrovich.handling.exception.CompositeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    static Logger logger = LogManager.getLogger();

    public String read(String filePath) throws CompositeException {
        if (filePath == null || filePath.isBlank()) {
            throw new CompositeException(String.format("File %s not found", filePath));
        }
        BufferedReader bufferedReader = null;
        String fileText = null;
        try {
            File file = new File(filePath);
            bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(currentLine);
                stringBuilder.append("\n");
            }
            fileText = stringBuilder.toString();

        } catch (IOException e) {
            logger.log(Level.ERROR, "TextReader: read: file isn't read", e);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        logger.log(Level.INFO, "TextReader: read: File is read: {}", fileText);
        return fileText;
    }

}

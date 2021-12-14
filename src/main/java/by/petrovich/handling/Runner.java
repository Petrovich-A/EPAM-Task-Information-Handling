package by.petrovich.handling;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.impl.DocumentParser;
import by.petrovich.handling.parser.impl.WordParser;
import by.petrovich.handling.reader.TextReader;

/**
 * Runner
 */
public class Runner {
    public static void main(String[] args) {
        String filePath = "src/main/resources/files/textExample.txt";
        TextReader textReader = new TextReader();
        String textFromReader = null;
        try {
            textFromReader = textReader.read(filePath);
            WordParser wordParser = WordParser.getInstance();
            wordParser.parse("бандерлоги.");
        } catch (CompositeException e) {
            e.printStackTrace();
        }
        DocumentParser documentParser = DocumentParser.getInstance();
        try {
            TextComponent textComponent = documentParser.parse(textFromReader);
        } catch (CompositeException e) {
            e.printStackTrace();
        }


    }
}

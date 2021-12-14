package by.petrovich.handling;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.impl.DocumentParser;
import by.petrovich.handling.parser.impl.WordParser;
import by.petrovich.handling.reader.TextReader;
import by.petrovich.handling.service.InfoHandlingService;
import by.petrovich.handling.service.InfoHandlingServiceImpl;

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
        } catch (CompositeException e) {
            e.printStackTrace();
        }
        DocumentParser documentParser = DocumentParser.getInstance();

        TextComponent textComponent = null;
        try {
            textComponent = documentParser.parse(textFromReader);
        } catch (CompositeException e) {
            e.printStackTrace();
        }

        InfoHandlingServiceImpl infoHandlingService = new InfoHandlingServiceImpl();
        infoHandlingService.findAllComponents(textComponent, CompositeType.TEXT);
        System.out.println("infoHandlingService: " + infoHandlingService);
    }
}

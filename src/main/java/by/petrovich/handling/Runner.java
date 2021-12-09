package by.petrovich.handling;

import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.impl.DocumentParser;

/**
 * Runner
 */
public class Runner {
    public static void main(String[] args) {
        DocumentParser documentParser = new DocumentParser();
        try {
            documentParser.parse("src/main/resources/files/textExample.txt");
        } catch (CompositeException e) {
            e.printStackTrace();
        }

    }
}

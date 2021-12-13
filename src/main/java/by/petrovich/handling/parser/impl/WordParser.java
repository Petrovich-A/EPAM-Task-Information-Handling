package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final WordParser instance = new WordParser();
    private final TextParser symbolParser = SymbolParser.getInstance();

    private WordParser() {
    }

    public static WordParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()) {
            throw new CompositeException("paragraph is empty");
        }

        TextComponent wordComposite = new TextComposite(CompositeType.WORD);
        wordComposite = new TextComposite(CompositeType.WORD);
        for (String symbol : text.split("")) {
            wordComposite.add(symbolParser.parse(symbol));
        }
        return wordComposite;
    }
}

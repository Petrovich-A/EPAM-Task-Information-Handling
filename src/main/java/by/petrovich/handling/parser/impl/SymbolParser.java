package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.*;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final SymbolParser instance = new SymbolParser();
    private static final String DIGIT_REGEX = "\\d";
    private static final String PUNCT_REGEX = "\\p{Punct}";
    private static final String VOWEL_REGEX = "[aeiouAEIOUауоыиэяюёеАУОЫИЭЯЮЁЕ]";


    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()) {
            throw new CompositeException("SymbolParser: text is empty");
        }
        Symbol symbol = new Symbol(text.charAt(0), SymbolType.UNKNOWN);
        TextComposite symbolComposite = new TextComposite(CompositeType.SYMBOL);
        if (text.matches(DIGIT_REGEX)) {
            symbol.setSymbol(text.charAt(0));
            symbol.setSymbolType(SymbolType.DIGIT);
        } else if (text.matches(PUNCT_REGEX)) {
            symbol.setSymbol(text.charAt(0));
            symbol.setSymbolType(SymbolType.PUNCTUATION);
        } else if (text.matches(VOWEL_REGEX)) {
            symbol.setSymbol(text.charAt(0));
            symbol.setSymbolType(SymbolType.VOWEL);
        } else {
            symbol.setSymbol(text.charAt(0));
            symbol.setSymbolType(SymbolType.CONSONANT);
        }
        logger.log(Level.INFO, "symbol type: {} ", String.valueOf(symbol.getSymbolType()));
        symbolComposite.add(symbol);
        return symbolComposite;
    }
}

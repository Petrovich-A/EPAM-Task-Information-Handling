package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements TextParser{
    static Logger logger = LogManager.getLogger();
    private static final String WORD_DELIMITER_REGEX = "\\s+";
    private static final SentenceParser instance = new SentenceParser();
    private final TextParser wordParser = WordParser.getInstance();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()){
            throw new CompositeException("SentenceParser: text is empty");
        }
        TextComposite sentenceComposite = new TextComposite(CompositeType.SENTENCE);

        for (String word : text.split(WORD_DELIMITER_REGEX)){
            logger.log(Level.INFO, "word: {}", word);
            TextComponent wordComposite = wordParser.parse(word);
            sentenceComposite.add(wordComposite);
        }
        return sentenceComposite;
    }
}

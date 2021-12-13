package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String SENTENCE_DELIMITER_REGEX = ".+?([.]{3}|[.!?])($|\\s)";
    private static final ParagraphParser instance = new ParagraphParser();
    private final TextParser sentenceParser = SentenceParser.getInstance();

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()) {
            throw new CompositeException("ParagraphParser: text is empty");
        }

        TextComposite paragraphComposite = new TextComposite(CompositeType.SENTENCE);


        return paragraphComposite;
    }
}

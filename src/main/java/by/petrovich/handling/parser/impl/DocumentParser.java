package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComponentType;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DocumentParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\n\\s+";
//    private TextParser textParser = new DocumentParser();

    public DocumentParser() {
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()) {
            logger.log(Level.INFO, "DocumentParser: {}", text);
        }
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);
        for (String paragraph : text.split(PARAGRAPH_DELIMITER_REGEX)) {
            logger.log(Level.INFO, "paragraph: {}", paragraph);
//            TextComponent paragraphComponent = textParser.parse(paragraph);
        }
        logger.log(Level.INFO, "DocumentParser: text parsed ");
        return textComposite;
    }
}

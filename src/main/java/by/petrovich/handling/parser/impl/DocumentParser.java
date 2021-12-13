package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DocumentParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\n\\s+";
    private static final DocumentParser instance = new DocumentParser();
    private final TextParser paragraphParser = ParagraphParser.getInstance();

    private DocumentParser() {
    }

    public static DocumentParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) throws CompositeException {
        if (text == null || text.isBlank()) {
            logger.log(Level.INFO, "DocumentParser: text is empty");
        }
        TextComposite documentComposite = new TextComposite(CompositeType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER_REGEX);

        for (String paragraph : paragraphs) {
            TextComponent paragraphComposite =  paragraphParser.parse(paragraph);
            documentComposite.add(paragraphComposite);
            System.out.println("sdfsdf: " + paragraph);
            logger.log(Level.INFO, "paragraphComposite: \n {} ", Arrays.toString(paragraphs));
        }
        logger.log(Level.INFO, "DocumentParser: text is parsed {} ", documentComposite.toString());
        return documentComposite;
    }

}

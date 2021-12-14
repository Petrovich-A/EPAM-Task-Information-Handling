package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DocumentParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\n";
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

        for (String paragraph : text.split(PARAGRAPH_DELIMITER_REGEX)) {
            logger.log(Level.INFO, "paragraph: {} ", paragraph);
            TextComponent paragraphComposite = paragraphParser.parse(paragraph);
            documentComposite.add(paragraphComposite);
        }
        logger.log(Level.INFO, "DocumentParser: text is parsed: {}, size: {}", documentComposite.toString(), documentComposite.size());
        return documentComposite;
    }

}

package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComponentType;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER_REGEX = ".+?([.]{3}|[.!?])($|\\s)";
    private TextParser sentenceParser = new DocumentParser();

    @Override
    public TextComponent parse(String paragraph) throws CompositeException {
        if (paragraph == null || paragraph.isBlank()) {
            throw new CompositeException("paragraph is empty");
        }

        TextComposite paragraphComposite = new TextComposite(TextComponentType.SENTENCE);
        Pattern pattern = Pattern.compile(PARAGRAPH_DELIMITER_REGEX, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(paragraph);

        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent sentenceComposite = sentenceParser.parse(sentence);
            paragraphComposite.add(sentenceComposite);
        }
        return paragraphComposite;
    }
}

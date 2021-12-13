package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements TextParser {
    static Logger logger = LogManager.getLogger();
    private static final String SYMBOL_DELIMITER_REGEX = "\\s";
    private static final WordParser instance = new WordParser();
    private static final String SYMBOL_DELIMITER = "";
    private static final String REGEX_LETTER = "[a-zA-Z]";
    private static final String REGEX_PUNCTUATION = "[,]";
    private static final String REGEX_NUMBER = "[0-9]";
    private static final String REGEX_MARK = "[.!?]";

    private WordParser() {
    }

    public static WordParser getInstance(){
        return instance;
    }

    @Override
    public TextComponent parse(String paragraph) throws CompositeException {
        if (paragraph == null || paragraph.isBlank()) {
            throw new CompositeException("paragraph is empty");
        }

//        TextComposite paragraphComposite = new TextComposite(TextComponentType.SENTENCE);
//        Pattern pattern = Pattern.compile(PARAGRAPH_DELIMITER_REGEX, Pattern.DOTALL);
//        Matcher matcher = pattern.matcher(paragraph);
//
//        while (matcher.find()) {
//            String sentence = matcher.group();
//            TextComponent sentenceComposite = sentenceParser.parse(sentence);
//            paragraphComposite.add(sentenceComposite);
//        }
//        return paragraphComposite;
        return null;
    }
}

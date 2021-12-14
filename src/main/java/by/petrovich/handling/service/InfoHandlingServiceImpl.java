package by.petrovich.handling.service;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.impl.DocumentParser;
import by.petrovich.handling.parser.impl.SentenceParser;
import by.petrovich.handling.parser.impl.WordParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class InfoHandlingServiceImpl implements InfoHandlingService {
    private static final String VOWEL_REGEX = "[aeiouAEIOUауоыиэяюёеАУОЫИЭЯЮЁЕ]";
    private static final String CONSONANT_REGEX = "[qwrtpsdfghjklzxcvbnm]";
    private static Logger logger = LogManager.getLogger();

    public List<TextComponent> findAllComponents(TextComponent textComponent, CompositeType compositeType) {
        List<TextComponent> allComponents = new ArrayList<>();
        Queue<TextComponent> queue = new ArrayDeque<>();
        queue.add(textComponent);
        if (textComponent.getComponentType() == compositeType) {
            allComponents.add(textComponent);
        }
        while (!queue.isEmpty()) {
            TextComponent current = queue.poll();
            if (current.getComponentType() != CompositeType.SYMBOL) {

                current.getAllComponents().forEach(child -> {
                    if (child.getComponentType() == compositeType) {
                        allComponents.add(child);
                    }
                    queue.add(child);
                });
            }
        }
        return allComponents;
    }

    public TextComponent findSentenceWithLongestWord(String filePath) throws CompositeException {
        SentenceParser sentenceParser = SentenceParser.getInstance();
        TextComponent sentenceComposite = sentenceParser.parse(filePath);
//to do
        return null;
    }

    @Override
    public long countVowel(String filePath) throws CompositeException {
        WordParser wordParser = WordParser.getInstance();
        TextComponent wordComposite = wordParser.parse(filePath);
        List<TextComponent> symbols = wordComposite.getAllComponents();

        long vowelCount = symbols.stream().filter(o -> o.toString().matches(VOWEL_REGEX)).count();

        logger.log(Level.INFO, "The are {} vowels text contains", vowelCount);
        return vowelCount;
    }

    @Override
    public long countConsonant(String filePath) throws CompositeException {
        WordParser wordParser = WordParser.getInstance();
        TextComponent wordComposite = wordParser.parse(filePath);
        List<TextComponent> symbols = wordComposite.getAllComponents();

        long consonantCount = symbols.stream().filter(o -> o.toString().matches(CONSONANT_REGEX)).count();

        logger.log(Level.INFO, "The are {} consonants text contains", consonantCount);
        return consonantCount;
    }

    @Override
    public List<TextComponent> deleteSentences(String filePath, int wordsAmount) throws CompositeException {
        SentenceParser sentenceParser = SentenceParser.getInstance();
        TextComponent sentenceComposite = sentenceParser.parse(filePath);

//to do
        return null;
    }

    @Override
    public TextComponent paragraphSort(String filePath) throws CompositeException {
        DocumentParser documentParser = DocumentParser.getInstance();
        TextComponent documentComposite = documentParser.parse(filePath);
        TextComposite sortedText = new TextComposite(CompositeType.PARAGRAPH);
        List<TextComponent> paragraphs = documentComposite.getAllComponents();

        paragraphs.sort(Comparator.comparingInt(TextComponent::size));

        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    public TextComponent findLongestWord(String filePath) throws CompositeException {
        SentenceParser sentenceParser = SentenceParser.getInstance();
        TextComponent sentenceComposite = sentenceParser.parse(filePath);
        List<TextComponent> sentences = sentenceComposite.getAllComponents();

        TextComponent longestWord = sentences.stream()
                .max(Comparator.comparingInt(TextComponent::size)).orElseThrow(() ->
                        new CompositeException("findSentenceWithLongestWord: Stream is empty"));

        logger.log(Level.INFO, "The longest word is: {} ", longestWord);
        return longestWord;
    }

}

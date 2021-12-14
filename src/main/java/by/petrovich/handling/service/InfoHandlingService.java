package by.petrovich.handling.service;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;

import java.util.List;

public interface InfoHandlingService {
    TextComponent paragraphSort(String filePath) throws CompositeException;

    TextComponent findSentenceWithLongestWord(String filePath) throws CompositeException;

    long countVowel(String filePath) throws CompositeException;

    long countConsonant(String filePath) throws CompositeException;

    List<TextComponent> deleteSentences(String filePath, int wordsAmount) throws CompositeException;

    //to do countSameWords();

}

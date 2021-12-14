package by.petrovich.handling.service;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;

public interface InfoHandlingService {
    TextComponent paragraphSort(String filePath) throws CompositeException;
    TextComponent findSentenceWithLongestWord (String filePath) throws CompositeException;
    long countVowel(String filePath) throws CompositeException;

//    List<TextComponent> deleteSentences(TextComponent text , int sizeBound);
//    Map<String, Long> countSameWords(TextComponent text);
//    long countConsonant(TextComponent text);

}

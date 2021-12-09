package by.petrovich.handling.parser;

import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;

public interface TextParser {
    TextComponent parse(String text) throws CompositeException;

}

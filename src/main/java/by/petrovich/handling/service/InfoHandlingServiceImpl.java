package by.petrovich.handling.service;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


public class InfoHandlingServiceImpl implements InfoHandlingService{
    private static Logger logger = LogManager.getLogger();

    @Override
    public TextComponent paragraphSort(TextComponent textComponent) {
        TextComposite sortedText = new TextComposite(CompositeType.TEXT);
        List<TextComponent> paragraphs = findAllComponents(textComponent, CompositeType.PARAGRAPH);
        return null;
    }


}

package by.petrovich.handling.service;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.entity.TextComposite;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.parser.impl.DocumentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class InfoHandlingServiceImpl implements InfoHandlingService {
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

                current.createAllComponents().forEach(child -> {
                    if (child.getComponentType() == compositeType) {
                        allComponents.add(child);
                    }
                    queue.add(child);
                });
            }
        }
        return allComponents;
    }

    @Override
    public TextComponent paragraphSort(String filePath) throws CompositeException {
        DocumentParser documentParser = DocumentParser.getInstance();
        TextComponent documentComposite = documentParser.parse(filePath);
        TextComposite sortedText = new TextComposite(CompositeType.PARAGRAPH);
        List<TextComponent> paragraphs = documentComposite.createAllComponents();

        paragraphs.sort(Comparator.comparingInt(TextComponent::size));

        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

}

package by.petrovich.handling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private TextComponentType textComponentType;
    private List<TextComponent> textComponents;

    public TextComposite(TextComponentType textComponentType, List<TextComponent> textComponents) {
        this.textComponentType = textComponentType;
        this.textComponents = textComponents;
    }

    public TextComposite(TextComponentType textComponentType) {
        this(textComponentType, new ArrayList<TextComponent>());
    }

    public void setTextComponentType(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    @Override
    public List<TextComponent> createAllComponents() {
        return List.copyOf(textComponents);
    }

    @Override
    public boolean add(TextComponent textComponent) {
        return textComponents.add(textComponent);
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        return textComponents.remove(textComponent);
    }

    @Override
    public int size() {
        return textComponents.size();
    }
}

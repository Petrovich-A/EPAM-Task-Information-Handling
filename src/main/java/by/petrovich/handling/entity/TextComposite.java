package by.petrovich.handling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private CompositeType componentType;
    private List<TextComponent> textComponents;

    public TextComposite(CompositeType textComponentType, List<TextComponent> textComponents) {
        this.componentType = textComponentType;
        this.textComponents = textComponents;
    }

    public TextComposite(CompositeType textComponentType) {
        this(textComponentType, new ArrayList<TextComponent>());
    }

    public void setComponentType(CompositeType componentType) {
        this.componentType = componentType;
    }

    public List<TextComponent> getTextComponents() {
        return textComponents;
    }

    @Override
    public CompositeType getComponentType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getAllComponents() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (getComponentType() != that.getComponentType()) return false;
        return textComponents != null ? textComponents.equals(that.textComponents) : that.textComponents == null;
    }

    @Override
    public int hashCode() {
        int result = getComponentType() != null ? getComponentType().hashCode() : 0;
        result = 31 * result + (textComponents != null ? textComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent element : textComponents) {
            stringBuilder.append(componentType.getPrefix())
                    .append(element.toString())
                    .append(componentType.getPostfix());
        }
        return stringBuilder.toString();
    }
}

package by.petrovich.handling.entity;

import java.util.List;

public interface TextComponent {

    List<TextComponent> getAllComponents();

    boolean add(TextComponent textComponent);

    boolean remove(TextComponent textComponent);

    CompositeType getComponentType();

    int size();

    String toString();

}

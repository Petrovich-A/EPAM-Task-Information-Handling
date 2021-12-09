package by.petrovich.handling.entity;

import java.util.List;

public interface TextComponent {

    List<TextComponent> createAllComponents();

    boolean add(TextComponent textComponent);

    boolean remove(TextComponent textComponent);

    TextComponentType getTextComponentType();

    int size();

    String toString();

}

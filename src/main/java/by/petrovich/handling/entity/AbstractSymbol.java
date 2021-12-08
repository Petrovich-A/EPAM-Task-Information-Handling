package by.petrovich.handling.entity;

import java.util.List;

public class AbstractSymbol implements TextComponent {
    private char symbol;

    public AbstractSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public List<TextComponent> getComponents() {
        return null;
    }

    @Override
    public void add(TextComponent textComponent) {

    }

    @Override
    public void remove(TextComponent textComponent) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractSymbol)) return false;

        AbstractSymbol that = (AbstractSymbol) o;

        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return symbol;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbstractSymbol{");
        sb.append("symbol=").append(symbol);
        sb.append('}');
        return sb.toString();
    }
}

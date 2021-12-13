package by.petrovich.handling.entity;

import java.util.List;

public class Symbol implements TextComponent {
    private char symbol;
    private SymbolType symbolType;

    public Symbol(char symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
    }

    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    @Override
    public List<TextComponent> createAllComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompositeType getComponentType() {
        return CompositeType.SYMBOL;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        if (symbol != symbol1.symbol) return false;
        return symbolType == symbol1.symbolType;
    }

    @Override
    public int hashCode() {
        int result = symbol;
        result = 31 * result + (symbolType != null ? symbolType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}

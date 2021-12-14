package by.petrovich.handling.entity;

import java.util.List;

public class Symbol implements TextComponent {
    private char symbol;
    private SymbolType symbolType;

    public Symbol(char symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
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

    public SymbolType getSymbolType() {
        return symbolType;
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
        return getSymbolType() == symbol1.getSymbolType();
    }

    @Override
    public int hashCode() {
        int result = symbol;
        result = 31 * result + (getSymbolType() != null ? getSymbolType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

}

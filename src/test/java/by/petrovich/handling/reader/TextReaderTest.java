package by.petrovich.handling.reader;

import by.petrovich.handling.exception.CompositeException;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest {
    private static final String FILE_PATH = "src/test/resources/textExample.txt";

    @Test
    public void testRead() throws CompositeException {
        TextReader textReader = new TextReader();
        String actual = textReader.read(FILE_PATH);
        String expected = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
                "It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout.";
        Assert.assertTrue(actual.contains(expected));
    }
}
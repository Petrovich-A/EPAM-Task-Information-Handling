package by.petrovich.handling.parser.impl;

import by.petrovich.handling.entity.CompositeType;
import by.petrovich.handling.entity.TextComponent;
import by.petrovich.handling.exception.CompositeException;
import by.petrovich.handling.service.InfoHandlingServiceImpl;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DocumentParserTest extends TestCase {
    private static final String FILE_PATH = "src/test/resources/textExample.txt";

    @Test
    public void testGetInstance() throws CompositeException {
        DocumentParser documentParser = DocumentParser.getInstance();
        String textExample = "It has survived - essentially unchanged.\n" +
                "It is a long a!=b established at its layout.";
        TextComponent result = documentParser.parse(textExample);
        Assert.assertTrue(result.getAllComponents().size() == 2);

    }
}
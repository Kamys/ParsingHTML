package com.parsingHTML.logic.parsing.tag;

import com.parsingHTML.logic.xml.factory.ElementJsoupFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 18.06.2016.
 */
public class ParserHTMLAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(ParserHTMLAbstractTest.class);
    private ParserHTMLAbstract parserHTMLAbstract;
    private Elements elements = new Elements();
    private final int size = new Random().nextInt(20);

    @Before
    public void setUp() throws Exception {
        parserHTMLAbstract = new ParserHTMLAbstractDummy();
        LOGGER.debug("size = " + size);
        for (int i = 0; i < size; i++) {
            elements.add(ElementJsoupFactory.createElementEmpty());
        }

    }

    @Test
    public void isParsing() throws Exception {
        assertFalse(parserHTMLAbstract.isParsing(new Element(Tag.valueOf("nameElement"), "")));
    }

    @Test
    public void checkElementSize() throws Exception {
        assertTrue(parserHTMLAbstract.checkElementSize(elements,size));
    }

    @Test
    public void checkElementSizeFalse() throws Exception {
        assertFalse(parserHTMLAbstract.checkElementSize(new Elements(),2));
    }

    @Test
    public void checkNotElementSize() throws Exception {
        assertTrue(parserHTMLAbstract.checkNotElementSize(new Elements(),2));
    }

    @Test
    public void checkNotElementSizeFalse() throws Exception {
        assertFalse(parserHTMLAbstract.checkNotElementSize(new Elements(),0));
    }

    @Test
    public void parsingElements() throws Exception {
        Elements results = parserHTMLAbstract.parsingElements(elements);
        assertTrue(results.size() == size);
    }

    private class ParserHTMLAbstractDummy extends ParserHTMLAbstract {
        @Override
        public Element parsing(Element element) {
            return ElementJsoupFactory.createElementEmpty();
        }
    }

}
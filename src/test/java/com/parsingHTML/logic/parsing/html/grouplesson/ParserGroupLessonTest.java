package com.parsingHTML.logic.parsing.html.grouplesson;

import com.parsingHTML.logic.parsing.check.ParserXMLCheck;
import org.jsoup.nodes.Element;
import org.junit.Test;

/**
 * Created by Nikita on 29.06.2016.
 */
public class ParserGroupLessonTest {
    @Test
    public void parsing() throws Exception {
        Element elementResults = ParserXMLCheck.parsingElement(new ParserGroupLesson(), "GroupLesson.html");
        ParserXMLCheck.checkElementSize(elementResults, "dayLesson", 6);
    }

}
package com.company.parsingHTML.logic;


import com.company.parsingHTML.logic.file.FileManagerDefault;
import com.company.parsingHTML.logic.loader.LoaderHTML;
import com.company.parsingHTML.logic.loader.LoaderHTMLDefault;
import com.company.parsingHTML.logic.parsing.helper.ParserFileHTML;
import com.company.parsingHTML.logic.parsing.tag.daytime.ParserDayTime;
import com.company.parsingHTML.logic.parsing.tag.ParserRoot;
import com.company.parsingHTML.logic.parsing.tag.ParserTagAbstract;
import com.company.parsingHTML.logic.parsing.tag.grouplesson.ParserGroupLesson;
import com.company.parsingHTML.logic.schedule.Schedule;
import org.htmlcleaner.TagNode;


import java.io.File;
import java.util.Date;

/**
 * Created by Nikita on 03.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        testParsing();
    }


    public static void testParsing(){
        //loadHTML("http://rasp.bukep.ru/");
        File file = getFile("rasp.bukep.ru2.html");
        ParserFileHTML parserFileHTML = new ParserFileHTML();

        Schedule schedule = new Schedule(new Date().toString(), "БУКЭП");
        ParserTagAbstract parserRoot = new ParserRoot();
        parserRoot.getObservableParing().addObserver(new ParserDayTime());
        parserRoot.getObservableParing().addObserver(new ParserGroupLesson());

        parserRoot.parsing(parserFileHTML.parsing(file),schedule);

        System.out.println(schedule.toString());
        System.out.println(schedule.getWeekTime());
    }

    public static File getFile(String name){
        return new FileManagerDefault().getFile(name);
    }

    /**
     * Загрузка html
     * @param stringURL
     */
    public static void loadHTML(String stringURL){
        LoaderHTML loaderHTMLDefault = new LoaderHTMLDefault();
        File file = loaderHTMLDefault.loadHTML("http://rasp.bukep.ru/");
    }

}

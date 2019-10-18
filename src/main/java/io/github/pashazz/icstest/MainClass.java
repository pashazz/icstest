package io.github.pashazz.icstest;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws IOException, ParserException {
        InputStream in = MainClass.class.getClassLoader().getResourceAsStream("timezone.ics");
        assert in != null;
        String input = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
        Calendar cal = getCalendar(input);
        System.out.println("Input\n------------");
        System.out.println(input);
        System.out.println("----------------");

        System.out.println("Parsed\n------------");
        String input2 = cal.toString();
        System.out.println(input2);
        System.out.println("----------------");

        System.out.println("Parsed once again\n----");
        Calendar cal2 = getCalendar(input2);
        System.out.println(cal2.toString());
        System.out.println("------------");


    }

    private static Calendar getCalendar(String input) throws IOException, ParserException {
        return new CalendarBuilder().build(new StringReader(input));
    }

}

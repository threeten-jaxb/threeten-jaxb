package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.LocalDate LocalDate} to ISO-8601 string
 * <p/>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE ISO_LOCAL_DATE}
 *
 * @author Mikhail Sokolov
 */
public class LocalDateXmlAdapter extends TemporalAccessorXmlAdapter<LocalDate> {
    public LocalDateXmlAdapter() {
        super(DateTimeFormatter.ISO_LOCAL_DATE, LocalDate::from);
    }
}

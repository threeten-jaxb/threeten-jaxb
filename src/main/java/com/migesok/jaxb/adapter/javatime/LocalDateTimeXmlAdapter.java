package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.LocalDateTime LocalDateTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME ISO_LOCAL_DATE_TIME}
 */
public class LocalDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<LocalDateTime> {
    public LocalDateTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_LOCAL_DATE_TIME, LocalDateTime::from);
    }
}

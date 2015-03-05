package com.migesok.jaxb.adapter.javatime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.LocalTime LocalTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME ISO_LOCAL_TIME}
 */
public class LocalTimeXmlAdapter extends TemporalAccessorXmlAdapter<LocalTime> {
    public LocalTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_LOCAL_TIME, LocalTime::from);
    }
}

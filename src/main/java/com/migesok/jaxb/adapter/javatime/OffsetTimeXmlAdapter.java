package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.OffsetTime OffsetTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_TIME ISO_OFFSET_TIME}
 */
public class OffsetTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetTime> {
    public OffsetTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_OFFSET_TIME, OffsetTime::from);
    }
}

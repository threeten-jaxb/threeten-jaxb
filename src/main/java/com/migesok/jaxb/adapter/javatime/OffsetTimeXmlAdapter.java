package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code OffsetTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_TIME}
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.OffsetTime
 */
public class OffsetTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetTime> {
    public OffsetTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_OFFSET_TIME, OffsetTime::from);
    }
}

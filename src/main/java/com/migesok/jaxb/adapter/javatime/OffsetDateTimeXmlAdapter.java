package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.OffsetDateTime OffsetDateTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_DATE_TIME ISO_OFFSET_DATE_TIME}
 *
 * @author Mikhail Sokolov
 */
public class OffsetDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetDateTime> {
    public OffsetDateTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_OFFSET_DATE_TIME, OffsetDateTime::from);
    }
}

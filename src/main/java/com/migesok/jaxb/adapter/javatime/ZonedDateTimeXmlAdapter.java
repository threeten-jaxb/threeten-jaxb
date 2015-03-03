package com.migesok.jaxb.adapter.javatime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.ZonedDateTime ZonedDateTime} to ISO-8601 string
 * <p/>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_ZONED_DATE_TIME ISO_ZONED_DATE_TIME}
 *
 * @author Mikhail Sokolov
 */
public class ZonedDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<ZonedDateTime> {
    public ZonedDateTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_ZONED_DATE_TIME, ZonedDateTime::from);
    }
}

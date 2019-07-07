package io.github.threetenjaxb.core;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code ZonedDateTime} to a xs:dateTime conform string.
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_DATE_TIME}
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.ZonedDateTime
 */
public class ZonedDateTimeXsDateTimeAdapter extends TemporalAccessorXmlAdapter<ZonedDateTime> {

    /**
     * Creates a new instance of this class.
     */
    public ZonedDateTimeXsDateTimeAdapter() {
        super(DateTimeFormatter.ISO_OFFSET_DATE_TIME, ZonedDateTime::from);
    }

}

package io.github.threetenjaxb.core;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code OffsetDateTime} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_DATE_TIME}
 * <p>
 * This adapter is suitable for {@code xsd:dateTime} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.OffsetDateTime
 */
public class OffsetDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetDateTime> {
    public OffsetDateTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_OFFSET_DATE_TIME, OffsetDateTime::from);
    }
}

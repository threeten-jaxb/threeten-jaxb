package io.github.threetenjaxb.core;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code OffsetDateTime} to ISO-8601 string that can also
 * parse local date time representations as UTC
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_OFFSET_DATE_TIME}
 * <p>
 * This adapter is suitable for {@code xsd:dateTime} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.OffsetDateTime
 */
public class LenientOffsetDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetDateTime> {
    public LenientOffsetDateTimeXmlAdapter() {
        super(new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .parseLenient()
                .optionalStart()
                .appendOffsetId()
                .toFormatter(), value -> {
            if (value.isSupported(ChronoField.OFFSET_SECONDS)) {
                return OffsetDateTime.from(value);
            } else {
                return LocalDateTime.from(value).atOffset(ZoneOffset.UTC);
            }
        });
    }
}

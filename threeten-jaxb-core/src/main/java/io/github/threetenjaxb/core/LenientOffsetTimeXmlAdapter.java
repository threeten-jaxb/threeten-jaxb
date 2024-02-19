package io.github.threetenjaxb.core;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code OffsetTime} to ISO-8601 string that can also
 * parse local time representations as UTC
 * <p>
 * String format details: {@link DateTimeFormatter#ISO_OFFSET_TIME}
 * <p>
 * This adapter is suitable for {@code xsd:time} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see OffsetTime
 */
public class LenientOffsetTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetTime> {
    public LenientOffsetTimeXmlAdapter() {
        super(new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .optionalStart()
                .appendOffsetId()
                .toFormatter(), value -> {
            if (value.isSupported(ChronoField.OFFSET_SECONDS)) {
                return OffsetTime.from(value);
            } else {
                return LocalTime.from(value).atOffset(ZoneOffset.UTC);
            }
        });
    }
}

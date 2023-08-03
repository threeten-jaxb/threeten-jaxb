package io.github.threetenjaxb.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalQuery;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code ZonedDateTime} to ISO-8601 string
 * <p>
 * String format details:
 * {@link java.time.format.DateTimeFormatter#ISO_ZONED_DATE_TIME}
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.ZonedDateTime
 */
public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime> {
    private static final ZoneId zuluZone = ZoneId.of("Z");

    private final DateTimeFormatter fZonedDateTime;
    private final DateTimeFormatter fLocalDateTime;
    private final DateTimeFormatter fOffsetDateTime;
    private final DateTimeFormatter fLocalDate;
    private final TemporalQuery<? extends ZonedDateTime> tqZonedDateTime;
    private final TemporalQuery<? extends LocalDateTime> tqLocalDateTime;
    private final TemporalQuery<? extends OffsetDateTime> tqOffsetDateTime;
    private final TemporalQuery<? extends LocalDate> tqLocalDate;

    public ZonedDateTimeXmlAdapter() {
        this.fZonedDateTime = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        this.fLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.fOffsetDateTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        this.fLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        this.tqZonedDateTime = ZonedDateTime::from;
        this.tqLocalDateTime = LocalDateTime::from;
        this.tqOffsetDateTime = OffsetDateTime::from;
        this.tqLocalDate = LocalDate::from;
    }

    @Override
    public ZonedDateTime unmarshal(String stringValue) {
        if (stringValue == null)
            return null;

        if (stringValue.contains("T")) { // stringValue contains a Time component
            // stringValue contains zone
            if ((stringValue.contains("Z")) || ((stringValue.contains("[") && (stringValue.contains("]"))))) {
                return fZonedDateTime.parse(stringValue, tqZonedDateTime);
            } else if ((stringValue.contains("+")) || (stringValue.contains("-"))) { // stingValue contains only offset
                return fOffsetDateTime.parse(stringValue, tqOffsetDateTime).atZoneSameInstant(zuluZone);
            } else {
                return fLocalDateTime.parse(stringValue, tqLocalDateTime).atZone(zuluZone);
            }
        } else {
            return fLocalDate.parse(stringValue, tqLocalDate).atStartOfDay(zuluZone);
        }
    }

    @Override
    public String marshal(ZonedDateTime value) {
        return value != null ? fZonedDateTime.format(value) : null;
    }
}

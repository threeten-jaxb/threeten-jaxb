package io.github.threetenjaxb.extra;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.threeten.extra.OffsetDate;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * {@code XmlAdapter} mapping threeten-extra's {@link OffsetDate} to ISO-8601
 * string that can also parse dates with no offsets as UTC.
 *
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_DATE}
 * </p>
 *
 * This adapter is suitable for {@code xs:date} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see org.threeten.extra.OffsetDate
 */
public class OffsetDateXmlAdapter extends XmlAdapter<String, OffsetDate> {
    @Override
    public OffsetDate unmarshal(String s) throws Exception {
        if (s == null) return null;
        TemporalAccessor dt = DateTimeFormatter.ISO_DATE.parseBest(s, OffsetDate::from, LocalDate::from);
        if (dt instanceof OffsetDate) {
            return (OffsetDate) dt;
        } else {
            return OffsetDate.of((LocalDate) dt, ZoneOffset.UTC);
        }
    }

    @Override
    public String marshal(OffsetDate offsetDate) throws Exception {
        return offsetDate != null ? offsetDate.format(DateTimeFormatter.ISO_OFFSET_DATE) : null;
    }
}

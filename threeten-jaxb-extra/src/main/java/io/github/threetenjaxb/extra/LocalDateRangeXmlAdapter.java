package io.github.threetenjaxb.extra;

import org.threeten.extra.LocalDateRange;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link LocalDateRange}.
 *
 * <p>This {@link XmlAdapter} binds {@link LocalDateRange} to its ISO-8601 string
 * representation, such as {@code 2007-12-03/2007-12-04}.
 *
 * @see LocalDateRange#toString()
 */
public class LocalDateRangeXmlAdapter extends XmlAdapter<String, LocalDateRange> {
    @Override
    public LocalDateRange unmarshal(String text) {
        return text != null ? LocalDateRange.parse(text) : null;
    }

    @Override
    public String marshal(LocalDateRange localDateRange) {
        return localDateRange != null ? localDateRange.toString() : null;
    }
}

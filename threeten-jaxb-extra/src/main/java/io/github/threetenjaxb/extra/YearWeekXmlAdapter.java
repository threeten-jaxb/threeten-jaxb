package io.github.threetenjaxb.extra;

import org.threeten.extra.YearWeek;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link YearWeek}.
 *
 * <p>This {@link XmlAdapter} binds {@link YearWeek} to its ISO-8601 string
 * representation, such as {@code 2015-W13}. The format is {@code YYYY-'W'ww}.
 *
 * @see YearWeek#toString()
 */
public class YearWeekXmlAdapter extends XmlAdapter<String, YearWeek> {
    @Override
    public YearWeek unmarshal(String text) {
        return text != null ? YearWeek.parse(text) : null;
    }

    @Override
    public String marshal(YearWeek yearWeek) {
        return yearWeek != null ? yearWeek.toString() : null;
    }
}

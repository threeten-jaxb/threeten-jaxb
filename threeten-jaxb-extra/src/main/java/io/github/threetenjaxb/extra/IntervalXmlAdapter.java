package io.github.threetenjaxb.extra;

import org.threeten.extra.Interval;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Interval}.
 *
 * <p>This {@link XmlAdapter} binds {@link Interval} to its ISO-8601 string
 * representation, such as {@code 2007-12-03T10:15:30/2007-12-04T10:15:30}.
 *
 * @see Interval#toString()
 */
public class IntervalXmlAdapter extends XmlAdapter<String, Interval> {
    @Override
    public Interval unmarshal(String text) {
        return text != null ? Interval.parse(text) : null;
    }

    @Override
    public String marshal(Interval interval) {
        return interval != null ? interval.toString() : null;
    }
}

package io.github.threetenjaxb.extra;

import org.threeten.extra.Hours;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Hours}.
 *
 * <p>This {@link XmlAdapter} binds {@link Hours} to its ISO-8601 string
 * representation. The format is {@code PTnH} where {@code n} is the number of
 * hours.
 *
 * @see Hours#toString()
 */
public class HoursXmlAdapter extends XmlAdapter<String, Hours> {
    @Override
    public Hours unmarshal(String text) {
        return text != null ? Hours.parse(text) : null;
    }

    @Override
    public String marshal(Hours hours) {
        return hours != null ? hours.toString() : null;
    }
}

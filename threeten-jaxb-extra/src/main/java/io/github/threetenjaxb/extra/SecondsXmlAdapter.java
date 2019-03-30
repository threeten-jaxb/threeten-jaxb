package io.github.threetenjaxb.extra;

import org.threeten.extra.Seconds;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Seconds}.
 *
 * <p>This {@link XmlAdapter} binds {@link Seconds} to its ISO-8601 string
 * representation. The format is {@code PTnS} where {@code n} is the number of
 * seconds.
 *
 * @see Seconds#toString()
 */
public class SecondsXmlAdapter extends XmlAdapter<String, Seconds> {
    @Override
    public Seconds unmarshal(String text) {
        return text != null ? Seconds.parse(text) : null;
    }

    @Override
    public String marshal(Seconds seconds) {
        return seconds != null ? seconds.toString() : null;
    }
}

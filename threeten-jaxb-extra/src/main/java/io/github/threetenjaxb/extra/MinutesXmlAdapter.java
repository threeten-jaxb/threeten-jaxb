package io.github.threetenjaxb.extra;

import org.threeten.extra.Minutes;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Minutes}.
 *
 * <p>This {@link XmlAdapter} binds {@link Minutes} to its ISO-8601 string
 * representation. The format is {@code PTnM} where {@code n} is the number of
 * minutes.
 *
 * @see Minutes#toString()
 */
public class MinutesXmlAdapter extends XmlAdapter<String, Minutes> {
    @Override
    public Minutes unmarshal(String text) {
        return text != null ? Minutes.parse(text) : null;
    }

    @Override
    public String marshal(Minutes minutes) {
        return minutes != null ? minutes.toString() : null;
    }
}

package io.github.threetenjaxb.extra;

import org.threeten.extra.Weeks;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Weeks}.
 *
 * <p>This {@link XmlAdapter} binds {@link Weeks} to its ISO-8601 string
 * representation. The format is {@code PnW} where {@code n} is the number of
 * weeks.
 *
 * @see Weeks#toString()
 */
public class WeeksXmlAdapter extends XmlAdapter<String, Weeks> {
    @Override
    public Weeks unmarshal(String text) {
        return text != null ? Weeks.parse(text) : null;
    }

    @Override
    public String marshal(Weeks weeks) {
        return weeks != null ? weeks.toString() : null;
    }
}

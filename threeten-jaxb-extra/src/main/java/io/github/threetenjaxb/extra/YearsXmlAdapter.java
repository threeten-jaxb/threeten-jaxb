package io.github.threetenjaxb.extra;

import org.threeten.extra.Years;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Years}.
 *
 * <p>This {@link XmlAdapter} binds {@link Years} to its ISO-8601 string
 * representation. The format is {@code PnY} where {@code n} is the number of
 * years.
 *
 * @see Years#toString()
 */
public class YearsXmlAdapter extends XmlAdapter<String, Years> {
    @Override
    public Years unmarshal(String text) {
        return text != null ? Years.parse(text) : null;
    }

    @Override
    public String marshal(Years years) {
        return years != null ? years.toString() : null;
    }
}

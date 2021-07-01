package io.github.threetenjaxb.extra;

import org.threeten.extra.Days;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Days}.
 *
 * <p>This {@link XmlAdapter} binds {@link Days} to its ISO-8601 string
 * representation. The format is {@code PnD} where {@code n} is the number of
 * days.
 *
 * @see Days#toString()
 */
public class DaysXmlAdapter extends XmlAdapter<String, Days> {
    @Override
    public Days unmarshal(String text) {
        return text != null ? Days.parse(text) : null;
    }

    @Override
    public String marshal(Days days) {
        return days != null ? days.toString() : null;
    }
}

package io.github.threetenjaxb.extra;

import org.threeten.extra.Months;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link Months}.
 *
 * <p>This {@link XmlAdapter} binds {@link Months} to its ISO-8601 string
 * representation. The format is {@code PnM} where {@code n} is the number of
 * months.
 *
 * @see Months#toString()
 */
public class MonthsXmlAdapter extends XmlAdapter<String, Months> {
    @Override
    public Months unmarshal(String text) {
        return text != null ? Months.parse(text) : null;
    }

    @Override
    public String marshal(Months months) {
        return months != null ? months.toString() : null;
    }
}

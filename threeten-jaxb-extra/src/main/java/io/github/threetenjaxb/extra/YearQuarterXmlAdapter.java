package io.github.threetenjaxb.extra;

import org.threeten.extra.YearQuarter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link YearQuarter}.
 *
 * <p>This {@link XmlAdapter} binds {@link YearQuarter} to its ISO-8601 string
 * representation, such as {@code 2007-Q2}. The format is {@code uuuu-'Q'Q}.
 *
 * @see YearQuarter#toString()
 */
public class YearQuarterXmlAdapter extends XmlAdapter<String, YearQuarter> {
    @Override
    public YearQuarter unmarshal(String text) {
        return text != null ? YearQuarter.parse(text) : null;
    }

    @Override
    public String marshal(YearQuarter yearQuarter) {
        return yearQuarter != null ? yearQuarter.toString() : null;
    }
}

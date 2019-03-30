package io.github.threetenjaxb.extra;

import org.threeten.extra.PeriodDuration;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@link XmlAdapter} for {@link PeriodDuration}.
 *
 * <p>This {@link XmlAdapter} binds {@link PeriodDuration} to its ISO-8601 string
 * representation. The format is {@code PnYnMnDTnHnMnS}, with sections omitted as
 * necessary. An empty amount will be bound {@code PT0S}.
 *
 * @see PeriodDuration#toString()
 */
public class PeriodDurationXmlAdapter extends XmlAdapter<String, PeriodDuration> {
    @Override
    public PeriodDuration unmarshal(String text) {
        return text != null ? PeriodDuration.parse(text) : null;
    }

    @Override
    public String marshal(PeriodDuration periodDuration) {
        return periodDuration != null ? periodDuration.toString() : null;
    }
}

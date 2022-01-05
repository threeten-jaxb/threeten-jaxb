package io.github.threetenjaxb.extra;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.threeten.extra.DayOfMonth;

/**
 * {@link XmlAdapter} for {@link DayOfMonth}
 *
 * <p>This {@link XmlAdapter} binds {@link DayOfMonth} to its day-of-month
 * value.
 * <p>
 * This adapter is suitable for {@code xsd:gDay} types.
 */
public class DayOfMonthAsTextXmlAdapter extends XmlAdapter<String, DayOfMonth> {
    @Override
    public DayOfMonth unmarshal(String text) {
        return text != null ? DayOfMonth.of(Integer.parseInt(text)) : null;
    }

    @Override
    public String marshal(DayOfMonth dayOfMonth) {
        return dayOfMonth != null ? Integer.toString(dayOfMonth.getValue()) : null;
    }
}

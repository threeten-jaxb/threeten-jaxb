package io.github.threetenjaxb.core;

import java.time.MonthDay;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code MonthDay} to a string such as --12-03
 * <p>
 * String format details:
 * <ul>
 * <li>{@link java.time.MonthDay#parse(java.lang.CharSequence)}</li>
 * <li>{@link java.time.MonthDay#toString()}</li>
 * </ul>
 * <p>
 * This adapter is suitable for {@code xsd:gMonthDay} types.
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.MonthDay
 */
public class MonthDayXmlAdapter extends XmlAdapter<String, MonthDay> {
    @Override
    public MonthDay unmarshal(String stringValue) {
        return stringValue != null ? MonthDay.parse(stringValue) : null;
    }

    @Override
    public String marshal(MonthDay value) {
        return value != null ? value.toString() : null;
    }
}

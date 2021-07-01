package io.github.threetenjaxb.core;

import java.time.Period;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Period} to ISO-8601 string
 * <p>
 * String format details:
 * <ul>
 * <li>{@link java.time.Period#parse(java.lang.CharSequence)}</li>
 * <li>{@link java.time.Period#toString()}</li>
 * </ul>
 *
 * @see jakarta.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Period
 */
public class PeriodXmlAdapter extends XmlAdapter<String, Period> {
    @Override
    public Period unmarshal(String stringValue) {
        return stringValue != null ? Period.parse(stringValue) : null;
    }

    @Override
    public String marshal(Period value) {
        return value != null ? value.toString() : null;
    }
}

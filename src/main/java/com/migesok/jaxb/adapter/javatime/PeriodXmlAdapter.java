package com.migesok.jaxb.adapter.javatime;

import java.time.Period;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Period} to ISO-8601 string
 * <p>
 * String format details:
 * <ul>
 * <li>{@link java.time.Period#parse(java.lang.CharSequence)}</li>
 * <li>{@link java.time.Period#toString()}</li>
 * </ul>
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
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

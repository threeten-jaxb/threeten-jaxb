package com.migesok.jaxb.adapter.javatime;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Period;

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
    public Period unmarshal(String stringValue) throws Exception {
        return stringValue != null ? Period.parse(stringValue) : null;
    }

    @Override
    public String marshal(Period value) throws Exception {
        return value != null ? value.toString() : null;
    }
}

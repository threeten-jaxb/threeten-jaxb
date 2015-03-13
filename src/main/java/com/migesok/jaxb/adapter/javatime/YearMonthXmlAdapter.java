package com.migesok.jaxb.adapter.javatime;

import java.time.YearMonth;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code YearMonth} to a string such as 2007-12
 * <p>
 * String format details:
 * <ul>
 * <li>{@link java.time.YearMonth#parse(java.lang.CharSequence)}</li>
 * <li>{@link java.time.YearMonth#toString()}</li>
 * </ul>
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.YearMonth
 */
public class YearMonthXmlAdapter extends XmlAdapter<String, YearMonth> {
    @Override
    public YearMonth unmarshal(String stringValue) {
        return stringValue != null ? YearMonth.parse(stringValue) : null;
    }

    @Override
    public String marshal(YearMonth value) {
        return value != null ? value.toString() : null;
    }
}

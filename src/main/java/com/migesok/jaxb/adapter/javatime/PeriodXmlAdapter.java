package com.migesok.jaxb.adapter.javatime;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Period;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.Period Period} to ISO-8601 string
 * <p/>
 * String format details:<br/>
 * {@link java.time.Period#parse(java.lang.CharSequence)}<br/>
 * {@link java.time.Period#toString()}
 *
 * @author Mikhail Sokolov
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

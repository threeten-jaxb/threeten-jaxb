package com.migesok.jaxb.adapter.javatime;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Duration;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310
 * {@link java.time.Duration Duration} to ISO-8601 string
 * <p>
 * String format details:<br>
 * {@link java.time.Duration#parse(java.lang.CharSequence)}<br>
 * {@link java.time.Duration#toString()}
 */
public class DurationXmlAdapter extends XmlAdapter<String, Duration> {
    @Override
    public Duration unmarshal(String stringValue) {
        return stringValue != null ? Duration.parse(stringValue) : null;
    }

    @Override
    public String marshal(Duration value) {
        return value != null ? value.toString() : null;
    }
}

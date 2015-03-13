package com.migesok.jaxb.adapter.javatime;

import java.time.ZoneId;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code ZoneId} and {@code ZoneOffset} to the time-zone ID string
 * <p>
 * Time-zone ID format details:
 * <ul>
 * <li>{@link java.time.ZoneId#of(java.lang.String)}</li>
 * <li>{@link java.time.ZoneId#getId()}</li>
 * </ul>
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.ZoneId
 * @see java.time.ZoneOffset
 */
public class ZoneIdXmlAdapter extends XmlAdapter<String, ZoneId> {
    @Override
    public ZoneId unmarshal(String stringValue) {
        return stringValue != null ? ZoneId.of(stringValue) : null;
    }

    @Override
    public String marshal(ZoneId value) {
        return value != null ? value.getId() : null;
    }
}

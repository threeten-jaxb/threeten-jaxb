package com.migesok.jaxb.adapter.javatime;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Instant} to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_INSTANT}
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Instant
 */
public class InstantXmlAdapter extends TemporalAccessorXmlAdapter<Instant> {
    public InstantXmlAdapter() {
        super(DateTimeFormatter.ISO_INSTANT, Instant::from);
    }
}

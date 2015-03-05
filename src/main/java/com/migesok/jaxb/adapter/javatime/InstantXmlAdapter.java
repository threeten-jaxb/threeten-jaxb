package com.migesok.jaxb.adapter.javatime;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * {@link javax.xml.bind.annotation.adapters.XmlAdapter XmlAdapter} mapping JSR-310 {@link java.time.Instant Instant}
 * to ISO-8601 string
 * <p>
 * String format details: {@link java.time.format.DateTimeFormatter#ISO_INSTANT ISO_INSTANT}
 */
public class InstantXmlAdapter extends TemporalAccessorXmlAdapter<Instant> {
    public InstantXmlAdapter() {
        super(DateTimeFormatter.ISO_INSTANT, Instant::from);
    }
}

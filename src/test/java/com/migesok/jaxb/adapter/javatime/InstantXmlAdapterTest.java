package com.migesok.jaxb.adapter.javatime;

import java.time.Instant;

public class InstantXmlAdapterTest extends AbstractToStringAdapterTest<Instant, InstantXmlAdapter> {
    public InstantXmlAdapterTest() {
        super(InstantXmlAdapter.class);
    }

    @Override
    protected Instant getNotNullValue() {
        return Instant.parse("2007-12-03T10:15:30.00Z");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

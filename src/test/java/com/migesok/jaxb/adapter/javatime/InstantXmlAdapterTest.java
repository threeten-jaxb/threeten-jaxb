package com.migesok.jaxb.adapter.javatime;

import java.time.Instant;

class InstantXmlAdapterTest extends AbstractToStringAdapterTest<Instant, InstantXmlAdapter> {
    InstantXmlAdapterTest() {
        super(InstantXmlAdapter.class);
    }

    @Override
    Instant getNotNullValue() {
        return Instant.parse("2007-12-03T10:15:30.00Z");
    }
}

package com.migesok.jaxb.adapter.javatime;

import java.time.Duration;

class DurationXmlAdapterTest extends AbstractToStringAdapterTest<Duration, DurationXmlAdapter> {
    DurationXmlAdapterTest() {
        super(DurationXmlAdapter.class);
    }

    @Override
    Duration getNotNullValue() {
        return Duration.parse("P2DT3H4M");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

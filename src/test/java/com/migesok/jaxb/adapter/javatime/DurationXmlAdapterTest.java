package com.migesok.jaxb.adapter.javatime;

import java.time.Duration;

public class DurationXmlAdapterTest extends AbstractToStringAdapterTest<Duration, DurationXmlAdapter> {
    public DurationXmlAdapterTest() {
        super(DurationXmlAdapter.class);
    }

    @Override
    protected Duration getNotNullValue() {
        return Duration.parse("P2DT3H4M");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

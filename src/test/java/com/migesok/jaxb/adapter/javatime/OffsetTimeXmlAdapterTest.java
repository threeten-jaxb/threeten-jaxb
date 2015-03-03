package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetTime;

public class OffsetTimeXmlAdapterTest extends AbstractToStringAdapterTest<OffsetTime, OffsetTimeXmlAdapter> {
    public OffsetTimeXmlAdapterTest() {
        super(OffsetTimeXmlAdapter.class);
    }

    @Override
    protected OffsetTime getNotNullValue() {
        return OffsetTime.parse("10:15:30+01:00");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

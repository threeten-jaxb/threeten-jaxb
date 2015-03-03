package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetDateTime;

public class OffsetDateTimeXmlAdapterTest
        extends AbstractToStringAdapterTest<OffsetDateTime, OffsetDateTimeXmlAdapter> {

    public OffsetDateTimeXmlAdapterTest() {
        super(OffsetDateTimeXmlAdapter.class);
    }

    @Override
    protected OffsetDateTime getNotNullValue() {
        return OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

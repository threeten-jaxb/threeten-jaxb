package com.migesok.jaxb.adapter.javatime;

import java.time.ZonedDateTime;

public class ZonedDateTimeXmlAdapterTest extends AbstractToStringAdapterTest<ZonedDateTime, ZonedDateTimeXmlAdapter> {
    public ZonedDateTimeXmlAdapterTest() {
        super(ZonedDateTimeXmlAdapter.class);
    }

    @Override
    protected ZonedDateTime getNotNullValue() {
        return ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

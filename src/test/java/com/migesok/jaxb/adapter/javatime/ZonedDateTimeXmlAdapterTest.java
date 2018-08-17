package com.migesok.jaxb.adapter.javatime;

import java.time.ZonedDateTime;

class ZonedDateTimeXmlAdapterTest extends AbstractToStringAdapterTest<ZonedDateTime, ZonedDateTimeXmlAdapter> {
    ZonedDateTimeXmlAdapterTest() {
        super(ZonedDateTimeXmlAdapter.class);
    }

    @Override
    ZonedDateTime getNotNullValue() {
        return ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

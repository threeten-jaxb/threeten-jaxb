package com.migesok.jaxb.adapter.javatime;

import java.time.OffsetTime;

class OffsetTimeXmlAdapterTest extends AbstractToStringAdapterTest<OffsetTime, OffsetTimeXmlAdapter> {
    OffsetTimeXmlAdapterTest() {
        super(OffsetTimeXmlAdapter.class);
    }

    @Override
    OffsetTime getNotNullValue() {
        return OffsetTime.parse("10:15:30+01:00");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

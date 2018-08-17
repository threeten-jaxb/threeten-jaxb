package com.migesok.jaxb.adapter.javatime;

import java.time.LocalTime;

class LocalTimeXmlAdapterTest extends AbstractToStringAdapterTest<LocalTime, LocalTimeXmlAdapter> {
    LocalTimeXmlAdapterTest() {
        super(LocalTimeXmlAdapter.class);
    }

    @Override
    LocalTime getNotNullValue() {
        return LocalTime.parse("10:15:30");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDateTime;

class LocalDateTimeXmlAdapterTest extends AbstractToStringAdapterTest<LocalDateTime, LocalDateTimeXmlAdapter> {

    LocalDateTimeXmlAdapterTest() {
        super(LocalDateTimeXmlAdapter.class);
    }

    @Override
    LocalDateTime getNotNullValue() {
        return LocalDateTime.parse("2007-12-03T10:15:30");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

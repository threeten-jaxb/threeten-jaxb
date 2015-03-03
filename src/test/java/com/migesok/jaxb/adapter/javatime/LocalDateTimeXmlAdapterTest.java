package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDateTime;

public class LocalDateTimeXmlAdapterTest extends AbstractToStringAdapterTest<LocalDateTime, LocalDateTimeXmlAdapter> {

    public LocalDateTimeXmlAdapterTest() {
        super(LocalDateTimeXmlAdapter.class);
    }

    @Override
    protected LocalDateTime getNotNullValue() {
        return LocalDateTime.parse("2007-12-03T10:15:30");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

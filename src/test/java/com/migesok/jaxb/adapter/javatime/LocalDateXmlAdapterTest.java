package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDate;

public class LocalDateXmlAdapterTest extends AbstractToStringAdapterTest<LocalDate, LocalDateXmlAdapter> {
    public LocalDateXmlAdapterTest() {
        super(LocalDateXmlAdapter.class);
    }

    @Override
    protected LocalDate getNotNullValue() {
        return LocalDate.of(2014, 12, 31);
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

package com.migesok.jaxb.adapter.javatime;

import java.time.LocalDate;

class LocalDateXmlAdapterTest extends AbstractToStringAdapterTest<LocalDate, LocalDateXmlAdapter> {
    LocalDateXmlAdapterTest() {
        super(LocalDateXmlAdapter.class);
    }

    @Override
    LocalDate getNotNullValue() {
        return LocalDate.of(2014, 12, 31);
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

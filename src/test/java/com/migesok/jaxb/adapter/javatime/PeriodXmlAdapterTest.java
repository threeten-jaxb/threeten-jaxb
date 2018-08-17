package com.migesok.jaxb.adapter.javatime;

import java.time.Period;

class PeriodXmlAdapterTest extends AbstractToStringAdapterTest<Period, PeriodXmlAdapter> {
    PeriodXmlAdapterTest() {
        super(PeriodXmlAdapter.class);
    }

    @Override
    Period getNotNullValue() {
        return Period.parse("P1Y2M3W4D");
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

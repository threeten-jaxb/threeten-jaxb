package com.migesok.jaxb.adapter.javatime;

import java.time.Period;

public class PeriodXmlAdapterTest extends AbstractToStringAdapterTest<Period, PeriodXmlAdapter> {
    public PeriodXmlAdapterTest() {
        super(PeriodXmlAdapter.class);
    }

    @Override
    protected Period getNotNullValue() {
        return Period.parse("P1Y2M3W4D");
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

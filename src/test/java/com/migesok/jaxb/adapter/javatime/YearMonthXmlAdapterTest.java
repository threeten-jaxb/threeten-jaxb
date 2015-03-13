package com.migesok.jaxb.adapter.javatime;

import java.time.YearMonth;

public class YearMonthXmlAdapterTest extends AbstractToStringAdapterTest<YearMonth, YearMonthXmlAdapter> {
    public YearMonthXmlAdapterTest() {
        super(YearMonthXmlAdapter.class);
    }

    @Override
    protected YearMonth getNotNullValue() {
        return YearMonth.of(2014, 12);
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

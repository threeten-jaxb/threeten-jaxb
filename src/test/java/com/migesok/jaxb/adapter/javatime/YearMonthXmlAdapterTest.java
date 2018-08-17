package com.migesok.jaxb.adapter.javatime;

import java.time.YearMonth;

class YearMonthXmlAdapterTest extends AbstractToStringAdapterTest<YearMonth, YearMonthXmlAdapter> {
    YearMonthXmlAdapterTest() {
        super(YearMonthXmlAdapter.class);
    }

    @Override
    YearMonth getNotNullValue() {
        return YearMonth.of(2014, 12);
    }
}

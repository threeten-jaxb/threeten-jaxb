package com.migesok.jaxb.adapter.javatime;

import java.time.MonthDay;

class MonthDayXmlAdapterTest extends AbstractToStringAdapterTest<MonthDay, MonthDayXmlAdapter> {
    MonthDayXmlAdapterTest() {
        super(MonthDayXmlAdapter.class);
    }

    @Override
    MonthDay getNotNullValue() {
        return MonthDay.of(12, 31);
    }

    @Override
    String getNotValidStringValue() {
        return "blah-blah";
    }
}

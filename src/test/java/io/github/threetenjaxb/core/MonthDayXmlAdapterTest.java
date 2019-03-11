package io.github.threetenjaxb.core;

import java.time.MonthDay;

public class MonthDayXmlAdapterTest extends AbstractToStringAdapterTest<MonthDay, MonthDayXmlAdapter> {
    public MonthDayXmlAdapterTest() {
        super(MonthDayXmlAdapter.class);
    }

    @Override
    protected MonthDay getNotNullValue() {
        return MonthDay.of(12, 31);
    }

    @Override
    protected String getNotValidStringValue() {
        return "blah-blah";
    }
}

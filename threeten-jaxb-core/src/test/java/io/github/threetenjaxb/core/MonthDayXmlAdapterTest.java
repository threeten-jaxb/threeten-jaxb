package io.github.threetenjaxb.core;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

class MonthDayXmlAdapterTest extends AbstractXmlAdapterTest<String, MonthDay, MonthDayXmlAdapter> {

    private static final Map<String, MonthDay> STRING_MONTH_DAY_MAP = new HashMap<>();

    static {
        STRING_MONTH_DAY_MAP.put("--12-03", MonthDay.of(Month.DECEMBER, 3));
    }

    MonthDayXmlAdapterTest() {
        super(new MonthDayXmlAdapter(), STRING_MONTH_DAY_MAP);
    }
}

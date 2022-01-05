package io.github.threetenjaxb.core;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

class MonthXmlAdapterTest extends AbstractXmlAdapterTest<Integer, Month, MonthXmlAdapter> {

    private static final Map<Integer, Month> INTEGER_MONTH_MAP = new HashMap<>();

    static {
        INTEGER_MONTH_MAP.put(1, Month.of(1));
    }

    MonthXmlAdapterTest() {
        super(new MonthXmlAdapter(), INTEGER_MONTH_MAP);
    }
}

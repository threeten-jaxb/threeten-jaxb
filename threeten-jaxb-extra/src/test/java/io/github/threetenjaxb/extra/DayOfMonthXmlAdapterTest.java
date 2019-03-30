package io.github.threetenjaxb.extra;

import org.threeten.extra.DayOfMonth;

import java.util.HashMap;
import java.util.Map;

class DayOfMonthXmlAdapterTest extends AbstractXmlAdapterTest<Integer, DayOfMonth, DayOfMonthXmlAdapter> {

    private static final Map<Integer, DayOfMonth> STRING_DAY_OF_MONTH_MAP = new HashMap<>();

    static {
        STRING_DAY_OF_MONTH_MAP.put(21, DayOfMonth.of(21));
    }

    DayOfMonthXmlAdapterTest() {
        super(new DayOfMonthXmlAdapter(), STRING_DAY_OF_MONTH_MAP);
    }
}

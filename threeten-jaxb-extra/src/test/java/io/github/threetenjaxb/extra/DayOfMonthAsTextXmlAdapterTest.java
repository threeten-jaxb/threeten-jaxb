package io.github.threetenjaxb.extra;

import org.threeten.extra.DayOfMonth;

import java.util.HashMap;
import java.util.Map;

class DayOfMonthAsTextXmlAdapterTest extends AbstractXmlAdapterTest<String, DayOfMonth, DayOfMonthAsTextXmlAdapter> {

    private static final Map<String, DayOfMonth> STRING_DAY_OF_MONTH_MAP = new HashMap<>();

    static {
        STRING_DAY_OF_MONTH_MAP.put("21", DayOfMonth.of(21));
    }

    DayOfMonthAsTextXmlAdapterTest() {
        super(new DayOfMonthAsTextXmlAdapter(), STRING_DAY_OF_MONTH_MAP);
    }
}
